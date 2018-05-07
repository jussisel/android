package com.example.anttieek.testi;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button mChange;
    DecimalFormat df = new DecimalFormat("#.##");
    EditText kMInput;
    RadioButton one;
    RadioButton three;
    RadioButton five;
    RadioButton six;
    String p = "0";
    TextView taxi;
    TextView fees;
    Taksi onniTaksi = new Taksi(3.5, 2.0, 2.3, 2.6, 3.0);
    Taksi kovanen = new Taksi(6.1, 1.8, 2.0, 2.3, 2.6);
    Taksi virtanen = new Taksi(10.6, 1.4, 1.7, 2.0, 2.4);
    

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        kMInput = v.findViewById(R.id.kMInput);
        //USDInput = v.findViewById(R.id.USDInput);
        one = v.findViewById(R.id.radioButton);
        three = v.findViewById(R.id.radioButton2);
        five = v.findViewById(R.id.radioButton3);
        six = v.findViewById(R.id.radioButton4);
        fees = v.findViewById(R.id.fees);
        taxi = v.findViewById(R.id.taxi);


        return v;
    }

    public void onCalculate(View view) {
        //Toast.makeText(getActivity(), "ready to calculate", Toast.LENGTH_LONG).show();
        if (kMInput.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Ilmoita kilometrit", Toast.LENGTH_LONG).show();


        } else if (one.isChecked()){

            Double onniTot = onniTaksi.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * onniTaksi.getOneOrTwo());
            Double kovanenTot = kovanen.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * kovanen.getOneOrTwo());
            Double virtanenTot = virtanen.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * virtanen.getOneOrTwo());

            showResults(onniTot, kovanenTot, virtanenTot);


        } else if(three.isChecked()){

            Double onniTot = onniTaksi.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * onniTaksi.getThreeOrFour());
            Double kovanenTot = kovanen.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * kovanen.getThreeOrFour());
            Double virtanenTot = virtanen.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * virtanen.getThreeOrFour());

            showResults(onniTot, kovanenTot, virtanenTot);

        } else if (five.isChecked()){

            Double onniTot = onniTaksi.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * onniTaksi.getFiveOrSix());
            Double kovanenTot = kovanen.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * kovanen.getFiveOrSix());
            Double virtanenTot = virtanen.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * virtanen.getFiveOrSix());

            showResults(onniTot, kovanenTot, virtanenTot);

        } else if (six.isChecked()){

            Double onniTot = onniTaksi.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * onniTaksi.getSixOrMore());
            Double kovanenTot = kovanen.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * kovanen.getSixOrMore());
            Double virtanenTot = virtanen.getBaseFee() + (Integer.parseInt(kMInput.getText().toString()) * virtanen.getSixOrMore());

            showResults(onniTot, kovanenTot, virtanenTot);

        } else {
            Toast.makeText(getActivity(), "Ilmoita henkilömäärä!", Toast.LENGTH_LONG).show();
        }

    }

    public void onChange(Intent intent){
        String p = intent.getStringExtra("pos");
        Toast.makeText(getActivity(), p, Toast.LENGTH_LONG).show();

    }

    private void showResults(double onni, double kovanen, double virtanen){
        //onni = Double.valueOf(df.format(onni));
        //kovanen = Double.valueOf(df.format(kovanen));
        //virtanen = Double.valueOf(df.format(virtanen));
        taxi.clearComposingText();
        fees.clearComposingText();
        taxi.setText("Taksi\n" +
                "OnniTaksi\n" +
                "Kovanen\n" +
                "Virtanen");
        fees.setText("Hinta\n" +
                String.format("%.2f", onni)+ "\n" +
                String.format("%.2f", kovanen) + "\n" +
                String.format("%.2f", virtanen));

    }
}
