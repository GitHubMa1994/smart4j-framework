package org.smart4j.framework.proxy;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 切面代理
 * @author mwb
 *
 */
public abstract class AspectProxy implements Proxy {

	private static final Logger LOGGER=LoggerFactory.getLogger(AspectProxy.class);
	
	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Object result=null;
		Class<?> cls=proxyChain.getTargetClass();
		Method method=proxyChain.getTargetMethod();
		Object[] params=proxyChain.getMethodParams();
		
		begin();
		try {
			if (intercept(cls, method, params)) {
				before(cls, method, params);
				result=proxyChain.doProxyChain();
				after(cls, method, params, result);
			}else {
				result=proxyChain.doProxyChain();
			}
		} catch (Exception e) {
			LOGGER.error("proxy failure",e);
			result=proxyChain.doProxyChain();
			error(cls, method, params, e);
			throw e;
		}finally{
			end();
		}
		return result;
	}
	
	private void begin(){

	}
	
	private boolean intercept(Class<?> cls,Method method,Object[] params){
		return true;
	}
	
	private void before(Class<?> cls,Method method,Object[] params) {

	}
	
	private void after(Class<?> cls,Method method,Object[] params,Object result) {

	}
	
	private void error(Class<?> cls,Method method,Object[] params,Throwable throwable) {

	}
	
	private void end() {

	}
}
