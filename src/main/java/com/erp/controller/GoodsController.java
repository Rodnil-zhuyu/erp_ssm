package com.erp.controller;

import com.erp.pojo.Goods;
import com.erp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/list")
    public List<Goods> list(Goods goods,
                            @RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "2") int pageSize){
        return goodsService.selectByExample(goods,pageNum,pageSize);
    }

}
