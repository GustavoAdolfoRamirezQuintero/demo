package com.test.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.test.mybatis.model.Product;

@Mapper
public interface ProductMapper {

	@Select("select * from products")
	public List<Product> findAllProducts();

	@Insert("insert into products(name, description) values(#{name}, #{description})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public long saveProducts(Product product);

}
