package com.tencent.hlyyb.downloader.e.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private List<b> a = new ArrayList();
  
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
        localStringBuilder.append(((b)localIterator.next()).a());
        localStringBuilder.append(";");
      }
    }
    String str = localObject.toString();
    return str;
  }
  
  public final void a(b paramb)
  {
    synchronized (this.a)
    {
      if (this.a.size() < 20) {
        this.a.add(paramb);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.c.a
 * JD-Core Version:    0.7.0.1
 */