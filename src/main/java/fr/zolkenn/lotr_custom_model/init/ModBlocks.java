package fr.zolkenn.lotr_custom_model.init;

import fr.zolkenn.lotr_custom_model.Main;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MID);

    public static final RegistryObject<Block> copper_block = createBlock("copper_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(3).slipperiness(1f).setRequiresTool()));

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier){
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ItemGroup.MATERIALS)));
        return block;
    }

}
