package com.hoborific.hobomod.common.entity;

import com.google.common.collect.Maps;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.oredict.DyeUtils;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;

import static net.minecraft.entity.passive.EntitySheep.getRandomSheepColor;

public class EntityDyeableChicken extends EntityChicken{
    public EntityDyeableChicken(World worldIn){
        super(worldIn);
    }
    private static final DataParameter<Byte> DYE_COLOR = EntityDataManager.createKey(EntityDyeableChicken.class, DataSerializers.BYTE);

    public boolean processInteract(EntityPlayer player, EnumHand hand){
        EntityPlayer p = player;
        ItemStack itemstack = p.getHeldItem(hand);
        Optional<EnumDyeColor> color = DyeUtils.colorFromStack(itemstack);
        if(color.isPresent()) {
            this.setFeatherColor(color.get());
            itemstack.shrink(1);
            p.swingArm(hand);
            return true;
        }
        return super.processInteract(player, hand);
    }

    public EnumDyeColor getFeatherColor()
    {
        return EnumDyeColor.byMetadata(this.dataManager.get(DYE_COLOR) & 15);
    }

    private final InventoryCrafting inventoryCrafting = new InventoryCrafting(new Container() {
        /**
         * Determines whether supplied player can use this container
         */
        public boolean canInteractWith(EntityPlayer playerIn)
        {
            return false;
        }
    }, 2, 1);

    private EnumDyeColor getDyeColorMixFromParents(EntityAnimal father, EntityAnimal mother) {
        EnumDyeColor i = ((EntityDyeableChicken) father).getFeatherColor();
        EnumDyeColor j = ((EntityDyeableChicken) mother).getFeatherColor();
        this.inventoryCrafting.setInventorySlotContents(0, new ItemStack(Items.DYE, 1, i.getDyeDamage()));
        this.inventoryCrafting.setInventorySlotContents(1, new ItemStack(Items.DYE, 1, j.getDyeDamage()));
        ItemStack result = CraftingManager.findMatchingResult(this.inventoryCrafting, ((EntityDyeableChicken) father).world);

        if (result.getItem() == Items.DYE) {
            return EnumDyeColor.byDyeDamage(result.getMetadata());
        } else {
            return this.world.rand.nextBoolean() ? i : j;
        }
    }

    @Override
    public EntityDyeableChicken createChild(EntityAgeable other) {
        EntityDyeableChicken child = new EntityDyeableChicken(this.world);
        child.setFeatherColor(getDyeColorMixFromParents(this, (EntityDyeableChicken) other));
        return child;
    }

    public void setFeatherColor(EnumDyeColor color)
    {
        byte b0 = this.dataManager.get(DYE_COLOR);
        this.dataManager.set(DYE_COLOR, (byte) (b0 & 240 | color.getMetadata() & 15));
    }
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(DYE_COLOR, (byte) 0);
    }

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setFeatherColor(EnumDyeColor.byDyeDamage(this.world.rand.nextInt(16)));
        return livingdata;
    }
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setByte("Color", (byte)this.getFeatherColor().getMetadata());
    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setFeatherColor(EnumDyeColor.byMetadata(compound.getByte("Color")));
    }
}


