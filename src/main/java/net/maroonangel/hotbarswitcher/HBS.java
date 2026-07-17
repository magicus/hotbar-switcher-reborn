package net.maroonangel.hotbarswitcher;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class HBS {
    public static KeyMapping switchKey = createKeyBinding(
            Identifier.fromNamespaceAndPath("hotbarswitcher", "swap"),
            InputConstants.Type.KEYSYM,
            82,
            KeyMapping.Category.INVENTORY);

    public void init() {}

    private static KeyMapping createKeyBinding(
            Identifier id, InputConstants.Type type, int code, KeyMapping.Category category) {
        return KeyMappingHelper.registerKeyMapping(
                new KeyMapping("key." + id.getNamespace() + "." + id.getPath(), type, code, category));
    }
}
