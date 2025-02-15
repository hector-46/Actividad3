package Main;

import java.util.Scanner;

class Producto {
    private String descripcion;
    private String codigo;
    private String tipo;
    private Double costo;
    private Double impuesto;

    // Métodos de acceso (getters)
    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    // Métodos establecedores (setters)
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    // Método para mostrar el producto
    public void muestraProducto() {
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Codigo: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo: " + costo);
        System.out.println("Impuesto: " + impuesto);
    }

    // Método para calcular el precio de venta
    public double calcularPrecio(double utilidad) {
        double precioAntesImpuesto = costo + (costo * utilidad / 100);
        double precioFinal = precioAntesImpuesto + (precioAntesImpuesto * impuesto / 100);
        return precioFinal;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();

        // Entrada de datos para el primer producto
        try {
            System.out.println("Ingrese los datos del primer producto:");
            System.out.print("Descripcion: ");
            producto1.setDescripcion(scanner.nextLine());
            System.out.print("Codigo: ");
            producto1.setCodigo(scanner.nextLine());
            System.out.print("Tipo: ");
            producto1.setTipo(scanner.nextLine());
            System.out.print("Costo: ");
            producto1.setCosto(scanner.nextDouble());
            System.out.print("Impuesto: ");
            producto1.setImpuesto(scanner.nextDouble());
            scanner.nextLine(); // Limpiar el buffer
        } catch (Exception e) {
            System.out.println("Error en la entrada de datos: " + e.getMessage());
            return;
        }

        // Entrada de datos para el segundo producto
        try {
            System.out.println("Ingrese los datos del segundo producto:");
            System.out.print("Descripcion: ");
            producto2.setDescripcion(scanner.nextLine());
            System.out.print("Codigo: ");
            producto2.setCodigo(scanner.nextLine());
            System.out.print("Tipo: ");
            producto2.setTipo(scanner.nextLine());
            System.out.print("Costo: ");
            producto2.setCosto(scanner.nextDouble());
            System.out.print("Impuesto: ");
            producto2.setImpuesto(scanner.nextDouble());
        } catch (Exception e) {
            System.out.println("Error en la entrada de datos: " + e.getMessage());
            return;
        }

        // Mostrar productos
        System.out.println("\nDetalles del primer producto:");
        producto1.muestraProducto();
        System.out.println("\nDetalles del segundo producto:");
        producto2.muestraProducto();

        // Comparar productos
        String productoMayor = compararProductos(producto1, producto2);
        System.out.println("\nEl producto con mayor precio de venta es: " + productoMayor);
    }

    // Método estático para comparar productos
    public static String compararProductos(Producto p1, Producto p2) {
        double precioP1 = p1.calcularPrecio(20); // Porcentaje de utilidad del 20%
        double precioP2 = p2.calcularPrecio(20); // Porcentaje de utilidad del 20%

        if (precioP1 > precioP2) {
            return p1.getDescripcion();
        } else {
            return p2.getDescripcion();
        }
    }
}
