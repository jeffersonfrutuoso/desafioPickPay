package com.PicPayDesafio.domain.user;

import com.PicPayDesafio.dtos.UserDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String documento;

    private String senha;

    private BigDecimal carteira;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {
    }

    public User(Long id, String nome, String email, String documento, String senha, BigDecimal carteira, UserType userType) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.senha = senha;
        this.carteira = carteira;
        this.userType = userType;
    }

    public User(UserDTO userDTO){
        this.nome = userDTO.nome();
        this.email = userDTO.email();
        this.documento = userDTO.documento();
        this.senha = userDTO.senha();
        this.carteira = userDTO.carteira();
        this.userType = userDTO.userType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getCarteira() {
        return carteira;
    }

    public void setCarteira(BigDecimal carteira) {
        this.carteira = carteira;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}




