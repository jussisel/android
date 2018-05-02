package com.example.anttieek.testi;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button mChange;
    EditText EuroInput;
    EditText USDInput;
    String p = "0";
    TextView tv;
    Double upper = 0.81;
    Double lower = 1.23;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        EuroInput = v.findViewById(R.id.EuroInput);
        USDInput = v.findViewById(R.id.USDInput);
        tv = v.findViewById(R.id.textView2);


        return v;
    }

    public void onCalculate(View view, Intent intent){
        //Toast.makeText(getActivity(), "ready to calculate", Toast.LENGTH_LONG).show();

        if (EuroInput.getText().toString().isEmpty() && !USDInput.getText().toString().isEmpty()){
            Double usd = Double.parseDouble(USDInput.getText().toString());
            EuroInput.setText(Double.toString(usd * upper));
        } else if(USDInput.getText().toString().isEmpty() && !EuroInput.getText().toString().isEmpty()){
            Double euros = Double.parseDouble(EuroInput.getText().toString());
            USDInput.setText(Double.toString(euros * lower + 5.90));
        }

    }

    public void onChange(Intent intent){
        String p = intent.getStringExtra("pos");
        Toast.makeText(getActivity(), p, Toast.LENGTH_LONG).show();
        switch (p) {
            case "0":
                tv.setText("Kovanen");
                //upper = 0.81;
                lower = 1.60;
                break;
            case "1":
                tv.setText("Vihavaisen taksi");
                //upper = 0.01;
                lower = 1.60;
                break;
            case "2":
                tv.setText("Kajoni");
                //upper = 0.13;
                lower = 1.60;
                break;
            case "3":
                tv.setText("Taksiyritys Kim Fallenius");
               // upper = 1.12;
                lower = 1.60;
                break;
            case "4":
                tv.setText("Mankkaan taksi");
                //upper = 0.003;
                lower = 1.60;
                break;
        }
    }
}
