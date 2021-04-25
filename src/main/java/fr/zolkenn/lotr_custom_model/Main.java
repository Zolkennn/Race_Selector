package fr.zolkenn.lotr_custom_model;


import fr.zolkenn.lotr_custom_model.entities.BruteEntity;
import fr.zolkenn.lotr_custom_model.init.ModBlocks;
import fr.zolkenn.lotr_custom_model.init.ModEntityTypes;
import fr.zolkenn.lotr_custom_model.init.ModItems;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;


@Mod(Main.MID)
public class Main {

    public static final String MID = "lotr_custom_model";
    public static final ItemGroup Lotr_addon_group = new Addgroup(MID);

    public Main(){

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModEntityTypes.Entity_type.register(bus);

    }

    //menu creatif
    public static class Addgroup extends ItemGroup {


        public Addgroup(String label) {
            super(label);
        }

        @Override
        public ItemStack createIcon() {
            return ModItems.copper_ingot.get().getDefaultInstance();
        }

        @Override
        public boolean hasScrollbar() {
            return true;
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        public @NotNull ResourceLocation getBackgroundImage() {
            return new ResourceLocation(MID,"textures/gui/container/creative_inventory/tab_items_custom.png" );
        }
    }


    private void setup(FMLCommonSetupEvent e){
        DeferredWorkQueue.runLater(() ->{
            GlobalEntityTypeAttributes.put(ModEntityTypes.Brute.get(), BruteEntity.setcustomAttributes().create());
        });

    }
    private void clientSetup(FMLClientSetupEvent e){

    }
}
