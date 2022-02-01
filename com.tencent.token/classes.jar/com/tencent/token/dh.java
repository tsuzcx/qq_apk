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

public class dh
{
  List<f> a = Collections.synchronizedList(new ArrayList());
  NewConfigureCacheItem b;
  String c;
  long d;
  public boolean e;
  public boolean f = false;
  
  public f a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= c()) {
        return null;
      }
      List localList = a();
      if (localList == null) {
        return null;
      }
      return (f)localList.get(paramInt);
    }
    return null;
  }
  
  public List<f> a()
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
  
  public void a(String paramString)
  {
    h.a("game_protect", paramString);
  }
  
  public void a(List<f> paramList)
  {
    try
    {
      if (this.b == null) {
        this.b = cs.a().h.a("account_prot");
      }
      if (this.b.mClientVersion > this.b.mClickVersion)
      {
        Object localObject;
        Iterator localIterator;
        f localf;
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
          localIterator = this.a.iterator();
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
      this.a.clear();
      this.a = paramList;
      this.c = cr.c;
      if (cr.a().e() != null) {
        this.d = cr.a().e().mUin;
      }
      return;
    }
    finally {}
  }
  
  public boolean a(JSONArray paramJSONArray)
  {
    boolean bool;
    if (paramJSONArray != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
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
            break label247;
          }
          Object localObject = paramJSONArray.getJSONObject(i);
          if (localObject == null) {
            break label242;
          }
          bool = true;
          g.a(bool);
          f localf = new f();
          if (!localf.a((JSONObject)localObject))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("object item parse failed: ");
            ((StringBuilder)localObject).append(i);
            g.c(((StringBuilder)localObject).toString());
          }
          localArrayList1.add(localf);
          i += 1;
          continue;
          if (i >= localArrayList1.size()) {
            break label259;
          }
          paramJSONArray = (f)localArrayList1.get(i);
          if (paramJSONArray.g) {
            break label252;
          }
          localArrayList2.add(paramJSONArray);
          break label252;
          if (i < localArrayList1.size())
          {
            paramJSONArray = (f)localArrayList1.get(i);
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
      label242:
      bool = false;
      continue;
      label247:
      int i = 0;
      continue;
      label252:
      i += 1;
      continue;
      label259:
      i = 0;
    }
  }
  
  public int b(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      int j = i + 1;
      i = j;
      if (localf.a == paramInt) {
        return j;
      }
    }
    return -1;
  }
  
  public boolean b()
  {
    QQUser localQQUser = cr.a().e();
    String str = this.c;
    if (str != null)
    {
      if (localQQUser == null) {
        return false;
      }
      return (str.equals(cr.c)) && (this.d == cr.a().e().mUin) && (this.e);
    }
    return false;
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
        boolean bool = ((f)localList.get(i)).g;
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
  
  public void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dh
 * JD-Core Version:    0.7.0.1
 */