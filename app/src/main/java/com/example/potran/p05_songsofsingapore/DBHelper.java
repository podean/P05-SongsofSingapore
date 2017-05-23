package com.example.potran.p05_songsofsingapore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 127107 on 23/5/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    //TODO Define the Database properties
    private static final String DATABASE_NAME = "songs.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_SONG = "song";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SINGER = "singer";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_STARS = "stars";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO CREATE TABLE Note
        String createTable = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_SINGER + " TEXT,"
                + COLUMN_YEAR + " INTEGER,"
                + COLUMN_STARS + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
        onCreate(db);
    }

    public void insertSong(String title, String singer, int year, int stars) {
        //TODO insert the data into the database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_SINGER, singer);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_STARS, stars);
        db.insert(TABLE_SONG, null,values);
        db.close();
    }

    public ArrayList<Song> getAllSongs() {
        //TODO return records in Java objects
        ArrayList<Song> song = new ArrayList<>();
        String selectQuery = "SELECT " + COLUMN_ID + ", "
                + COLUMN_TITLE + ", "
                + COLUMN_SINGER + ", "
                + COLUMN_YEAR + ", "
                + COLUMN_STARS
                + " FROM " + TABLE_SONG;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String singer = cursor.getString(2);
                int year = cursor.getInt(3);
                int star = cursor.getInt(4);
                Song obj = new Song(title, singer, year, star);
                song.add(obj);
            } while (cursor.moveToNext());
        }
        return song;
    }

//    public ArrayList<String> getSongContent() {
//        //TODO return records in Strings
//
//        // Create an ArrayList that holds String objects
//        ArrayList<String> songs = new ArrayList<String>();
//        // Select all the notes' content
//        String selectQuery = "SELECT " + COLUMN_TITLE + " FROM " + TABLE_SONG;
//
//        // Get the instance of database to read
//        SQLiteDatabase db = this.getReadableDatabase();
//        // Run the SQL query and get back the Cursor object
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        // moveToFirst() moves to first row
//        if (cursor.moveToFirst()) {
//            // Loop while moveToNext() points to next row and returns true;
//            // moveToNext() returns false when no more next row to move to
//            do {
//
//                songs.add(cursor.getString(0));
//            } while (cursor.moveToNext());
//        }
//        // Close connection
//        cursor.close();
//        db.close();
//
//        return songs;
//    }
    public int updateSong(Song data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, data.getTitle());
        values.put(COLUMN_SINGER, data.getSingers());
        values.put(COLUMN_YEAR, data.getYear());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.get_id())};
        int result = db.update(TABLE_SONG, values, condition, args);
        db.close();
        return result;
    }

    public int deleteSong(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_SONG, condition, args);
        db.close();
        return result;
    }
}
