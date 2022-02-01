package com.tencent.token;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.UserHandle;
import com.oasisfeng.condom.PackageManagerWrapper;
import java.util.List;

public class ajc
  extends PackageManagerWrapper
{
  private PackageManager a;
  
  public ajc(PackageManager paramPackageManager)
  {
    super(paramPackageManager);
    this.a = paramPackageManager;
  }
  
  public void addPackageToPreferred(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("addPackageToPreferred, packageName[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    aji.a("[API]PackageManager_");
    this.a.addPackageToPreferred(paramString);
  }
  
  public boolean addPermission(PermissionInfo paramPermissionInfo)
  {
    aji.a("[API]PackageManager_");
    return this.a.addPermission(paramPermissionInfo);
  }
  
  public boolean addPermissionAsync(PermissionInfo paramPermissionInfo)
  {
    aji.a("[API]PackageManager_");
    return this.a.addPermissionAsync(paramPermissionInfo);
  }
  
  public void addPreferredActivity(IntentFilter paramIntentFilter, int paramInt, ComponentName[] paramArrayOfComponentName, ComponentName paramComponentName)
  {
    aji.a("[API]PackageManager_");
    this.a.addPreferredActivity(paramIntentFilter, paramInt, paramArrayOfComponentName, paramComponentName);
  }
  
  public boolean canRequestPackageInstalls()
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.canRequestPackageInstalls();
    }
    return false;
  }
  
  public String[] canonicalToCurrentPackageNames(String[] paramArrayOfString)
  {
    aji.a("[API]PackageManager_");
    return this.a.canonicalToCurrentPackageNames(paramArrayOfString);
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("checkPermission, permName:[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]packageName:[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]");
    aji.a("[API]PackageManager_");
    return this.a.checkPermission(paramString1, paramString2);
  }
  
  public int checkSignatures(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("checkSignatures, uid1:[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("]uid2:[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    aji.a("[API]PackageManager_");
    return this.a.checkSignatures(paramInt1, paramInt2);
  }
  
  public int checkSignatures(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("checkSignatures, packageName1:[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]packageName2:[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]");
    aji.a("[API]PackageManager_");
    return this.a.checkSignatures(paramString1, paramString2);
  }
  
  public void clearInstantAppCookie()
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.clearInstantAppCookie();
    }
  }
  
  public void clearPackagePreferredActivities(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("clearPackagePreferredActivities, packageName:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    aji.a("[API]PackageManager_");
    this.a.clearPackagePreferredActivities(paramString);
  }
  
  public String[] currentToCanonicalPackageNames(String[] paramArrayOfString)
  {
    aji.a("[API]PackageManager_");
    return this.a.currentToCanonicalPackageNames(paramArrayOfString);
  }
  
  public void extendVerificationTimeout(int paramInt1, int paramInt2, long paramLong)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 17) {
      this.a.extendVerificationTimeout(paramInt1, paramInt2, paramLong);
    }
  }
  
  public Drawable getActivityBanner(ComponentName paramComponentName)
  {
    StringBuilder localStringBuilder = new StringBuilder("getActivityBanner, activityName:[");
    localStringBuilder.append(paramComponentName);
    localStringBuilder.append("]");
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 20) {
      return this.a.getActivityBanner(paramComponentName);
    }
    return null;
  }
  
  public Drawable getActivityBanner(Intent paramIntent)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 20) {
      return this.a.getActivityBanner(paramIntent);
    }
    return null;
  }
  
  public Drawable getActivityIcon(ComponentName paramComponentName)
  {
    aji.a("[API]PackageManager_");
    return this.a.getActivityIcon(paramComponentName);
  }
  
  public Drawable getActivityIcon(Intent paramIntent)
  {
    aji.a("[API]PackageManager_");
    return this.a.getActivityIcon(paramIntent);
  }
  
  public ActivityInfo getActivityInfo(ComponentName paramComponentName, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getActivityInfo(paramComponentName, paramInt);
  }
  
  public Drawable getActivityLogo(ComponentName paramComponentName)
  {
    aji.a("[API]PackageManager_");
    return this.a.getActivityLogo(paramComponentName);
  }
  
  public Drawable getActivityLogo(Intent paramIntent)
  {
    aji.a("[API]PackageManager_");
    return this.a.getActivityLogo(paramIntent);
  }
  
  public List<PermissionGroupInfo> getAllPermissionGroups(int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getAllPermissionGroups(paramInt);
  }
  
  public Drawable getApplicationBanner(ApplicationInfo paramApplicationInfo)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 20) {
      return this.a.getApplicationBanner(paramApplicationInfo);
    }
    return null;
  }
  
  public Drawable getApplicationBanner(String paramString)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 20) {
      return this.a.getApplicationBanner(paramString);
    }
    return null;
  }
  
  public int getApplicationEnabledSetting(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getApplicationEnabledSetting(paramString);
  }
  
  public Drawable getApplicationIcon(ApplicationInfo paramApplicationInfo)
  {
    aji.a("[API]PackageManager_");
    return this.a.getApplicationIcon(paramApplicationInfo);
  }
  
  public Drawable getApplicationIcon(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getApplicationIcon(paramString);
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getApplicationInfo(paramString, paramInt);
  }
  
  public CharSequence getApplicationLabel(ApplicationInfo paramApplicationInfo)
  {
    aji.a("[API]PackageManager_");
    return this.a.getApplicationLabel(paramApplicationInfo);
  }
  
  public Drawable getApplicationLogo(ApplicationInfo paramApplicationInfo)
  {
    aji.a("[API]PackageManager_");
    return this.a.getApplicationLogo(paramApplicationInfo);
  }
  
  public Drawable getApplicationLogo(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getApplicationLogo(paramString);
  }
  
  public ChangedPackages getChangedPackages(int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getChangedPackages(paramInt);
    }
    return null;
  }
  
  public int getComponentEnabledSetting(ComponentName paramComponentName)
  {
    aji.a("[API]PackageManager_");
    return this.a.getComponentEnabledSetting(paramComponentName);
  }
  
  public Drawable getDefaultActivityIcon()
  {
    aji.a("[API]PackageManager_");
    return this.a.getDefaultActivityIcon();
  }
  
  public Drawable getDrawable(String paramString, int paramInt, ApplicationInfo paramApplicationInfo)
  {
    aji.a("[API]PackageManager_");
    return this.a.getDrawable(paramString, paramInt, paramApplicationInfo);
  }
  
  public List<ApplicationInfo> getInstalledApplications(int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getInstalledApplications(paramInt);
  }
  
  public List<PackageInfo> getInstalledPackages(int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getInstalledPackages(paramInt);
  }
  
  public String getInstallerPackageName(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getInstallerPackageName(paramString);
  }
  
  public byte[] getInstantAppCookie()
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getInstantAppCookie();
    }
    return null;
  }
  
  public int getInstantAppCookieMaxBytes()
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getInstantAppCookieMaxBytes();
    }
    return 0;
  }
  
  public InstrumentationInfo getInstrumentationInfo(ComponentName paramComponentName, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getInstrumentationInfo(paramComponentName, paramInt);
  }
  
  public Intent getLaunchIntentForPackage(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getLaunchIntentForPackage(paramString);
  }
  
  public Intent getLeanbackLaunchIntentForPackage(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getLaunchIntentForPackage(paramString);
  }
  
  public String getNameForUid(int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getNameForUid(paramInt);
  }
  
  public PackageInfo getPackageArchiveInfo(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getPackageArchiveInfo(paramString, paramInt);
  }
  
  public int[] getPackageGids(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getPackageGids(paramString);
  }
  
  public int[] getPackageGids(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getPackageGids(paramString, paramInt);
    }
    return null;
  }
  
  public PackageInfo getPackageInfo(VersionedPackage paramVersionedPackage, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getPackageInfo(paramVersionedPackage, paramInt);
    }
    return null;
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getPackageInfo(paramString, paramInt);
  }
  
  public PackageInstaller getPackageInstaller()
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.getPackageInstaller();
    }
    return null;
  }
  
  public int getPackageUid(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getPackageUid(paramString, paramInt);
    }
    return 0;
  }
  
  public String[] getPackagesForUid(int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getPackagesForUid(paramInt);
  }
  
  public List<PackageInfo> getPackagesHoldingPermissions(String[] paramArrayOfString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 18) {
      return this.a.getPackagesHoldingPermissions(paramArrayOfString, paramInt);
    }
    return null;
  }
  
  public PermissionGroupInfo getPermissionGroupInfo(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getPermissionGroupInfo(paramString, paramInt);
  }
  
  public PermissionInfo getPermissionInfo(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getPermissionInfo(paramString, paramInt);
  }
  
  public int getPreferredActivities(List<IntentFilter> paramList, List<ComponentName> paramList1, String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getPreferredActivities(paramList, paramList1, paramString);
  }
  
  public List<PackageInfo> getPreferredPackages(int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getPreferredPackages(paramInt);
  }
  
  public ProviderInfo getProviderInfo(ComponentName paramComponentName, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getProviderInfo(paramComponentName, paramInt);
  }
  
  public ActivityInfo getReceiverInfo(ComponentName paramComponentName, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getReceiverInfo(paramComponentName, paramInt);
  }
  
  public Resources getResourcesForActivity(ComponentName paramComponentName)
  {
    aji.a("[API]PackageManager_");
    return this.a.getResourcesForActivity(paramComponentName);
  }
  
  public Resources getResourcesForApplication(ApplicationInfo paramApplicationInfo)
  {
    aji.a("[API]PackageManager_");
    return this.a.getResourcesForApplication(paramApplicationInfo);
  }
  
  public Resources getResourcesForApplication(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.getResourcesForApplication(paramString);
  }
  
  public ServiceInfo getServiceInfo(ComponentName paramComponentName, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.getServiceInfo(paramComponentName, paramInt);
  }
  
  public List<SharedLibraryInfo> getSharedLibraries(int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getSharedLibraries(paramInt);
    }
    return null;
  }
  
  public Bundle getSuspendedPackageAppExtras()
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 28) {
      return this.a.getSuspendedPackageAppExtras();
    }
    return null;
  }
  
  public FeatureInfo[] getSystemAvailableFeatures()
  {
    aji.a("[API]PackageManager_");
    return this.a.getSystemAvailableFeatures();
  }
  
  public String[] getSystemSharedLibraryNames()
  {
    aji.a("[API]PackageManager_");
    return this.a.getSystemSharedLibraryNames();
  }
  
  public Drawable getUserBadgedDrawableForDensity(Drawable paramDrawable, UserHandle paramUserHandle, Rect paramRect, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.getUserBadgedDrawableForDensity(paramDrawable, paramUserHandle, paramRect, paramInt);
    }
    return null;
  }
  
  public Drawable getUserBadgedIcon(Drawable paramDrawable, UserHandle paramUserHandle)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.getUserBadgedIcon(paramDrawable, paramUserHandle);
    }
    return null;
  }
  
  public CharSequence getUserBadgedLabel(CharSequence paramCharSequence, UserHandle paramUserHandle)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.getUserBadgedLabel(paramCharSequence, paramUserHandle);
    }
    return null;
  }
  
  public XmlResourceParser getXml(String paramString, int paramInt, ApplicationInfo paramApplicationInfo)
  {
    aji.a("[API]PackageManager_");
    return this.a.getXml(paramString, paramInt, paramApplicationInfo);
  }
  
  public boolean hasSigningCertificate(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 28) {
      return this.a.hasSigningCertificate(paramString, paramArrayOfByte, paramInt);
    }
    return false;
  }
  
  public boolean hasSystemFeature(String paramString)
  {
    aji.a("[API]PackageManager_");
    return this.a.hasSystemFeature(paramString);
  }
  
  public boolean hasSystemFeature(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.hasSystemFeature(paramString, paramInt);
    }
    return false;
  }
  
  public boolean isInstantApp()
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.isInstantApp();
    }
    return false;
  }
  
  public boolean isInstantApp(String paramString)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.isInstantApp(paramString);
    }
    return false;
  }
  
  public boolean isPackageSuspended()
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 28) {
      return this.a.isPackageSuspended();
    }
    return false;
  }
  
  public boolean isPermissionRevokedByPolicy(String paramString1, String paramString2)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 23) {
      return this.a.isPermissionRevokedByPolicy(paramString1, paramString2);
    }
    return false;
  }
  
  public boolean isSafeMode()
  {
    aji.a("[API]PackageManager_");
    return this.a.isSafeMode();
  }
  
  public List<ResolveInfo> queryBroadcastReceivers(Intent paramIntent, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.queryBroadcastReceivers(paramIntent, paramInt);
  }
  
  public List<ProviderInfo> queryContentProviders(String paramString, int paramInt1, int paramInt2)
  {
    aji.a("[API]PackageManager_");
    return this.a.queryContentProviders(paramString, paramInt1, paramInt2);
  }
  
  public List<InstrumentationInfo> queryInstrumentation(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.queryInstrumentation(paramString, paramInt);
  }
  
  public List<ResolveInfo> queryIntentActivities(Intent paramIntent, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.queryIntentActivities(paramIntent, paramInt);
  }
  
  public List<ResolveInfo> queryIntentActivityOptions(ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
  }
  
  public List<ResolveInfo> queryIntentContentProviders(Intent paramIntent, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 19) {
      return this.a.queryIntentContentProviders(paramIntent, paramInt);
    }
    return null;
  }
  
  public List<ResolveInfo> queryIntentServices(Intent paramIntent, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.queryIntentServices(paramIntent, paramInt);
  }
  
  public List<PermissionInfo> queryPermissionsByGroup(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.queryPermissionsByGroup(paramString, paramInt);
  }
  
  public void removePackageFromPreferred(String paramString)
  {
    aji.a("[API]PackageManager_");
    this.a.removePackageFromPreferred(paramString);
  }
  
  public void removePermission(String paramString)
  {
    aji.a("[API]PackageManager_");
    this.a.removePermission(paramString);
  }
  
  public ResolveInfo resolveActivity(Intent paramIntent, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.resolveActivity(paramIntent, paramInt);
  }
  
  public ProviderInfo resolveContentProvider(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.resolveContentProvider(paramString, paramInt);
  }
  
  public ResolveInfo resolveService(Intent paramIntent, int paramInt)
  {
    aji.a("[API]PackageManager_");
    return this.a.resolveService(paramIntent, paramInt);
  }
  
  public void setApplicationCategoryHint(String paramString, int paramInt)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setApplicationCategoryHint(paramString, paramInt);
    }
  }
  
  public void setApplicationEnabledSetting(String paramString, int paramInt1, int paramInt2)
  {
    aji.a("[API]PackageManager_");
    this.a.setApplicationEnabledSetting(paramString, paramInt1, paramInt2);
  }
  
  public void setComponentEnabledSetting(ComponentName paramComponentName, int paramInt1, int paramInt2)
  {
    aji.a("[API]PackageManager_");
    this.a.setComponentEnabledSetting(paramComponentName, paramInt1, paramInt2);
  }
  
  public void setInstallerPackageName(String paramString1, String paramString2)
  {
    aji.a("[API]PackageManager_");
    this.a.setInstallerPackageName(paramString1, paramString2);
  }
  
  public void updateInstantAppCookie(byte[] paramArrayOfByte)
  {
    aji.a("[API]PackageManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.updateInstantAppCookie(paramArrayOfByte);
    }
  }
  
  public void verifyPendingInstall(int paramInt1, int paramInt2)
  {
    aji.a("[API]PackageManager_");
    this.a.verifyPendingInstall(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajc
 * JD-Core Version:    0.7.0.1
 */