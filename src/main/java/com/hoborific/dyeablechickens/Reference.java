package com.hoborific.dyeablechickens;

public class Reference {

    public static final String modId = DyeableChickens.MODID;

    public enum MobJarItems {
        JAR("jar","ItemJar");

        private String unlocalizedName;
        private String registryName;

        MobJarItems(String unlocalizedName, String registryName){
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName(){
            return unlocalizedName;
        }

        public String getRegistryName(){
            return registryName;
        }
    }
    public enum MobJarBlocks {
        JAR("jar","blockjar");

        private String unlocalizedName;
        private String registryName;

        MobJarBlocks(String unlocalizedName, String registryName){
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName(){
            return unlocalizedName;
        }

        public String getRegistryName(){
            return registryName;
        }
    }
}
