package com.test.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.mybatis.mapper.ProductMapper;
import com.test.mybatis.model.Product;

import static com.test.mybatis.adapterConst.AdapterConsts.LIST_PRODUCT_END_POINT;
import static com.test.mybatis.adapterConst.AdapterConsts.SAVE_PRODUCT_END_POINT;

import java.util.List;

@RestController
public class ProductController {

	@Autowired
	ProductMapper productMapper;

	@GetMapping(value = LIST_PRODUCT_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProductList() {
		return productMapper.findAllProducts();
	}

	@PostMapping(value = SAVE_PRODUCT_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Long saveProduct(@RequestBody Product product) {
		return productMapper.saveProducts(product);
	}

}
