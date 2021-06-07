package clases.poo.ito;

public class Calzados implements Arreglo<Calzado> {
	
	private Calzado lote[] = null;
	private int ultimo = 0;
	private final int I = 5;

	public Calzados() {
		super();
		this.lote = new Calzado[I];
		this.ultimo = -1;
	}

	//========================================
	private void crecerArreglo() {
		Calzado calzadoCopia[] = new Calzado[this.lote.length + I];
		for (int i = 0; i < lote.length; i++)
			calzadoCopia[i] = this.lote[i];
		lote = calzadoCopia;
	}

	@Override
	public boolean addItem(Calzado item) {
		boolean add = false;
		if (!this.existeItem(item)) {
			if (this.isFull())
				crecerArreglo();
		int j = 0;
		for (int i = this.ultimo; i >= j; i--)
			lote[i + 1] = lote[i];
		this.lote[j] = item;
		this.ultimo++;
		add = true;
		}
		return add;
	}

	@Override
	public boolean existeItem(Calzado item) {
		boolean existe = false;
		for (int i = 0; i <= this.ultimo; i++)
			if (item.compareTo(this.lote[i]) == 1) {
				existe = true;
				break;
			}
		return existe;
	}

	@Override
	public Calzado getItem(int pos) {
		Calzado c = null;
		if (pos <= this.ultimo && !this.isFree())
			c = this.lote[pos];
		return c;
	}

	@Override
	public int getSize() {
		return this.ultimo + 1;
	}

	@Override
	public boolean clear(Calzado item) {
		boolean borrar = false;
		if (this.existeItem(item)) {
			int i = 0;
			for (; i <= this.ultimo; i++)
				if (item.compareTo(this.lote[i]) == 1)
					break;
			for (; i <= this.ultimo; i++)
				lote[i] = lote[i + 1];
			this.ultimo--;
			borrar = true;
		}
		return borrar;
	}

	@Override
	public boolean isFree() {
		return this.ultimo == -1;
	}

	@Override
	public boolean isFull() {
		return this.ultimo + 1 == this.lote.length;
	}

}
