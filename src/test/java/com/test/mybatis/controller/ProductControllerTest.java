package com.test.mybatis.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.test.mybatis.adapterConst.AdapterConsts.LIST_PRODUCT_END_POINT;
import static com.test.mybatis.adapterConst.AdapterConsts.SAVE_PRODUCT_END_POINT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.test.mybatis.demo.DemoApplication;
import com.test.mybatis.mapper.ProductMapper;
import com.test.mybatis.model.Product;
import static org.mockito.Mockito.any;

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
		when(mapper.saveProducts(any())).thenReturn(1l);
	}

	private void generateResponse() {
		product = new Product(1L, "carne", "alimento ric en proteinas");
		productList = new ArrayList<Product>();
		productList.add(product);
	}

	@Test
	public void testing_product_list__Controller() throws Exception {
		mvc.perform(get(LIST_PRODUCT_END_POINT)).andExpect(status().isOk());

	}

	@Test
	public void testing_product_save_Controller() throws Exception {
		product = new Product(34L, "carne", "alimento");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(product);
		System.out.println(requestJson);
		mvc.perform(post(SAVE_PRODUCT_END_POINT).contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson))
				.andExpect(status().isOk());

	}
}
