package com.example.anttieek.testi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int ACTIVITY_SELECT=0; // id for activity
    private MainActivityFragment fragment;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fragment = (MainActivityFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        //intent = getIntent();
        //if (getIntent().getStringExtra("pos") != null){
         //   fragment.onChange(intent);
        //}


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_list) {
            Intent i = new Intent( this, ListView.class);
            startActivityForResult(i, ACTIVITY_SELECT);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCalculate(View view){
        if (fragment != null){
            fragment.onCalculate(view, intent);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode==ACTIVITY_SELECT)
            if (resultCode==RESULT_OK) {
                Toast.makeText(this, "Selection made", Toast.LENGTH_SHORT).show();
                fragment.onChange(intent);
            }
    }
}
