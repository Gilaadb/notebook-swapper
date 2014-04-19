package gilaad.itamar.idan.notebookswapper.dbitems.impl;

import gilaad.itamar.idan.notebookswapper.dbitems.enums.NotebookType;
import gilaad.itamar.idan.notebookswapper.dbitems.iface.IWishlistItem;

public class WishlistItem implements IWishlistItem {

	private long m_ID, m_UID;
	private int m_CourseNum;
	private boolean m_bExchangable,m_bForPurchase,m_bIsRelevant;
	private NotebookType m_Type; 
	
	@Override
	public long getWishID() 
	{
		return m_ID;
	}

	@Override
	public long getUserID() 
	{
		return m_UID;
	}

	@Override
	public int getCourseNumber() 
	{
		return m_CourseNum; 
	}

	@Override
	public boolean isExchangable() 
	{
		return m_bExchangable;
	}

	@Override
	public boolean isForPurchase() 
	{
		return m_bForPurchase;
	}

	@Override
	public boolean isWishStillRelevant() 
	{
		return m_bIsRelevant;
	}

	@Override
	public NotebookType getType() 
	{
		return m_Type;
	}

}
