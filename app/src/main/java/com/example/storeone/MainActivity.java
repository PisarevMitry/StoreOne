package com.example.storeone;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    fragment_home frag1;
    fragment_directory frag2;
    fragment_cart frag3;
    fragment_favorite frag4;
    fragment_profile frag5;
    FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new fragment_home();
        frag2 = new fragment_directory();
        frag3 = new fragment_cart();
        frag4 = new fragment_favorite();
        frag5 = new fragment_profile();

        fTrans = getFragmentManager().beginTransaction();
        fTrans.add(R.id.fragmentLayout, frag1);
        fTrans.commit();
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        fTrans = getFragmentManager().beginTransaction();
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                fTrans.replace(R.id.fragmentLayout, frag1);
                                break;
                            case R.id.action_directory:
                                fTrans.replace(R.id.fragmentLayout, frag2);
                                break;
                            case R.id.action_cart:
                                fTrans.replace(R.id.fragmentLayout, frag3);
                                break;
                            case R.id.action_favorite:
                                fTrans.replace(R.id.fragmentLayout, frag4);
                                break;
                            case R.id.action_profile:
                                fTrans.replace(R.id.fragmentLayout, frag5);
                                break;
                        }
                        fTrans.commit();
                        return true;
                    }
                });
    }

}