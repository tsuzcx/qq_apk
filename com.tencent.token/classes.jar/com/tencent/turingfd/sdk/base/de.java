package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.HandlerThread;
import java.util.Map;

public final class de
{
  public static boolean a;
  
  public static df a(Context paramContext)
  {
    a();
    return new ej(ed.a(paramContext));
  }
  
  public static void a()
  {
    if (a) {
      return;
    }
    throw new IllegalStateException("please init first");
  }
  
  public static void a(dc paramdc)
  {
    a = true;
    Object localObject = new ea(paramdc.o(), null);
    ((ea)localObject).d = paramdc.c();
    ((ea)localObject).b = paramdc.d();
    ((ea)localObject).g = paramdc.a();
    ((ea)localObject).c = paramdc.b();
    ((ea)localObject).e = paramdc.r();
    ((ea)localObject).f = paramdc.q();
    localObject = new dz((ea)localObject, null);
    if (!er.a) {
      if (((en)localObject).f)
      {
        try
        {
          System.loadLibrary("turingbase");
          bool = true;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            boolean bool = false;
          }
        }
        er.a = bool;
        if (er.a) {
          break label120;
        }
      }
    }
    label120:
    bm localbm;
    for (;;)
    {
      ef.a(paramdc);
      return;
      er.a = true;
      localbm = bm.a();
      localbm.c = ((en)localObject);
      if (!localbm.e) {
        break;
      }
      er.b = true;
    }
    localbm.e = true;
    ed.b(((en)localObject).a);
    HandlerThread localHandlerThread = new HandlerThread("TuringFdCore");
    localHandlerThread.start();
    localbm.d = new bn(localbm, localHandlerThread.getLooper(), ((en)localObject).a);
    localbm.f = new bp(localbm.d);
    localObject = ((en)localObject).a;
    if (!ca.a.containsKey(ca.c)) {}
    for (;;)
    {
      new bi(localbm).start();
      break;
      new bz((cb)ca.a.get(ca.c), (Context)localObject).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.de
 * JD-Core Version:    0.7.0.1
 */