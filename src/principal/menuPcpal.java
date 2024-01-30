package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import dao.Articulo;

public class menuPcpal {
	
	public static final String fichero = "articulos.txt";
	
	private static Scanner leer;
	static {
		leer = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion = 0;
		opcion = menuPrincipal();
		
		while (opcion != 5) {
			
			switch(opcion) {
				case 1:
					System.out.println("AÑADIR NUEVO ARTICULO");
					anadir();
					break;
				case 2:
					System.out.println("BORRAR ARTICULO POR ID");
					break;
				case 3:
					System.out.println("CONSULTA ARTICULO POR ID");
					break;				
				case 4:
					System.out.println("LISTADO DE TODOS LOS ARTICULOS");
					listado();
					break;
		
			}
			opcion = menuPrincipal();
		}
		
		System.out.println("FIN DE PROGRAMA");
		leer.close();

	}
	
	private static void listado() {
		
		File fichero = new File("articulos.txt");
		Scanner lector = null;
			
		if (!fichero.exists()) { // Si no existe el fichero
			System.out.println("El fichero no existe");
			return;
		} else {
			System.out.println("id   nombre   descripcion            stock precio ");
			System.out.println("==== ======== ====================== ===== ====== ");
		
			try {
				lector = new Scanner(fichero);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (lector.hasNext()) {
				String linea = lector.nextLine();
				System.out.println(linea);
			}
			
			lector.close();
		}
	}

	private static void anadir() {
		
		
			System.out.println("Escritura de fichero " + fichero);
			
			FileWriter fw = null;
			PrintWriter pw = null;
			
			Articulo articulo = new Articulo();
			
			articulo.setNombre();
			articulo.setDescripcion();
			articulo.setStock();
			articulo.setPrecio();
			
			try {
				//Abrimos el fichero en modo escritura.
				fw = new FileWriter(fichero,true);//Si ponemos (nombreFichero,true) add en vez de borrar
				pw = new PrintWriter(fw);
				pw.println(articulo.toStringFichero());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//siempre debemos de cerrar el fichero despues de usarlo
				if(fw != null && pw != null){
					pw.close();
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			System.out.println("Fichero creado y rellenado con los datos \n" + articulo.toString());
		
		
	}

	public static int menuPrincipal() {
		int opcion = 0;
		System.out.println("\n\nMENU");
		System.out.println("====");
		System.out.println("1. Añadir nuevo artículo");
		System.out.println("2. Borrar artículo por id");
		System.out.println("3. Consulta artículo por id");
		System.out.println("4. Listado de todos los artículos");
		System.out.println("5. Terminar el programa");

		System.out.println("teclea una opcion del 1 al 4, 5 para salir");
		opcion = leer.nextInt();
	
		while(opcion < 1 || opcion > 5) {
			System.out.println("opciones del 1 al 5");
			opcion = leer.nextInt();
			}
	
		return opcion;
	}

}
