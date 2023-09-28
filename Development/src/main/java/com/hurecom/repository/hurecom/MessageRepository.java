package com.hurecom.repository.hurecom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hurecom.entity.hurecom.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

	@Query(value = "select * from hurecom_v2.messages where code = :code", nativeQuery = true)
	MessageEntity getMessageByCode(@Param("code") String code);
}
