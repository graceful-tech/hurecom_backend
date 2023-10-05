package com.hurecom.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	public static String appendLikeOperator(String input) {
		StringBuilder sb = new StringBuilder();
		sb.append("%");
		sb.append(input);
		sb.append("%");
		return sb.toString();
	}

}
