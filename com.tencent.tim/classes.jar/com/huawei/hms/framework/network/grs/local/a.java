package com.huawei.hms.framework.network.grs.local;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public abstract class a
{
  protected com.huawei.hms.framework.network.grs.local.model.a a;
  protected List<b> b;
  protected Map<String, String> c = new ConcurrentHashMap(16);
  protected boolean d = false;
  protected Set<String> e = new HashSet(16);
  
  private Map<String, String> a(List<b> paramList, GrsBaseInfo paramGrsBaseInfo)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(16);
    localConcurrentHashMap.put("no_route_country", "no-country");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.b().contains(paramGrsBaseInfo.getIssueCountry())) {
        localConcurrentHashMap.put(paramGrsBaseInfo.getIssueCountry(), localb.a());
      }
      if (localb.b().contains(paramGrsBaseInfo.getRegCountry())) {
        localConcurrentHashMap.put(paramGrsBaseInfo.getRegCountry(), localb.a());
      }
      if (localb.b().contains(paramGrsBaseInfo.getSerCountry())) {
        localConcurrentHashMap.put(paramGrsBaseInfo.getSerCountry(), localb.a());
      }
    }
    return localConcurrentHashMap;
  }
  
  private int d(String paramString)
  {
    int i = -1;
    if (TextUtils.isEmpty(paramString)) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c(paramString);
        i = j;
      } while (j != 0);
      j = a(paramString);
      i = j;
    } while (j != 0);
    return b(paramString);
  }
  
  private int e(String paramString)
  {
    int i = -1;
    if (TextUtils.isEmpty(paramString)) {}
    int j;
    do
    {
      return i;
      if ((this.b != null) && (!this.b.isEmpty())) {
        break;
      }
      j = c(paramString);
      i = j;
    } while (j != 0);
    return b(paramString);
  }
  
  public abstract int a(String paramString);
  
  int a(String paramString, Context paramContext)
  {
    int i = -1;
    if (d(com.huawei.hms.framework.network.grs.c.c.a(paramString, paramContext)) == 0)
    {
      Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success.");
      i = 0;
    }
    paramString = paramContext.getAssets();
    int j = i;
    try
    {
      paramString = paramString.list("");
      int k = i;
      if (paramString != null)
      {
        j = i;
        k = i;
        if (paramString.length > 0)
        {
          j = i;
          int n = paramString.length;
          int m = 0;
          for (;;)
          {
            k = i;
            if (m >= n) {
              break;
            }
            CharSequence localCharSequence = paramString[m];
            k = i;
            j = i;
            if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", localCharSequence))
            {
              k = i;
              j = i;
              if (e(com.huawei.hms.framework.network.grs.c.c.a(localCharSequence, paramContext)) == 0)
              {
                j = i;
                Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE sucess.");
                k = 0;
              }
            }
            m += 1;
            i = k;
          }
        }
      }
      return k;
    }
    catch (IOException paramString)
    {
      Logger.w("AbstractLocalManager", "list assets files fail,please check if according to our standard config json files.");
      k = j;
    }
  }
  
  public com.huawei.hms.framework.network.grs.local.model.a a()
  {
    return this.a;
  }
  
  public String a(GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2)
  {
    paramGrsBaseInfo = a(paramGrsBaseInfo, paramString1);
    if (paramGrsBaseInfo == null)
    {
      Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", new Object[] { paramString1 });
      return null;
    }
    return (String)paramGrsBaseInfo.get(paramString2);
  }
  
  public Map<String, String> a(GrsBaseInfo paramGrsBaseInfo, String paramString)
  {
    if (!this.d) {
      return null;
    }
    com.huawei.hms.framework.network.grs.local.model.c localc = this.a.b(paramString);
    if (localc == null)
    {
      Logger.w("AbstractLocalManager", "service not found in local config{%s}", new Object[] { paramString });
      return null;
    }
    paramString = e.a(localc.b(), paramGrsBaseInfo);
    if (paramString == null)
    {
      Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", new Object[] { localc.b() });
      return null;
    }
    List localList = localc.c();
    if ((localList != null) && (localList.size() != 0)) {}
    for (paramGrsBaseInfo = localc.b((String)a(localList, paramGrsBaseInfo).get(paramString)); paramGrsBaseInfo == null; paramGrsBaseInfo = localc.b((String)this.c.get(paramString))) {
      return null;
    }
    return paramGrsBaseInfo.b();
  }
  
  public boolean a(GrsBaseInfo paramGrsBaseInfo)
  {
    if ((this.b == null) || (this.b.isEmpty())) {
      return false;
    }
    this.c.put("no_route_country", "no-country");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.b().contains(paramGrsBaseInfo.getIssueCountry())) {
        this.c.put(paramGrsBaseInfo.getIssueCountry(), localb.a());
      }
      if (localb.b().contains(paramGrsBaseInfo.getRegCountry())) {
        this.c.put(paramGrsBaseInfo.getRegCountry(), localb.a());
      }
      if (localb.b().contains(paramGrsBaseInfo.getSerCountry())) {
        this.c.put(paramGrsBaseInfo.getSerCountry(), localb.a());
      }
    }
    return true;
  }
  
  public abstract int b(String paramString);
  
  public boolean b()
  {
    return this.d;
  }
  
  public abstract int c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.a
 * JD-Core Version:    0.7.0.1
 */