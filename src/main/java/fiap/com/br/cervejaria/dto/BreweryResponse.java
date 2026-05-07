package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Brewery;

public record BreweryResponse(
        Long id,
        String name,
        String country
) {
    public static BreweryResponse fromEntity(Brewery b) {
        return new BreweryResponse(
                b.getId(),
                b.getName(),
                b.getCountry()
        );
    }
}
