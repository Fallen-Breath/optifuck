package me.fallenbreath.optifuck.mixins;

import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("ShadowTarget")
@Mixin(DebugHud.class)
public abstract class DebugHudMixin
{
	@Dynamic
	@Shadow(remap = false)
	private long updateInfoLeftTimeMs;

	@Dynamic
	@Shadow(remap = false)
	private long updateInfoRightTimeMs;

	@Inject(method = "render", at = @At("TAIL"))
	private void cancelOptFpsLimit(CallbackInfo ci)
	{
		this.updateInfoLeftTimeMs = 0;
		this.updateInfoRightTimeMs = 0;
	}
}
