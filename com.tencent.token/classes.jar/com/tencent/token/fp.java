package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
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

public final class fp
  extends Observable
  implements fj
{
  public static final String[] a = { "login_protect", "account_prot", "mail_protect", "qb_prot", "account_lock", "game_lock", "modify_pwd", "recover_friends", "real_name", "key_value" };
  public int b = 0;
  private List c = Collections.synchronizedList(new ArrayList());
  
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
          int j = ((Integer)((JSONArray)localObject).get(1)).intValue();
          localObject = a(str);
          if (localObject == null)
          {
            localObject = new NewConfigureCacheItem(str);
            a((NewConfigureCacheItem)localObject);
            ((NewConfigureCacheItem)localObject).mClientVersion = j;
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
    }
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject;
    int i;
    try
    {
      localObject = paramJSONObject.getJSONArray("main_tab_new");
      paramJSONObject = paramJSONObject.getJSONArray("conf_id_new");
      if (localObject != null)
      {
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          localNewConfigureCacheItem = a((String)((JSONArray)localObject).get(i));
          if (localNewConfigureCacheItem == null) {
            break label230;
          }
          localNewConfigureCacheItem.mClickVersion = -1;
          break label230;
        }
      }
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localNewConfigureCacheItem = (NewConfigureCacheItem)((Iterator)localObject).next();
        if (localNewConfigureCacheItem.mClickVersion != -1) {
          localNewConfigureCacheItem.mClickVersion = localNewConfigureCacheItem.mClientVersion;
        }
      }
      localObject = a("game_lock");
    }
    catch (Exception paramJSONObject)
    {
      e.b(paramJSONObject.toString());
      return false;
    }
    if (((NewConfigureCacheItem)localObject).mConfIDs == null) {
      ((NewConfigureCacheItem)localObject).mConfIDs = new ArrayList();
    }
    NewConfigureCacheItem localNewConfigureCacheItem = a("account_prot");
    if (localNewConfigureCacheItem.mConfIDs == null) {
      localNewConfigureCacheItem.mConfIDs = new ArrayList();
    }
    for (;;)
    {
      if (i < paramJSONObject.length())
      {
        ((NewConfigureCacheItem)localObject).mConfIDs.add(Integer.valueOf(paramJSONObject.getInt(i)));
        localNewConfigureCacheItem.mConfIDs.add(Integer.valueOf(paramJSONObject.getInt(i)));
        i += 1;
      }
      else
      {
        label230:
        do
        {
          return true;
          i += 1;
          break;
        } while (paramJSONObject == null);
        i = 0;
      }
    }
  }
  
  /* Error */
  public final NewConfigureCacheItem a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/tencent/token/fp:c	Ljava/util/List;
    //   6: invokeinterface 116 1 0
    //   11: astore 4
    //   13: aload 4
    //   15: invokeinterface 122 1 0
    //   20: ifeq +33 -> 53
    //   23: aload 4
    //   25: invokeinterface 126 1 0
    //   30: checkcast 91	com/tencent/token/core/bean/NewConfigureCacheItem
    //   33: astore_3
    //   34: aload_3
    //   35: getfield 151	com/tencent/token/core/bean/NewConfigureCacheItem:mConfKey	Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifeq -31 -> 13
    //   47: aload_3
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aconst_null
    //   54: astore_1
    //   55: goto -6 -> 49
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	fp
    //   0	63	1	paramString	String
    //   42	2	2	bool	boolean
    //   33	15	3	localNewConfigureCacheItem	NewConfigureCacheItem
    //   11	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	58	finally
    //   13	43	58	finally
  }
  
  public final ft a(Serializable paramSerializable)
  {
    ft localft = new ft();
    localft.a = paramSerializable;
    return localft;
  }
  
  public final Serializable a(ft paramft)
  {
    return (Serializable)paramft.a;
  }
  
  public final void a()
  {
    ft localft = new ft();
    localft.a = this.c;
    RqdApplication.h().a(this, localft);
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    bool2 = false;
    bool1 = false;
    if (paramJSONObject == null) {
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      e.c(paramJSONObject.toString());
      for (;;)
      {
        try
        {
          i = paramJSONObject.getInt("version");
          bool1 = bool2;
          if (this.b < i) {
            bool1 = a(paramJSONObject.getJSONArray("config_version"));
          }
        }
        catch (Exception paramJSONObject)
        {
          int i;
          SharedPreferences.Editor localEditor;
          bool1 = bool2;
          continue;
          continue;
        }
        try
        {
          localEditor = RqdApplication.i().getSharedPreferences("sp_name_global", 0).edit();
          localEditor.putInt("exchangeky_conf_ver", i);
          localEditor.commit();
          if (this.b == 0)
          {
            bool1 = b(paramJSONObject.getJSONObject("install_new"));
            this.b = i;
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            paramJSONObject = new ft();
            paramJSONObject.a = this.c;
            RqdApplication.h().a(this, paramJSONObject);
            setChanged();
            notifyObservers();
            return bool1;
          }
        }
        catch (Exception localException)
        {
          e.c("SharedPreferences msg " + localException.getMessage());
        }
      }
    }
  }
  
  public final void b()
  {
    int k = 0;
    this.b = g.a();
    Object localObject1 = RqdApplication.h().a(this);
    int i;
    label35:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label70;
      }
      i = 0;
      j = k;
      if (i == 0) {
        break label196;
      }
      this.c.addAll((Collection)localObject1);
    }
    for (;;)
    {
      return;
      localObject1 = (List)((fe)localObject1).b.a;
      break;
      label70:
      int m = ((List)localObject1).size();
      i = 0;
      for (;;)
      {
        if (i >= a.length) {
          break label151;
        }
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
          break;
        }
        i += 1;
      }
      label151:
      Object localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext()) {
          if (((NewConfigureCacheItem)((Iterator)localObject2).next()).mConfIDs == null)
          {
            i = 0;
            break;
          }
        }
      }
      i = 1;
      break label35;
      label196:
      while (j < a.length)
      {
        a(new NewConfigureCacheItem(a[j]));
        j += 1;
      }
    }
  }
  
  public final void c()
  {
    ft localft = new ft();
    localft.a = this.c;
    RqdApplication.h().a(this, localft);
  }
  
  public final String d()
  {
    return getClass().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fp
 * JD-Core Version:    0.7.0.1
 */