package com.tencent.wcdb;

import java.util.ArrayList;

public abstract class Observable<T>
{
  protected final ArrayList<T> mObservers = new ArrayList();
  
  public void registerObserver(T paramT)
  {
    if (paramT != null) {
      synchronized (this.mObservers)
      {
        if (!this.mObservers.contains(paramT))
        {
          this.mObservers.add(paramT);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Observer ");
        localStringBuilder.append(paramT);
        localStringBuilder.append(" is already registered.");
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    throw new IllegalArgumentException("The observer is null.");
  }
  
  public void unregisterAll()
  {
    synchronized (this.mObservers)
    {
      this.mObservers.clear();
      return;
    }
  }
  
  public void unregisterObserver(T paramT)
  {
    if (paramT != null) {
      synchronized (this.mObservers)
      {
        int i = this.mObservers.indexOf(paramT);
        if (i != -1)
        {
          this.mObservers.remove(i);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Observer ");
        localStringBuilder.append(paramT);
        localStringBuilder.append(" was not registered.");
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    throw new IllegalArgumentException("The observer is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.Observable
 * JD-Core Version:    0.7.0.1
 */