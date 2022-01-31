package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.halley.common.c;
import com.tencent.halley.common.h;
import com.tencent.halley.scheduler.c.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bo
{
  public static final int[] a = { 80, 8080, 14000 };
  public long b;
  private Map c;
  
  public bo() {}
  
  public bo(g paramg)
  {
    this.b = paramg.b;
    this.c = new HashMap();
    Iterator localIterator = paramg.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (cb.a(localInteger))
      {
        Object localObject = (ArrayList)paramg.a.get(localInteger);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          bg localbg = new bg();
          if (localbg.a(str)) {
            localArrayList.add(localbg);
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
      str = "access_cm";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "access_uni";
      }
    } while (paramInt != 3);
    return "access_ct";
  }
  
  public final void a()
  {
    SharedPreferences localSharedPreferences = h.a().getSharedPreferences("Access_Preferences", 0);
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
        if (i != 1) {
          break label180;
        }
        localObject1 = "183.61.38.168:14000,117.135.171.182:14000";
      }
      for (;;)
      {
        c.b("SdkAccessInfo", "getDefaultIpListByOpType:" + (String)localObject1);
        localObject1 = ((String)localObject1).split(",");
        if (localObject1.length <= 0) {
          break label220;
        }
        localObject2 = new ArrayList();
        int k = localObject1.length;
        int j = 0;
        while (j < k)
        {
          String str = localObject1[j];
          bg localbg = new bg();
          if (localbg.a(str)) {
            ((ArrayList)localObject2).add(localbg);
          }
          j += 1;
        }
        label180:
        if (i == 2) {
          localObject1 = "112.90.140.213:14000,112.90.140.216:14000";
        } else if (i == 3) {
          localObject1 = "14.17.41.159:14000,140.206.160.242:14000";
        }
      }
      this.c.put(Integer.valueOf(i), localObject2);
      label220:
      i += 1;
    }
  }
  
  public final void b()
  {
    SharedPreferences localSharedPreferences = h.a().getSharedPreferences("Access_Preferences", 0);
    if ((this.c != null) && (this.c.size() > 0))
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (Integer)localIterator.next();
        if (cb.a((Integer)localObject1))
        {
          String str = a(((Integer)localObject1).intValue());
          Object localObject2 = (ArrayList)this.c.get(localObject1);
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            localObject2 = new StringBuilder();
            localObject1 = ((ArrayList)this.c.get(localObject1)).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ((StringBuilder)localObject2).append(((bg)((Iterator)localObject1).next()).c());
              ((StringBuilder)localObject2).append(",");
            }
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
            localSharedPreferences.edit().putString(str, ((StringBuilder)localObject2).toString()).commit();
          }
        }
      }
      localSharedPreferences.edit().putLong("timesStamp", this.b).commit();
    }
  }
  
  public final ArrayList c()
  {
    int k = 0;
    int i = cb.e();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject;
    if (cb.a(Integer.valueOf(i)))
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
    for (;;)
    {
      j += 1;
      if (j >= i) {
        break;
      }
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        localObject = (ArrayList)this.c.get(localObject);
        if (j < ((ArrayList)localObject).size()) {
          localArrayList1.add(((ArrayList)localObject).get(j));
        }
      }
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bo
 * JD-Core Version:    0.7.0.1
 */