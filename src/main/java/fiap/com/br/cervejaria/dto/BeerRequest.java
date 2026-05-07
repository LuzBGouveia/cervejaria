package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.entity.Brewery;
import jakarta.validation.constraints.NotBlank;

public record BeerRequest(
        @NotBlank(message = "Name is required")
        String name,

        String description,

        Double alcoholContent,

        String harmonization,

        Brewery brewery
) {
    public Beer toEntity() {
        return Beer.builder()
                .name(name)
                .description(description)
                .alcoholContent(alcoholContent)
                .harmonization(harmonization)
                .brewery(brewery)
                .build();
    }
}
