package com.example.abgadgil.dynamicviewlab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListActivity extends Activity {

    private static final int MAX_LIST_ITEMS = 30 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new ListGridAdapter(getLayoutInflater(), ListGridAdapter.AdapterMode.LIST,MAX_LIST_ITEMS));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent gridIntent = new Intent(view.getContext(),GridActivity.class);
                gridIntent.putExtra(Intent.EXTRA_UID, (int) parent.getAdapter().getItem(position));
                ListActivity.this.startActivity(gridIntent);

            }
        });

    }
}
