package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by dbuffing on 06-03-2018.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    /**
     * Database version
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Database name
     */
    private static final String DATABASE_NAME = "Shelter.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";



    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;

    /**
     * Database constructor
     */
    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Database Creation
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /**
         * Database create command
         */
        String SQL_CREATE_PETS_TABLE =
                "CREATE TABLE " + PetEntry.TABLE_NAME + "(" +
                        PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + PetEntry.COLUMN_PET_NAME + TEXT_TYPE + COMMA_SEP
                        + PetEntry.COLUMN_PET_GENDER + " INTEGER" + COMMA_SEP
                        + PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP
                        + PetEntry.COLUMN_PET_WEIGHT + " INTEGER"
                        + ")";

        sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);

    }

    /**
     * Database upgrade
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
