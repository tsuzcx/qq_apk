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

public final class qn
{
  public static ArrayList<aoc> a(Context paramContext, ArrayList<Integer> paramArrayList)
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
        int i = aps.a(((Integer)paramArrayList.next()).intValue());
        if (!localArrayList.contains(Integer.valueOf(i))) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
      paramArrayList = ra.a(paramContext).a.a(localArrayList);
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
            localObject = (aoc)apv.a(((k)localObject).e, new aoc());
            if ((localObject != null) && (((aoc)localObject).c != null)) {
              if (!a(paramContext, (aoc)localObject))
              {
                qm.a(paramContext, ((aoc)localObject).b, 1, 0);
              }
              else
              {
                Pair localPair = b(paramContext, (aoc)localObject);
                if (!((Boolean)localPair.first).booleanValue())
                {
                  qm.a(paramContext, ((aoc)localObject).b, 1, ((Integer)localPair.second).intValue());
                }
                else
                {
                  qm.a(paramContext, ((aoc)localObject).b, 0, ((Integer)localPair.second).intValue());
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
  
  private static boolean a(Context paramContext, PackageManager paramPackageManager, ano paramano)
  {
    if (paramano == null) {
      return false;
    }
    Object localObject2 = new Intent();
    if (!TextUtils.isEmpty(paramano.e)) {
      ((Intent)localObject2).setAction(paramano.e);
    }
    if (!TextUtils.isEmpty(paramano.f)) {
      if (!TextUtils.isEmpty(paramano.b)) {
        ((Intent)localObject2).setClassName(paramano.f, paramano.b);
      } else {
        ((Intent)localObject2).setPackage(paramano.f);
      }
    }
    boolean bool1 = TextUtils.isEmpty(paramano.g) ^ true;
    boolean bool2 = TextUtils.isEmpty(paramano.p) ^ true;
    if ((bool1) && (bool2)) {
      ((Intent)localObject2).setDataAndType(Uri.parse(paramano.g), paramano.p);
    } else if (bool1) {
      ((Intent)localObject2).setData(Uri.parse(paramano.g));
    } else if (bool2) {
      ((Intent)localObject2).setType(paramano.p);
    }
    int i;
    if (paramano.i != 0) {
      i = paramano.i;
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
      if ((!paramContext.getPackageName().equals(paramano.f)) && (!localObject1.activityInfo.exported)) {
        return false;
      }
      return (TextUtils.isEmpty(localObject1.activityInfo.permission)) || (paramPackageManager.checkPermission(localObject1.activityInfo.permission, paramContext.getPackageName()) != -1);
    }
    return false;
  }
  
  static boolean a(Context paramContext, aoc paramaoc)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Iterator localIterator = paramaoc.c.iterator();
    while (localIterator.hasNext())
    {
      ano localano = (ano)localIterator.next();
      Object localObject;
      if (!TextUtils.isEmpty(localano.d)) {
        localObject = null;
      }
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(localano.d, 0);
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
        int i = localPackageManager.getApplicationEnabledSetting(localano.d);
        if ((i != 2) && (i != 3)) {
          if (i != 4) {
            break;
          }
        }
      }
    }
    return paramaoc.c.isEmpty() ^ true;
  }
  
  static Pair<Boolean, Integer> b(Context paramContext, aoc paramaoc)
  {
    Iterator localIterator = paramaoc.c.iterator();
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = 0;
    while (localIterator.hasNext())
    {
      ano localano = (ano)localIterator.next();
      Object localObject;
      if (localano.a == 1)
      {
        localObject = localano.f;
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramaoc = null;
        }
      }
      try
      {
        localObject = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        paramaoc = (aoc)localObject;
      }
      catch (Throwable localThrowable)
      {
        label82:
        break label82;
      }
      int j = i;
      if (paramaoc != null) {
        j = paramaoc.versionCode;
      }
      i = j;
      if (!a(paramContext, localPackageManager, localano)) {
        return new Pair(Boolean.FALSE, Integer.valueOf(j));
      }
    }
    return new Pair(Boolean.TRUE, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qn
 * JD-Core Version:    0.7.0.1
 */