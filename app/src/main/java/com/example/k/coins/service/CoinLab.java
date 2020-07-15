package com.example.k.coins.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.example.k.coins.dataBase.AppDataBase;
import com.example.k.coins.model.Coin;

import java.util.List;

/**
 * Класс отвечающий за создание и объектов Coin (чет пока вопрос: Анужен ли он вообще?)
 */
//todo: разобраться с Room. База не пашет.
public class CoinLab {
    //AppDataBase dataBase;
    Context context;
    Coin coin;

    public CoinLab(Coin coin, Context context) {
        this.coin = coin;
        this.context = context;

    }

    public CoinLab(Context context) {
        this.context = context;
    }

    public List<Coin> getCoinsList() {
        GetData getData = new GetData();
        getData.execute();
        return getData.getCoinsList();
    }

    public void addCoin(Coin coin) {
        InsertData insertData = new InsertData();
        insertData.execute();
    }

    public void deleteCoin(Coin coin) {
        DeleteCoin deleteCoin = new DeleteCoin();
        deleteCoin.execute();
    }

    /**
     * Метод для теста
     * @param db
     */
    private static void populateWithTestData(AppDataBase db) {
        Coin coin = new Coin();
        coin.setCountry("Россия");
        coin.setCoinValue(25);
        coin.setCurrencyName("рубль");
        coin.setYear(1997);
        coin.setPrice(34.27);
        //addCoin(db, coin);
    }

    @SuppressLint("StaticFieldLeak")
    class GetData extends AsyncTask<Void, Void, Void> {
        List<Coin> coinsList;

        @Override
        protected Void doInBackground(Void... voids) {
            AppDataBase db = AppDataBase.getAppDatabase(context);
            coinsList = db.coinDao().getAllCoins();
            return null;
        }

        public List<Coin> getCoinsList() {
            return coinsList;
        }
    }
    class InsertData extends AsyncTask<Coin, Void, Void> {

        @Override
        protected Void doInBackground(Coin... coins) {
            AppDataBase db = AppDataBase.getAppDatabase(context);
            db.coinDao().insertAll(coin);
            return null;
        }
    }
    class SearchData {

    }

    class DeleteCoin extends AsyncTask<Coin, Void, Void> {

        @Override
        protected Void doInBackground(Coin... coins) {
            AppDataBase db = AppDataBase.getAppDatabase(context);
            db.coinDao().deleteRowByCoin(coin);
            return null;
        }
    }


}
