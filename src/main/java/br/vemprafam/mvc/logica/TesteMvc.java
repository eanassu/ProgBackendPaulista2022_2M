package br.vemprafam.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TesteMvc implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("executando o teste mvc");
		return "testemvc.jsp";
	}

}
