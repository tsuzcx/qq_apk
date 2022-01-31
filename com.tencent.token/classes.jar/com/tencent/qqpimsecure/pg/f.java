package com.tencent.qqpimsecure.pg;

import Protocol.MMGRAuth.SolutionItem;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qqpimsecure.taiji.n;
import java.util.ArrayList;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;

public class f
{
  private static SolutionItem a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    paramContext = new SolutionItem();
    paramContext.commSoluId = (-paramInt);
    paramContext.extSoluId = (-paramInt);
    return paramContext;
  }
  
  static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    SolutionItem localSolutionItem2 = n.a(paramContext).a(paramInt1);
    SolutionItem localSolutionItem1;
    if (localSolutionItem2 != null)
    {
      localSolutionItem1 = localSolutionItem2;
      if (localSolutionItem2.soluInfo != null) {}
    }
    else
    {
      localSolutionItem2 = a(paramContext, paramInt1);
      localSolutionItem1 = localSolutionItem2;
      if (localSolutionItem2 != null) {}
    }
    long l;
    do
    {
      return;
      cl.b("AdapterSolutionMonitor", "adapterID:" + paramInt1 + " solutionID:" + localSolutionItem1.extSoluId + " validity:" + paramInt2 + " verCode:" + paramInt3);
      l = System.currentTimeMillis();
    } while (l - q.a(paramContext, localSolutionItem1.extSoluId) <= 86400000L);
    q.a(paramContext, localSolutionItem1.extSoluId, l);
    paramContext = new ArrayList();
    paramContext.add(String.valueOf(localSolutionItem1.commSoluId));
    if (paramInt2 == 0)
    {
      paramContext.add(String.valueOf(2));
      if (paramInt3 != 0) {
        break label219;
      }
      paramContext.add("");
    }
    for (;;)
    {
      paramContext.add(String.valueOf(localSolutionItem1.extSoluId));
      com.tencent.qqpimsecure.taiji.f.a().e().reportString(265219, paramContext);
      return;
      paramContext.add(String.valueOf(1));
      break;
      label219:
      paramContext.add(String.valueOf(paramInt3));
    }
  }
  
  static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    SolutionItem localSolutionItem2 = n.a(paramContext).a(paramInt1);
    SolutionItem localSolutionItem1;
    if (localSolutionItem2 != null)
    {
      localSolutionItem1 = localSolutionItem2;
      if (localSolutionItem2.soluInfo != null) {}
    }
    else
    {
      localSolutionItem2 = a(paramContext, paramInt1);
      localSolutionItem1 = localSolutionItem2;
      if (localSolutionItem2 == null) {
        return;
      }
    }
    cl.b("AdapterSolutionMonitor", "adapterID:" + paramInt1 + " operation:" + paramInt2 + " source:" + paramInt3 + " errCode:" + paramInt4 + " pkgName:" + paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(String.valueOf(localSolutionItem1.commSoluId));
    paramInt1 = 14;
    switch (paramInt2)
    {
    default: 
      localArrayList.add(String.valueOf(paramInt1 + (paramInt3 << 7) + (paramInt4 << 18)));
      if (!TextUtils.isEmpty(paramString)) {
        localSolutionItem2 = null;
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null)
        {
          paramInt1 = paramContext.versionCode;
          if (paramInt1 == 0)
          {
            localArrayList.add("");
            localArrayList.add(String.valueOf(localSolutionItem1.extSoluId));
            com.tencent.qqpimsecure.taiji.f.a().e().reportString(265219, localArrayList);
            return;
            paramInt1 = 78;
            break;
            paramInt1 = 46;
            break;
            paramInt1 = 30;
            break;
          }
          localArrayList.add(String.valueOf(paramInt1));
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext = localSolutionItem2;
        continue;
      }
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.f
 * JD-Core Version:    0.7.0.1
 */