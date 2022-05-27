package com.br.willmathlock.cadastroveiculo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 60, nullable = false)
    private String fabricante;
    @Column(length = 60, nullable = false)
    private String modelo;
    @Column(name = "anoFabricacao", nullable = false)
    private Integer anoFabricacao;
    @Column(name = "anoModelo", nullable = false)
    private Integer anoModelo;
    @Column(precision = 10, scale = 2, nullable = true)
    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro", nullable = false)
    private Date dataCadastro;

    @Lob
    private String especificacoes;
    @Column(name = "tipoCombustivel", nullable = true)
    @Enumerated(EnumType.STRING)
    private tipoCombustivel combustivel;

    public String getEspecificacoes () {
        return especificacoes;
    }

    public void setEspecificacoes (String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public Date getDataCadastro () {
        return dataCadastro;
    }

    public void setDataCadastro (Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public tipoCombustivel getCombustivel () {
        return combustivel;
    }

    public void setCombustivel (tipoCombustivel combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return codigo.equals(veiculo.codigo);
    }

    @Override
    public int hashCode () {
        return Objects.hash(codigo);
    }

    public Long getCodigo () {
        return codigo;
    }

    public void setCodigo (Long codigo) {
        this.codigo = codigo;
    }

    public String getFabricante () {
        return fabricante;
    }

    public void setFabricante (String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo () {
        return modelo;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao () {
        return anoFabricacao;
    }

    public void setAnoFabricacao (Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo () {
        return anoModelo;
    }

    public void setAnoModelo (Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public BigDecimal getValor () {
        return valor;
    }

    public void setValor (BigDecimal valor) {
        this.valor = valor;
    }

    public enum tipoCombustivel {
        ALCOOL,
        GASOLINA,
        DIESEL,
        BIOCOMBUSTIVEL
    }
}