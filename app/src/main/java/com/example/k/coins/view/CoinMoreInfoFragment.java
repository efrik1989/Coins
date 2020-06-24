package com.example.k.coins.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.k.coins.R;

public class CoinMoreInfoFragment extends Fragment {

    TextView coinState;
    TextView coinEmitterTown;
    TextView coinPrice;
    TextView coinCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more_info_abaut_coin, container);

        //coinState = view.findViewById(R.id.)


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
