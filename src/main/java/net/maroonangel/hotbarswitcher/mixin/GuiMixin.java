package net.maroonangel.hotbarswitcher.mixin;

import net.maroonangel.hotbarswitcher.HBS;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Unique
    private static Inventory inventory;

    @Inject(method = "tick", at = @At("RETURN"))
    public void tick(final CallbackInfo info) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player != null) {
            inventory = player.getInventory();
            if (inventory != null && HBS.switchKey.consumeClick() && !mc.hasControlDown()) {
                if (mc.hasShiftDown()) {
                    int selectedSlot = ((InventoryAccessor) inventory).getSelected();
                    int top = selectedSlot + 9;
                    int mid = top + 9;
                    int bot = mid + 9;

                    mc.gameMode.handleInventoryMouseClick(0, top, selectedSlot, ClickType.SWAP, player);
                    mc.gameMode.handleInventoryMouseClick(0, mid, selectedSlot, ClickType.SWAP, player);
                    mc.gameMode.handleInventoryMouseClick(0, bot, selectedSlot, ClickType.SWAP, player);
                } else {
                    int selectedSlot = ((InventoryAccessor) inventory).getSelected();
                    int topSlot = selectedSlot + 27;

                    mc.gameMode.handleInventoryMouseClick(0, topSlot, selectedSlot, ClickType.SWAP, player);
                }
            }
        }
    }
}
