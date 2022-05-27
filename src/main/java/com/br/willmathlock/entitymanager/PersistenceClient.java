package com.br.willmathlock.entitymanager;
import com.br.willmathlock.cadastroveiculo.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class PersistenceClient {

    public static void main (String[] args) {
        Date dnow = new Date();
        EntityManager manager = JpaUtil.getFactory();
        EntityTransaction tx = manager.getTransaction();
        StringBuilder specs = new StringBuilder();
        tx.begin();
        specs.append("Carro em excelente estado\n");
        specs.append("Sem ar condicionado\n");
        specs.append("Primeiro dono, com manual de instrução\n");

        Veiculo veiculo = new Veiculo();

        veiculo.setFabricante("VW");
        veiculo.setModelo("Gol");
        veiculo.setAnoFabricacao(2018);
        veiculo.setAnoModelo(2019);
        veiculo.setValor(new BigDecimal(17200));
        veiculo.setCombustivel(Veiculo.tipoCombustivel.BIOCOMBUSTIVEL);
        veiculo.setDataCadastro(dnow);
        veiculo.setEspecificacoes(specs.toString());


        manager.persist(veiculo);
        tx.commit();
        manager.detach(veiculo);

        Veiculo veiculo1 = manager.find(Veiculo.class, veiculo.getCodigo());
        System.out.println("Veiculo: "+ veiculo1.getModelo());
        System.out.println("---------------");
        System.out.println(veiculo1.getEspecificacoes());


        manager.close();
        JpaUtil.close();
    }



}
