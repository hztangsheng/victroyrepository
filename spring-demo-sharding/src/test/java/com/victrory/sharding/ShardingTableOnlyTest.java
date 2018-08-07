package com.victrory.sharding;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.victory.sharding.service.DemoService;

/**
 * 
 *@Description:同库分表测试
 *@Author:唐胜
 *@Since:2018年8月7日下午9:00:09
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml","classpath:spring/spring-shardingtablesonly.xml"}) 
public class ShardingTableOnlyTest {
	
	@Resource
	private DemoService demoService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDemoservice(){
		try {
			demoService.demo();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
