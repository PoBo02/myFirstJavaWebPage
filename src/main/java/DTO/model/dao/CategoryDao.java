package DTO.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao implements Accessable<Category> {
    private SelvetContext sc;
    private Connection con;

    public CategoryDao() throws SQLException, ClassNotFoundException {
    };

    public CategoryDao(SelvetContext sc) throws SQLException, ClassNotFoundException {

    };

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        return sc.getConnection();
    }

    @Override
    public int insertRec(Category obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateRec(Category obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteRec(Category obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Category getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Category> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
