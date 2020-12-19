package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public List<CategoryEntity> getParentMenuList() {
        List<CategoryEntity> allMenuList = baseMapper.selectList(null);

        List<CategoryEntity> parentMenuList = allMenuList.stream().filter(category -> {
            return category.getParentCid() == 0;
        }).map(category -> {
            category.setChildren(getChildMenu(allMenuList, category));
            return category;
        }).sorted((menu1, menu2) -> {
            return Optional.of(menu1.getSort()).orElse(0) - Optional.of(menu2.getSort()).orElse(0);
        }).collect(Collectors.toList());

        return parentMenuList;
    }

    private List<CategoryEntity> getChildMenu(List<CategoryEntity> allMenuList, CategoryEntity parentMenu) {
        List<CategoryEntity> childMenuList = allMenuList.stream().filter(category -> {
            return category.getParentCid().equals(parentMenu.getCatId());
        }).map(category -> {
            category.setChildren(getChildMenu(allMenuList, category));
            return category;
        }).sorted((menu1, menu2) -> {
            return Optional.of(menu1.getSort()).orElse(0) - Optional.of(menu2.getSort()).orElse(0);
        }).collect(Collectors.toList());
        return childMenuList;
    }

    @Override
    public void removeMenuByIds(List<Long> catIds) {
        // TODO 缺少删除检查逻辑
        baseMapper.deleteBatchIds(catIds);
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity category) {
        int insert = baseMapper.insert(category);
        category.setCatId((long)insert);
        return category;
    }
}