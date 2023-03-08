package com.mayab.desarrollo.persistance;
import com.mayab.desarrollo.entities.UserPOJO;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
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
    private static void close(Connection con, PreparedStatement st){
        try{
            con.close();
            st.close();
        }
        catch(Exception e)
        {
                e.printStackTrace();
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
        finally {
            close(con, ps);
        }
        return result;
    }

    public List<UserPOJO> findAll() {
        String query ="SELECT * FROM users;";
        Connection con= null;
        PreparedStatement ps=null;
        List<UserPOJO> users = new ArrayList<UserPOJO>();
        try {
            con=getConnection();
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UserPOJO u = new UserPOJO();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPswrd(rs.getString(3));
                u.setEmail(rs.getString(4));
                users.add(u);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            close(con, ps);
        }
        return users;
    }

    public UserPOJO findById(int id) {
        String query ="SELECT * FROM users WHERE id=?;";
        Connection con= null;
        PreparedStatement ps=null;
        UserPOJO u =null;
        try {
            con=getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u = new UserPOJO(rs.getString(2), rs.getString(3), rs.getString(4));
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            close(con, ps);
        }
        return u;
    }

    public boolean deleteUser(int id) {
        String query ="DELETE FROM users WHERE id=?;";
        Connection con= null;
        PreparedStatement ps=null;
        boolean result;
        try {
            con=getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int idQuery = ps.executeUpdate();
            return idQuery==1 ?  true : false;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            close(con, ps);
        }
    }

    @Override
    public UserPOJO update(UserPOJO userArg, String password) {
        String query ="UPDATE users SET password=? WHERE id=?;";
        Connection con= null;
        PreparedStatement ps=null;
        try {
            con=getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, password);
            ps.setInt(2,userArg.getId());
            int row = ps.executeUpdate();
            if(row != 1){
                userArg.setPswrd("");
            }
            else {
                userArg.setPswrd(password);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            close(con, ps);
        }
        return userArg;
    }
}
