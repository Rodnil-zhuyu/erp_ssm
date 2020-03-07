package com.erp.service.impl;

import com.erp.mapper.GoodsMapper;
import com.erp.pojo.Goods;
import com.erp.pojo.GoodsExample;
import com.erp.service.GoodsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> selectByExample(Goods goods,int pageNum,int pageSize) {

        //在查询之前先设置分页--自动进行分页查询
        PageHelper.startPage(pageNum,pageSize);

        GoodsExample example =new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        //添加模糊查询
        if(goods.getName()!=null){
            criteria.andNameLike("%"+goods.getName()+"%");
        }
        return goodsMapper.selectByExample(example);
    }
}
