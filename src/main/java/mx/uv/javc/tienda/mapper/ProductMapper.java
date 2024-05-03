package mx.uv.javc.tienda.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mx.uv.javc.tienda.dto.CreateProductDTO;
import mx.uv.javc.tienda.dto.ProductDTO;
import mx.uv.javc.tienda.model.Product;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    // source: Product
    // target: ProductDTO
    ProductDTO toDTO(Product model);


    // source: CreateProductDTO -> el objeto de entrada
    // target: Product -> al objeto de salida
    // En el target se va a ignorar el atributo "id"
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "stock", target = "quantity" )
    Product toModel(CreateProductDTO dto);
}
