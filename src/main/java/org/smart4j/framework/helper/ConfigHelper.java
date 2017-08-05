package org.smart4j.framework.helper;

import java.util.Properties;

import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropsUtil;

public final class ConfigHelper {
	
	private static final Properties CONFIG_PROPS=PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
	
	/**
	 * 获得JDBC驱动
	 */
	public static String getJdbcDriver(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
	}
	
	/**
	 * 获得JDBC url
	 */
	public static String getJdbcUrl(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}
	
	/**
	 * 获得username
	 */
	public static String getJdbcUsername(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}
	
	/**
	 * 获得Password
	 */
	public static String getJdbcPassword(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}
	
	/**
	 * 获取基础应用包
	 */
	public static String getAppBasePackage(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}
	
	/**
	 * 获取应用JSP路径
	 */
	public static String getAppJspPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
	}
	
	/**
	 * 获取静态资源路径
	 */
	public static String getAppAssetPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH,"/asset/");
	}
}
