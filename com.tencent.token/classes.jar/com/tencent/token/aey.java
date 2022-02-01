package com.tencent.token;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.Flat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class aey
{
  public static final Set<String> a = new HashSet();
  public static List<Flat> b = null;
  public static final Set<String> c;
  
  static
  {
    a.add(afg.a(afg.M));
    a.add(afg.a(afg.N));
    a.add(afg.a(afg.O));
    a.add(afg.a(afg.P));
    a.add(afg.a(afg.Q));
    a.add(afg.a(afg.R));
    a.add(afg.a(afg.S));
    a.add(afg.a(afg.T));
    a.add(afg.a(afg.U));
    a.add(afg.a(afg.V));
    a.add(afg.a(afg.W));
    a.add(afg.a(afg.X));
    HashSet localHashSet = new HashSet();
    c = localHashSet;
    localHashSet.add(afg.a(afg.L));
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
            localObject3 = aez.a(Integer.parseInt((String)localObject3));
            if (localObject3 != null) {
              ((List)localObject2).add(localObject3);
            }
          }
        }
        catch (Exception localException)
        {
          label102:
          Object localObject4;
          Object localObject5;
          Iterator localIterator;
          String str;
          break label102;
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
        localObject4 = (acj)((Iterator)localObject1).next();
        if (j == ((acj)localObject4).a) {
          i = ((acj)localObject4).e;
        }
      }
      if (i != 0)
      {
        localObject1 = "";
        localObject4 = ((List)localObject2).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (acj)((Iterator)localObject4).next();
          if (i == ((acj)localObject5).a) {
            localObject1 = ((acj)localObject5).d;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject4 = new Flat();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(afn.c);
          ((StringBuilder)localObject5).append(afn.l);
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
        localObject5 = (acj)((Iterator)localObject4).next();
        localIterator = a.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (((acj)localObject5).d.contains(str))
          {
            ((StringBuilder)localObject3).append(((acj)localObject5).d);
            ((StringBuilder)localObject3).append("_");
          }
        }
      }
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject4 = new Flat();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(afn.c);
        ((StringBuilder)localObject5).append(afn.h);
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
        localObject5 = (acj)((Iterator)localObject2).next();
        label822:
        if ((((acj)localObject5).c == 0) && (((acj)localObject5).d.startsWith("/")) && (!((acj)localObject5).d.startsWith("/system")) && (!((acj)localObject5).d.startsWith("/dev")) && (!((acj)localObject5).d.startsWith("/sbin")) && (!((acj)localObject5).d.startsWith("/init")) && (!((acj)localObject5).d.startsWith("/vendor")) && (!((acj)localObject5).d.startsWith("/bin")) && (!((acj)localObject5).d.startsWith("/usr")) && (!((acj)localObject5).d.contains("kinguser")) && (!((acj)localObject5).d.endsWith("so")))
        {
          localIterator = a.iterator();
          while (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            if (((acj)localObject5).d.contains(str))
            {
              j = 1;
              break label766;
            }
          }
          j = 0;
          label766:
          if (j == 0)
          {
            localIterator = c.iterator();
            while (localIterator.hasNext())
            {
              str = (String)localIterator.next();
              if (((acj)localObject5).d.contains(str))
              {
                j = 1;
                break label822;
              }
            }
            j = 0;
            if (j == 0)
            {
              ((Set)localObject4).add(((acj)localObject5).d);
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
        ((StringBuilder)localObject4).append(afn.c);
        ((StringBuilder)localObject4).append(afn.i);
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
 * Qualified Name:     com.tencent.token.aey
 * JD-Core Version:    0.7.0.1
 */