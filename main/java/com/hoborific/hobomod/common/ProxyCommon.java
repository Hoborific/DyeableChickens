package com.hoborific.hobomod.common;

import com.hoborific.hobomod.HoboMod;
import com.hoborific.hobomod.common.entity.EntityDyeableChicken;
import com.hoborific.hobomod.common.event.EventLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by hobo on 2/5/2017.
 */
public class ProxyCommon {
    public void preInit() {

    }

    public void init() {
        EntityRegistry.registerModEntity(new ResourceLocation("textures/entity/chicken.png"),EntityDyeableChicken.class,"EntityDyeableChicken",133,HoboMod.instance,64,3,true,1,1);
        MinecraftForge.EVENT_BUS.register(new EventLiving());
    }

    public void postInit() {

    }
}