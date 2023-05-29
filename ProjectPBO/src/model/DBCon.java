/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class DBCon implements ActionSQL   {
    private Connection connection;
    
    public DBCon(){
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectpbo", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addGoods(Goods goods) {
        try {
            String query = "INSERT INTO goods (name, price, stock, category, brand) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, goods.getName());
            statement.setDouble(2, goods.getPrice());
            statement.setString(3, goods.getStock());
            statement.setString(4, goods.getCategory().toString());
            statement.setString(5, goods.getBrand());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGoods(Goods goods) {
        try {
            String query = "UPDATE goods SET name = ?, price = ?, stock = ?, category = ?, brand = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, goods.getName());
            statement.setDouble(2, goods.getPrice());
            statement.setString(3, goods.getStock());
            statement.setString(4, goods.getCategory().toString());
            statement.setString(5, goods.getBrand());
            statement.setInt(6, goods.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGoods(int id) {
        try {
            String query = "DELETE FROM goods WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> goodsList = new ArrayList<>();

        try {
            String query = "SELECT * FROM Goods";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String stock = resultSet.getString("stock");
                Category category = Category.valueOf(resultSet.getString("category"));
                String brand = resultSet.getString("brand");

                Goods goods = new Goods(id, name, price, stock, category, brand);
                goodsList.add(goods);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goodsList;
    }
    
    public Goods findGoods(int id){
        Goods goods = null;
        try {
            String query = "SELECT * FROM goods WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String stock = resultSet.getString("stock");
                Category category = Category.valueOf(resultSet.getString("category"));
                String brand = resultSet.getString("brand");
                goods = new Goods(id, name, price, stock, category, brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
}
