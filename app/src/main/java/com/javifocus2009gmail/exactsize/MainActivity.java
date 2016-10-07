package com.javifocus2009gmail.exactsize;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNumPieces;
    private ListView listView;
    private ArrayList<LineMeasure> linesMeasures;
    private EditText etSizeLarge;
    private LinesMeasureAdapter adapter;
    private AlertDialog.Builder builder;
    private EditText et1;
    private EditText et2;
    private Button btn;

    private int numPieces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumPieces = (EditText) findViewById(R.id.etNumPieces);
        etSizeLarge = (EditText) findViewById(R.id.etSizeLarge);
        final Button btn1 = (Button) findViewById(R.id.btnAceptPieces);
        listView = (ListView) findViewById(R.id.lVDinamicsInputs);
        et1 =(EditText)findViewById(R.id.etQuanty);
        et2 =(EditText)findViewById(R.id.etSize);
//        btn = (Button) findViewById(R.id.btnRemove);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!etNumPieces.getText().toString().equals("") && Integer.parseInt(etNumPieces.getText().toString()) > 2){
                    numPieces = Integer.parseInt(etNumPieces.getText().toString());
                    if(!etSizeLarge.getText().toString().equals("") && Integer.parseInt(etSizeLarge.getText().toString()) > 20){
//                        Toast.makeText(MainActivity.this,
//                                String.valueOf("Entra en la condicion"), Toast.LENGTH_SHORT).show();
                        linesMeasures = new ArrayList<>();
                        addLines(numPieces);
                        generateInputs();
                    }else{
                        showAlertDialog("Debe poner un largo superior a 20 (medida en milímetros)");
                    }
                }else{
                    showAlertDialog("Debe introducir al menos 2 piezas diferentes");
                }
            }
        });
    }

    private void showAlertDialog(String string) {
        builder.setMessage(string)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                });
        builder.create();
        builder.show();
    }

    private void generateInputs() {
        adapter = new LinesMeasureAdapter(this, linesMeasures);
        listView.setAdapter(adapter);
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    private void addLines(int numPieces) {

        for (int i=0;i<numPieces;i++){
            linesMeasures.add(new LineMeasure());
        }
    }

}
