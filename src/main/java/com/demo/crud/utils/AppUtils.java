package com.demo.crud.utils;

import com.demo.crud.dto.ProductDto;
import com.demo.crud.entity.Product;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.BeanUtils;
// Convert Dto to Entity and Entity to DTO
public class AppUtils {
    public static ProductDto entityToDto(Product product)
    {
        ProductDto productDto=new ProductDto();
        //Bean Utils is to be used when source and destination have same attributes
        BeanUtils.copyProperties(product,productDto);  //   Source,Destination ,Copying product components to productDto
        return productDto;
    }

    public static Product dtoToEntity(ProductDto productDto)
    {
       
    	Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
       
    }

}
