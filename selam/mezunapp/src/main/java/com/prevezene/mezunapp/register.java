package com.prevezene.mezunapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prevezene.mezunapp.ui.login.DatabaseHelper;

public class register extends AppCompatActivity {
    DatabaseHelper sqLiteDatabase;
    Button btn_giriş,btn_kaydet;
    EditText edt_kullanici,edt_kullaniciadi,edt_mail,edt_sifre;

/*
    public void btn_anasayfaya(){
        btn_giriş=(Button)findViewById(R.id.btn_giriş);
        btn_giriş.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris= new Intent(register.this,login_frm.class);
                startActivity(giris);
            }
        });
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       // edt_kullanici=(EditText)findViewById(R.id.edt_kullaniciadi); ŞİMDİLİK DURSUN
        sqLiteDatabase= new DatabaseHelper(this);
        edt_kullanici=(EditText)findViewById(R.id.edt_kullanici);
        edt_kullaniciadi=(EditText)findViewById(R.id.edt_kullaniciadi);
        edt_mail=(EditText)findViewById(R.id.edt_mail);
        edt_sifre=(EditText)findViewById(R.id.edt_sifre);
        btn_kaydet=(Button)findViewById(R.id.btn_kaydet);
        AddData();
        /*btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  satir1= edt_kullanici.getText().toString();
                String  satir2= edt_kullaniciadi.getText().toString();
                String  satir3= edt_mail.getText().toString();
                String  satir4= edt_sifre.getText().toString();
                /*    if(satir1.equals("") ||  satir2.equals("") || satir3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty", Toast.LENGTH_SHORT).show();

                }

                    else{
                        if (satir2.equals(satir3)) {
                            Boolean chk_email = sqLiteDatabase.chk_email(satir1);
                        if (chk_email==true){
                            Boolean insert =sqLiteDatabase.insert(satir1,satir2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"register succesful", Toast.LENGTH_SHORT).show();

                            }
                        }

                        else{
                            Toast.makeText(getApplicationContext(),"Email already exist" ,  Toast.LENGTH_SHORT).show();

                        }
                        }

                }
            }
        }

        );*/
       // btn_anasayfaya();


    }


    public  void AddData() {
       // btn_kaydet=(Button)findViewById(R.id.btn_kaydet);
        btn_kaydet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = sqLiteDatabase.insert(edt_kullanici.getText().toString(),
                                edt_kullaniciadi.getText().toString(),
                                edt_mail.getText().toString(),
                                edt_sifre.getText().toString());
                        if(isInserted == true) {
                            Toast.makeText(register.this, "kayıt tamam", Toast.LENGTH_LONG).show();

                             Intent giris= new Intent(register.this,login_frm.class);
                             startActivity(giris);
                        }
                        else
                            Toast.makeText(register.this,"yüklenmiyor ",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }







}