package com.example.kalkal;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    BmrCalc bmr = new BmrCalc();
    Button   mButton;
    EditText uEdit,bEdit,tEdit;
    TextView dummy;
    RadioGroup gender;
    RadioButton pilihan;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.calcButton);
        uEdit   = (EditText)findViewById(R.id.umurText);
        bEdit = (EditText)findViewById(R.id.beratText);
        tEdit = (EditText)findViewById(R.id.tinggiText);
        gender = (RadioGroup)findViewById(R.id.radioGroup);
        dummy = (TextView)findViewById(R.id.dummy);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_test, menu);

        return super.onCreateOptionsMenu(menu); }

    public void homeButton(MenuItem item) {

        setContentView(R.layout.activity_main);
    }

    public void infoButton(MenuItem item) {

        setContentView(R.layout.layout_info);
    }

    public void hitung(View view) {
        bmr.setAge(Integer.parseInt(uEdit.getText().toString()));
        bmr.setBerat(Integer.parseInt(bEdit.getText().toString()));
        bmr.setTinggi(Integer.parseInt(tEdit.getText().toString()));
        int selected = gender.getCheckedRadioButtonId();
        pilihan = (RadioButton)findViewById(selected);
        if (pilihan.getText().equals("Pria")){
            dummy.setText(bmr.rumusDuaMan());
        }
        else {
            dummy.setText(bmr.rumusDuaWoman());
        }

    }

}