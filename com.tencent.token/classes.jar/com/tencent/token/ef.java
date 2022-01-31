package com.tencent.token;

import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ef
{
  List a = Collections.synchronizedList(new ArrayList());
  List b = Collections.synchronizedList(new ArrayList());
  NewConfigureCacheItem c;
  String d;
  long e;
  public boolean f;
  public boolean g = false;
  
  public com.tencent.token.core.bean.h a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= b(paramBoolean))) {}
    List localList;
    do
    {
      return null;
      localList = a(paramBoolean);
    } while (localList == null);
    return (com.tencent.token.core.bean.h)localList.get(paramInt);
  }
  
  public List a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.a;
    }
    return this.b;
  }
  
  public void a(String paramString)
  {
    j.a("account_lock", paramString);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    Object localObject;
    com.tencent.token.core.bean.h localh;
    try
    {
      if (this.c == null) {
        this.c = dr.a().h.a("account_lock");
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
            localh = (com.tencent.token.core.bean.h)localIterator.next();
            if (i == localh.a) {
              localh.f = true;
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
        ((Set)localObject).add(Integer.valueOf(((com.tencent.token.core.bean.h)localIterator.next()).a));
      }
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject).add(Integer.valueOf(((com.tencent.token.core.bean.h)localIterator.next()).a));
    }
    localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localh = (com.tencent.token.core.bean.h)localIterator.next();
      if (!((Set)localObject).contains(Integer.valueOf(localh.a))) {
        localh.f = true;
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
      this.d = do.c;
      if (do.a().e() != null) {
        this.e = do.a().e().mUin;
      }
      return;
      this.b.clear();
      this.b.addAll(paramList);
    }
  }
  
  public boolean a()
  {
    QQUser localQQUser = do.a().e();
    if ((this.d == null) || (localQQUser == null)) {}
    while ((!this.d.equals(do.c)) || (this.e != localQQUser.mUin) || (!this.f)) {
      return false;
    }
    return true;
  }
  
  public boolean a(JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    if (paramJSONArray != null) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        com.tencent.token.global.h.a(bool);
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
  
  public boolean a(JSONArray paramJSONArray, boolean paramBoolean)
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
            com.tencent.token.global.h.a(bool);
            com.tencent.token.core.bean.h localh = new com.tencent.token.core.bean.h();
            if (!localh.b(localJSONObject)) {
              com.tencent.token.global.h.c("object item parse failed: " + i);
            }
            localArrayList.add(localh);
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
      ((com.tencent.token.core.bean.h)localIterator.next()).f = false;
    }
    localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.token.core.bean.h)localIterator.next()).f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ef
 * JD-Core Version:    0.7.0.1
 */