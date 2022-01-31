package com.tencent.feedback.eup;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class a<E>
  extends LinkedList<E>
{
  private int a = -1;
  
  public a() {}
  
  public a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void add(int paramInt, E paramE)
  {
    if (size() == this.a) {
      removeFirst();
    }
    super.add(paramInt, paramE);
  }
  
  public final boolean add(E paramE)
  {
    if (size() == this.a) {
      removeFirst();
    }
    return super.add(paramE);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    int i = size() + paramCollection.size() - this.a;
    if (i > 0) {
      removeRange(0, i);
    }
    return super.addAll(paramCollection);
  }
  
  public final void addFirst(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void addLast(E paramE)
  {
    add(paramE);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(localIterator.next().toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.a
 * JD-Core Version:    0.7.0.1
 */