package DTO.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.model.Category;
import DTO.model.ultis.ConnectDB;

public class CategoryDao implements Accessable<Category> {
    private ServletContext sc;
    private Connection con;

    public CategoryDao() throws SQLException, ClassNotFoundException {
    };

    public CategoryDao(ServletContext sc) throws SQLException, ClassNotFoundException {
        this.sc = sc;
    };

    private Connection getConnection() throws SQLException,
            ClassNotFoundException {
        con = new ConnectDB(sc).getConnection();
        return con;
    }

    @Override
    public int insertRec(Category obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int updateRec(Category obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteRec(Category obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Category getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Category> listAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
