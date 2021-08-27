package br.edu.uniceplac.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.uniceplac.entidade.Medicamento;
import br.edu.uniceplac.util.AbstractSession;

@Stateless
public class MedicamentoSession extends AbstractSession<Medicamento, Integer> {
	
	public MedicamentoSession() {
		super(Medicamento.class);
	}
	
	public MedicamentoSession(final EntityManager entityManager) {
		this();
		this.entityManager = entityManager;
	}
	
	public List<Medicamento> find(Medicamento medicamento){
		TypedQuery<Medicamento> query = entityManager.createNamedQuery("Medicamento.find", Medicamento.class).
				setParameter("medicamento", String.format("%%%s%%", medicamento.getNome()));
		return query.getResultList();
	}

}
