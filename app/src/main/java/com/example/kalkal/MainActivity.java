package com.example.kalkal;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_test, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void homeButton(MenuItem item) {
        setContentView(R.layout.activity_main);
    }

    public void infoButton(MenuItem item) {
        setContentView(R.layout.layout_info);
    }
}