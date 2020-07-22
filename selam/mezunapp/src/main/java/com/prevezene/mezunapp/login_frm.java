package com.prevezene.mezunapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_frm extends AppCompatActivity {
     Button button3;
    public void init(){
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy= new Intent(login_frm.this,register.class);
                startActivity(toy);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();


        /*
     public void  button3 final View view = (View) {
                Intent intent= new Intent(this, register.class);

        }
*/
    }
}
