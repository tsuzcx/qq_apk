package com.tencent.token;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.Flat;
import java.util.ArrayList;

public final class afc
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
      localStringBuilder.append(afm.c);
      localStringBuilder.append(afm.e);
      paramContext.sc = localStringBuilder.toString();
      paramContext.tc = String.valueOf(i);
      localArrayList.add(paramContext);
    }
    return localArrayList;
  }
  
  public static int b(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    bool2 = false;
    String str;
    if (localObject1 != null) {
      str = aff.a(aff.l);
    }
    try
    {
      ((PackageManager)localObject1).getPackageInfo(str, 128);
      bool1 = true;
    }
    catch (Throwable localThrowable)
    {
      label42:
      int k;
      break label42;
    }
    bool1 = false;
    k = aey.a(0, bool1, 0);
    try
    {
      localObject1 = new String(aey.c(aff.a(aff.n)));
      boolean bool3 = TextUtils.isEmpty((CharSequence)localObject1);
      bool1 = bool2;
      if (bool3) {
        break label289;
      }
      localObject1 = ((String)localObject1).split("\\n");
      bool1 = bool2;
      if (localObject1 == null) {
        break label289;
      }
      bool1 = bool2;
      if (localObject1.length == 0) {
        break label289;
      }
      paramContext = paramContext.getPackageName();
      m = localObject1.length;
      j = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int m;
        int j;
        Object localObject2;
        int i;
        StringBuilder localStringBuilder;
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (j < m)
        {
          localObject2 = localThrowable[j];
          if (localObject2 == null)
          {
            i = 0;
            continue;
            i = 0;
            if ((!bool1) && (i == 0)) {
              i = 0;
            }
          }
        }
      }
    }
    i = localObject2.indexOf('/');
    if (i == -1)
    {
      i = 0;
    }
    else
    {
      str = localObject2.substring(i).trim();
      if (!str.startsWith("/data/"))
      {
        i = 0;
      }
      else
      {
        localStringBuilder = new StringBuilder("/data/data/");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("/");
        if (str.startsWith(localStringBuilder.toString()))
        {
          i = 0;
        }
        else
        {
          bool1 = str.endsWith(".so");
          if ((bool1) || (!str.endsWith(".jar"))) {
            break label336;
          }
          i = 1;
          break label338;
          bool1 = localObject2.contains(aff.a(aff.m));
          if (bool1) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
    if (i != 0)
    {
      bool1 = true;
    }
    else
    {
      j += 1;
      break label310;
    }
    label289:
    return aey.a(k, bool1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afc
 * JD-Core Version:    0.7.0.1
 */