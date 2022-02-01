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

public final class aaf
{
  public List<sl> a = Collections.synchronizedList(new ArrayList());
  public List<sl> b = Collections.synchronizedList(new ArrayList());
  NewConfigureCacheItem c;
  public long d;
  public boolean e;
  public boolean f = false;
  
  private void a(List<sl> paramList, boolean paramBoolean)
  {
    try
    {
      if (this.c == null) {
        this.c = tb.a().h.a("account_lock");
      }
      if (this.c.mClientVersion > this.c.mClickVersion)
      {
        Object localObject;
        Iterator localIterator;
        sl localsl;
        if (this.c.mClickVersion == -1)
        {
          if (this.c.mConfIDs != null)
          {
            localObject = this.c.mConfIDs.iterator();
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
          if (paramBoolean)
          {
            localIterator = this.a.iterator();
            while (localIterator.hasNext()) {
              ((Set)localObject).add(Integer.valueOf(((sl)localIterator.next()).a));
            }
          }
          localIterator = this.b.iterator();
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
      if (paramBoolean)
      {
        this.a.clear();
        this.a.addAll(paramList);
      }
      else
      {
        this.b.clear();
        this.b.addAll(paramList);
      }
      if (ta.a().k.b() != null) {
        this.d = ta.a().k.b().mUin;
      }
      return;
    }
    finally {}
  }
  
  private boolean a(JSONArray paramJSONArray, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          int i = 0;
          if (i < paramJSONArray.length())
          {
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            if (localJSONObject == null) {
              break label113;
            }
            bool = true;
            xb.a(bool);
            sl localsl = new sl();
            if (!localsl.b(localJSONObject)) {
              xb.c("object item parse failed: ".concat(String.valueOf(i)));
            }
            localArrayList.add(localsl);
            i += 1;
            continue;
          }
        }
        a(localArrayList, paramBoolean);
        return true;
      }
      catch (JSONException paramJSONArray)
      {
        return false;
      }
      label113:
      boolean bool = false;
    }
  }
  
  public final List<sl> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.a;
    }
    return this.b;
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    boolean bool;
    if (paramJSONArray != null) {
      bool = true;
    } else {
      bool = false;
    }
    xb.a(bool);
    try
    {
      if (!a(paramJSONArray.getJSONArray(0), true)) {
        return false;
      }
      bool = a(paramJSONArray.getJSONArray(1), false);
      return bool;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
    return false;
  }
  
  public final int b(boolean paramBoolean)
  {
    List localList = a(paramBoolean);
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aaf
 * JD-Core Version:    0.7.0.1
 */