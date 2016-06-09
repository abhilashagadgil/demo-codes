package com.example.abgadgil.dynamicviewlab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;


/**
 * Created by abgadgil on 6/9/2016.
 */
public class ListGridAdapter extends BaseAdapter {


    private int mMaxItems;
    private LayoutInflater inflator;
    private AdapterMode mode;

    public ListGridAdapter(LayoutInflater layoutInflater, AdapterMode list, int maxListItems) {
        this.mMaxItems = maxListItems;
        this.inflator = layoutInflater;
        this.mode = list;
    }


    @Override
    public int getCount() {

        return mMaxItems;
    }

    @Override
    public Object getItem(int position) {
        return new Integer(position + 1);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        boolean isList = mode == AdapterMode.LIST;
        boolean isEvenPos = position % 2 == 0;
        if (convertView == null) {
            convertView = inflator.inflate(isList ? R.layout.list_item : R.layout.grid_item, parent, false);
        }
        ImageView  image = (ImageView) convertView.findViewById(R.id.imageView);
        int resourceId;
        if(isList){
            resourceId = isEvenPos?android.R.drawable.btn_dialog:android.R.drawable.btn_minus;
        }
        else{
            resourceId = isEvenPos?android.R.drawable.btn_dialog:android.R.drawable.btn_minus;
        }
        image.setImageResource(resourceId);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(String.valueOf(position+1));
        return convertView;
    }

    public enum AdapterMode {LIST, GRID}
}