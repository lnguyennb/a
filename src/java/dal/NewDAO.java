/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.New;
import java.sql.Date;


/**
 *
 * @author lgn
 */
public class NewDAO extends MyDAO {

    public List<New> getAllNew() {
        List<New> list = new ArrayList<>();
        xSql = "select * from new";
        try {
            String xName, xImage, xContent;
            String xTitle;
            Date xDate;
            int xId;
            New x;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<New> get3LastNew() {
        List<New> list = new ArrayList<>();
        xSql = "SELECT n1.*\n"
                + "FROM new n1\n"
                + "JOIN (\n"
                + "    SELECT n2.id\n"
                + "    FROM new n2\n"
                + "    ORDER BY n2.id DESC\n"
                + "    LIMIT 3\n"
                + ") subquery\n"
                + "ON n1.id = subquery.id\n"
                + "ORDER BY n1.id DESC;";
        try {
            String xName, xImage, xContent;
            String xTitle;
            Date xDate;
            int xId;
            New x;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<New> getNewByCID(int cid) {
        List<New> list = new ArrayList<>();
        xSql = "select * from new where cateID = ? order by id DESC";
        try {
            String xName, xImage, xContent;
            String xTitle;
            int xId;
            Date xDate;

            New x;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public New getNewByID(String id) {
        xSql = "select * from new where id = ?";
        String xName, xImage, xContent;
        int xId;
        Date xDate;
        String xTitle;
        New x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = Integer.parseInt(id);
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public List<New> getNewByWriterID(int id) {
        List<New> list = new ArrayList<>();
        xSql = "select * from new where writerID = ?";
        try {
            String xName, xImage, xContent;
            String xTitle;
            int xId;
            Date xDate;
            New x;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<New> searchByName(String txtSearch) {
        List<New> list = new ArrayList<>();
        xSql = "select * from new where name like '%" + txtSearch + "%'";
        String xName, xImage, xContent;
        String xTitle;
        Date xDate;
        int xId;
        New x;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public void add(String name, String image, String title, String content, String date, int cateID, int writerID) {
        xSql = "insert into New (name,image,title, content,date, cateID, writerID) values (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, title);
            ps.setString(4, content);
            ps.setString(5, date);
            ps.setInt(6, cateID);
            ps.setInt(7, writerID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(String name, String image, String title, String content, int id) {
        xSql = "update New set name=?, image=?, title=?, content=? where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, title);
            ps.setString(4, content);
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String xId) {
        xSql = "delete from New where id= ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
