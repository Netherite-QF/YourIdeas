package com.netheriteqf.your_ideas.mixin;

import com.netheriteqf.your_ideas.YourIdeas;
import com.netheriteqf.your_ideas.web.BrowserUrl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Goulixiaoji
 */
@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    @Shadow
    @Final
    private static Identifier ACCESSIBILITY_ICON_TEXTURE;

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init()V", at = @At("RETURN"))
    public void init(CallbackInfo ci) {
        this.addDrawableChild(
                new TexturedButtonWidget(
                        this.width / 2 + 104, this.height / 4 + 96, 20, 20, 0, 0, 20,
                        new Identifier(YourIdeas.MOD_ID, "textures/gui/idea.png"),
                        32, 64,
                        (buttonWidget) -> {
                            if (this.client != null) {
                                try {
                                    String code = MinecraftClient.getInstance().getLanguageManager().getLanguage()
                                            .getCode();
                                    if (code.indexOf("zh") == 0) {
                                        BrowserUrl.browserUrl("https://www.mcmod.cn/class/9072.html");
                                    } else {
                                        BrowserUrl.browserUrl("https://github.com/Netherite-QF/YourIdeas");
                                    }

                                } catch (Exception e) {
                                    YourIdeas.LOGGER.error(e.getClass().getName() + ": " + e.getMessage());
                                }
                            }
                        },
                        new TranslatableText("text.your_ideas.link")));
    }
}
