package com.example.fran.appiumtechtalk.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fran.appiumtechtalk.R;
import com.example.fran.appiumtechtalk.bussines.User;
import com.example.fran.appiumtechtalk.fragments.FormFragment;
import com.example.fran.appiumtechtalk.fragments.HomeFragment;
import com.example.fran.appiumtechtalk.fragments.ListFragment;
import com.example.fran.appiumtechtalk.fragments.ProfileFragment;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnHomeOptionSelected, FormFragment.onSaveUserDataListener {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.container, HomeFragment.newInstance())
                                   .addToBackStack(null)
                                   .commit();
    }

    @Override
    public void onFormClicked() {
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.container, FormFragment.newInstance())
                                   .addToBackStack(null)
                                   .commit();
    }

    @Override
    public void onListClicked() {
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.container, ListFragment.newInstance())
                                   .addToBackStack(null)
                                   .commit();
    }

    @Override
    public void onProfileClicked() {
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.container, ProfileFragment.newInstance(user))
                                   .addToBackStack(null)
                                   .commit();
    }

    @Override
    public void onResetClicked() {
        user = null;
        Toast.makeText(this, "User has been reset correctly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveUserData(User user) {
        this.user = user;
    }
}
