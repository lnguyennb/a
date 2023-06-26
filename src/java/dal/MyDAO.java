/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lgn
 */
public class MyDAO extends DBContext {

    protected PreparedStatement ps = null;
    protected ResultSet rs = null;
    protected String xSql = null;
}
