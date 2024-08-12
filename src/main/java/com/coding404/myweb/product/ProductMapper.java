package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    public int productInsert(ProductVO vo);
    public List<ProductVO> getList(@Param("userId") String userId, @Param("cri") Criteria cri);
    public int getTotal(@Param("userId") String userId, @Param("cri") Criteria cri);
    public ProductVO getDetail(int prodId);
    public int productUpdate(ProductVO vo);
    public int productDelete(int prodId);
}
