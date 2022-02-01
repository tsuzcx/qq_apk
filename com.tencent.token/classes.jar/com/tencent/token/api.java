package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class api
{
  public boolean a = false;
  public apx b;
  public volatile int c;
  public volatile int d;
  public volatile long e;
  public Object f = new Object();
  int g = 0;
  ArrayList h = new ArrayList();
  String i = null;
  private final String j = "IpPlot";
  private Context k;
  private final String l = "http://mazutest.3g.qq.com";
  private final String m = "http://mazu.3g.qq.com";
  private ArrayList n = new ArrayList();
  private ArrayList o = new ArrayList();
  private ArrayList p = new ArrayList();
  private ArrayList q = new ArrayList();
  private ArrayList r = new ArrayList();
  private ArrayList s = new ArrayList();
  private ArrayList t = new ArrayList();
  
  public api(Context arg1, apx paramapx)
  {
    this.k = ???;
    this.a = false;
    this.b = paramapx;
    b();
    paramapx = new AtomicLong();
    AtomicReference localAtomicReference1 = new AtomicReference();
    AtomicReference localAtomicReference2 = new AtomicReference();
    AtomicReference localAtomicReference3 = new AtomicReference();
    this.b.a(paramapx, localAtomicReference1, localAtomicReference2, localAtomicReference3);
    synchronized (this.f)
    {
      if (paramapx.get() > 0L) {
        this.e = paramapx.get();
      }
      this.c = this.b.b();
      this.d = this.b.a();
      a((ArrayList)localAtomicReference1.get(), (ArrayList)localAtomicReference2.get(), (ArrayList)localAtomicReference3.get());
      a();
      return;
    }
  }
  
  private static String a(String paramString)
  {
    String str;
    for (;;)
    {
      str = paramString;
      if (!paramString.startsWith(" ")) {
        break;
      }
      paramString = paramString.substring(1, paramString.length()).trim();
    }
    while (str.endsWith(" ")) {
      str = str.substring(0, str.length() - 1).trim();
    }
    return str;
  }
  
  private static ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i1 = paramArrayList.size() - 1;
      while (i1 > 0)
      {
        double d1 = i1;
        double d2 = Math.random();
        Double.isNaN(d1);
        int i2 = (int)(d1 * d2);
        String str = (String)paramArrayList.get(i1);
        paramArrayList.set(i1, paramArrayList.get(i2));
        paramArrayList.set(i2, str);
        i1 -= 1;
      }
      return paramArrayList;
    }
    return new ArrayList();
  }
  
  public static void a(String paramString, ArrayList paramArrayList)
  {
    if (paramArrayList == null)
    {
      paramArrayList = new StringBuilder("printList() ");
      paramArrayList.append(paramString);
      paramArrayList.append(" is null");
      paramArrayList = new StringBuilder("printList() ");
      paramArrayList.append(paramString);
      paramArrayList.append(" is null");
      return;
    }
    if (paramArrayList.size() <= 0)
    {
      paramArrayList = new StringBuilder("printList() ");
      paramArrayList.append(paramString);
      paramArrayList.append(".size <= 0");
      paramArrayList = new StringBuilder("printList() ");
      paramArrayList.append(paramString);
      paramArrayList.append(".size <= 0");
      return;
    }
    int i2 = paramArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i1)))
      {
        StringBuilder localStringBuilder = new StringBuilder("printList() ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]: ");
        localStringBuilder.append((String)paramArrayList.get(i1));
        localStringBuilder = new StringBuilder("printList() ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]: ");
        localStringBuilder.append((String)paramArrayList.get(i1));
      }
      i1 += 1;
    }
  }
  
  private void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    ArrayList localArrayList;
    switch (k())
    {
    default: 
      return;
    case 2: 
      if (paramBoolean) {
        localArrayList = this.p;
      } else {
        localArrayList = this.s;
      }
      paramArrayList.addAll(localArrayList);
      return;
    case 1: 
      if (paramBoolean) {
        localArrayList = this.o;
      } else {
        localArrayList = this.r;
      }
      paramArrayList.addAll(localArrayList);
      return;
    }
    if (paramBoolean) {
      localArrayList = this.n;
    } else {
      localArrayList = this.q;
    }
    paramArrayList.addAll(localArrayList);
  }
  
  private void b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList.addAll(this.t);
  }
  
  private void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i1 = k();
    ArrayList localArrayList;
    if (i1 != 0)
    {
      if (paramBoolean) {
        localArrayList = this.n;
      } else {
        localArrayList = this.q;
      }
      paramArrayList.addAll(localArrayList);
    }
    if (1 != i1)
    {
      if (paramBoolean) {
        localArrayList = this.o;
      } else {
        localArrayList = this.r;
      }
      paramArrayList.addAll(localArrayList);
    }
    if (2 != i1)
    {
      if (paramBoolean) {
        localArrayList = this.p;
      } else {
        localArrayList = this.s;
      }
      paramArrayList.addAll(localArrayList);
    }
  }
  
  private static boolean b(String paramString)
  {
    paramString = a(paramString);
    if (paramString.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
    {
      paramString = paramString.split("\\.");
      if (paramString.length < 4) {
        return false;
      }
      if ((Integer.parseInt(paramString[0]) < 255) && (Integer.parseInt(paramString[1]) < 255) && (Integer.parseInt(paramString[2]) < 255) && (Integer.parseInt(paramString[3]) < 255)) {
        return true;
      }
    }
    return false;
  }
  
  private static ArrayList c(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    int i1 = paramArrayList.size();
    if (i1 <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    i1 -= 1;
    while (i1 >= 0)
    {
      String str = (String)paramArrayList.get(i1);
      if (!TextUtils.isEmpty(str))
      {
        StringBuilder localStringBuilder = new StringBuilder("getHttpList() ipStr[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]:");
        localStringBuilder.append(str);
        localStringBuilder = new StringBuilder("getHttpList() ipStr[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]:");
        localStringBuilder.append(str);
        if (!b(str)) {
          paramArrayList.remove(i1);
        } else {
          localArrayList.add("http://".concat(String.valueOf(str)));
        }
      }
      i1 -= 1;
    }
    return localArrayList;
  }
  
  private long e()
  {
    synchronized (this.f)
    {
      long l1 = this.e;
      return l1;
    }
  }
  
  private boolean f()
  {
    long l1 = e();
    if (l1 <= 0L) {
      return false;
    }
    return System.currentTimeMillis() > l1;
  }
  
  private void g()
  {
    for (;;)
    {
      int i1;
      synchronized (this.f)
      {
        int i2 = this.h.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (!TextUtils.isEmpty((CharSequence)this.h.get(i1)))
          {
            StringBuilder localStringBuilder = new StringBuilder("printWrokingIpList() mWorkingIpList[");
            localStringBuilder.append(i1);
            localStringBuilder.append("]: ");
            localStringBuilder.append((String)this.h.get(i1));
            localStringBuilder = new StringBuilder("printWrokingIpList() mWorkingIpList[");
            localStringBuilder.append(i1);
            localStringBuilder.append("]: ");
            localStringBuilder.append((String)this.h.get(i1));
          }
        }
        else {
          return;
        }
      }
      i1 += 1;
    }
  }
  
  private void h()
  {
    synchronized (this.f)
    {
      this.g = 0;
      this.h.clear();
      return;
    }
  }
  
  private void i()
  {
    synchronized (this.f)
    {
      h();
      a(true, this.h);
      b(this.h);
      b(true, this.h);
      g();
      this.e = 0L;
      this.b.a(0L, new ArrayList(), new ArrayList(), new ArrayList());
      return;
    }
  }
  
  private String j()
  {
    if (this.a) {
      return "http://mazutest.3g.qq.com";
    }
    return "http://mazu.3g.qq.com";
  }
  
  private int k()
  {
    if (4 == apa.a) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return 2;
    }
    int i1 = arr.f(this.k);
    if (-1 == i1) {
      return 2;
    }
    return i1;
  }
  
  public final void a()
  {
    synchronized (this.f)
    {
      if (this.h == null) {
        return;
      }
      if (c()) {
        return;
      }
      h();
      a(false, this.h);
      b(this.h);
      b(false, this.h);
      g();
      if (this.h.size() <= this.t.size())
      {
        i();
        g();
      }
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    synchronized (this.f)
    {
      this.c = paramInt1;
      this.d = paramInt2;
      this.b.a(paramInt1, paramInt2);
      return;
    }
  }
  
  public final void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if (paramArrayList1 != null) {
      this.q = a(c(paramArrayList1));
    }
    if (paramArrayList2 != null) {
      this.r = a(c(paramArrayList2));
    }
    if (paramArrayList3 != null) {
      this.s = a(c(paramArrayList3));
    }
  }
  
  public final void b()
  {
    synchronized (this.f)
    {
      if (this.a)
      {
        this.n.clear();
        this.o.clear();
        this.t.clear();
        this.t.clear();
        this.t.add("http://mazutest.3g.qq.com");
      }
      else
      {
        this.n.clear();
        this.o.clear();
        this.p.clear();
        this.t.clear();
        this.t.add("http://mazu.3g.qq.com");
      }
      return;
    }
  }
  
  final boolean c()
  {
    boolean bool = f();
    if (bool) {
      i();
    }
    return bool;
  }
  
  final String d()
  {
    synchronized (this.h)
    {
      int i1 = this.h.size();
      if (i1 <= 0)
      {
        str = j();
        return str;
      }
      if (this.g >= i1) {
        this.g = 0;
      }
      String str = (String)this.h.get(this.g);
      StringBuilder localStringBuilder = new StringBuilder("getIpInIpList() mCurIpIdx: ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" ip: ");
      localStringBuilder.append(str);
      localStringBuilder = new StringBuilder("getIpInIpList() mCurIpIdx: ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" ip: ");
      localStringBuilder.append(str);
      if (TextUtils.isEmpty(str))
      {
        str = j();
        return str;
      }
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.api
 * JD-Core Version:    0.7.0.1
 */