package com.tencent.turingfd.sdk.base;

import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class cl
{
  public static final Set<String> a = new HashSet();
  public static List<Flat> b = null;
  public static final Set<String> c;
  
  static
  {
    a.add(ct.a(ct.M));
    a.add(ct.a(ct.N));
    a.add(ct.a(ct.O));
    a.add(ct.a(ct.P));
    a.add(ct.a(ct.Q));
    a.add(ct.a(ct.R));
    a.add(ct.a(ct.S));
    a.add(ct.a(ct.T));
    a.add(ct.a(ct.U));
    a.add(ct.a(ct.V));
    a.add(ct.a(ct.W));
    a.add(ct.a(ct.X));
    c = new HashSet();
    c.add(ct.a(ct.L));
  }
  
  public static List<Flat> a()
  {
    List localList = b;
    if (localList != null) {
      return localList;
    }
    return b();
  }
  
  public static List<Flat> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new File("/proc").list();
    Object localObject3;
    if (localObject1 == null)
    {
      localObject3 = new ArrayList();
      j = Process.myPid();
      localObject1 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject5 = (w)((Iterator)localObject1).next();
        if (j == ((w)localObject5).a) {
          i = ((w)localObject5).e;
        }
      }
    }
    int j = localObject1.length;
    int i = 0;
    label101:
    if (i < j)
    {
      localObject3 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label126;
      }
    }
    for (;;)
    {
      i += 1;
      break label101;
      break;
      try
      {
        label126:
        int k = ((String)localObject3).charAt(0);
        if ((k <= 57) && (k >= 48))
        {
          localObject3 = cm.b(Integer.parseInt((String)localObject3));
          if (localObject3 != null) {
            ((List)localObject2).add(localObject3);
          }
        }
      }
      catch (Exception localException) {}
    }
    if (i == 0) {}
    w localw;
    Iterator localIterator;
    String str;
    for (;;)
    {
      localArrayList.addAll(localException);
      localObject4 = new StringBuilder();
      localObject1 = new ArrayList();
      localObject5 = ((List)localObject2).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localw = (w)((Iterator)localObject5).next();
        localIterator = a.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (localw.d.contains(str))
          {
            ((StringBuilder)localObject4).append(localw.d);
            ((StringBuilder)localObject4).append("_");
          }
        }
      }
      localObject5 = ((List)localObject2).iterator();
      localObject1 = "";
      while (((Iterator)localObject5).hasNext())
      {
        localw = (w)((Iterator)localObject5).next();
        if (i == localw.a) {
          localObject1 = localw.d;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject5 = new Flat();
        ((Flat)localObject5).sc = (da.c + da.l);
        ((Flat)localObject5).tc = ((String)localObject1);
        ((List)localObject4).add(localObject5);
      }
    }
    Object localObject4 = ((StringBuilder)localObject4).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject5 = new Flat();
      ((Flat)localObject5).sc = (da.c + da.h);
      ((Flat)localObject5).tc = ((String)localObject4).substring(0, ((String)localObject4).length() - 1);
      ((List)localObject1).add(localObject5);
    }
    localArrayList.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    localObject4 = new StringBuilder();
    Object localObject5 = new HashSet();
    localObject2 = ((List)localObject2).iterator();
    i = 0;
    label974:
    label979:
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localw = (w)((Iterator)localObject2).next();
        if ((localw.c == 0) && (localw.d.startsWith("/")) && (!localw.d.startsWith("/system")) && (!localw.d.startsWith("/dev")) && (!localw.d.startsWith("/sbin")) && (!localw.d.startsWith("/init")) && (!localw.d.startsWith("/vendor")) && (!localw.d.startsWith("/bin")) && (!localw.d.startsWith("/usr")) && (!localw.d.contains("kinguser")) && (!localw.d.endsWith("so")))
        {
          localIterator = a.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
          } while (!localw.d.contains(str));
        }
      }
      else
      {
        for (j = 1;; j = 0)
        {
          if (j != 0) {
            break label979;
          }
          localIterator = c.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
          } while (!localw.d.contains(str));
          for (j = 1;; j = 0)
          {
            if (j != 0) {
              break label974;
            }
            ((Set)localObject5).add(localw.d);
            if (i >= 8)
            {
              if (((Set)localObject5).size() > 0)
              {
                localObject2 = ((Set)localObject5).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  ((StringBuilder)localObject4).append((String)((Iterator)localObject2).next());
                  ((StringBuilder)localObject4).append("_");
                }
                localObject2 = ((StringBuilder)localObject4).toString();
                localObject4 = new Flat();
                ((Flat)localObject4).sc = (da.c + da.i);
                ((Flat)localObject4).tc = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                ((List)localObject1).add(localObject4);
              }
              localArrayList.addAll((Collection)localObject1);
              return localArrayList;
            }
            i += 1;
            break;
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cl
 * JD-Core Version:    0.7.0.1
 */