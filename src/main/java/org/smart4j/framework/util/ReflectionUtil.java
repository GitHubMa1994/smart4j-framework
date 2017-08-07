package org.smart4j.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射工具类（实例化对象）
 * @author mwb
 *
 */
public final class ReflectionUtil {
	private static final Logger LOGGER=LoggerFactory.getLogger(ReflectionUtil.class);
	
	/**
	 * 创建实例
	 */
	public static Object newInstance(Class<?> cls){
		Object Instance;
		try {
			Instance=cls.newInstance();
		} catch (Exception e) {
			LOGGER.error("new instance failure",e);
			throw new RuntimeException(e);
		}
		return Instance;
	}
	
	/**
	 * 调用方法
	 */
	public static Object invokeMethod(Object obj,Method method,Object... args){
		Object result = null;
		try {
			method.setAccessible(true);
			result=method.invoke(obj, args);
		} catch (Exception e) {
			LOGGER.error("invoke method failure",e);
			throw new RuntimeException(e);
		}
		return result;
	}
	
	/**
	 * 设置成员变量
	 */
	public static void setField(Object obj,Field field,Object value){
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			//TODO: handle exception
			LOGGER.error("set field failure",e);
			throw new RuntimeException(e);
		}
	}
}






