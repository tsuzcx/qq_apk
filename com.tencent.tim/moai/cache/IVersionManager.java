package moai.cache;

public interface IVersionManager<E> {
	public int getVersion(E key);
	public boolean dataHasChanged(E key, int version);
}
