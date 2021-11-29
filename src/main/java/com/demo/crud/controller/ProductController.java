package com.demo.crud.controller;

import com.demo.crud.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.demo.crud.service.ProductService;

@RestController
@RequestMapping("/movies")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<ProductDto> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(String id){
       return service.getProduct(id);
    }

   @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono){

        return service.saveProduct(productDtoMono);
    }
    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateMovie(@RequestBody Mono<ProductDto> productDtoMono, @PathVariable  String id)
    {
        return service.updateProduct(productDtoMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }

//    public Mono<ServerResponse> handleRequest(ServerRequest request) {
//        return sayHello(request)
//                .onErrorReturn("Hello Stranger")
//                .flatMap(s -> ServerResponse.ok()
//                        .contentType(MediaType.TEXT_PLAIN)
//                        .bodyValue(s));
//    }
//

}
