package tauri.dev.jsg.renderer.stargate;

import io.netty.buffer.ByteBuf;
import tauri.dev.jsg.loader.texture.TextureLoader;
import tauri.dev.jsg.renderer.activation.Activation;
import tauri.dev.jsg.renderer.activation.StargateActivation;
import tauri.dev.jsg.renderer.biomes.BiomeOverlayEnum;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.*;

import static tauri.dev.jsg.stargate.EnumMemberVariant.CHEVRON;

public class ChevronTextureList {

  //	private String chevronTextureBase;

  // Saved
  private final List<ChevronEnum> activeChevrons = new ArrayList<>(9);
  //	private int activeChevrons;
  //	private boolean isFinalActive;

  // Not saved
  public Map<ChevronEnum, Integer> CHEVRON_STATE_MAP = new HashMap<>(9);
  private final List<Activation<ChevronEnum>> activationList = new ArrayList<>();

  private final Map<BiomeOverlayEnum, Map<Integer, ResourceLocation>> CHEVRON_RESOURCE_MAP = new HashMap<>();
  private final Map<Integer, ResourceLocation> CHEVRON_LIGHT_RESOURCE_MAP = new HashMap<>();

  public ChevronTextureList(String chevronTextureBase) {
    for (BiomeOverlayEnum biomeOverlay : BiomeOverlayEnum.values()) {
      Map<Integer, ResourceLocation> map = new HashMap<>();

      for (int i = 0; i <= 10; i++) {
        CHEVRON_LIGHT_RESOURCE_MAP.put(i, TextureLoader.getTextureResource(chevronTextureBase + i + "_emissive.png"));
        map.put(i, TextureLoader.getTextureResource(chevronTextureBase + i + biomeOverlay.suffix + ".jpg"));
      }

      CHEVRON_RESOURCE_MAP.put(biomeOverlay, map);
    }
  }

  public ChevronTextureList(String chevronTextureBase, int activeChevrons, boolean isFinalActive) {
    this(chevronTextureBase);

    if (isFinalActive) activeChevrons--;

    for (int i = 0; i < activeChevrons; i++)
      this.activeChevrons.add(ChevronEnum.valueOf(i));

    if (isFinalActive) this.activeChevrons.add(ChevronEnum.getFinal());
  }

  public void initClient() {
    for (ChevronEnum chevron : ChevronEnum.values()) {
      CHEVRON_STATE_MAP.put(chevron, activeChevrons.contains(chevron) ? 10 : 0);
    }
  }

  public ChevronEnum getCurrentChevron() {
    if (activeChevrons.size() > 0) return activeChevrons.get(activeChevrons.size() - 1);
    return ChevronEnum.C1;
  }

  public ChevronEnum getNextChevron() {
    if (activeChevrons.size() > 0) return getCurrentChevron().getNext();
    return ChevronEnum.C1;
  }

  public void activateNextChevron(long totalWorldTime) {
    ChevronEnum next = getNextChevron();

    activationList.add(new StargateActivation(next, totalWorldTime, false));
    activeChevrons.add(next);
  }

  public void activateNextChevron(long totalWorldTime, int chevron) {
    if(chevron < 10){
      activateNextChevron(totalWorldTime);
      return;
    }
    ChevronEnum chev = ChevronEnum.valueOf(chevron-10);

    activationList.add(new StargateActivation(chev, totalWorldTime, false));
    activeChevrons.add(chev);
  }

  public void activateFinalChevron(long totalWorldTime) {
    activationList.add(new StargateActivation(ChevronEnum.getFinal(), totalWorldTime, false));
    activeChevrons.add(ChevronEnum.getFinal());
  }

  public void deactivateFinalChevron(long totalWorldTime) {
    activationList.add(new StargateActivation(ChevronEnum.getFinal(), totalWorldTime, true));
    activeChevrons.remove(ChevronEnum.getFinal());
  }

  public void clearChevrons(long totalWorldTime) {
    for (ChevronEnum chevron : activeChevrons) {
      activationList.add(new StargateActivation(chevron, totalWorldTime, true));
    }

    activeChevrons.clear();
  }

  public void lightUpChevrons(long totalWorldTime, int incomingAddressSize) {
    for (ChevronEnum chevron : Arrays.asList(ChevronEnum.C7, ChevronEnum.C8)) {
      if (activeChevrons.contains(chevron) && chevron.index >= incomingAddressSize - 1) {
        activationList.add(new StargateActivation(chevron, totalWorldTime, true));
      }
    }

    activeChevrons.clear();

    while (activeChevrons.size() < incomingAddressSize - 1) {
      activateNextChevron(totalWorldTime);
    }

    activateFinalChevron(totalWorldTime);
  }

  public void iterate(World world, double partialTicks) {
    Activation.iterate(activationList, world.getTotalWorldTime(), partialTicks, (index, stage) -> {
      CHEVRON_STATE_MAP.put(index, Math.round(stage));
    });
  }

  public ResourceLocation get(BiomeOverlayEnum overlayEnum, ChevronEnum chevron, boolean onlyLight) {
    if(onlyLight)
      return CHEVRON_LIGHT_RESOURCE_MAP.get(CHEVRON_STATE_MAP.get(chevron));
    return CHEVRON_RESOURCE_MAP.get(overlayEnum).get(CHEVRON_STATE_MAP.get(chevron));
  }

  public void toBytes(ByteBuf buf) {
    buf.writeInt(activeChevrons.size());

    for (ChevronEnum chevron : activeChevrons) {
      buf.writeInt(chevron.index);
    }
  }

  public void fromBytes(ByteBuf buf) {
    int size = buf.readInt();
    activeChevrons.clear();

    for (int i = 0; i < size; i++) {
      activeChevrons.add(ChevronEnum.valueOf(buf.readInt()));
    }
  }
}
