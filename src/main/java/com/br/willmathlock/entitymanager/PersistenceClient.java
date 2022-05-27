package com.br.willmathlock.entitymanager;
import com.br.willmathlock.cadastroveiculo.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class PersistenceClient {

    public static void main (String[] args) {
        EntityManager manager = JpaUtil.getFactory();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        Veiculo veiculo = new Veiculo();
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));

        tx.commit();

        manager.close();
        JpaUtil.close();
    }



}
