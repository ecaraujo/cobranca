package br.com.ftd.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ftd.model.StatusTitulo;
import br.com.ftd.model.Titulo;
import br.com.ftd.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public ModelAndView Salvar(Titulo titulo) {

		titulos.save(titulo);
		
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		
		mv.addObject("mensagem","Titulo salvo com sucesso!!!!!!");
				
		return mv;
	}
	
	@RequestMapping
	public ModelAndView Pesquisar() {
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
	
}
