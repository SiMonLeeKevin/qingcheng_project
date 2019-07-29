package com.qingcheng.service.goods;

import com.github.pagehelper.PageInfo;
import com.qingcheng.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * 品牌业务逻辑层接口
 */
public interface BrandService {
    /**
     * 查询所有的物品
     *
     * @return
     */
    List<Brand> findAll();

    /**
     * 品牌的分页列表
     *
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(int page, int size);

    /**
     * 品牌条件查询
     *
     * @param serarchMap
     * @return
     */
    List<Brand> findList(Map<String, Object> serarchMap);

    /**
     * 品牌条件加 分页查询
     *
     * @param serachMap
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Map<String, Object> serachMap, int page, int size);

    /**
     * 根据ID进行查询
     *
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 新加商品
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改品牌信息
     * @param brand
     */
    void update(Brand brand);

    /**
     * 根据id进行删除
     * @param id
     */
    void delete(Integer id);
}
