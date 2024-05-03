package mx.uv.javc.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.uv.javc.tienda.dto.CreateProductDTO;
import mx.uv.javc.tienda.dto.ProductDTO;
import mx.uv.javc.tienda.service.ProductService;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/obtenerProductos")
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @RequestMapping("/crearProductos")
    public ProductDTO save(@Valid @RequestBody CreateProductDTO data) {
        log.info("Ejcutando el guardado de un producto", data );
        log.info(data.toString());
        return productService.save(data);
    }
}
