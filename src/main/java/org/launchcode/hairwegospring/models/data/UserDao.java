package org.launchcode.hairwegospring.models.data;

import org.launchcode.hairwegospring.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    User getOne(Integer userId);

    //User findOne(Integer userId);

}
