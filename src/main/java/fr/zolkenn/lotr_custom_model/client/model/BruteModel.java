package fr.zolkenn.lotr_custom_model.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.zolkenn.lotr_custom_model.entities.BruteEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BruteModel<T extends BruteEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer Legfrontleft;
    private final ModelRenderer legfrontright;
    private final ModelRenderer legbackleft;
    private final ModelRenderer legbackright;

    public BruteModel() {
        textureWidth = 32;
        textureHeight = 39;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.setTextureOffset(12, 13).addBox(-2.5F, -14.0F, -9.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 22).addBox(-4.0F, -11.0F, -6.0F, 8.0F, 5.0F, 12.0F, 0.0F, false);

        Legfrontleft = new ModelRenderer(this);
        Legfrontleft.setRotationPoint(0.0F, 24.0F, 0.0F);
        Legfrontleft.setTextureOffset(13, 4).addBox(1.0F, -6.0F, -6.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

        legfrontright = new ModelRenderer(this);
        legfrontright.setRotationPoint(0.0F, 24.0F, 0.0F);
        legfrontright.setTextureOffset(0, 7).addBox(-4.0F, -6.0F, -6.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

        legbackleft = new ModelRenderer(this);
        legbackleft.setRotationPoint(0.0F, 24.0F, 0.0F);
        legbackleft.setTextureOffset(0, 16).addBox(1.0F, -6.0F, 3.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

        legbackright = new ModelRenderer(this);
        legbackright.setRotationPoint(0.0F, 24.0F, 0.0F);
        legbackright.setTextureOffset(0, 25).addBox(-4.0F, -6.0F, 3.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        //this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.legbackright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1F * limbSwingAmount;
        //this.legbackleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        //this.legfrontright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        //this.Legfrontleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        Legfrontleft.render(matrixStack, buffer, packedLight, packedOverlay);
        legfrontright.render(matrixStack, buffer, packedLight, packedOverlay);
        legbackleft.render(matrixStack, buffer, packedLight, packedOverlay);
        legbackright.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
