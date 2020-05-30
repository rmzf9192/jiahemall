package com.el.jiahemall.search.controller;

import com.el.jiahemall.common.exception.BizCodeEnume;
import com.el.jiahemall.common.to.es.SkuEsModel;
import com.el.jiahemall.common.utils.R;
import com.el.jiahemall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman.Zhang
 * @date 2020/5/30
 * @description:
 */
@Slf4j
@RequestMapping("/search")
@RestController
public class ElasticSaveController {
    @Autowired
    ProductSaveService productSaveService;

    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels){
        boolean b = false;
        try {
          b =  productSaveService.productStatusUp(skuEsModels);
        } catch (IOException e) {
            log.error("ElasticSearchController 商品上架错误，{}",e);
            e.printStackTrace();
            R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(),BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }

        if(b){
            return R.ok();
        }else{
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(),BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());

        }

    }

}
