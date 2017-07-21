package com.ronone.dao;

import com.ronone.entities.EmailUser;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EmailUserDao extends CrudRepository<EmailUser, Long>
{
  <S extends EmailUser> S save(S paramS);
  
  Iterable<EmailUser> findAll();
  
  EmailUser findOne(Long paramLong);
  
  EmailUser findByUsername(String paramString);
}
