package com.hoborific.hobomod.client;

import com.hoborific.hobomod.HoboMod;
import com.hoborific.hobomod.common.entity.EntityDyeableChicken;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderDyeableChicken extends RenderLiving<EntityDyeableChicken> {
    private static final ResourceLocation CHICKEN_TEXTURES =   new ResourceLocation(HoboMod.MODID+":textures/entity/dyeablechicken/chicken_base.png");//new ResourceLocation("textures/entity/chicken.png");
    public static final ResourceLocation CHICKEN_COAT_TEXTURES = new ResourceLocation(HoboMod.MODID+":textures/entity/dyeablechicken/chicken_coat.png"); //
    public RenderDyeableChicken(RenderManager renderManagerIn){
        super(renderManagerIn, new ModelChicken(), 0.3F); //renderManagerIn =p_i47211_1_
        this.addLayer(new LayerDyeableChickenFeathers(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDyeableChicken entity) {
        return CHICKEN_TEXTURES;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */


    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityDyeableChicken livingBase, float partialTicks) {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
    @Override
    public void doRender(EntityDyeableChicken entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);

    }
    protected void preRenderCallback(EntityDyeableChicken entity, float f)
    {
        preRenderDyeableChicken(entity,f);
    }
    protected void preRenderDyeableChicken(EntityDyeableChicken entity, float f){

    }
}
