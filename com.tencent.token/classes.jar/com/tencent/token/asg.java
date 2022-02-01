package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class asg
  extends aqq
{
  public asd a;
  public ExecutorService b;
  private final String c = "SharkProtocolQueue";
  private final int d = 1073741824;
  private final long e = -1L;
  private Context f;
  private TreeMap g = new TreeMap();
  private ArrayList h = new ArrayList();
  private Handler i = new ash(this, Looper.getMainLooper());
  
  public static void a(int paramInt)
  {
    if (b(5, 1))
    {
      aso.a().a.incrementAndGet();
      if (b(5, 4)) {
        aso.a().b();
      }
    }
  }
  
  public static void b(int paramInt)
  {
    if (b(1, 1))
    {
      aso localaso = aso.a();
      if (localaso.a.decrementAndGet() <= 0)
      {
        localaso.a.set(0);
        localaso.c();
      }
    }
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public final aij a(int paramInt1, int paramInt2)
  {
    if (b(paramInt2, 1)) {
      return aso.a().a(paramInt1);
    }
    aij localaij = null;
    synchronized (this.g)
    {
      if (this.g.containsKey(Integer.valueOf(paramInt1))) {
        localaij = (aij)((Pair)this.g.remove(Integer.valueOf(paramInt1))).second;
      }
      return localaij;
    }
  }
  
  public final WeakReference a(long paramLong, int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, aii paramaii)
  {
    return a(paramLong, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramaii, -1L);
  }
  
  public final WeakReference a(long paramLong1, int paramInt1, JceStruct arg4, JceStruct paramJceStruct2, int paramInt2, aii paramaii, long paramLong2)
  {
    if (b(paramInt2, 1)) {
      return aso.a().a(this.a, paramInt1, paramInt2, 0, 0, ???, paramJceStruct2, paramaii, paramLong2);
    }
    paramJceStruct2 = new asi(this, paramLong1, paramInt1, ???, paramJceStruct2, paramInt2, paramaii);
    paramJceStruct2.g = this.a.b.a();
    paramJceStruct2.i = paramLong2;
    synchronized (this.h)
    {
      this.h.add(paramJceStruct2);
      this.i.sendEmptyMessage(1);
      return new WeakReference(paramJceStruct2.h);
    }
  }
  
  public final void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, aij paramaij)
  {
    if (paramaij != null)
    {
      if (b(paramInt2, 1))
      {
        aso.a().a(paramInt2, paramInt1, paramJceStruct, paramaij);
        return;
      }
      Object localObject = null;
      synchronized (this.g)
      {
        if (!this.g.containsKey(Integer.valueOf(paramInt1)))
        {
          this.g.put(Integer.valueOf(paramInt1), new Pair(paramJceStruct, paramaij));
          paramJceStruct = localObject;
        }
        else
        {
          paramJceStruct = new ClassCastException();
        }
        if (paramJceStruct == null) {
          return;
        }
        throw paramJceStruct;
      }
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asg
 * JD-Core Version:    0.7.0.1
 */