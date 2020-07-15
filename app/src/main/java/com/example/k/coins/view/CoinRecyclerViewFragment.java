package com.example.k.coins.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.k.coins.R;
import com.example.k.coins.dataBase.AppDataBase;
import com.example.k.coins.model.Coin;
import com.example.k.coins.service.CoinLab;
import com.example.k.coins.service.DialogFragmentListener;
import com.example.k.coins.service.FragmentListener;

import java.util.List;

/**
 *Класс фрагмент отвечающий за формирование и отображение списка монет
 *
 */

public class CoinRecyclerViewFragment extends Fragment {
    private static final String TAG = "CoinRecyclerViewFragment";


    CoinLab mCoinLab;
    Callbacks mCallbacks;
    RecyclerView mCoinRecyclerView;
    CoinAdapter mAdapter;
    private FragmentListener mFragmentListener;
    private DialogFragmentListener mDialogFragmentListener;
    int listSize;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view_layout, container, false);

        mCoinRecyclerView = view.findViewById(R.id.recycler_view_list_host);
        mCoinRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mCoinLab = new CoinLab(getContext());

        updateUI();

        if (getListSize() == 0 ) {
            CoinDialogFragment coinDialogFragment = new CoinDialogFragment();
            mDialogFragmentListener.onDialogFragmentListener(coinDialogFragment);
        }

        return view;
    }

    /**
     * Интерфейс отвечающий за передачу данных
     */
    public interface Callbacks {
        void onCoinSelected(Coin coin);
    }

    public int getListSize() {
        listSize = mAdapter.getItemCount();
        return listSize;
    }

    /**
     * Метод отвечающий за привязку к Activity и передачу данных между фрагментами
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Callbacks) {
            mCallbacks = (Callbacks) context;
        }if (context instanceof FragmentListener) {
            mFragmentListener = (FragmentListener) context;
        }
        if (context instanceof DialogFragmentListener) {
            mDialogFragmentListener = (DialogFragmentListener) context;
        }
        else {
            throw new RuntimeException(context.toString() + " must implement OnFragment1DataListener");
        }
    }

    /**
     * Класс обновления данных отображения (Refresh)
     *
     */
    @SuppressLint("LongLogTag")
    public void updateUI() {
        //TODO: Работа с БД должна быть асинхронной!!!
        //TODO:База елает все в отдельном потоке и почему-то не выводит на экран свою работу. Исправить!!!
        //List <Coin> coins = mCoinLab.getCoinsList();
        AppDataBase db = AppDataBase.getAppDatabase(getContext());
        List <Coin> coins = db.coinDao().getAllCoins();
        if (mAdapter == null) {
            mAdapter = new CoinAdapter(coins);
            mCoinRecyclerView.setAdapter(mAdapter);
            Log.d(TAG, "Adapter created");
        } else {
            mAdapter.setCoins(coins);
            mAdapter.notifyDataSetChanged();
            Log.d(TAG, "Adapter is not created");
        }

    }

    /**
     * Класс отвечающий за разметку элемента в спискe
     */
    public class CoinHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Coin mCoin;
        TextView year;
        //TextView currencyValue;
        TextView quantity;
        TextView value;
        ImageView coinPhoto;
        ImageView countryPhoto;

        public CoinHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.recycler_list_item_layout, parent, false));

            year = itemView.findViewById(R.id.coin_year_list_item);
            value = itemView.findViewById(R.id.coin_value_list_item);
            quantity = itemView.findViewById(R.id.coin_quantity_list_item);
            coinPhoto = itemView.findViewById(R.id.coin_photo_list_item);
            countryPhoto = itemView.findViewById(R.id.country_image);

            itemView.setOnClickListener(this);

        }

        @SuppressLint("SetTextI18n")
        public void bind(Coin coin) {
            mCoin = coin;
            year.setText(mCoin.getYear() + "");
            value.setText(mCoin.getCoinValue() + "");
            quantity.setText(mCoin.getCoinQuantityInChest() + "");
            //TODO:Привязать изображения Авес в уменьшеном и облегченном виде.
            //coinPhoto.set;
            //TODO: Сделать привязку названия стран и изображений их флагов
            //countryPhoto = itemView.findViewById(R.id.country_image);s
        }

        @Override
        public void onClick(View v) {
            mCallbacks.onCoinSelected(mCoin);
            CoinDescriptionFragment coinDescriptionFragment = new CoinDescriptionFragment();
            mFragmentListener.onFragmentListener(coinDescriptionFragment);
        }
    }

    /**
     * Класс Адаптер отвечающий за привязку макета элемента в списке и списка
     */
    public class CoinAdapter extends RecyclerView.Adapter<CoinHolder> {

        List<Coin> coins;

        public CoinAdapter(List<Coin> coins) {
            this.coins = coins;
        }

        @NonNull
        @Override
        public CoinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            return new CoinHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CoinHolder holder, int position) {
            Coin coin = coins.get(position);
            holder.bind(coin);
        }

        @Override
        public int getItemCount() {
            if (coins != null) {
                return coins.size();
            }
            return 0;
        }

        public void setCoins(List<Coin> coins) {
            this.coins = coins;
        }
    }


    /**
     * Метода отвечающий за создание меню
     * @param menu
     * @param inflater
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_layout, menu);
    }

    /**
     * Метод отвечающий за отклик пунктов меню
     * @param item
     * @return
     */
    //TODO: Полноценно переделать меню(Разобраться с вызовом фрагментов и передачей данных между ними)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addButton :
                Coin coin = new Coin();
                mCallbacks.onCoinSelected(coin);
                CoinDescriptionFragment coinDescriptionFragment = new CoinDescriptionFragment();
                mFragmentListener.onFragmentListener(coinDescriptionFragment);
                break;
            case R.id.app_bar_search:

                break;

        }
        return super.onOptionsItemSelected(item);
    }



}
