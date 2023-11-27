package com.julongtech.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.julongtech.generator.entity.DataParam;

public abstract class ClazzGenerator {

	private static final Logger logger = LoggerFactory.getLogger(ClazzGenerator.class);
	
	/**
	 * 中文类名
	 * @author julong
	 * @date 2023年11月26日 下午12:10:49
	 */
	public static final String CLASS_NAME = "CLASSNAME";
	/**
	 * 类名首字母大写
	 * @author julong
	 * @date 2023年11月26日 下午12:10:57
	 */
	public static final String DATA_INDEX = "DATAINDEX";
	/**
	 * 类名首字母小写
	 * @author julong
	 * @date 2023年11月26日 下午12:11:03
	 */
	public static final String data_index = "dataindex";
	/**
	 * 主键字段首字母大写
	 * @author julong
	 * @date 2023年11月26日 下午12:11:11
	 */
	public static final String DATA_ID = "DATAID";
	/**
	 * 主键字段首字母小写
	 * @author julong
	 * @date 2023年11月26日 下午12:11:17
	 */
	public static final String data_id = "dataid";
	/**
	 * 包名
	 * @author julong
	 * @date 2023年11月26日 下午12:11:25
	 */
	public static final String PACKAGES = "PACKAGES";
	
	
	
	/**
	 * 生成对应的文件字符串
	 * @param data
	 * @param param
	 * @param packages
	 * @return
	 * @author julong
	 * @date 2023年11月26日 下午2:45:47
	 * @desc
	 */
	public String generatorClazz(String data,DataParam param,String packages){
		return  data.replaceAll(PACKAGES, packages)
				.replaceAll(CLASS_NAME, param.getClassName())
				.replaceAll(data_index, param.getDataIndexLower())
				.replaceAll(DATA_INDEX, param.getDataIndexUpper())
				.replaceAll(data_id, param.getDataIdLower())
				.replaceAll(DATA_ID, param.getDataIdUpper());
	}
	
	/**
	 * 生成对应的文件夹目录字符串
	 * @param packages
	 * @return
	 * @author julong
	 * @date 2023年11月26日 下午12:17:40
	 * @desc
	 */
	public String generatorFilePath(String packages,String path){
		//保存内容 
		packages = packages.replaceAll("\\.", "/");
		path = path.replaceAll("\\.", "/");
		packages = packages.concat("/" + path);
		return packages;
	}
	
	/**
	 * 生成包路径
	 * @param packages
	 * @param path
	 * @return
	 * @author julong
	 * @date 2023年11月26日 下午12:30:08
	 * @desc
	 */
	public String generatorPackagePath(String packages,String path){
		//保存内容 
		packages = packages.concat("." + path);
		return packages;
	}
}
