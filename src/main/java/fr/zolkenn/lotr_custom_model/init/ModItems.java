package fr.zolkenn.lotr_custom_model.init;

import fr.zolkenn.lotr_custom_model.Items.SpecialItems;
import fr.zolkenn.lotr_custom_model.Main;
import fr.zolkenn.lotr_custom_model.Utils.CustomItemTiers;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    //initalise les items basic
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MID);

    //initalise les items avancé
    public static final RegistryObject<SpecialItems> Special_ITEMS = ITEMS.register("model_changer",
            () -> new SpecialItems(new Item.Properties().group(Main.Lotr_addon_group)));


    //Zone pour rajoute des Items :
    public static final RegistryObject<Item> copper_ingot = ITEMS.register("copper_ingot",() -> new Item(new Item.Properties().group(Main.Lotr_addon_group)));
    public static final RegistryObject<Item> copper_stick = ITEMS.register("copper_stick",() -> new Item(new Item.Properties().maxStackSize(2).group(Main.Lotr_addon_group)));

    public static final RegistryObject<Item> copper_sword = ITEMS.register("copper_sword",() -> new SwordItem(CustomItemTiers.copper, 2, -2.4f, new Item.Properties().maxStackSize(1).group(Main.Lotr_addon_group)));
    public static final RegistryObject<Item> copper_pickaxe = ITEMS.register("copper_pickaxe",() -> new PickaxeItem(CustomItemTiers.copper, 2, -2.4f, new Item.Properties().maxStackSize(1).group(Main.Lotr_addon_group)));
    public static final RegistryObject<Item> copper_shovel = ITEMS.register("copper_shovel",() -> new ShovelItem(CustomItemTiers.copper, 2, -2.4f, new Item.Properties().maxStackSize(1).group(Main.Lotr_addon_group)));
    public static final RegistryObject<Item> copper_axe = ITEMS.register("copper_axe",() -> new AxeItem(CustomItemTiers.copper, 2, -2.4f, new Item.Properties().maxStackSize(1).group(Main.Lotr_addon_group)));

}
