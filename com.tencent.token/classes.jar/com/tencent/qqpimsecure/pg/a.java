package com.tencent.qqpimsecure.pg;

import Protocol.MMGRAuth.SolutionItem;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qqpimsecure.taiji.c;
import com.tencent.qqpimsecure.taiji.g;
import java.util.ArrayList;
import taiji.bn;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;

public class a
{
  private static SolutionItem a(Context paramContext, int paramInt)
  {
    if ((paramInt != 30118) && (paramInt != 30123) && (paramInt != 30125)) {
      return null;
    }
    paramContext = new SolutionItem();
    long l = -paramInt;
    paramContext.commSoluId = l;
    paramContext.extSoluId = l;
    return paramContext;
  }
  
  static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = g.a(paramContext).a(paramInt1);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((SolutionItem)localObject2).soluInfo != null) {}
    }
    else
    {
      localObject2 = a(paramContext, paramInt1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        return;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("adapterID:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" solutionID:");
    ((StringBuilder)localObject2).append(localObject1.extSoluId);
    ((StringBuilder)localObject2).append(" validity:");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(" verCode:");
    ((StringBuilder)localObject2).append(paramInt3);
    bn.b("AdapterSolutionMonitor", ((StringBuilder)localObject2).toString());
    long l = System.currentTimeMillis();
    if (l - f.a(paramContext, localObject1.extSoluId) > 86400000L)
    {
      f.a(paramContext, localObject1.extSoluId, l);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(String.valueOf(localObject1.commSoluId));
      if (paramInt2 == 0) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
      ((ArrayList)localObject2).add(String.valueOf(paramInt1));
      if (paramInt3 == 0) {
        paramContext = "";
      } else {
        paramContext = String.valueOf(paramInt3);
      }
      ((ArrayList)localObject2).add(paramContext);
      ((ArrayList)localObject2).add(String.valueOf(localObject1.extSoluId));
      c.a().e().reportString(265219, (ArrayList)localObject2);
    }
  }
  
  static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    Object localObject2 = g.a(paramContext).a(paramInt1);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((SolutionItem)localObject2).soluInfo != null) {}
    }
    else
    {
      localObject2 = a(paramContext, paramInt1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        return;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("adapterID:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" operation:");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(" source:");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(" errCode:");
    ((StringBuilder)localObject2).append(paramInt4);
    ((StringBuilder)localObject2).append(" pkgName:");
    ((StringBuilder)localObject2).append(paramString);
    bn.b("AdapterSolutionMonitor", ((StringBuilder)localObject2).toString());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(String.valueOf(localObject1.commSoluId));
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
      localArrayList.add(String.valueOf(localObject1.extSoluId));
      c.a().e().reportString(265219, localArrayList);
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
 * Qualified Name:     com.tencent.qqpimsecure.pg.a
 * JD-Core Version:    0.7.0.1
 */