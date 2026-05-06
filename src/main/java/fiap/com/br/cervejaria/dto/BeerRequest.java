package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Beer;
import jakarta.validation.constraints.NotBlank;

public record BeerRequest(
        @NotBlank(message = "Name is required")
        String name
) {
    public Beer toEntity() {
        return Beer.builder()
                .name(name)
                .build();
    }
}
