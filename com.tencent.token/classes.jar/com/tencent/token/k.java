package com.tencent.token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k
{
  private List a = new ArrayList();
  
  public final int a()
  {
    return this.a.size();
  }
  
  public final void a(j paramj)
  {
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((j)localIterator.next()).equals(paramj));
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.a.add(paramj);
      }
      return;
    }
  }
  
  public final j b()
  {
    if (this.a.size() == 0) {
      return null;
    }
    return (j)this.a.get(0);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("bytes=");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      localStringBuilder.append(localj.a);
      localStringBuilder.append("-");
      if (localj.b != -1L) {
        localStringBuilder.append(localj.b);
      }
      localStringBuilder.append(",");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.k
 * JD-Core Version:    0.7.0.1
 */