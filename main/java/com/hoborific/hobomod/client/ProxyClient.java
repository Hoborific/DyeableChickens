package com.hoborific.hobomod.client;

import com.hoborific.hobomod.common.ProxyCommon;
import com.hoborific.hobomod.common.entity.EntityDyeableChicken;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by hobo on 2/5/2017.
 */
public class ProxyClient extends ProxyCommon {
    public void preInit() {

        super.preInit();
    }

    public void init() {

        RenderingRegistry.registerEntityRenderingHandler(EntityDyeableChicken.class, new RenderDyeableChicken(Minecraft.getMinecraft().getRenderManager()));
        super.init();
    }

    public void postInit() {
        super.postInit();
    }
}