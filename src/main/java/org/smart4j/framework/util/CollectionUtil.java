package org.smart4j.framework.util;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 集合工具类
 * @author mwb
 *
 */
public final class CollectionUtil {

	/**
	 * 判断集合是否为空
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Collection collection){
		return 	!CollectionUtils.isEmpty(collection);
	}
	
	/**
	 * 判断集合是否为空
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Collection collection){
		return 	CollectionUtils.isEmpty(collection);
	}
}
