package com.hoborific.hobomod.common.event;

import com.hoborific.hobomod.common.entity.EntityDyeableChicken;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Created by hobo on 3/8/2017.
 */

public class EventLiving {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        World world = event.getWorld();
        Entity entity = event.getEntity();
        if (entity instanceof EntityChicken && !(entity instanceof EntityDyeableChicken)) {
            EntityDyeableChicken newChicken = new EntityDyeableChicken(world);
            if (!world.isRemote) {
                newChicken.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, 0, 0);
                if(((EntityChicken) entity).isChild()){
                    newChicken.setGrowingAge(((EntityChicken) entity).getGrowingAge());
                }
                // You might want to consider spawning rare pre-colored chicken here
                //world.spawnEntityInWorld(newChicken);
                world.spawnEntity(newChicken);
            }
            newChicken.playLivingSound();
            entity.setDead();

        }
    }

}
