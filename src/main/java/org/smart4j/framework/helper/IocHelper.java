package org.smart4j.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;

/**
 * 依赖注入助手类
 */
public final class IocHelper {
	static{
		//获取所有的bean类与实例间的映射关系(Bean Map)
		Map<Class<?>,Object> beanMap=BeanHelper.getBeanMap();
		if (!beanMap.isEmpty()) {
			//遍历Map
			for (Map.Entry<Class<?>, Object> beanEntry: beanMap.entrySet()) {
				Class<?> beanClass=beanEntry.getKey();
				Object beanInstance=beanEntry.getValue();
				//获取Bean类定义的所有成员遍历
				Field[] beanFields = beanClass.getDeclaredFields();
				if (ArrayUtil.isNotEmpty(beanFields)) {
					//遍历成员变量
					for (Field beanField : beanFields) {
						//判断成员变量是否带有Inject注解
						if (beanField.isAnnotationPresent(Inject.class)){
							//在BeanMap中获取BeanField对应的实例
							Class<?> beanFieldClass=beanField.getType();
						}
					}
				}
			}
		}
	}
}
