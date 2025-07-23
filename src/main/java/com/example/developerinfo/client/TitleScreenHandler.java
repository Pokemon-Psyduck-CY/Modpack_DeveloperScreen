package com.example.developerinfo.client;

import com.example.developerinfo.DeveloperInfoMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeveloperInfoMod.MODID, value = Dist.CLIENT)
public class TitleScreenHandler {
    @SubscribeEvent
    public static void onTitleScreenInit(ScreenEvent.Init.Post event) {
        if (!(event.getScreen() instanceof TitleScreen screen))
            return;

        // 移除原退出按钮 (文本使用默认的翻译 key)
        event.getListeners().removeIf(w -> w instanceof Button b &&
                b.getMessage().getString().equals(Component.translatable("menu.quit").getString()));

        // 在同一位置添加“Developers”按钮
        int x = screen.width / 2 + 104;
        int y = screen.height / 4 + 48 + 24;
        event.addListener(new Button(x, y, 98, 20, Component.literal("Developers"),
                btn -> Minecraft.getInstance().setScreen(new DeveloperScreen(screen))));
    }
}