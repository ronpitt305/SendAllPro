package com.ronone.dao;

import com.ronone.entities.EmailToSend;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SendEmailDao extends CrudRepository<EmailToSend, Long>
{
  <S extends EmailToSend> S save(S s);
  
  EmailToSend findByMessage(String paramString);
}
