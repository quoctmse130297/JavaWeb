/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoctm.userAccount;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import quoctm.utils.DBHelper;

/**
 *
 * @author SE130297
 */
public class UserDAO implements Serializable {

    private UserDTO userdto;

    public UserDTO getUserdto() {
        return userdto;
    }

    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            con = DBHelper.makeConnection();
            String sql = "select lastname, isAdmin "
                    + "from tblStudent1 "
                    + "where username = ? and password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                String lastname = rs.getString("lastname");
                userdto = new UserDTO(username, lastname);
                check = true;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    private List<UserDTO> userList;

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void SearchLastName(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT username, password, lastname, isAdmin "
                        + "from tblStudent1 "
                        + "where lastname LIKE ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + searchValue + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    UserDTO dto = new UserDTO(username, password, lastname, isAdmin);
                    if (this.userList == null) {
                        this.userList = new ArrayList<>();
                    }
                    this.userList.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean DeleteAccount(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "DELETE from tblStudent1 "
                        + "where username = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean UpdateAccount(String password, String lastname, boolean isAdmin, String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Update tblStudent1 "
                        + "Set password = ? ,isAdmin = ? "
                        + "where username = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, password);
                ps.setBoolean(2, isAdmin);
                if (isAdmin) {
                    ps.setString(2, "1");
                } else {
                    ps.setString(2, "0");
                }
                ps.setString(3, username);
                boolean check = ps.executeUpdate() > 0;
                if (check) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean SignUpAccount(String username, String password, String lastname, boolean isAdmin) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelper.makeConnection();
            String sql = "Insert into tblStudent1 (username, password, lastname, isAdmin) "
                    + "values (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, lastname);
            ps.setBoolean(4, isAdmin);
            int row = ps.executeUpdate();
            if(row > 0){
                return true;
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
