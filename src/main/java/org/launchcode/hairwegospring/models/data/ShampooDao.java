package org.launchcode.hairwegospring.models.data;

import org.launchcode.hairwegospring.models.Shampoo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface ShampooDao extends CrudRepository<Shampoo,Integer> {
}
