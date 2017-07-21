package com.ronone.dao;

import com.ronone.entities.Contact;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ContactDao extends CrudRepository<Contact, Long>
{
  <S extends Contact> S save(S paramS);
  
  Contact findOne(Long paramLong);
  
  Contact findByContactName(String paramString);
}
