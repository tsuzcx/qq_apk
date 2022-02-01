package com.tencent.token;

import java.util.ArrayList;
import java.util.HashSet;

public final class fs<T>
{
  public final ee.a<ArrayList<T>> a = new ee.b(10);
  public final eg<T, ArrayList<T>> b = new eg();
  private final ArrayList<T> c = new ArrayList();
  private final HashSet<T> d = new HashSet();
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (!paramHashSet.contains(paramT))
    {
      paramHashSet.add(paramT);
      ArrayList localArrayList = (ArrayList)this.b.get(paramT);
      if (localArrayList != null)
      {
        int i = 0;
        int j = localArrayList.size();
        while (i < j)
        {
          a(localArrayList.get(i), paramArrayList, paramHashSet);
          i += 1;
        }
      }
      paramHashSet.remove(paramT);
      paramArrayList.add(paramT);
      return;
    }
    throw new RuntimeException("This graph contains cyclic dependencies");
  }
  
  public final ArrayList<T> a()
  {
    this.c.clear();
    this.d.clear();
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      a(this.b.b(i), this.c, this.d);
      i += 1;
    }
    return this.c;
  }
  
  public final void a(T paramT)
  {
    if (!this.b.containsKey(paramT)) {
      this.b.put(paramT, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fs
 * JD-Core Version:    0.7.0.1
 */