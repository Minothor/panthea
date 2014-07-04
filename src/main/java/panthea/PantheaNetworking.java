package panthea;

//FML imports
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

//
import emeraldCasino.network.*;
import emeraldCasino.network.packets.*;

public class PantheaNetworking {
	
	public static void register(SimpleNetworkWrapper ECchannel) {
		//Register Channel
		ECchannel = NetworkRegistry.INSTANCE.newSimpleChannel(EmeraldCasino.MODID);
		
		//register Packets
		ECchannel.registerMessage(DeityMessageHandler.class, DeityMessage.class, 0, Side.SERVER); 
		
	}

}
