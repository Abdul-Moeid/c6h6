package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp.Model.food;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Modify extends AppCompatActivity {
    TextView name, price, category,dcat,category_name,dcatnm;
    Button add, update, delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        name = this.<TextView>findViewById(R.id.editText1);
        price = this.<TextView>findViewById(R.id.editText2);
        category = this.<TextView>findViewById(R.id.editText3);
        category_name= this.<TextView>findViewById(R.id.editText6);
        dcatnm = this.<TextView>findViewById(R.id.editText);
        dcat = this.<TextView>findViewById(R.id.editText4);
        add = this.<Button>findViewById(R.id.button2);
        update = this.<Button>findViewById(R.id.button1);
        delete = this.<Button>findViewById(R.id.button3);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_cat = database.getReference("Bengali");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference table_cat = database.getReference(category_name.getText().toString());
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());//getting current time
                food  item = new food(name.getText().toString(),price.getText().toString(),timeStamp);
                table_cat.child(timeStamp).setValue(item);
                Toast.makeText(Modify.this, "Item is added successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference table_cat = database.getReference(category_name.getText().toString());
                food  item = new food(name.getText().toString(),price.getText().toString(),category.getText().toString());
                table_cat.child(category.getText().toString()).setValue(item);
                Toast.makeText(Modify.this, "Item is updated successfully!", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference table_cat = database.getReference(dcatnm.getText().toString());
                table_cat.child(dcat.getText().toString()).removeValue();
                Toast.makeText(Modify.this, "Item is deleted successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
