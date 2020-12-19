package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author fuoo
 * @email 390983980@qq.com
 * @date 2020-12-14 11:34:53
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
