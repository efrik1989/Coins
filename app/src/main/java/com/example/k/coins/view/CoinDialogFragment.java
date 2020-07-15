package com.example.k.coins.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;

import com.example.k.coins.service.FragmentListener;


/**
 * Класс диалогового окна
 */
public class CoinDialogFragment extends AppCompatDialogFragment {

    private FragmentListener mFragmentListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("У вас не добавлено ни одной монеты. Добавить сейччас?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CoinDescriptionFragment coinDescriptionFragment = new CoinDescriptionFragment();
                        mFragmentListener.onFragmentListener(coinDescriptionFragment);
                        coinDescriptionFragment.setCoinEditRecord(true);
                    }
                }).setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            mFragmentListener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement FragmentListener");
        }

    }
}
