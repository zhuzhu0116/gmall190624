package com.atguigu.gmall0624.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall0624.bean.SkuInfo;
import com.atguigu.gmall0624.bean.SkuSaleAttrValue;
import com.atguigu.gmall0624.bean.SpuSaleAttr;
import com.atguigu.gmall0624.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class ItemController {
    @Reference
    private ManageService manageService;
    @RequestMapping("{skuId}.html")
    public String skuInfoPage(@PathVariable String skuId, HttpServletRequest request){
       SkuInfo skuInfo = manageService.getskuInfo(skuId);
       request.setAttribute("skuInfo",skuInfo);
       List <SpuSaleAttr> spuSaleAttrList=manageService.getSpuSaleAttrListCheckBySku(skuInfo);
       request.setAttribute("spuSaleAttrList",spuSaleAttrList);
       List<SkuSaleAttrValue> skuSaleAttrValueList =manageService.getSkuSaleAttrValueListBySpu(skuInfo.getSpuId());
        String key = "";
        HashMap<String, String> map = new HashMap<>();
        if(skuSaleAttrValueList!=null && skuSaleAttrValueList.size()>0){
            for (int i = 0; i < skuSaleAttrValueList.size(); i++) {
                SkuSaleAttrValue skuSaleAttrValue = skuSaleAttrValueList.get(i);
                if(key.length()>0){
                    key+="|";
                }
                key += skuSaleAttrValue.getSaleAttrValueId();
                if((i+1)==skuSaleAttrValueList.size() || !skuSaleAttrValue.getSkuId().equals(skuSaleAttrValueList.get(i+1).getSkuId())){
                    map.put(key,skuSaleAttrValue.getSkuId());
                    key="";
                }

            }
       }
        String valuesSkuJson = JSON.toJSONString(map);
        request.setAttribute("valuesSkuJson",valuesSkuJson);
        return "item";
    }

}
