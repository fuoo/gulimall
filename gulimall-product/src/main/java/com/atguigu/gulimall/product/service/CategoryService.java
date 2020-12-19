package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author fuoo
 * @email 390983980@qq.com
 * @date 2020-12-14 10:32:40
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     * 查询商品分类菜单
     * @return java.util.List<com.atguigu.gulimall.product.entity.CategoryEntity>
     * @author fuoo
     * @date 2020/12/18 15:11
     */
    List<CategoryEntity> getParentMenuList();

    /**
     * 批量删除商品分类
     * @param catIds 分类ids
     * @return void
     * @author fuoo
     * @date 2020/12/18 14:19
     */
    void removeMenuByIds(List<Long> catIds);

    /**
     * 保存商品分类菜单
     * @param category
     * @return
     */
    CategoryEntity saveCategory(CategoryEntity category);
}

