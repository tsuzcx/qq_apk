package com.tencent.turingfd.sdk.base;

import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h
{
  public static final Set a = new HashSet();
  public static final String[] b = new String[0];
  public static List c = null;
  public static final Set d;
  
  static
  {
    a.add(db.a(db.I));
    a.add(db.a(db.J));
    a.add(db.a(db.K));
    a.add(db.a(db.L));
    a.add(db.a(db.M));
    a.add(db.a(db.N));
    a.add(db.a(db.O));
    a.add(db.a(db.P));
    a.add(db.a(db.Q));
    a.add(db.a(db.R));
    a.add(db.a(db.S));
    a.add(db.a(db.T));
    d = new HashSet();
    d.add(db.a(db.H));
  }
  
  public static String a(Set paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      localStringBuilder.append((String)paramSet.next());
      if (paramSet.hasNext()) {
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static List a()
  {
    List localList = c;
    if (localList != null) {
      return localList;
    }
    return b();
  }
  
  public static Set a(List paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      al localal = (al)paramList.next();
      if ((localal.c == 2000) && (!localal.d.contains("logcat")) && (!localal.d.contains("sh")) && (!localal.d.contains("adbd")) && (!localal.d.contains("su")) && (!localal.d.contains("grep")) && (!localal.d.startsWith("/system/bin")) && (!localal.d.startsWith("/sbin"))) {
        localHashSet.add(localal.d);
      }
    }
    return localHashSet;
  }
  
  public static List b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject1 = new File("/proc").list();
    Object localObject3;
    if (localObject1 == null)
    {
      localObject3 = new ArrayList();
      j = Process.myPid();
      localObject1 = ((List)localObject5).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject6 = (al)((Iterator)localObject1).next();
        if (j == ((al)localObject6).a) {
          i = ((al)localObject6).e;
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
          localObject3 = ed.b(Integer.parseInt((String)localObject3));
          if (localObject3 != null) {
            ((List)localObject5).add(localObject3);
          }
        }
      }
      catch (Exception localException) {}
    }
    if (i == 0) {}
    Object localObject8;
    Object localObject9;
    for (;;)
    {
      localArrayList.addAll(localException);
      localObject4 = new StringBuilder();
      localObject1 = new ArrayList();
      localObject6 = ((List)localObject5).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (al)((Iterator)localObject6).next();
        localObject8 = a.iterator();
        while (((Iterator)localObject8).hasNext())
        {
          localObject9 = (String)((Iterator)localObject8).next();
          if (((al)localObject7).d.contains((CharSequence)localObject9))
          {
            ((StringBuilder)localObject4).append(((al)localObject7).d);
            ((StringBuilder)localObject4).append("_");
          }
        }
      }
      localObject6 = ((List)localObject5).iterator();
      localObject1 = "";
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (al)((Iterator)localObject6).next();
        if (i == ((al)localObject7).a) {
          localObject1 = ((al)localObject7).d;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject6 = new Fig();
        ((Fig)localObject6).vc = (dk.c + dk.n);
        ((Fig)localObject6).wc = ((String)localObject1);
        ((List)localObject4).add(localObject6);
      }
    }
    Object localObject4 = ((StringBuilder)localObject4).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject6 = new Fig();
      ((Fig)localObject6).vc = (dk.c + dk.h);
      ((Fig)localObject6).wc = ((String)localObject4).substring(0, ((String)localObject4).length() - 1);
      ((List)localObject1).add(localObject6);
    }
    localArrayList.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    localObject4 = new StringBuilder();
    Object localObject6 = new HashSet();
    Object localObject7 = ((List)localObject5).iterator();
    i = 0;
    label1555:
    label1693:
    label1698:
    for (;;)
    {
      String str;
      if (((Iterator)localObject7).hasNext())
      {
        localObject8 = (al)((Iterator)localObject7).next();
        if ((((al)localObject8).c == 0) && (((al)localObject8).d.startsWith("/")) && (!((al)localObject8).d.startsWith("/system")) && (!((al)localObject8).d.startsWith("/dev")) && (!((al)localObject8).d.startsWith("/sbin")) && (!((al)localObject8).d.startsWith("/init")) && (!((al)localObject8).d.startsWith("/vendor")) && (!((al)localObject8).d.startsWith("/bin")) && (!((al)localObject8).d.startsWith("/usr")) && (!((al)localObject8).d.contains("kinguser")) && (!((al)localObject8).d.endsWith("so")))
        {
          localObject9 = a.iterator();
          do
          {
            if (!((Iterator)localObject9).hasNext()) {
              break;
            }
            str = (String)((Iterator)localObject9).next();
          } while (!((al)localObject8).d.contains(str));
        }
      }
      else
      {
        for (j = 1;; j = 0)
        {
          if (j != 0) {
            break label1698;
          }
          localObject9 = d.iterator();
          do
          {
            if (!((Iterator)localObject9).hasNext()) {
              break;
            }
            str = (String)((Iterator)localObject9).next();
          } while (!((al)localObject8).d.contains(str));
          for (j = 1;; j = 0)
          {
            if (j != 0) {
              break label1693;
            }
            ((Set)localObject6).add(((al)localObject8).d);
            if (i >= 8)
            {
              if (((Set)localObject6).size() > 0)
              {
                localObject6 = ((Set)localObject6).iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  ((StringBuilder)localObject4).append((String)((Iterator)localObject6).next());
                  ((StringBuilder)localObject4).append("_");
                }
                localObject4 = ((StringBuilder)localObject4).toString();
                localObject6 = new Fig();
                ((Fig)localObject6).vc = (dk.c + dk.i);
                ((Fig)localObject6).wc = ((String)localObject4).substring(0, ((String)localObject4).length() - 1);
                ((List)localObject1).add(localObject6);
              }
              localArrayList.addAll((Collection)localObject1);
              Object localObject2;
              for (;;)
              {
                try
                {
                  localObject1 = new String(ed.c(db.a(db.ak)));
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    continue;
                  }
                  localObject1 = b;
                }
                catch (Throwable localThrowable)
                {
                  localObject2 = b;
                  continue;
                  if (!"2000".equals(((Matcher)localObject8).group(4))) {
                    continue;
                  }
                  if (!"0A".equals(((Matcher)localObject8).group(3))) {
                    continue;
                  }
                  localObject8 = ((Matcher)localObject8).group(1).split(":");
                  if ((localObject8 == null) || (localObject8.length < 2)) {
                    continue;
                  }
                  ((Set)localObject4).add(localObject8[1]);
                  continue;
                  if (!"01".equals(((Matcher)localObject8).group(3))) {
                    continue;
                  }
                  ((Map)localObject6).put(((Matcher)localObject8).group(1), ((Matcher)localObject8).group(2));
                  continue;
                  localObject7 = new HashMap((Map)localObject6);
                  localObject2 = new HashSet();
                  localObject8 = ((Map)localObject6).keySet().iterator();
                  if (!((Iterator)localObject8).hasNext()) {
                    continue;
                  }
                  localObject9 = (String)((Iterator)localObject8).next();
                  str = (String)((Map)localObject6).get(localObject9);
                  if ((((Map)localObject7).get(str) == null) || (!((String)localObject9).equals((String)((Map)localObject7).get(str)))) {
                    continue;
                  }
                  localObject9 = ((String)localObject9).split(":");
                  if ((localObject9 == null) || (localObject9.length < 2)) {
                    continue;
                  }
                  localObject9 = localObject9[1];
                  if (!((Set)localObject4).contains(localObject9)) {
                    continue;
                  }
                  ((Set)localObject2).add(localObject9);
                  continue;
                  localObject8 = a((List)localObject5);
                  localObject6 = new ArrayList();
                  if (((Set)localObject4).size() + ((Set)localObject2).size() + ((Set)localObject8).size() != 0) {
                    break;
                  }
                }
                localObject6 = new HashMap();
                localObject4 = new HashSet();
                localObject7 = Pattern.compile(db.a(db.as));
                j = localObject1.length;
                i = 0;
                if (i < j)
                {
                  localObject8 = ((Pattern)localObject7).matcher(localObject1[i]);
                  if (!((Matcher)localObject8).find())
                  {
                    i += 1;
                    continue;
                    localObject4 = ((String)localObject1).split("\n");
                    if (localObject4 != null)
                    {
                      localObject1 = localObject4;
                      if (localObject4.length != 0) {
                        continue;
                      }
                    }
                    localObject1 = b;
                    continue;
                  }
                }
                localArrayList.addAll((Collection)localObject6);
                localObject2 = new ArrayList();
                localObject5 = a((List)localObject5);
                if (((Set)localObject5).size() != 0) {
                  break label1555;
                }
              }
              for (;;)
              {
                localArrayList.addAll((Collection)localObject2);
                return localArrayList;
                localObject7 = new StringBuilder();
                ((StringBuilder)localObject7).append(a((Set)localObject4));
                ((StringBuilder)localObject7).append("&");
                ((StringBuilder)localObject7).append(a((Set)localObject2));
                ((StringBuilder)localObject7).append("&");
                ((StringBuilder)localObject7).append(a((Set)localObject8));
                localObject2 = new Fig();
                ((Fig)localObject2).vc = (dk.c + dk.l);
                ((Fig)localObject2).wc = ((StringBuilder)localObject7).toString();
                ((List)localObject6).add(localObject2);
                break;
                localObject4 = new StringBuilder();
                localObject5 = ((Set)localObject5).iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  ((StringBuilder)localObject4).append((String)((Iterator)localObject5).next());
                  ((StringBuilder)localObject4).append("_");
                }
                localObject4 = ((StringBuilder)localObject4).toString();
                localObject5 = new Fig();
                ((Fig)localObject5).vc = (dk.c + dk.m);
                ((Fig)localObject5).wc = ((String)localObject4).substring(0, ((String)localObject4).length() - 1);
                ((List)localObject2).add(localObject5);
              }
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.h
 * JD-Core Version:    0.7.0.1
 */