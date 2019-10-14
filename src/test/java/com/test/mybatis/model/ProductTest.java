package com.test.mybatis.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTest {

	private Product product;

	@Test
	public void with_arg_constructor() {
		product = new Product(1L, "carne", "producto alimenticio");

		assertNotNull(product);
		assertEquals("carne", product.getName());
		assertEquals("producto alimenticio", product.getDesc());
		assertEquals((Long) 1L, product.getId());
	}

	@Test
	public void with_no_arg_constructor() {
		product = new Product();

		product.setDesc("producto alimenticio");
		product.setName("carne");
		product.setId(1L);

		assertNotNull(product);
		assertEquals("carne", product.getName());
		assertEquals("producto alimenticio", product.getDesc());
		assertEquals((Long) 1L, product.getId());
	}

}
