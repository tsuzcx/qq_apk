package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
{
  public static ArrayList a;
  
  public static ArrayList a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i = b(paramContext);
    if (i > 0)
    {
      paramContext = new Fig();
      paramContext.vc = (dk.c + dk.e);
      paramContext.wc = String.valueOf(i);
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
          for (i = 1; ((bool) || (i != 0)) && (paramString2.contains(db.a(db.l))); i = 0) {
            return true;
          }
        }
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    bool2 = false;
    Object localObject2 = paramContext.getPackageManager();
    label14:
    label17:
    int j;
    if (localObject2 == null)
    {
      break label106;
      bool1 = false;
      j = ed.a(0, bool1, 0);
    }
    label84:
    label106:
    do
    {
      do
      {
        try
        {
          localObject1 = new String(ed.c(db.a(db.m)));
          bool1 = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool1) {
            break label152;
          }
          bool1 = bool2;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            Object localObject1;
            bool1 = bool2;
          }
        }
        return ed.a(j, bool1, 1);
        localObject1 = null;
        try
        {
          localObject2 = ((PackageManager)localObject2).getInstalledApplications(128);
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          ApplicationInfo localApplicationInfo;
          int k;
          int i;
          break label84;
        }
        if (localObject1 == null) {
          break label14;
        }
        localObject2 = db.a(db.k);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label14;
        }
        localApplicationInfo = (ApplicationInfo)((Iterator)localObject1).next();
        if ((localApplicationInfo == null) || (!((String)localObject2).equals(localApplicationInfo.packageName))) {
          break;
        }
        bool1 = true;
        break label17;
        localObject1 = ((String)localObject1).split("\\n");
        bool1 = bool2;
      } while (localObject1 == null);
      bool1 = bool2;
    } while (localObject1.length == 0);
    label152:
    paramContext = paramContext.getPackageName();
    k = localObject1.length;
    i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= k) {
        break;
      }
      bool1 = a(paramContext, localObject1[i]);
      if (bool1)
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.l
 * JD-Core Version:    0.7.0.1
 */