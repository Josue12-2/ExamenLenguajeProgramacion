<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="entidades.Pelicula" %>
<%@ page import="entidades.Genero" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Películas</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Lista de Películas</h2>
            <a href="registrarPelicula" class="btn btn-primary">Registrar Nueva Película</a>
        </div>

        <div class="table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Director</th>
                        <th>Fecha Estreno</th>
                        <th>Género</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        @SuppressWarnings("unchecked")
                        List<Pelicula> lista = (List<Pelicula>) request.getAttribute("lista");
                        if (lista != null && !lista.isEmpty()) {
                            for (Pelicula p : lista) {
                    %>
                    <tr>
                        <td><%= p.getIdpelicula() %></td>
                        <td><%= p.getNombre() %></td>
                        <td><%= p.getDirector() %></td>
                        <td><%= p.getFechaEstreno() %></td>
                        <td><%= p.getGenero() != null ? p.getGenero().getNombre() : "Sin género" %></td>
                    </tr>
                    <% 
                            }
                        } else { 
                    %>
                    <tr>
                        <td colspan="5" class="text-center">No hay películas registradas.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>