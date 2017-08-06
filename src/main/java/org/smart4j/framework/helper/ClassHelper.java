package org.smart4j.framework.helper;

import java.util.HashSet;
import java.util.Set;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
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
	
	/**
	 * 获得应用包下service类
	 */
	public static Set<Class<?>> getServiceClassSet(){
		Set<Class<?>> classSet=new HashSet<Class<?>>();
		for (Class<?> cls : classSet) {
			if (cls.isAnnotationPresent(Service.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	/**
	 * 获得应用包下Controller类
	 */
	public static Set<Class<?>> getControllerClassSet(){
		Set<Class<?>> classSet=new HashSet<Class<?>>();
		for (Class<?> cls : classSet) {
			if (cls.isAnnotationPresent(Controller.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	/**
	 *  获取Bean
	 */
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> classSet=new HashSet<Class<?>>();
		classSet.addAll(getServiceClassSet());
		classSet.addAll(getControllerClassSet());
		return classSet;
	}
}


