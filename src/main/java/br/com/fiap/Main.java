package br.com.fiap;

import br.com.fiap.domain.servico.model.Servico;

import br.com.fiap.domain.servico.model.TipoServico;
import br.com.fiap.domain.servico.view.ServicoView;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle-fiap");
        EntityManager manager = factory.createEntityManager();
        Servico servico = ServicoView.formAbertura();
        TipoServico tipo = new TipoServico();

        tipo.setNome("Upgrade");

        manager.getTransaction().begin();
        manager.persist(tipo);

        servico.setTipo(tipo);

        manager.persist(servico);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}