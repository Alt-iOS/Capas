package com.mayab.desarrollo.persistance;
import com.mayab.desarrollo.entities.UserPOJO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO{
    private static final String DRIVER_NAME= "com.qlite.jdbc.Driver";
    private static final String DB_URL = "jdbc:sqlite:/Users/victor/Documents/Universidad/Semestre_6/Ingenieria_de_soft_II/ProyectoGIT/Capas/Login.db";
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(DB_URL,"","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int createUser(UserPOJO User) {
        return 0;
    }

    public List<UserPOJO> findAll() {
        return null;
    }

    public UserPOJO findById(UserPOJO user) {
        return null;
    }

    public boolean deleteUser(int id) {
        return false;
    }
}
