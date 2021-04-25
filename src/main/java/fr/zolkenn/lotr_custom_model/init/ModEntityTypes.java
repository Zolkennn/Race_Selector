package fr.zolkenn.lotr_custom_model.init;

import fr.zolkenn.lotr_custom_model.Main;
import fr.zolkenn.lotr_custom_model.entities.BruteEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> Entity_type = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MID);

    //Entity types
    public static final RegistryObject<EntityType<BruteEntity>> Brute = Entity_type.register("brute",
            () -> EntityType.Builder.create(BruteEntity::new, EntityClassification.CREATURE)
                    .size(1f,1f).build(new ResourceLocation(Main.MID,"brute").toString()));
}
