package com.coding404.myweb.product;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;

import java.util.List;

public interface ProductService {

    public int productInsert(ProductVO vo);
    public List<ProductVO> getList(String userId, Criteria cri);
    public int getTotal(String userId, Criteria cri);
    public ProductVO getDetail(int prodId);
    public int productUpdate(ProductVO vo);
    public int productDelete(int prodId);
    public List<String> getCategoryNav();
    // 카테고리 1단계
    public List<CategoryVO> getCategory();
    // 카테고리 2, 3단계
    public List<CategoryVO> getCategoryChild(CategoryVO vo);

}
