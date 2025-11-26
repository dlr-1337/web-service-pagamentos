package com.otavio.webservices.dominio;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Pagamento {

    private Integer codigo;
    private String descricao;
    private Double valor;

// Controla a serializacao de data em dd/MM/yyyy no JSON
@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;
    private Boolean pago;

    public Pagamento() {
    }

    public Pagamento(Integer codigo, String descricao, Double valor, LocalDate dataVencimento, Boolean pago) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.pago = pago;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }
}
