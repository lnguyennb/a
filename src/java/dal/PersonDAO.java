/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Person;

/**
 *
 * @author lgn
 */
public class PersonDAO extends MyDAO {

    public List<Person> getAllPerson() {
        List<Person> list = new ArrayList<>();
        xSql = "select * from person";
        try {
            int xId;
            String xName;
            Date xDob;
            String xAddress;
            Person x;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xDob = rs.getDate("dob");
                xAddress = rs.getString("address");
                x = new Person(xId, xName, xDob, xName);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Person getPersonByNewID(int id) {
        xSql = "select pa.id,pa.name,pa.dob,pa.address from (select * from person p inner join Account a on p.id = a.person_id) pa "
                + "inner join new n on pa.person_id = n.writerID where n.id = ?";
        int xId;
        String xName;
        Date xDob;
        String xAddress;
        Person x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xDob = rs.getDate("dob");
                xAddress = rs.getString("address");
                x = new Person(id, xName, xDob, xAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public Person getPersonByID(int id) {
        xSql = "select * from person where id = ?";
        int xId;
        String xName;
        Date xDob;
        String xAddress;
        Person x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = id;
                xName = rs.getString("name");
                xDob = rs.getDate("dob");
                xAddress = rs.getString("address");
                x = new Person(id, xName, xDob, xAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return x;

    }

    public List<Person> searchByName(String txtSearch) {
        List<Person> list = new ArrayList<>();
        xSql = "select * from person where name like '%" + txtSearch + "%'";
        int xId;
        String xName;
        Date xDob;
        String xAddress;
        Person x;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xDob = rs.getDate("dob");
                xAddress = rs.getString("address");
                x = new Person(xId, xName, xDob, xAddress);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public void add(String name, Date dob, String address) {
        xSql = "insert into person (name,dob,address) values (?,?,?)";
        java.sql.Date xDob = (java.sql.Date) dob;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setDate(2, xDob);
            ps.setString(3, address);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(String name, Date dob, String address, int id) {
        java.sql.Date xDob = (java.sql.Date) dob;
        xSql = "update person set name = ?, dob = ?, address = ? where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setDate(2, xDob);
            ps.setString(3, address);
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
