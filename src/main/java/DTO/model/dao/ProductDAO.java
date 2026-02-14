package DTO.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.model.Product;
import DTO.model.ultis.ConnectDB;

public class ProductDAO implements Accessable<Product> {
    private ServletContext sc;
    private Connection con;

    public ProductDAO() throws ClassNotFoundException, SQLException {
    }

    public ProductDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
    }

    private Connection getConnection() throws SQLException,
            ClassNotFoundException {
        con = new ConnectDB(sc).getConnection();
        return con;
    }

    @Override
    public int insertRec(Product obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int updateRec(Product obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteRec(Product obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public java.util.List<Product> listAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Product> listByCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
