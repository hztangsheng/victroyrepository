

package com.victory.sharding.service;



import com.victory.sharding.dao.OrderItemRepository;
import com.victory.sharding.dao.OrderRepository;
import com.victory.sharding.entity.Order;
import com.victory.sharding.entity.OrderItem;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    
    @Resource
    private OrderRepository orderRepository;
    
    @Resource
    private OrderItemRepository orderItemRepository;

    @Transactional
    public void demo() {
        orderRepository.createIfNotExistsTable();
        orderItemRepository.createIfNotExistsTable();
        orderRepository.truncateTable();
        orderItemRepository.truncateTable();
        List<Long> orderIds = new ArrayList<>(10);
        System.out.println("插入数据--------------");
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(i);
            order.setStatus("INSERT_TEST");
            orderRepository.insert(order);
            long orderId = order.getOrderId();
            orderIds.add(orderId);
                OrderItem item = new OrderItem();
                item.setOrderId(orderId);
                item.setUserId(i);
                item.setStatus("INSERT_TEST");
                orderItemRepository.insert(item);

            
        }
        
        System.out.println("插入后的数据是："+orderItemRepository.selectAll());
        
//       System.out.println("删除数据--------------");
//        for (Long each : orderIds) {
//            orderRepository.delete(each);
//            orderItemRepository.delete(each);
//        }
//        System.out.println("删除后的数据是："+ orderItemRepository.selectAll());
//        orderItemRepository.dropTable();
//        orderRepository.dropTable();
    }
}
