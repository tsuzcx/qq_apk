package com.tencent.token;

import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.f;
import com.tencent.token.global.g;
import com.tencent.token.global.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dc
{
  List<f> a = Collections.synchronizedList(new ArrayList());
  List<f> b = Collections.synchronizedList(new ArrayList());
  NewConfigureCacheItem c;
  String d;
  long e;
  public boolean f;
  public boolean g = false;
  
  public f a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= b(paramBoolean)) {
        return null;
      }
      List localList = a(paramBoolean);
      if (localList == null) {
        return null;
      }
      return (f)localList.get(paramInt);
    }
    return null;
  }
  
  public List<f> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.a;
    }
    return this.b;
  }
  
  public void a(String paramString)
  {
    h.a("account_lock", paramString);
  }
  
  public void a(List<f> paramList, boolean paramBoolean)
  {
    try
    {
      if (this.c == null) {
        this.c = cs.a().h.a("account_lock");
      }
      if (this.c.mClientVersion > this.c.mClickVersion)
      {
        Object localObject;
        Iterator localIterator;
        f localf;
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
                localf = (f)localIterator.next();
                if (i == localf.a) {
                  localf.f = true;
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
              ((Set)localObject).add(Integer.valueOf(((f)localIterator.next()).a));
            }
          }
          localIterator = this.b.iterator();
          while (localIterator.hasNext()) {
            ((Set)localObject).add(Integer.valueOf(((f)localIterator.next()).a));
          }
          localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            localf = (f)localIterator.next();
            if (!((Set)localObject).contains(Integer.valueOf(localf.a))) {
              localf.f = true;
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
      this.d = cr.c;
      if (cr.a().e() != null) {
        this.e = cr.a().e().mUin;
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    QQUser localQQUser = cr.a().e();
    String str = this.d;
    if (str != null)
    {
      if (localQQUser == null) {
        return false;
      }
      return (str.equals(cr.c)) && (this.e == localQQUser.mUin) && (this.f);
    }
    return false;
  }
  
  public boolean a(JSONArray paramJSONArray)
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
    g.a(bool);
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
  
  public boolean a(JSONArray paramJSONArray, boolean paramBoolean)
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
            Object localObject = paramJSONArray.getJSONObject(i);
            if (localObject == null) {
              break label133;
            }
            bool = true;
            g.a(bool);
            f localf = new f();
            if (!localf.b((JSONObject)localObject))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("object item parse failed: ");
              ((StringBuilder)localObject).append(i);
              g.c(((StringBuilder)localObject).toString());
            }
            localArrayList.add(localf);
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
      label133:
      boolean bool = false;
    }
  }
  
  public int b(boolean paramBoolean)
  {
    List localList = a(paramBoolean);
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).f = false;
    }
    localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dc
 * JD-Core Version:    0.7.0.1
 */