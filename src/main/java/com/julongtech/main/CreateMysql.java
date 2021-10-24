package com.julongtech.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * mysql 代码生成
 * @author julong
 * @date 2021年10月20日 下午8:45:29
 * @desc 
 */
public class CreateMysql {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("src/main/resource/generator-mysql.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
	
		org.mybatis.generator.config.Configuration config;
		try {
			//获取配置
			config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("生成成功.....");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
