package com.br.willmathlock.cadastroveiculo.model;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tab_veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 60, nullable = false)
    private String fabricante;
    @Column(length = 60, nullable = false)
    private String modelo;
    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;
    @Column(name = "ano_modelo", nullable = false)
    private Integer anoModelo;
    @Column(precision = 10, scale = 2, nullable = true)
    private BigDecimal valor;

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
}