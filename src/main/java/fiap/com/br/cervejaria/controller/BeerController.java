package fiap.com.br.cervejaria.controller;

import fiap.com.br.cervejaria.dto.BeerRequest;
import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("beer")
@RequiredArgsConstructor
public class BeerController {
    private final BeerService beerService;

    @PostMapping
    public Beer addBeer(@RequestBody BeerRequest beerRequest) {
        return beerService.addBeer(beerRequest.toEntity());
    }
}
