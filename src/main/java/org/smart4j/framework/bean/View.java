package org.smart4j.framework.bean;

import java.util.Map;

/**
 * 返回视图对象
 * @author mwb
 *
 */
public class View {

	/**
	 * 视图路径
	 */
	private String path;
	
	/**
	 * 模型数据
	 */
	private Map<String,Object> model;
	
	public View(String path){
		this.path=path;
	}

	public View(String path, Map<String, Object> model) {
		this.path = path;
		this.model = model;
	}

	public String getPath() {
		return path;
	}

	public Map<String, Object> getModel() {
		return model;
	}
	
	
}
