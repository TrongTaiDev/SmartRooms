package dev.trongtai.smartrooms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dev.trongtai.smartrooms.R;
import dev.trongtai.smartrooms.classes.Persion;

/**
 * Created by HK on 27/03/2018.
 */

public class TestAdapter extends BaseAdapter {
    int currposition = - 1;
    private class view_holder{
        private TextView labID;
        private TextView labName;
        private TextView labID2;
        private TextView labName2;

        public void init(View view){
            labID = view.findViewById(R.id.id);
            labName = view.findViewById(R.id.name);
            labID2 = view.findViewById(R.id.id2);
            labName2 = view.findViewById(R.id.name2);
        }

        public void bind(int position)
        {
            Persion p1 = ds.get(position);
            Persion p2 = ds.get(position + 1);

            labID.setText(p1.getId());
            labName.setText(p1.getName());
            labID2.setText(p2.getId());
            labName2.setText(p2.getName());

            currposition = position + 1;
        }
    }
    private Context context;
    private List<Persion> ds;

    public TestAdapter(Context context){
        this.context = context;
        ds = new ArrayList<>();
//        ds.add(new Persion("1", "Tài"));
//        ds.add(new Persion("2", "Tài"));
//        ds.add(new Persion("3", "Tài"));
//        ds.add(new Persion("4", "Tài"));
//        ds.add(new Persion("5", "Tài"));
//        ds.add(new Persion("6", "Tài"));
//        ds.add(new Persion("7", "Tài"));
//        ds.add(new Persion("8", "Tài"));
//        ds.add(new Persion("9", "Tài"));
//        ds.add(new Persion("10", "Tài"));
//        ds.add(new Persion("11", "Tài"));
//        ds.add(new Persion("12", "Tài"));
//        ds.add(new Persion("13", "Tài"));
//        ds.add(new Persion("14", "Tài"));
//        ds.add(new Persion("15", "Tài"));

    }
    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int position) {
        return ds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        while (position <= currposition ){
            position++;
        }
            View view = convertView;
            view_holder viewHolder = null;
            if(view == null){
                view = LayoutInflater.from(context).inflate(R.layout.viewflipper_item, null);
                viewHolder = new view_holder();
                viewHolder.init(view);
                view.setTag(viewHolder);
            }
            else {
                viewHolder = (view_holder)view.getTag();
            }
            viewHolder.bind(position);
            return view;
    }
}
