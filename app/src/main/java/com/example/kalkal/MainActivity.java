package com.example.kalkal;

import android.content.Intent;
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
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private BmrCalc bmr = new BmrCalc();
    private Button   mButton;
    private EditText uEdit,bEdit,tEdit;
    private TextView risiko, saran, kondisi, resultShow, numResult;
    private RadioGroup gender;
    private RadioButton pilihan;
    private String rKondisi;
    private String rSaran;
    private String rRisiko;
    private String nKondisi;
    private String nSaran;
    private String nRisiko;
    private String tKondisi;
    private String tSaran;
    private String tRisiko;
    private int selected,hasil2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bangun();
    }

    public void bangun(){
        mButton = findViewById(R.id.calcButton);
        uEdit   = findViewById(R.id.umurText);
        bEdit = findViewById(R.id.beratText);
        tEdit = findViewById(R.id.tinggiText);
        gender = findViewById(R.id.radioGroup);
        rKondisi=getString(R.string.r_kondisi);
        rSaran=getString(R.string.r_saran);
        rRisiko=getString(R.string.r_risiko);
        nKondisi=getString(R.string.n_kondisi);
        nSaran=getString(R.string.n_saran);
        nRisiko=getString(R.string.n_risiko);
        tKondisi=getString(R.string.t_kondisi);
        tSaran=getString(R.string.t_saran);
        tRisiko=getString(R.string.t_risiko);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_test, menu);

        return true; }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                return true;
            case R.id.item2:
                setContentView(R.layout.layout_info);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void hasilPopUp(String risiko, String kondisi, String saran, int bmr, String resultNtr){
        dialogBuilder = new AlertDialog.Builder(this);
        final View hasilPop=getLayoutInflater().inflate(R.layout.result_calc, null);
        this.risiko = (TextView)hasilPop.findViewById(R.id.risikoText);
        this.saran = (TextView)hasilPop.findViewById(R.id.saranText);
        this.kondisi = (TextView)hasilPop.findViewById(R.id.kondisiText);
        this.resultShow = (TextView)hasilPop.findViewById(R.id.resultShow);
        this.numResult = (TextView)hasilPop.findViewById(R.id.numResult);
        this.risiko.setText(risiko);
        this.saran.setText(saran);
        this.kondisi.setText(kondisi);
        this.resultShow.setText(resultNtr);
        this.numResult.setText(String.valueOf(bmr));

        dialogBuilder.setView(hasilPop);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void hitung(View view) {
        if (uEdit.getText().toString().trim().length() == 0 ||
                tEdit.getText().toString().trim().length() == 0 ||
                bEdit.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Harus Di Isi Semuanya Ya \nSalam Senna dan Waldo", Toast.LENGTH_SHORT).show();
        }
        else {
            bmr.setAge(Integer.parseInt(uEdit.getText().toString()));
            bmr.setBerat(Integer.parseInt(bEdit.getText().toString()));
            bmr.setTinggi(Integer.parseInt(tEdit.getText().toString()));
            selected = gender.getCheckedRadioButtonId();
            pilihan = (RadioButton) findViewById(selected);
            if (pilihan.getText().equals("Pria")) {
                hasil2 = bmr.rumusDuaMan();
            } else {
                hasil2 = bmr.rumusDuaWoman();
            }
            if (hasil2 < 1400) {
                hasilPopUp(rRisiko, rKondisi, rSaran, hasil2, "Rendah");
            } else if (hasil2 < 1600) {
                hasilPopUp(nRisiko, nKondisi, nSaran, hasil2, "Normal");
            } else {
                hasilPopUp(tRisiko, tKondisi, tSaran, hasil2, "Tinggi");
            }
        }
    }
}