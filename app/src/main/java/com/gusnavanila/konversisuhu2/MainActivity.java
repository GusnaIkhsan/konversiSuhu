package com.gusnavanila.konversisuhu2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputan;
    Spinner pilihan_awal,pilihan_akhir;
    Button btnReset,btnKonversi;
    TextView hasilakhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputan = (EditText) findViewById(R.id.inputan);
        pilihan_awal = (Spinner) findViewById(R.id.pilihan_awal);
        pilihan_akhir = (Spinner) findViewById(R.id.pilihan_akhir);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnKonversi = (Button) findViewById(R.id.btnKonversi);
        hasilakhir = (TextView) findViewById(R.id.hasilakhir);

        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputan.getText().toString().equals("")){
                    double input;
                    int pilihan1,pilihan2;
                    String  derajat = "";
                    input = Double.parseDouble(inputan.getText().toString());
                    pilihan1 = pilihan_awal.getSelectedItemPosition();
                    pilihan2 = pilihan_akhir.getSelectedItemPosition();
                    switch (pilihan1){
                        case 0:
                            switch (pilihan2){
                                case 0:
                                    derajat = "C";
                                    break;
                                case 1:
                                    derajat = "K";
                                    input = input+273.15;
                                    break;
                                case 2:
                                    derajat = "F";
                                    input = input*1.8+32;
                                    break;
                                case 3:
                                    derajat = "R";
                                    input = input*0.8;
                                    break;
                                default:
                                    input = 0;
                                    break;
                            }
                            break;
                        case 1:
                            switch (pilihan2){
                                case 0:
                                    derajat = "C";
                                    input = input-273.15;
                                    break;
                                case 1:
                                    derajat = "K";
                                    break;
                                case 2:
                                    derajat = "F";
                                    input = ((input-273.15)*1.8)+32;
                                    break;
                                case 3:
                                    derajat = "R";
                                    input = (input-273.15)*0.8;
                                    break;
                                default:
                                    input = 0;
                                    break;
                            }
                            break;
                        case 2:
                            switch (pilihan2){
                                case 0:
                                    derajat = "C";
                                    input = ((input-32)*5)/9;
                                    break;
                                case 1:
                                    derajat = "K";
                                    input = (((input-32)*5)/9)+273.15;
                                    break;
                                case 2:
                                    derajat = "F";
                                    break;
                                case 3:
                                    derajat = "R";
                                    input = ((input-32)*4)/9;
                                    break;
                                default:
                                    input = 0;
                                    break;
                            }
                            break;
                        case 3:
                            switch (pilihan2){
                                case 0:
                                    derajat = "C";
                                    input = (input*5)/4;
                                    break;
                                case 1:
                                    derajat = "K";
                                    input = ((input*5)/4)+273.15;
                                    break;
                                case 2:
                                    derajat = "F";
                                    input = ((input*9)/4)+32;
                                    break;
                                case 3:
                                    derajat = "R";
                                    break;
                                default:
                                    input = 0;
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                    hasilakhir.setText(input+" "+derajat);
                }else{
                    hasilakhir.setText("Nilai Kosong");
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputan.setText("");
                hasilakhir.setText("Hasil");
            }
        });
    }
}
