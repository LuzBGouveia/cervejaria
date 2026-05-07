package fiap.com.br.cervejaria.service;

import fiap.com.br.cervejaria.dto.BeerRequest;
import fiap.com.br.cervejaria.entity.Beer;
import fiap.com.br.cervejaria.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerService {
    private final BeerRepository beerRepository;

    @Cacheable(value = "beers", key = "#id")
    public Beer findById(Long id) {
        return beerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cerveja não encontrada."));
    }

    @Cacheable("beers")
    public Page<Beer> findAll(Pageable pageable) {
        return beerRepository.findAll(pageable);
    }

    @Cacheable(value = "beers", key = "'brewery-' + #breweryId")
    public List<Beer> findAllByBreweryId(Long id) {
        return beerRepository.findAllByBreweryId(id);
    }

    public Beer create(BeerRequest request) {
        return beerRepository.save(request.toEntity());
    }

    @CacheEvict(value = "beers", allEntries = true)
    public Beer update(Long id, BeerRequest request) {
        findById(id);
        Beer beer = request.toEntity();
        beer.setId(id);
        return beerRepository.save(beer);
    }

    @CacheEvict(value = "beers", allEntries = true)
    public void delete(Long id) {
        findById(id);
        beerRepository.deleteById(id);
    }

}
