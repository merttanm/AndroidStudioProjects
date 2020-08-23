package com.prevezene.mezunapp.ui.login;


import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.content.ContentValues.*;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="login.sqLiteDatabase";
    public static final String TABLE_NAME="user";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="EMAIL";
    public static final String COL_4="PASSWORD";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,  1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY  AUTOINCREMENT, NAME TEXT,EMAIL TEXT,PASSWORD TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(" drop table if exists "+TABLE_NAME );
        onCreate(sqLiteDatabase);
    }
 /*   public boolean create(Account account){
boolean result=true;
        try{
            SQLiteDatabase sqLiteDatabase2=this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
        /*contentValues.put("EMAIL", edt_mail );
        contentValues.put("PASSWORD", edt_sifre );

            contentValues.put(COL_1,account.getClass());
            contentValues.put(COL_2,account.);
            contentValues.put(COL_3,edt_mail);
            contentValues.put(COL_4,edt_sifre);


        }


    }*/


    ////// insert table
    public boolean insert(String edt_mail, String edt_sifre,String edt_kullanici, String edt_kullaniciadi ){


        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        /*contentValues.put("EMAIL", edt_mail );
        contentValues.put("PASSWORD", edt_sifre );
        */
        contentValues.put(COL_1,edt_kullanici);
        contentValues.put(COL_2,edt_kullaniciadi);
        contentValues.put(COL_3,edt_mail);
        contentValues.put(COL_4,edt_sifre);

            long result= sqLiteDatabase.insert(TABLE_NAME,null, contentValues);
            if (result== -1)
                return
                        false;
            else
                return
                        true;
        /*public String getLoginData(String edt_mail, String edt_sifre)
        {
            SQLiteDatabase sql=this.getReadableDatabase();
            String query=" select count(*) from "+TABLE_NAME+" where email ='"+COL_3+"' and password='"+COL_4+"'";
            Cursor cursor =sql.rawQuery(query,null);
            cursor.moveToFirst();
            String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
            return count;

        }*/

    }
    public Boolean emailpassword(String edt_mail, String edt_sifre){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor =db.rawQuery("select * from user where EMAIL=? and PASSWORD=?", new String[]{edt_mail, edt_sifre});

            if(cursor.getCount()>0) return true;
            else return false;

    }



    /*
    public Account loginAct(String edt_mail, String edt_sifre){
        Account account=null;
        try {
          SQLiteDatabase  sqLiteDatabase=getReadableDatabase();

            Cursor cursor=sqLiteDatabase.rawQuery("select * from "+ TABLE_NAME + " where EMAIL = ? and PASSWORD = ?", new String[]{edt_mail, edt_sifre});
                if(cursor.moveToFirst()){
                    account = new Account();



                }

        }
        catch (Exception e){
            account =null;
        }

        return account;



    }*/

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }



    /*
    public boolean updateData(String edt_mail, String edt_sifre,String edt_kullanici, String edt_kullaniciadi ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,edt_kullanici);
        contentValues.put(COL_2,edt_kullaniciadi);
        contentValues.put(COL_3,edt_mail);
        contentValues.put(COL_4,edt_sifre);
        sqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?",new String[] { edt_kullaniciadi });
        return true;
    }

   /* public Integer deleteData (String edt_kullanici) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, "İD = ?",new String[] {edt_kullanici});
    }



    /*
    public Boolean chk_email(String edt_mail ){
        SQLiteDatabase  sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from user where email=?", new String[]{edt_mail});
        if(cursor.getCount()>0) return false;
        else return true;


    }*/

    /*
  public static final String TAG="DatabaseHelper";

    public static final String TABLE_NAME="People_table"  ;
    public static final String col1="İD";
    public static final String col2="name";
    public DatabaseHelper(Context context){
super(context, TABLE_NAME, null,1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {



        String createTable="CREATE TABLE" + TABLE_NAME +"(ID INTEGER PRİMARY KEY AUTOINCREMEN," +
                col2 +"TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
*/
}