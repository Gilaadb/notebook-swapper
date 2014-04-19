package gilaad.itamar.idan.notebookswapper.dbhandler;

import gilaad.itamar.idan.notebookswapper.dbitems.iface.*;

import java.util.ArrayList;


public abstract class AbstractDataManager {

	private static AbstractDataManager m_manager = null;
	
	public abstract ArrayList<ICourse> getAllCourses();
	public abstract ArrayList<IWishlistItem> getMyWishlist();
	public abstract ArrayList<IOfferItem> getMyOffers();
	public abstract ArrayList<ICatalogItem> getCatalog();
	
	public static AbstractDataManager getManager()
	{		
		return m_manager;
	}
	
	public static void setManager(AbstractDataManager $)
	{
		m_manager = $;
	}

}
