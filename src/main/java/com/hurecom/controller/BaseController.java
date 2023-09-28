package com.hurecom.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.hurecom.dto.MessageDto;
import com.hurecom.dto.ResponseDto;
import com.hurecom.service.MessageService;

public class BaseController {

	@Autowired
	MessageService messageService;

	public ResponseDto buildResponse(String code) {
		ResponseDto responseDto = new ResponseDto();
		MessageDto messageDto = messageService.getMessageByCode(code);

		if (Objects.nonNull(messageDto)) {
			responseDto.setStatus(messageDto.getType());
			responseDto.setMessage(messageDto.getMessage());
		}
		return responseDto;
	}

	public ResponseDto buildResponse(String code, Long id) {
		ResponseDto responseDto = new ResponseDto();
		MessageDto messageDto = messageService.getMessageByCode(code);

		responseDto.setId(id);
		if (Objects.nonNull(messageDto)) {
			responseDto.setStatus(messageDto.getType());
			responseDto.setMessage(messageDto.getMessage());
		}
		return responseDto;
	}
}
