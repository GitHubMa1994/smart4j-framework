package org.smart4j.framework.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 编码解密操作工具类
 * @author mwb
 *
 */
public final class CodecUtil {

	private static final Logger LOGGER=LoggerFactory.getLogger(CodecUtil.class);
	
	/**
	 * URL编码
	 */
	public static String encodeURL(String source){
		String target=null;
		try {
			target=URLEncoder.encode(source,"UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("encode url failure",e);
			throw new RuntimeException(e);
		}
		return target;
	}
	
	/**
	 * URL解码
	 */
	public static String decodeURL(String source){
		String target=null;
		try {
			target=URLDecoder.decode(source,"UTF-8");
		} catch (Exception e) {
			LOGGER.error("decoder url failure",e);
		}
		return target;
	}
}
