package com.victory.sharding.algorithm;

import java.util.Collection;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
/**
 * 
 *@Description:<sharding:standard-strategy />
              精确分片算法引用，用于=和IN。该类需实现PreciseShardingAlgorithm接口
 *@Author:唐胜
 *@Since:2018年8月7日下午2:23:09
 */
public class PreciseShardingDataBaseAlgorithmImpl implements PreciseShardingAlgorithm<Integer>{
	@Override
	public String doSharding(Collection<String> availableTargetNames,PreciseShardingValue<Integer> shardingValue) {
		Integer currentuserId = 	shardingValue.getValue();
System.out.println("当前操作的currentuserId的值是"+currentuserId);      
		for (String each : availableTargetNames) {
            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
System.out.println("操作的数据库是："+each);            	
                return each;
            }
        }
		return null;
	}

}
