package com.example.fran.appiumtechtalk.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fran.appiumtechtalk.R;
import com.example.fran.appiumtechtalk.bussines.User;

/**
 * @author f.visintini on 27/06/17.
 */
public class ProfileFragment extends Fragment {

    private static final String USER = "user";

    private User user;

    private TextView name;
    private TextView lastName;
    private TextView gender;
    private TextView eyeColor;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(User user) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getParcelable(USER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView error = (TextView) view.findViewById(R.id.error);
        RelativeLayout dataLayout = (RelativeLayout) view.findViewById(R.id.data_layout);

        if(user == null){
            error.setVisibility(View.VISIBLE);
            dataLayout.setVisibility(View.GONE);
        } else {
            error.setVisibility(View.GONE);
            dataLayout.setVisibility(View.VISIBLE);
            name = (TextView) view.findViewById(R.id.name);
            lastName = (TextView) view.findViewById(R.id.last_name);
            gender = (TextView) view.findViewById(R.id.gender);
            eyeColor = (TextView) view.findViewById(R.id.eye_color);
            fillData(user);
        }

        return view;
    }

    private void fillData(User user) {
        name.setText(user.getName());
        lastName.setText(user.getLastName());
        gender.setText(user.getGender());
        eyeColor.setText(user.getEyeColor());
    }
}
