package com.hurecom.service;

import com.hurecom.dto.MessageDto;

public interface MessageService {

	MessageDto getMessageByCode(String code);
}
