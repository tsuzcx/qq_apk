package com.tencent.token;

import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aak
{
  public List<sl> a = Collections.synchronizedList(new ArrayList());
  NewConfigureCacheItem b;
  public long c;
  public boolean d;
  public boolean e = false;
  
  private void a(List<sl> paramList)
  {
    try
    {
      if (this.b == null) {
        this.b = tb.a().h.a("account_prot");
      }
      if (this.b.mClientVersion > this.b.mClickVersion)
      {
        Object localObject;
        Iterator localIterator;
        sl localsl;
        if (this.b.mClickVersion == -1)
        {
          if (this.b.mConfIDs != null)
          {
            localObject = this.b.mConfIDs.iterator();
            while (((Iterator)localObject).hasNext())
            {
              int i = ((Integer)((Iterator)localObject).next()).intValue();
              localIterator = paramList.iterator();
              while (localIterator.hasNext())
              {
                localsl = (sl)localIterator.next();
                if (i == localsl.a) {
                  localsl.f = true;
                }
              }
            }
          }
        }
        else
        {
          localObject = new HashSet();
          localIterator = this.a.iterator();
          while (localIterator.hasNext()) {
            ((Set)localObject).add(Integer.valueOf(((sl)localIterator.next()).a));
          }
          localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            localsl = (sl)localIterator.next();
            if (!((Set)localObject).contains(Integer.valueOf(localsl.a))) {
              localsl.f = true;
            }
          }
        }
      }
      this.a.clear();
      this.a = paramList;
      if (ta.a().k.b() != null) {
        this.c = ta.a().k.b().mUin;
      }
      return;
    }
    finally {}
  }
  
  public final List<sl> a()
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
    if (paramJSONArray != null) {
      bool = true;
    } else {
      bool = false;
    }
    xb.a(bool);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramJSONArray != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          i = 0;
          if (i >= paramJSONArray.length()) {
            break label227;
          }
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label222;
          }
          bool = true;
          xb.a(bool);
          sl localsl = new sl();
          if (!localsl.a(localJSONObject)) {
            xb.c("object item parse failed: ".concat(String.valueOf(i)));
          }
          localArrayList1.add(localsl);
          i += 1;
          continue;
          if (i >= localArrayList1.size()) {
            break label239;
          }
          paramJSONArray = (sl)localArrayList1.get(i);
          if (paramJSONArray.g) {
            break label232;
          }
          localArrayList2.add(paramJSONArray);
          break label232;
          if (i < localArrayList1.size())
          {
            paramJSONArray = (sl)localArrayList1.get(i);
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
      label222:
      bool = false;
      continue;
      label227:
      int i = 0;
      continue;
      label232:
      i += 1;
      continue;
      label239:
      i = 0;
    }
  }
  
  public final int b()
  {
    List localList = a();
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public final int c()
  {
    try
    {
      List localList = a();
      int i = 0;
      if (localList == null) {
        return 0;
      }
      int k;
      for (int j = 0; i < localList.size(); j = k)
      {
        boolean bool = ((sl)localList.get(i)).g;
        k = j;
        if (!bool) {
          k = j + 1;
        }
        i += 1;
      }
      return j;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aak
 * JD-Core Version:    0.7.0.1
 */