package com.example.k.coins;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.k.coins.view.CoinDescriptionFragment;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoinDescriptionFragment coinDescriptionFragment = new CoinDescriptionFragment();
        transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.main_fragment_container, coinDescriptionFragment, null).commit();



    }
}
