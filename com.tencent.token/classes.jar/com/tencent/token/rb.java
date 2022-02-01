package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class rb
{
  public static ArrayList<apa> a(Context paramContext, ArrayList<Integer> paramArrayList)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      if (paramArrayList.isEmpty()) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        int i = aqq.a(((Integer)paramArrayList.next()).intValue());
        if (!localArrayList.contains(Integer.valueOf(i))) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
      paramArrayList = ro.a(paramContext).a.a(localArrayList);
      if (paramArrayList != null)
      {
        if (paramArrayList.isEmpty()) {
          return null;
        }
        paramArrayList = paramArrayList.iterator();
        localArrayList = new ArrayList();
        while (paramArrayList.hasNext())
        {
          Object localObject = (k)paramArrayList.next();
          if ((localObject != null) && (((k)localObject).e != null))
          {
            localObject = (apa)aqt.a(((k)localObject).e, new apa());
            if ((localObject != null) && (((apa)localObject).c != null)) {
              if (!a(paramContext, (apa)localObject))
              {
                ra.a(paramContext, ((apa)localObject).b, 1, 0);
              }
              else
              {
                Pair localPair = b(paramContext, (apa)localObject);
                if (!((Boolean)localPair.first).booleanValue())
                {
                  ra.a(paramContext, ((apa)localObject).b, 1, ((Integer)localPair.second).intValue());
                }
                else
                {
                  ra.a(paramContext, ((apa)localObject).b, 0, ((Integer)localPair.second).intValue());
                  localArrayList.add(localObject);
                  continue;
                }
              }
            }
          }
          paramArrayList.remove();
        }
        return localArrayList;
      }
      return null;
    }
    return null;
  }
  
  private static boolean a(Context paramContext, PackageManager paramPackageManager, aom paramaom)
  {
    if (paramaom == null) {
      return false;
    }
    Object localObject2 = new Intent();
    if (!TextUtils.isEmpty(paramaom.e)) {
      ((Intent)localObject2).setAction(paramaom.e);
    }
    if (!TextUtils.isEmpty(paramaom.f)) {
      if (!TextUtils.isEmpty(paramaom.b)) {
        ((Intent)localObject2).setClassName(paramaom.f, paramaom.b);
      } else {
        ((Intent)localObject2).setPackage(paramaom.f);
      }
    }
    boolean bool1 = TextUtils.isEmpty(paramaom.g) ^ true;
    boolean bool2 = TextUtils.isEmpty(paramaom.p) ^ true;
    if ((bool1) && (bool2)) {
      ((Intent)localObject2).setDataAndType(Uri.parse(paramaom.g), paramaom.p);
    } else if (bool1) {
      ((Intent)localObject2).setData(Uri.parse(paramaom.g));
    } else if (bool2) {
      ((Intent)localObject2).setType(paramaom.p);
    }
    int i;
    if (paramaom.i != 0) {
      i = paramaom.i;
    } else {
      i = 1350926336;
    }
    ((Intent)localObject2).setFlags(i);
    Object localObject1 = null;
    try
    {
      localObject2 = paramPackageManager.resolveActivity((Intent)localObject2, 0);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      label208:
      break label208;
    }
    if (localObject1 != null)
    {
      if (localObject1.activityInfo == null) {
        return false;
      }
      if ((!paramContext.getPackageName().equals(paramaom.f)) && (!localObject1.activityInfo.exported)) {
        return false;
      }
      return (TextUtils.isEmpty(localObject1.activityInfo.permission)) || (paramPackageManager.checkPermission(localObject1.activityInfo.permission, paramContext.getPackageName()) != -1);
    }
    return false;
  }
  
  static boolean a(Context paramContext, apa paramapa)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Iterator localIterator = paramapa.c.iterator();
    while (localIterator.hasNext())
    {
      aom localaom = (aom)localIterator.next();
      Object localObject;
      if (!TextUtils.isEmpty(localaom.d)) {
        localObject = null;
      }
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(localaom.d, 0);
        localObject = localPackageInfo;
      }
      catch (Throwable localThrowable)
      {
        label68:
        break label68;
      }
      if (localObject == null) {}
      for (;;)
      {
        localIterator.remove();
        break;
        int i = localPackageManager.getApplicationEnabledSetting(localaom.d);
        if ((i != 2) && (i != 3)) {
          if (i != 4) {
            break;
          }
        }
      }
    }
    return paramapa.c.isEmpty() ^ true;
  }
  
  static Pair<Boolean, Integer> b(Context paramContext, apa paramapa)
  {
    Iterator localIterator = paramapa.c.iterator();
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = 0;
    while (localIterator.hasNext())
    {
      aom localaom = (aom)localIterator.next();
      Object localObject;
      if (localaom.a == 1)
      {
        localObject = localaom.f;
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramapa = null;
        }
      }
      try
      {
        localObject = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        paramapa = (apa)localObject;
      }
      catch (Throwable localThrowable)
      {
        label82:
        break label82;
      }
      int j = i;
      if (paramapa != null) {
        j = paramapa.versionCode;
      }
      i = j;
      if (!a(paramContext, localPackageManager, localaom)) {
        return new Pair(Boolean.FALSE, Integer.valueOf(j));
      }
    }
    return new Pair(Boolean.TRUE, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rb
 * JD-Core Version:    0.7.0.1
 */