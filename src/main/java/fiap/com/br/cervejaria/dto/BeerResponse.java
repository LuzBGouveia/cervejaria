package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.entity.Brewery;

public record BeerResponse(
        Long id,
        String name,
        String description,
        Double alcoholContent,
        String harmonization,
        Brewery brewery
) {
    public static BeerResponse fromEntity(Beer b) {
        return new BeerResponse(
                b.getId(),
                b.getName(),
                b.getDescription(),
                b.getAlcoholContent(),
                b.getHarmonization(),
                b.getBrewery());
    }
}
