package com.PicPayDesafio.domain.transaction;
import com.PicPayDesafio.domain.user.User;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorDaTransferencia;

    @ManyToOne
    @JoinColumn(name = "enviador_id")
    private User enviador;

    @ManyToOne
    @JoinColumn(name = "recebedor_id")
    private User recebedor;

    private LocalDateTime timestamp;

    public Transaction() {
    }

    public Transaction(Long id, BigDecimal valorDaTransferencia, User enviador, User recebedor, LocalDateTime timestamp) {
        this.id = id;
        this.valorDaTransferencia = valorDaTransferencia;
        this.enviador = enviador;
        this.recebedor = recebedor;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorDaTransferencia() {
        return valorDaTransferencia;
    }

    public void setValorDaTransferencia(BigDecimal valorDaTransferencia) {
        this.valorDaTransferencia = valorDaTransferencia;
    }

    public User getEnviador() {
        return enviador;
    }

    public void setEnviador(User enviador) {
        this.enviador = enviador;
    }

    public User getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(User recebedor) {
        this.recebedor = recebedor;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
