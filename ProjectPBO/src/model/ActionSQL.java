/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ActionSQL {
    void addGoods(Goods barang);
    void updateGoods(Goods barang);
    void deleteGoods(int id);
    Goods findGoods(int id);
    List<Goods> getAllGoods();
}
