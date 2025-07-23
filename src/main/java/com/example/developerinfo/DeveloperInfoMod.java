package com.example.developerinfo;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(DeveloperInfoMod.MODID)
public class DeveloperInfoMod {
    public static final String MODID = "developerinfo";

    // Forge 配置对象
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final ClientConfig CLIENT;
    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        CLIENT = new ClientConfig(builder);
        CLIENT_SPEC = builder.build();
    }

    public DeveloperInfoMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC);
    }

    /** 供界面调用，获取开发者名单 */
    public static java.util.List<String> getDevelopers() {
        return CLIENT.developers.get();
    }
}
