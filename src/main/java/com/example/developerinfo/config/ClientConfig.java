// src/main/java/com/example/developerinfo/config/ClientConfig.java
package com.example.developerinfo.config;

import net.minecraftforge.common.ForgeConfigSpec;
import java.util.Arrays;

public class ClientConfig {
    public final ForgeConfigSpec.ConfigValue<java.util.List<? extends String>> developers;

    public ClientConfig(ForgeConfigSpec.Builder builder) {
        builder.push("DeveloperInfo Settings");
        developers = builder
            .comment("在这里填写需要展示的开发者/整合包作者名单")
            .defineList("developers", Arrays.asList("YourName"), o -> o instanceof String);
        builder.pop();
    }
}
 
                     
                 