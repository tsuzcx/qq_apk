package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends com.tencent.beacon.upload.a
{
  private com.tencent.beacon.c.a.b d;
  private List<h> e;
  
  public static com.tencent.beacon.c.a.b a(Context paramContext, int paramInt, List<h> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return null;
      try
      {
        com.tencent.beacon.d.a.b(" current size:}" + paramList.size(), new Object[0]);
        paramList = b(paramList);
        if (paramList != null)
        {
          paramList = paramList.a();
          if (paramList != null)
          {
            paramContext = a(paramContext, paramInt, paramList);
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        com.tencent.beacon.d.a.d(" RealTimeRecordUploadDatas.encode2EventRecordPackage error}", new Object[0]);
      }
    }
    return null;
  }
  
  private void a(com.tencent.beacon.c.a.b paramb)
  {
    try
    {
      this.d = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private void a(List<h> paramList)
  {
    try
    {
      this.e = paramList;
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  private static com.tencent.beacon.c.b.b b(List<h> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    com.tencent.beacon.c.b.b localb;
    try
    {
      localb = new com.tencent.beacon.c.b.b();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.beacon.c.b.a locala = e.d((h)paramList.next());
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      localb.a = localArrayList;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    com.tencent.beacon.d.a.b(" RealTimeRecordUploadDatas.encode2EventRecordPackage() end}", new Object[0]);
    return localb;
  }
  
  private List<h> e()
  {
    try
    {
      List localList = this.e;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.beacon.c.a.b a()
  {
    return null;
  }
  
  public final void a(boolean paramBoolean)
  {
    a(null);
    List localList = e();
    a(null);
    if (localList != null)
    {
      if (!paramBoolean)
      {
        com.tencent.beacon.d.a.b(" isHandled false , record to db}", new Object[0]);
        e.a(null, localList);
      }
      localList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.event.j
 * JD-Core Version:    0.7.0.1
 */