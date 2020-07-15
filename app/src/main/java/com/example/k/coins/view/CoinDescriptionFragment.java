package com.example.k.coins.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.k.coins.R;
import com.example.k.coins.dataBase.AppDataBase;
import com.example.k.coins.model.Coin;
import com.example.k.coins.service.CoinLab;

public class CoinDescriptionFragment extends Fragment {
    public static final String TAG = "CoinDescriptionFragment";
    private boolean coinEditRecord;
    Coin coin;
    Callbacks mCallbacks;
    CoinLab coinLab;

    ImageView photoAves;
    ImageView photoReverse;
    TextView coinYear;
    TextView coinValue;
    TextView coinCountry;
    EditText yearTextView;
    EditText valueTextView;
    EditText countryTextView;
    ImageButton acceptButton;
    Button moreInfo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.coin_description, container, false);
        setHasOptionsMenu(true);
        //Привязка view элементов в коду
        photoAves = view.findViewById(R.id.aves);
        photoReverse = view.findViewById(R.id.reverse);
        coinYear = view.findViewById(R.id.coin_year);
        coinValue = view.findViewById(R.id.coin_value);
        coinCountry = view.findViewById(R.id.coin_country);

        //todo: принажатии на итем в списке в фрагменте детализации
        // должны быть развернутые данные того же объекта
        yearTextView = view.findViewById(R.id.coin_year_text);
        valueTextView = view.findViewById(R.id.coin_value_text);
        countryTextView = view.findViewById(R.id.coin_country_text);



        acceptButton = view.findViewById(R.id.accept_button);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertNewCoin();
                coinEditRecord = false;
            }
        });


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

        if (!isCoinEditRecord()) {
            editTextBlock(yearTextView);
            editTextBlock(valueTextView);
            editTextBlock(countryTextView);
            acceptButton.setVisibility(View.INVISIBLE);
        }

        coin = new Coin();
        coinLab = new CoinLab(coin, getContext());

        return view;
    }

    /**
     * Интерфейс несет в себе контекст т.е. информацию о данном фрагменте
     */
    public interface Callbacks {
        void onCoinUpdated(Coin coin);
    }

    /**
     * Метод отвечающий за привязку к Activity и передачу данных между фрагментами
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }

    void editTextBlock(EditText editText) {
        editText.setFocusable(false);
        editText.setLongClickable(false);
        editText.setCursorVisible(false);
    }

    void editTextUnblock(EditText editText) {
        editText.setFocusable(true);
        editText.setLongClickable(true);
        editText.setCursorVisible(true);
    }

    void insertNewCoin() {
        try {
            coin.setYear(Integer.parseInt(yearTextView.getText().toString()));
            coin.setCoinValue(Integer.parseInt(valueTextView.getText().toString()));
            coin.setCountry(countryTextView.getText().toString());

            //coinLab.addCoin(coin);
            AppDataBase db = AppDataBase.getAppDatabase(getContext());
            db.coinDao().insertAll(coin);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            Log.d(TAG,yearTextView.getText().toString()  + " " + valueTextView.getText().toString() + " " + countryTextView.getText().toString() );
        }
    }

    public boolean isCoinEditRecord() {
        return coinEditRecord;
    }

    public void setCoinEditRecord(boolean coinEditRecord) {
        this.coinEditRecord = coinEditRecord;
    }

    //TODO: сделать метод обновления фрагмента


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.descr_frag_menu_layout, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_record :
                editTextUnblock(yearTextView);
                editTextUnblock(countryTextView);
                editTextUnblock(valueTextView);
                acceptButton.setVisibility(View.VISIBLE);
                break;
            case R.id.delete_record :
                coinLab.deleteCoin(coin);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
