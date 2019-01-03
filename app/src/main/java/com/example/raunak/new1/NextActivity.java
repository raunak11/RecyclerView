package com.example.raunak.new1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView name, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        name = findViewById(R.id.textView1);
        desc = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();
        String name1 = bundle.getString("name");
        String desc1 = bundle.getString("desc");

        name.setText(name1);
        desc.setText(desc1);
    }
}
