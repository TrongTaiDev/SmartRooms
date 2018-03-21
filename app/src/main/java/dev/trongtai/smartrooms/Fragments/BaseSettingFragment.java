package dev.trongtai.smartrooms.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.trongtai.smartrooms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseSettingFragment extends Fragment {


    public BaseSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base_setting, container, false);
    }

}
