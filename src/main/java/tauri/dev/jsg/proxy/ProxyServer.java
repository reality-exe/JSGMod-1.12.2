package tauri.dev.jsg.proxy;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import tauri.dev.jsg.renderer.stargate.StargateAbstractRendererState;
import tauri.dev.jsg.sound.SoundPositionedEnum;

@SuppressWarnings({"deprecation", "unused"})
public class ProxyServer implements IProxy {
    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }

    @Override
    public EntityPlayer getPlayerInMessageHandler(MessageContext ctx) {
        return ctx.getServerHandler().player;
    }

    @Override
    public void setTileEntityItemStackRenderer(Item item) {

    }

    @Override
    public EntityPlayer getPlayerClientSide() {
        return null;
    }

    @Override
    public void addScheduledTaskClientSide(Runnable runnable) {
    }

    @Override
    public void orlinRendererSpawnParticles(World world, StargateAbstractRendererState rendererState) {
    }

    @Override
    public void playPositionedSoundClientSide(BlockPos pos, SoundPositionedEnum soundEnum, boolean play) {
    }

    @Override
    public void openGui(GuiScreen gui) {
    }

    @Override
    public void shutDown() {
    }
}
