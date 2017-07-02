package com.hoborific.hobomod;


import com.hoborific.hobomod.common.ProxyCommon;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HoboMod.MODID, version = HoboMod.VERSION)
public class HoboMod
{
    public static final String MODID = "hobomod";
    public static final String VERSION = "1.2";

    @Mod.Instance(MODID)
    public static HoboMod instance;

    @SidedProxy(clientSide = "com.hoborific.hobomod.client.ProxyClient", serverSide = "com.hoborific.hobomod.ProxySerb")
    public static ProxyCommon proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
        // some example code
        instance = this;
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }



}
