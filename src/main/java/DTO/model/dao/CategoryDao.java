package DTO.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.model.Category;
import DTO.model.ultis.ConnectDB;

public class CategoryDao implements Accessable<Category> {

    private ServletContext sc;
    private Connection con;

    public CategoryDao() throws SQLException, ClassNotFoundException {
    }

    public CategoryDao(ServletContext sc) throws SQLException, ClassNotFoundException {
        this.sc = sc;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        con = new ConnectDB(sc).getConnection();
        return con;
    }

    @Override
    public int insertRec(Category obj) {
        String sql = "INSERT INTO categories(categoryName, memo) VALUES (?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, obj.getCategoryName());
            ps.setString(2, obj.getMemo());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateRec(Category obj) {
        String sql = "UPDATE categories SET categoryName = ?, memo = ? WHERE typeID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, obj.getCategoryName());
            ps.setString(2, obj.getMemo());
            ps.setInt(3, obj.getTypeID());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteRec(Category obj) {
        String sql = "DELETE FROM categories WHERE typeID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getTypeID());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Category getObjectById(String id) {
        String sql = "SELECT * FROM categories WHERE typeID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setTypeID(rs.getInt("typeID"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setMemo(rs.getString("memo"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> listAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setTypeID(rs.getInt("typeID"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setMemo(rs.getString("memo"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}