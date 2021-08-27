package br.edu.uniceplac.managebean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.uniceplac.entidade.Medicamento;
import br.edu.uniceplac.session.MedicamentoSession;

@ManagedBean(name = "medicamentoBean")
@SessionScoped
public class MedicamentoBean {
	
	private Medicamento medicamento = new Medicamento();
	private List<Medicamento> listaMedicamento;
	
	@EJB
	private MedicamentoSession medicamentoSession;
	
	public String init() {
		medicamento = new Medicamento();
		listaMedicamento = medicamentoSession.findAll();
		return "consultaMedicamento.html?faces-redirect=true";
	}
	
	public String editar(Integer id) {
		medicamento = medicamentoSession.find(id);
		return "cadastroMedicamento.xhtml?faces-redirect=true";
	}
	
	public void excluir(Integer id) {
		medicamentoSession.delete(id);
		listaMedicamento = medicamentoSession.findAll();
		
	}
	
	public void consultarPorNome() {
		listaMedicamento = medicamentoSession.find(medicamento);
	}
	
	public void salvar() {
		medicamentoSession.save(medicamento);
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getListaMedicamento() {
		return listaMedicamento;
	}

	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	
	
	
	

}
