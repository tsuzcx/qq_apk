package moai.cache;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("serial")
public abstract class QMConcurrentCache<T, E> extends ConcurrentHashMap<T, E> {
		
	public QMConcurrentCache() {
		super(16, 0.9f, 1);
	}
	
	public void select(IQuery<E> query) {
		for (Entry<T, E> entry : this.entrySet()) {
			E e = entry.getValue();
			if (e != null && query.map(e)) {
				query.reduce(e);
			}
		}
	}

	public void selectByKey(T key, IReducer<E> reducer) {
		E e = this.get(key);
		if (e != null) {
			reducer.reduce(e);
		}
	}
	
	public void update(IQuery<E> query) {
		select(query);
	}
	
	public void updateByKey(T key, IReducer<E> reducer) {
		selectByKey(key, reducer);
	}
	
	public void insert(T key, E e) {
		this.put(key, e);
	}
	
	public void delete(final IMapper<E> mapper) {
		select(new IQuery<E>() {
			public boolean map(E e) {
				return mapper.map(e);
			}
			public void reduce(E e) {
				QMConcurrentCache.this.remove(QMConcurrentCache.this.getKeyByItem(e));
			}
		});
	}
	
	
	public void deleteByKey(T key) {
		this.remove(key);
	}
	
	public abstract T getKeyByItem(E e);
}
