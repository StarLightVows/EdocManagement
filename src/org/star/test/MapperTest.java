package org.star.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class MapperTest {

	@Test
	public void generatorTest() throws Exception{
	   List<String> warnings = new ArrayList<String>();
	   boolean overwrite = true;
	   File configFile = new File("resources/generatorConfig.xml");
	   ConfigurationParser cp = new ConfigurationParser(warnings);
	   org.mybatis.generator.config.Configuration config = cp.parseConfiguration(configFile);
	   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
	   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
	   myBatisGenerator.generate(null);
	   System.err.println("生成成功");
	}
	
	@Test
	public void userMapperTest(){
		System.err.println(11);
	}
}
