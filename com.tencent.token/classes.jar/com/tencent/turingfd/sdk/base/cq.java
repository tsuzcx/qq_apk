package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.ArrayList;

public class cq
{
  public static ArrayList<Flat> a;
  
  public static ArrayList<Flat> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i = b(paramContext);
    if (i > 0)
    {
      paramContext = new Flat();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(da.c);
      localStringBuilder.append(da.e);
      paramContext.sc = localStringBuilder.toString();
      paramContext.tc = String.valueOf(i);
      localArrayList.add(paramContext);
    }
    return localArrayList;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return false;
    }
    int i = paramString2.indexOf('/');
    if (i == -1) {
      return false;
    }
    String str = paramString2.substring(i).trim();
    if (!str.startsWith("/data/")) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/data/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    if (str.startsWith(localStringBuilder.toString())) {
      return false;
    }
    boolean bool = str.endsWith(".so");
    if ((!bool) && (str.endsWith(".jar"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!bool) && (i == 0)) {
      return false;
    }
    return paramString2.contains(ct.a(ct.m));
  }
  
  public static int b(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    bool2 = false;
    String str;
    if (localObject != null) {
      str = ct.a(ct.l);
    }
    try
    {
      ((PackageManager)localObject).getPackageInfo(str, 128);
      bool1 = true;
    }
    catch (Throwable localThrowable)
    {
      label42:
      int j;
      break label42;
    }
    bool1 = false;
    j = cm.a(0, bool1, 0);
    try
    {
      localObject = new String(cm.c(ct.a(ct.n)));
      bool1 = TextUtils.isEmpty((CharSequence)localObject);
      if (bool1)
      {
        bool1 = bool2;
      }
      else
      {
        localObject = ((String)localObject).split("\\n");
        bool1 = bool2;
        if (localObject != null) {
          if (localObject.length == 0)
          {
            bool1 = bool2;
          }
          else
          {
            paramContext = paramContext.getPackageName();
            int k = localObject.length;
            int i = 0;
            for (;;)
            {
              bool1 = bool2;
              if (i >= k) {
                break;
              }
              bool1 = a(paramContext, localObject[i]);
              if (bool1)
              {
                bool1 = true;
                break;
              }
              i += 1;
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    return cm.a(j, bool1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cq
 * JD-Core Version:    0.7.0.1
 */