package com.hoborific.dyeablechickens.client;

import com.hoborific.dyeablechickens.common.ProxyCommon;
import com.hoborific.dyeablechickens.common.entity.EntityDyeableChicken;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by hobo on 2/5/2017.
 */
public class ProxyClient extends ProxyCommon {
    public void preInit() {

        super.preInit();
        RenderingRegistry.registerEntityRenderingHandler(EntityDyeableChicken.class, RenderDyeableChicken::new);
    }

    public void init() {

        //RenderingRegistry.registerEntityRenderingHandler(EntityDyeableChicken.class, new RenderDyeableChicken(Minecraft.getMinecraft().getRenderManager()));
        super.init();
    }

    public void postInit() {
        super.postInit();
    }
}