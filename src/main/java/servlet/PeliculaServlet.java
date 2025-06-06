package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.GeneroDAO;
import dao.PeliculaDAO;
import entidades.Genero;
import entidades.Pelicula;

/**
 * Servlet implementation class PeliculaServlet
 */
@WebServlet("/RegistrarPeliculaServlet")
public class PeliculaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PeliculaDAO peliculaDAO = new PeliculaDAO();
    private GeneroDAO generoDAO = new GeneroDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pelicula> peliculas = peliculaDAO.listar();
        request.setAttribute("peliculas", peliculas);
      
        request.setAttribute("lista", peliculas);
        request.getRequestDispatcher("listarPeliculas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String director = request.getParameter("director");
        String fechaEstreno = request.getParameter("fechaEstreno");
        String nombreGenero = request.getParameter("genero");

        Genero genero = generoDAO.buscarPorNombre(nombreGenero);

        if (genero == null) {
            genero = new Genero();
            genero.setNombre(nombreGenero);
            generoDAO.registrarGenero(genero);
            genero = generoDAO.buscarPorNombre(nombreGenero);
        }

        Pelicula p = new Pelicula();
        p.setNombre(nombre);
        p.setDirector(director);
        p.setFechaEstreno(java.sql.Date.valueOf(fechaEstreno));
        p.setGenero(genero);

        peliculaDAO.registrar(p);

        response.sendRedirect("RegistrarPeliculaServlet");
    }
}


