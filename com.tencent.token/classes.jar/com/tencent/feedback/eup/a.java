package com.tencent.feedback.eup;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends LinkedList
{
  private int a = -1;
  
  public a() {}
  
  public a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    if (size() == this.a) {
      removeFirst();
    }
    super.add(paramInt, paramObject);
  }
  
  public final boolean add(Object paramObject)
  {
    if (size() == this.a) {
      removeFirst();
    }
    return super.add(paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    int i = size() + paramCollection.size() - this.a;
    if (i > 0) {
      removeRange(0, i);
    }
    return super.addAll(paramCollection);
  }
  
  public final void addFirst(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void addLast(Object paramObject)
  {
    add(paramObject);
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