package dao;

import java.util.Objects;
import java.util.Scanner;

public class Articulo {
	private static int contadorIDs = 1;
	int id;
	String nombre;
	String descripcion;
	int stock;
	double precio;
	
	private static Scanner leer;
	static {
		leer = new Scanner(System.in);
	}
	
    public Articulo(int id, String nombre, String descripcion, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }
    
    public Articulo() {
        this.id = generarID(); // Genera un nuevo ID cada vez que se crea un objeto
    }
	
    private static int generarID() {
        return contadorIDs++;
    }
    
	public String toStringFichero() {
		return id + "," + nombre + "," + descripcion + "," + stock + "," + precio;
	}
	
	@Override
	public String toString() {
		return "articulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio +"]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return id == other.id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre() {
		System.out.println("Introduce el nombre del articulo: ");
		String nombre = leer.next();
		this.nombre = nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion() {
		System.out.println("Introduce la descripcion del articulo: ");
		String descripcion = leer.nextLine();
		descripcion = leer.nextLine(); // Para que no se salte el nextLine
		this.descripcion = descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getStock() {
		return stock;
	}

	public void setStock() {
		System.out.println("Introduce la cantidad: ");
		int stock = leer.nextInt();
		this.stock = stock;
	}
	

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio() {
		System.out.println("Introduce el precio: ");
		double precio = leer.nextDouble();
		this.precio = precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
    public static void closeScanner() {
        leer.close();
    }
	
}
