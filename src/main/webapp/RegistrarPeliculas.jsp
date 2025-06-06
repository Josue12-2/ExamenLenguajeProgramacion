<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Película</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h4 class="mb-0">Registrar Película</h4>
            </div>
            <div class="card-body">
                <form action="RegistrarPeliculaServlet" method="post">
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre de la película</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="director" class="form-label">Director</label>
                        <input type="text" class="form-control" id="director" name="director" required>
                    </div>
                    <div class="mb-3">
                        <label for="fechaEstreno" class="form-label">Fecha de estreno</label>
                        <input type="date" class="form-control" id="fechaEstreno" name="fechaEstreno" required>
                    </div>
                    <div class="mb-3">
                        <label for="genero" class="form-label">Género</label>
                        <input type="text" class="form-control" id="genero" name="genero" required>
                    </div>
                    <button type="submit" class="btn btn-success">Registrar</button>
                    <a href="RegistrarPeliculaServlet" class="btn btn-secondary ms-2">Volver a la lista</a>
                </form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


