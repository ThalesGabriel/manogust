package com.example.demo.controller;

import com.example.demo.service.ConiferasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequestMapping(value = "api/v1/coniferas")
@Tag(name = "Coniferas")
@RestController
public class ConiferasController {

    private final ConiferasService coniferasService;

    public ConiferasController(ConiferasService coniferasService) {
        this.coniferasService = coniferasService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new order of stocks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    public ResponseEntity<?> createStocks(BigDecimal primeiroValorDiametro, BigDecimal segundoValorDiametro, BigDecimal comprimentoToraMetros) {

//      Fazer calculos nessa classe de Serviço que é destinada a regras de negócio
        var resultado = coniferasService.execute(primeiroValorDiametro, segundoValorDiametro, comprimentoToraMetros);

        return ResponseEntity.ok(resultado);
    }

}
