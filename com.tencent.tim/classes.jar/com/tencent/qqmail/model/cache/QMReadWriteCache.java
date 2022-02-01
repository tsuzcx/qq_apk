package com.tencent.qqmail.model.cache;

public abstract class QMReadWriteCache<T, E>
  extends QMConcurrentCache<T, E>
{
  public void delete(IMapper<E> paramIMapper, Runnable paramRunnable)
  {
    super.delete(paramIMapper);
    runJobsIfNotNull(paramRunnable);
  }
  
  public void deleteByKey(T paramT, Runnable paramRunnable)
  {
    super.deleteByKey(paramT);
    runJobsIfNotNull(paramRunnable);
  }
  
  public void insert(T paramT, E paramE, Runnable paramRunnable)
  {
    super.insert(paramT, paramE);
    runJobsIfNotNull(paramRunnable);
  }
  
  protected void runJobsIfNotNull(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public void update(IQuery<E> paramIQuery, Runnable paramRunnable)
  {
    super.update(paramIQuery);
    runJobsIfNotNull(paramRunnable);
  }
  
  public void updateByKey(T paramT, IReducer<E> paramIReducer, Runnable paramRunnable)
  {
    super.updateByKey(paramT, paramIReducer);
    runJobsIfNotNull(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMReadWriteCache
 * JD-Core Version:    0.7.0.1
 */