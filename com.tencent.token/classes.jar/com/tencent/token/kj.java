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
import com.oasisfeng.condom.CondomCore.c;
import com.oasisfeng.condom.CondomCore.f;
import com.oasisfeng.condom.CondomCore.g;
import com.oasisfeng.condom.OutboundType;
import com.oasisfeng.condom.PackageManagerWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class kj
  extends PackageManagerWrapper
{
  private static final CondomCore.c<String, String> c = new CondomCore.c() {};
  private final CondomCore a;
  private final String b;
  
  public kj(CondomCore paramCondomCore, PackageManager paramPackageManager, String paramString)
  {
    super(paramPackageManager);
    this.a = paramCondomCore;
    this.b = paramString;
  }
  
  public final int checkPermission(final String paramString1, final String paramString2)
  {
    ((Integer)this.a.proceed(OutboundType.CHECK_PERMISSION, paramString2, Integer.valueOf(-1), new CondomCore.f() {})).intValue();
  }
  
  public final ApplicationInfo getApplicationInfo(final String paramString, final int paramInt)
  {
    (ApplicationInfo)this.a.proceed(OutboundType.GET_APPLICATION_INFO, paramString, null, new CondomCore.g() {});
  }
  
  public final List<ApplicationInfo> getInstalledApplications(int paramInt)
  {
    this.a.logConcern(this.b, "PackageManager.getInstalledApplications");
    return super.getInstalledApplications(paramInt);
  }
  
  public final List<PackageInfo> getInstalledPackages(int paramInt)
  {
    this.a.logConcern(this.b, "PackageManager.getInstalledPackages");
    return super.getInstalledPackages(paramInt);
  }
  
  public final PackageInfo getPackageInfo(final String paramString, final int paramInt)
  {
    PackageInfo localPackageInfo = (PackageInfo)this.a.proceed(OutboundType.GET_PACKAGE_INFO, paramString, null, new CondomCore.g() {});
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
  
  public final PackageInstaller getPackageInstaller()
  {
    throw new UnsupportedOperationException("PackageManager.getPackageInstaller() is not yet supported by Project Condom. If it causes trouble, please file an issue on GitHub.");
  }
  
  public final String[] getPackagesForUid(final int paramInt)
  {
    List localList = this.a.proceedQuery(OutboundType.QUERY_PACKAGES, null, new CondomCore.f() {}, c);
    if ((localList != null) && (!localList.isEmpty())) {
      return (String[])localList.toArray(new String[0]);
    }
    return null;
  }
  
  public final List<ResolveInfo> queryBroadcastReceivers(final Intent paramIntent, final int paramInt)
  {
    this.a.proceedQuery(OutboundType.QUERY_RECEIVERS, paramIntent, new CondomCore.f() {}, CondomCore.RECEIVER_PACKAGE_GETTER);
  }
  
  public final List<ResolveInfo> queryIntentServices(final Intent paramIntent, final int paramInt)
  {
    final int i = paramIntent.getFlags();
    this.a.proceedQuery(OutboundType.QUERY_SERVICES, paramIntent, new CondomCore.f() {}, CondomCore.SERVICE_PACKAGE_GETTER);
  }
  
  public final ProviderInfo resolveContentProvider(String paramString, int paramInt)
  {
    paramString = super.resolveContentProvider(paramString, paramInt);
    if (!this.a.shouldAllowProvider(paramString)) {
      return null;
    }
    return paramString;
  }
  
  public final ResolveInfo resolveService(final Intent paramIntent, final int paramInt)
  {
    final int i = paramIntent.getFlags();
    (ResolveInfo)this.a.proceed(OutboundType.QUERY_SERVICES, paramIntent, null, new CondomCore.f() {});
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kj
 * JD-Core Version:    0.7.0.1
 */