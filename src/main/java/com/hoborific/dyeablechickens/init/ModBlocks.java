package com.hoborific.dyeablechickens.init;

import com.hoborific.dyeablechickens.DyeableChickens;
import com.hoborific.dyeablechickens.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = DyeableChickens.MODID)
public class ModBlocks {

    public static Block JAR = new BlockJar();

    public static void init(){
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(JAR);
        //event.getRegistry().registerAll(block1, block2, ...);
    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        final ItemBlock[] items = {
                new ItemBlock(JAR),
        };

        for (final ItemBlock item : items) {
            final Block block = item.getBlock();
            final ResourceLocation registryName = block.getRegistryName();
            registry.register(item.setRegistryName(registryName));
        }
    }

    public static void registerRenders(){
        registerRender(JAR);

    }

    public static void registerRender(Block block){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block),
                0,new ModelResourceLocation(block.getRegistryName(),"Inventory"));


    }
}
