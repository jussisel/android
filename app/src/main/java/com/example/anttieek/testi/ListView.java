package com.example.anttieek.testi;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ArrayAdapter;

/**
 * Created by anttieek on 21.3.2018.
 */

public class ListView extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Now create a new list adapter bound to the cursor.

        String[] values = new String[] { "USD", "SEK", "DKK",
                "GBP", "HUF"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        // Bind to our new adapter.
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(android.widget.ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("pos", String.valueOf(position));
       // startActivity(i);

        setResult(RESULT_OK, i);
        finish(); // finish the activity
    }


}
