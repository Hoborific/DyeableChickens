package com.hoborific.hobomod.client;

import com.hoborific.hobomod.common.ProxyCommon;
import com.hoborific.hobomod.common.entity.EntityDyeableChicken;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntitySheep;
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
        super.init();
    }

    public void postInit() {
        super.postInit();
    }
}