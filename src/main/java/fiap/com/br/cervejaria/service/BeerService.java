package fiap.com.br.cervejaria.service;

import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeerService {
    private final BeerRepository beerRepository;

    public Beer addBeer(Beer beer) {
        return beerRepository.save(beer);
    }


}
