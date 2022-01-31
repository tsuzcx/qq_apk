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
import taiji.cf;
import taiji.cg;
import taiji.ch;
import taiji.cj;
import taiji.ck;
import taiji.cl;

public class j
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
    cl.b("TaijiLocalSchemeManager", "adapter id:" + (String)localObject);
    JSONObject localJSONObject = (JSONObject)cg.a(paramJSONObject, (String)localObject);
    paramJSONObject = (JSONArray)cg.c(localJSONObject, paramString);
    if (paramJSONObject == null)
    {
      cl.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " not accurate scheme for " + paramString + ", try key common scheme");
      paramJSONObject = (JSONArray)cg.a(localJSONObject, "all_brand");
    }
    for (;;)
    {
      if (paramJSONObject == null)
      {
        cl.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " has no scheme for " + paramString + ", abort");
        return null;
      }
      cl.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " has scheme for " + paramString);
      cl.b("TaijiLocalSchemeManager", "start to search scheme");
      int m = paramJSONObject.length();
      cl.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + ", scheme count:" + m);
      int k = 0;
      if (k < m)
      {
        cl.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + ", current scheme index:" + k);
        localJSONObject = (JSONObject)cg.a(paramJSONObject, k);
        if (localJSONObject == null) {}
        label372:
        int j;
        do
        {
          for (;;)
          {
            k += 1;
            break;
            paramString = cg.b(localJSONObject, "scheme");
            str = cg.b(localJSONObject, "sdk");
            if (!TextUtils.isEmpty(paramString)) {
              break label372;
            }
            cl.b("TaijiLocalSchemeManager", "scheme is null, abort");
          }
          cl.b("TaijiLocalSchemeManager", "scheme:" + paramString);
          cl.b("TaijiLocalSchemeManager", "sdk:" + str);
          j = 1;
          int i = j;
          if (!TextUtils.isEmpty(str))
          {
            i = j;
            if (!a(paramInt, str))
            {
              cl.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " sdk not hit");
              i = 0;
            }
          }
          String str = cg.b(localJSONObject, "model");
          j = i;
          if (!TextUtils.isEmpty(str))
          {
            j = i;
            if (!a(str))
            {
              cl.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " model not hit");
              j = 0;
            }
          }
          str = cg.b(localJSONObject, "rom_version");
          i = j;
          if (j != 0)
          {
            i = j;
            if (!TextUtils.isEmpty(str))
            {
              i = j;
              if (!b(str))
              {
                cl.b("TaijiLocalSchemeManager", "adapter id " + str + " rom version not hit");
                i = 0;
              }
            }
          }
          localJSONObject = (JSONObject)cg.a(localJSONObject, "pkg");
          j = i;
          if (i != 0)
          {
            j = i;
            if (localJSONObject != null)
            {
              j = i;
              if (!a(paramContext, localJSONObject))
              {
                cl.b("TaijiLocalSchemeManager", "adapter id " + (String)localObject + " pkg not hit");
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
          paramContext = (SolutionItem)ch.a(Base64.decode(paramContext, 2), new SolutionItem(), false);
          if (paramContext != null)
          {
            cl.b("TaijiLocalSchemeManager", "adapterId:" + paramContext.adapterId + ", commSoluId:" + paramContext.commSoluId + ", extSoluId:" + paramContext.extSoluId + ", soluType:" + paramContext.soluType);
            return paramContext;
          }
        }
        return null;
      }
    }
  }
  
  public static j a()
  {
    return l.a();
  }
  
  private List a(Context paramContext, String paramString)
  {
    try
    {
      String str = cj.c();
      int j = Build.VERSION.SDK_INT;
      cl.b("TaijiLocalSchemeManager", "brand:" + str + ", sdk:" + j);
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      cl.b("TaijiLocalSchemeManager", "adapter id count:" + k);
      int i = 0;
      while (i < k)
      {
        SolutionItem localSolutionItem = a(paramContext, (JSONObject)cg.a(paramString, i), str, j);
        if (localSolutionItem != null) {
          localArrayList.add(localSolutionItem);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Throwable paramContext)
    {
      cl.d("TaijiLocalSchemeManager", "parse taiji local scheme file fail!");
    }
    return null;
  }
  
  private void a(Context paramContext, List paramList)
  {
    Object localObject = u.a(paramContext);
    if ((((u)localObject).f()) && (!((u)localObject).g()))
    {
      cl.b("TaijiLocalSchemeManager", "pull cloud scheme finish, ignore local scheme");
      return;
    }
    try
    {
      localObject = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SolutionItem localSolutionItem = (SolutionItem)paramList.next();
        String str = Base64.encodeToString(c.a().a(paramContext, ch.a(localSolutionItem)), 2);
        cl.b("TaijiLocalSchemeManager", str);
        if (!TextUtils.isEmpty(str))
        {
          ((HashMap)localObject).put(Integer.valueOf(localSolutionItem.adapterId), str);
          cl.b("TaijiLocalSchemeManager", "put local scheme to taiji dao, adapter id:" + localSolutionItem.adapterId + ", commSoluId:" + localSolutionItem.commSoluId);
        }
      }
      a.a(paramContext).a((HashMap)localObject, false);
    }
    catch (Throwable paramContext)
    {
      cl.d("TaijiLocalSchemeManager", paramContext.getMessage());
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
            str = cg.b(paramJSONObject, "pkg_exist");
            if ((!TextUtils.isEmpty(str)) && (!ck.a(paramContext, str)))
            {
              cl.b("TaijiLocalSchemeManager", "package:" + str + " not exist, return false");
              return false;
            }
            str = cg.b(paramJSONObject, "pkg_not_exist");
            if ((!TextUtils.isEmpty(str)) && (ck.a(paramContext, str)))
            {
              cl.b("TaijiLocalSchemeManager", "package:" + str + " exist, return false");
              return false;
            }
            str = cg.b(paramJSONObject, "package");
            cl.b("TaijiLocalSchemeManager", "pkg:" + str);
            if (TextUtils.isEmpty(str))
            {
              cl.b("TaijiLocalSchemeManager", "package is null, return true");
              return true;
            }
            if (!ck.a(paramContext, str))
            {
              cl.b("TaijiLocalSchemeManager", "package:" + str + " not exist, return false");
              return false;
            }
            paramContext = ck.b(paramContext, str);
            cl.b("TaijiLocalSchemeManager", "versionName:" + paramContext);
            if (TextUtils.isEmpty(paramContext))
            {
              cl.b("TaijiLocalSchemeManager", "get version name for " + str + " fail, return false");
              return false;
            }
            str = cg.b(paramJSONObject, "versionName_LT");
            cl.b("TaijiLocalSchemeManager", "versionNameLt:" + str);
          } while ((!TextUtils.isEmpty(str)) && (paramContext.compareTo(str) >= 0));
          str = cg.b(paramJSONObject, "versionName_LE");
          cl.b("TaijiLocalSchemeManager", "versionNameLe:" + str);
        } while ((!TextUtils.isEmpty(str)) && (paramContext.compareTo(str) > 0));
        str = cg.b(paramJSONObject, "versionName_MT");
        cl.b("TaijiLocalSchemeManager", "versionNameMt:" + str);
      } while ((!TextUtils.isEmpty(str)) && (paramContext.compareTo(str) <= 0));
      paramJSONObject = cg.b(paramJSONObject, "versionName_ME");
      cl.b("TaijiLocalSchemeManager", "versionNameMe:" + paramJSONObject);
    } while ((!TextUtils.isEmpty(paramJSONObject)) && (paramContext.compareTo(paramJSONObject) < 0));
    return true;
  }
  
  private static boolean a(String paramString)
  {
    String str = cj.a();
    return a(paramString, str + "", ",");
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    cl.b("TaijiLocalSchemeManager", "wholeStr:" + paramString1 + " === matchStr:" + paramString2);
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
    cl.b("TaijiLocalSchemeManager", "startAndLoadScheme, process id:" + Process.myPid() + ", thread id:" + Thread.currentThread().getId());
    Object localObject = c(paramContext);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      cl.b("TaijiLocalSchemeManager", "loadAssetLocalSchemeFile json is null, return");
      return;
    }
    cl.b("TaijiLocalSchemeManager", "loadAssetLocalSchemeFile json:" + (String)localObject);
    localObject = a(paramContext, (String)localObject);
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      cl.b("TaijiLocalSchemeManager", "getSolutionListForPhone result list is empty, return");
      return;
    }
    cl.b("TaijiLocalSchemeManager", "getSolutionListForPhone result list size:" + ((List)localObject).size());
    a(paramContext, (List)localObject);
  }
  
  private static boolean b(String paramString)
  {
    String str = cj.d();
    cl.b("TaijiLocalSchemeManager", "romVersion:" + paramString + ", phoneRomVersion:" + str);
    return a(paramString, str, ",");
  }
  
  private String c(Context paramContext)
  {
    byte[] arrayOfByte = cf.a(paramContext, "zz.dat");
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      cl.b("TaijiLocalSchemeManager", "read asset file zz.dat is null");
      return null;
    }
    cl.b("TaijiLocalSchemeManager", "read asset file zz.dat is not null");
    paramContext = c.a().b(paramContext, arrayOfByte, true);
    if (paramContext == null)
    {
      cl.b("TaijiLocalSchemeManager", "decrypt asset file zz.dat, result is null");
      return null;
    }
    cl.b("TaijiLocalSchemeManager", "decrypt asset file zz.dat, result is not null");
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
    u localu = u.a(paramContext);
    int i = localu.i();
    int j = ck.c(paramContext, paramContext.getPackageName());
    if ((i == 0) || (i != j))
    {
      localu.c(true);
      localu.a(j);
    }
    if (localu.h())
    {
      localu.c(false);
      b(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.j
 * JD-Core Version:    0.7.0.1
 */