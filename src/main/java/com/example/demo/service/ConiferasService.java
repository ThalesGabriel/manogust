package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ConiferasService {

    public BigDecimal execute(BigDecimal primeiroValorDiametro, BigDecimal segundoValorDiametro, BigDecimal comprimentoToraMetros) {
        primeiroValorDiametro = primeiroValorDiametro.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        segundoValorDiametro = segundoValorDiametro.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        // ...
        return primeiroValorDiametro.multiply(segundoValorDiametro);
    }

}
