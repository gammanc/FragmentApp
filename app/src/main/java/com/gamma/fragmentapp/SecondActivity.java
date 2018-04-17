package com.gamma.fragmentapp;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView stone_name, stone_location, stone_description;
    ImageView stone_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        stone_name = findViewById(R.id.stone_name);
        stone_location = findViewById(R.id.stone_location);
        stone_description = findViewById(R.id.stone_description);
        stone_image = findViewById(R.id.stone_image);

        Bundle b = getIntent().getExtras();
        InfinityStone stone;

        if(b != null){
            stone = b.getParcelable("STONE");
            stone_image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), stone.getImage()));
            stone_name.setText(stone.getName());
            stone_location.setText(getString(R.string.txt_location) + " " +stone.getLocation());
            stone_description.setText(stone.getDescription());
        }
    }


}
