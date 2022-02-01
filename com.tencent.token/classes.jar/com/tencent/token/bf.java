package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.halley.common.b;
import com.tencent.halley.common.f;
import com.tencent.halley.scheduler.c.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bf
{
  public static final int[] a = { 80, 8080, 14000 };
  public long b;
  private Map c;
  
  public bf() {}
  
  public bf(g paramg)
  {
    this.b = paramg.b;
    this.c = new HashMap();
    Iterator localIterator = paramg.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (bp.a(localInteger))
      {
        Object localObject = (ArrayList)paramg.a.get(localInteger);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ay localay = new ay();
          if (localay.a(str)) {
            localArrayList.add(localay);
          }
        }
        this.c.put(localInteger, localArrayList);
      }
    }
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      return "access_cm";
    }
    if (paramInt == 2) {
      return "access_uni";
    }
    if (paramInt == 3) {
      str = "access_ct";
    }
    return str;
  }
  
  public final void a()
  {
    SharedPreferences localSharedPreferences = f.a().getSharedPreferences("Access_Preferences", 0);
    this.b = localSharedPreferences.getLong("timeStamp", 0L);
    this.c = new HashMap();
    int i = 1;
    while (i <= 3)
    {
      Object localObject2 = localSharedPreferences.getString(a(i), "");
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = "";
        if (i == 1) {
          localObject1 = "183.61.38.168:14000,117.135.171.182:14000";
        }
        for (;;)
        {
          break;
          if (i == 2)
          {
            localObject1 = "112.90.140.213:14000,112.90.140.216:14000";
          }
          else
          {
            if (i != 3) {
              break;
            }
            localObject1 = "14.17.41.159:14000,140.206.160.242:14000";
          }
        }
        localObject2 = new StringBuilder("getDefaultIpListByOpType:");
        ((StringBuilder)localObject2).append((String)localObject1);
        b.b("SdkAccessInfo", ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((String)localObject1).split(",");
      if (localObject1.length > 0)
      {
        localObject2 = new ArrayList();
        int k = localObject1.length;
        int j = 0;
        while (j < k)
        {
          String str = localObject1[j];
          ay localay = new ay();
          if (localay.a(str)) {
            ((ArrayList)localObject2).add(localay);
          }
          j += 1;
        }
        this.c.put(Integer.valueOf(i), localObject2);
      }
      i += 1;
    }
  }
  
  public final void b()
  {
    SharedPreferences localSharedPreferences = f.a().getSharedPreferences("Access_Preferences", 0);
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject1 = this.c.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Integer)((Iterator)localObject1).next();
        if (bp.a((Integer)localObject2))
        {
          String str = a(((Integer)localObject2).intValue());
          Object localObject3 = (ArrayList)this.c.get(localObject2);
          if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
          {
            localObject3 = new StringBuilder();
            localObject2 = ((ArrayList)this.c.get(localObject2)).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              ((StringBuilder)localObject3).append(((ay)((Iterator)localObject2).next()).c());
              ((StringBuilder)localObject3).append(",");
            }
            ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
            localSharedPreferences.edit().putString(str, ((StringBuilder)localObject3).toString()).commit();
          }
        }
      }
      localSharedPreferences.edit().putLong("timesStamp", this.b).commit();
    }
  }
  
  public final ArrayList c()
  {
    int i = bp.e();
    ArrayList localArrayList1 = new ArrayList();
    boolean bool = bp.a(Integer.valueOf(i));
    int k = 0;
    Object localObject;
    if (bool)
    {
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        ArrayList localArrayList2 = (ArrayList)this.c.get(localObject);
        if (i == ((Integer)localObject).intValue()) {
          localArrayList1.addAll(0, localArrayList2);
        } else {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
    Iterator localIterator = this.c.keySet().iterator();
    int j;
    for (i = 0;; i = Math.max(i, ((ArrayList)this.c.get(localObject)).size()))
    {
      j = k;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (Integer)localIterator.next();
    }
    while (j < i)
    {
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        localObject = (ArrayList)this.c.get(localObject);
        if (j < ((ArrayList)localObject).size()) {
          localArrayList1.add(((ArrayList)localObject).get(j));
        }
      }
      j += 1;
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bf
 * JD-Core Version:    0.7.0.1
 */