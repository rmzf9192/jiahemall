package com.el.jiahemall.search.service;

import com.el.jiahemall.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman.Zhang
 * @date 2020/5/30
 * @description:
 */
public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;

}
