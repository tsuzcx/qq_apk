package com.tencent.qqpimsecure.pg;

import Protocol.MMGRAuth.SolutionItem;
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
import com.tencent.qqpimsecure.taiji.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import taiji.bg;
import taiji.bj;

public class b
{
  static ArrayList<taiji.b> a(Context paramContext, ArrayList<Integer> paramArrayList)
  {
    if ((Build.VERSION.SDK_INT >= 8) && (paramArrayList != null))
    {
      if (paramArrayList.isEmpty()) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        int i = bg.a(((Integer)paramArrayList.next()).intValue());
        if (!localArrayList.contains(Integer.valueOf(i))) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
      paramArrayList = g.a(paramContext).b(localArrayList);
      if (paramArrayList != null)
      {
        if (paramArrayList.isEmpty()) {
          return null;
        }
        paramArrayList = paramArrayList.iterator();
        localArrayList = new ArrayList();
        while (paramArrayList.hasNext())
        {
          Object localObject = (SolutionItem)paramArrayList.next();
          if ((localObject != null) && (((SolutionItem)localObject).soluInfo != null))
          {
            localObject = (taiji.b)bj.a(((SolutionItem)localObject).soluInfo, new taiji.b(), false);
            if ((localObject != null) && (((taiji.b)localObject).c != null)) {
              if (!a(paramContext, (taiji.b)localObject))
              {
                a.a(paramContext, ((taiji.b)localObject).b, 1, 0);
              }
              else
              {
                Pair localPair = b(paramContext, (taiji.b)localObject);
                if (!((Boolean)localPair.first).booleanValue())
                {
                  a.a(paramContext, ((taiji.b)localObject).b, 1, ((Integer)localPair.second).intValue());
                }
                else
                {
                  a.a(paramContext, ((taiji.b)localObject).b, 0, ((Integer)localPair.second).intValue());
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
    }
    return null;
  }
  
  public static taiji.b a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    paramInt = bg.a(paramInt);
    Object localObject = g.a(paramContext).a(paramInt);
    if (localObject != null)
    {
      if (((SolutionItem)localObject).soluInfo == null) {
        return null;
      }
      localObject = (taiji.b)bj.a(((SolutionItem)localObject).soluInfo, new taiji.b(), false);
      if (localObject != null)
      {
        if (((taiji.b)localObject).c == null) {
          return null;
        }
        if (!a(paramContext, (taiji.b)localObject))
        {
          a.a(paramContext, paramInt, 1, 0);
          return null;
        }
        Pair localPair = b(paramContext, (taiji.b)localObject);
        if (!((Boolean)localPair.first).booleanValue())
        {
          a.a(paramContext, paramInt, 1, ((Integer)localPair.second).intValue());
          return null;
        }
        a.a(paramContext, paramInt, 0, ((Integer)localPair.second).intValue());
        return localObject;
      }
    }
    return null;
  }
  
  private static boolean a(Context paramContext, PackageManager paramPackageManager, taiji.a parama)
  {
    if (parama == null) {
      return false;
    }
    Object localObject2 = new Intent();
    if (!TextUtils.isEmpty(parama.e)) {
      ((Intent)localObject2).setAction(parama.e);
    }
    if (!TextUtils.isEmpty(parama.f)) {
      if (!TextUtils.isEmpty(parama.b)) {
        ((Intent)localObject2).setClassName(parama.f, parama.b);
      } else {
        ((Intent)localObject2).setPackage(parama.f);
      }
    }
    boolean bool1 = TextUtils.isEmpty(parama.g) ^ true;
    boolean bool2 = TextUtils.isEmpty(parama.p) ^ true;
    if ((bool1) && (bool2)) {
      ((Intent)localObject2).setDataAndType(Uri.parse(parama.g), parama.p);
    } else if ((bool1) && (!bool2)) {
      ((Intent)localObject2).setData(Uri.parse(parama.g));
    } else if ((!bool1) && (bool2)) {
      ((Intent)localObject2).setType(parama.p);
    }
    int i;
    if (parama.i != 0) {
      i = parama.i;
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
      label217:
      break label217;
    }
    if (localObject1 != null)
    {
      if (localObject1.activityInfo == null) {
        return false;
      }
      if ((!paramContext.getPackageName().equals(parama.f)) && (!localObject1.activityInfo.exported)) {
        return false;
      }
      return (TextUtils.isEmpty(localObject1.activityInfo.permission)) || (paramPackageManager.checkPermission(localObject1.activityInfo.permission, paramContext.getPackageName()) != -1);
    }
    return false;
  }
  
  private static boolean a(Context paramContext, taiji.b paramb)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Iterator localIterator = paramb.c.iterator();
    while (localIterator.hasNext())
    {
      taiji.a locala = (taiji.a)localIterator.next();
      Object localObject;
      if (!TextUtils.isEmpty(locala.d)) {
        localObject = null;
      }
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(locala.d, 0);
        localObject = localPackageInfo;
      }
      catch (Throwable localThrowable)
      {
        label71:
        break label71;
      }
      if (localObject == null) {}
      for (;;)
      {
        localIterator.remove();
        break;
        int i = localPackageManager.getApplicationEnabledSetting(locala.d);
        if ((i != 2) && (i != 3)) {
          if (i != 4) {
            break;
          }
        }
      }
    }
    return paramb.c.isEmpty() ^ true;
  }
  
  private static Pair<Boolean, Integer> b(Context paramContext, taiji.b paramb)
  {
    Iterator localIterator = paramb.c.iterator();
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = 0;
    while (localIterator.hasNext())
    {
      taiji.a locala = (taiji.a)localIterator.next();
      Object localObject;
      if (locala.a == 1)
      {
        localObject = locala.f;
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramb = null;
        }
      }
      try
      {
        localObject = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        paramb = (taiji.b)localObject;
      }
      catch (Throwable localThrowable)
      {
        label82:
        break label82;
      }
      int j = i;
      if (paramb != null) {
        j = paramb.versionCode;
      }
      i = j;
      if (!a(paramContext, localPackageManager, locala)) {
        return new Pair(Boolean.valueOf(false), Integer.valueOf(j));
      }
    }
    return new Pair(Boolean.valueOf(true), Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.b
 * JD-Core Version:    0.7.0.1
 */