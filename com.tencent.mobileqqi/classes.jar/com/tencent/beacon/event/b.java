package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.e;
import com.tencent.beacon.c.d.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.beacon.upload.a
{
  private static b h = null;
  private Context d = null;
  private com.tencent.beacon.c.a.b e = null;
  private Long[] f = null;
  private List<Long> g = null;
  
  private b(Context paramContext)
  {
    super(paramContext, 1, 4);
    this.d = paramContext;
  }
  
  private com.tencent.beacon.c.a.a a(List<h> paramList)
  {
    int j = 1;
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Object localObject1 = new ArrayList(5);
    ArrayList localArrayList1 = new ArrayList(5);
    ArrayList localArrayList2 = new ArrayList(5);
    Object localObject2 = new ArrayList();
    int k = paramList.size();
    this.g = new ArrayList();
    int i = 0;
    h localh;
    Object localObject3;
    if (i < k) {
      try
      {
        localh = (h)paramList.get(i);
        localObject3 = localh.e();
        com.tencent.beacon.d.a.a(" bean.getTP: " + localh.b(), new Object[0]);
        if (localObject3 != null) {
          if ("IP".equals(localh.b()))
          {
            localObject3 = e.a(localh);
            if (localObject3 != null) {
              ((ArrayList)localObject1).add(localObject3);
            } else {
              this.g.add(Long.valueOf(localh.a()));
            }
          }
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        com.tencent.beacon.d.a.d(" CommonRecordUploadDatas.encode2MixPackage() error1", new Object[0]);
      }
    }
    for (;;)
    {
      try
      {
        paramList = new c();
        i = j;
        if (localArrayList2.size() > 0)
        {
          paramList.c = localArrayList2;
          i = 0;
        }
        if (localArrayList1.size() > 0)
        {
          paramList.b = localArrayList1;
          i = 0;
        }
        if (((ArrayList)localObject1).size() <= 0) {
          break label747;
        }
        paramList.a = ((ArrayList)localObject1);
        i = 0;
      }
      catch (Exception paramList)
      {
        label266:
        paramList.printStackTrace();
        com.tencent.beacon.d.a.d(" CommonRecordUploadDatas.encode2MixPackage() error2", new Object[0]);
        b();
        return null;
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = new com.tencent.beacon.c.b.b();
        ((com.tencent.beacon.c.b.b)localObject1).a = ((ArrayList)localObject2);
        if ((paramList == null) && (localObject1 == null))
        {
          return null;
          if ("DN".equals(localh.b()))
          {
            localObject3 = e.b(localh);
            if (localObject3 != null) {
              localArrayList1.add(localObject3);
            } else {
              this.g.add(Long.valueOf(localh.a()));
            }
          }
          else if ("HO".equals(localh.b()))
          {
            localObject3 = e.c(localh);
            if (localObject3 != null) {
              localArrayList2.add(localObject3);
            } else {
              this.g.add(Long.valueOf(localh.a()));
            }
          }
          else if ("UA".equals(localh.b()))
          {
            com.tencent.beacon.d.a.f(" Pack2Upload eventName:}%s ", new Object[] { localh.d() });
            localObject3 = e.d(localh);
            if (localObject3 != null)
            {
              ((ArrayList)localObject2).add(localObject3);
            }
            else
            {
              this.g.add(Long.valueOf(localh.a()));
              break label740;
              if (this.g.size() > 0) {
                e.a(this.d, (Long[])this.g.toArray(new Long[this.g.size()]));
              }
              com.tencent.beacon.d.a.b(" up hmList:" + localArrayList2.size(), new Object[0]);
              com.tencent.beacon.d.a.b(" up dmList:" + localArrayList1.size(), new Object[0]);
              com.tencent.beacon.d.a.b(" up ipList:" + ((ArrayList)localObject1).size(), new Object[0]);
              com.tencent.beacon.d.a.b(" up erList:" + ((ArrayList)localObject2).size(), new Object[0]);
            }
          }
        }
        else
        {
          localObject2 = new HashMap();
          if (paramList != null) {
            ((Map)localObject2).put(Integer.valueOf(3), paramList.a());
          }
          if (localObject1 != null) {
            ((Map)localObject2).put(Integer.valueOf(1), ((com.tencent.beacon.c.b.b)localObject1).a());
          }
          paramList = new com.tencent.beacon.c.a.a();
          paramList.a = ((Map)localObject2);
          return paramList;
        }
      }
      else
      {
        localObject1 = null;
        continue;
      }
      label740:
      label747:
      while (i == 0)
      {
        break label266;
        i += 1;
        break;
      }
      paramList = null;
    }
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (h == null) {
        h = new b(paramContext);
      }
      paramContext = h;
      return paramContext;
    }
    finally {}
  }
  
  public final com.tencent.beacon.c.a.b a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = m.d();
        if ((localObject1 == null) || (!((m)localObject1).h()))
        {
          com.tencent.beacon.d.a.c(" imposiable! ua not ready!", new Object[0]);
          localObject1 = null;
          return localObject1;
        }
        localObject1 = ((m)localObject1).k();
        if (localObject1 == null)
        {
          com.tencent.beacon.d.a.c(" imposiable! ua S not ready!", new Object[0]);
          localObject1 = null;
          continue;
        }
        if (this.e != null)
        {
          localObject1 = this.e;
          continue;
        }
        try
        {
          long l = ((d)localObject1).h();
          if (com.tencent.beacon.d.b.a(this.d)) {
            l = ((d)localObject1).g();
          }
          if (l < 0L) {
            break label356;
          }
          localList = e.a(this.d, null, l);
          if ((localList == null) || (localList.size() <= 0))
          {
            com.tencent.beacon.d.a.h(" no up datas", new Object[0]);
            localObject1 = null;
            continue;
          }
          i = localList.size();
          com.tencent.beacon.d.a.h(" size:%d", new Object[] { Integer.valueOf(i) });
          localObject1 = a(localList);
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            List localList;
            this.f = new Long[i];
            int i = 0;
            if (i < this.f.length)
            {
              this.f[i] = Long.valueOf(((h)localList.get(i)).a());
              i += 1;
              continue;
            }
            localList.clear();
            if (localObject1 == null) {
              break label350;
            }
          }
          catch (Throwable localThrowable2)
          {
            continue;
            Object localObject3 = null;
            continue;
          }
          try
          {
            localObject1 = ((com.tencent.beacon.c.a.a)localObject1).a();
            this.e = a(this.c, this.a, (byte[])localObject1);
            localObject1 = this.e;
          }
          catch (Exception localException)
          {
            com.tencent.beacon.d.a.d(" get req datas error: %s", new Object[] { localException.toString() });
            b();
            localObject3 = null;
          }
          localThrowable1 = localThrowable1;
          localObject1 = null;
          localThrowable1.printStackTrace();
          com.tencent.beacon.d.a.d(" get req datas error: %s", new Object[] { localThrowable1.toString() });
          continue;
        }
        continue;
      }
      finally {}
      label350:
      label356:
      Object localObject4 = null;
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 271
    //   5: iconst_0
    //   6: anewarray 81	java/lang/Object
    //   9: invokestatic 171	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: iload_1
    //   13: ifeq +20 -> 33
    //   16: aload_0
    //   17: getfield 31	com/tencent/beacon/event/b:f	[Ljava/lang/Long;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 31	com/tencent/beacon/event/b:f	[Ljava/lang/Long;
    //   27: arraylength
    //   28: istore_2
    //   29: iload_2
    //   30: ifgt +6 -> 36
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: getfield 27	com/tencent/beacon/event/b:d	Landroid/content/Context;
    //   40: aload_0
    //   41: getfield 31	com/tencent/beacon/event/b:f	[Ljava/lang/Long;
    //   44: invokestatic 164	com/tencent/beacon/a/e:a	(Landroid/content/Context;[Ljava/lang/Long;)I
    //   47: istore_2
    //   48: new 63	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 273
    //   55: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: iload_2
    //   59: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: iconst_0
    //   66: anewarray 81	java/lang/Object
    //   69: invokestatic 171	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 29	com/tencent/beacon/event/b:e	Lcom/tencent/beacon/c/a/b;
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 31	com/tencent/beacon/event/b:f	[Ljava/lang/Long;
    //   82: goto -49 -> 33
    //   85: astore_3
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_3
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	b
    //   0	90	1	paramBoolean	boolean
    //   28	31	2	i	int
    //   85	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	85	finally
    //   16	29	85	finally
    //   36	82	85	finally
  }
  
  public final void b()
  {
    try
    {
      com.tencent.beacon.d.a.c(" encode failed, clear db data", new Object[0]);
      if ((this.f != null) && (this.f.length > 0))
      {
        int i = e.a(this.d, this.f);
        com.tencent.beacon.d.a.b(" remove num :" + i, new Object[0]);
        this.e = null;
        this.f = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.event.b
 * JD-Core Version:    0.7.0.1
 */