package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class Signup extends AppCompatActivity {
    EditText edtphn, edtnm, edtpass;
    Button btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtnm = this.<EditText>findViewById(R.id.edtname);
        edtpass = this.<EditText>findViewById(R.id.edtpass);
        edtphn = this.<EditText>findViewById(R.id.edtphn);
        btnsignup = this.<Button>findViewById(R.id.btnSignUp);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

       btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(Signup.this);
                mDialog.setMessage("Please wait....");
                mDialog.show();
                Toast.makeText(Signup.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // check if already exist
                        if (dataSnapshot.child(edtphn.getText().toString()).exists()) {
                            //get user information
                            mDialog.dismiss();
                            Toast.makeText(Signup.this,"User already exsit",Toast.LENGTH_SHORT).show();
                        }

                        else {
                            mDialog.dismiss();
                            User user = new User(edtnm.getText().toString(), edtpass.getText().toString());
                            table_user.child(edtphn.getText().toString()).setValue(user);
                            Toast.makeText(Signup.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
