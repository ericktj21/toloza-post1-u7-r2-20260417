package com.universidad.productosweb.service;

import com.universidad.productosweb.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductoService {

    private final Map<Long, Producto> productos = new LinkedHashMap<>();
    private long contadorId = 1;

    public ProductoService() {
        guardar(new Producto(null, "Laptop", "Laptop 15 pulgadas 16GB RAM", 3200.0));
        guardar(new Producto(null, "Mouse", "Mouse inalambrico ergonomico", 95.0));
        guardar(new Producto(null, "Teclado", "Teclado mecanico TKL", 220.0));
    }

    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos.values());
    }

    public Optional<Producto> buscarPorId(Long id) {
        return Optional.ofNullable(productos.get(id));
    }

    public Producto guardar(Producto producto) {
        if (producto.getId() == null) {
            producto.setId(contadorId++);
        }
        productos.put(producto.getId(), producto);
        return producto;
    }

    public void eliminar(Long id) {
        productos.remove(id);
    }
}
