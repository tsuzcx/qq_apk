package com.tencent.token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ag
{
  private List a = new ArrayList();
  
  public final String a()
  {
    synchronized (this.a)
    {
      if (this.a.size() == 0) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
      {
        localStringBuilder.append(((ah)localIterator.next()).a());
        localStringBuilder.append(";");
      }
    }
    String str = localObject.toString();
    return str;
  }
  
  public final void a(ah paramah)
  {
    synchronized (this.a)
    {
      if (this.a.size() < 20) {
        this.a.add(paramah);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ag
 * JD-Core Version:    0.7.0.1
 */