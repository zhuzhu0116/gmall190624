package com.atguigu.gmall0624.service;

import com.atguigu.gmall0624.bean.*;

import java.util.List;

public interface ManageService {
    /**
     * 查找所有一级分类
     * @return
     */
    List<BaseCatalog1> getCatalog1();

    /**
     * 根据属性查找二级分类
     * @param baseCatalog2
     * @return
     */

    List<BaseCatalog2> getCatalog2(BaseCatalog2 baseCatalog2);

    List<BaseCatalog3> getCatalog3(BaseCatalog3 baseCatalog3);

    List<BaseAttrInfo> getAttrInfoList(BaseAttrInfo baseAttrInfo);

    List<BaseAttrInfo> getAttrInfoList(String catalog3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    BaseAttrInfo getAttrInfo(String attrId);

    /**
     * 通过attrId 查询平台属性值集合
     * @param attrId
     * @return
     */
    List<BaseAttrValue> getAttrValueList(String attrId);

    List<SpuInfo> getSpuList(SpuInfo spuInfo);

    // 查询基本销售属性表
    List<BaseSaleAttr> getBaseSaleAttrList();

    void saveSpuInfo(SpuInfo spuInfo);

    List<SpuImage> getSpuImageList(SpuImage spuImage);

    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    void saveSkuInfo(SkuInfo skuInfo);

}
