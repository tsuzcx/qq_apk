package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.Date;
import com.tencent.turingfd.sdk.base.Dew;
import com.tencent.turingfd.sdk.base.Durian;
import com.tencent.turingfd.sdk.base.Filbert;
import com.tencent.turingfd.sdk.base.Flat;
import com.tencent.turingfd.sdk.base.Foxnut;
import com.tencent.turingfd.sdk.base.Guava;
import com.tencent.turingfd.sdk.base.Herbaceous;
import com.tencent.turingfd.sdk.base.Longan;
import com.tencent.turingfd.sdk.base.Mandarin;
import com.tencent.turingfd.sdk.base.break;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class aea
{
  public static final afk<aea> a = new a();
  
  public static adm a(Context paramContext, int paramInt)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramContext = paramContext.getDir("turingfd", 0);
    Object localObject1;
    int i;
    if (paramContext != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getAbsolutePath());
      paramContext = new File(aev.a((StringBuilder)localObject1, File.separator, "10"));
      if (paramContext.exists())
      {
        paramContext = paramContext.listFiles();
        if (paramContext != null)
        {
          Arrays.sort(paramContext, new aec());
          int k = paramContext.length;
          i = 0;
          while (i < k)
          {
            localObject1 = paramContext[i];
            try
            {
              localObject2 = ((File)localObject1).getName();
              localObject2 = ((String)localObject2).split("_");
              if ((localObject2 == null) || (localObject2.length != 2)) {
                break label1328;
              }
              j = Integer.valueOf(localObject2[0]).intValue() / 1000;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                Object localObject2;
                Object localObject3;
                Object localObject4;
                Iterator localIterator;
                continue;
                int j = -1;
                if (paramInt != j) {
                  if (paramInt != -1) {}
                }
              }
            }
            localObject3 = aez.b(aez.b(aez.b(((File)localObject1).getAbsolutePath()), aez.b()));
            localObject2 = new Dew();
            localObject3 = new afl((byte[])localObject3);
            ((Dew)localObject2).Jb = ((afl)localObject3).a(((Dew)localObject2).Jb, 0, true);
            ((Dew)localObject2).Kb = ((afl)localObject3).a(1, true);
            if (Dew.Ab == null)
            {
              Dew.Ab = new ArrayList();
              localObject4 = new Guava();
              Dew.Ab.add(localObject4);
            }
            ((Dew)localObject2).Lb = ((ArrayList)((afl)localObject3).a(Dew.Ab, 2, true));
            ((Dew)localObject2).Mb = ((afl)localObject3).a(((Dew)localObject2).Mb, 3, true);
            ((Dew)localObject2).S = ((afl)localObject3).a(4, true);
            ((Dew)localObject2).Nb = ((afl)localObject3).a(((Dew)localObject2).Nb, 5, true);
            ((Dew)localObject2).Ob = ((afl)localObject3).a(((Dew)localObject2).Ob, 6, true);
            ((Dew)localObject2).Pb = ((afl)localObject3).a(7, true);
            ((Dew)localObject2).H = ((afl)localObject3).a(8, false);
            ((Dew)localObject2).I = ((afl)localObject3).a(9, false);
            ((Dew)localObject2).Qb = ((afl)localObject3).a(10, false);
            ((Dew)localObject2).Rb = ((afl)localObject3).a(11, false);
            ((Dew)localObject2).Sb = ((afl)localObject3).a(12, false);
            ((Dew)localObject2).Tb = ((afl)localObject3).a(((Dew)localObject2).Tb, 13, false);
            ((Dew)localObject2).Ub = ((afl)localObject3).a(((Dew)localObject2).Ub, 14, false);
            ((Dew)localObject2).Vb = ((afl)localObject3).a(15, false);
            ((Dew)localObject2).W = ((afl)localObject3).a(((Dew)localObject2).W, 16, false);
            ((Dew)localObject2).Wb = ((afl)localObject3).a(17, false);
            ((Dew)localObject2).Xb = ((afl)localObject3).a(18, false);
            ((Dew)localObject2).Yb = ((afl)localObject3).a(((Dew)localObject2).Yb, 19, false);
            if (Dew.Bb == null) {
              Dew.Bb = new Filbert();
            }
            ((Dew)localObject2).Zb = ((Filbert)((afl)localObject3).a(Dew.Bb, 20, false));
            if (Dew.Cb == null) {
              Dew.Cb = new Foxnut();
            }
            ((Dew)localObject2)._b = ((Foxnut)((afl)localObject3).a(Dew.Cb, 21, false));
            if (Dew.Db == null) {
              Dew.Db = new Date();
            }
            ((Dew)localObject2).ac = ((Date)((afl)localObject3).a(Dew.Db, 22, false));
            ((Dew)localObject2).bc = ((afl)localObject3).a(((Dew)localObject2).bc, 23, false);
            if (Dew.Eb == null)
            {
              Dew.Eb = new ArrayList();
              localObject4 = new Flat();
              Dew.Eb.add(localObject4);
            }
            ((Dew)localObject2).cc = ((ArrayList)((afl)localObject3).a(Dew.Eb, 24, false));
            if (Dew.Fb == null)
            {
              Dew.Fb = new ArrayList();
              localObject4 = new Durian();
              Dew.Fb.add(localObject4);
            }
            ((Dew)localObject2).dc = ((ArrayList)((afl)localObject3).a(Dew.Fb, 25, false));
            if (Dew.Gb == null) {
              Dew.Gb = new Mandarin();
            }
            ((Dew)localObject2).ec = ((Mandarin)((afl)localObject3).a(Dew.Gb, 26, false));
            if (Dew.Hb == null) {
              Dew.Hb = new Longan();
            }
            ((Dew)localObject2).fc = ((Longan)((afl)localObject3).a(Dew.Hb, 27, false));
            if (Dew.Ib == null)
            {
              localObject4 = new byte[1];
              Dew.Ib = (byte[])localObject4;
              localObject4[0] = 0;
            }
            localObject4 = Dew.Ib;
            ((Dew)localObject2).gc = ((afl)localObject3).b(28, false);
            localLinkedHashMap.put(((File)localObject1).getAbsolutePath(), localObject2);
            break label885;
            ((File)localObject1).deleteOnExit();
            label885:
            i += 1;
          }
        }
      }
    }
    if (localLinkedHashMap.size() == 0) {
      return null;
    }
    localObject4 = new ArrayList();
    localIterator = localLinkedHashMap.keySet().iterator();
    paramContext = null;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (Dew)localLinkedHashMap.get(localObject2);
      if ((localObject1 != null) && (((Dew)localObject1).Ob == 0))
      {
        ((List)localObject4).add(localObject2);
        if (paramContext == null)
        {
          paramContext = (Context)localObject1;
        }
        else
        {
          localObject2 = paramContext.Lb;
          if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            paramInt = 0;
            do
            {
              i = paramInt;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = ((Guava)((Iterator)localObject2).next()).Nc;
            } while (localObject3 == null);
            localObject3 = ((ArrayList)localObject3).iterator();
            i = paramInt;
            for (;;)
            {
              paramInt = i;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              Map localMap = ((Herbaceous)((Iterator)localObject3).next()).Uc;
              if ((localMap != null) && (localMap.containsKey(Integer.valueOf(0)))) {
                i += 1;
              }
            }
          }
          i = 0;
          if (i < 120)
          {
            paramContext.Lb.addAll(((Dew)localObject1).Lb);
            localObject2 = paramContext.ac;
            localObject3 = ((Dew)localObject1).ac;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Date();
            }
            if (((Date)localObject1).zb == null) {
              ((Date)localObject1).zb = new ArrayList();
            }
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = new Date();
            }
            if (((Date)localObject2).zb == null) {
              ((Date)localObject2).zb = new ArrayList();
            }
            ((Date)localObject1).zb.addAll(((Date)localObject2).zb);
            paramContext.ac = ((Date)localObject1);
          }
        }
      }
    }
    if (paramContext != null)
    {
      Collections.sort(paramContext.Lb, new aej());
      localObject1 = new b();
      ((b)localObject1).a = paramContext;
      ((b)localObject1).b = ((List)localObject4);
      paramContext = (Context)localObject1;
    }
    else
    {
      paramContext = null;
    }
    if (paramContext != null) {
      return new adm(paramContext.a, paramContext.b);
    }
    return null;
  }
  
  private static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("000");
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, int paramInt, Dew paramDew)
  {
    Object localObject1 = aez.a(aez.a(paramDew.a()), aez.b());
    if (localObject1 == null) {
      return;
    }
    paramDew = paramContext.getDir("turingfd", 0);
    Object localObject2;
    if (paramDew != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramDew.getAbsolutePath());
      paramDew = new File(aev.a((StringBuilder)localObject2, File.separator, "10"));
      if ((paramDew.exists()) || (paramDew.mkdirs()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramDew.getAbsolutePath());
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(a(paramInt));
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        paramDew = ((StringBuilder)localObject2).toString();
        break label155;
      }
    }
    paramDew = "";
    label155:
    if (TextUtils.isEmpty(paramDew)) {
      return;
    }
    aez.a(paramDew, (byte[])localObject1);
    paramDew = a(paramInt);
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getAbsolutePath());
      paramContext = new File(aev.a((StringBuilder)localObject1, File.separator, "10"));
      if (paramContext.exists())
      {
        localObject1 = paramContext.listFiles();
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          int i = localObject1.length;
          paramInt = 0;
          Object localObject3;
          while (paramInt < i)
          {
            localObject3 = localObject1[paramInt];
            if (((File)localObject3).getName().startsWith(paramDew)) {
              ((List)localObject2).add(localObject3);
            }
            paramInt += 1;
          }
          if (((List)localObject2).size() > 6)
          {
            localObject1 = new ArrayList();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = ((File)((Iterator)localObject2).next()).getName().split("_");
              if ((localObject3.length == 2) && (localObject3[0].equals(paramDew))) {
                ((List)localObject1).add(Long.valueOf(Long.parseLong(localObject3[1])));
              }
            }
            if (((List)localObject1).size() > 6)
            {
              Collections.sort((List)localObject1);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramContext.getAbsolutePath());
              ((StringBuilder)localObject2).append(File.separator);
              ((StringBuilder)localObject2).append(paramDew);
              ((StringBuilder)localObject2).append("_");
              ((StringBuilder)localObject2).append(((List)localObject1).get(0));
              paramContext = ((StringBuilder)localObject2).toString();
              break label486;
            }
          }
        }
      }
    }
    paramContext = "";
    label486:
    if (!TextUtils.isEmpty(paramContext)) {
      new File(paramContext).delete();
    }
  }
  
  public static final class a
    extends afk<aea>
  {
    public final Object a()
    {
      return new aea();
    }
  }
  
  public static final class b
  {
    public Dew a;
    public List<String> b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aea
 * JD-Core Version:    0.7.0.1
 */