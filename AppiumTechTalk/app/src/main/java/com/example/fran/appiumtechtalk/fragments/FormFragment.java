package com.example.fran.appiumtechtalk.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.fran.appiumtechtalk.R;
import com.example.fran.appiumtechtalk.bussines.User;

/**
 * @author f.visintini on 27/06/17.
 */
public class FormFragment extends Fragment {

    private onSaveUserDataListener mListener;

    private TextView name;
    private TextView error;
    private TextView success;
    private TextView lastName;
    private RadioButton female;
    private RadioButton male;
    private TextView eyeColor;

    private User user;

    public FormFragment() {
        // Required empty public constructor
    }

    public static FormFragment newInstance() {
        return new FormFragment();
    }

    public void onSaveUserData(User user) {
        if (mListener != null) {
            mListener.onSaveUserData(user);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onSaveUserDataListener) {
            mListener = (onSaveUserDataListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onSaveUserDataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        Button submit = (Button) view.findViewById(R.id.submit);
        NumberPicker pickers = (NumberPicker) view.findViewById(R.id.eye_color_picker);
        error = (TextView) view.findViewById(R.id.error);
        success = (TextView) view.findViewById(R.id.success);
        eyeColor = (TextView) view.findViewById(R.id.eye_color);
        name = (TextView) view.findViewById(R.id.name);
        lastName = (TextView) view.findViewById(R.id.last_name);
        female = (RadioButton) view.findViewById(R.id.gender_female);
        male = (RadioButton) view.findViewById(R.id.gender_male);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateFields()){
                    onSaveUserData(user);
                }
            }
        });

        final String[] arrayPicker= new String[]{" ","Blue","Green","Black","Brown","Other"};

        pickers.setMinValue(0);
        pickers.setMaxValue(arrayPicker.length - 1);
        pickers.setDisplayedValues(arrayPicker);
        pickers.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickers.setWrapSelectorWheel(false);

        pickers.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                eyeColor.setText(arrayPicker[newVal]);
            }
        });

        return view;
    }

    private boolean validateFields() {
        if(name.getText().toString().isEmpty()){
            error.setVisibility(View.VISIBLE);
            error.setText(getString(R.string.error_name));
            success.setVisibility(View.GONE);
            return false;
        }

        if(lastName.getText().toString().isEmpty()){
            error.setVisibility(View.VISIBLE);
            error.setText(getString(R.string.error_last_name));
            success.setVisibility(View.GONE);
            return false;
        }

        if(!male.isChecked() && !female.isChecked()){
            error.setVisibility(View.VISIBLE);
            error.setText(getString(R.string.error_gender));
            success.setVisibility(View.GONE);
            return false;
        }

        if(eyeColor.getText().toString().trim().isEmpty()){
            error.setVisibility(View.VISIBLE);
            error.setText(getString(R.string.error_eye_color));
            success.setVisibility(View.GONE);
            return false;
        }

        error.setVisibility(View.GONE);
        success.setVisibility(View.VISIBLE);

        user = new User();
        user.setName(name.getText().toString().trim());
        user.setLastName(lastName.getText().toString().trim());
        user.setGender(male.isChecked() ? male.getText().toString() : female.getText().toString());
        user.setEyeColor(eyeColor.getText().toString());

        return true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface onSaveUserDataListener {
        void onSaveUserData(User user);
    }
}
