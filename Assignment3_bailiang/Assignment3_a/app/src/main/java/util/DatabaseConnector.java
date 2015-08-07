package util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gongbailiang on 7/22/15.
 */
public class DatabaseConnector {
    private static final String DATABASE_NAME = "StuScores";
    private SQLiteDatabase database; // database object
    private DatabaseOpenHelper databaseOpenHelper; // database helper

    // public constructor for DatabaseConnector
    public DatabaseConnector(Context context)
    {
        // create a new DatabaseOpenHelper
        databaseOpenHelper =
                new DatabaseOpenHelper(context, DATABASE_NAME, null, 1);
    } // end DatabaseConnector constructor

    // open the database connection
    public void open() throws SQLException
    {
        // create or open a database for reading/writing
        database = databaseOpenHelper.getWritableDatabase();
    } // end method open

    // close the database connection
    public void close()
    {
        if (database != null)
            database.close(); // close the database connection
    } // end method close

    // inserts a new contact in the database
    public void insertInput(int stuid, int q1, int q2, int q3, int q4, int q5)
    {
        ContentValues newInput = new ContentValues();
        newInput.put("stuid", stuid);
        newInput.put("q1", q1);
        newInput.put("q2", q2);
        newInput.put("q3", q3);
        newInput.put("q4", q4);
        newInput.put("q5", q5);

        open(); // open the database
        database.insert("stu", null, newInput);
        close(); // close the database
    } // end method insertContact

    // inserts a new contact in the database
    public void updateInput(int stuid, int q1, int q2, int q3, int q4, int q5)
    {
        ContentValues editInput = new ContentValues();
        editInput.put("id", stuid);
        editInput.put("q1", q1);
        editInput.put("q2", q2);
        editInput.put("q3", q3);
        editInput.put("q4", q4);
        editInput.put("q5", q5);

        open(); // open the database
        database.update("stu", editInput, "_stuid=" + stuid, null);
        close(); // close the database
    } // end method updateContact

    // return a Cursor with all contact information in the database
    public Cursor getAllInputs()
    {
        return database.query("stu", new String[] {"stuid", "q1", "q2","q3", "q4", "q5"},
                null, null, null, null, "_id");
    } // end method getAllContacts

    // get a Cursor containing all information about the contact specified
    // by the given id
    public Cursor getOneInput(long id)
    {
        return database.query(
                "stu", null, "_id=" + id, null, null, null, null);
    } // end method getOnContact

    // delete the contact specified by the given String name
    public void deleteInput(long id)
    {
        open(); // open the database
        database.delete("stu", "_id=" + id, null);
        close(); // close the database
    } // end method deleteContact

    public int[] getStatScores(int num) {
        open(); // open the database

        int[] scores = new int[3];
        //Max
        Cursor cursor = database.query("stu", new String[] { "max(q" + num + ")" },
                null, null, null, null, null);
        cursor.moveToFirst();
        scores[0] = cursor.getInt(0);
        //Min
        cursor = database.query("stu", new String[] { "min(q" + num + ")" },
                null, null, null, null, null);
        cursor.moveToFirst();
        scores[1] = cursor.getInt(0);
        //Avg
        cursor = database.query("stu", new String[] { "avg(q" + num + ")" },
                null, null, null, null, null);
        cursor.moveToFirst();
        scores[2] = cursor.getInt(0);
        try{
            return scores;
        }finally{
            cursor.close();
        }
    }

    private class DatabaseOpenHelper extends SQLiteOpenHelper
    {
        // public constructor
        public DatabaseOpenHelper(Context context, String name,
                                  SQLiteDatabase.CursorFactory factory, int version)
        {
            super(context, name, factory, version);
        } // end DatabaseOpenHelper constructor

        // creates the contacts table when the database is created
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            // query to create a new table named contacts
            String createQuery = "CREATE TABLE stu " +
                    "(_id integer primary key autoincrement, " +
                    "stuid integer, q1 integer, q2 integer, q3 integer, q4 integer, q5 integer);";
            System.out.println(createQuery);

            db.execSQL(createQuery); // execute the query
        } // end method onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
        } // end method onUpgrade
    }
}
