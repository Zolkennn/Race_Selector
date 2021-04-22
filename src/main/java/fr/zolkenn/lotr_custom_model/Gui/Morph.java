package fr.zolkenn.lotr_custom_model.Gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import fr.zolkenn.lotr_custom_model.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Morph extends Screen {

    private final ResourceLocation Gui_Morph = new ResourceLocation(Main.MID, "textures/gui/base.png");

    private final int xSize = 256;
    private final  int ySize = 202;
    private int GuiLeftMoi;
    private int GuiTopMoi;
    private float oldMouseX;
    private float oldMouseY;



    public Morph() {
        super(new TranslationTextComponent("Gui.Title.Morph"));
    }


    protected void init(){
        this.GuiLeftMoi = (this.width - this.xSize)/2;
        this.GuiTopMoi = (this.height - this.ySize)/2;
    }

    //func_230430_a_
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        drawBackground(matrixStack);
        drawtext();
        this.oldMouseX = (float)mouseX;
        this.oldMouseY = (float)mouseY;
        drawEntity();
        drawButon();
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }


    //fontion à appelez
    private void drawBackground(MatrixStack matrixStack){
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(Gui_Morph);
        this.blit(matrixStack, GuiLeftMoi, GuiTopMoi, 0,0, this.xSize, this.ySize);
    }

    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, @org.jetbrains.annotations.NotNull LivingEntity livingEntity) {
        float f = (float)Math.atan(mouseX / 40.0F);
        float f1 = (float)Math.atan(mouseY / 40.0F);
        RenderSystem.pushMatrix();
        RenderSystem.translatef((float)posX, (float)posY, 1050.0F);
        RenderSystem.scalef(1.0F, 1.0F, -1.0F);
        MatrixStack matrixstack = new MatrixStack();
        matrixstack.translate(0.0D, 0.0D, 1000.0D);
        matrixstack.scale((float)scale, (float)scale, (float)scale);
        Quaternion quaternion = Vector3f.ZP.rotationDegrees(180.0F);
        Quaternion quaternion1 = Vector3f.XP.rotationDegrees(f1 * 20.0F);
        quaternion.multiply(quaternion1);
        matrixstack.rotate(quaternion);
        float f2 = livingEntity.renderYawOffset;
        float f3 = livingEntity.rotationYaw;
        float f4 = livingEntity.rotationPitch;
        float f5 = livingEntity.prevRotationYawHead;
        float f6 = livingEntity.rotationYawHead;
        livingEntity.renderYawOffset = 180.0F + f * 20.0F;
        livingEntity.rotationYaw = 180.0F + f * 40.0F;
        livingEntity.rotationPitch = -f1 * 20.0F;
        livingEntity.rotationYawHead = livingEntity.rotationYaw;
        livingEntity.prevRotationYawHead = livingEntity.rotationYaw;
        EntityRendererManager entityrenderermanager = Minecraft.getInstance().getRenderManager();
        quaternion1.conjugate();
        entityrenderermanager.setCameraOrientation(quaternion1);
        entityrenderermanager.setRenderShadow(false);
        entityrenderermanager.setDebugBoundingBox(false);
        IRenderTypeBuffer.Impl irendertypebuffer$impl = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        RenderSystem.runAsFancy(() -> entityrenderermanager.renderEntityStatic(livingEntity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, matrixstack, irendertypebuffer$impl, 15728880));
        irendertypebuffer$impl.finish();
        entityrenderermanager.setRenderShadow(true);
        livingEntity.renderYawOffset = f2;
        livingEntity.rotationYaw = f3;
        livingEntity.rotationPitch = f4;
        livingEntity.prevRotationYawHead = f5;
        livingEntity.rotationYawHead = f6;
        RenderSystem.popMatrix();
    }

    private void drawtext(){

    }

    private void drawEntity(){
        assert this.minecraft != null;
        assert this.minecraft.player != null;
        drawEntityOnScreen( GuiLeftMoi + 51, GuiTopMoi + 75, 30, (float)(GuiLeftMoi + 51) - this.oldMouseX, (float)(GuiTopMoi + 75 - 50) - this.oldMouseY, this.minecraft.player);
    }

    private void drawButon(){
        this.addButton(new Button(GuiLeftMoi, GuiTopMoi, 110, 20, new TranslationTextComponent("lotr_custom_model.gui.menu.Button1"), button -> {
            try {
                assert this.minecraft != null;
                assert this.minecraft.player != null;
                assert this.minecraft.world != null;
                double x = this.minecraft.player.getPosX();
                double y = this.minecraft.player.getPosY();
                double z = this.minecraft.player.getPosZ();
                this.minecraft.world.addParticle(ParticleTypes.EXPLOSION, x, y + 1D, z, 0.0D, 4D, 0.0D);
                this.minecraft.world.playSound(x, y, z, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 2.0F, (1.0F + (this.minecraft.world.rand.nextFloat() - this.minecraft.world.rand.nextFloat()) * 0.2F) * 0.7F, false);
            }catch (Exception ignored){
            }
        }));
    }

}
