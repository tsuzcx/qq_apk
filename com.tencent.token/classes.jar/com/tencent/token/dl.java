package com.tencent.token;

import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.global.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dl
  extends Observable
  implements df
{
  public static final String[] a = { "login_protect", "account_prot", "mail_protect", "qb_prot", "account_lock", "game_lock", "real_name", "modify_pwd", "recover_friends", "account_freeze", "key_value" };
  public int b = 0;
  private List<NewConfigureCacheItem> c = Collections.synchronizedList(new ArrayList());
  private boolean d = false;
  
  private boolean a(List<NewConfigureCacheItem> paramList)
  {
    if (paramList == null) {
      return false;
    }
    int k = paramList.size();
    int i = 0;
    while (i < a.length)
    {
      int j = 0;
      while (j < k)
      {
        NewConfigureCacheItem localNewConfigureCacheItem = (NewConfigureCacheItem)paramList.get(j);
        if (a[i].equals(localNewConfigureCacheItem.mConfKey)) {
          break;
        }
        j += 1;
      }
      if (j == k) {
        return false;
      }
      i += 1;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((NewConfigureCacheItem)paramList.next()).mConfIDs == null) {
        return false;
      }
    }
    return true;
  }
  
  private boolean a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          Object localObject = paramJSONArray.getJSONArray(i);
          String str = (String)((JSONArray)localObject).get(0);
          int k = ((Integer)((JSONArray)localObject).get(1)).intValue();
          NewConfigureCacheItem localNewConfigureCacheItem = a(str);
          localObject = localNewConfigureCacheItem;
          if (localNewConfigureCacheItem == null)
          {
            localObject = new NewConfigureCacheItem(str);
            a((NewConfigureCacheItem)localObject);
            break label155;
            if (j < a.length - 1)
            {
              if ((this.b == 0) || (((NewConfigureCacheItem)localObject).mClientVersion >= k) || (!str.equals(a[j]))) {
                break label160;
              }
              this.d = true;
              break label160;
            }
            ((NewConfigureCacheItem)localObject).mClientVersion = k;
            i += 1;
          }
        }
        else
        {
          return true;
        }
      }
      catch (JSONException paramJSONArray)
      {
        return false;
      }
      catch (Exception paramJSONArray)
      {
        return false;
      }
      label155:
      int j = 0;
      continue;
      label160:
      j += 1;
    }
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject1 = paramJSONObject.getJSONArray("main_tab_new");
        paramJSONObject = paramJSONObject.getJSONArray("conf_id_new");
        if (localObject1 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = (String)((JSONArray)localObject1).get(i);
            NewConfigureCacheItem localNewConfigureCacheItem = a((String)localObject2);
            if (localNewConfigureCacheItem == null) {
              break label282;
            }
            localNewConfigureCacheItem.mClickVersion = -1;
            j = 0;
            if (j >= a.length - 1) {
              break label282;
            }
            if (!((String)localObject2).equals(a[j])) {
              break label275;
            }
            this.d = true;
            break label275;
          }
        }
        localObject1 = this.c.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (NewConfigureCacheItem)((Iterator)localObject1).next();
          if (((NewConfigureCacheItem)localObject2).mClickVersion == -1) {
            continue;
          }
          ((NewConfigureCacheItem)localObject2).mClickVersion = ((NewConfigureCacheItem)localObject2).mClientVersion;
          continue;
        }
        localObject1 = a("game_lock");
        if (((NewConfigureCacheItem)localObject1).mConfIDs == null) {
          ((NewConfigureCacheItem)localObject1).mConfIDs = new ArrayList();
        }
        localObject2 = a("account_prot");
        if (((NewConfigureCacheItem)localObject2).mConfIDs != null) {
          break label289;
        }
        ((NewConfigureCacheItem)localObject2).mConfIDs = new ArrayList();
      }
      catch (Exception paramJSONObject)
      {
        Object localObject1;
        Object localObject2;
        g.b(paramJSONObject.toString());
        return false;
      }
      if (i < paramJSONObject.length())
      {
        ((NewConfigureCacheItem)localObject1).mConfIDs.add(Integer.valueOf(paramJSONObject.getInt(i)));
        ((NewConfigureCacheItem)localObject2).mConfIDs.add(Integer.valueOf(paramJSONObject.getInt(i)));
        i += 1;
      }
      else
      {
        return true;
        label275:
        j += 1;
        continue;
        label282:
        i += 1;
        continue;
        label289:
        if (paramJSONObject != null) {
          i = 0;
        }
      }
    }
  }
  
  private void e()
  {
    Object localObject = g();
    if (a((List)localObject))
    {
      this.c.addAll((Collection)localObject);
      return;
    }
    int i = 0;
    for (;;)
    {
      localObject = a;
      if (i >= localObject.length) {
        break;
      }
      a(new NewConfigureCacheItem(localObject[i]));
      i += 1;
    }
  }
  
  private void f()
  {
    dp localdp = new dp();
    localdp.a = this.c;
    RqdApplication.k().a(this, localdp, null);
  }
  
  private List<NewConfigureCacheItem> g()
  {
    dd.a locala = RqdApplication.k().a(this);
    if (locala == null) {
      return null;
    }
    return (List)locala.b.a;
  }
  
  public NewConfigureCacheItem a(String paramString)
  {
    try
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        NewConfigureCacheItem localNewConfigureCacheItem = (NewConfigureCacheItem)localIterator.next();
        boolean bool = localNewConfigureCacheItem.mConfKey.equals(paramString);
        if (bool) {
          return localNewConfigureCacheItem;
        }
      }
      return null;
    }
    finally {}
  }
  
  public dp a(Serializable paramSerializable)
  {
    dp localdp = new dp();
    localdp.a = paramSerializable;
    return localdp;
  }
  
  public Serializable a(dp paramdp)
  {
    return (Serializable)paramdp.a;
  }
  
  public void a()
  {
    f();
  }
  
  public void a(NewConfigureCacheItem paramNewConfigureCacheItem)
  {
    try
    {
      this.c.add(paramNewConfigureCacheItem);
      return;
    }
    finally
    {
      paramNewConfigureCacheItem = finally;
      throw paramNewConfigureCacheItem;
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    bool2 = false;
    if (paramJSONObject == null) {
      return false;
    }
    g.c(paramJSONObject.toString());
    try
    {
      int i = paramJSONObject.getInt("version");
      bool1 = bool2;
      if (this.b < i)
      {
        bool1 = a(paramJSONObject.getJSONArray("config_version"));
        h.b(i);
        if (this.b == 0) {
          bool1 = b(paramJSONObject.getJSONObject("install_new"));
        }
        this.b = i;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
    if (bool1)
    {
      a();
      setChanged();
      notifyObservers();
      if (this.d) {
        h.a(true);
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.b = h.c();
    e();
  }
  
  public void c()
  {
    a();
  }
  
  public String d()
  {
    return getClass().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dl
 * JD-Core Version:    0.7.0.1
 */