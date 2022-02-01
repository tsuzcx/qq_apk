package com.tencent.qqmail.model.cache;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class QMConcurrentCache<T, E>
  extends ConcurrentHashMap<T, E>
{
  public QMConcurrentCache()
  {
    super(16, 0.9F, 1);
  }
  
  public void delete(IMapper<E> paramIMapper)
  {
    select(new QMConcurrentCache.1(this, paramIMapper));
  }
  
  public void deleteByKey(T paramT)
  {
    remove(paramT);
  }
  
  public abstract T getKeyByItem(E paramE);
  
  public void insert(T paramT, E paramE)
  {
    put(paramT, paramE);
  }
  
  public void select(IQuery<E> paramIQuery)
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((Map.Entry)localIterator.next()).getValue();
      if ((localObject != null) && (paramIQuery.map(localObject))) {
        paramIQuery.reduce(localObject);
      }
    }
  }
  
  public void selectByKey(T paramT, IReducer<E> paramIReducer)
  {
    paramT = get(paramT);
    if (paramT != null) {
      paramIReducer.reduce(paramT);
    }
  }
  
  public void update(IQuery<E> paramIQuery)
  {
    select(paramIQuery);
  }
  
  public void updateByKey(T paramT, IReducer<E> paramIReducer)
  {
    selectByKey(paramT, paramIReducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMConcurrentCache
 * JD-Core Version:    0.7.0.1
 */