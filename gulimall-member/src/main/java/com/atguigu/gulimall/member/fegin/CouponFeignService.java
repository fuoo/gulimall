package com.atguigu.gulimall.member.fegin;

import com.atguigu.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fuoo
 * @date 2020/12/14 14:15
 */
@Component
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/smscoupon/member/list")
    R memberCoupon();
}
