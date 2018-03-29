package dev.trongtai.smartrooms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dev.trongtai.smartrooms.adapter.DialogAdapter;
import dev.trongtai.smartrooms.classes.Persion;

public class DialogActivity extends AppCompatActivity {

    private ListView listSrc;
    private ListView listSelected;
    private Button btnChon;
    private Button btnBoChon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        listSrc = findViewById(R.id.list_src);
        listSelected = findViewById(R.id.list_selected);
        btnChon = findViewById(R.id.btnChon);
        btnBoChon = findViewById(R.id.btnBoChon);

        final DialogAdapter adapter = new DialogAdapter(this);
        listSrc.setAdapter(adapter);

        final List<Persion> seletedPerson = new ArrayList<>();
        final  List<Persion> totalSelectedPerson = new ArrayList<>();
        listSrc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(findOutItemIndex((Persion) parent.getAdapter().getItem(position), seletedPerson) == -1){
                    seletedPerson.add((Persion) parent.getAdapter().getItem(position));
                    view.setBackground(getDrawable(android.R.color.holo_orange_light));
                }
                else {
                    seletedPerson.remove(findOutItemIndex((Persion) parent.getAdapter().getItem(position), seletedPerson));
                    view.setBackground(getDrawable(android.R.color.transparent));
                }
            }
        });

        final List<Persion> unseletedPerson = new ArrayList<>();
        final List<Persion> totalUnselectedPersion = new ArrayList<>();
        listSelected.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(findOutItemIndex((Persion) parent.getAdapter().getItem(position), unseletedPerson) == -1){
                    unseletedPerson.add((Persion) parent.getAdapter().getItem(position));
                    view.setBackground(getDrawable(android.R.color.holo_blue_light));
                }
                else {
                    unseletedPerson.remove(findOutItemIndex((Persion) parent.getAdapter().getItem(position), unseletedPerson));
                    view.setBackground(getDrawable(android.R.color.transparent));
                }
            }
        });
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seletedPerson.size()>0){
                    for (Persion pt:seletedPerson){
                        if(findOutItemIndex(pt, totalSelectedPerson) == -1)
                            totalSelectedPerson.add(pt);
                    }
                    DialogAdapter adapter1 = new DialogAdapter(getApplicationContext(), totalSelectedPerson, 0);
                    listSelected.setAdapter(adapter1);
                    seletedPerson.removeAll(seletedPerson);

                    //Lam moi lai danh sach nguon
                    DialogAdapter adapter2 = new DialogAdapter(getApplicationContext(), totalSelectedPerson, 1);
                    listSrc.setAdapter(adapter2);
                }
            }
        });

    }
    private int findOutItemIndex(Persion item, List<Persion> ds){
        for(int i = 0; i < ds.size(); i++){
            if(ds.get(i).getId() == item.getId())
                return i;
        }
        return -1;
    }
}
