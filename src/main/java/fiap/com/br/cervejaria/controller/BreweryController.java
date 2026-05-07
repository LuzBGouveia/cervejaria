package fiap.com.br.cervejaria.controller;

import fiap.com.br.cervejaria.dto.BreweryRequest;
import fiap.com.br.cervejaria.dto.BreweryResponse;
import fiap.com.br.cervejaria.service.BreweryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("breweries")
@RequiredArgsConstructor
@Tag(name = "Brewery", description = "Endpoints para o gerenciamento de cervejarias")
public class BreweryController {
    private final BreweryService service;

    @PostMapping
    @Operation(
            summary = "Cria uma nova cervejaria.",
            description = "Cria uma cervejaria, com suas informações.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada.")
            }
    )
    public ResponseEntity<BreweryResponse> addBrewery(@RequestBody BreweryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BreweryResponse.fromEntity(service.create(request)));
    }

    @GetMapping
    @Operation(
            summary = "Lista todas as cervejarias.",
            description = "Lista todas as cervejarias, com suas informações.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada.")
            }
    )
    public ResponseEntity<Page<BreweryResponse>> findAllBrewery(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(BreweryResponse::fromEntity));
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Lista uma cervejaria.",
            description = "Lista uma cervejaria e suas informações com base no ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada.")
            }
    )
    public ResponseEntity<BreweryResponse> findBreweryById(@PathVariable Long id) {
        return ResponseEntity.ok(BreweryResponse.fromEntity(service.findById(id)));
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Atualiza as informações de uma cervejaria.",
            description = "Atualiza as informações de uma cervejaria com base no seu ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada.")
            }
    )
    public ResponseEntity<BreweryResponse> updateBrewery(@PathVariable Long id, @RequestBody BreweryRequest request){
        return ResponseEntity.ok(BreweryResponse.fromEntity(service.update(id, request)));
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Deleta uma cervejaria.",
            description = "Deleta uma cervejaria com base no seu ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada.")
            }
    )
    public ResponseEntity<Void> deleteBrewery(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
