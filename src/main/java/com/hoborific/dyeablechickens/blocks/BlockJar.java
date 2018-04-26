package com.hoborific.dyeablechickens.blocks;

import com.hoborific.dyeablechickens.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.modId)
public class BlockJar extends Block{

    public BlockJar(){
        super(Material.GLASS);
        setSoundType(SoundType.GLASS);
        setHardness(0.3f);
        setUnlocalizedName(Reference.MobJarBlocks.JAR.getUnlocalizedName());
        setRegistryName(Reference.MobJarBlocks.JAR.getRegistryName());

    }
    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(final IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(final IBlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isTopSolid(final IBlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        return true;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT; //cutout?
    }


    @SubscribeEvent

    public static void EntityInteractEvent(PlayerInteractEvent.EntityInteract event){
        // client side
        if (event.getWorld().isRemote && event.getHand().equals(EnumHand.MAIN_HAND)) {
            System.out.println("Shwing");
        }
        // server side
        else if (event.getHand().equals(EnumHand.MAIN_HAND)) {
            System.out.println(event.getTarget().getName());
            event.getEntityPlayer().swingArm(EnumHand.MAIN_HAND);
        }
    }
}
