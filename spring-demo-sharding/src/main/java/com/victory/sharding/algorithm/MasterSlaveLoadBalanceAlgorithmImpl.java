package com.victory.sharding.algorithm;

import io.shardingsphere.core.api.algorithm.masterslave.MasterSlaveLoadBalanceAlgorithm;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: tangsheng
 * @Date: 2018/8/7 09:46
 * @Description: 根据自己当前的业务关系，指定响应的查询策略
 */

public class MasterSlaveLoadBalanceAlgorithmImpl implements MasterSlaveLoadBalanceAlgorithm {

    @Override
    public String getDataSource(String name, final String masterDataSourceName, final List<String> slaveDataSourceNames) {
    	
System.out.println("开始使用读的策略....");
System.out.println("当前使用的datasource的名称是name="+name);
System.out.println("主的数据库名称是masterDataSourceName="+masterDataSourceName);
System.out.println("备份从数据库名称是slaveDataSourceNames="+slaveDataSourceNames);
System.out.println("选定从数据库名称是="+slaveDataSourceNames.get(0));
        return slaveDataSourceNames.get(0);//可以自己按照实际业务需要，进行数据库名称返回
    }
}
