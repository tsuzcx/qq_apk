package com.tencent.wcdb;

import java.util.ArrayList;

public abstract class Observable
{
  protected final ArrayList mObservers = new ArrayList();
  
  public void registerObserver(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.mObservers)
    {
      if (this.mObservers.contains(paramObject)) {
        throw new IllegalStateException("Observer " + paramObject + " is already registered.");
      }
    }
    this.mObservers.add(paramObject);
  }
  
  public void unregisterAll()
  {
    synchronized (this.mObservers)
    {
      this.mObservers.clear();
      return;
    }
  }
  
  public void unregisterObserver(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.mObservers)
    {
      i = this.mObservers.indexOf(paramObject);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramObject + " was not registered.");
      }
    }
    this.mObservers.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.Observable
 * JD-Core Version:    0.7.0.1
 */