package gilaad.itamar.idan.notebookswapper.dbitems.iface;

import gilaad.itamar.idan.notebookswapper.dbitems.enums.NotebookType;

public interface ICatalogItem {
	long getCatalogItemID();
	int getCourseNumber();
	String getEdition();
	String getBarcode(); //String?
	NotebookType getType();
}
