package com.br.willmathlock.entitymanager;
import com.br.willmathlock.cadastroveiculo.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class PersistenceClient {

    public static void main (String[] args) {
        Date dNow = new Date( );
        EntityManager manager = JpaUtil.getFactory();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        Veiculo veiculo = new Veiculo();
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));
        veiculo.setCombustivel(Veiculo.tipoCombustivel.BIOCOMBUSTIVEL);
        veiculo.setDataCadastro(dNow);
        tx.commit();

        manager.close();
        JpaUtil.close();
    }



}
