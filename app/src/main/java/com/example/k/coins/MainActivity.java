package com.example.k.coins;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.k.coins.model.Coin;
import com.example.k.coins.service.DialogFragmentListener;
import com.example.k.coins.service.FragmentListener;
import com.example.k.coins.view.CoinDescriptionFragment;
import com.example.k.coins.view.CoinRecyclerViewFragment;

public class MainActivity
        extends
            AppCompatActivity
        implements
            CoinRecyclerViewFragment.Callbacks,
            CoinDescriptionFragment.Callbacks,
            FragmentListener,
            DialogFragmentListener {

    private static final String TAG = "MainActivity";

    Coin mCoin;
    FragmentTransaction transaction;
    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CoinRecyclerViewFragment coinRecyclerViewFragment = new CoinRecyclerViewFragment();
        //CoinDescriptionFragment coinDescriptionFragment = new CoinDescriptionFragment();
        fragmentController(coinRecyclerViewFragment);


    }

    public void fragmentController(Fragment fragment) {

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment_container, fragment, null);
        transaction.addToBackStack("").commit();
        Log.d(TAG, "Вызов фрагмента");

    }



    @Override
    public void onCoinUpdated(Coin coin) {
        mCoin = coin;
    }

    @Override
    public void onFragmentListener(Fragment fragment) {
         fragmentController(fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu_layout, menu);
        return true;
    }

    @Override
    public void onDialogFragmentListener(AppCompatDialogFragment dialogFragment) {
        mFragmentManager = getSupportFragmentManager();
        dialogFragment.show(mFragmentManager, "customDialog");
    }
}


