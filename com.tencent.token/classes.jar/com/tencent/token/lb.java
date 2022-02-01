package com.tencent.token;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import com.oasisfeng.condom.CondomCore;
import com.oasisfeng.condom.CondomCore.j;
import com.oasisfeng.condom.CondomCore.m;
import com.oasisfeng.condom.CondomCore.n;
import com.oasisfeng.condom.OutboundType;
import com.oasisfeng.condom.PackageManagerWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class lb
  extends PackageManagerWrapper
{
  private static final CondomCore.j<String, String> a = new h();
  private final CondomCore b;
  private final String c;
  
  public lb(CondomCore paramCondomCore, PackageManager paramPackageManager, String paramString)
  {
    super(paramPackageManager);
    this.b = paramCondomCore;
    this.c = paramString;
  }
  
  public final int checkPermission(final String paramString1, final String paramString2)
  {
    return ((Integer)this.b.proceed(OutboundType.CHECK_PERMISSION, paramString2, Integer.valueOf(-1), new g(paramString1, paramString2))).intValue();
  }
  
  public final ApplicationInfo getApplicationInfo(final String paramString, final int paramInt)
  {
    return (ApplicationInfo)this.b.proceed(OutboundType.GET_APPLICATION_INFO, paramString, null, new d(paramString, paramInt));
  }
  
  public final List<ApplicationInfo> getInstalledApplications(int paramInt)
  {
    this.b.logConcern(this.c, "PackageManager.getInstalledApplications");
    return super.getInstalledApplications(paramInt);
  }
  
  public final List<PackageInfo> getInstalledPackages(int paramInt)
  {
    this.b.logConcern(this.c, "PackageManager.getInstalledPackages");
    return super.getInstalledPackages(paramInt);
  }
  
  public final PackageInfo getPackageInfo(final String paramString, final int paramInt)
  {
    PackageInfo localPackageInfo = (PackageInfo)this.b.proceed(OutboundType.GET_PACKAGE_INFO, paramString, null, new e(paramString, paramInt));
    if (localPackageInfo != null)
    {
      if (((paramInt & 0x1000) != 0) && (!this.b.getSpoofPermissions().isEmpty()) && (this.b.getPackageName().equals(paramString)))
      {
        paramString = localPackageInfo.requestedPermissions;
        if (paramString == null) {
          paramString = new ArrayList();
        } else {
          paramString = new ArrayList(Arrays.asList(paramString));
        }
        Object localObject = new ArrayList(this.b.getSpoofPermissions());
        ((List)localObject).removeAll(paramString);
        if (!((List)localObject).isEmpty())
        {
          paramString.addAll((Collection)localObject);
          localPackageInfo.requestedPermissions = ((String[])paramString.toArray(new String[paramString.size()]));
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          localObject = localPackageInfo.requestedPermissionsFlags;
          if (localObject == null) {
            paramString = new int[paramString.size()];
          } else {
            paramString = Arrays.copyOf((int[])localObject, paramString.size());
          }
          paramInt = 0;
          for (;;)
          {
            localObject = localPackageInfo.requestedPermissions;
            if (paramInt >= localObject.length) {
              break;
            }
            if (this.b.shouldSpoofPermission(localObject[paramInt])) {
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
  
  public final PackageInstaller getPackageInstaller()
  {
    throw new UnsupportedOperationException("PackageManager.getPackageInstaller() is not yet supported by Project Condom. If it causes trouble, please file an issue on GitHub.");
  }
  
  public final String[] getPackagesForUid(final int paramInt)
  {
    List localList = this.b.proceedQuery(OutboundType.QUERY_PACKAGES, null, new f(paramInt), a);
    if ((localList != null) && (!localList.isEmpty())) {
      return (String[])localList.toArray(new String[0]);
    }
    return null;
  }
  
  public final List<ResolveInfo> queryBroadcastReceivers(final Intent paramIntent, final int paramInt)
  {
    return this.b.proceedQuery(OutboundType.QUERY_RECEIVERS, paramIntent, new a(paramIntent, paramInt), CondomCore.RECEIVER_PACKAGE_GETTER);
  }
  
  public final List<ResolveInfo> queryIntentServices(final Intent paramIntent, final int paramInt)
  {
    final int i = paramIntent.getFlags();
    return this.b.proceedQuery(OutboundType.QUERY_SERVICES, paramIntent, new b(paramIntent, paramInt, i), CondomCore.SERVICE_PACKAGE_GETTER);
  }
  
  public final ProviderInfo resolveContentProvider(String paramString, int paramInt)
  {
    ProviderInfo localProviderInfo = super.resolveContentProvider(paramString, paramInt);
    paramString = localProviderInfo;
    if (!this.b.shouldAllowProvider(localProviderInfo)) {
      paramString = null;
    }
    return paramString;
  }
  
  public final ResolveInfo resolveService(final Intent paramIntent, final int paramInt)
  {
    final int i = paramIntent.getFlags();
    return (ResolveInfo)this.b.proceed(OutboundType.QUERY_SERVICES, paramIntent, null, new c(paramIntent, paramInt, i));
  }
  
  final class a
    implements CondomCore.m<List<ResolveInfo>>
  {
    a(Intent paramIntent, int paramInt) {}
  }
  
  final class b
    implements CondomCore.m<List<ResolveInfo>>
  {
    b(Intent paramIntent, int paramInt1, int paramInt2) {}
  }
  
  final class c
    implements CondomCore.m<ResolveInfo>
  {
    c(Intent paramIntent, int paramInt1, int paramInt2) {}
  }
  
  final class d
    implements CondomCore.n<ApplicationInfo, PackageManager.NameNotFoundException>
  {
    d(String paramString, int paramInt) {}
  }
  
  final class e
    implements CondomCore.n<PackageInfo, PackageManager.NameNotFoundException>
  {
    e(String paramString, int paramInt) {}
  }
  
  final class f
    implements CondomCore.m<List<String>>
  {
    f(int paramInt) {}
  }
  
  final class g
    implements CondomCore.m<Integer>
  {
    g(String paramString1, String paramString2) {}
  }
  
  static final class h
    implements CondomCore.j<String, String>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lb
 * JD-Core Version:    0.7.0.1
 */