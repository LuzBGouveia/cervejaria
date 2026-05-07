package fiap.com.br.cervejaria.data;

import fiap.com.br.cervejaria.dto.BeerRequest;
import fiap.com.br.cervejaria.dto.BreweryRequest;
import fiap.com.br.cervejaria.entity.Brewery;
import fiap.com.br.cervejaria.service.BeerService;
import fiap.com.br.cervejaria.service.BreweryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MockData {

    private final BreweryService breweryService;
    private final BeerService beerService;

    @PostConstruct
    public void init() {

        // Cervejarias
        Brewery auroraBrew = breweryService.create(
                new BreweryRequest("Aurora Brew", "Brasil")
        );

        Brewery montanhaCraft = breweryService.create(
                new BreweryRequest("Montanha Craft", "Alemanha")
        );

        Brewery oceanoMalte = breweryService.create(
                new BreweryRequest("Oceano Malte", "Bélgica")
        );

        // Cervejas da Aurora Brew
        beerService.create(
                new BeerRequest(
                        "Aurora IPA",
                        "IPA tropical com aroma intenso de maracujá",
                        6.8,
                        "Hambúrguer artesanal e batata rústica",
                        auroraBrew
                )
        );

        beerService.create(
                new BeerRequest(
                        "Golden Aurora",
                        "Blonde Ale leve e refrescante",
                        4.9,
                        "Peixes grelhados e saladas",
                        auroraBrew
                )
        );

        // Cervejas da Montanha Craft
        beerService.create(
                new BeerRequest(
                        "Montanha Stout",
                        "Stout cremosa com notas de café e chocolate",
                        7.5,
                        "Sobremesas e carnes defumadas",
                        montanhaCraft
                )
        );

        beerService.create(
                new BeerRequest(
                        "Pico Weiss",
                        "Weissbier tradicional com toque frutado",
                        5.3,
                        "Salsichas alemãs e pretzels",
                        montanhaCraft
                )
        );

        // Cervejas da Oceano Malte
        beerService.create(
                new BeerRequest(
                        "Maré Lager",
                        "Lager suave e extremamente refrescante",
                        4.5,
                        "Frutos do mar e petiscos",
                        oceanoMalte
                )
        );

        beerService.create(
                new BeerRequest(
                        "Tempestade Dubbel",
                        "Dubbel belga encorpada com notas caramelizadas",
                        8.1,
                        "Queijos fortes e carnes assadas",
                        oceanoMalte
                )
        );
    }
}