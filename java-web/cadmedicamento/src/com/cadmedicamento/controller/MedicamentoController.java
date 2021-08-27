package com.cadmedicamento.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cadmedicamento.negocio.MedicamentoDAO;
import com.cadmedicamento.vo.Medicamento;

@WebServlet("/medicamentoController")
public class MedicamentoController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nomeMedicamento");
		Integer tipo = Integer.parseInt(req.getParameter("tipoMedicamento"));
		Double valorCusto = Double.parseDouble(req.getParameter("valorCusto"));
		Double valorVenda = Double.parseDouble(req.getParameter("valorVenda"));
		
		Medicamento medicamento = new Medicamento(nome, tipo, valorCusto, valorVenda);
		
		MedicamentoDAO dao =  new MedicamentoDAO();
		dao.inserir(medicamento);
		
		resp.sendRedirect("medicamentoController?acao=consultar");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MedicamentoDAO dao = new MedicamentoDAO();
		ArrayList<Medicamento> lista = dao.consultar();
		req.setAttribute("medicamentos", lista);
		
		RequestDispatcher rd = req.getRequestDispatcher("/consultaMedicamento.jsp");
		rd.forward(req, resp);
		
	}
	
	
	
	

}
