package com.example.fran.appiumtechtalk.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fran.appiumtechtalk.R;

public class HomeFragment extends Fragment {

    private Button form;
    private Button list;
    private Button profile;
    private Button reset;

    private OnHomeOptionSelected homeOptionListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeOptionSelected) {
            homeOptionListener = (OnHomeOptionSelected) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnHomeOptionSelected");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        form = (Button) view.findViewById(R.id.form);
        list = (Button) view.findViewById(R.id.list);
        profile = (Button) view.findViewById(R.id.profile);
        reset = (Button) view.findViewById(R.id.reset);

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeOptionListener.onFormClicked();
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeOptionListener.onListClicked();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeOptionListener.onProfileClicked();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeOptionListener.onResetClicked();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homeOptionListener = null;
    }

    public interface OnHomeOptionSelected {
        void onFormClicked();
        void onListClicked();
        void onProfileClicked();
        void onResetClicked();
    }
}
