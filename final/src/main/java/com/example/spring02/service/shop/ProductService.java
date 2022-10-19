package com.example.spring02.service.shop;

import java.util.List;

import com.example.spring02.model.shop.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> listProduct(); //목록보기
	ProductDTO detailProduct(int product_id);//상세보기
	void updateProduct(ProductDTO dto);//수정
	void deleteProduct(int product_id);//삭제
	void insertProduct(ProductDTO dto);//입력
	String fileInfo(int product_id);//첨부파일정보
}
