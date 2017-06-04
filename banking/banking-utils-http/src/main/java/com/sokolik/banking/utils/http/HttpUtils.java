package com.sokolik.banking.utils.http;

import javax.servlet.http.HttpServletRequest;

import com.sokolik.banking.utils.StringUtils;



public final class HttpUtils {

	private HttpUtils() {
		throw new com.sokolik.banking.utils.StaticClassInstantiationError();
	}

	public static Integer getIntParam(HttpServletRequest request, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			throw new EmptyParamNameException();
		}

		String valueStr = request.getParameter(paramName);

		try {
			Integer value = new Integer(valueStr);
			return value;
		} catch(NumberFormatException e) {
			return null;
		}
	}
}
