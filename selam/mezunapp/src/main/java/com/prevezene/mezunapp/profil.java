package com.prevezene.mezunapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.prevezene.mezunapp.ui.login.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class profil extends AppCompatActivity {
    Button buton_geri;
    //u userDbhelper;
    DatabaseHelper sqLiteDatabase;
    EditText k_adi, adi, okulno, sifre;
    public void anasayfayadon(){
        buton_geri=(Button)findViewById(R.id.button_geri);
        buton_geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy= new Intent(profil.this,MainActivity.class);
                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        anasayfayadon();
        sqLiteDatabase =new DatabaseHelper(this);
        viewAll();



        //List<user> posts = db.getAllBeneficiary();
/*
        db =new DatabaseHelper(this);
        Cursor res = db.getAllData();
        if(res.getCount()==0){

            return;

        }*/
      /* StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID :"+ res.getString(0));
            buffer.append("NAME :"+ res.getString(1));
            buffer.append("EMAIL :"+ res.getString(2));
            buffer.append("PASSWORD :"+ res.getString(3));
        }*/

    }

    private void viewAll() {
        k_adi= (EditText)findViewById(R.id.txt_kullaniciadigoster);
        adi= (EditText)findViewById(R.id.txt_adigoster);
        okulno= (EditText)findViewById(R.id.txt_okulnogoster);
        sifre= (EditText)findViewById(R.id.txt_şifregoster);
        Cursor res = sqLiteDatabase.getAllData();
        if (res.moveToFirst()) {
            int kadi = res.getInt(0);
            String aadi = res.getString(1);
            String  no = res.getString(2);
            String  sifresi = res.getString(3);

             k_adi.setId(kadi);
             adi.setText(aadi);
            okulno.setText(no);
            sifre.setText(sifresi);

        }
    }

/*
    public void viewAll(View view) {


    }*/
}