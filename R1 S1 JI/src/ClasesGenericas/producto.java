package ClasesGenericas;

import jakarta.validation.constraints;
import spring-boot-starter-validation;

public class producto {
     Long id;
     @NotBlank
     String nombre ;
     String descripcion;
     @Min(1)
     double precio;

}
