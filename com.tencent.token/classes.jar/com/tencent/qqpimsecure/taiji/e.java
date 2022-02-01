package com.tencent.qqpimsecure.taiji;

import Protocol.MMGRAuth.SolutionItem;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import taiji.bh;
import taiji.bi;
import taiji.bj;
import taiji.bl;
import taiji.bm;
import taiji.bn;

public class e
{
  private SolutionItem a(Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject = paramJSONObject.keys();
    if ((localObject == null) || (!((Iterator)localObject).hasNext())) {
      return null;
    }
    localObject = (String)((Iterator)localObject).next();
    bn.b("TaijiLocalSchemeManager", "adapter id:" + (String)localObject);
    JSONObject localJSONObject = (JSONObject)bi.a(paramJSONObject, (String)localObject);
    paramJSONObject = (JSONArray)bi.c(localJSONObject, paramString);
    if (paramJSONObject == null)
    {
      bn.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " not accurate scheme for " + paramString + ", try key common scheme");
      paramJSONObject = (JSONArray)bi.a(localJSONObject, "all_brand");
    }
    for (;;)
    {
      if (paramJSONObject == null)
      {
        bn.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " has no scheme for " + paramString + ", abort");
        return null;
      }
      bn.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " has scheme for " + paramString);
      bn.b("TaijiLocalSchemeManager", "start to search scheme");
      int m = paramJSONObject.length();
      bn.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + ", scheme count:" + m);
      int k = 0;
      if (k < m)
      {
        bn.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + ", current scheme index:" + k);
        localJSONObject = (JSONObject)bi.a(paramJSONObject, k);
        if (localJSONObject == null) {}
        label372:
        int j;
        do
        {
          for (;;)
          {
            k += 1;
            break;
            paramString = bi.b(localJSONObject, "scheme");
            str = bi.b(localJSONObject, "sdk");
            if (!TextUtils.isEmpty(paramString)) {
              break label372;
            }
            bn.b("TaijiLocalSchemeManager", "scheme is null, abort");
          }
          bn.b("TaijiLocalSchemeManager", "scheme:" + paramString);
          bn.b("TaijiLocalSchemeManager", "sdk:" + str);
          j = 1;
          int i = j;
          if (!TextUtils.isEmpty(str))
          {
            i = j;
            if (!a(paramInt, str))
            {
              bn.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " sdk not hit");
              i = 0;
            }
          }
          String str = bi.b(localJSONObject, "model");
          j = i;
          if (!TextUtils.isEmpty(str))
          {
            j = i;
            if (!a(str))
            {
              bn.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " model not hit");
              j = 0;
            }
          }
          str = bi.b(localJSONObject, "rom_version");
          i = j;
          if (j != 0)
          {
            i = j;
            if (!TextUtils.isEmpty(str))
            {
              i = j;
              if (!b(str))
              {
                bn.b("TaijiLocalSchemeManager", "adapter id " + str + " rom version not hit");
                i = 0;
              }
            }
          }
          localJSONObject = (JSONObject)bi.a(localJSONObject, "pkg");
          j = i;
          if (i != 0)
          {
            j = i;
            if (localJSONObject != null)
            {
              j = i;
              if (!a(paramContext, localJSONObject))
              {
                bn.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " pkg not hit");
                j = 0;
              }
            }
          }
        } while (j == 0);
      }
      for (paramContext = paramString;; paramContext = null)
      {
        if (!TextUtils.isEmpty(paramContext))
        {
          paramContext = (SolutionItem)bj.a(Base64.decode(paramContext, 2), new SolutionItem(), false);
          if (paramContext != null)
          {
            bn.b("TaijiLocalSchemeManager", "adapterId:" + paramContext.adapterId + ", commSoluId:" + paramContext.commSoluId + ", extSoluId:" + paramContext.extSoluId + ", soluType:" + paramContext.soluType);
            return paramContext;
          }
        }
        return null;
      }
    }
  }
  
  public static e a()
  {
    return a.a();
  }
  
  private List<SolutionItem> a(Context paramContext, String paramString)
  {
    try
    {
      String str = bl.c();
      int j = Build.VERSION.SDK_INT;
      bn.b("TaijiLocalSchemeManager", "brand:" + str + ", sdk:" + j);
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      bn.b("TaijiLocalSchemeManager", "adapter id count:" + k);
      int i = 0;
      while (i < k)
      {
        SolutionItem localSolutionItem = a(paramContext, (JSONObject)bi.a(paramString, i), str, j);
        if (localSolutionItem != null) {
          localArrayList.add(localSolutionItem);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Throwable paramContext)
    {
      bn.d("TaijiLocalSchemeManager", "parse taiji local scheme file fail!");
    }
    return null;
  }
  
  private void a(Context paramContext, List<SolutionItem> paramList)
  {
    Object localObject = i.a(paramContext);
    if ((((i)localObject).f()) && (!((i)localObject).g()))
    {
      bn.b("TaijiLocalSchemeManager", "pull cloud scheme finish, ignore local scheme");
      return;
    }
    try
    {
      localObject = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SolutionItem localSolutionItem = (SolutionItem)paramList.next();
        String str = Base64.encodeToString(b.a().a(paramContext, bj.a(localSolutionItem)), 2);
        bn.b("TaijiLocalSchemeManager", str);
        if (!TextUtils.isEmpty(str))
        {
          ((HashMap)localObject).put(Integer.valueOf(localSolutionItem.adapterId), str);
          bn.b("TaijiLocalSchemeManager", "put local scheme to taiji dao, adapter id:" + localSolutionItem.adapterId + ", commSoluId:" + localSolutionItem.commSoluId);
        }
      }
      a.a(paramContext).a((HashMap)localObject, false);
    }
    catch (Throwable paramContext)
    {
      bn.d("TaijiLocalSchemeManager", paramContext.getMessage());
      return;
    }
  }
  
  private static boolean a(int paramInt, String paramString)
  {
    return a(paramString, paramInt + "", ",");
  }
  
  private static boolean a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramContext == null) {}
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            return false;
            if (paramJSONObject == null) {
              return true;
            }
            str = bi.b(paramJSONObject, "pkg_exist");
            if ((!TextUtils.isEmpty(str)) && (!bm.a(paramContext, str)))
            {
              bn.b("TaijiLocalSchemeManager", "package:" + str + " not exist, return false");
              return false;
            }
            str = bi.b(paramJSONObject, "pkg_not_exist");
            if ((!TextUtils.isEmpty(str)) && (bm.a(paramContext, str)))
            {
              bn.b("TaijiLocalSchemeManager", "package:" + str + " exist, return false");
              return false;
            }
            str = bi.b(paramJSONObject, "package");
            bn.b("TaijiLocalSchemeManager", "pkg:" + str);
            if (TextUtils.isEmpty(str))
            {
              bn.b("TaijiLocalSchemeManager", "package is null, return true");
              return true;
            }
            if (!bm.a(paramContext, str))
            {
              bn.b("TaijiLocalSchemeManager", "package:" + str + " not exist, return false");
              return false;
            }
            paramContext = bm.b(paramContext, str);
            bn.b("TaijiLocalSchemeManager", "versionName:" + paramContext);
            if (TextUtils.isEmpty(paramContext))
            {
              bn.b("TaijiLocalSchemeManager", "get version name for " + str + " fail, return false");
              return false;
            }
            str = bi.b(paramJSONObject, "versionName_LT");
            bn.b("TaijiLocalSchemeManager", "versionNameLt:" + str);
          } while ((!TextUtils.isEmpty(str)) && (paramContext.compareTo(str) >= 0));
          str = bi.b(paramJSONObject, "versionName_LE");
          bn.b("TaijiLocalSchemeManager", "versionNameLe:" + str);
        } while ((!TextUtils.isEmpty(str)) && (paramContext.compareTo(str) > 0));
        str = bi.b(paramJSONObject, "versionName_MT");
        bn.b("TaijiLocalSchemeManager", "versionNameMt:" + str);
      } while ((!TextUtils.isEmpty(str)) && (paramContext.compareTo(str) <= 0));
      paramJSONObject = bi.b(paramJSONObject, "versionName_ME");
      bn.b("TaijiLocalSchemeManager", "versionNameMe:" + paramJSONObject);
    } while ((!TextUtils.isEmpty(paramJSONObject)) && (paramContext.compareTo(paramJSONObject) < 0));
    return true;
  }
  
  private static boolean a(String paramString)
  {
    String str = bl.a();
    return a(paramString, str + "", ",");
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    bn.b("TaijiLocalSchemeManager", "wholeStr:" + paramString1 + " === matchStr:" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = paramString1.split(paramString3);
        if ((paramString1 == null) || (paramString1.length <= 0)) {
          continue;
        }
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          paramString3 = paramString1[i];
          if (!TextUtils.isEmpty(paramString3))
          {
            boolean bool = paramString2.equals(paramString3.trim());
            if (bool) {
              return true;
            }
          }
          i += 1;
        }
        return false;
      }
      catch (Throwable paramString1) {}
    }
  }
  
  private void b(Context paramContext)
  {
    bn.b("TaijiLocalSchemeManager", "startAndLoadScheme, process id:" + Process.myPid() + ", thread id:" + Thread.currentThread().getId());
    Object localObject = c(paramContext);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      bn.b("TaijiLocalSchemeManager", "loadAssetLocalSchemeFile json is null, return");
      return;
    }
    bn.b("TaijiLocalSchemeManager", "loadAssetLocalSchemeFile json:" + (String)localObject);
    localObject = a(paramContext, (String)localObject);
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      bn.b("TaijiLocalSchemeManager", "getSolutionListForPhone result list is empty, return");
      return;
    }
    bn.b("TaijiLocalSchemeManager", "getSolutionListForPhone result list size:" + ((List)localObject).size());
    a(paramContext, (List)localObject);
  }
  
  private static boolean b(String paramString)
  {
    String str = bl.d();
    bn.b("TaijiLocalSchemeManager", "romVersion:" + paramString + ", phoneRomVersion:" + str);
    return a(paramString, str, ",");
  }
  
  private String c(Context paramContext)
  {
    byte[] arrayOfByte = bh.a(paramContext, "zz.dat");
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      bn.b("TaijiLocalSchemeManager", "read asset file zz.dat is null");
      return null;
    }
    bn.b("TaijiLocalSchemeManager", "read asset file zz.dat is not null");
    paramContext = b.a().b(paramContext, arrayOfByte, true);
    if (paramContext == null)
    {
      bn.b("TaijiLocalSchemeManager", "decrypt asset file zz.dat, result is null");
      return null;
    }
    bn.b("TaijiLocalSchemeManager", "decrypt asset file zz.dat, result is not null");
    try
    {
      paramContext = new String(paramContext, "UTF-8");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public void a(Context paramContext)
  {
    i locali = i.a(paramContext);
    int i = locali.i();
    int j = bm.c(paramContext, paramContext.getPackageName());
    if ((i == 0) || (i != j))
    {
      locali.c(true);
      locali.a(j);
    }
    if (locali.h())
    {
      locali.c(false);
      b(paramContext);
    }
  }
  
  private static final class a
  {
    private static final e a = new e(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.e
 * JD-Core Version:    0.7.0.1
 */