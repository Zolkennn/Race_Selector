package fr.zolkenn.lotr_custom_model.entities;

import fr.zolkenn.lotr_custom_model.init.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class BruteEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEM = Ingredient.fromItems(Items.LAVA_BUCKET);

    public BruteEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setcustomAttributes(){
        return MobEntity.registerAttributes()
                .createMutableAttribute(Attributes.MAX_HEALTH, 30D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 4D);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1D, TEMPTATION_ITEM, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(4);
    }

    @Nullable @Override protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_PIGLIN_BRUTE_AMBIENT;}
    @Nullable @Override protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_PIGLIN_BRUTE_DEATH; }
    @Nullable @Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_PIGLIN_BRUTE_HURT; }
    @Override protected void playStepSound(BlockPos pos, BlockState blockIn) { this.playSound(SoundEvents.ENTITY_PIGLIN_BRUTE_STEP, 0.15f,1.0f); }

    @Override
    protected float getJumpFactor() {
        return 4f;
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return ModEntityTypes.Brute.get().create(world);
    }
}
