package com.tencent.token;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public final class arc
{
  private TreeMap a = null;
  
  public arc(Comparator paramComparator)
  {
    this.a = new TreeMap(paramComparator);
  }
  
  public final void a(Object paramObject)
  {
    try
    {
      LinkedList localLinkedList2 = (LinkedList)this.a.get(paramObject);
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        this.a.put(paramObject, localLinkedList1);
      }
      localLinkedList1.addLast(paramObject);
      return;
    }
    finally {}
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.a.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object c()
  {
    try
    {
      boolean bool = a();
      if (bool) {
        return null;
      }
      Object localObject1 = this.a.firstKey();
      LinkedList localLinkedList = (LinkedList)this.a.get(localObject1);
      Object localObject3 = localLinkedList.poll();
      if (localLinkedList.size() <= 0) {
        this.a.remove(localObject1);
      }
      return localObject3;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.arc
 * JD-Core Version:    0.7.0.1
 */