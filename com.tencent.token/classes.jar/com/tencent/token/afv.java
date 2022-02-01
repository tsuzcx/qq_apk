package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.turingfd.sdk.qps.Coconut;
import com.tencent.turingfd.sdk.qps.Codlin;
import com.tencent.turingfd.sdk.qps.Cranberry;
import com.tencent.turingfd.sdk.qps.Filbert;
import com.tencent.turingfd.sdk.qps.Flat;
import com.tencent.turingfd.sdk.qps.Foxnut;
import com.tencent.turingfd.sdk.qps.Grape;
import com.tencent.turingfd.sdk.qps.final;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class afv
  extends adk
{
  public afv(int paramInt, SparseArray paramSparseArray, List paramList, afe paramafe) {}
  
  public final void a()
  {
    int m = this.a;
    Object localObject5 = this.d;
    Object localObject6 = this.b;
    List localList = this.c;
    Object localObject4 = new Codlin();
    Object localObject1 = ((afe)localObject5).e;
    Object localObject10 = new ArrayList();
    int j = 0;
    Object localObject7;
    int i;
    while (j < ((SparseArray)localObject6).size())
    {
      acv localacv = (acv)((SparseArray)localObject6).valueAt(j);
      localacv.getClass();
      ArrayList localArrayList1 = new ArrayList();
      int k = 0;
      for (;;)
      {
        localObject7 = localacv.b;
        if (k >= localObject7.length) {
          break;
        }
        Object localObject11 = (List)localObject7[k];
        if (localObject11 != null) {
          if (((List)localObject11).size() != 0)
          {
            Foxnut localFoxnut = new Foxnut();
            ArrayList localArrayList2 = new ArrayList();
            localObject7 = (List)localacv.b[k];
            Object localObject8;
            Object localObject9;
            if (localObject7 != null)
            {
              i = 0;
              while (i < ((List)localObject7).size())
              {
                localObject8 = (acw)((List)localObject7).get(i);
                localObject9 = new Flat();
                float[] arrayOfFloat = ((acw)localObject8).c;
                ((Flat)localObject9).b = arrayOfFloat[0];
                ((Flat)localObject9).c = arrayOfFloat[1];
                ((Flat)localObject9).d = arrayOfFloat[2];
                ((Flat)localObject9).a = ((acw)localObject8).b;
                localArrayList2.add(localObject9);
                i += 1;
              }
              localObject7 = localObject5;
              localObject8 = localObject4;
              localObject9 = localObject1;
            }
            else
            {
              localObject9 = localObject1;
              localObject8 = localObject4;
              localObject7 = localObject5;
            }
            localObject1 = new HashMap();
            int n = localacv.a;
            i = 4;
            if (n == 1) {
              i = 0;
            } else if (n == 4) {
              i = 2;
            } else if (n != 9) {
              if (n == 2) {
                i = 5;
              } else {
                i = -1;
              }
            }
            ((HashMap)localObject1).put(Integer.valueOf(i), localArrayList2);
            localFoxnut.c = ((Map)localObject1);
            localObject11 = (acw)((List)localObject11).get(0);
            localObject5 = localObject7;
            localObject4 = localObject8;
            localObject1 = localObject9;
            if (localObject11 != null)
            {
              localFoxnut.b = ((acw)localObject11).b;
              if (localList.size() > k)
              {
                localObject1 = (adb)localList.get(k);
                if (localObject1 != null)
                {
                  localFoxnut.f = ((adb)localObject1).a;
                  localFoxnut.g = ((adb)localObject1).b;
                }
              }
              localArrayList1.add(localFoxnut);
              localObject5 = localObject7;
              localObject4 = localObject8;
              localObject1 = localObject9;
            }
          }
          else {}
        }
        k += 1;
      }
      if (((ArrayList)localObject10).size() != 0)
      {
        i = 0;
        while (i < localArrayList1.size())
        {
          ((Foxnut)localArrayList1.get(i)).c.putAll(((Foxnut)((ArrayList)localObject10).get(i)).c);
          i += 1;
        }
      }
      j += 1;
      localObject10 = localArrayList1;
    }
    if ((((ArrayList)localObject10).size() > 0) && (((ArrayList)localObject10).get(0) != null))
    {
      localObject6 = new Filbert();
      ((Filbert)localObject6).c = ((Foxnut)((ArrayList)localObject10).get(0)).b;
      ((Filbert)localObject6).d = ((ArrayList)localObject10);
      ((Filbert)localObject6).e = m;
      ((Filbert)localObject6).f = 1;
      localObject7 = new ArrayList();
      ((ArrayList)localObject7).add(localObject1);
      ((Filbert)localObject6).i = ((ArrayList)localObject7);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(localObject6);
      ((Codlin)localObject4).l = ((ArrayList)localObject1);
      long l = ((afe)localObject5).e.b;
      i = ((afe)localObject5).d;
      localObject5 = new Cranberry();
      ((Cranberry)localObject5).b = l;
      ((Cranberry)localObject5).c = m;
      ((Cranberry)localObject5).a = i;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(localObject5);
      localObject5 = new Coconut();
      ((Coconut)localObject5).c = ((ArrayList)localObject1);
      ((Codlin)localObject4).F = ((Coconut)localObject5);
      ((Codlin)localObject4).H = new ArrayList();
      localObject1 = (afy)afy.a.b();
      localObject5 = this.d.c;
      i = this.a;
      localObject1.getClass();
      localObject4 = agn.a(agn.a(((final)localObject4).a()), agn.b());
      label1365:
      if (localObject4 != null)
      {
        localObject1 = ((Context)localObject5).getDir("turingfd", 0);
        if (localObject1 != null)
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(((File)localObject1).getAbsolutePath());
          localObject1 = File.separator;
          ((StringBuilder)localObject6).append((String)localObject1);
          ((StringBuilder)localObject6).append("10");
          localObject7 = new File(((StringBuilder)localObject6).toString());
          if ((((File)localObject7).exists()) || (((File)localObject7).mkdirs()))
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(((File)localObject7).getAbsolutePath());
            ((StringBuilder)localObject6).append((String)localObject1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("000");
            ((StringBuilder)localObject6).append(((StringBuilder)localObject1).toString());
            ((StringBuilder)localObject6).append("_");
            ((StringBuilder)localObject6).append(System.currentTimeMillis());
            localObject1 = ((StringBuilder)localObject6).toString();
            break label995;
          }
        }
        localObject1 = "";
        label995:
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          adg.a((String)localObject1, (byte[])localObject4);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("000");
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject4 = ((Context)localObject5).getDir("turingfd", 0);
          if (localObject4 != null)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(((File)localObject4).getAbsolutePath());
            ((StringBuilder)localObject5).append(File.separator);
            ((StringBuilder)localObject5).append("10");
            localObject4 = new File(((StringBuilder)localObject5).toString());
            if (((File)localObject4).exists())
            {
              localObject5 = ((File)localObject4).listFiles();
              if (localObject5 != null)
              {
                localObject6 = new ArrayList();
                j = localObject5.length;
                i = 0;
                while (i < j)
                {
                  localObject7 = localObject5[i];
                  if (((File)localObject7).getName().startsWith((String)localObject1)) {
                    ((ArrayList)localObject6).add(localObject7);
                  }
                  i += 1;
                }
                if (((ArrayList)localObject6).size() > 6)
                {
                  localObject5 = new ArrayList();
                  localObject6 = ((ArrayList)localObject6).iterator();
                  while (((Iterator)localObject6).hasNext())
                  {
                    localObject7 = ((File)((Iterator)localObject6).next()).getName().split("_");
                    if ((localObject7.length == 2) && (localObject7[0].equals(localObject1))) {
                      ((ArrayList)localObject5).add(Long.valueOf(Long.parseLong(localObject7[1])));
                    }
                  }
                  if (((ArrayList)localObject5).size() > 6)
                  {
                    Collections.sort((List)localObject5);
                    localObject6 = new StringBuilder();
                    ((StringBuilder)localObject6).append(((File)localObject4).getAbsolutePath());
                    ((StringBuilder)localObject6).append(File.separator);
                    ((StringBuilder)localObject6).append((String)localObject1);
                    ((StringBuilder)localObject6).append("_");
                    ((StringBuilder)localObject6).append(((ArrayList)localObject5).get(0));
                    localObject1 = ((StringBuilder)localObject6).toString();
                    break label1365;
                  }
                }
              }
            }
          }
          localObject1 = "";
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            new File((String)localObject1).delete();
          }
        }
      }
      localObject1 = this.d.f;
      if (localObject1 != null)
      {
        i = this.a;
        localObject1 = (aeh)localObject1;
        localObject6 = ((aeh)localObject1).a;
        localObject7 = ((aeh)localObject1).b;
        localObject4 = (afk)afk.a.b();
        try
        {
          localObject5 = agn.a;
          localObject1 = adz.e;
          if (TextUtils.isEmpty(((agr)localObject1).e)) {
            localObject1 = "";
          } else {
            localObject1 = ((agr)localObject1).e;
          }
          localObject6 = new aej((aeq)localObject6, i, (ads)localObject7);
          try
          {
            localObject7 = ((Context)localObject5).getApplicationContext();
            ((afk)localObject4).e = ((Context)localObject7);
            if (localObject7 == null) {
              return;
            }
            ((afk)localObject4).f.post(new afu((afk)localObject4, i, (aet)localObject6, (Context)localObject5, (String)localObject1));
            return;
          }
          finally {}
          return;
        }
        finally {}
      }
    }
    throw new IllegalArgumentException("invalid stateUnits");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afv
 * JD-Core Version:    0.7.0.1
 */