package com.mayab.desarrollo.persistance;
import com.mayab.desarrollo.entities.UserPOJO;

import java.util.List;

public interface IUserDAO {
    public int createUser(UserPOJO User);
    public List<UserPOJO> findAll();
    public UserPOJO findById(UserPOJO user);
    public boolean deleteUser(int id);

}
