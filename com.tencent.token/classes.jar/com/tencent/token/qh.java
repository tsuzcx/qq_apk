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

public final class qh
{
  public static ArrayList<amg> a(Context paramContext, ArrayList<Integer> paramArrayList)
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
        int i = anw.a(((Integer)paramArrayList.next()).intValue());
        if (!localArrayList.contains(Integer.valueOf(i))) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
      paramArrayList = qu.a(paramContext).a.a(localArrayList);
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
            localObject = (amg)anz.a(((k)localObject).e, new amg());
            if ((localObject != null) && (((amg)localObject).c != null)) {
              if (!a(paramContext, (amg)localObject))
              {
                qg.a(paramContext, ((amg)localObject).b, 1, 0);
              }
              else
              {
                Pair localPair = b(paramContext, (amg)localObject);
                if (!((Boolean)localPair.first).booleanValue())
                {
                  qg.a(paramContext, ((amg)localObject).b, 1, ((Integer)localPair.second).intValue());
                }
                else
                {
                  qg.a(paramContext, ((amg)localObject).b, 0, ((Integer)localPair.second).intValue());
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
  
  private static boolean a(Context paramContext, PackageManager paramPackageManager, als paramals)
  {
    if (paramals == null) {
      return false;
    }
    Object localObject2 = new Intent();
    if (!TextUtils.isEmpty(paramals.e)) {
      ((Intent)localObject2).setAction(paramals.e);
    }
    if (!TextUtils.isEmpty(paramals.f)) {
      if (!TextUtils.isEmpty(paramals.b)) {
        ((Intent)localObject2).setClassName(paramals.f, paramals.b);
      } else {
        ((Intent)localObject2).setPackage(paramals.f);
      }
    }
    boolean bool1 = TextUtils.isEmpty(paramals.g) ^ true;
    boolean bool2 = TextUtils.isEmpty(paramals.p) ^ true;
    if ((bool1) && (bool2)) {
      ((Intent)localObject2).setDataAndType(Uri.parse(paramals.g), paramals.p);
    } else if (bool1) {
      ((Intent)localObject2).setData(Uri.parse(paramals.g));
    } else if (bool2) {
      ((Intent)localObject2).setType(paramals.p);
    }
    int i;
    if (paramals.i != 0) {
      i = paramals.i;
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
      if ((!paramContext.getPackageName().equals(paramals.f)) && (!localObject1.activityInfo.exported)) {
        return false;
      }
      return (TextUtils.isEmpty(localObject1.activityInfo.permission)) || (paramPackageManager.checkPermission(localObject1.activityInfo.permission, paramContext.getPackageName()) != -1);
    }
    return false;
  }
  
  static boolean a(Context paramContext, amg paramamg)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Iterator localIterator = paramamg.c.iterator();
    while (localIterator.hasNext())
    {
      als localals = (als)localIterator.next();
      Object localObject;
      if (!TextUtils.isEmpty(localals.d)) {
        localObject = null;
      }
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(localals.d, 0);
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
        int i = localPackageManager.getApplicationEnabledSetting(localals.d);
        if ((i != 2) && (i != 3)) {
          if (i != 4) {
            break;
          }
        }
      }
    }
    return paramamg.c.isEmpty() ^ true;
  }
  
  static Pair<Boolean, Integer> b(Context paramContext, amg paramamg)
  {
    Iterator localIterator = paramamg.c.iterator();
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = 0;
    while (localIterator.hasNext())
    {
      als localals = (als)localIterator.next();
      Object localObject;
      if (localals.a == 1)
      {
        localObject = localals.f;
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramamg = null;
        }
      }
      try
      {
        localObject = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        paramamg = (amg)localObject;
      }
      catch (Throwable localThrowable)
      {
        label82:
        break label82;
      }
      int j = i;
      if (paramamg != null) {
        j = paramamg.versionCode;
      }
      i = j;
      if (!a(paramContext, localPackageManager, localals)) {
        return new Pair(Boolean.FALSE, Integer.valueOf(j));
      }
    }
    return new Pair(Boolean.TRUE, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qh
 * JD-Core Version:    0.7.0.1
 */