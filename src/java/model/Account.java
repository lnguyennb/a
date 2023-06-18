/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lgn
 */

public class Account {

    private int id;
    private int isWriter, isAdmin;
    private String user, pass;

    public Account() {
    }

    public Account(int id, String user, String pass, int isWriter, int isAdmin) {
        this.id = id;
        this.isWriter = isWriter;
        this.isAdmin = isAdmin;
        this.user = user;
        this.pass = pass;
    }

    public int getIsWriter() {
        return isWriter;
    }

    public void setIsWriter(int isWriter) {
        this.isWriter = isWriter;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", isWriter=" + isWriter + ", isAdmin=" + isAdmin + ", user=" + user + ", pass=" + pass + '}';
    }

}
