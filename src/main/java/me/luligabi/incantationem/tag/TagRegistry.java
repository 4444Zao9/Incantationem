package me.luligabi.incantationem.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagRegistry {

    public static final TagKey<Block> COMMON_DIRT = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dirt"));


    public static void init() {
        // NO-OP
    }

    private TagRegistry() {
        // NO-OP
    }
}