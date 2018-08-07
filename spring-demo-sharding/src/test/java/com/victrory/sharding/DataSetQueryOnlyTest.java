package com.victrory.sharding;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.victory.sharding.service.DemoService;
/**
 * 
 *@Description:读写分离测试
 *@Author:唐胜
 *@Since:2018年8月7日下午2:44:42
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml","classpath:spring/sharding-databasequeryonly.xml"}) 
public class DataSetQueryOnlyTest {
	@Resource
	private DemoService demoService;

   @Test
   public void testDemoService(){
	   try {
		   demoService.demo();
		} catch (Exception e) {
		}
	 
	   
   }
	
}
