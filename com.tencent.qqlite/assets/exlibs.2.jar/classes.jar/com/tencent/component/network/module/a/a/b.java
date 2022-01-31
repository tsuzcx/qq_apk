package com.tencent.component.network.module.a.a;

import java.util.Comparator;

public final class b<V>
  extends a<V>
{
  private final Comparator<V> a;
  
  public b(Comparator<V> paramComparator)
  {
    super(100);
    this.a = paramComparator;
  }
  
  public final void add(int paramInt, V paramV)
  {
    if (paramV == null) {
      return;
    }
    if (this.a == null)
    {
      super.add(paramInt, paramV);
      return;
    }
    add(paramV);
  }
  
  public final boolean add(V paramV)
  {
    int i = 0;
    if (paramV == null) {
      return false;
    }
    if (this.a == null) {
      return super.add(paramV);
    }
    int j = size();
    for (;;)
    {
      if (i >= j) {}
      Object localObject;
      do
      {
        super.add(i, paramV);
        return true;
        localObject = get(i);
      } while ((localObject != null) && (this.a.compare(paramV, localObject) <= 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.a.a.b
 * JD-Core Version:    0.7.0.1
 */