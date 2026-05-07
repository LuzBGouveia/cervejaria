package fiap.com.br.cervejaria.controller;

import fiap.com.br.cervejaria.dto.BeerRequest;
import fiap.com.br.cervejaria.dto.BeerResponse;
import fiap.com.br.cervejaria.service.BeerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("beers")
@RequiredArgsConstructor
@Tag(name = "Beer", description = "Endpoints para o gerenciamento de cervejas")
public class BeerController {
    private final BeerService service;

    @PostMapping
    @Operation(
            summary = "Cria uma nova cerveja.",
            description = "Cria uma cerveja, com suas informações e cervejaria."
    )
    public ResponseEntity<BeerResponse> addBeer(@RequestBody BeerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BeerResponse.fromEntity(service.create(request)));
    }

    @GetMapping
    @Operation(
            summary = "Lista todas as cervejas.",
            description = "Lista todas as cerveja, com suas informações e cervejarias."
    )
    public ResponseEntity<List<BeerResponse>> findAllBeer() {
        return ResponseEntity.ok(service.findAll().stream().map(BeerResponse::fromEntity).toList());
    }

    @GetMapping("brewery/{id}")
    @Operation(
            summary = "Lista todas as cervejas de uma cervejaria.",
            description = "Lista todas as cerveja de uma cervejaria com base em seu ID."
    )
    public ResponseEntity<List<BeerResponse>> findAllByBreweryId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllByBreweryId(id).stream().map(BeerResponse::fromEntity).toList());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Lista uma cerveja.",
            description = "Lista uma cerveja e sua informação com base no ID."
    )
    public ResponseEntity<BeerResponse> findBeerById(@PathVariable Long id) {
        return ResponseEntity.ok(BeerResponse.fromEntity(service.findById(id)));
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Atualiza uma cerveja.",
            description = "Atualiza uma cerveja e suas informações, com base em seu ID."
    )
    public ResponseEntity<BeerResponse> updateBeer(@PathVariable Long id, @RequestBody BeerRequest request){
        return ResponseEntity.ok(BeerResponse.fromEntity(service.update(id, request)));
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Deleta uma cerveja.",
            description = "Deleta uma cerveja com base no seu ID."
    )
    public ResponseEntity<Void> deleteBeer(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
