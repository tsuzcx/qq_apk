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
    if ((paramInt < 0) || (paramInt >= c())) {}
    List localList;
    do
    {
      return null;
      localList = a();
    } while (localList == null);
    return (f)localList.get(paramInt);
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
    Object localObject;
    f localf;
    try
    {
      if (this.b == null) {
        this.b = cs.a().h.a("account_prot");
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
            localf = (f)localIterator.next();
            if (i == localf.a) {
              localf.f = true;
            }
          }
        }
      }
      localObject = new HashSet();
    }
    finally {}
    Iterator localIterator = this.a.iterator();
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
    label259:
    this.a.clear();
    this.a = paramList;
    this.c = cr.c;
    if (cr.a().e() != null) {
      this.d = cr.a().e().mUin;
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
      g.a(bool);
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
          g.a(bool);
          f localf = new f();
          if (!localf.a(localJSONObject)) {
            g.c("object item parse failed: " + i);
          }
          localArrayList1.add(localf);
          i += 1;
          continue;
          if (i >= localArrayList1.size()) {
            break label246;
          }
          paramJSONArray = (f)localArrayList1.get(i);
          if (paramJSONArray.g) {
            break label239;
          }
          localArrayList2.add(paramJSONArray);
          break label239;
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
    if ((this.c == null) || (localQQUser == null)) {}
    while ((!this.c.equals(cr.c)) || (this.d != cr.a().e().mUin) || (!this.e)) {
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
      boolean bool = ((f)localList.get(j)).g;
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
      ((f)localIterator.next()).f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dh
 * JD-Core Version:    0.7.0.1
 */