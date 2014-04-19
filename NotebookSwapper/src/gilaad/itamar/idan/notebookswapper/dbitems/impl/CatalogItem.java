package gilaad.itamar.idan.notebookswapper.dbitems.impl;

import gilaad.itamar.idan.notebookswapper.dbitems.enums.NotebookType;
import gilaad.itamar.idan.notebookswapper.dbitems.iface.ICatalogItem;

public class CatalogItem implements ICatalogItem {
	private long m_CatItemID;
	private int m_CourseNum;
	private String m_sEdition, m_sBarcode;
	private NotebookType m_Type;
	
	@Override
	public long getCatalogItemID() {
		return m_CatItemID;
	}

	@Override
	public int getCourseNumber() {
		return m_CourseNum;
	}

	@Override
	public String getEdition() {
		return m_sEdition;
	}

	@Override
	public String getBarcode() {
		return m_sBarcode;
	}

	@Override
	public NotebookType getType() {
		return m_Type;
	}

}
