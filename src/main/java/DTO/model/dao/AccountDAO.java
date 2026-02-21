package DTO.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.model.Account;
import DTO.model.ultis.ConnectDB;

public class AccountDAO implements Accessable<Account> {
    private ServletContext sc;
    private Connection con;

    public AccountDAO() throws ClassNotFoundException, SQLException {
    }

    public AccountDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
    }

    private Connection getConnection() throws SQLException,
            ClassNotFoundException {
        con = new ConnectDB(sc).getConnection();
        return con;
    }

    @Override
    public int insertRec(Account obj) {
        String sql = "INSERT INTO Account VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, obj.getAccount());
            ps.setString(2, obj.getPass());
            ps.setString(3, obj.getLastName());
            ps.setString(4, obj.getFirstName());
            ps.setDate(5, obj.getBirthday());
            ps.setBoolean(6, obj.isGender());
            ps.setString(7, obj.getPhone());
            ps.setBoolean(8, obj.isIsUsed());
            ps.setInt(9, obj.getRoleInSystem());
            int kq = ps.executeUpdate();

            if (kq != 0) {
                return kq;

            } else {
                throw new  SQLException();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateRec(Account obj) {
        String sql = "UPDATE Account SET pass=?, lastName=?, firstName=?, birthday=?, gender=?, phone=?, isUsed=?, roleInSystem=? WHERE account=?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, obj.getPass());
            ps.setString(2, obj.getLastName());
            ps.setString(3, obj.getFirstName());
            ps.setDate(4, obj.getBirthday());
            ps.setBoolean(5, obj.isGender());
            ps.setString(6, obj.getPhone());
            ps.setBoolean(7, obj.isIsUsed());
            ps.setInt(8, obj.getRoleInSystem());
            ps.setString(9, obj.getAccount());

            int kq = ps.executeUpdate();

            if (kq != 0) {
                return kq;

            } else {
                throw new SQLException();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //
    @Override
    public int deleteRec(Account obj) {
        String sql = "Delete from Account Where account=?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, obj.getAccount());
            int kq = ps.executeUpdate();

            if (kq != 0) {
                return kq;

            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Account> listAllByRole(int role) {
        List<Account> list = new ArrayList<>();
        String sql = "Select * From Account Where role=?";

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, role);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Account(
                        rs.getString("account"),
                        rs.getString("pass"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getDate("birthday"),
                        rs.getBoolean("gender"),
                        rs.getString("phone"),
                        rs.getBoolean("isUsed"),
                        rs.getInt("roleInSystem")));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Account getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Account> listAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int updateIsUsed(String acc, boolean isUsed) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Account loginSuccess(String acc, String pass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
