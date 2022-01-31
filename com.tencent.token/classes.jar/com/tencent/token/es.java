package com.tencent.token;

import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.global.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class es
  extends Observable
  implements em
{
  public static final String[] a = { "login_protect", "account_prot", "mail_protect", "qb_prot", "account_lock", "game_lock", "real_name", "modify_pwd", "recover_friends", "account_freeze", "key_value" };
  public int b = 0;
  private List c = Collections.synchronizedList(new ArrayList());
  private boolean d = false;
  
  private boolean a(List paramList)
  {
    if (paramList == null) {
      return false;
    }
    int k = paramList.size();
    int i = 0;
    label16:
    if (i < a.length)
    {
      int j = 0;
      for (;;)
      {
        if (j < k)
        {
          NewConfigureCacheItem localNewConfigureCacheItem = (NewConfigureCacheItem)paramList.get(j);
          if (!a[i].equals(localNewConfigureCacheItem.mConfKey)) {}
        }
        else
        {
          if (j == k) {
            break;
          }
          i += 1;
          break label16;
        }
        j += 1;
      }
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
      int j;
      try
      {
        if (i >= paramJSONArray.length()) {
          break label153;
        }
        localObject = paramJSONArray.getJSONArray(i);
        str = (String)((JSONArray)localObject).get(0);
        k = ((Integer)((JSONArray)localObject).get(1)).intValue();
        NewConfigureCacheItem localNewConfigureCacheItem = a(str);
        localObject = localNewConfigureCacheItem;
        if (localNewConfigureCacheItem != null) {
          break label155;
        }
        localObject = new NewConfigureCacheItem(str);
        a((NewConfigureCacheItem)localObject);
      }
      catch (JSONException paramJSONArray)
      {
        Object localObject;
        String str;
        int k;
        return false;
      }
      catch (Exception paramJSONArray)
      {
        return false;
      }
      if (j < a.length - 1)
      {
        if ((this.b != 0) && (((NewConfigureCacheItem)localObject).mClientVersion < k) && (str.equals(a[j]))) {
          this.d = true;
        }
      }
      else
      {
        ((NewConfigureCacheItem)localObject).mClientVersion = k;
        i += 1;
        continue;
        label153:
        return true;
        label155:
        j = 0;
        continue;
      }
      j += 1;
    }
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject1;
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
          label69:
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
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (NewConfigureCacheItem)((Iterator)localObject1).next();
        if (((NewConfigureCacheItem)localObject2).mClickVersion != -1) {
          ((NewConfigureCacheItem)localObject2).mClickVersion = ((NewConfigureCacheItem)localObject2).mClientVersion;
        }
      }
      localObject1 = a("game_lock");
    }
    catch (Exception paramJSONObject)
    {
      h.b(paramJSONObject.toString());
      return false;
    }
    if (((NewConfigureCacheItem)localObject1).mConfIDs == null) {
      ((NewConfigureCacheItem)localObject1).mConfIDs = new ArrayList();
    }
    Object localObject2 = a("account_prot");
    if (((NewConfigureCacheItem)localObject2).mConfIDs == null) {
      ((NewConfigureCacheItem)localObject2).mConfIDs = new ArrayList();
    }
    for (;;)
    {
      if (i < paramJSONObject.length())
      {
        ((NewConfigureCacheItem)localObject1).mConfIDs.add(Integer.valueOf(paramJSONObject.getInt(i)));
        ((NewConfigureCacheItem)localObject2).mConfIDs.add(Integer.valueOf(paramJSONObject.getInt(i)));
        i += 1;
      }
      else
      {
        label275:
        label282:
        do
        {
          return true;
          j += 1;
          break label69;
          i += 1;
          break;
        } while (paramJSONObject == null);
        i = 0;
      }
    }
  }
  
  private void e()
  {
    List localList = g();
    if (a(localList)) {
      this.c.addAll(localList);
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < a.length)
      {
        a(new NewConfigureCacheItem(a[i]));
        i += 1;
      }
    }
  }
  
  private void f()
  {
    ew localew = new ew();
    localew.a = this.c;
    RqdApplication.k().a(this, localew, null);
  }
  
  private List g()
  {
    eh localeh = RqdApplication.k().a(this);
    if (localeh == null) {
      return null;
    }
    return (List)localeh.b.a;
  }
  
  /* Error */
  public NewConfigureCacheItem a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/token/es:c	Ljava/util/List;
    //   6: invokeinterface 86 1 0
    //   11: astore 4
    //   13: aload 4
    //   15: invokeinterface 92 1 0
    //   20: ifeq +33 -> 53
    //   23: aload 4
    //   25: invokeinterface 96 1 0
    //   30: checkcast 74	com/tencent/token/core/bean/NewConfigureCacheItem
    //   33: astore_3
    //   34: aload_3
    //   35: getfield 78	com/tencent/token/core/bean/NewConfigureCacheItem:mConfKey	Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   0	63	0	this	es
    //   0	63	1	paramString	String
    //   42	2	2	bool	boolean
    //   33	15	3	localNewConfigureCacheItem	NewConfigureCacheItem
    //   11	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	58	finally
    //   13	43	58	finally
  }
  
  public ew a(Serializable paramSerializable)
  {
    ew localew = new ew();
    localew.a = paramSerializable;
    return localew;
  }
  
  public Serializable a(ew paramew)
  {
    return (Serializable)paramew.a;
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
    bool1 = false;
    if (paramJSONObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    h.c(paramJSONObject.toString());
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("version");
        if (this.b >= i) {
          continue;
        }
        bool1 = a(paramJSONObject.getJSONArray("config_version"));
        j.b(i);
        if (this.b == 0) {
          bool1 = b(paramJSONObject.getJSONObject("install_new"));
        }
        this.b = i;
      }
      catch (Exception paramJSONObject)
      {
        bool1 = bool2;
        continue;
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      a();
      setChanged();
      notifyObservers();
      bool2 = bool1;
      if (!this.d) {
        break;
      }
      j.a(true);
      return bool1;
      bool1 = false;
    }
  }
  
  public void b()
  {
    this.b = j.c();
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
 * Qualified Name:     com.tencent.token.es
 * JD-Core Version:    0.7.0.1
 */