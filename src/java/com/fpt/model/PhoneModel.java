/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.model;

import com.fpt.entity.Phone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author badan
 */
public class PhoneModel {

    String urlConnection = "jdbc:sqlserver://localhost;databaseName=Store;user=sa;password=123456";

    List<Phone> list = new ArrayList<>();
    Phone phone = null;

    PreparedStatement psmt;

    public Connection connection() {
        try {
            Connection connection = DriverManager.getConnection(urlConnection);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addPhone(String Name, String Brand, double Price, String Description) {
        String sql = "INSERT INTO Phone(Name, Brand, Price, Description) VALUES(?, ?, ?, ?)";
        try {
            psmt = connection().prepareStatement(sql);
            psmt.setString(1, Name);
            psmt.setString(2, Brand);
            psmt.setDouble(3, Price);
            psmt.setString(4, Description);
            return psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhoneModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Phone> list() {
        String sql = "SELECT * FROM Phone";

        try {
            psmt = connection().prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                phone = new Phone();
                phone.setID(rs.getInt("ID"));
                phone.setName(rs.getString("Name"));
                phone.setBrand(rs.getString("Brand"));
                phone.setPrice(rs.getDouble("Price"));
                phone.setDescription(rs.getString("Description"));
                list.add(phone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhoneModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
