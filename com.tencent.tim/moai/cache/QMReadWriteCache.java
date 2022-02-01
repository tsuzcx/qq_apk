package moai.cache;

@SuppressWarnings("serial")
public abstract class QMReadWriteCache<T, E> extends QMConcurrentCache<T, E> {
	
	public void updateByKey(T key, IReducer<E> reducer, Runnable bgJobs) {
		super.updateByKey(key, reducer);
		runJobsIfNotNull(bgJobs);
	}
	
	public void update(IQuery<E> query, Runnable bgJobs) {
		super.update(query);
		runJobsIfNotNull(bgJobs);
	}
	
	public void insert(T key, E e, Runnable bgJobs) {
		super.insert(key, e);
		runJobsIfNotNull(bgJobs);
	}
	
	public void delete(final IMapper<E> mapper, Runnable bgJobs) {
		super.delete(mapper);
		runJobsIfNotNull(bgJobs);
	}
	
	public void deleteByKey(T key, Runnable bgJobs) {
		super.deleteByKey(key);
		runJobsIfNotNull(bgJobs);
	}
	
	protected void runJobsIfNotNull(Runnable jobs) {
		if (jobs != null) {
			jobs.run();
		}
	}
}
