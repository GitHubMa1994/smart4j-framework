package org.smart4j.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;

/**
 * 控制器助手类
 * @author mwb
 *
 */
public final class ControllerHelper {
	/**
	 * 存放请求和处理器的映射关系
	 */
	private static final Map<Request, Handler> ACTION_MAP=new HashMap<Request, Handler>();
	
	static{
		//获取所有的Controller类
		Set<Class<?>> controllerClassSet=ClassHelper.getControllerClassSet();
		if (CollectionUtil.isNotEmpty(controllerClassSet)) {
			for (Class<?> controllerClass : controllerClassSet) {
				//获取controllerClass定义的方法
				Method[] methods=controllerClass.getMethods();
				if (ArrayUtil.isNotEmpty(methods)) {
					for (Method method : methods) {
						//检查方法是否带有action注解
						if (method.isAnnotationPresent(Action.class)) {
							//从注解中获得url的映射规则
							Action action=method.getAnnotation(Action.class);
							String mapping=action.value();
							//验证映射规则
							if (mapping.matches("\\w+:/\\w*")) {
								String[] array=mapping.split(":");
								if (ArrayUtil.isNotEmpty(array)&&array.length==2) {
									String requestMethod=array[0];
									String requestPath=array[1];
									Request request=new Request(requestMethod, requestPath);
									Handler handler=new Handler(controllerClass, method);
									//初始化Action Map
									ACTION_MAP.put(request, handler);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 从ACTION_MAP中获取Handler
	 */
	public static Handler getHandler(String requestMethod,String requestPath){
		Request request=new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
	
}




