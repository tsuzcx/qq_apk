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

public class x
{
  public static final dj a = new r();
  
  public final Damson a(String paramString)
  {
    Object localObject1 = ed.c(ed.b(ed.b(paramString), ed.c()));
    paramString = new Damson();
    localObject1 = new dp((byte[])localObject1);
    paramString.Mb = ((dp)localObject1).a(paramString.Mb, 0, true);
    paramString.Nb = ((dp)localObject1).a(1, true);
    Object localObject2;
    if (Damson.Db == null)
    {
      Damson.Db = new ArrayList();
      localObject2 = new Gooseberry();
      Damson.Db.add(localObject2);
    }
    paramString.Ob = ((ArrayList)((dp)localObject1).a(Damson.Db, 2, true));
    paramString.Pb = ((dp)localObject1).a(paramString.Pb, 3, true);
    paramString.aa = ((dp)localObject1).a(4, true);
    paramString.Qb = ((dp)localObject1).a(paramString.Qb, 5, true);
    paramString.Rb = ((dp)localObject1).a(paramString.Rb, 6, true);
    paramString.Sb = ((dp)localObject1).a(7, true);
    paramString.K = ((dp)localObject1).a(8, false);
    paramString.Q = ((dp)localObject1).a(9, false);
    paramString.Tb = ((dp)localObject1).a(10, false);
    paramString.Ub = ((dp)localObject1).a(11, false);
    paramString.Vb = ((dp)localObject1).a(12, false);
    paramString.Wb = ((dp)localObject1).a(paramString.Wb, 13, false);
    paramString.Xb = ((dp)localObject1).a(paramString.Xb, 14, false);
    paramString.Yb = ((dp)localObject1).a(15, false);
    paramString.ca = ((dp)localObject1).a(paramString.ca, 16, false);
    paramString.Zb = ((dp)localObject1).a(17, false);
    paramString._b = ((dp)localObject1).a(18, false);
    paramString.ac = ((dp)localObject1).a(paramString.ac, 19, false);
    if (Damson.Eb == null) {
      Damson.Eb = new Durian();
    }
    paramString.bc = ((Durian)((dp)localObject1).a(Damson.Eb, 20, false));
    if (Damson.Fb == null) {
      Damson.Fb = new Filbert();
    }
    paramString.cc = ((Filbert)((dp)localObject1).a(Damson.Fb, 21, false));
    if (Damson.Gb == null) {
      Damson.Gb = new Cumquat();
    }
    paramString.dc = ((Cumquat)((dp)localObject1).a(Damson.Gb, 22, false));
    paramString.ec = ((dp)localObject1).a(paramString.ec, 23, false);
    if (Damson.Hb == null)
    {
      Damson.Hb = new ArrayList();
      localObject2 = new Fig();
      Damson.Hb.add(localObject2);
    }
    paramString.fc = ((ArrayList)((dp)localObject1).a(Damson.Hb, 24, false));
    if (Damson.Ib == null)
    {
      Damson.Ib = new ArrayList();
      localObject2 = new Date();
      Damson.Ib.add(localObject2);
    }
    paramString.gc = ((ArrayList)((dp)localObject1).a(Damson.Ib, 25, false));
    if (Damson.Jb == null) {
      Damson.Jb = new Kiwifruit();
    }
    paramString.hc = ((Kiwifruit)((dp)localObject1).a(Damson.Jb, 26, false));
    if (Damson.Kb == null) {
      Damson.Kb = new Herbaceous();
    }
    paramString.ic = ((Herbaceous)((dp)localObject1).a(Damson.Kb, 27, false));
    if (Damson.Lb == null)
    {
      Damson.Lb = new byte[1];
      Damson.Lb[0] = 0;
    }
    paramString.jc = ((dp)localObject1).a(Damson.Lb, 28, false);
    return paramString;
  }
  
  public eb a(Context paramContext, int paramInt)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {}
    label640:
    label645:
    for (;;)
    {
      int k;
      int i;
      if (localLinkedHashMap.size() == 0)
      {
        return null;
        paramContext = new File(paramContext.getAbsolutePath() + File.separator + "10");
        if (paramContext.exists())
        {
          paramContext = paramContext.listFiles();
          if (paramContext != null)
          {
            Arrays.sort(paramContext, new u(this));
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
            break label645;
          }
          Object localObject1 = paramContext[i];
          int j;
          label623:
          do
          {
            try
            {
              Object localObject2 = ((File)localObject1).getName();
              localObject2 = ((String)localObject2).split("_");
              if (localObject2 == null)
              {
                break label623;
                localObject2 = a(((File)localObject1).getAbsolutePath());
                localLinkedHashMap.put(((File)localObject1).getAbsolutePath(), localObject2);
                break label640;
              }
              if (localObject2.length != 2) {
                break label623;
              }
              j = Integer.valueOf(localObject2[0]).intValue() / 1000;
            }
            catch (Throwable localThrowable)
            {
              ((File)localObject1).deleteOnExit();
              break label640;
            }
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = localLinkedHashMap.keySet().iterator();
            paramContext = null;
            while (localIterator.hasNext())
            {
              Object localObject3 = (String)localIterator.next();
              localObject1 = (Damson)localLinkedHashMap.get(localObject3);
              if ((localObject1 != null) && (((Damson)localObject1).Rb == 0))
              {
                localArrayList.add(localObject3);
                if (paramContext == null)
                {
                  paramContext = (Context)localObject1;
                }
                else
                {
                  localObject3 = paramContext.Ob;
                  Object localObject4;
                  if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
                  {
                    i = 0;
                    if (i < 120)
                    {
                      paramContext.Ob.addAll(((Damson)localObject1).Ob);
                      localObject3 = paramContext.dc;
                      localObject4 = ((Damson)localObject1).dc;
                      localObject1 = localObject3;
                      if (localObject3 == null) {
                        localObject1 = new Cumquat();
                      }
                      if (((Cumquat)localObject1).Cb == null) {
                        ((Cumquat)localObject1).Cb = new ArrayList();
                      }
                      localObject3 = localObject4;
                      if (localObject4 == null) {
                        localObject3 = new Cumquat();
                      }
                      if (((Cumquat)localObject3).Cb == null) {
                        ((Cumquat)localObject3).Cb = new ArrayList();
                      }
                      ((Cumquat)localObject1).Cb.addAll(((Cumquat)localObject3).Cb);
                      paramContext.dc = ((Cumquat)localObject1);
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
                      localObject4 = ((Gooseberry)((Iterator)localObject3).next()).Pc;
                    } while (localObject4 == null);
                    localObject4 = ((ArrayList)localObject4).iterator();
                    i = paramInt;
                    for (;;)
                    {
                      paramInt = i;
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      Map localMap = ((Grapefruit)((Iterator)localObject4).next()).Wc;
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
              Collections.sort(paramContext.Ob, new v(this));
              localObject1 = new y(null);
              ((y)localObject1).a = paramContext;
              ((y)localObject1).b = localArrayList;
            }
            for (paramContext = (Context)localObject1; paramContext != null; paramContext = null) {
              return new eb(paramContext.a, paramContext.b);
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
  
  public void a(Context paramContext, int paramInt1, int paramInt2, Damson paramDamson)
  {
    Object localObject1 = ed.a(ed.b(paramDamson.c()), ed.c());
    if (localObject1 == null) {}
    label36:
    label41:
    label77:
    label482:
    for (;;)
    {
      return;
      paramDamson = paramContext.getDir("turingfd", 0);
      if (paramDamson == null)
      {
        paramDamson = "";
        if (TextUtils.isEmpty(paramDamson)) {
          break label203;
        }
        ed.a(paramDamson, (byte[])localObject1);
        paramDamson = a(paramInt1, paramInt2);
        paramContext = paramContext.getDir("turingfd", 0);
        if (paramContext != null) {
          break label205;
        }
      }
      Object localObject2;
      for (paramContext = "";; paramContext = paramContext.getAbsolutePath() + File.separator + paramDamson + "_" + ((List)localObject2).get(0))
      {
        if (TextUtils.isEmpty(paramContext)) {
          break label482;
        }
        new File(paramContext).delete();
        return;
        paramDamson = new File(paramDamson.getAbsolutePath() + File.separator + "10");
        if ((!paramDamson.exists()) && (!paramDamson.mkdirs())) {
          break label36;
        }
        paramDamson = paramDamson.getAbsolutePath() + File.separator + a(paramInt1, paramInt2) + "_" + System.currentTimeMillis();
        break label41;
        break;
        paramContext = new File(paramContext.getAbsolutePath() + File.separator + "10");
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
          if (!((File)localObject3).getName().startsWith(paramDamson)) {}
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
          if ((localObject3.length == 2) && (localObject3[0].equals(paramDamson))) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.x
 * JD-Core Version:    0.7.0.1
 */