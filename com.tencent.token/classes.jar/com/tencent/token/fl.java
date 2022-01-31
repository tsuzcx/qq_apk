package com.tencent.token;

import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.g;
import com.tencent.token.global.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fl
{
  List a = Collections.synchronizedList(new ArrayList());
  NewConfigureCacheItem b;
  String c;
  long d;
  public boolean e;
  public boolean f = false;
  
  private void a(List paramList)
  {
    Object localObject;
    g localg;
    try
    {
      if (this.b == null) {
        this.b = ba.a().h.a("account_prot");
      }
      if (this.b.mClientVersion <= this.b.mClickVersion) {
        break label259;
      }
      if (this.b.mClickVersion == -1)
      {
        if (this.b.mConfIDs == null) {
          break label259;
        }
        localObject = this.b.mConfIDs.iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Iterator)localObject).next()).intValue();
          localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            localg = (g)localIterator.next();
            if (i == localg.a) {
              localg.f = true;
            }
          }
        }
      }
      localObject = new HashSet();
    }
    finally {}
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject).add(Integer.valueOf(((g)localIterator.next()).a));
    }
    localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localg = (g)localIterator.next();
      if (!((Set)localObject).contains(Integer.valueOf(localg.a))) {
        localg.f = true;
      }
    }
    label259:
    this.a.clear();
    this.a = paramList;
    ax.a();
    this.c = ax.c;
    if (ax.a().e() != null) {
      this.d = ax.a().e().mUin;
    }
  }
  
  public final int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      int j = i + 1;
      i = j;
      if (localg.a == paramInt) {
        return j;
      }
    }
    return -1;
  }
  
  public final List a()
  {
    try
    {
      List localList = this.a;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    boolean bool;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if (paramJSONArray != null)
    {
      bool = true;
      e.a(bool);
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if (paramJSONArray == null) {}
    }
    for (;;)
    {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          i = 0;
          if (i >= paramJSONArray.length()) {
            break label234;
          }
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label229;
          }
          bool = true;
          e.a(bool);
          g localg = new g();
          if (!localg.a(localJSONObject)) {
            e.c("object item parse failed: " + i);
          }
          localArrayList1.add(localg);
          i += 1;
          continue;
          if (i >= localArrayList1.size()) {
            break label246;
          }
          paramJSONArray = (g)localArrayList1.get(i);
          if (paramJSONArray.g) {
            break label239;
          }
          localArrayList2.add(paramJSONArray);
          break label239;
          if (i < localArrayList1.size())
          {
            paramJSONArray = (g)localArrayList1.get(i);
            if (paramJSONArray.g) {
              localArrayList2.add(paramJSONArray);
            }
            i += 1;
            continue;
          }
        }
        a(localArrayList2);
        return true;
      }
      catch (JSONException paramJSONArray)
      {
        return false;
      }
      bool = false;
      break;
      label229:
      bool = false;
      continue;
      label234:
      int i = 0;
      continue;
      label239:
      i += 1;
      continue;
      label246:
      i = 0;
    }
  }
  
  public final boolean b()
  {
    Object localObject = ax.a().e();
    if ((this.c == null) || (localObject == null)) {}
    do
    {
      return false;
      localObject = this.c;
      ax.a();
    } while ((!((String)localObject).equals(ax.c)) || (this.d != ax.a().e().mUin) || (!this.e));
    return true;
  }
  
  public final int c()
  {
    int i = 0;
    int k = 0;
    try
    {
      List localList = a();
      if (localList == null) {}
      int j;
      do
      {
        return k;
        j = 0;
        k = i;
      } while (j >= localList.size());
      boolean bool = ((g)localList.get(j)).g;
      if (!bool) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
      }
    }
    finally {}
  }
  
  public final void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fl
 * JD-Core Version:    0.7.0.1
 */