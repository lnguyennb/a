/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author lgn
 */
public class AccountDAO extends MyDAO {

    public Account login(String user, String pass) {
        xSql = "select * from Account where user = ? and pass = ?";
        String xUser, xPass;
        int xId, xIsWriter, xIsAdmin;
        Account x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                xUser = rs.getString("user");
                xPass = rs.getString("pass");
                xId = rs.getInt("person_id");
                xIsWriter = rs.getInt("isWriter");
                xIsAdmin = rs.getInt("isAdmin");
                x = new Account(xId, xUser, xPass, xIsWriter, xIsAdmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;

    }

    public List<Account> getAllWriter() {
        List<Account> list = new ArrayList<>();
        xSql = "select * from Account where isWriter = 1";
        try {
            String xUser, xPass;
            int xId, xIsWriter, xIsAdmin;
            Account x = null;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xUser = rs.getString("user");
                xPass = rs.getString("pass");
                xId = rs.getInt("person_id");
                xIsWriter = rs.getInt("isWriter");
                xIsAdmin = rs.getInt("isAdmin");
                x = new Account(xId, xUser, xPass, xIsWriter, xIsAdmin);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Account getAccountByID(String id) {
        xSql = "select * from Account where id = ?";
        //String xName, xImage, xDescription;
        String xUser, xPass;
        int xId, xIsWriter, xIsAdmin;
        Account x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xUser = rs.getString("user");
                xPass = rs.getString("pass");
                xId = rs.getInt("person_id");
                xIsWriter = rs.getInt("isWriter");
                xIsAdmin = rs.getInt("isAdmin");
                x = new Account(xId, xUser, xPass, xIsWriter, xIsAdmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public void add(String user, String pass) {
        xSql = "INSERT INTO WorldNews.Account (`user`, pass, isWriter, isAdmin) VALUES(?, ?, 1, 0);";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addReader(String user, String pass) {
        xSql = "insert into Account (user,pass,isWriter,isAdmin) values (?,?,0,0)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkExits(String user) {
        List<String> list = new ArrayList<>();
        xSql = "select user from Account";
        try {
            String xUser;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xUser = rs.getString("user");
                list.add(xUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            if (user.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

}
