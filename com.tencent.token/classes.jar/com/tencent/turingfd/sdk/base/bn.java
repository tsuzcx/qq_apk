package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bn
{
  public static final cx<bn> a = new a();
  
  public final Dew a(String paramString)
  {
    Object localObject1 = cm.c(cm.b(cm.b(paramString), cm.b()));
    paramString = new Dew();
    localObject1 = new cy((byte[])localObject1);
    paramString.Jb = ((cy)localObject1).a(paramString.Jb, 0, true);
    paramString.Kb = ((cy)localObject1).a(1, true);
    Object localObject2;
    if (Dew.Ab == null)
    {
      Dew.Ab = new ArrayList();
      localObject2 = new Guava();
      Dew.Ab.add(localObject2);
    }
    paramString.Lb = ((ArrayList)((cy)localObject1).a(Dew.Ab, 2, true));
    paramString.Mb = ((cy)localObject1).a(paramString.Mb, 3, true);
    paramString.S = ((cy)localObject1).a(4, true);
    paramString.Nb = ((cy)localObject1).a(paramString.Nb, 5, true);
    paramString.Ob = ((cy)localObject1).a(paramString.Ob, 6, true);
    paramString.Pb = ((cy)localObject1).a(7, true);
    paramString.H = ((cy)localObject1).a(8, false);
    paramString.I = ((cy)localObject1).a(9, false);
    paramString.Qb = ((cy)localObject1).a(10, false);
    paramString.Rb = ((cy)localObject1).a(11, false);
    paramString.Sb = ((cy)localObject1).a(12, false);
    paramString.Tb = ((cy)localObject1).a(paramString.Tb, 13, false);
    paramString.Ub = ((cy)localObject1).a(paramString.Ub, 14, false);
    paramString.Vb = ((cy)localObject1).a(15, false);
    paramString.W = ((cy)localObject1).a(paramString.W, 16, false);
    paramString.Wb = ((cy)localObject1).a(17, false);
    paramString.Xb = ((cy)localObject1).a(18, false);
    paramString.Yb = ((cy)localObject1).a(paramString.Yb, 19, false);
    if (Dew.Bb == null) {
      Dew.Bb = new Filbert();
    }
    paramString.Zb = ((Filbert)((cy)localObject1).a(Dew.Bb, 20, false));
    if (Dew.Cb == null) {
      Dew.Cb = new Foxnut();
    }
    paramString._b = ((Foxnut)((cy)localObject1).a(Dew.Cb, 21, false));
    if (Dew.Db == null) {
      Dew.Db = new Date();
    }
    paramString.ac = ((Date)((cy)localObject1).a(Dew.Db, 22, false));
    paramString.bc = ((cy)localObject1).a(paramString.bc, 23, false);
    if (Dew.Eb == null)
    {
      Dew.Eb = new ArrayList();
      localObject2 = new Flat();
      Dew.Eb.add(localObject2);
    }
    paramString.cc = ((ArrayList)((cy)localObject1).a(Dew.Eb, 24, false));
    if (Dew.Fb == null)
    {
      Dew.Fb = new ArrayList();
      localObject2 = new Durian();
      Dew.Fb.add(localObject2);
    }
    paramString.dc = ((ArrayList)((cy)localObject1).a(Dew.Fb, 25, false));
    if (Dew.Gb == null) {
      Dew.Gb = new Mandarin();
    }
    paramString.ec = ((Mandarin)((cy)localObject1).a(Dew.Gb, 26, false));
    if (Dew.Hb == null) {
      Dew.Hb = new Longan();
    }
    paramString.fc = ((Longan)((cy)localObject1).a(Dew.Hb, 27, false));
    if (Dew.Ib == null)
    {
      Dew.Ib = new byte[1];
      Dew.Ib[0] = 0;
    }
    paramString.gc = ((cy)localObject1).a(Dew.Ib, 28, false);
    return paramString;
  }
  
  public az a(Context paramContext, int paramInt)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {}
    label617:
    label634:
    label639:
    for (;;)
    {
      int k;
      int i;
      if (localLinkedHashMap.size() == 0)
      {
        return null;
        paramContext = new File(ci.a(new StringBuilder().append(paramContext.getAbsolutePath()), File.separator, "10"));
        if (paramContext.exists())
        {
          paramContext = paramContext.listFiles();
          if (paramContext != null)
          {
            Arrays.sort(paramContext, new bp(this));
            k = paramContext.length;
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i >= k) {
            break label639;
          }
          Object localObject1 = paramContext[i];
          int j;
          do
          {
            try
            {
              Object localObject2 = ((File)localObject1).getName();
              localObject2 = ((String)localObject2).split("_");
              if (localObject2 == null)
              {
                break label617;
                localObject2 = a(((File)localObject1).getAbsolutePath());
                localLinkedHashMap.put(((File)localObject1).getAbsolutePath(), localObject2);
                break label634;
              }
              if (localObject2.length != 2) {
                break label617;
              }
              j = Integer.valueOf(localObject2[0]).intValue() / 1000;
            }
            catch (Throwable localThrowable)
            {
              ((File)localObject1).deleteOnExit();
              break label634;
            }
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = localLinkedHashMap.keySet().iterator();
            paramContext = null;
            while (localIterator.hasNext())
            {
              Object localObject3 = (String)localIterator.next();
              localObject1 = (Dew)localLinkedHashMap.get(localObject3);
              if ((localObject1 != null) && (((Dew)localObject1).Ob == 0))
              {
                localArrayList.add(localObject3);
                if (paramContext == null)
                {
                  paramContext = (Context)localObject1;
                }
                else
                {
                  localObject3 = paramContext.Lb;
                  Object localObject4;
                  if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
                  {
                    i = 0;
                    if (i < 120)
                    {
                      paramContext.Lb.addAll(((Dew)localObject1).Lb);
                      localObject3 = paramContext.ac;
                      localObject4 = ((Dew)localObject1).ac;
                      localObject1 = localObject3;
                      if (localObject3 == null) {
                        localObject1 = new Date();
                      }
                      if (((Date)localObject1).zb == null) {
                        ((Date)localObject1).zb = new ArrayList();
                      }
                      localObject3 = localObject4;
                      if (localObject4 == null) {
                        localObject3 = new Date();
                      }
                      if (((Date)localObject3).zb == null) {
                        ((Date)localObject3).zb = new ArrayList();
                      }
                      ((Date)localObject1).zb.addAll(((Date)localObject3).zb);
                      paramContext.ac = ((Date)localObject1);
                    }
                  }
                  else
                  {
                    localObject3 = ((ArrayList)localObject3).iterator();
                    paramInt = 0;
                    do
                    {
                      i = paramInt;
                      if (!((Iterator)localObject3).hasNext()) {
                        break;
                      }
                      localObject4 = ((Guava)((Iterator)localObject3).next()).Nc;
                    } while (localObject4 == null);
                    localObject4 = ((ArrayList)localObject4).iterator();
                    i = paramInt;
                    for (;;)
                    {
                      paramInt = i;
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      Map localMap = ((Herbaceous)((Iterator)localObject4).next()).Uc;
                      if ((localMap != null) && (localMap.containsKey(Integer.valueOf(0)))) {
                        i += 1;
                      }
                    }
                  }
                }
              }
            }
            if (paramContext != null)
            {
              Collections.sort(paramContext.Lb, new bw(this));
              localObject1 = new b(null);
              ((b)localObject1).a = paramContext;
              ((b)localObject1).b = localArrayList;
            }
            for (paramContext = (Context)localObject1; paramContext != null; paramContext = null) {
              return new az(paramContext.a, paramContext.b);
            }
            break;
            j = -1;
          } while ((paramInt == j) || (paramInt == -1));
          i += 1;
        }
      }
    }
  }
  
  public final String a(int paramInt1, int paramInt2)
  {
    return paramInt1 + "00" + paramInt2;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, Dew paramDew)
  {
    Object localObject1 = cm.a(cm.b(paramDew.c()), cm.b());
    if (localObject1 == null) {}
    label36:
    label41:
    label77:
    label470:
    for (;;)
    {
      return;
      paramDew = paramContext.getDir("turingfd", 0);
      if (paramDew == null)
      {
        paramDew = "";
        if (TextUtils.isEmpty(paramDew)) {
          break label197;
        }
        cm.a(paramDew, (byte[])localObject1);
        paramDew = a(paramInt1, paramInt2);
        paramContext = paramContext.getDir("turingfd", 0);
        if (paramContext != null) {
          break label199;
        }
      }
      Object localObject2;
      for (paramContext = "";; paramContext = paramContext.getAbsolutePath() + File.separator + paramDew + "_" + ((List)localObject2).get(0))
      {
        if (TextUtils.isEmpty(paramContext)) {
          break label470;
        }
        new File(paramContext).delete();
        return;
        paramDew = new File(ci.a(new StringBuilder().append(paramDew.getAbsolutePath()), File.separator, "10"));
        if ((!paramDew.exists()) && (!paramDew.mkdirs())) {
          break label36;
        }
        paramDew = paramDew.getAbsolutePath() + File.separator + a(paramInt1, paramInt2) + "_" + System.currentTimeMillis();
        break label41;
        break;
        paramContext = new File(ci.a(new StringBuilder().append(paramContext.getAbsolutePath()), File.separator, "10"));
        if (!paramContext.exists()) {
          break label77;
        }
        localObject2 = paramContext.listFiles();
        if (localObject2 == null) {
          break label77;
        }
        localObject1 = new ArrayList();
        paramInt2 = localObject2.length;
        paramInt1 = 0;
        Object localObject3;
        if (paramInt1 < paramInt2)
        {
          localObject3 = localObject2[paramInt1];
          if (!((File)localObject3).getName().startsWith(paramDew)) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            ((List)localObject1).add(localObject3);
          }
        }
        if (((List)localObject1).size() <= 6) {
          break label77;
        }
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((File)((Iterator)localObject1).next()).getName().split("_");
          if ((localObject3.length == 2) && (localObject3[0].equals(paramDew))) {
            ((List)localObject2).add(Long.valueOf(Long.parseLong(localObject3[1])));
          }
        }
        if (((List)localObject2).size() <= 6) {
          break label77;
        }
        Collections.sort((List)localObject2);
      }
    }
  }
  
  public static final class a
    extends cx<bn>
  {
    public Object a()
    {
      return new bn();
    }
  }
  
  private static class b
  {
    public Dew a;
    public List<String> b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bn
 * JD-Core Version:    0.7.0.1
 */