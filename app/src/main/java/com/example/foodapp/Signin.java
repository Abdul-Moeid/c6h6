package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodapp.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signin extends AppCompatActivity {
    EditText edtphn, edtpass;
    Button btnsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        edtpass = this.<EditText>findViewById(R.id.edtpass);
        edtphn = this.<EditText>findViewById(R.id.edtphn);
        btnsignin = this.<Button>findViewById(R.id.btnSigIn);

        //firbase init

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(Signin.this);
                mDialog.setMessage("Please wait....");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // Check user is exist or not
                        if (dataSnapshot.child(edtphn.getText().toString()).exists()) {
                            //get user information
                            mDialog.dismiss();
                            User user = dataSnapshot.child(edtphn.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(edtpass.getText().toString())) {
                                Toast.makeText(Signin.this, "sign in sucessfully !", Toast.LENGTH_SHORT).show();
                                Intent menue = new Intent(Signin.this,Menue.class);
                                startActivity(menue);
                            } else {
                                Toast.makeText(Signin.this, "Wrong password !", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(Signin.this, "User doesn't exist", Toast.LENGTH_SHORT).show();}
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
