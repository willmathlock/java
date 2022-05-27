package com.br.willmathlock.entitymanager;

import com.br.willmathlock.cadastroveiculo.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class buscandoVeiculo {
    public static void main (String[] args) {
        EntityManager manager = JpaUtil.getFactory();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Veiculo veiculo = manager.find(Veiculo.class, 1L);
        System.out.println("veiculo de codigo: " + veiculo.getCodigo() + "é um veiculo: " + veiculo.getModelo());

        Query query = manager.createQuery("select v from Veiculo v");
        List<Veiculo> veiculos = query.getResultList();

        for (Veiculo veiculo2 : veiculos){
            System.out.println(veiculo2.getCodigo() + '-' +
                                veiculo2.getAnoFabricacao() + '-');
        }

        System.out.println("Valor atual: " + veiculo.getValor());
        veiculo.setValor(veiculo.getValor().add(new BigDecimal(780)));
        System.out.println("Novo valor: " + veiculo.getValor());

        tx.commit();
        manager.close();
        JpaUtil.close();
    }
}
