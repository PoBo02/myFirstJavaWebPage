package DTO.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
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
        throw new UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public int updateRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Account> listAllByRole(int role) {
        throw new UnsupportedOperationException("Not supported yet.");
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
