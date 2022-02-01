package com.tencent.token;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.ArrayList;

public final class qm
{
  private static k a(int paramInt)
  {
    if ((paramInt != 30118) && (paramInt != 30123) && (paramInt != 30125)) {
      return null;
    }
    k localk = new k();
    long l = -paramInt;
    localk.a = l;
    localk.b = l;
    return localk;
  }
  
  static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = ra.a(paramContext).a(paramInt1);
    if (localObject != null)
    {
      paramContext = (Context)localObject;
      if (((k)localObject).e != null) {}
    }
    else
    {
      localObject = a(paramInt1);
      paramContext = (Context)localObject;
      if (localObject == null) {
        return;
      }
    }
    localObject = new StringBuilder("adapterID:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" solutionID:");
    ((StringBuilder)localObject).append(paramContext.b);
    ((StringBuilder)localObject).append(" validity:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" verCode:");
    ((StringBuilder)localObject).append(paramInt3);
    apz.b();
    long l1 = System.currentTimeMillis();
    long l2 = paramContext.b;
    localObject = new StringBuilder("s");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append("ct");
    localObject = ((StringBuilder)localObject).toString();
    if (l1 - qw.a.a().a("pgd_sp").a((String)localObject, 0L) > 86400000L)
    {
      l2 = paramContext.b;
      localObject = new StringBuilder("s");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("ct");
      localObject = ((StringBuilder)localObject).toString();
      qw.a.a().a("pgd_sp").b((String)localObject, l1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(paramContext.a));
      if (paramInt2 == 0) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      localArrayList.add(localObject);
      if (paramInt3 == 0) {
        localObject = "";
      } else {
        localObject = String.valueOf(paramInt3);
      }
      localArrayList.add(localObject);
      localArrayList.add(String.valueOf(paramContext.b));
      qw.a.a().b().a(265219, localArrayList);
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    Object localObject2 = ra.a(paramContext).a(paramInt1);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((k)localObject2).e != null) {}
    }
    else
    {
      localObject2 = a(paramInt1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        return;
      }
    }
    localObject2 = new StringBuilder("adapterID:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" operation:");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(" source:");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(" errCode:");
    ((StringBuilder)localObject2).append(paramInt4);
    ((StringBuilder)localObject2).append(" pkgName:");
    ((StringBuilder)localObject2).append(paramString);
    apz.b();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(String.valueOf(localObject1.a));
    paramInt1 = 14;
    switch (paramInt2)
    {
    default: 
      break;
    case 1: 
      paramInt1 = 30;
      break;
    case 0: 
      paramInt1 = 46;
      break;
    case -1: 
      paramInt1 = 78;
    }
    localArrayList.add(String.valueOf(paramInt1 + (paramInt3 << 7) + (paramInt4 << 18)));
    boolean bool = TextUtils.isEmpty(paramString);
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!bool) {
      localObject2 = null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      paramInt1 = paramInt2;
      if (paramContext != null) {
        paramInt1 = paramContext.versionCode;
      }
      if (paramInt1 == 0) {
        paramContext = "";
      } else {
        paramContext = String.valueOf(paramInt1);
      }
      localArrayList.add(paramContext);
      localArrayList.add(String.valueOf(localObject1.b));
      qw.a.a().b().a(265219, localArrayList);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qm
 * JD-Core Version:    0.7.0.1
 */