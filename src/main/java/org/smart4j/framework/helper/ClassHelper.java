package org.smart4j.framework.helper;

import java.util.Set;

import org.smart4j.framework.util.ClassUtil;

/**
 * 类操作助手
 * @author mwb
 */
public final class ClassHelper {

	/**
	 * 定义类集合
	 */
	private static final Set<Class<?>> CLASS_SET;

	static{
		String basePackage=ConfigHelper.getAppBasePackage();
		CLASS_SET=ClassUtil.getClassSet(basePackage);
	}
	
	public Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
}
