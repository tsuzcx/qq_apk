package com.tencent.token;

import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class en
{
  List a = Collections.synchronizedList(new ArrayList());
  NewConfigureCacheItem b;
  String c;
  long d;
  public boolean e;
  public boolean f = false;
  
  public com.tencent.token.core.bean.h a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= c())) {}
    List localList;
    do
    {
      return null;
      localList = a();
    } while (localList == null);
    return (com.tencent.token.core.bean.h)localList.get(paramInt);
  }
  
  public List a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    j.a("game_lock", paramString);
  }
  
  public void a(List paramList)
  {
    try
    {
      if (this.b == null) {
        this.b = dr.a().h.a("game_lock");
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
            com.tencent.token.core.bean.h localh = (com.tencent.token.core.bean.h)localIterator2.next();
            if (i == localh.a) {
              localh.f = true;
            }
          }
        }
      }
      this.a.clear();
    }
    finally {}
    this.a.addAll(paramList);
    this.c = do.c;
    if (do.a().e() != null) {
      this.d = do.a().e().mUin;
    }
  }
  
  public boolean a(JSONArray paramJSONArray)
  {
    boolean bool;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if (paramJSONArray != null)
    {
      bool = true;
      com.tencent.token.global.h.a(bool);
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
          com.tencent.token.global.h.a(bool);
          com.tencent.token.core.bean.h localh = new com.tencent.token.core.bean.h();
          if (!localh.c(localJSONObject)) {
            com.tencent.token.global.h.c("object item parse failed: " + i);
          }
          localArrayList1.add(localh);
          i += 1;
          continue;
          if (i >= localArrayList1.size()) {
            break label246;
          }
          paramJSONArray = (com.tencent.token.core.bean.h)localArrayList1.get(i);
          if (paramJSONArray.g) {
            break label239;
          }
          localArrayList2.add(paramJSONArray);
          break label239;
          if (i < localArrayList1.size())
          {
            paramJSONArray = (com.tencent.token.core.bean.h)localArrayList1.get(i);
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
  
  public int b(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      com.tencent.token.core.bean.h localh = (com.tencent.token.core.bean.h)localIterator.next();
      int j = i + 1;
      i = j;
      if (localh.a == paramInt) {
        return j;
      }
    }
    return -1;
  }
  
  public boolean b()
  {
    QQUser localQQUser = do.a().e();
    if ((this.c == null) || (localQQUser == null)) {}
    while ((!this.c.equals(do.c)) || (this.d != do.a().e().mUin) || (!this.e)) {
      return false;
    }
    return true;
  }
  
  public int c()
  {
    List localList = a();
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int d()
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
      boolean bool = ((com.tencent.token.core.bean.h)localList.get(j)).g;
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
  
  public void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.token.core.bean.h)localIterator.next()).f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.en
 * JD-Core Version:    0.7.0.1
 */