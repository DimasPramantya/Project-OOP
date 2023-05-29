/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Lenovo
 */

import model.*;
import java.util.List;

public class GoodsController {
    private DBCon dbAction;
    
    public GoodsController(){
        dbAction = new DBCon();
    }

    public void addGoods(String name, double price, String stock, Category category, String brand) {
        Goods goods = new Goods(0, name, price, stock, category, brand);
        dbAction.addGoods(goods);
    }

    public void updateGoods(int id, String name, double price, String stock, Category category, String brand) {
        Goods goods = new Goods(id, name, price, stock, category, brand);
        dbAction.updateGoods(goods);
    }

    public void deleteGoods(int id) {
        dbAction.deleteGoods(id);
    }

    public List<Goods> getAllGoods() {
        return dbAction.getAllGoods();
    }
    
    public Goods findGoods(int id){
        return dbAction.findGoods(id);
    }

}
