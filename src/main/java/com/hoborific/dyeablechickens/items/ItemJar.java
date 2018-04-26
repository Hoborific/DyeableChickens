package com.hoborific.dyeablechickens.items;

import com.hoborific.dyeablechickens.Reference;
import net.minecraft.item.Item;

public class ItemJar extends Item {

    public ItemJar(){
        setUnlocalizedName(Reference.MobJarItems.JAR.getUnlocalizedName());
        setRegistryName(Reference.MobJarItems.JAR.getRegistryName());
    }
}
