package com.example.k.coins.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.k.coins.MainActivity;
import com.example.k.coins.R;

public class CoinDescriptionFragment extends Fragment {

    ImageView photoAves;
    ImageView photoReverse;
    TextView coinYear;
    TextView coinValue;
    TextView coinCountry;
    Button moreInfo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coin_description, container, false);

        //Привязка view элементов в коду
        photoAves = view.findViewById(R.id.aves);
        photoReverse = view.findViewById(R.id.reverse);
        coinYear = view.findViewById(R.id.coin_year);
        coinValue = view.findViewById(R.id.coin_value);
        coinCountry = view.findViewById(R.id.coin_country);
        moreInfo = view.findViewById(R.id.coin_more_info);

        moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CoinMoreInfoFragment coinMoreInfoFragment = new CoinMoreInfoFragment();
                    System.out.println("new CoinMoreInfoFragment()");

                    //TODO: Разобраться с кнопокой "Дополнительная информация", чтоб при нажатии появлялся еще один фрагмент.
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                            .beginTransaction();

                            transaction.add(R.id.more_info_container, coinMoreInfoFragment)
                            .commit();
                }
            }
        );



        return view;
    }
}
