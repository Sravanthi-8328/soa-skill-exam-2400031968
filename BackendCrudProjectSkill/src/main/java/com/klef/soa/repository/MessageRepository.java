
package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
 
	 List<Message> findByName(String name);
	 List<Message> findByType(String type);
	
}
