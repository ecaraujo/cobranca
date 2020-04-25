package br.com.ftd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ftd.model.StatusTitulo;
import br.com.ftd.model.Titulo;
import br.com.ftd.repository.Titulos;

@Service
public class CadastroTituloService {
	
	@Autowired
	private Titulos titulos;
	
	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		}catch(DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}
	
	public List<Titulo> findAll(){
		List<Titulo> todosTitulos = titulos.findAll();
		return todosTitulos;
	}
	
	public void deleteById(Long codigo) {
		titulos.deleteById(codigo);
	}

	public String receber(Long codigo) {
		Optional<Titulo> titulo = titulos.findById(codigo);
		titulo.get().setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo.get());
		return StatusTitulo.RECEBIDO.getDescricao()	;
	}

}
