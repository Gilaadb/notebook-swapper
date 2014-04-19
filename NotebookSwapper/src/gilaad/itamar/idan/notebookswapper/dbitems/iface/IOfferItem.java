package gilaad.itamar.idan.notebookswapper.dbitems.iface;

public interface IOfferItem {
	long getOfferID();
	long getUserID();
	long getCatalogItemID();
	boolean isExchangable();
	boolean isFree();
	boolean isOfferStillRelevant();
	int getPrice();
	String getAdditionalInfo();
}
