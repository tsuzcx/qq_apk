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
    Object localObject1 = paramJSONObject.keys();
    if (localObject1 != null)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return null;
      }
      String str = (String)((Iterator)localObject1).next();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("adapter id:");
      ((StringBuilder)localObject1).append(str);
      bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject1).toString());
      Object localObject2 = (JSONObject)bi.a(paramJSONObject, str);
      localObject1 = (JSONArray)bi.c((JSONObject)localObject2, paramString);
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("adapter id ");
        paramJSONObject.append(str);
        paramJSONObject.append(" not accurate scheme for ");
        paramJSONObject.append(paramString);
        paramJSONObject.append(", try key common scheme");
        bn.b("TaijiLocalSchemeManager", paramJSONObject.toString());
        paramJSONObject = (JSONArray)bi.a((JSONObject)localObject2, "all_brand");
      }
      if (paramJSONObject == null)
      {
        paramContext = new StringBuilder();
        paramContext.append("adapter id ");
        paramContext.append(str);
        paramContext.append(" has no scheme for ");
        paramContext.append(paramString);
        paramContext.append(", abort");
        bn.b("TaijiLocalSchemeManager", paramContext.toString());
        return null;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("adapter id ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" has scheme for ");
      ((StringBuilder)localObject1).append(paramString);
      bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject1).toString());
      bn.b("TaijiLocalSchemeManager", "start to search scheme");
      int m = paramJSONObject.length();
      paramString = new StringBuilder();
      paramString.append("adapter id ");
      paramString.append(str);
      paramString.append(", scheme count:");
      paramString.append(m);
      bn.b("TaijiLocalSchemeManager", paramString.toString());
      int k = 0;
      while (k < m)
      {
        paramString = new StringBuilder();
        paramString.append("adapter id ");
        paramString.append(str);
        paramString.append(", current scheme index:");
        paramString.append(k);
        bn.b("TaijiLocalSchemeManager", paramString.toString());
        localObject1 = (JSONObject)bi.a(paramJSONObject, k);
        if (localObject1 != null)
        {
          paramString = bi.b((JSONObject)localObject1, "scheme");
          localObject2 = bi.b((JSONObject)localObject1, "sdk");
          if (TextUtils.isEmpty(paramString))
          {
            bn.b("TaijiLocalSchemeManager", "scheme is null, abort");
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("scheme:");
            localStringBuilder.append(paramString);
            bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("sdk:");
            localStringBuilder.append((String)localObject2);
            bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!a(paramInt, (String)localObject2)))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("adapter id ");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append(" sdk not hit");
              bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject2).toString());
              j = 0;
            }
            else
            {
              j = 1;
            }
            localObject2 = bi.b((JSONObject)localObject1, "model");
            int i = j;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              i = j;
              if (!a((String)localObject2))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("adapter id ");
                ((StringBuilder)localObject2).append(str);
                ((StringBuilder)localObject2).append(" model not hit");
                bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject2).toString());
                i = 0;
              }
            }
            localObject2 = bi.b((JSONObject)localObject1, "rom_version");
            int j = i;
            if (i != 0)
            {
              j = i;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                j = i;
                if (!b((String)localObject2))
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("adapter id ");
                  localStringBuilder.append((String)localObject2);
                  localStringBuilder.append(" rom version not hit");
                  bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
                  j = 0;
                }
              }
            }
            localObject1 = (JSONObject)bi.a((JSONObject)localObject1, "pkg");
            i = j;
            if (j != 0)
            {
              i = j;
              if (localObject1 != null)
              {
                i = j;
                if (!a(paramContext, (JSONObject)localObject1))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("adapter id ");
                  ((StringBuilder)localObject1).append(str);
                  ((StringBuilder)localObject1).append(" pkg not hit");
                  bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject1).toString());
                  i = 0;
                }
              }
            }
            if (i != 0)
            {
              paramContext = paramString;
              break label857;
            }
          }
        }
        k += 1;
      }
      paramContext = null;
      label857:
      if (!TextUtils.isEmpty(paramContext))
      {
        paramContext = (SolutionItem)bj.a(Base64.decode(paramContext, 2), new SolutionItem(), false);
        if (paramContext != null)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("adapterId:");
          paramJSONObject.append(paramContext.adapterId);
          paramJSONObject.append(", commSoluId:");
          paramJSONObject.append(paramContext.commSoluId);
          paramJSONObject.append(", extSoluId:");
          paramJSONObject.append(paramContext.extSoluId);
          paramJSONObject.append(", soluType:");
          paramJSONObject.append(paramContext.soluType);
          bn.b("TaijiLocalSchemeManager", paramJSONObject.toString());
          return paramContext;
        }
      }
    }
    return null;
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("brand:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(", sdk:");
      ((StringBuilder)localObject1).append(j);
      bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject1).toString());
      localObject1 = new ArrayList();
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("adapter id count:");
      ((StringBuilder)localObject2).append(k);
      bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject2).toString());
      int i = 0;
      while (i < k)
      {
        localObject2 = a(paramContext, (JSONObject)bi.a(paramString, i), str, j);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        i += 1;
      }
      return localObject1;
    }
    catch (Throwable paramContext)
    {
      label172:
      break label172;
    }
    bn.d("TaijiLocalSchemeManager", "parse taiji local scheme file fail!");
    return null;
  }
  
  private void a(Context paramContext, List<SolutionItem> paramList)
  {
    Object localObject1 = i.a(paramContext);
    if ((((i)localObject1).f()) && (!((i)localObject1).g()))
    {
      bn.b("TaijiLocalSchemeManager", "pull cloud scheme finish, ignore local scheme");
      return;
    }
    try
    {
      localObject1 = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SolutionItem localSolutionItem = (SolutionItem)paramList.next();
        Object localObject2 = Base64.encodeToString(b.a().a(paramContext, bj.a(localSolutionItem)), 2);
        bn.b("TaijiLocalSchemeManager", (String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((HashMap)localObject1).put(Integer.valueOf(localSolutionItem.adapterId), localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("put local scheme to taiji dao, adapter id:");
          ((StringBuilder)localObject2).append(localSolutionItem.adapterId);
          ((StringBuilder)localObject2).append(", commSoluId:");
          ((StringBuilder)localObject2).append(localSolutionItem.commSoluId);
          bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject2).toString());
        }
      }
      a.a(paramContext).a((HashMap)localObject1, false);
      return;
    }
    catch (Throwable paramContext)
    {
      bn.d("TaijiLocalSchemeManager", paramContext.getMessage());
    }
  }
  
  private static boolean a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return a(paramString, localStringBuilder.toString(), ",");
  }
  
  private static boolean a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramJSONObject == null) {
      return true;
    }
    Object localObject = bi.b(paramJSONObject, "pkg_exist");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!bm.a(paramContext, (String)localObject)))
    {
      paramContext = new StringBuilder();
      paramJSONObject = (JSONObject)localObject;
      paramContext.append("package:");
      paramContext.append(paramJSONObject);
      localObject = " not exist, return false";
      paramJSONObject = paramContext;
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      paramJSONObject.append(paramContext);
      bn.b("TaijiLocalSchemeManager", paramJSONObject.toString());
      return false;
      localObject = bi.b(paramJSONObject, "pkg_not_exist");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (bm.a(paramContext, (String)localObject)))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("package:");
        paramJSONObject.append((String)localObject);
        paramContext = " exist, return false";
      }
      else
      {
        localObject = bi.b(paramJSONObject, "package");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pkg:");
        localStringBuilder.append((String)localObject);
        bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          bn.b("TaijiLocalSchemeManager", "package is null, return true");
          return true;
        }
        if (!bm.a(paramContext, (String)localObject))
        {
          paramContext = new StringBuilder();
          paramJSONObject = (JSONObject)localObject;
          break;
        }
        paramContext = bm.b(paramContext, (String)localObject);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("versionName:");
        localStringBuilder.append(paramContext);
        bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
        if (!TextUtils.isEmpty(paramContext)) {
          break label286;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("get version name for ");
        paramJSONObject.append((String)localObject);
        paramContext = " fail, return false";
      }
    }
    label286:
    localObject = bi.b(paramJSONObject, "versionName_LT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("versionNameLt:");
    localStringBuilder.append((String)localObject);
    bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramContext.compareTo((String)localObject) >= 0)) {
      return false;
    }
    localObject = bi.b(paramJSONObject, "versionName_LE");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("versionNameLe:");
    localStringBuilder.append((String)localObject);
    bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramContext.compareTo((String)localObject) > 0)) {
      return false;
    }
    localObject = bi.b(paramJSONObject, "versionName_MT");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("versionNameMt:");
    localStringBuilder.append((String)localObject);
    bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramContext.compareTo((String)localObject) <= 0)) {
      return false;
    }
    paramJSONObject = bi.b(paramJSONObject, "versionName_ME");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("versionNameMe:");
    ((StringBuilder)localObject).append(paramJSONObject);
    bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject).toString());
    return (TextUtils.isEmpty(paramJSONObject)) || (paramContext.compareTo(paramJSONObject) >= 0);
  }
  
  private static boolean a(String paramString)
  {
    String str = bl.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("");
    return a(paramString, localStringBuilder.toString(), ",");
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wholeStr:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" === matchStr:");
    localStringBuilder.append(paramString2);
    bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
    }
    try
    {
      paramString1 = paramString1.split(paramString3);
      if (paramString1 != null)
      {
        if (paramString1.length <= 0) {
          return false;
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
      }
      return false;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  private void b(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startAndLoadScheme, process id:");
    ((StringBuilder)localObject).append(Process.myPid());
    ((StringBuilder)localObject).append(", thread id:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    bn.b("TaijiLocalSchemeManager", ((StringBuilder)localObject).toString());
    localObject = c(paramContext);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      bn.b("TaijiLocalSchemeManager", "loadAssetLocalSchemeFile json is null, return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadAssetLocalSchemeFile json:");
    localStringBuilder.append((String)localObject);
    bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
    localObject = a(paramContext, (String)localObject);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSolutionListForPhone result list size:");
      localStringBuilder.append(((List)localObject).size());
      bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
      a(paramContext, (List)localObject);
      return;
    }
    bn.b("TaijiLocalSchemeManager", "getSolutionListForPhone result list is empty, return");
  }
  
  private static boolean b(String paramString)
  {
    String str = bl.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("romVersion:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", phoneRomVersion:");
    localStringBuilder.append(str);
    bn.b("TaijiLocalSchemeManager", localStringBuilder.toString());
    return a(paramString, str, ",");
  }
  
  private String c(Context paramContext)
  {
    byte[] arrayOfByte = bh.a(paramContext, "zz.dat");
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      bn.b("TaijiLocalSchemeManager", "read asset file zz.dat is not null");
      paramContext = b.a().b(paramContext, arrayOfByte, true);
      if (paramContext != null) {}
    }
    for (paramContext = "decrypt asset file zz.dat, result is null";; paramContext = "read asset file zz.dat is null")
    {
      bn.b("TaijiLocalSchemeManager", paramContext);
      return null;
      bn.b("TaijiLocalSchemeManager", "decrypt asset file zz.dat, result is not null");
      try
      {
        paramContext = new String(paramContext, "UTF-8");
        return paramContext;
      }
      catch (Throwable paramContext) {}
    }
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