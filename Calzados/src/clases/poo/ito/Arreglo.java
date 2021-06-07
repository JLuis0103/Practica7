package clases.poo.ito;

public interface Arreglo<T> {
	
	public boolean addItem(T item);

	public boolean existeItem(T item);

	public T getItem(int pos);

	public int getSize();

	public boolean clear(T item);

	public boolean isFree();

	public boolean isFull();

}
