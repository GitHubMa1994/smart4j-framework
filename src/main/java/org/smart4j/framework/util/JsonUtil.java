package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON工具类
 * @author mwb
 *
 */
public final class JsonUtil {
	private static final Logger LOGGER=LoggerFactory.getLogger(JsonUtil.class);
	
	private static final ObjectMapper OBJECT_MAPPER=new ObjectMapper();
	
	/**
	 * POJO转Json
	 */
	public static <T> String toJson(Object obj){
		String json=new String();
		try {
			json=OBJECT_MAPPER.writeValueAsString(obj);
		} catch (Exception e) {
			LOGGER.error("convert POJO to JSON failure",e);
			throw new RuntimeException(e);
		}
		return json;
	}
	
	/**
	 * JSON转POJO
	 */
	public static <T> T fromJson(String json,Class<T> type){
		T pojo=null;
		try {
			pojo=OBJECT_MAPPER.readValue(json, type);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("convert JSON to POJO failure",e);
		}
		return pojo;
	}
	
}
