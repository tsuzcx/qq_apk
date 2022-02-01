package com.tencent.beacon.b;

import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.base.util.f;
import com.tencent.beacon.e.b;
import com.tencent.qmsp.sdk.u.U;

public class a
{
  private static boolean a;
  
  public static String a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Object localObject3;
      try
      {
        Object localObject1;
        if (!b.a().e())
        {
          localObject1 = "";
          return localObject1;
        }
        String[] arrayOfString2;
        try
        {
          localObject1 = U.c(paramInt);
          if (localObject1 == null)
          {
            if (!a)
            {
              d.b().a("501", "[beaconId] jni execute error or load so fail!");
              a = true;
            }
            localObject1 = "";
          }
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            String[] arrayOfString1 = U.c(paramInt);
          }
          catch (Throwable localThrowable2)
          {
            localObject3 = e.l().f();
            if (!a)
            {
              d.b().a("501", "[beaconId] get bid from qmsp fail! cpuInfo: " + (String)localObject3, localThrowable2);
              a = true;
            }
            c.b("[beaconId] get bid from qmsp fail! cpuInfo: " + (String)localObject3, new Object[0]);
            c.a(localThrowable2);
            arrayOfString2 = null;
          }
          continue;
          f.a(arrayOfString2);
          paramInt = 0;
          if (paramInt < arrayOfString2.length)
          {
            arrayOfString2[paramInt] = f.a(arrayOfString2[paramInt]);
            paramInt += 1;
            continue;
          }
          localObject3 = new StringBuilder();
          paramInt = i;
        }
        if (paramInt < arrayOfString2.length) {
          if (paramInt >= 9) {
            ((StringBuilder)localObject3).append("k").append(paramInt + 2).append(":").append(arrayOfString2[paramInt]).append(";");
          } else {
            ((StringBuilder)localObject3).append("k").append(paramInt + 1).append(":").append(arrayOfString2[paramInt]).append(";");
          }
        }
      }
      finally {}
      ((StringBuilder)localObject3).append("k10:").append(1);
      c.a("[BeaconId] %s", new Object[] { localObject3 });
      String str = ((StringBuilder)localObject3).toString();
      continue;
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.b.a
 * JD-Core Version:    0.7.0.1
 */