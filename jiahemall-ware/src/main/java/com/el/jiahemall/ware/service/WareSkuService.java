package com.el.jiahemall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.el.jiahemall.common.to.SkuHasStockVo;
import com.el.jiahemall.common.utils.PageUtils;
import com.el.jiahemall.ware.entity.WareSkuEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:59:40
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);


    List<SkuHasStockVo> getSkusHasStok(List<Long> skuIds);
}

