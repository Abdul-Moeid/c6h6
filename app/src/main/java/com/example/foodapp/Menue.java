package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.example.foodapp.R.id.ben1;

public class Menue extends AppCompatActivity {
    ImageView ben,ind,chin,drk,fast,des;
    Button mod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);
         ben= this.<ImageView>findViewById(ben1);
         ind= this.<ImageView>findViewById(R.id.ind1);
         chin= this.<ImageView>findViewById(R.id.chin2);
         drk= this.<ImageView>findViewById(R.id.drn1);
         fast= this.<ImageView>findViewById(R.id.fst1);
         des= this.<ImageView>findViewById(R.id.des1);
         mod = this.<Button>findViewById(R.id.button);
        ben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(Menue.this,foodlist.class);
                signin.putExtra("key","Bengali");
                startActivity(signin);

            }
        });
        ind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(Menue.this,foodlist.class);
                signin.putExtra("key","Indian");
                startActivity(signin);

            }
        });
        chin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(Menue.this,foodlist.class);
                signin.putExtra("key","Chineses");
                startActivity(signin);

            }
        });
        drk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(Menue.this,foodlist.class);
                signin.putExtra("key","Drinks");
                startActivity(signin);

            }
        });
        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(Menue.this,foodlist.class);
                signin.putExtra("key","Fast food");
                startActivity(signin);

            }
        });
        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(Menue.this,foodlist.class);
                signin.putExtra("key","Dessert");
                startActivity(signin);

            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menue.this,Modify.class);
                startActivity(intent);
            }
        });
    }
}
