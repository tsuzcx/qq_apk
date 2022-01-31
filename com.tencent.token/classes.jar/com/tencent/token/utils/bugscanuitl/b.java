package com.tencent.token.utils.bugscanuitl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.content.AsyncTaskLoader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.token.global.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class b
  extends AsyncTaskLoader
{
  public static List c;
  public static final Comparator e = new c();
  public final d a = new d();
  public final PackageManager b = getContext().getPackageManager();
  ArrayList d;
  
  public b(Context paramContext, ArrayList paramArrayList)
  {
    super(paramContext);
    this.d = paramArrayList;
  }
  
  private static String a(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramApplicationInfo.packageName, 0);
      if (paramContext != null) {
        return paramContext.versionName;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    return "";
  }
  
  private List a()
  {
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        Object localObject1 = this.b.getInstalledApplications(8192);
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          Log.i("getList", "getList");
          localContext = getContext();
          localArrayList = new ArrayList(((List)localObject1).size());
          i = 0;
          if (i < ((List)localObject1).size()) {
            if ((((ApplicationInfo)((List)localObject1).get(i)).flags & 0x1) != 0)
            {
              j = 1;
              if ((j != 0) || (((ApplicationInfo)((List)localObject1).get(i)).packageName.indexOf("com.tencent.token") != -1)) {
                continue;
              }
              localObject2 = new StringBuilder().append("");
              if (this.d != null) {
                continue;
              }
              j = 0;
              e.c(j);
              e.c("apps" + ((ApplicationInfo)((List)localObject1).get(i)).packageName);
              if ((this.d != null) && (this.d.size() != 0)) {
                continue;
              }
              return localArrayList;
            }
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Context localContext;
        ArrayList localArrayList;
        int i;
        Object localObject2;
        localInterruptedException.printStackTrace();
        continue;
        int j = 0;
        continue;
        j = this.d.size();
        continue;
        j = 0;
        if (j < this.d.size())
        {
          Object localObject3 = (BugObject)this.d.get(j);
          localObject2 = a(localContext, (ApplicationInfo)localInterruptedException.get(i));
          int k = b(localContext, (ApplicationInfo)localInterruptedException.get(i));
          if (((BugObject)localObject3).a().equals(((ApplicationInfo)localInterruptedException.get(i)).packageName))
          {
            e.c("bopac" + ((BugObject)localObject3).a());
            e.c("code" + k);
            e.c("bo.getVersion()" + ((BugObject)localObject3).b());
          }
          if ((((BugObject)localObject3).a().equals(((ApplicationInfo)localInterruptedException.get(i)).packageName)) && (Integer.parseInt(((BugObject)localObject3).b()) >= k))
          {
            localObject3 = new a(this, (ApplicationInfo)localInterruptedException.get(i));
            ((a)localObject3).a(localContext);
            ((a)localObject3).a((String)localObject2);
            localArrayList.add(localObject3);
          }
          j += 1;
        }
        else
        {
          i += 1;
          continue;
          Collections.sort(localArrayList, e);
          return localArrayList;
        }
      }
    }
  }
  
  private static int b(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramApplicationInfo.packageName, 0);
      if (paramContext != null) {
        i = paramContext.versionCode;
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
  
  protected final void onReset()
  {
    super.onReset();
    cancelLoad();
  }
  
  protected final void onStartLoading()
  {
    forceLoad();
  }
  
  protected final void onStopLoading()
  {
    cancelLoad();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.b
 * JD-Core Version:    0.7.0.1
 */