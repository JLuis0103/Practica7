package clases.poo.ito;

import java.util.HashSet;

public class Calzado implements Comparable<Calzado> {

	private int clave = 0;
	private String material = "";
	private String troquel = "";
	private int cantProdxDia = 0;
	private float costoxLote;
	private HashSet<String> colores = new HashSet<String>();

	public Calzado() {
		super();
	}
	
	public Calzado(int clave, String material, String troquel, int cantProdxDia) {
		super();
		this.clave = clave;
		this.material = material;
		this.troquel = troquel;
		this.cantProdxDia = cantProdxDia;
	}

	//=============================================
	public void costoxLote(float costoxUnidad) {
		this.costoxLote = costoxUnidad * this.cantProdxDia;
	}
	
	//=============================================
	public int getClave() {
		return this.clave;
	}
	
	//=============================================
	public void setClave(int newClave) {
		this.clave = newClave;
	}
	
	//=============================================
	public String getMaterial() {
		return this.material;
	}
	
	//=============================================
	public void setMaterial(String newMaterial) {
		this.material = newMaterial;
	}

	//=============================================
	public String getTroquel() {
		return this.troquel;
	}

	//=============================================
	public void setTroquel(String newTroquel) {
		this.troquel = newTroquel;
	}

	//=============================================
	public int getCantProdxDia() {
		return this.cantProdxDia;
	}

	//=============================================
	public void setCantProdxDia(int newCantProdxDia) {
		this.cantProdxDia = newCantProdxDia;
	}
	
	//=============================================
	public void addColores(String colores){
		this.colores.add(colores);	
	}
	
	//=============================================
	public void delColores(String colores){
		this.colores.remove(colores);
	}

	//=============================================
	public HashSet<String> getColores() {
		return this.colores;
	}

	@Override
	public String toString() {
		return "Calzado con clave: " + clave + " | Material: " + material + " | Troquel: " + troquel + "\nColores disponibles: "
				+ colores + "\nProduccion diaria: " + cantProdxDia + " | Costo por lote: "+ costoxLote + "\n";
	}

	@Override
	public int compareTo(Calzado o) {
		int compare = 0;
		if (this.clave == o.getClave())
			compare = 1;
		return compare;
	}

}
