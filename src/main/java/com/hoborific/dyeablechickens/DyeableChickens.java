package com.hoborific.dyeablechickens;


import com.hoborific.dyeablechickens.common.ProxyCommon;
import com.hoborific.dyeablechickens.init.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DyeableChickens.MODID, version = DyeableChickens.VERSION)
public class DyeableChickens
{
    public static final String MODID = "dyeablechickens";
    public static final String VERSION = "1.2";

    @Mod.Instance(MODID)
    public static DyeableChickens instance;

    @SidedProxy(clientSide = "com.hoborific.dyeablechickens.client.ProxyClient", serverSide = "com.hoborific.dyeablechickens.ProxySerb")
    public static ProxyCommon proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("PRINT");
        System.out.println("PRINT");
        System.out.println("PRINT");
        System.out.println("PRINT");System.out.println("PRINT");
        System.out.println("PRINT");

        ModBlocks.init();
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
