package com.example.abgadgil.dynamicviewlab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * Created by abgadgil on 6/9/2016.
 */
public class GridActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        int i = getIntent().getExtras().getInt(Intent.EXTRA_UID);
        GridView gridView= (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ListGridAdapter(getLayoutInflater(), ListGridAdapter.AdapterMode.GRID,i));
    }
}
