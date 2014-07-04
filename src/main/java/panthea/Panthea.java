package panthea;

//Mod Imports

//Item/Block related Imports
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

//Forge Imports
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import panthea.blocks.*;
import panthea.blocks.tileEntities.*;
import panthea.items.*;
import panthea.proxies.*;

@Mod(modid = Panthea.MODID, name = Panthea.NAME, version = Panthea.VERSION)
public class Panthea
{
    public static final String MODID = "panthea";
    public static final String NAME = "Panthea";
    public static final String VERSION = "1.7.2 - 1.0.0";
    
    public static SimpleNetworkWrapper pantheaChannel;
    
    @Instance(value = "panthea")
	public static Panthea instance;
    
    @SidedProxy(clientSide="panthea.proxies.ClientProxy", serverSide="panthea.proxies.CommonProxy")
    public static CommonProxy proxy;
    
  //Declare Tab
  	//Set Creative Tab Icon
  	public static CreativeTabs tabPanthea;
  	
    
  	@EventHandler
  	public void preInit(FMLPreInitializationEvent event)
  	{
  		tabPanthea = new CreativeTabs("tabPanthea"){
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Blocks.emerald_block);
			}
		};
		
		PantheaBlocks.register(tabPanthea);
    	
		PantheaItems.register(tabPanthea);
		
		PantheaNetworking.register(pantheaChannel);
  	}
  	
  	@EventHandler
  	public void init(FMLInitializationEvent event)
  	{
  	//Add Relevant Recipes
  			proxy.registerRenderers();
  			
  			PantheaTileEntities.register();
  			
  			PantheaRecipes.register();
  			
  			PantheaEvents.register();
  	  		
  	}
    
    @EventHandler
	public void load(FMLLoadEvent event)
  	{
		

	}
  	
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
    	
    }
    
}
