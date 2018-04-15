package com.example.nqh.ex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    int from,to=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinnerfrom=(Spinner)findViewById(R.id.spinnerFrom);
        Spinner spinnento=(Spinner)findViewById(R.id.spinnerTo);
        ArrayAdapter<CharSequence> adapterFrom = ArrayAdapter.createFromResource(this,
                R.array.From_array, android.R.layout.simple_spinner_item);

        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerfrom.setAdapter(adapterFrom);
        spinnento.setAdapter(adapterFrom);
        spinnerfrom.setOnItemSelectedListener(this);
        spinnento.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        if (parent.getId()==R.id.spinnerFrom)
        {
            from=position;
        }
        else if(parent.getId()==R.id.spinnerTo)
        {
            to=position;
        }

        Log.v("test","dap an"+from+"and"+to);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void convertmoney(View v){
        double usdtovnd=22.800;
        double usdtoeur=0.815048;
        double eurtousd=1.22685;
        double eurtovnd=27.700;
        double vndtousd=0.000044;
        double vndtoeur=0.000036;

        double money = 0;
        EditText value=(EditText)findViewById(R.id.inputvalue);
        TextView output=(TextView)findViewById(R.id.outputmoney);
        double input=Double.valueOf(value.getText().toString());




      // vnd->usd
        if(from==0 && to ==1){
            money=input*vndtousd;

        }
        //vnd->EUR
        else if(from==0 && to ==2 )
        {
            money=input*vndtoeur;

        }

        //usd->vnd
        else if(from==1 && to ==0 )
        {
            money=input*usdtovnd*1000;

        }
        //usd->eur
        else if(from==1 && to ==2 )
        {
            money=input*usdtoeur;

        }
        //eur->vnd
        else if(from==2 && to ==0 )
        {
            money=input*eurtovnd*1000;

        }
        //eur->usd
        else if(from==2 && to ==1 )
        {
            money=input*eurtousd;

        }
        else
        {
            money=input;
        }
        output.setText(Double.toString(money));
    }
}
