package fiap.com.br.cervejaria.service;

import fiap.com.br.cervejaria.dto.BreweryRequest;
import fiap.com.br.cervejaria.entity.Brewery;
import fiap.com.br.cervejaria.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BreweryService {

    private final BreweryRepository breweryRepository;

    @Cacheable(value = "breweries", key = "#id")
    public Brewery findById(Long id) {
        return breweryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cervejaria não encontrada."));
    }

    @Cacheable("breweries")
    public Page<Brewery> findAll(Pageable pageable) {
        return breweryRepository.findAll(pageable);
    }

    public Brewery create(BreweryRequest request) {
        return breweryRepository.save(request.toEntity());
    }

    @CacheEvict(value = "breweries", allEntries = true)
    public Brewery update(Long id, BreweryRequest request) {
        findById(id);
        Brewery brewery = request.toEntity();
        brewery.setId(id);
        return breweryRepository.save(brewery);
    }

    @CacheEvict(value = "breweries", allEntries = true)
    public void delete(Long id) {
        findById(id);
        breweryRepository.deleteById(id);
    }
}
