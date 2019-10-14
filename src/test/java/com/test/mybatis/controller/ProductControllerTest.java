package com.test.mybatis.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.test.mybatis.adapterConst.AdapterConsts.LIST_PRODUCT_END_POINT;

import com.test.mybatis.demo.DemoApplication;
import com.test.mybatis.mapper.ProductMapper;
import com.test.mybatis.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ProductControllerTest {

	private Product product;
	private List<Product> productList;

	protected MockMvc mvc;

	@Autowired
	private ProductController controller;

	@MockBean
	private ProductMapper mapper;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
		generateResponse();
		when(mapper.findAllProducts()).thenReturn(productList);
	}

	private void generateResponse() {
		product = new Product(1L, "carne", "alimento ric en proteinas");
		productList = new ArrayList<Product>();
		productList.add(product);
	}

	@Test
	public void testing_product_Controller() throws Exception {
		mvc.perform(get(LIST_PRODUCT_END_POINT)).andExpect(status().isOk());

	}
}
