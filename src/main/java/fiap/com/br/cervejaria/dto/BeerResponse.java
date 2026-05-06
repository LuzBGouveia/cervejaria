package fiap.com.br.cervejaria.dto;

import fiap.com.br.cervejaria.entity.Beer;

public record BeerResponse(
        Long id,
        String name
) {
    public static BeerResponse fromEntity(Beer b) {
        return new BeerResponse(b.getId(), b.getName());
    }
}
