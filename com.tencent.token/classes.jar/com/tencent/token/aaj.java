package com.tencent.token;

import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aaj
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
        this.b = tb.a().h.a("game_lock");
      }
      if ((this.b.mClientVersion > this.b.mClickVersion) && (this.b.mClickVersion == -1) && (this.b.mConfIDs != null))
      {
        Iterator localIterator1 = this.b.mConfIDs.iterator();
        while (localIterator1.hasNext())
        {
          int i = ((Integer)localIterator1.next()).intValue();
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            sl localsl = (sl)localIterator2.next();
            if (i == localsl.a) {
              localsl.f = true;
            }
          }
        }
      }
      this.a.clear();
      this.a.addAll(paramList);
      if (ta.a().k.b() != null) {
        this.c = ta.a().k.b().mUin;
      }
      return;
    }
    finally {}
  }
  
  public final int a()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
          if (!localsl.c(localJSONObject)) {
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
    try
    {
      List localList = this.a;
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
 * Qualified Name:     com.tencent.token.aaj
 * JD-Core Version:    0.7.0.1
 */