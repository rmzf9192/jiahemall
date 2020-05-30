package com.el.jiahemall.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.el.jiahemall.common.to.es.SkuEsModel;
import com.el.jiahemall.search.config.JiaheMallElasticSearchConfig;
import com.el.jiahemall.search.constant.EsConstant;
import com.el.jiahemall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roman.Zhang
 * @date 2020/5/30
 * @description:
 */@Slf4j
@Service
public class ProductSaveServiceImpl implements ProductSaveService {
    @Autowired
    RestHighLevelClient restHighLevelClient;


    @Override
    public boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException {
        //1.建立索引和映射关系
        BulkRequest bulkRequest = new BulkRequest();

        skuEsModels.forEach((item->{
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(item.getSkuId().toString());

            String s= JSON.toJSONString(item);
            bulkRequest.add(indexRequest);
        }));
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, JiaheMallElasticSearchConfig.COMMON_OPTIONS);

        boolean b = bulk.hasFailures();

        List<String> collect = Arrays.stream(bulk.getItems()).map(item -> {
            return item.getId();
        }).collect(Collectors.toList());


        log.error("商品上架错误,{}",collect);

        return b;
    }
}
