package com.oasisfeng.condom;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class d
  extends PackageManagerWrapper
{
  private static final CondomCore.c<String, String> c = new CondomCore.c()
  {
    public String a(String paramAnonymousString)
    {
      return paramAnonymousString;
    }
  };
  private final CondomCore a;
  private final String b;
  
  d(CondomCore paramCondomCore, PackageManager paramPackageManager, String paramString)
  {
    super(paramPackageManager);
    this.a = paramCondomCore;
    this.b = paramString;
  }
  
  public int checkPermission(final String paramString1, final String paramString2)
  {
    ((Integer)this.a.proceed(OutboundType.CHECK_PERMISSION, paramString2, Integer.valueOf(-1), new CondomCore.f()
    {
      public Integer a()
      {
        return Integer.valueOf(d.a(d.this, paramString1, paramString2));
      }
    })).intValue();
  }
  
  public ApplicationInfo getApplicationInfo(final String paramString, final int paramInt)
  {
    (ApplicationInfo)this.a.proceed(OutboundType.GET_APPLICATION_INFO, paramString, null, new CondomCore.g()
    {
      public ApplicationInfo a()
      {
        return d.a(d.this, paramString, paramInt);
      }
    });
  }
  
  public List<ApplicationInfo> getInstalledApplications(int paramInt)
  {
    this.a.logConcern(this.b, "PackageManager.getInstalledApplications");
    return super.getInstalledApplications(paramInt);
  }
  
  public List<PackageInfo> getInstalledPackages(int paramInt)
  {
    this.a.logConcern(this.b, "PackageManager.getInstalledPackages");
    return super.getInstalledPackages(paramInt);
  }
  
  public PackageInfo getPackageInfo(final String paramString, final int paramInt)
  {
    PackageInfo localPackageInfo = (PackageInfo)this.a.proceed(OutboundType.GET_PACKAGE_INFO, paramString, null, new CondomCore.g()
    {
      public PackageInfo a()
      {
        return d.b(d.this, paramString, paramInt);
      }
    });
    if (localPackageInfo != null)
    {
      if (((paramInt & 0x1000) != 0) && (!this.a.getSpoofPermissions().isEmpty()) && (this.a.getPackageName().equals(paramString)))
      {
        if (localPackageInfo.requestedPermissions == null) {
          paramString = new ArrayList();
        } else {
          paramString = new ArrayList(Arrays.asList(localPackageInfo.requestedPermissions));
        }
        ArrayList localArrayList = new ArrayList(this.a.getSpoofPermissions());
        localArrayList.removeAll(paramString);
        if (!localArrayList.isEmpty())
        {
          paramString.addAll(localArrayList);
          localPackageInfo.requestedPermissions = ((String[])paramString.toArray(new String[paramString.size()]));
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          if (localPackageInfo.requestedPermissionsFlags == null) {
            paramString = new int[paramString.size()];
          } else {
            paramString = Arrays.copyOf(localPackageInfo.requestedPermissionsFlags, paramString.size());
          }
          paramInt = 0;
          while (paramInt < localPackageInfo.requestedPermissions.length)
          {
            if (this.a.shouldSpoofPermission(localPackageInfo.requestedPermissions[paramInt])) {
              paramString[paramInt] = 2;
            }
            paramInt += 1;
          }
          localPackageInfo.requestedPermissionsFlags = paramString;
        }
      }
      return localPackageInfo;
    }
    throw new PackageManager.NameNotFoundException(paramString);
  }
  
  @NonNull
  @RequiresApi(21)
  public PackageInstaller getPackageInstaller()
  {
    throw new UnsupportedOperationException("PackageManager.getPackageInstaller() is not yet supported by Project Condom. If it causes trouble, please file an issue on GitHub.");
  }
  
  @Nullable
  public String[] getPackagesForUid(final int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject3 = OutboundType.QUERY_PACKAGES;
    CondomCore.f local6 = new CondomCore.f()
    {
      @Nullable
      public List<String> a()
      {
        String[] arrayOfString = d.a(d.this, paramInt);
        if (arrayOfString != null) {
          return Arrays.asList(arrayOfString);
        }
        return null;
      }
    };
    CondomCore.c localc = c;
    Object localObject2 = null;
    localObject3 = ((CondomCore)localObject1).proceedQuery((OutboundType)localObject3, null, local6, localc);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject3).isEmpty()) {
        localObject1 = (String[])((List)localObject3).toArray(new String[0]);
      }
    }
    return localObject1;
  }
  
  public List<ResolveInfo> queryBroadcastReceivers(final Intent paramIntent, final int paramInt)
  {
    this.a.proceedQuery(OutboundType.QUERY_RECEIVERS, paramIntent, new CondomCore.f()
    {
      public List<ResolveInfo> a()
      {
        return d.a(d.this, paramIntent, paramInt);
      }
    }, CondomCore.RECEIVER_PACKAGE_GETTER);
  }
  
  public List<ResolveInfo> queryIntentServices(final Intent paramIntent, final int paramInt)
  {
    final int i = paramIntent.getFlags();
    this.a.proceedQuery(OutboundType.QUERY_SERVICES, paramIntent, new CondomCore.f()
    {
      public List<ResolveInfo> a()
      {
        List localList = d.b(d.this, paramIntent, paramInt);
        d.b(d.this).filterCandidates(OutboundType.QUERY_SERVICES, paramIntent.setFlags(i), localList, d.a(d.this), true);
        return localList;
      }
    }, CondomCore.SERVICE_PACKAGE_GETTER);
  }
  
  public ProviderInfo resolveContentProvider(String paramString, int paramInt)
  {
    paramString = super.resolveContentProvider(paramString, paramInt);
    if (!this.a.shouldAllowProvider(paramString)) {
      return null;
    }
    return paramString;
  }
  
  public ResolveInfo resolveService(final Intent paramIntent, final int paramInt)
  {
    final int i = paramIntent.getFlags();
    (ResolveInfo)this.a.proceed(OutboundType.QUERY_SERVICES, paramIntent, null, new CondomCore.f()
    {
      public ResolveInfo a()
      {
        if ((!d.b(d.this).mExcludeBackgroundServices) && (d.b(d.this).mOutboundJudge == null)) {
          return d.c(d.this, paramIntent, paramInt);
        }
        List localList = d.d(d.this, paramIntent, paramInt);
        Intent localIntent = paramIntent.setFlags(i);
        return d.b(d.this).filterCandidates(OutboundType.QUERY_SERVICES, localIntent, localList, d.a(d.this), false);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.d
 * JD-Core Version:    0.7.0.1
 */