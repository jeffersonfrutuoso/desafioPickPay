package com.PicPayDesafio.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal valor, Long enviadorId, Long recebedorId) {
}
