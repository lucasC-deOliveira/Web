package com.cadmedicamento.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cadmedicamento.vo.Medicamento;

public class MedicamentoDAO extends DAO {
	
	public void inserir(Medicamento medicamento) {
		String sql = "insert into medicamento (nome, idtipo, valorcusto, valorvenda) values (?, ?, ?, ? ) ";
		
		try (Connection con = getConexao();
			 PreparedStatement ps = con.prepareStatement(sql);
			) {
			ps.setString(1, medicamento.getNome());
			ps.setInt(2, medicamento.getTipo());
			ps.setDouble(3, medicamento.getValorCusto());
			ps.setDouble(4, medicamento.getValorVenda());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Medicamento> consultar(){
		
		String sql = "select idmedicamento, nome, valorcusto, valorvenda from medicamento";
		ArrayList<Medicamento> lista = new ArrayList<>();
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			
			while(rs.next()) {
				Medicamento medicamento = new Medicamento();
				medicamento.setId(rs.getInt("idmedicamento"));
				medicamento.setNome(rs.getString("nome"));
				medicamento.setValorCusto(rs.getDouble("valorcusto"));
				medicamento.setValorVenda(rs.getDouble("valorvenda"));
				lista.add(medicamento);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
		
	}

}
