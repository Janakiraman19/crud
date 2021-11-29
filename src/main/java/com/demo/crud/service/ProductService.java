package com.demo.crud.service;

import com.demo.crud.dto.ProductDto;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import com.demo.crud.repository.ProductRepository;
import com.demo.crud.utils.AppUtils;
import reactor.core.publisher.Flux;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<ProductDto> getProducts()
    {
        return repository.findAll()
                .map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> getProduct(String id)
    {

        final Mono<ProductDto> user;
        user = repository.findById(id).map(AppUtils::entityToDto);

        //return user;

        return user;
    }




    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){
        System.out.println("service method called ...");
        Mono<ProductDto> map = productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
        return map;
    }
    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,String id){
        return repository.findById(id)
                 .flatMap(p->productDtoMono.map(AppUtils::dtoToEntity)
                 .doOnNext(e->e.setId(id)))
                 .flatMap(repository::save)
                 .map(AppUtils::entityToDto);

     }


    public Mono<Void> deleteProduct(String id){
        return repository.deleteById(id);
    }
//    private Mono<String> sayHello(ServerRequest request) {
//        return Mono.just("Hello, " + request.queryParam("name").get());
//    }
//    public Mono<ServerResponse> handleRequest(Object request) {
//        return sayHello(request)
//                .onErrorReturn("Hello Stranger")
//                .flatMap(s -> ServerResponse.ok()
//                        .contentType(MediaType.TEXT_PLAIN)
//                        .bodyValue(s));
//    }
}
