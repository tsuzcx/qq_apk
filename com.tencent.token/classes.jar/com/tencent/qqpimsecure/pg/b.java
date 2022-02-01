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
    if ((Build.VERSION.SDK_INT < 8) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
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
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    localArrayList = new ArrayList();
    while (paramArrayList.hasNext())
    {
      Object localObject = (SolutionItem)paramArrayList.next();
      if ((localObject == null) || (((SolutionItem)localObject).soluInfo == null))
      {
        paramArrayList.remove();
      }
      else
      {
        localObject = (taiji.b)bj.a(((SolutionItem)localObject).soluInfo, new taiji.b(), false);
        if ((localObject == null) || (((taiji.b)localObject).c == null))
        {
          paramArrayList.remove();
        }
        else if (!a(paramContext, (taiji.b)localObject))
        {
          a.a(paramContext, ((taiji.b)localObject).b, 1, 0);
          paramArrayList.remove();
        }
        else
        {
          Pair localPair = b(paramContext, (taiji.b)localObject);
          if (!((Boolean)localPair.first).booleanValue())
          {
            a.a(paramContext, ((taiji.b)localObject).b, 1, ((Integer)localPair.second).intValue());
            paramArrayList.remove();
          }
          else
          {
            a.a(paramContext, ((taiji.b)localObject).b, 0, ((Integer)localPair.second).intValue());
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static taiji.b a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    paramInt = bg.a(paramInt);
    Object localObject = g.a(paramContext).a(paramInt);
    if ((localObject == null) || (((SolutionItem)localObject).soluInfo == null)) {
      return null;
    }
    localObject = (taiji.b)bj.a(((SolutionItem)localObject).soluInfo, new taiji.b(), false);
    if ((localObject == null) || (((taiji.b)localObject).c == null)) {
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
  
  private static boolean a(Context paramContext, PackageManager paramPackageManager, taiji.a parama)
  {
    if (parama == null) {
      return false;
    }
    Object localObject2 = new Intent();
    if (!TextUtils.isEmpty(parama.e)) {
      ((Intent)localObject2).setAction(parama.e);
    }
    label69:
    int i;
    label81:
    int j;
    if (!TextUtils.isEmpty(parama.f))
    {
      if (!TextUtils.isEmpty(parama.b)) {
        ((Intent)localObject2).setClassName(parama.f, parama.b);
      }
    }
    else
    {
      if (TextUtils.isEmpty(parama.g)) {
        break label240;
      }
      i = 1;
      if (TextUtils.isEmpty(parama.p)) {
        break label245;
      }
      j = 1;
      label94:
      if ((i == 0) || (j == 0)) {
        break label251;
      }
      ((Intent)localObject2).setDataAndType(Uri.parse(parama.g), parama.p);
      label120:
      if (parama.i == 0) {
        break label298;
      }
      ((Intent)localObject2).setFlags(parama.i);
    }
    for (;;)
    {
      Object localObject1 = null;
      try
      {
        localObject2 = paramPackageManager.resolveActivity((Intent)localObject2, 0);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        label153:
        break label153;
      }
      if ((localObject1 == null) || (localObject1.activityInfo == null) || ((!paramContext.getPackageName().equals(parama.f)) && (!localObject1.activityInfo.exported)) || ((!TextUtils.isEmpty(localObject1.activityInfo.permission)) && (paramPackageManager.checkPermission(localObject1.activityInfo.permission, paramContext.getPackageName()) == -1))) {
        break;
      }
      return true;
      ((Intent)localObject2).setPackage(parama.f);
      break label69;
      label240:
      i = 0;
      break label81;
      label245:
      j = 0;
      break label94;
      label251:
      if ((i != 0) && (j == 0))
      {
        ((Intent)localObject2).setData(Uri.parse(parama.g));
        break label120;
      }
      if ((i != 0) || (j == 0)) {
        break label120;
      }
      ((Intent)localObject2).setType(parama.p);
      break label120;
      label298:
      ((Intent)localObject2).setFlags(1350926336);
    }
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
        label68:
        int i;
        break label68;
      }
      if (localObject == null)
      {
        localIterator.remove();
      }
      else
      {
        i = localPackageManager.getApplicationEnabledSetting(locala.d);
        if ((i == 2) || (i == 3) || (i == 4)) {
          localIterator.remove();
        }
      }
    }
    return !paramb.c.isEmpty();
  }
  
  private static Pair<Boolean, Integer> b(Context paramContext, taiji.b paramb)
  {
    Iterator localIterator = paramb.c.iterator();
    PackageManager localPackageManager = paramContext.getPackageManager();
    int k;
    for (int i = 0; localIterator.hasNext(); i = k)
    {
      taiji.a locala = (taiji.a)localIterator.next();
      k = i;
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
        label85:
        break label85;
      }
      int j = i;
      if (paramb != null) {
        j = paramb.versionCode;
      }
      k = j;
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