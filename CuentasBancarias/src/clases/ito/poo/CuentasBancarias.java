package clases.ito.poo;

public class CuentasBancarias implements Arreglo<CuentaBancaria> {
	
	private CuentaBancaria cuentas[] = null;
	private int ultimo = 0;
	private final int I = 5;
	
	public CuentasBancarias() {
		super();
		this.cuentas = new CuentaBancaria[I];
		this.ultimo = -1;
	}
	
	//========================================
	public void crecerArreglo() {
		CuentaBancaria cuentasCopia[] = new CuentaBancaria[this.cuentas.length + I];
		for (int i = 0; i < cuentas.length; i++)
			cuentasCopia[i] = this.cuentas[i];
		this.cuentas = cuentasCopia;
	}

	@Override
	public boolean addItem(CuentaBancaria item) {
		boolean add=false;
		if(this.isFull())
			crecerArreglo();
		int j=0;
		for(int i = this.ultimo; i >= j; i--)
			cuentas[i+1] = cuentas[i];
		this.cuentas[j] = item;
		this.ultimo++;
		add=true;
		return add;
	}

	@Override
	public boolean existeItem(CuentaBancaria item) {
		boolean existe = false;
		for (int i = 0; i <= this.ultimo; i++)
			if (item.compareTo(this.cuentas[i]) == 0) {
				existe = true;
				break;
			}
		return existe;
	}

	@Override
	public CuentaBancaria getItem(int pos) {
		CuentaBancaria cb = null;
		if(pos <= this.ultimo &&! this.isFree())
			cb = this.cuentas[pos];
		return cb;
	}

	@Override
	public int getSize() {
		return this.ultimo + 1;
	}

	@Override
	public boolean clear(CuentaBancaria item) {
		boolean borrar=false;
		if(this.existeItem(item)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(item.compareTo(this.cuentas[i]) == 0)
					break;
			for(;i<=this.ultimo;i++)
				cuentas[i]=cuentas[i+1];
			this.ultimo--;
			borrar=true;
			}
		return borrar;
	}

	@Override
	public boolean isFree() {
		return this.ultimo==-1;
	}

	@Override
	public boolean isFull() {
		return this.ultimo+1==this.cuentas.length;
	}
	
}
