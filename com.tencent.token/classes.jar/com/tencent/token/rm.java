package com.tencent.token;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class rm
{
  private static k a(Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt)
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
      "adapter id:".concat(String.valueOf(str));
      aqx.b();
      Object localObject2 = (JSONObject)aqs.a(paramJSONObject, str);
      if ((localObject2 != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramJSONObject = ((JSONObject)localObject2).keys();
        if (paramJSONObject != null) {
          while (paramJSONObject.hasNext())
          {
            localObject1 = (String)paramJSONObject.next();
            if (paramString.equalsIgnoreCase((String)localObject1))
            {
              paramJSONObject = aqs.a((JSONObject)localObject2, (String)localObject1);
              break label133;
            }
          }
        }
      }
      paramJSONObject = null;
      label133:
      paramJSONObject = (JSONArray)paramJSONObject;
      localObject1 = paramJSONObject;
      if (paramJSONObject == null)
      {
        paramJSONObject = new StringBuilder("adapter id ");
        paramJSONObject.append(str);
        paramJSONObject.append(" not accurate scheme for ");
        paramJSONObject.append(paramString);
        paramJSONObject.append(", try key common scheme");
        aqx.b();
        localObject1 = (JSONArray)aqs.a((JSONObject)localObject2, "all_brand");
      }
      if (localObject1 == null)
      {
        paramContext = new StringBuilder("adapter id ");
        paramContext.append(str);
        paramContext.append(" has no scheme for ");
        paramContext.append(paramString);
        paramContext.append(", abort");
        aqx.b();
        return null;
      }
      paramJSONObject = new StringBuilder("adapter id ");
      paramJSONObject.append(str);
      paramJSONObject.append(" has scheme for ");
      paramJSONObject.append(paramString);
      aqx.b();
      aqx.b();
      int i1 = ((JSONArray)localObject1).length();
      paramJSONObject = new StringBuilder("adapter id ");
      paramJSONObject.append(str);
      paramJSONObject.append(", scheme count:");
      paramJSONObject.append(i1);
      aqx.b();
      int k = 0;
      while (k < i1)
      {
        paramJSONObject = new StringBuilder("adapter id ");
        paramJSONObject.append(str);
        paramJSONObject.append(", current scheme index:");
        paramJSONObject.append(k);
        aqx.b();
        paramJSONObject = (JSONObject)aqs.a((JSONArray)localObject1, k);
        if (paramJSONObject != null)
        {
          localObject2 = aqs.b(paramJSONObject, "scheme");
          paramString = aqs.b(paramJSONObject, "sdk");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            aqx.b();
          }
          else
          {
            "scheme:".concat(String.valueOf(localObject2));
            aqx.b();
            "sdk:".concat(String.valueOf(paramString));
            aqx.b();
            boolean bool = TextUtils.isEmpty(paramString);
            int n = 1;
            if ((!bool) && (!a(paramString, String.valueOf(paramInt), ",")))
            {
              paramString = new StringBuilder("adapter id ");
              paramString.append(str);
              paramString.append(" sdk not hit");
              aqx.b();
              i = 0;
            }
            else
            {
              i = 1;
            }
            paramString = aqs.b(paramJSONObject, "model");
            int j = i;
            if (!TextUtils.isEmpty(paramString))
            {
              j = i;
              if (!a(paramString, String.valueOf(yd.a), ","))
              {
                paramString = new StringBuilder("adapter id ");
                paramString.append(str);
                paramString.append(" model not hit");
                aqx.b();
                j = 0;
              }
            }
            paramString = aqs.b(paramJSONObject, "rom_version");
            int i = j;
            Object localObject3;
            if (j != 0)
            {
              i = j;
              if (!TextUtils.isEmpty(paramString))
              {
                localObject3 = aqv.b();
                StringBuilder localStringBuilder = new StringBuilder("romVersion:");
                localStringBuilder.append(paramString);
                localStringBuilder.append(", phoneRomVersion:");
                localStringBuilder.append((String)localObject3);
                aqx.b();
                i = j;
                if (!a(paramString, (String)localObject3, ","))
                {
                  localObject3 = new StringBuilder("adapter id ");
                  ((StringBuilder)localObject3).append(paramString);
                  ((StringBuilder)localObject3).append(" rom version not hit");
                  aqx.b();
                  i = 0;
                }
              }
            }
            paramJSONObject = (JSONObject)aqs.a(paramJSONObject, "pkg");
            int m = i;
            if (i != 0)
            {
              m = i;
              if (paramJSONObject != null)
              {
                if (paramContext == null) {}
                label759:
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        j = 0;
                        break;
                        j = n;
                        if (paramJSONObject == null) {
                          break;
                        }
                        paramString = aqs.b(paramJSONObject, "pkg_exist");
                        if ((!TextUtils.isEmpty(paramString)) && (!aqw.a(paramContext, paramString)))
                        {
                          paramJSONObject = new StringBuilder("package:");
                          paramJSONObject.append(paramString);
                          paramString = " not exist, return false";
                        }
                        for (;;)
                        {
                          paramJSONObject.append(paramString);
                          aqx.b();
                          break;
                          paramString = aqs.b(paramJSONObject, "pkg_not_exist");
                          if ((!TextUtils.isEmpty(paramString)) && (aqw.a(paramContext, paramString)))
                          {
                            paramJSONObject = new StringBuilder("package:");
                            paramJSONObject.append(paramString);
                            paramString = " exist, return false";
                          }
                          else
                          {
                            paramString = aqs.b(paramJSONObject, "package");
                            "pkg:".concat(String.valueOf(paramString));
                            aqx.b();
                            if (TextUtils.isEmpty(paramString))
                            {
                              aqx.b();
                              j = n;
                              break label1097;
                            }
                            if (!aqw.a(paramContext, paramString))
                            {
                              paramJSONObject = new StringBuilder("package:");
                              break label759;
                            }
                            localObject3 = aqw.b(paramContext, paramString);
                            "versionName:".concat(String.valueOf(localObject3));
                            aqx.b();
                            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                              break label933;
                            }
                            paramJSONObject = new StringBuilder("get version name for ");
                            paramJSONObject.append(paramString);
                            paramString = " fail, return false";
                          }
                        }
                        paramString = aqs.b(paramJSONObject, "versionName_LT");
                        "versionNameLt:".concat(String.valueOf(paramString));
                        aqx.b();
                      } while ((!TextUtils.isEmpty(paramString)) && (((String)localObject3).compareTo(paramString) >= 0));
                      paramString = aqs.b(paramJSONObject, "versionName_LE");
                      "versionNameLe:".concat(String.valueOf(paramString));
                      aqx.b();
                    } while ((!TextUtils.isEmpty(paramString)) && (((String)localObject3).compareTo(paramString) > 0));
                    paramString = aqs.b(paramJSONObject, "versionName_MT");
                    "versionNameMt:".concat(String.valueOf(paramString));
                    aqx.b();
                  } while ((!TextUtils.isEmpty(paramString)) && (((String)localObject3).compareTo(paramString) <= 0));
                  paramJSONObject = aqs.b(paramJSONObject, "versionName_ME");
                  "versionNameMe:".concat(String.valueOf(paramJSONObject));
                  aqx.b();
                  j = n;
                  if (TextUtils.isEmpty(paramJSONObject)) {
                    break;
                  }
                  j = n;
                } while (((String)localObject3).compareTo(paramJSONObject) < 0);
                label933:
                label1097:
                m = i;
                if (j == 0)
                {
                  paramJSONObject = new StringBuilder("adapter id ");
                  paramJSONObject.append(str);
                  paramJSONObject.append(" pkg not hit");
                  aqx.b();
                  m = 0;
                }
              }
            }
            if (m != 0)
            {
              paramContext = (Context)localObject2;
              break label1158;
            }
          }
        }
        k += 1;
      }
      paramContext = null;
      label1158:
      if (!TextUtils.isEmpty(paramContext))
      {
        paramContext = (k)aqt.a(Base64.decode(paramContext, 2), new k());
        if (paramContext != null)
        {
          paramJSONObject = new StringBuilder("adapterId:");
          paramJSONObject.append(paramContext.d);
          paramJSONObject.append(", commSoluId:");
          paramJSONObject.append(paramContext.a);
          paramJSONObject.append(", extSoluId:");
          paramJSONObject.append(paramContext.b);
          paramJSONObject.append(", soluType:");
          paramJSONObject.append(paramContext.c);
          aqx.b();
          return paramContext;
        }
      }
      return null;
    }
    return null;
  }
  
  static String a(Context paramContext)
  {
    byte[] arrayOfByte = aqr.a(paramContext, "zz.dat");
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      aqx.b();
      paramContext = rj.a.a().a(paramContext, arrayOfByte, true);
      if (paramContext == null)
      {
        aqx.b();
        return null;
      }
      aqx.b();
    }
    try
    {
      paramContext = new String(paramContext, "UTF-8");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    aqx.b();
    return null;
    return null;
  }
  
  static List<k> a(Context paramContext, String paramString)
  {
    try
    {
      if (!sj.a().b())
      {
        localObject1 = "UNKNOWN";
        break label80;
      }
      localObject1 = Build.BRAND;
      if ("BBK".equalsIgnoreCase((String)localObject1)) {
        break label221;
      }
      localObject2 = localObject1;
      if (!"bbk".equalsIgnoreCase((String)localObject1)) {}
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        label80:
        int j;
        int k;
        int i;
        continue;
        label221:
        Object localObject2 = "vivo";
        continue;
        Object localObject1 = "huawei";
      }
    }
    if (!"HONOR".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (!"honor".equalsIgnoreCase((String)localObject2))
      {
        j = Build.VERSION.SDK_INT;
        localObject2 = new StringBuilder("brand:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", sdk:");
        ((StringBuilder)localObject2).append(j);
        aqx.b();
        localObject2 = new ArrayList();
        paramString = new JSONArray(paramString);
        k = paramString.length();
        "adapter id count:".concat(String.valueOf(k));
        aqx.b();
        i = 0;
        while (i < k)
        {
          k localk = a(paramContext, (JSONObject)aqs.a(paramString, i), (String)localObject1, j);
          if (localk != null) {
            ((List)localObject2).add(localk);
          }
          i += 1;
        }
        return localObject2;
        aqx.d();
        return null;
      }
    }
  }
  
  static void a(Context paramContext, List<k> paramList)
  {
    rq.a(paramContext);
    if ((rq.b()) && (!rq.d()))
    {
      aqx.b();
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        k localk = (k)paramList.next();
        Object localObject = Base64.encodeToString(rj.a.a().a(paramContext, aqt.a(localk)), 2);
        aqx.b();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localHashMap.put(Integer.valueOf(localk.d), localObject);
          localObject = new StringBuilder("put local scheme to taiji dao, adapter id:");
          ((StringBuilder)localObject).append(localk.d);
          ((StringBuilder)localObject).append(", commSoluId:");
          ((StringBuilder)localObject).append(localk.a);
          aqx.b();
        }
      }
      ri.a(paramContext).a(localHashMap, false);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.getMessage();
      aqx.d();
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder("wholeStr:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" === matchStr:");
    localStringBuilder.append(paramString2);
    aqx.b();
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
  
  static final class a
  {
    private static final rm a = new rm((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rm
 * JD-Core Version:    0.7.0.1
 */