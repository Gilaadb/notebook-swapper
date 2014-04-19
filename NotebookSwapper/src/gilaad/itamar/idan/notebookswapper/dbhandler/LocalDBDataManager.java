package gilaad.itamar.idan.notebookswapper.dbhandler;

import gilaad.itamar.idan.notebookswapper.dbitems.iface.ICatalogItem;
import gilaad.itamar.idan.notebookswapper.dbitems.iface.ICourse;
import gilaad.itamar.idan.notebookswapper.dbitems.iface.IOfferItem;
import gilaad.itamar.idan.notebookswapper.dbitems.iface.IWishlistItem;
import gilaad.itamar.idan.notebookswapper.dbitems.impl.Course;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDBDataManager extends AbstractDataManager {
	
	MySQLiteOpenHelper m_DatabaseHelper;
	private class MySQLiteOpenHelper extends SQLiteOpenHelper
	{

		public MySQLiteOpenHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE Offers (OfferID INTEGER PRIMARY KEY, UserID INTEGER, NotebookID INTEGER, Condition TEXT, IsExchange INTEGER, Price INTEGER, IsRelevant INTEGER, AdditionalInfo TEXT);");
			db.execSQL("CREATE TABLE Courses (CourseNumber INTEGER PRIMARY KEY, CourseName TEXT, Faculty TEXT);");
			db.execSQL("INSERT INTO Courses VALUES(236369,'WWW','CS');");
			db.execSQL("CREATE TABLE Catalog (ItemID INTEGER PRIMARY KEY, Edition TEXT, Type TEXT, CourseNumber INTEGER, Barcode BLOB);");
			db.execSQL("CREATE TABLE Wishes (WishID INTEGER PRIMARY KEY, UserID INTEGER, CourseNumber INTEGER, IsExchange INTEGER, WantToBuy INTEGER, IsRelevant INTEGER);");			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			return;
		}
		
	}

	public LocalDBDataManager(Context context)
	{
		super();
		m_DatabaseHelper = new MySQLiteOpenHelper(context, null, null, 1);	
	}
	
	@Override
	public ArrayList<ICourse> getAllCourses() {
		SQLiteDatabase readableDatabase = m_DatabaseHelper.getReadableDatabase();
		Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM Courses", null);
		if (null == rawQuery)
		{
			return null;
		}
		int idx_Number = rawQuery.getColumnIndex("CourseNumber");
		int idx_Name = rawQuery.getColumnIndex("CourseName");
		int idx_Faculty = rawQuery.getColumnIndex("Faculty");
		ArrayList<ICourse> $ = new ArrayList<ICourse>();
		while (rawQuery.moveToNext())
		{
			$.add(new Course(rawQuery.getInt(idx_Number),rawQuery.getString(idx_Name),rawQuery.getString(idx_Faculty)));
		}
		return $;
	}

	@Override
	public ArrayList<IWishlistItem> getMyWishlist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<IOfferItem> getMyOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ICatalogItem> getCatalog() {
		// TODO Auto-generated method stub
		return null;
	}

}
