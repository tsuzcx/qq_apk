package com.tencent.kingkong;

import java.util.ArrayList;

public class DataSetObservable
  extends Observable<DataSetObserver>
{
  public void notifyChanged()
  {
    synchronized (this.mObservers)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((DataSetObserver)this.mObservers.get(i)).onChanged();
        i -= 1;
      }
      return;
    }
  }
  
  public void notifyInvalidated()
  {
    synchronized (this.mObservers)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((DataSetObserver)this.mObservers.get(i)).onInvalidated();
        i -= 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.DataSetObservable
 * JD-Core Version:    0.7.0.1
 */