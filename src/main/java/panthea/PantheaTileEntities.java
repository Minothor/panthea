package panthea;

import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.blocks.tileEntities.TileEntityCardBlock;

public class PantheaTileEntities {

	private PantheaTileEntities() {}
	
	public static void register() {
		
		GameRegistry.registerTileEntity(TileEntityCardBlock.class, "tileEntityCardDeck");
		
	}

}
