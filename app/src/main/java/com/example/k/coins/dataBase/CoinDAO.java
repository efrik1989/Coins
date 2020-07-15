package com.example.k.coins.dataBase;


import com.example.k.coins.model.Coin;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Интерфейс предоставляющий запросы к БД
 */

@Dao
public interface CoinDAO {

    @Query("SELECT * FROM coin")
    List<Coin> getAllCoins();

    @Query("SELECT * FROM coin WHERE :coinValue LIKE :coinValue")
    List<Coin> findCoinByValue(int coinValue);

    @Query("SELECT * FROM coin WHERE :country LIKE :country")
    List<Coin> findCoinByCountry(String country);

    @Query("SELECT * FROM coin WHERE :currencyName LIKE :currencyName")
    List<Coin> findCoinByCurrencyName(String currencyName);

    @Insert
    void insertAll(Coin coin);

    @Delete
    void deleteRowByCoin(Coin coin);

    @Update
    void updateRow(Coin coin);
}
