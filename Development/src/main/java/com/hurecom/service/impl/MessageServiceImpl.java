package com.hurecom.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurecom.dto.MessageDto;
import com.hurecom.entity.hurecom.MessageEntity;
import com.hurecom.repository.hurecom.MessageRepository;
import com.hurecom.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public MessageDto getMessageByCode(String code) {
		logger.debug("Service :: getMessageByCode :: Entered");
		MessageDto message = null;
		try {
			MessageEntity messageEntity = messageRepository.getMessageByCode(code);
			message = modelMapper.map(messageEntity, MessageDto.class);
		} catch (Exception e) {
			logger.debug("Service :: getMessageByCode :: Exception :: " + e);
		}
		logger.debug("Service :: getMessageByCode :: Exited");
		return message;
	}

}
