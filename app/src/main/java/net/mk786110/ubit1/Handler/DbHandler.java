package net.mk786110.ubit1.Handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import net.mk786110.ubit1.entity.Profile;

import java.util.ArrayList;

/**
 * Created by mkumail on 10/20/16.
 */
public class DbHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProQuestSQLite";
    private static final String TABLE_NAME = "Profile";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_HOBBY = "hobby";
    private static final String KEY_DETAIL = "detail";
    private static final String KEY_DOB = "dob";
    private static final String KEY_IMAGE = "image";


    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_PROFILE_TABLE = "CREATE TABLE " + TABLE_NAME + "( "
                + KEY_ID + " INTEGER PRIMARY KEY NOT NULL, "
                + KEY_NAME + " TEXT NOT NULL , "
                + KEY_PHONE + " TEXT NOT NULL , "
                + KEY_EMAIL + " TEXT NOT NULL UNIQUE , "
                + KEY_GENDER + " TEXT  , "
                + KEY_HOBBY + " TEXT  , "
                + KEY_DETAIL + " TEXT  , "
                + KEY_DOB + " TEXT  , "
                + KEY_IMAGE + " TEXT  "
                + ")";
        sqLiteDatabase.execSQL(CREATE_PROFILE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long registerProfile(Profile profile) {
        long id;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profile.getName());
        values.put(KEY_PHONE, profile.getPhone());
        values.put(KEY_EMAIL, profile.getEmail());
        values.put(KEY_GENDER, profile.getGender());
        values.put(KEY_HOBBY, profile.getHobby());
        values.put(KEY_DETAIL, profile.getAboutme());
        values.put(KEY_DOB, profile.getDob());
        values.put(KEY_IMAGE, "image");

        try {
            id = db.insert(TABLE_NAME, null, values);
            db.close();
            return id;
        } catch (Exception ex) {
            return -1;
        }
    }

    public void deleteProfile(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Delete from " +TABLE_NAME+ " Where "+ KEY_ID + " = " + id;
        Log.i("query", " query: "+query);
        db.execSQL(query);
        db.close();
    }
    public void updateProfile(Profile profile) {

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, profile.getName());
        values.put(KEY_PHONE, profile.getPhone());
        values.put(KEY_EMAIL, profile.getEmail());
        values.put(KEY_GENDER, profile.getGender());
        values.put(KEY_HOBBY, profile.getHobby());
        values.put(KEY_DETAIL, profile.getName());
        values.put(KEY_DOB, profile.getName());
        values.put(KEY_IMAGE, "image");
        db.update(TABLE_NAME, values, KEY_ID + " =? ", new String[]{String.valueOf(profile.getId())});
        db.close();

    }

    public ArrayList<Profile> getAllProfile() {
        ArrayList<Profile> profileList = new ArrayList<>();
        String selectQuery = "Select * from " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToNext()) {

            do {
                Profile p = new Profile();
                p.setId(cursor.getString(0));
                p.setName(cursor.getString(1));
                p.setPhone(cursor.getString(2));
                p.setEmail(cursor.getString(3));
                p.setGender(cursor.getString(4));
                p.setHobby(cursor.getString(5));
                p.setAboutme(cursor.getString(6));
                p.setDob(cursor.getString(6));

                profileList.add(p);
            }
            while (cursor.moveToNext());
        }

        return profileList;
    }
}
