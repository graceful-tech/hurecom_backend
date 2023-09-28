package com.hurecom.repository.hurecom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hurecom.entity.hurecom.ValueSetEntity;



@Repository
public interface ValueSetRepository extends JpaRepository<ValueSetEntity, Long> {

	@Query(value = "select * from hurecom_v2.value_sets where value_set_code = :valueSetCode", nativeQuery = true)
	List<ValueSetEntity> getValueSetsByCode(@Param("valueSetCode") String valueSetCode);

}
