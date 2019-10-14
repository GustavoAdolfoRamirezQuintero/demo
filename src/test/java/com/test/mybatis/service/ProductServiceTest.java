package com.test.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tes.mybatis.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

	@Test
	public void testing_service() {
		new ProductService();
	}

}
