package com.hoborific.dyeablechickens.client;

import com.hoborific.dyeablechickens.common.entity.EntityDyeableChicken;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/**
 * Created by Hobo on 2/07/2017.
 */
public class LayerDyeableChickenFeathers implements LayerRenderer<EntityDyeableChicken> {
    private final RenderDyeableChicken dyeableChickenRenderer;
    private final ModelChicken chickenModel = new ModelChicken();
    LayerDyeableChickenFeathers(RenderDyeableChicken dyeableChickenIn)
    {
        this.dyeableChickenRenderer = dyeableChickenIn;
    }

    @Override
    public void doRenderLayer(EntityDyeableChicken entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.dyeableChickenRenderer.bindTexture(dyeableChickenRenderer.CHICKEN_COAT_TEXTURES);
        this.chickenModel.setModelAttributes(this.dyeableChickenRenderer.getMainModel());
        float[] afloat = EntityDyeableChicken.getDyeRgb(entitylivingbaseIn.getFeatherColor());
        GlStateManager.enableColorMaterial();
        GlStateManager.color(afloat[0], afloat[1], afloat[2]);
        this.chickenModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
