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
    TextView coinHistory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more_info_abaut_coin, container, false);

        coinState = view.findViewById(R.id.coin_state);
        coinEmitterTown = view.findViewById(R.id.coin_emitter_town);
        coinPrice = view.findViewById(R.id.coin_price);
        coinCategory = view.findViewById(R.id.coin_category);
        coinHistory = view.findViewById(R.id.coin_history);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
