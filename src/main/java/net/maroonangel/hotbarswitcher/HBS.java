package net.maroonangel.hotbarswitcher;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;

public class HBS {
    public static KeyMapping switchKey = createKeyBinding(
            ResourceLocation.fromNamespaceAndPath("hotbarswitcher", "swap"),
            InputConstants.Type.KEYSYM,
            82,
            KeyMapping.Category.INVENTORY);

    public void init() {}

    private static KeyMapping createKeyBinding(
            ResourceLocation id, InputConstants.Type type, int code, KeyMapping.Category category) {
        return KeyBindingHelper.registerKeyBinding(
                new KeyMapping("key." + id.getNamespace() + "." + id.getPath(), type, code, category));
    }
}
