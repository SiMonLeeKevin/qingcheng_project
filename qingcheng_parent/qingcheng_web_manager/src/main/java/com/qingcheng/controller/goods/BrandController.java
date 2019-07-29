package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @GetMapping("/findAll")
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @GetMapping("/findPage")
    public PageInfo<Brand> findPage(int page, int size) {
        return brandService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Brand> findList(@RequestBody Map<String, Object> searchMap) {
        return brandService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageInfo<Brand> findPage(@RequestBody Map<String, Object> serarchMap, int page, int size) {
        return brandService.findPage(serarchMap, page, size);
    }

    @GetMapping("/findById")
    public Brand findById(Integer id) {
        return brandService.findById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Brand brand) {
        brandService.update(brand);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id) {
        brandService.delete(id);
        return new Result();
    }
}
