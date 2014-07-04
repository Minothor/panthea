package panthea;

import cpw.mods.fml.common.FMLCommonHandler;
import emeraldCasino.events.*;

public class PantheaEvents {

	public static void register() {
		
		FMLCommonHandler.instance().bus().register(new cardHandHandler());
		
	}

}
