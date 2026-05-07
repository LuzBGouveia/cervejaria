package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Brewery;
import jakarta.validation.constraints.NotBlank;

public record BreweryRequest(
        @NotBlank
        String name,

        @NotBlank
        String country
) {
    public Brewery toEntity() {
        return Brewery.builder()
                .name(name)
                .country(country)
                .build();
    }
}
