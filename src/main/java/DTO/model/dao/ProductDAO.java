package DTO.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.model.Account;
import DTO.model.Category;
import DTO.model.Product;
import DTO.model.ultis.ConnectDB;

public class ProductDAO implements Accessable<Product> {

    private ServletContext sc;
    private Connection con;

    public ProductDAO() {
    }

    public ProductDAO(ServletContext sc) {
        this.sc = sc;
    }

    private Connection getConnection() throws Exception {
        con = new ConnectDB(sc).getConnection();
        return con;
    }

    @Override
    public int insertRec(Product p) {
        String sql = "INSERT INTO products "
                + "(productId, productName, productImage, brief, typeId, account, unit, price, discount) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, p.getProductID());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getProductImage());
            ps.setString(4, p.getBrief());
            ps.setInt(5, p.getType().getTypeID());
            ps.setString(6, p.getAccount().getAccount());
            ps.setString(7, p.getUnit());
            ps.setInt(8, p.getPrice());
            ps.setInt(9, p.getDiscount());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateRec(Product p) {
        String sql = "UPDATE products SET "
                + "productName=?, productImage=?, brief=?, typeId=?, "
                + "unit=?, price=?, discount=? "
                + "WHERE productId=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, p.getProductName());
            ps.setString(2, p.getProductImage());
            ps.setString(3, p.getBrief());
            ps.setInt(4, p.getType().getTypeID());
            ps.setString(5, p.getUnit());
            ps.setInt(6, p.getPrice());
            ps.setInt(7, p.getDiscount());
            ps.setString(8, p.getProductID());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteRec(Product p) {
        String sql = "DELETE FROM products WHERE productId=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, p.getProductID());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Product getObjectById(String id) {
        String sql = "SELECT * FROM products WHERE productId=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getString("productId"));
                p.setProductName(rs.getString("productName"));
                p.setProductImage(rs.getString("productImage"));
                p.setBrief(rs.getString("brief"));
                p.setPostedDate(rs.getDate("postedDate"));
                p.setUnit(rs.getString("unit"));
                p.setPrice(rs.getInt("price"));
                p.setDiscount(rs.getInt("discount"));

                Category c = new Category();
                c.setTypeID(rs.getInt("typeId"));
                p.setType(c);

                Account a = new Account();
                a.setAccount(rs.getString("account"));
                p.setAccount(a);

                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> listAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getString("productId"));
                p.setProductName(rs.getString("productName"));
                p.setProductImage(rs.getString("productImage"));
                p.setBrief(rs.getString("brief"));
                p.setPostedDate(rs.getDate("postedDate"));
                p.setUnit(rs.getString("unit"));
                p.setPrice(rs.getInt("price"));
                p.setDiscount(rs.getInt("discount"));

                Category c = new Category();
                c.setTypeID(rs.getInt("typeId"));
                p.setType(c);

                Account a = new Account();
                a.setAccount(rs.getString("account"));
                p.setAccount(a);

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> listByCategory(int categoryId) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE typeId=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getString("productId"));
                p.setProductName(rs.getString("productName"));
                p.setProductImage(rs.getString("productImage"));
                p.setBrief(rs.getString("brief"));
                p.setPostedDate(rs.getDate("postedDate"));
                p.setUnit(rs.getString("unit"));
                p.setPrice(rs.getInt("price"));
                p.setDiscount(rs.getInt("discount"));

                Category c = new Category();
                c.setTypeID(categoryId);
                p.setType(c);

                Account a = new Account();
                a.setAccount(rs.getString("account"));
                p.setAccount(a);

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}