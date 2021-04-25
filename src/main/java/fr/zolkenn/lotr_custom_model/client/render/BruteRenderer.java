package fr.zolkenn.lotr_custom_model.client.render;

import fr.zolkenn.lotr_custom_model.Main;
import fr.zolkenn.lotr_custom_model.client.model.BruteModel;
import fr.zolkenn.lotr_custom_model.entities.BruteEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BruteRenderer extends MobRenderer<BruteEntity, BruteModel<BruteEntity>> {

    public static final ResourceLocation Texture = new ResourceLocation(Main.MID, "textures/entity/brute.png");

    public BruteRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new BruteModel<>(),1f);
    }

    @Override
    public @NotNull ResourceLocation getEntityTexture(@NotNull BruteEntity entity) {
        return Texture;
    }
}
