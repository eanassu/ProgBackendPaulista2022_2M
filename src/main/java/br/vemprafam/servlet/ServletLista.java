package br.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Funcionario;

/**
 * Servlet implementation class ServletLista
 */
@WebServlet("/ServletLista")
public class ServletLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFuncionario dao = new DaoFuncionario();
		List<Funcionario> lista = dao.getLista();
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
        out.println("<meta charset='ISO-8859-1'>");
		out.println("<title>Lista de Funcionários</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>\n"
				+ "<th>RE</th><th>nome</th><th>data adm.</th><th>salário</th><th>e-mail</th>\r\n"
				+ "</tr>");
		for( Funcionario f: lista ) {
			out.println("<tr>");
			out.println("<td>"+f.getRe()+"</td>"+
			            "<td>"+f.getNome()+"</td>"+
					    "<td>"+f.getDataAdmissao()+"</td>"+
			            "<td>"+f.getSalario()+"</td>"+
			            "<td>"+f.getEmail()+"</td>"	);
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<br/><a href='/Projeto'>voltar</a>");
		out.println("</body>");
		out.println("</html>");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
