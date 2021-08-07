package com.akash.second.ui.Dbhandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.akash.second.ui.home.foods;
import com.akash.second.ui.addcart.addcartfood;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.

    private static final String DB_NAME = "FOODMANAGEMENT.db";

    // below int is our database version
    private static final int DB_VERSION = 3;

    // below variable is for our table name.
    private static final String TABLE_NAME = "FOODDATA";
    private static final String ADDCART_TABLE="SELECTEDTABLE";

    // below variable is for our id column.
    private static final String ID_COL = "Id";

    // below variable is for our course name column
    private static final String NAME_COL = "Name";

    // below variable id for our course duration column.
    private static final String Imageurl_COL = "Imageurl";

    // below variable for our course description column.
    private static final String SHORTDES_COL = "Shortdesc";

    // below variable is for our course tracks column.
    private static final String LONGDES_COL = "Longdesc";
    private static final String PRICE_COL= "Price";
    private static final String AVAILABLE_COL= "StockValue";
    private static final String QUANTITY= "QUANTITY";





    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + Imageurl_COL + " LONGTEXT,"
                + SHORTDES_COL + " LONGTEXT,"
                + LONGDES_COL + " LONGTEXT,"
                + PRICE_COL + " INTEGER,"
                + AVAILABLE_COL+ " INTEGER)";

        String query2="CREATE TABLE " + ADDCART_TABLE + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PRICE_COL + " INTEGER,"
                + QUANTITY+ " INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
        db.execSQL(query2);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewitem(String Name, String imageurl, String description, String longdes,int price,int stock) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, Name);
        values.put(Imageurl_COL, imageurl);
        values.put(SHORTDES_COL, description);
        values.put(LONGDES_COL, longdes);
        values.put(PRICE_COL, price);
        values.put(AVAILABLE_COL,stock);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public void addcartinsert(String Name,int price,int quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, Name);
        values.put(PRICE_COL, price);
        values.put(QUANTITY,quantity);

        // after adding all values we are passing
        // content values to our table.
        db.insert(ADDCART_TABLE, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }
    public List<addcartfood> getAlladdcart() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + ADDCART_TABLE, null);

        // on below line we are creating a new array list.
        ArrayList<addcartfood> addcartList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                addcartList.add(new addcartfood(cursorCourses.getInt(0),
                        cursorCourses.getString(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return addcartList;
    }
     public int gettotalprice(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor totalprice=db.rawQuery("SELECT * FROM " + ADDCART_TABLE,  null);
        int val=0;

         if (totalprice.moveToFirst()) {
             do {
                val=val+totalprice.getInt(2);

             } while (totalprice.moveToNext());
         }
         totalprice.close();
         return val;


     }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ADDCART_TABLE);
        onCreate(db);
    }
    public Cursor getaddcart(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + ADDCART_TABLE + "where" + ID_COL + "=" + id, null);
        return res;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + "where" + ID_COL + "=" + id, null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

//    public boolean updateContact (Integer id,String Name, String imageurl, String description, String quantity) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        contentValues.put("phone", phone);
//        contentValues.put("email", email);
//        contentValues.put("street", street);
//        contentValues.put("place", place);
//        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
//        return true;
//    }
public Integer deleteaddcart(int id) {
    SQLiteDatabase db = this.getWritableDatabase();
    return db.delete(ADDCART_TABLE, "id = ? ",
            new String[]{Integer.toString(id)});
}
    public Integer deletefood(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<foods> getAllitems() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<foods> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new foods(cursorCourses.getInt(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getInt(5),
                        cursorCourses.getInt(6)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

//        ArrayList<String> array_list = new ArrayList<String>();
//
//        //hp = new HashMap();
//
//        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
//        res.moveToFirst();
//
//        while(res.isAfterLast() == false){
//            array_list.add(res.getString(res.getColumnIndex(TABLE_NAME)));
//            res.moveToNext();
//        }
//        return array_list;
    //  }
}
