package com.mayab.desarrollo.logic;

import com.mayab.desarrollo.entities.UserPOJO;
import com.mayab.desarrollo.persistance.UserDAO;

public class UserLogic {
    public static void main(String[] args){
        UserPOJO user= new UserPOJO("Alumno 1", "123", "123@gmail.com");
        UserDAO dao = new UserDAO();
        int id=dao.createUser(user);
        System.out.println("Logic: " + id);
    }
}
