package app.poo.ito;

import clases.poo.ito.Calzado;
import clases.poo.ito.Calzados;
import javax.swing.JOptionPane;

public class Aplicacion {
	
	static Calzados c;

	//========================================
	static void menu() {
		inicializa();
		boolean ciclo = true;
		int respuesta = 0;
		while (ciclo) {
			String opciones = "Bienvenido a su zapateria de confianza: \n1) Agregar nuevo Lote. \n2) Mostrar Lotes. \n3) Borrar Lote. \n4) Salir.";
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(opciones));
			switch (respuesta) {
			case 1: agregarLote(); break;
			case 2: mostrarLotes(); break;
			case 3: borrarLote(); break;
			case 4: ciclo = false; break;
			default: JOptionPane.showMessageDialog(null, "Ingrese una de las opciones mostradas por favor.");
			}
		}
	}

	//========================================
	static Calzado capturarLote() {
		Calzado c = new Calzado();	
		c.setClave(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la clave del producto: ")));
		c.setMaterial(JOptionPane.showInputDialog("Ingrese el material del que esta hecho el calzado: "));
		c.setTroquel(JOptionPane.showInputDialog("Ingrese el troquel con el que fue fabricado el calzado: "));
		c.setCantProdxDia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la produccion diaria de este modelo:")));
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de colores que tiene disponibles: "));
			for (int i=0; i < aux; i++)
				c.addColores(JOptionPane.showInputDialog("Color " + (i + 1) + ":"));
		c.costoxLote(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el costo por unidad:")));
		return c;
	}

	//========================================
	private static void inicializa() {
		c = new Calzados();
	}

	//========================================
	static void agregarLote() {
		Calzado item;
		item = capturarLote();
		if (c.addItem(item))
			JOptionPane.showMessageDialog(null, "Se ha agregado el lote exitosamente.");
		else
			JOptionPane.showMessageDialog(null, "ERROR: Este lote ya existe.");
	}

	//========================================
	static void mostrarLotes() {
		if (c.isFree())
			JOptionPane.showMessageDialog(null, "Todavía no hay lotes registrados en el sistema.");
		else {
			String lotes = "";
			for (int i = 0; i < c.getSize(); i++)
				lotes = lotes + "\n" + (c.getItem(i));
			JOptionPane.showMessageDialog(null, lotes);
		}
	}

	//========================================
	static void borrarLote() {
		int pos = 0;
		if (c.isFree())
			JOptionPane.showMessageDialog(null, "Todavía no hay lotes registrados en el sistema.");
		else {
			boolean aux = true;
			while (aux) {
				String lotes = "";
				for (int i = 0; i < c.getSize(); i++)
					lotes = lotes + "\n" + (i + 1) + ") " + (c.getItem(i)).getClave();
				pos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el lote que desea dar de baja: " + lotes));
				if ((c.getSize()) >= pos && pos > 0) {
					c.clear(c.getItem(pos - 1));
					JOptionPane.showMessageDialog(null, "El lote ha sido eliminado exitosamente.");
					aux = false;
				} else
					JOptionPane.showMessageDialog(null, "ERROR: Ese lote no existe.");
			}
		}
	}
}
	