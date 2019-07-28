package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.pojo.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl  implements BrandService{

    /**
     * 导入通用mapper
     */
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 调用通用mapper的selectAll方法查询所有
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 根据当前页，当前页大小
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        List<Brand> brandList = brandMapper.selectAll();
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return pageInfo;
    }

    /**
     * 条件查询
     * @param serarchMap
     * @return
     */
    @Override
    public List<Brand> findList(Map<String, Object> serarchMap) {
        Example example = createExample(serarchMap);
        return brandMapper.selectByExample(example);
    }

    private Example createExample(Map<String, Object> serarchMap){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(serarchMap !=null){
            //判断名称条件
            if (serarchMap.get("name") != null && !"".equals(serarchMap.get("name"))) {
                criteria.andLike("name","%"+(String) serarchMap.get("name")+"%");
            }
            //判断首字母
            if(serarchMap.get("letter")!=null && !"".equals(serarchMap.get("letter"))){
                criteria.andEqualTo("letter",serarchMap.get("letter"));
            }
        }
        return example;
    }


    @Override
    public PageInfo<Brand> findPage(Map<String, Object> serachMap, int page, int size) {
        PageHelper.startPage(page,size);
        List<Brand> brandList = brandMapper.selectAll();
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return pageInfo;
    }

    @Override
    public Brand findById(Integer id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
    }
}
