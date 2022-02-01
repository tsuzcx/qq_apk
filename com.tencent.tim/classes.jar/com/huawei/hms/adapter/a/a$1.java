package com.huawei.hms.adapter.a;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class a$1
  implements b
{
  private final List<c> a = new ArrayList();
  
  public void a(int paramInt)
  {
    synchronized ()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next()).a(paramInt)) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    synchronized ()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next()).a(paramIntent, paramString)) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void a(c paramc)
  {
    if (paramc == null) {}
    while (this.a.contains(paramc)) {
      return;
    }
    synchronized (a.c())
    {
      this.a.add(paramc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.adapter.a.a.1
 * JD-Core Version:    0.7.0.1
 */