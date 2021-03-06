package panthea;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.blocks.blockCardDeck;
import emeraldCasino.items.itemCardDeck;

public class PantheaBlocks {
	public static Block blockCardDeck;
	private PantheaBlocks() {}
	
	public static void register(CreativeTabs tabEC)
	{
		//Initialise Blocks
  		blockCardDeck = new blockCardDeck().setBlockName("CardDeckBlock");
  		if(tabEC!=null)
  			//blockCardDeck.setCreativeTab(tabEC); //Commented out to stop card deck blocks being in creative
  		GameRegistry.registerBlock(blockCardDeck, "cardDeckBlock");
	}
}
