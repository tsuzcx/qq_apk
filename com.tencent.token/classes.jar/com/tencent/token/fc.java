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

public final class fc
{
  List a = Collections.synchronizedList(new ArrayList());
  List b = Collections.synchronizedList(new ArrayList());
  NewConfigureCacheItem c;
  String d;
  long e;
  public boolean f;
  public boolean g = false;
  
  private void a(List paramList, boolean paramBoolean)
  {
    Object localObject;
    g localg;
    try
    {
      if (this.c == null) {
        this.c = ba.a().h.a("account_lock");
      }
      if (this.c.mClientVersion <= this.c.mClickVersion) {
        break label317;
      }
      if (this.c.mClickVersion == -1)
      {
        if (this.c.mConfIDs == null) {
          break label317;
        }
        localObject = this.c.mConfIDs.iterator();
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
    if (paramBoolean)
    {
      localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((Set)localObject).add(Integer.valueOf(((g)localIterator.next()).a));
      }
    }
    Iterator localIterator = this.b.iterator();
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
    label317:
    if (paramBoolean)
    {
      this.a.clear();
      this.a.addAll(paramList);
    }
    for (;;)
    {
      ax.a();
      this.d = ax.c;
      if (ax.a().e() != null) {
        this.e = ax.a().e().mUin;
      }
      return;
      this.b.clear();
      this.b.addAll(paramList);
    }
  }
  
  private boolean a(JSONArray paramJSONArray, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null) {}
    try
    {
      if (paramJSONArray.length() > 0)
      {
        int i = 0;
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool);
            g localg = new g();
            if (!localg.b(localJSONObject)) {
              e.c("object item parse failed: " + i);
            }
            localArrayList.add(localg);
            i += 1;
            break;
          }
        }
      }
      a(localArrayList, paramBoolean);
      return true;
    }
    catch (JSONException paramJSONArray) {}
    return false;
  }
  
  public final List a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.a;
    }
    return this.b;
  }
  
  public final boolean a()
  {
    QQUser localQQUser = ax.a().e();
    if ((this.d == null) || (localQQUser == null)) {}
    String str;
    do
    {
      return false;
      str = this.d;
      ax.a();
    } while ((!str.equals(ax.c)) || (this.e != localQQUser.mUin) || (!this.f));
    return true;
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    if (paramJSONArray != null) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        e.a(bool);
        try
        {
          if (!a(paramJSONArray.getJSONArray(0), true)) {
            break;
          }
          bool = a(paramJSONArray.getJSONArray(1), false);
          if (!bool) {
            break;
          }
          return true;
        }
        catch (JSONException paramJSONArray)
        {
          paramJSONArray.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public final int b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (List localList = this.a; localList == null; localList = this.b) {
      return 0;
    }
    return localList.size();
  }
  
  public final void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).f = false;
    }
    localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fc
 * JD-Core Version:    0.7.0.1
 */