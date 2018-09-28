package com.medi.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main4Activity extends AppCompatActivity {

    ImageView imgview;
    TextView textEmail,textName;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mAuth = FirebaseAuth.getInstance();

        imgview = findViewById(R.id.image);
        textName=findViewById(R.id.textviewname);

        textEmail = findViewById(R.id.textviewemail);

        FirebaseUser user = mAuth.getCurrentUser();
        Glide.with(this)
                .load(user.getPhotoUrl())
                .into(imgview);

        textName.setText(user.getDisplayName());
        textEmail.setText(user.getEmail());

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
