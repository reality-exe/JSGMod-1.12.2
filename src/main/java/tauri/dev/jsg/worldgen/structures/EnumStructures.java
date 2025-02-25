package tauri.dev.jsg.worldgen.structures;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import tauri.dev.jsg.config.JSGConfig;
import tauri.dev.jsg.stargate.network.SymbolTypeEnum;
import tauri.dev.jsg.worldgen.structures.stargate.nether.JSGNetherStructure;
import tauri.dev.jsg.worldgen.structures.stargate.processor.NetherProcessor;
import tauri.dev.jsg.worldgen.structures.stargate.processor.OverworldProcessor;
import tauri.dev.jsg.worldgen.util.EnumGenerationHeight;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum EnumStructures {

    // ---------------------------------------------------------------------------
    // STARGATE STRUCTURES

    // Milkyway
    PLAINS_MW("sg_plains_milkyway", 0, true, false, SymbolTypeEnum.MILKYWAY, 13, 13, 0, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceOverworld, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.GRASS);
                add(Blocks.DIRT);
                add(Blocks.STONE);
            }}, null, 35, Rotation.CLOCKWISE_90, 0.7, 0.8, EnumGenerationHeight.MIDDLE),
    DESERT_MW("sg_desert_milkyway", 0, true, false, SymbolTypeEnum.MILKYWAY, 13, 13, 0, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceOverworld, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.SAND);
                add(Blocks.SANDSTONE);
            }},
            new ArrayList<String>() {{
                add("desert");
                add("mesa");
            }}, 35, Rotation.CLOCKWISE_90, 0.7, 0.8, EnumGenerationHeight.MIDDLE),
    MOSSY_MW("sg_mossy_milkyway", 0, true, false, SymbolTypeEnum.MILKYWAY, 13, 13, 0, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceOverworld, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.GRASS);
                add(Blocks.DIRT);
                add(Blocks.STONE);
            }},
            new ArrayList<String>() {{
                add("taiga");
                add("jungle");
                add("swamp");
                add("mushroom");
            }}, 35, Rotation.CLOCKWISE_90, 0.7, 0.8, EnumGenerationHeight.MIDDLE),
    FROST_MW("sg_frosty_milkyway", 0, true, false, SymbolTypeEnum.MILKYWAY, 13, 13, 0, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceOverworld, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.SNOW);
                add(Blocks.SNOW_LAYER);
                add(Blocks.ICE);
                add(Blocks.FROSTED_ICE);
                add(Blocks.PACKED_ICE);
            }},
            new ArrayList<String>() {{
                add("ice");
                add("frozen");
                add("cold");
            }}, 35, Rotation.CLOCKWISE_90, 0.7, 0.8, EnumGenerationHeight.MIDDLE),
    // Pegasus
    PLAINS_PG("sg_plains_pegasus", 0, true, false, SymbolTypeEnum.PEGASUS, 13, 13, 0, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceOverworld, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.GRASS);
                add(Blocks.DIRT);
                add(Blocks.STONE);
            }}, null, 35, Rotation.CLOCKWISE_90, 0.8, 0.8, EnumGenerationHeight.MIDDLE),
    DESERT_PG("sg_desert_pegasus", 0, true, false, SymbolTypeEnum.PEGASUS, 13, 13, 0, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceOverworld, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.SAND);
                add(Blocks.SANDSTONE);
            }},
            new ArrayList<String>() {{
                add("desert");
                add("mesa");
            }}, 35, Rotation.CLOCKWISE_90, 0.7, 0.8, EnumGenerationHeight.MIDDLE),
    MOSSY_PG("sg_mossy_pegasus", 0, true, false, SymbolTypeEnum.PEGASUS, 13, 13, 0, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceOverworld, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.GRASS);
                add(Blocks.DIRT);
                add(Blocks.STONE);
            }},
            new ArrayList<String>() {{
                add("taiga");
            }}, 35, Rotation.CLOCKWISE_90, 0.7, 0.8, EnumGenerationHeight.MIDDLE),
    FROST_PG("sg_frosty_pegasus", 0, true, false, SymbolTypeEnum.PEGASUS, 13, 13, 0, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceOverworld, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.SNOW);
                add(Blocks.SNOW_LAYER);
                add(Blocks.ICE);
                add(Blocks.FROSTED_ICE);
                add(Blocks.PACKED_ICE);
            }},
            new ArrayList<String>() {{
                add("ice");
                add("frozen");
                add("cold");
            }}, 35, Rotation.CLOCKWISE_90, 0.7, 0.8, EnumGenerationHeight.MIDDLE),
    // Universe
    END_UNI("sg_end_universe", 0, true, false, SymbolTypeEnum.UNIVERSE, 10, 10, 1, true, JSGConfig.stargateGeneratorConfig.stargateRandomGeneratorEnabled, JSGConfig.stargateGeneratorConfig.stargateRGChanceTheEnd, new OverworldProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.END_STONE);
            }}, null, 15, Rotation.CLOCKWISE_90, 0.7, 0.8, EnumGenerationHeight.LOW),

    // Nether
    NETHER_MW("sg_nether_milkyway", 0, true, false, SymbolTypeEnum.MILKYWAY, 16, 16, -1, false, false, 0, new NetherProcessor(),
            new ArrayList<Block>() {{
                add(Blocks.NETHERRACK);
                add(Blocks.QUARTZ_ORE);
                add(Blocks.NETHER_BRICK);
                add(Blocks.SOUL_SAND);
            }}, null, 12, Rotation.NONE, 0.3, 0.8, EnumGenerationHeight.HEIGHT),

    // ---------------------------------------------------------------------------
    // GENERAL STRUCTURES

    NAQUADAH_MINE("naquadah_mine", 10, false, false, null, 15, 15, 0, false, JSGConfig.stargateGeneratorConfig.structuresRandomGeneratorEnabled, 0.0005f, null,
            new ArrayList<Block>() {{
                add(Blocks.GRASS);
            }}, null, 35, Rotation.NONE, 0.5, 0.5, EnumGenerationHeight.LOW),

    TOKRA_TUNNEL("tr_tokra", 21, false, true, null, 7, 7, 0, false, JSGConfig.stargateGeneratorConfig.structuresRandomGeneratorEnabled, 0.0005f, null,
            new ArrayList<Block>() {{
                add(Blocks.SAND);
                add(Blocks.GRASS);
            }}, null, 35, Rotation.NONE, 0.88, 0.8, EnumGenerationHeight.LOW),

    ANCIENT_TOTEM("ancient_totem", 0, false, false, null, 3, 3, 0, false, JSGConfig.stargateGeneratorConfig.structuresRandomGeneratorEnabled, 0.0008f, null,
            new ArrayList<Block>(){{
                add(Blocks.GRASS);
                add(Blocks.SAND);
                add(Blocks.STONE);
                add(Blocks.DIRT);
                add(Blocks.GRAVEL);
            }}, null, 5, Rotation.NONE, 0.3, 0.3, EnumGenerationHeight.MIDDLE),
    ;

    public final String name;
    private final JSGStructure structure;
    private final JSGNetherStructure netherStructure;
    public final boolean randomGenEnable;
    public final float chance;
    public final List<String> allowedInBiomes;
    public final List<Block> allowedOnBlocks;

    EnumStructures(String structureName, int yNegativeOffset, boolean isStargateStructure, boolean isRingsStructure, SymbolTypeEnum symbolType, int structureSizeX, int structureSizeZ, int dimensionToSpawn, boolean findOptimalRotation, boolean randomGenEnable, float chanceToGenerateRandom, ITemplateProcessor templateProcessor, @Nullable List<Block> allowedOnBlocks, @Nullable List<String> allowedInBiomes, int airCountUp, Rotation rotationToNorth, double terrainFlatPercents, double topBlockMatchPercent, @Nonnull EnumGenerationHeight genHeight) {
        this.name = structureName;
        this.netherStructure = new JSGNetherStructure(structureName, yNegativeOffset, isStargateStructure, isRingsStructure, symbolType, structureSizeX, structureSizeZ, airCountUp, dimensionToSpawn, findOptimalRotation, templateProcessor, rotationToNorth, terrainFlatPercents, topBlockMatchPercent, genHeight);
        this.structure = new JSGStructure(structureName, yNegativeOffset, isStargateStructure, isRingsStructure, symbolType, structureSizeX, structureSizeZ, airCountUp, dimensionToSpawn, findOptimalRotation, templateProcessor, rotationToNorth, terrainFlatPercents, topBlockMatchPercent, genHeight);

        this.randomGenEnable = randomGenEnable;
        this.chance = chanceToGenerateRandom;

        this.allowedInBiomes = allowedInBiomes;
        this.allowedOnBlocks = allowedOnBlocks;
    }

    public JSGStructure getActualStructure(int dimId){
        if(dimId == -1) return netherStructure;
        return structure;
    }

    @Nullable
    public static EnumStructures getStargateStructureByBiome(String biomeName, SymbolTypeEnum symbolType, int dimensionToSpawn) {
        ArrayList<EnumStructures> biomeNull = new ArrayList<>();
        for (EnumStructures structure : EnumStructures.values()) {
            if (!structure.getActualStructure(dimensionToSpawn).isStargateStructure) continue;
            if (structure.getActualStructure(dimensionToSpawn).symbolType != symbolType) continue;
            if (structure.getActualStructure(dimensionToSpawn).dimensionToSpawn != dimensionToSpawn) continue;
            if (structure.allowedInBiomes != null) {
                for (String s : structure.allowedInBiomes) {
                    if (biomeName.toLowerCase().contains(s.toLowerCase())) return structure;
                }
            } else biomeNull.add(structure);
        }
        if (biomeNull.size() > 0) return biomeNull.get(0);
        return null;
    }

    @Nullable
    public static EnumStructures getStructureByName(String name){
        for(EnumStructures s : EnumStructures.values()){
            if(s.name.equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public static Collection<String> getAllStructureNames(){
        Collection<String> col = new ArrayList<>();
        for(EnumStructures s : EnumStructures.values())
            col.add(s.name);
        return col;
    }
}
