package br.vemprafam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.mvc.logica.Logica;

/**
 * Servlet implementation class ServetController
 */
@WebServlet("/mvc")
public class ServetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("logica");
		String nomeClasse = "br.vemprafam.mvc.logica." + operacao;
		try {
			Class classe = Class.forName(nomeClasse);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executar(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch ( Exception e ) {
			throw new RuntimeException("lógica do mvc causou exceção",e);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
