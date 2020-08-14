/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoctm.book;

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
public class BookDAO implements Serializable {

//
    private List<BookDTO> bookList;

    public List<BookDTO> getBookList() {
        return bookList;
    }

    public List<BookDTO> BookView() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<BookDTO> bookList = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select bookID, bookName, price"
                        + " from tblBookList";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int bookID = rs.getInt("bookID");
                    String bookName = rs.getString("bookName");;
                    float price = rs.getFloat("price");
                    BookDTO dto = new BookDTO(bookID, bookName, price);
                    if(this.bookList == null){
                        this.bookList = new ArrayList<>();
                    }
                    this.bookList.add(dto);
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
        return bookList;
    }
}
