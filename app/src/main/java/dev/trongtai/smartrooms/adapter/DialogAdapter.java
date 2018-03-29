package dev.trongtai.smartrooms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dev.trongtai.smartrooms.R;
import dev.trongtai.smartrooms.classes.Persion;

/**
 * Created by HK on 29/03/2018.
 */

public class DialogAdapter extends BaseAdapter {
    private Context context;
    private List<Persion> ds;
    private List<Persion> ds1;

    public DialogAdapter(Context context){
        this.context = context;
        ds = new ArrayList<>();
        ds1 = new ArrayList<>();
        createDefaultData();
    }
    public DialogAdapter(Context context, List<Persion> list, int mode){
        this.context = context;
        ds = new ArrayList<>();
        ds1 = new ArrayList<>();
        if(mode == 0){
            for (Persion pt:list){
                ds.add(pt);
            }
        }
        else if(mode == 1){
            createDefaultData();
            List<Persion> temp = new ArrayList<>();
//            for(Persion pt : ds){
//                temp.add(pt);
//            }
//            for(int i = 0; i < ds.size(); i++){
//                for(int j = 0; j<list.size(); j++){
//                    if(ds.get(i).getId() == list.get(j).getId()){
//                        temp.remove(i);
//                    }
//                }
//            }
//            ds.removeAll(ds);
//            for(Persion pt : temp){
//                ds.add(pt);
//            }
            for(Persion pt: list){
                if(findOutItemIndex(pt, ds) != -1)
                    ds.remove(findOutItemIndex(pt, ds));
            }
        }
    }

    private int findOutItemIndex(Persion item, List<Persion> ds){
        for(int i = 0; i < ds.size(); i++){
            if(ds.get(i).getId() == item.getId())
                return i;
        }
        return -1;
    }
    public void createDefaultData(){
        ds.add(new Persion(1, "Tai1"));
        ds.add(new Persion(2, "Tai2"));
        ds.add(new Persion(3, "Tai3"));
        ds.add(new Persion(4, "Tai4"));
        ds.add(new Persion(5, "Tai5"));
        ds.add(new Persion(6, "Tai6"));
        ds.add(new Persion(7, "Tai7"));
        ds.add(new Persion(8, "Tai8"));
        ds.add(new Persion(9, "Tai9"));
        ds.add(new Persion(10, "Tai10"));
        ds.add(new Persion(11, "Tai11"));
        ds.add(new Persion(12, "Tai12"));
        ds.add(new Persion(13, "Tai13"));
        ds.add(new Persion(14, "Tai14"));

    }
    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Persion getItem(int position) {
        return ds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ds.get(position).getId();
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = convertView;
        viewHolder holder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
            holder = new viewHolder();
            holder.labName = view.findViewById(R.id.lab_name);
            view.setTag(holder);
        }
        else {
            holder = (viewHolder)view.getTag();
        }
        holder.labName.setText(ds.get(position).getName());

        return view;
    }

    private class viewHolder{
        private TextView labName;
    }
}
