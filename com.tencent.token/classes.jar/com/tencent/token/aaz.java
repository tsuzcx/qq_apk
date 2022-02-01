package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.global.RqdApplication;
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

public final class aaz
  extends Observable
  implements aat
{
  public static final String[] a = { "login_protect", "account_prot", "mail_protect", "qb_prot", "account_lock", "game_lock", "real_name", "modify_pwd", "recover_friends", "account_freeze", "key_value" };
  public int b = 0;
  private List<NewConfigureCacheItem> c = Collections.synchronizedList(new ArrayList());
  private boolean d = false;
  
  private void a(NewConfigureCacheItem paramNewConfigureCacheItem)
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
        xj.b(paramJSONObject.toString());
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
  
  public final abd a(Serializable paramSerializable)
  {
    abd localabd = new abd();
    localabd.a = paramSerializable;
    return localabd;
  }
  
  public final NewConfigureCacheItem a(String paramString)
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
  
  public final Serializable a(abd paramabd)
  {
    return (Serializable)paramabd.a;
  }
  
  public final void a()
  {
    Object localObject1 = RqdApplication.o().a(this);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (List)((aar.a)localObject1).b.a;
    }
    int k = 0;
    int i;
    if (localObject1 == null)
    {
      i = 0;
    }
    else
    {
      int m = ((List)localObject1).size();
      i = 0;
      while (i < a.length)
      {
        j = 0;
        while (j < m)
        {
          localObject2 = (NewConfigureCacheItem)((List)localObject1).get(j);
          if (a[i].equals(((NewConfigureCacheItem)localObject2).mConfKey)) {
            break;
          }
          j += 1;
        }
        if (j == m)
        {
          i = 0;
          break label170;
        }
        i += 1;
      }
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((NewConfigureCacheItem)((Iterator)localObject2).next()).mConfIDs == null)
        {
          i = 0;
          break label170;
        }
      }
      i = 1;
    }
    label170:
    int j = k;
    if (i != 0)
    {
      this.c.addAll((Collection)localObject1);
      return;
    }
    for (;;)
    {
      localObject1 = a;
      if (j >= localObject1.length) {
        break;
      }
      a(new NewConfigureCacheItem(localObject1[j]));
      j += 1;
    }
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    bool2 = false;
    if (paramJSONObject == null) {
      return false;
    }
    xj.c(paramJSONObject.toString());
    try
    {
      i = paramJSONObject.getInt("version");
      bool1 = bool2;
      if (this.b >= i) {
        break label144;
      }
      bool1 = a(paramJSONObject.getJSONArray("config_version"));
      try
      {
        SharedPreferences.Editor localEditor = RqdApplication.p().getSharedPreferences("sp_name_global", 0).edit();
        localEditor.putInt("exchangeky_conf_ver", i);
        localEditor.commit();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
        localStringBuilder.append(localException.getMessage());
        xj.c(localStringBuilder.toString());
      }
      if (this.b != 0) {
        break label180;
      }
      bool1 = b(paramJSONObject.getJSONObject("install_new"));
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        int i;
        label144:
        boolean bool1 = bool2;
      }
    }
    this.b = i;
    if (bool1)
    {
      b();
      setChanged();
      notifyObservers();
      if (this.d) {
        xm.a(true);
      }
    }
    return bool1;
  }
  
  public final void b()
  {
    abd localabd = new abd();
    localabd.a = this.c;
    RqdApplication.o().a(this, localabd);
  }
  
  public final String c()
  {
    return getClass().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aaz
 * JD-Core Version:    0.7.0.1
 */