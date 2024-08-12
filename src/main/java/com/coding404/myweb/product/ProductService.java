package com.coding404.myweb.product;

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

}
