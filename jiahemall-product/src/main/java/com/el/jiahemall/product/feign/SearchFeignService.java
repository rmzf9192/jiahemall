package com.el.jiahemall.product.feign;

import com.el.jiahemall.common.to.es.SkuEsModel;
import com.el.jiahemall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Roman.Zhang
 * @date 2020/5/30
 * @description:
 */
@FeignClient("jiahemall-search")
public interface SearchFeignService {
    @PostMapping("/search/save/product")
    R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
