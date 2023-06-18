/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author lgn
 */
public class CategoryDAO extends MyDAO {

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        xSql = "select * from category";
        try {
            String xCname;
            int xCid;
            Category x;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xCid = rs.getInt("cid");
                xCname = rs.getString("cname");
                x = new Category(xCid, xCname);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Category getCategoryByID(String id) {
        xSql = "select * from category where cid = ?";
        String xCname;
        int xCid;
        Category x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xCid = rs.getInt("cid");
                xCname = rs.getString("cname");
                x = new Category(xCid, xCname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
}
