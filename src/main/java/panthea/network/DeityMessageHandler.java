package panthea.network;

import emeraldCasino.network.packets.*;
import cpw.mods.fml.common.network.simpleimpl.*;

public class DeityMessageHandler implements IMessageHandler<DeityMessage, IMessage>{
	@Override
	public IMessage onMessage(DeityMessage message, MessageContext ctx) {
		System.out.println(message.packetPayload);
		return message;
	}

}
