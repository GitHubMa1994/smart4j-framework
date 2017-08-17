package org.smart4j.framework.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.MethodProxy;

/**
 * 代理链
 * @author mwb
 *
 */
public class ProxyChain {

	private final Class<?> targetClass;//目标类
	private final Object targetObject;//目标对象
	private final Method targetMethod;//目标方法
	private final MethodProxy methodProxy;//方法代理
	private final Object[] methodParams;//方法参数
	
	/**
	 * 代理列表
	 */
	private  List<Proxy> proxyList=new ArrayList<Proxy>();
	/**
	 * 代理索引
	 */
	private int proxyIndex=0;
	
	public ProxyChain(Class<?> targetClass, Object targetObject,
			Method targetMethod, MethodProxy methodProxy,
			Object[] methodParams, List<Proxy> proxyList) {
		this.targetClass = targetClass;
		this.targetObject = targetObject;
		this.targetMethod = targetMethod;
		this.methodProxy = methodProxy;
		this.methodParams = methodParams;
		this.proxyList = proxyList;
	}

	public Class<?> getTargetClass() {
		return targetClass;
	}

	public Method getTargetMethod() {
		return targetMethod;
	}

	public Object[] getMethodParams() {
		return methodParams;
	}
	
	public Object doProxyChain() throws Throwable{
		Object methodResult;
		if (proxyIndex<proxyList.size()) {
			methodResult=proxyList.get(proxyIndex++).doProxy(this);
		}else {
			methodResult=methodProxy.invokeSuper(targetObject,methodParams);
		}
		return methodResult;
	}
}
