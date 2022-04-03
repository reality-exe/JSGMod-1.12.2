package mrjake.aunis.block.transportrings;

import mrjake.aunis.tileentity.transportrings.TransportRingsAbstractTile;
import mrjake.aunis.tileentity.transportrings.TransportRingsAncientTile;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

public class TransportRingsAncientBlock extends TransportRingsAbstractBlock {

  private static final String blockName = "transportrings_block";

  public TransportRingsAncientBlock() {
    super(blockName);
  }

  @Override
  public TransportRingsAbstractTile createTileEntity(World world, IBlockState state) {
    return new TransportRingsAncientTile();
  }
}
