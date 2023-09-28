package com.hurecom.service;

import java.util.List;

import com.hurecom.dto.ValueSetDto;

public interface ValueSetService {

	List<ValueSetDto> getValueSetsByCode(ValueSetDto valueSetDto);
}
