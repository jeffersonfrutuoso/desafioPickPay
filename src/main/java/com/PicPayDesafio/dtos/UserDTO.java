package com.PicPayDesafio.dtos;

import com.PicPayDesafio.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String nome, String email, String documento, String senha, BigDecimal carteira, UserType userType) {
}
