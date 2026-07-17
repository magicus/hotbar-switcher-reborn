package net.maroonangel.hotbarswitcher;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;

public class HBS {

	public static KeyBinding switchKey = createKeyBinding(Identifier.of("hotbarswitcher", "swap"), InputUtil.Type.KEYSYM, 82, KeyBinding.Category.INVENTORY);

	public void init() {

	}

	private static KeyBinding createKeyBinding(Identifier id, InputUtil.Type type, int code, KeyBinding.Category category) {
        return KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + id.getNamespace() + "." + id.getPath(), type, code, category));
	}
}
