package com.julongtech.generator.entity;

import java.io.Serializable;

/**
 * 格式化参数
 * @author julong
 * @date 2023年11月25日 下午5:41:04
 * @desc 
 */
public class DataParam implements Serializable{

	
	/**
	 * @author julong
	 * @date 2023年11月26日 下午1:00:21
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 中文类名
	 * @author julong
	 * @date 2023年11月25日 下午5:41:47
	 */
	private String className;
	/**
	 * 类名首字母大写
	 * @author julong
	 * @date 2023年11月25日 下午5:41:54
	 */
	private String dataIndexUpper;
	/**
	 * 类名首字母小写
	 * @author julong
	 * @date 2023年11月25日 下午5:42:30
	 */
	private String dataIndexLower;
	/**
	 * 主键字段首字母大写
	 * @author julong
	 * @date 2023年11月25日 下午5:42:39
	 */
	private String dataIdUpper;
	/**
	 * 主键字段首字母小写
	 * @author julong
	 * @date 2023年11月25日 下午5:42:50
	 */
	private String dataIdLower;
	/**
	 * 包名
	 * @author julong
	 * @date 2023年11月25日 下午5:42:57
	 */
	private String packages;

	public DataParam() {
		super();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDataIndexUpper() {
		return dataIndexUpper;
	}

	public void setDataIndexUpper(String dataIndexUpper) {
		this.dataIndexUpper = dataIndexUpper;
	}

	public String getDataIndexLower() {
		return dataIndexLower;
	}

	public void setDataIndexLower(String dataIndexLower) {
		this.dataIndexLower = dataIndexLower;
	}

	public String getDataIdUpper() {
		return dataIdUpper;
	}

	public void setDataIdUpper(String dataIdUpper) {
		this.dataIdUpper = dataIdUpper;
	}

	public String getDataIdLower() {
		return dataIdLower;
	}

	public void setDataIdLower(String dataIdLower) {
		this.dataIdLower = dataIdLower;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	/**
	 * @param classname 中文名称
	 * @param dataindexUpper 类名首字母大写
	 * @param dataindexLower 类名首字母小写
	 * @param dataidUpper 主键首字母大写
	 * @param dataidLower 主键首字母小写
	 * @param packages 包名
	 * @author julong
	 * @date 2023年11月26日 上午11:22:46
	 */
	public DataParam(String className, String dataIndexUpper, String dataIndexLower, String dataIdUpper,
			String dataIdLower, String packages) {
		super();
		this.className = className;
		this.dataIndexUpper = dataIndexUpper;
		this.dataIndexLower = dataIndexLower;
		this.dataIdUpper = dataIdUpper;
		this.dataIdLower = dataIdLower;
		this.packages = packages;
	}

}
