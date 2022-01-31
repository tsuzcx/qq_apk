package com.tencent.mapsdk.net;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static boolean A;
  private static int B;
  private static int a = 10000;
  private static int b = 15000;
  private static int c = 5000;
  private static int d = 20000;
  private static int e = 25000;
  private static int f = 15000;
  private static int g = 1;
  private static int h = 3;
  private static ArrayList<a> i;
  private static long j;
  private static long k;
  private static long l;
  private static long m;
  private static long n;
  private static long o;
  private static long p;
  private static int q;
  private static long r;
  private static long s;
  private static long t;
  private static long u;
  private static int v;
  private static int w;
  private static int x;
  private static int y;
  private static int z;
  
  static
  {
    A = false;
    B = -1;
    e();
  }
  
  public static int a()
  {
    int i2 = a;
    int i1 = i2;
    if (m > 0L)
    {
      i1 = i2;
      if (n > 0L) {
        i1 = (int)(Math.max(p, m) + n - o);
      }
    }
    Object localObject = (ConnectivityManager)NetContext.getContext().getSystemService("connectivity");
    i2 = i1;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      i2 = i1;
      if (localObject != null)
      {
        if ((((NetworkInfo)localObject).isConnected()) || (!((NetworkInfo)localObject).isAvailable())) {
          break label203;
        }
        i2 = b;
      }
    }
    for (;;)
    {
      i2 += z * c;
      i1 = i2;
      if (i2 <= c) {
        i1 = c;
      }
      i2 = i1;
      if (i1 <= n) {
        i2 = (int)(n + c);
      }
      i1 = i2;
      if (i2 >= b) {
        i1 = b;
      }
      a locala = b(Thread.currentThread().getId());
      localObject = locala;
      if (locala == null) {
        localObject = a(Thread.currentThread().getId());
      }
      i2 = i1;
      if (i1 < ((a)localObject).j + c) {
        i2 = ((a)localObject).j + c;
      }
      ((a)localObject).j = i2;
      return i2;
      label203:
      i2 = i1;
      if (n > 0L)
      {
        i2 = i1;
        if (n < c) {
          i2 = c;
        }
      }
    }
  }
  
  private static a a(long paramLong)
  {
    if (i == null) {
      i = new ArrayList();
    }
    int i3;
    int i1;
    synchronized (i)
    {
      int i2;
      Object localObject1;
      if (i.size() > 20)
      {
        int i4 = i.size();
        i3 = 0;
        i2 = 0;
        i1 = 0;
        if (i1 < i4 / 2) {
          break label266;
        }
        if (i2 != 0)
        {
          k = ((a)i.get(0)).d;
          l = ((a)i.get(0)).d;
          n = ((a)i.get(0)).e;
          o = ((a)i.get(0)).e;
          s = ((a)i.get(0)).f;
          t = ((a)i.get(0)).f;
          if (((a)i.get(0)).h > 0L) {
            w = (int)(((a)i.get(0)).g * 1000 / ((a)i.get(0)).h);
          }
          x = w;
          localObject1 = i.iterator();
        }
      }
      label266:
      do
      {
        a locala;
        do
        {
          if (!((Iterator)localObject1).hasNext())
          {
            localObject1 = new a();
            ((a)localObject1).b = paramLong;
            i.add(localObject1);
            return localObject1;
            if ((((a)i.get(i3)).h <= 0L) && (System.currentTimeMillis() - ((a)i.get(i3)).c <= 600000L)) {
              break label524;
            }
            i.remove(i3);
            i2 = 1;
            break;
          }
          locala = (a)((Iterator)localObject1).next();
          if (locala.d > k) {
            k = locala.d;
          }
          if (locala.d < l) {
            l = locala.d;
          }
          if (locala.e > n) {
            n = locala.e;
          }
          if (locala.e < o) {
            o = locala.e;
          }
          if (locala.f > s) {
            s = locala.f;
          }
          if (locala.f < t) {
            t = locala.f;
          }
        } while (locala.h <= 0L);
        i1 = (int)(locala.g * 1000 / locala.h);
        if (i1 > w) {
          w = i1;
        }
      } while (i1 >= x);
      x = i1;
    }
    for (;;)
    {
      i1 += 1;
      break;
      label524:
      i3 += 1;
    }
  }
  
  public static void a(int paramInt)
  {
    a locala1 = b(Thread.currentThread().getId());
    if (locala1 == null) {
      return;
    }
    locala1.h = (System.currentTimeMillis() - locala1.c);
    locala1.c = System.currentTimeMillis();
    locala1.g = paramInt;
    long l1;
    if (locala1.h == 0L) {
      l1 = 1L;
    }
    for (;;)
    {
      paramInt = (int)(paramInt * 1000 / l1);
      y = paramInt;
      if (paramInt > w)
      {
        paramInt = y;
        label82:
        w = paramInt;
        if (y >= x) {
          break label246;
        }
        paramInt = y;
        label99:
        x = paramInt;
        paramInt = 0;
        l1 = 0L;
        if (i == null) {}
      }
      synchronized (i)
      {
        Iterator localIterator = i.iterator();
        if (!localIterator.hasNext())
        {
          if (l1 > 0L) {
            v = (int)(paramInt * 1000 / l1);
          }
          if ((z > 0) && (locala1.e < c) && (locala1.f < f)) {
            z -= 1;
          }
          locala1.a = null;
          locala1.j = ((int)locala1.e);
          locala1.l = 0;
          locala1.m = 0;
          return;
          l1 = locala1.h;
          continue;
          paramInt = w;
          break label82;
          label246:
          if (x == 0)
          {
            paramInt = y;
            break label99;
          }
          paramInt = x;
          break label99;
        }
        a locala2 = (a)localIterator.next();
        paramInt += locala2.g;
        long l2 = locala2.h;
        l1 += l2;
      }
    }
  }
  
  public static void a(Intent paramIntent)
  {
    int i1;
    if (paramIntent.getBooleanExtra("noConnectivity", false)) {
      if (i != null)
      {
        paramIntent = i;
        i1 = 0;
      }
    }
    do
    {
      try
      {
        for (;;)
        {
          if (i1 >= i.size())
          {
            A = false;
            j = 0L;
            k = 0L;
            l = 0L;
            m = 0L;
            n = 0L;
            o = 0L;
            p = 0L;
            q = 0;
            r = 0L;
            s = 0L;
            t = 0L;
            u = 0L;
            v = 0;
            w = 0;
            x = 0;
            y = 0;
            z = 0;
            return;
          }
          i.remove(0);
          i1 += 1;
        }
        paramIntent = (ConnectivityManager)NetContext.getContext().getSystemService("connectivity");
      }
      finally {}
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getActiveNetworkInfo();
        if (paramIntent == null) {}
      }
      for (i1 = paramIntent.getType(); i1 != B; i1 = -1)
      {
        e();
        return;
      }
    } while (A);
    e();
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    a locala2 = b(Thread.currentThread().getId());
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = a(Thread.currentThread().getId());
    }
    if (locala1 == null) {
      return;
    }
    locala1.a = paramHttpURLConnection;
    locala1.c = System.currentTimeMillis();
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      z += 1;
    }
    a locala = c(Thread.currentThread().getId());
    if (locala != null)
    {
      locala.a = null;
      locala.i = (System.currentTimeMillis() - locala.c);
    }
  }
  
  public static int b()
  {
    int i2 = d;
    int i1 = i2;
    if (r > 0L)
    {
      i1 = i2;
      if (s > 0L) {
        i1 = (int)(Math.max(u, r) + s - t);
      }
    }
    Object localObject = (ConnectivityManager)NetContext.getContext().getSystemService("connectivity");
    i2 = i1;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      i2 = i1;
      if (localObject != null)
      {
        if ((((NetworkInfo)localObject).isConnected()) || (!((NetworkInfo)localObject).isAvailable())) {
          break label218;
        }
        i2 = e;
      }
    }
    for (;;)
    {
      i2 += z * c;
      i1 = i2;
      if (i2 <= f) {
        i1 = f;
      }
      i2 = i1;
      if (i1 <= s) {
        i2 = (int)(s + f);
      }
      i1 = i2;
      if (i2 >= e) {
        i1 = e;
      }
      localObject = b(Thread.currentThread().getId());
      i2 = i1;
      if (localObject != null)
      {
        i2 = i1;
        if (i1 < ((a)localObject).k + f) {
          i2 = ((a)localObject).k + f;
        }
        i1 = i2;
        if (i2 < ((a)localObject).j + f) {
          i1 = ((a)localObject).j + f;
        }
        ((a)localObject).k = i1;
        i2 = i1;
      }
      return i2;
      label218:
      i2 = i1;
      if (s > 0L)
      {
        i2 = i1;
        if (s < f) {
          i2 = f;
        }
      }
    }
  }
  
  private static a b(long paramLong)
  {
    if (i == null) {
      return null;
    }
    synchronized (i)
    {
      Iterator localIterator = i.iterator();
      a locala;
      do
      {
        if (!localIterator.hasNext()) {
          return null;
        }
        locala = (a)localIterator.next();
      } while (locala.b != paramLong);
      return locala;
    }
  }
  
  private static a c(long paramLong)
  {
    if (i != null) {}
    for (;;)
    {
      int i1;
      synchronized (i)
      {
        i1 = i.size();
        i1 -= 1;
        if (i1 < 0) {
          return null;
        }
        if (((a)i.get(i1)).b == paramLong)
        {
          a locala = (a)i.remove(i1);
          return locala;
        }
      }
      i1 -= 1;
    }
  }
  
  public static void c()
  {
    Object localObject1 = b(Thread.currentThread().getId());
    if (localObject1 == null) {}
    long l1;
    label77:
    do
    {
      return;
      ((a)localObject1).e = (System.currentTimeMillis() - ((a)localObject1).c);
      ((a)localObject1).c = System.currentTimeMillis();
      p = ((a)localObject1).e;
      if (((a)localObject1).e <= n) {
        break;
      }
      l1 = ((a)localObject1).e;
      n = l1;
      if (((a)localObject1).e >= o) {
        break label143;
      }
      l1 = ((a)localObject1).e;
      o = l1;
    } while (i == null);
    localObject1 = i;
    int i1 = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = i.iterator();
        if (localIterator.hasNext()) {
          break label166;
        }
        if (i1 > 0) {
          m /= i1;
        }
        return;
      }
      finally {}
      l1 = n;
      break;
      label143:
      if (o == 0L)
      {
        l1 = ((a)localObject1).e;
        break label77;
      }
      l1 = o;
      break label77;
      label166:
      a locala = (a)localObject2.next();
      if (locala.e > 0L)
      {
        m += locala.e;
        i1 += 1;
      }
    }
  }
  
  public static void d()
  {
    Object localObject1 = b(Thread.currentThread().getId());
    if (localObject1 == null) {}
    long l1;
    label77:
    do
    {
      return;
      ((a)localObject1).f = (System.currentTimeMillis() - ((a)localObject1).c);
      ((a)localObject1).c = System.currentTimeMillis();
      u = ((a)localObject1).f;
      if (((a)localObject1).f <= s) {
        break;
      }
      l1 = ((a)localObject1).f;
      s = l1;
      if (((a)localObject1).f >= t) {
        break label143;
      }
      l1 = ((a)localObject1).f;
      t = l1;
    } while (i == null);
    localObject1 = i;
    int i1 = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = i.iterator();
        if (localIterator.hasNext()) {
          break label166;
        }
        if (i1 > 0) {
          r /= i1;
        }
        return;
      }
      finally {}
      l1 = s;
      break;
      label143:
      if (t == 0L)
      {
        l1 = ((a)localObject1).f;
        break label77;
      }
      l1 = t;
      break label77;
      label166:
      a locala = (a)localObject2.next();
      if (locala.f > 0L)
      {
        r += locala.f;
        i1 += 1;
      }
    }
  }
  
  private static void e()
  {
    a = 12000;
    b = 20000;
    c = 8000;
    d = 20000;
    e = 25000;
    f = 15000;
    g = 1;
    h = 3;
    Object localObject = (ConnectivityManager)NetContext.getContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        int i1 = ((NetworkInfo)localObject).getType();
        if (((NetworkInfo)localObject).isConnected())
        {
          A = true;
          B = i1;
          if (i1 == 0)
          {
            localObject = ((TelephonyManager)NetContext.getContext().getSystemService("phone")).getSubscriberId();
            if ((localObject != null) && (((String)localObject).length() > 3) && (!((String)localObject).startsWith("46000")) && (!((String)localObject).startsWith("46002")))
            {
              a = 15000;
              b = 25000;
              c = 10000;
              d = 25000;
              e = 35000;
              f = 15000;
              g = 2;
              h = 4;
            }
          }
        }
      }
    }
  }
  
  public static final class a
  {
    public HttpURLConnection a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public long h;
    public long i;
    public int j;
    public int k;
    public int l;
    public int m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mapsdk.net.a
 * JD-Core Version:    0.7.0.1
 */