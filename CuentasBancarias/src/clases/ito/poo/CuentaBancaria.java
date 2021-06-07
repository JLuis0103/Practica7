package clases.ito.poo;

import java.time.LocalDate;

public class CuentaBancaria implements Comparable<CuentaBancaria> {

	private long numCuenta = 0L;
	private String nomCliente = "";
	private float saldo = 0F;
	private LocalDate fechaApertura = null;
	private LocalDate fechaActualizacion = null;

	public CuentaBancaria() {
		super();
	}
	
	public CuentaBancaria(long numCuenta, String nomCliente, float saldo, LocalDate fechaApertura) {
		super();
		this.numCuenta = numCuenta;
		this.nomCliente = nomCliente;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
	}
	
	//====================================
	public boolean deposito(float cantidad) {
		boolean deposito = false;
		LocalDate c=LocalDate.now();
		if (this.fechaApertura.compareTo(c) < 0) {
			deposito=true;
			this.saldo=this.saldo+cantidad;
			this.fechaActualizacion=LocalDate.now();
		}
		return deposito;
	}

	//====================================
	public boolean retiro(float cantidad) {
		boolean retiro = false;
		if (cantidad <= this.saldo) {
			retiro=true;
			this.saldo=this.saldo-cantidad;
			this.fechaActualizacion=LocalDate.now();
		}
		return retiro;
	}

	//====================================
	public long getNumCuenta() {
		return this.numCuenta;
	}

	//====================================
	public void setNumCuenta(long newNumCuenta) {
		this.numCuenta = newNumCuenta;
	}

	//====================================
	public String getNomCliente() {
		return this.nomCliente;
	}

	//====================================
	public void setNomCliente(String newNomCliente) {
		this.nomCliente = newNomCliente;
	}

	//====================================
	public float getSaldo() {
		return this.saldo;
	}

	//====================================
	public void setSaldo(float newSaldo) {
		this.saldo = newSaldo;
	}

	//====================================
	public LocalDate getFechaApertura() {
		return this.fechaApertura;
	}

	//====================================
	public void setFechaApertura(LocalDate newFechaApertura) {
		this.fechaApertura = newFechaApertura;
	}

	//====================================
	public LocalDate getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	//====================================
	public void setFechaActualizacion(LocalDate newFechaActualizacion) {
		this.fechaActualizacion = newFechaActualizacion;
	}

	@Override
	public String toString() {
		return "Numero de cuenta: " + numCuenta + " | Cliente: " + nomCliente + "\nSaldo: " + saldo
				+ "\nFecha Apertura: " + fechaApertura + " | Fecha Actualizacion: " + fechaActualizacion + "\n";
	}

	@Override
	public int compareTo(CuentaBancaria o) {
		int compare=0;
		if (this.numCuenta<o.getNumCuenta())
				compare=-1;
		else if(this.numCuenta>o.getNumCuenta())
				compare=1;
		return compare;
	}

	

}
