package gilaad.itamar.idan.notebookswapper.dbitems.iface;

import gilaad.itamar.idan.notebookswapper.dbitems.enums.NotebookType;

public interface IWishlistItem {
	long getWishID();
	long getUserID();
	int getCourseNumber();
	boolean isExchangable();
	boolean isForPurchase();
	boolean isWishStillRelevant();
	NotebookType getType();	
}
