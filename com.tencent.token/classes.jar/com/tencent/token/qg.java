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

public final class qg
{
  public static ArrayList<amf> a(Context paramContext, ArrayList<Integer> paramArrayList)
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
        int i = anv.a(((Integer)paramArrayList.next()).intValue());
        if (!localArrayList.contains(Integer.valueOf(i))) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
      paramArrayList = qt.a(paramContext).a.a(localArrayList);
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
            localObject = (amf)any.a(((k)localObject).e, new amf());
            if ((localObject != null) && (((amf)localObject).c != null)) {
              if (!a(paramContext, (amf)localObject))
              {
                qf.a(paramContext, ((amf)localObject).b, 1, 0);
              }
              else
              {
                Pair localPair = b(paramContext, (amf)localObject);
                if (!((Boolean)localPair.first).booleanValue())
                {
                  qf.a(paramContext, ((amf)localObject).b, 1, ((Integer)localPair.second).intValue());
                }
                else
                {
                  qf.a(paramContext, ((amf)localObject).b, 0, ((Integer)localPair.second).intValue());
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
  
  private static boolean a(Context paramContext, PackageManager paramPackageManager, alr paramalr)
  {
    if (paramalr == null) {
      return false;
    }
    Object localObject2 = new Intent();
    if (!TextUtils.isEmpty(paramalr.e)) {
      ((Intent)localObject2).setAction(paramalr.e);
    }
    if (!TextUtils.isEmpty(paramalr.f)) {
      if (!TextUtils.isEmpty(paramalr.b)) {
        ((Intent)localObject2).setClassName(paramalr.f, paramalr.b);
      } else {
        ((Intent)localObject2).setPackage(paramalr.f);
      }
    }
    boolean bool1 = TextUtils.isEmpty(paramalr.g) ^ true;
    boolean bool2 = TextUtils.isEmpty(paramalr.p) ^ true;
    if ((bool1) && (bool2)) {
      ((Intent)localObject2).setDataAndType(Uri.parse(paramalr.g), paramalr.p);
    } else if (bool1) {
      ((Intent)localObject2).setData(Uri.parse(paramalr.g));
    } else if (bool2) {
      ((Intent)localObject2).setType(paramalr.p);
    }
    int i;
    if (paramalr.i != 0) {
      i = paramalr.i;
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
      if ((!paramContext.getPackageName().equals(paramalr.f)) && (!localObject1.activityInfo.exported)) {
        return false;
      }
      return (TextUtils.isEmpty(localObject1.activityInfo.permission)) || (paramPackageManager.checkPermission(localObject1.activityInfo.permission, paramContext.getPackageName()) != -1);
    }
    return false;
  }
  
  static boolean a(Context paramContext, amf paramamf)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Iterator localIterator = paramamf.c.iterator();
    while (localIterator.hasNext())
    {
      alr localalr = (alr)localIterator.next();
      Object localObject;
      if (!TextUtils.isEmpty(localalr.d)) {
        localObject = null;
      }
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(localalr.d, 0);
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
        int i = localPackageManager.getApplicationEnabledSetting(localalr.d);
        if ((i != 2) && (i != 3)) {
          if (i != 4) {
            break;
          }
        }
      }
    }
    return paramamf.c.isEmpty() ^ true;
  }
  
  static Pair<Boolean, Integer> b(Context paramContext, amf paramamf)
  {
    Iterator localIterator = paramamf.c.iterator();
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = 0;
    while (localIterator.hasNext())
    {
      alr localalr = (alr)localIterator.next();
      Object localObject;
      if (localalr.a == 1)
      {
        localObject = localalr.f;
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramamf = null;
        }
      }
      try
      {
        localObject = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        paramamf = (amf)localObject;
      }
      catch (Throwable localThrowable)
      {
        label82:
        break label82;
      }
      int j = i;
      if (paramamf != null) {
        j = paramamf.versionCode;
      }
      i = j;
      if (!a(paramContext, localPackageManager, localalr)) {
        return new Pair(Boolean.FALSE, Integer.valueOf(j));
      }
    }
    return new Pair(Boolean.TRUE, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qg
 * JD-Core Version:    0.7.0.1
 */