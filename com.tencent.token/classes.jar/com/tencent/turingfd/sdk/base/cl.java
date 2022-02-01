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
    int j;
    int i;
    Object localObject3;
    if (localObject1 != null)
    {
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject1[i];
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
        try
        {
          int k = ((String)localObject3).charAt(0);
          if ((k <= 57) && (k >= 48))
          {
            localObject3 = cm.b(Integer.parseInt((String)localObject3));
            if (localObject3 != null) {
              ((List)localObject2).add(localObject3);
            }
          }
        }
        catch (Exception localException)
        {
          label111:
          Object localObject4;
          Object localObject5;
          Iterator localIterator;
          String str;
          break label111;
        }
        i += 1;
      }
    }
    else
    {
      localObject3 = new ArrayList();
      j = Process.myPid();
      localObject1 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (w)((Iterator)localObject1).next();
        if (j == ((w)localObject4).a) {
          i = ((w)localObject4).e;
        }
      }
      if (i != 0)
      {
        localObject1 = "";
        localObject4 = ((List)localObject2).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (w)((Iterator)localObject4).next();
          if (i == ((w)localObject5).a) {
            localObject1 = ((w)localObject5).d;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject4 = new Flat();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(da.c);
          ((StringBuilder)localObject5).append(da.l);
          ((Flat)localObject4).sc = ((StringBuilder)localObject5).toString();
          ((Flat)localObject4).tc = ((String)localObject1);
          ((List)localObject3).add(localObject4);
        }
      }
      localArrayList.addAll((Collection)localObject3);
      localObject3 = new StringBuilder();
      localObject1 = new ArrayList();
      localObject4 = ((List)localObject2).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (w)((Iterator)localObject4).next();
        localIterator = a.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (((w)localObject5).d.contains(str))
          {
            ((StringBuilder)localObject3).append(((w)localObject5).d);
            ((StringBuilder)localObject3).append("_");
          }
        }
      }
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject4 = new Flat();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(da.c);
        ((StringBuilder)localObject5).append(da.h);
        ((Flat)localObject4).sc = ((StringBuilder)localObject5).toString();
        ((Flat)localObject4).tc = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
        ((List)localObject1).add(localObject4);
      }
      localArrayList.addAll((Collection)localObject1);
      localObject1 = new ArrayList();
      localObject3 = new StringBuilder();
      localObject4 = new HashSet();
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (w)((Iterator)localObject2).next();
        if ((((w)localObject5).c == 0) && (((w)localObject5).d.startsWith("/")) && (!((w)localObject5).d.startsWith("/system")) && (!((w)localObject5).d.startsWith("/dev")) && (!((w)localObject5).d.startsWith("/sbin")) && (!((w)localObject5).d.startsWith("/init")) && (!((w)localObject5).d.startsWith("/vendor")) && (!((w)localObject5).d.startsWith("/bin")) && (!((w)localObject5).d.startsWith("/usr")) && (!((w)localObject5).d.contains("kinguser")) && (!((w)localObject5).d.endsWith("so")))
        {
          localIterator = a.iterator();
          while (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            if (((w)localObject5).d.contains(str))
            {
              j = 1;
              break label814;
            }
          }
          j = 0;
          label814:
          if (j == 0)
          {
            localIterator = c.iterator();
            while (localIterator.hasNext())
            {
              str = (String)localIterator.next();
              if (((w)localObject5).d.contains(str))
              {
                j = 1;
                break label873;
              }
            }
            j = 0;
            label873:
            if (j == 0)
            {
              ((Set)localObject4).add(((w)localObject5).d);
              if (i >= 8) {
                break;
              }
              i += 1;
            }
          }
        }
      }
      if (((Set)localObject4).size() > 0)
      {
        localObject2 = ((Set)localObject4).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ((StringBuilder)localObject3).append((String)((Iterator)localObject2).next());
          ((StringBuilder)localObject3).append("_");
        }
        localObject2 = ((StringBuilder)localObject3).toString();
        localObject3 = new Flat();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(da.c);
        ((StringBuilder)localObject4).append(da.i);
        ((Flat)localObject3).sc = ((StringBuilder)localObject4).toString();
        ((Flat)localObject3).tc = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        ((List)localObject1).add(localObject3);
      }
      localArrayList.addAll((Collection)localObject1);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cl
 * JD-Core Version:    0.7.0.1
 */