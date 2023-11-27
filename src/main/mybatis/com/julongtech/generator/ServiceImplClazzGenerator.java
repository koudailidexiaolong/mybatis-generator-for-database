package com.julongtech.generator;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.julongtech.generator.entity.DataParam;

public class ServiceImplClazzGenerator extends ClazzGenerator{

	private static final Logger logger = LoggerFactory.getLogger(ServiceImplClazzGenerator.class);
	
	private final static String FILE_NAME = "ServiceImpl.java";
	
	private final static String PACKAGE_NAME = "service.impl";
	
	public final static String TEMPLATE_NAME = "TemplateServiceImpl.ftl";
	
	/**
	 * 生成文件
	 * @param data
	 * @param param
	 * @return
	 * @throws IOException
	 * @author julong
	 * @date 2023年11月26日 下午1:01:00
	 * @desc
	 */
	public boolean createClazzFile(String data,DataParam param) throws IOException{
		//文件路径
		String filePath = super.generatorFilePath(param.getPackages(),PACKAGE_NAME);
		//文件中对应的package 名称
		String packages = super.generatorPackagePath(param.getPackages(), PACKAGE_NAME);
		String newData = super.generatorClazz(data, param,packages);
		String newFile = "src/main/java/"+ filePath + "/" + param.getDataIndexUpper() + FILE_NAME;
		FileUtils.writeStringToFile(FileUtils.getFile(newFile), newData,"utf-8");
		logger.info("【service.impl模板】-生成service.impl成功");
		return true;
	}
}
