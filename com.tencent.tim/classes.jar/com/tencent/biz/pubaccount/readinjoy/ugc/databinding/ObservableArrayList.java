package com.tencent.biz.pubaccount.readinjoy.ugc.databinding;

import java.util.ArrayList;
import java.util.Collection;
import mmd;
import mmf;
import mmf.a;

public class ObservableArrayList<T>
  extends ArrayList<T>
  implements mmf<T>
{
  private transient mmd a = new mmd();
  
  private void cU(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.b(this, paramInt1, paramInt2);
    }
  }
  
  private void cV(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.c(this, paramInt1, paramInt2);
    }
  }
  
  public void add(int paramInt, T paramT)
  {
    super.add(paramInt, paramT);
    cU(paramInt, 1);
  }
  
  public boolean add(T paramT)
  {
    super.add(paramT);
    cU(size() - 1, 1);
    return true;
  }
  
  public boolean addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    boolean bool = super.addAll(paramInt, paramCollection);
    if (bool) {
      cU(paramInt, paramCollection.size());
    }
    return bool;
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    int i = size();
    boolean bool = super.addAll(paramCollection);
    if (bool) {
      cU(i, size() - i);
    }
    return bool;
  }
  
  public void addOnListChangedCallback(mmf.a parama)
  {
    if (this.a == null) {
      this.a = new mmd();
    }
    this.a.add(parama);
  }
  
  public void clear()
  {
    int i = size();
    super.clear();
    if (i != 0) {
      cV(0, i);
    }
  }
  
  public T remove(int paramInt)
  {
    Object localObject = super.remove(paramInt);
    cV(paramInt, 1);
    return localObject;
  }
  
  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      remove(i);
      return true;
    }
    return false;
  }
  
  public void removeOnListChangedCallback(mmf.a parama)
  {
    if (this.a != null) {
      this.a.remove(parama);
    }
  }
  
  protected void removeRange(int paramInt1, int paramInt2)
  {
    super.removeRange(paramInt1, paramInt2);
    cV(paramInt1, paramInt2 - paramInt1);
  }
  
  public T set(int paramInt, T paramT)
  {
    paramT = super.set(paramInt, paramT);
    if (this.a != null) {
      this.a.a(this, paramInt, 1);
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList
 * JD-Core Version:    0.7.0.1
 */