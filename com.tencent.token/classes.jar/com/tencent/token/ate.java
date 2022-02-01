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

public class ate
  extends aro
{
  public atb a;
  public ExecutorService b;
  private final String c = "SharkProtocolQueue";
  private final int d = 1073741824;
  private final long e = -1L;
  private Context f;
  private TreeMap g = new TreeMap();
  private ArrayList h = new ArrayList();
  private Handler i = new atf(this, Looper.getMainLooper());
  
  public static void a(int paramInt)
  {
    if (b(5, 1))
    {
      atm.a().a.incrementAndGet();
      if (b(5, 4)) {
        atm.a().b();
      }
    }
  }
  
  public static void b(int paramInt)
  {
    if (b(1, 1))
    {
      atm localatm = atm.a();
      if (localatm.a.decrementAndGet() <= 0)
      {
        localatm.a.set(0);
        localatm.c();
      }
    }
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public final ajj a(int paramInt1, int paramInt2)
  {
    if (b(paramInt2, 1)) {
      return atm.a().a(paramInt1);
    }
    ajj localajj = null;
    synchronized (this.g)
    {
      if (this.g.containsKey(Integer.valueOf(paramInt1))) {
        localajj = (ajj)((Pair)this.g.remove(Integer.valueOf(paramInt1))).second;
      }
      return localajj;
    }
  }
  
  public final WeakReference a(long paramLong, int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, aji paramaji)
  {
    return a(paramLong, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramaji, -1L);
  }
  
  public final WeakReference a(long paramLong1, int paramInt1, JceStruct arg4, JceStruct paramJceStruct2, int paramInt2, aji paramaji, long paramLong2)
  {
    if (b(paramInt2, 1)) {
      return atm.a().a(this.a, paramInt1, paramInt2, 0, 0, ???, paramJceStruct2, paramaji, paramLong2);
    }
    paramJceStruct2 = new atg(this, paramLong1, paramInt1, ???, paramJceStruct2, paramInt2, paramaji);
    paramJceStruct2.g = this.a.b.a();
    paramJceStruct2.i = paramLong2;
    synchronized (this.h)
    {
      this.h.add(paramJceStruct2);
      this.i.sendEmptyMessage(1);
      return new WeakReference(paramJceStruct2.h);
    }
  }
  
  public final void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, ajj paramajj)
  {
    if (paramajj != null)
    {
      if (b(paramInt2, 1))
      {
        atm.a().a(paramInt2, paramInt1, paramJceStruct, paramajj);
        return;
      }
      Object localObject = null;
      synchronized (this.g)
      {
        if (!this.g.containsKey(Integer.valueOf(paramInt1)))
        {
          this.g.put(Integer.valueOf(paramInt1), new Pair(paramJceStruct, paramajj));
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
 * Qualified Name:     com.tencent.token.ate
 * JD-Core Version:    0.7.0.1
 */