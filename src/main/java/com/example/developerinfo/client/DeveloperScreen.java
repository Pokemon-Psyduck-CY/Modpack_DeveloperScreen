package com.example.developerinfo.client;

import com.example.developerinfo.DeveloperInfoMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Label;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.List;

public class DeveloperScreen extends Screen {
    private final Screen parent;
    private List<String> developers;

    public DeveloperScreen(Screen parent) {
        super(Component.literal("Mod Developers"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        developers = DeveloperInfoMod.getDevelopers();
        int startY = height / 4;
        for (int i = 0; i < developers.size(); i++) {
            String name = developers.get(i);
            this.addRenderableWidget(
                    new Label(this.font, Component.literal(name), width / 2 - 100, startY + i * 12, 0xFFFFFF));
        }
        // “返回”按钮
        this.addRenderableWidget(new Button(
                width / 2 - 100, height - 30, 200, 20,
                Component.literal("Back"), b -> this.minecraft.setScreen(parent)));
    }

    @Override
    public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
    }
}