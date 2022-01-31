package com.tencent.beacon.b;

import com.tencent.beacon.c.e.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class e
  implements com.tencent.beacon.upload.f
{
  public static List<b> a(com.tencent.beacon.c.e.e parame)
  {
    if (parame == null)
    {
      com.tencent.beacon.d.a.b("SpeedMonitorStrategy sourcePackage is null", new Object[0]);
      return null;
    }
    Object localObject3 = parame.a;
    Object localObject2 = parame.b;
    Object localObject1 = parame.c;
    parame = new ArrayList();
    Object localObject4;
    if (localObject3 != null)
    {
      com.tencent.beacon.d.a.b("ipList size:%d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (c)((Iterator)localObject3).next();
        b localb = new b();
        localb.b(((c)localObject4).a + ":" + ((c)localObject4).b);
        localb.a(new Date().getTime());
        localb.a("IP");
        parame.add(localb);
      }
    }
    if (localObject2 != null)
    {
      com.tencent.beacon.d.a.b("dnsList size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.beacon.c.e.b)((Iterator)localObject2).next();
        localObject4 = new b();
        ((b)localObject4).b(((com.tencent.beacon.c.e.b)localObject3).a);
        ((b)localObject4).a(new Date().getTime());
        ((b)localObject4).a("PG");
        parame.add(localObject4);
      }
    }
    if (localObject1 != null)
    {
      com.tencent.beacon.d.a.b("hostList size:%d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.beacon.c.e.f)((Iterator)localObject1).next();
        localObject3 = new b();
        ((b)localObject3).c(((com.tencent.beacon.c.e.f)localObject2).d);
        ((b)localObject3).d(((com.tencent.beacon.c.e.f)localObject2).a + ":" + ((com.tencent.beacon.c.e.f)localObject2).b);
        ((b)localObject3).b(((com.tencent.beacon.c.e.f)localObject2).c);
        ((b)localObject3).a(new Date().getTime());
        ((b)localObject3).a("HOST");
        parame.add(localObject3);
        com.tencent.beacon.d.a.a(" TxHostSource: " + ((b)localObject3).toString(), new Object[0]);
      }
    }
    if (parame.size() > 0) {
      return parame;
    }
    return null;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    d locald;
    if ((paramInt == 105) && (paramArrayOfByte != null))
    {
      locald = d.d();
      if ((locald == null) || (!d.e())) {}
    }
    try
    {
      com.tencent.beacon.c.e.e locale = new com.tencent.beacon.c.e.e();
      locale.a(new com.tencent.beacon.e.a(paramArrayOfByte));
      paramArrayOfByte = a(locale);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
        locald.a((b[])paramArrayOfByte.toArray(new b[0]));
      }
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d(" process sm strategy error: %s", new Object[] { paramArrayOfByte.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.b.e
 * JD-Core Version:    0.7.0.1
 */