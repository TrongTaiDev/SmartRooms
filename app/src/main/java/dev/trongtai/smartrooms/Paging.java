package dev.trongtai.smartrooms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterViewFlipper;

import dev.trongtai.smartrooms.adapter.TestAdapter;

public class Paging extends AppCompatActivity {
    private AdapterViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        viewFlipper = findViewById(R.id.viewFlipper);

        TestAdapter adapter = new TestAdapter(this);
        viewFlipper.setAdapter(adapter);
        viewFlipper.setAutoStart(true);
    }
}
