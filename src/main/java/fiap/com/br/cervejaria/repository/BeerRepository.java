package fiap.com.br.cervejaria.repository;

import fiap.com.br.cervejaria.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findAllByBreweryId(Long breweryId);
}
