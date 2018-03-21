package dev.trongtai.smartrooms;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import dev.trongtai.smartrooms.Fragments.BaseSettingFragment;
import dev.trongtai.smartrooms.Fragments.GroupwaveInformationFragment;
import dev.trongtai.smartrooms.Fragments.IndividualSettingFragment;
import dev.trongtai.smartrooms.Fragments.MeetingFragment;
import dev.trongtai.smartrooms.Fragments.SupportFragment;

public class SettingsActivity extends AppCompatActivity {
    private Button btnBaseSetting;
    private Button btnGroupwaveInfo;
    private Button btnMeetingInfo;
    private Button btnIndividualSetting;
    private Button btnSupport;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        customizeActionbar();

        btnBaseSetting = findViewById(R.id.btnBaseSetting);
        btnGroupwaveInfo = findViewById(R.id.btnGroupwaveInfo);
        btnMeetingInfo = findViewById(R.id.btnMeetingInfo);
        btnIndividualSetting = findViewById(R.id.btnIndividualSetting);
        btnSupport = findViewById(R.id.btnSupport);

        initEvents();
    }

    public void initEvents(){
        btnBaseSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new BaseSettingFragment());
            }
        });
        btnGroupwaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new GroupwaveInformationFragment());
            }
        });
        btnMeetingInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new MeetingFragment());
            }
        });
        btnIndividualSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new IndividualSettingFragment());
            }
        });
        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(new SupportFragment());
            }
        });
    }

    public void callFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FrameLayout content = findViewById(R.id.setting_content);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(content.getId(), fragment);
        transaction.commit();
    }
    public void customizeActionbar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Setting");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_timer);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, Color.WHITE);
        actionBar.setHomeAsUpIndicator(drawable);
    }
}
