package fiap.com.br.cervejaria.repository;

import fiap.com.br.cervejaria.entity.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
}
