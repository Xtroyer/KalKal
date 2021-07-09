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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private BmrCalc bmr = new BmrCalc();
    private Button   mButton;
    private EditText uEdit,bEdit,tEdit;
    private TextView dummy, dummy2, risiko, saran, kondisi, resultShow, numResult;
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
        dummy2 = (TextView)findViewById(R.id.dummy2);
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

        return super.onCreateOptionsMenu(menu); }

    //Pilih kalkulator buat ke layout 1
    public void homeButton(MenuItem item) {
        setContentView(R.layout.activity_main);
    }

    //Pilih Informasi BMR buat ke layour 2
    public void infoButton(MenuItem item) {
        setContentView(R.layout.layout_info);
    }
    public void hasilPopUp(String risiko, String kondisi, String saran, String bmr, String resultNtr){
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
        this.numResult.setText(bmr);

        dialogBuilder.setView(hasilPop);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void hitung(View view) {
        bmr.setAge(Integer.parseInt(uEdit.getText().toString()));
        bmr.setBerat(Integer.parseInt(bEdit.getText().toString()));
        bmr.setTinggi(Integer.parseInt(tEdit.getText().toString()));
        int selected = gender.getCheckedRadioButtonId();
        pilihan = (RadioButton) findViewById(selected);
        if (pilihan.getText().equals("Pria")) {
            dummy.setText(bmr.rumusDuaMan());
        } else {
            dummy.setText(bmr.rumusDuaWoman());
        }
        //Buat teks kondisi, risiko, dan saran
        double hasil2 = Double.parseDouble(String.valueOf(dummy.getText()));
        if (hasil2 < 1400) {
            dummy2.setText("Rendah");
            hasilPopUp(rRisiko,rKondisi,rSaran,String.valueOf(dummy.getText()),"Rendah");
        } else if (hasil2 <1600){
            dummy2.setText("Normal");
            hasilPopUp(nRisiko,nKondisi,nSaran, String.valueOf(dummy.getText()),"Normal");
        }
        else {
            dummy2.setText("Tinggi");
            hasilPopUp(tRisiko,tKondisi,tSaran, String.valueOf(dummy.getText()),"Tinggi");
        }
    }
}