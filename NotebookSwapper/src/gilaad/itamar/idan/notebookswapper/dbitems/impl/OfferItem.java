package gilaad.itamar.idan.notebookswapper.dbitems.impl;

import gilaad.itamar.idan.notebookswapper.dbitems.iface.IOfferItem;

public class OfferItem implements IOfferItem {

	private long m_ID, m_UID,m_CatItemID;
	private boolean m_bExchangable,m_bIsRelevant;
	private int m_iPrice;
	private String m_sInfo; 
	
	@Override
	public long getOfferID() {
		return m_ID;
	}

	@Override
	public long getUserID() {
		return m_UID;
	}

	@Override
	public long getCatalogItemID() {
		return m_CatItemID;
	}

	@Override
	public boolean isExchangable() {
		return m_bExchangable;
	}

	@Override
	public boolean isFree() {
		return m_iPrice == 0;
	}

	@Override
	public boolean isOfferStillRelevant() {
		return m_bIsRelevant;
	}

	@Override
	public int getPrice() {
		return m_iPrice;
	}

	@Override
	public String getAdditionalInfo() {
		return m_sInfo;
	}

}
