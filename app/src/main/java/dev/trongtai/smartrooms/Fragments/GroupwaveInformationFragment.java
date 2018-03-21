package dev.trongtai.smartrooms.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.trongtai.smartrooms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupwaveInformationFragment extends Fragment {


    public GroupwaveInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_groupwave_information, container, false);
    }

}
