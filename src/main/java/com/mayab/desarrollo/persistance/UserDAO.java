package com.mayab.desarrollo.persistance;
import com.mayab.desarrollo.entities.UserPOJO;

import java.sql.*;
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
    public int createUser(UserPOJO user) {
        String query = "INSERT INTO users(name,password, email) VALUES(?,?,?)";
        Connection con = null;
        PreparedStatement ps=null;
        int result =-1;
        try {
            con=getConnection();
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPswrd());
            ps.setString(3, user.getEmail());
            int id =ps.executeUpdate(); //Cuantas fueron afectadas por el update
            System.out.println(id);
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                user.setId(rs.getInt(1));
            }
            result= user.getId();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
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

    @Override
    public UserPOJO update(UserPOJO user, String password) {
        return null;
    }
}
