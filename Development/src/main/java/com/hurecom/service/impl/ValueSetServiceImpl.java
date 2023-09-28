package com.hurecom.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurecom.dto.ValueSetDto;
import com.hurecom.entity.hurecom.ValueSetEntity;
import com.hurecom.repository.hurecom.ValueSetRepository;
import com.hurecom.service.ValueSetService;

@Service
public class ValueSetServiceImpl implements ValueSetService {

	private static final Logger logger = LoggerFactory.getLogger(ValueSetServiceImpl.class);

	@Autowired
	ValueSetRepository valueSetRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ValueSetDto> getValueSetsByCode(ValueSetDto valueSetDto) {
		logger.debug("Service :: getValueSetsByCode :: Entered");
		List<ValueSetDto> valueSets = new ArrayList<>();
		try {
			List<ValueSetEntity> valueSetEntities = valueSetRepository
					.getValueSetsByCode(valueSetDto.getValueSetCode());

			valueSetEntities.forEach(entity -> {
				valueSets.add(modelMapper.map(entity, ValueSetDto.class));
			});

		} catch (Exception e) {
			logger.error("Service :: getValueSetsByCode :: Exception :: " + e.getMessage());
		}
		logger.debug("Service :: getValueSetsByCode :: Exited");
		return valueSets;
	}

}
