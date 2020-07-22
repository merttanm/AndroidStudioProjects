package com.prevezene.sqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.textclassifier.SelectionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase database=  this.openOrCreateDatabase( "loginekranı", MODE_PRIVATE, null);
            // bu bana veri tabanı açtı
            database.execSQL("CREATE TABLE IF NOT EXISTS loginekranı (name VARCHAR, number INT)");
            //TABLO OLUŞTURDUM
            database.execSQL(" INSERT INTO loginekranı (name, number) VALUES ('MERT', 05422495220) ");
            String q="SELECT * FROM loginekranı";

            Cursor cursor = database.rawQuery(q, null);

            int nameIx = cursor.getColumnIndex();

        } catch (Exception e){

        e.printStackTrace();



        }
    }
}