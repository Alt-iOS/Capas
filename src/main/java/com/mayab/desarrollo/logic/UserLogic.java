package com.mayab.desarrollo.logic;

import com.mayab.desarrollo.entities.UserPOJO;
import com.mayab.desarrollo.persistance.UserDAO;

import java.util.List;

public class UserLogic {
    public static void main(String[] args){
        UserDAO dao = new UserDAO();
        //test for creating user
        /*
        System.out.println("Test for creating user");
        UserPOJO user= new UserPOJO("Alumno 1", "123", "123@gmail.com");
        int id=dao.createUser(user);
        System.out.println("Logic: " + id);
        */
        //test for finding user by id
        /*
        System.out.println("Test for finding user by id");
        UserPOJO user1 = dao.findById(1);
        System.out.println(user1.getEmail());
        System.out.println(user1.getName());
        System.out.println(user1.getPswrd());
        */
        //test for find all
        /*
        System.out.println("Test for find all");
        List<UserPOJO> userPOJOList = dao.findAll();
        for (UserPOJO userInList : userPOJOList
             ) {
            System.out.println(userInList.getId());
            System.out.println(userInList.getEmail());
            System.out.println(userInList.getName());
            System.out.println(userInList.getPswrd());
        }*/
        //test for update user
        /*
        System.out.println("Test for update user");
        UserPOJO u = new UserPOJO("Alumno 1", "123", "123@gmail.com");
        u.setId(3);
        dao.update(u,"1234");
        */
        //test for delete user
        /*
        System.out.println("Test for delete user");
        dao.deleteUser(11);
        */

    }
}
