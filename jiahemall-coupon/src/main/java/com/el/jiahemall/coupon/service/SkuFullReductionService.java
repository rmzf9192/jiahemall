package com.el.jiahemall.coupon.service;

import com.el.jiahemall.common.to.SkuReductionTo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.el.jiahemall.common.utils.PageUtils;
import com.el.jiahemall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:36:40
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo reductionTo);


}

