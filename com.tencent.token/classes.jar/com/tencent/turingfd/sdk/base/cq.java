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
      paramContext.sc = (da.c + da.e);
      paramContext.tc = String.valueOf(i);
      localArrayList.add(paramContext);
    }
    return localArrayList;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      return false;
      int i = paramString2.indexOf('/');
      if (i != -1)
      {
        String str = paramString2.substring(i).trim();
        if ((str.startsWith("/data/")) && (!str.startsWith("/data/data/" + paramString1 + "/")))
        {
          boolean bool = str.endsWith(".so");
          if ((!bool) && (str.endsWith(".jar"))) {}
          for (i = 1; ((bool) || (i != 0)) && (paramString2.contains(ct.a(ct.m))); i = 0) {
            return true;
          }
        }
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    bool2 = false;
    Object localObject = paramContext.getPackageManager();
    if (localObject == null) {}
    for (;;)
    {
      bool1 = false;
      int j = cm.a(0, bool1, 0);
      do
      {
        do
        {
          for (;;)
          {
            try
            {
              localObject = new String(cm.c(ct.a(ct.n)));
              bool1 = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool1) {
                continue;
              }
              bool1 = bool2;
            }
            catch (Throwable paramContext)
            {
              String str;
              int k;
              int i;
              bool1 = bool2;
              continue;
            }
            return cm.a(j, bool1, 1);
            str = ct.a(ct.l);
            try
            {
              ((PackageManager)localObject).getPackageInfo(str, 128);
              bool1 = true;
            }
            catch (Throwable localThrowable) {}
          }
          localObject = ((String)localObject).split("\\n");
          bool1 = bool2;
        } while (localObject == null);
        bool1 = bool2;
      } while (localObject.length == 0);
      paramContext = paramContext.getPackageName();
      k = localObject.length;
      i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cq
 * JD-Core Version:    0.7.0.1
 */