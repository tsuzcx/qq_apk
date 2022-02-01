package com.oasisfeng.condom;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.InstrumentationInfo;
import android.content.pm.KeySet;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageItemInfo;
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
import android.os.Bundle;
import android.os.UserHandle;
import android.support.annotation.Keep;
import java.util.List;

@Keep
public class PackageManagerWrapper
  extends PackageManager
{
  private final PackageManager mBase;
  
  public PackageManagerWrapper(PackageManager paramPackageManager)
  {
    this.mBase = paramPackageManager;
  }
  
  public void addPackageToPreferred(String paramString)
  {
    this.mBase.addPackageToPreferred(paramString);
  }
  
  public boolean addPermission(PermissionInfo paramPermissionInfo)
  {
    return this.mBase.addPermission(paramPermissionInfo);
  }
  
  public boolean addPermissionAsync(PermissionInfo paramPermissionInfo)
  {
    return this.mBase.addPermissionAsync(paramPermissionInfo);
  }
  
  public void addPreferredActivity(IntentFilter paramIntentFilter, int paramInt, ComponentName[] paramArrayOfComponentName, ComponentName paramComponentName)
  {
    this.mBase.addPreferredActivity(paramIntentFilter, paramInt, paramArrayOfComponentName, paramComponentName);
  }
  
  public Intent buildRequestPermissionsIntent(String[] paramArrayOfString)
  {
    return this.mBase.buildRequestPermissionsIntent(paramArrayOfString);
  }
  
  public boolean canRequestPackageInstalls()
  {
    return this.mBase.canRequestPackageInstalls();
  }
  
  public String[] canonicalToCurrentPackageNames(String[] paramArrayOfString)
  {
    return this.mBase.canonicalToCurrentPackageNames(paramArrayOfString);
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    return this.mBase.checkPermission(paramString1, paramString2);
  }
  
  public int checkSignatures(int paramInt1, int paramInt2)
  {
    return this.mBase.checkSignatures(paramInt1, paramInt2);
  }
  
  public int checkSignatures(String paramString1, String paramString2)
  {
    return this.mBase.checkSignatures(paramString1, paramString2);
  }
  
  public void clearInstantAppCookie()
  {
    this.mBase.clearInstantAppCookie();
  }
  
  public void clearPackagePreferredActivities(String paramString)
  {
    this.mBase.clearPackagePreferredActivities(paramString);
  }
  
  public String[] currentToCanonicalPackageNames(String[] paramArrayOfString)
  {
    return this.mBase.currentToCanonicalPackageNames(paramArrayOfString);
  }
  
  public void extendVerificationTimeout(int paramInt1, int paramInt2, long paramLong)
  {
    this.mBase.extendVerificationTimeout(paramInt1, paramInt2, paramLong);
  }
  
  public void flushPackageRestrictionsAsUser(int paramInt)
  {
    this.mBase.flushPackageRestrictionsAsUser(paramInt);
  }
  
  public Drawable getActivityBanner(ComponentName paramComponentName)
  {
    return this.mBase.getActivityBanner(paramComponentName);
  }
  
  public Drawable getActivityBanner(Intent paramIntent)
  {
    return this.mBase.getActivityBanner(paramIntent);
  }
  
  public Drawable getActivityIcon(ComponentName paramComponentName)
  {
    return this.mBase.getActivityIcon(paramComponentName);
  }
  
  public Drawable getActivityIcon(Intent paramIntent)
  {
    return this.mBase.getActivityIcon(paramIntent);
  }
  
  public ActivityInfo getActivityInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getActivityInfo(paramComponentName, paramInt);
  }
  
  public Drawable getActivityLogo(ComponentName paramComponentName)
  {
    return this.mBase.getActivityLogo(paramComponentName);
  }
  
  public Drawable getActivityLogo(Intent paramIntent)
  {
    return this.mBase.getActivityLogo(paramIntent);
  }
  
  public List<IntentFilter> getAllIntentFilters(String paramString)
  {
    return this.mBase.getAllIntentFilters(paramString);
  }
  
  public List<PermissionGroupInfo> getAllPermissionGroups(int paramInt)
  {
    return this.mBase.getAllPermissionGroups(paramInt);
  }
  
  public Drawable getApplicationBanner(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getApplicationBanner(paramApplicationInfo);
  }
  
  public Drawable getApplicationBanner(String paramString)
  {
    return this.mBase.getApplicationBanner(paramString);
  }
  
  public int getApplicationEnabledSetting(String paramString)
  {
    return this.mBase.getApplicationEnabledSetting(paramString);
  }
  
  public Drawable getApplicationIcon(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getApplicationIcon(paramApplicationInfo);
  }
  
  public Drawable getApplicationIcon(String paramString)
  {
    return this.mBase.getApplicationIcon(paramString);
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
  {
    return this.mBase.getApplicationInfo(paramString, paramInt);
  }
  
  public ApplicationInfo getApplicationInfoAsUser(String paramString, int paramInt1, int paramInt2)
  {
    return this.mBase.getApplicationInfoAsUser(paramString, paramInt1, paramInt2);
  }
  
  public CharSequence getApplicationLabel(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getApplicationLabel(paramApplicationInfo);
  }
  
  public Drawable getApplicationLogo(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getApplicationLogo(paramApplicationInfo);
  }
  
  public Drawable getApplicationLogo(String paramString)
  {
    return this.mBase.getApplicationLogo(paramString);
  }
  
  public ChangedPackages getChangedPackages(int paramInt)
  {
    return this.mBase.getChangedPackages(paramInt);
  }
  
  public int getComponentEnabledSetting(ComponentName paramComponentName)
  {
    return this.mBase.getComponentEnabledSetting(paramComponentName);
  }
  
  public Drawable getDefaultActivityIcon()
  {
    return this.mBase.getDefaultActivityIcon();
  }
  
  public Drawable getDrawable(String paramString, int paramInt, ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getDrawable(paramString, paramInt, paramApplicationInfo);
  }
  
  public ComponentName getHomeActivities(List<ResolveInfo> paramList)
  {
    return this.mBase.getHomeActivities(paramList);
  }
  
  public List<ApplicationInfo> getInstalledApplications(int paramInt)
  {
    return this.mBase.getInstalledApplications(paramInt);
  }
  
  public List<PackageInfo> getInstalledPackages(int paramInt)
  {
    return this.mBase.getInstalledPackages(paramInt);
  }
  
  public List<PackageInfo> getInstalledPackagesAsUser(int paramInt1, int paramInt2)
  {
    return this.mBase.getInstalledPackagesAsUser(paramInt1, paramInt2);
  }
  
  public String getInstallerPackageName(String paramString)
  {
    return this.mBase.getInstallerPackageName(paramString);
  }
  
  public byte[] getInstantAppCookie()
  {
    return this.mBase.getInstantAppCookie();
  }
  
  public int getInstantAppCookieMaxBytes()
  {
    return this.mBase.getInstantAppCookieMaxBytes();
  }
  
  public InstrumentationInfo getInstrumentationInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getInstrumentationInfo(paramComponentName, paramInt);
  }
  
  public KeySet getKeySetByAlias(String paramString1, String paramString2)
  {
    return this.mBase.getKeySetByAlias(paramString1, paramString2);
  }
  
  public Intent getLaunchIntentForPackage(String paramString)
  {
    return this.mBase.getLaunchIntentForPackage(paramString);
  }
  
  public Intent getLeanbackLaunchIntentForPackage(String paramString)
  {
    return this.mBase.getLeanbackLaunchIntentForPackage(paramString);
  }
  
  public Drawable getManagedUserBadgedDrawable(Drawable paramDrawable, Rect paramRect, int paramInt)
  {
    return this.mBase.getManagedUserBadgedDrawable(paramDrawable, paramRect, paramInt);
  }
  
  public String getNameForUid(int paramInt)
  {
    return this.mBase.getNameForUid(paramInt);
  }
  
  public String[] getNamesForUids(int[] paramArrayOfInt)
  {
    return this.mBase.getNamesForUids(paramArrayOfInt);
  }
  
  public PackageInfo getPackageArchiveInfo(String paramString, int paramInt)
  {
    return this.mBase.getPackageArchiveInfo(paramString, paramInt);
  }
  
  public int[] getPackageGids(String paramString)
  {
    return this.mBase.getPackageGids(paramString);
  }
  
  public int[] getPackageGids(String paramString, int paramInt)
  {
    return this.mBase.getPackageGids(paramString, paramInt);
  }
  
  public PackageInfo getPackageInfo(VersionedPackage paramVersionedPackage, int paramInt)
  {
    return this.mBase.getPackageInfo(paramVersionedPackage, paramInt);
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
  {
    return this.mBase.getPackageInfo(paramString, paramInt);
  }
  
  public PackageInfo getPackageInfoAsUser(String paramString, int paramInt1, int paramInt2)
  {
    return this.mBase.getPackageInfoAsUser(paramString, paramInt1, paramInt2);
  }
  
  public PackageInstaller getPackageInstaller()
  {
    return this.mBase.getPackageInstaller();
  }
  
  public void getPackageSizeInfo(String paramString, IPackageStatsObserver paramIPackageStatsObserver)
  {
    this.mBase.getPackageSizeInfo(paramString, paramIPackageStatsObserver);
  }
  
  public void getPackageSizeInfoAsUser(String paramString, int paramInt, IPackageStatsObserver paramIPackageStatsObserver)
  {
    this.mBase.getPackageSizeInfoAsUser(paramString, paramInt, paramIPackageStatsObserver);
  }
  
  public int getPackageUid(String paramString, int paramInt)
  {
    return this.mBase.getPackageUid(paramString, paramInt);
  }
  
  public int getPackageUidAsUser(String paramString, int paramInt)
  {
    return this.mBase.getPackageUidAsUser(paramString, paramInt);
  }
  
  public int getPackageUidAsUser(String paramString, int paramInt1, int paramInt2)
  {
    return this.mBase.getPackageUidAsUser(paramString, paramInt1, paramInt2);
  }
  
  public String[] getPackagesForUid(int paramInt)
  {
    return this.mBase.getPackagesForUid(paramInt);
  }
  
  public List<PackageInfo> getPackagesHoldingPermissions(String[] paramArrayOfString, int paramInt)
  {
    return this.mBase.getPackagesHoldingPermissions(paramArrayOfString, paramInt);
  }
  
  public String getPermissionControllerPackageName()
  {
    return this.mBase.getPermissionControllerPackageName();
  }
  
  public PermissionGroupInfo getPermissionGroupInfo(String paramString, int paramInt)
  {
    return this.mBase.getPermissionGroupInfo(paramString, paramInt);
  }
  
  public PermissionInfo getPermissionInfo(String paramString, int paramInt)
  {
    return this.mBase.getPermissionInfo(paramString, paramInt);
  }
  
  public int getPreferredActivities(List<IntentFilter> paramList, List<ComponentName> paramList1, String paramString)
  {
    return this.mBase.getPreferredActivities(paramList, paramList1, paramString);
  }
  
  public List<PackageInfo> getPreferredPackages(int paramInt)
  {
    return this.mBase.getPreferredPackages(paramInt);
  }
  
  public ProviderInfo getProviderInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getProviderInfo(paramComponentName, paramInt);
  }
  
  public ActivityInfo getReceiverInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getReceiverInfo(paramComponentName, paramInt);
  }
  
  public Resources getResourcesForActivity(ComponentName paramComponentName)
  {
    return this.mBase.getResourcesForActivity(paramComponentName);
  }
  
  public Resources getResourcesForApplication(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getResourcesForApplication(paramApplicationInfo);
  }
  
  public Resources getResourcesForApplication(String paramString)
  {
    return this.mBase.getResourcesForApplication(paramString);
  }
  
  public Resources getResourcesForApplicationAsUser(String paramString, int paramInt)
  {
    return this.mBase.getResourcesForApplicationAsUser(paramString, paramInt);
  }
  
  public ServiceInfo getServiceInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getServiceInfo(paramComponentName, paramInt);
  }
  
  public String getServicesSystemSharedLibraryPackageName()
  {
    return this.mBase.getServicesSystemSharedLibraryPackageName();
  }
  
  public List<SharedLibraryInfo> getSharedLibraries(int paramInt)
  {
    return this.mBase.getSharedLibraries(paramInt);
  }
  
  public String getSharedSystemSharedLibraryPackageName()
  {
    return this.mBase.getSharedSystemSharedLibraryPackageName();
  }
  
  public KeySet getSigningKeySet(String paramString)
  {
    return this.mBase.getSigningKeySet(paramString);
  }
  
  public Bundle getSuspendedPackageAppExtras()
  {
    return this.mBase.getSuspendedPackageAppExtras();
  }
  
  public FeatureInfo[] getSystemAvailableFeatures()
  {
    return this.mBase.getSystemAvailableFeatures();
  }
  
  public String[] getSystemSharedLibraryNames()
  {
    return this.mBase.getSystemSharedLibraryNames();
  }
  
  public String getSystemTextClassifierPackageName()
  {
    return this.mBase.getSystemTextClassifierPackageName();
  }
  
  public CharSequence getText(String paramString, int paramInt, ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getText(paramString, paramInt, paramApplicationInfo);
  }
  
  public int getUidForSharedUser(String paramString)
  {
    return this.mBase.getUidForSharedUser(paramString);
  }
  
  public Drawable getUserBadgeForDensity(UserHandle paramUserHandle, int paramInt)
  {
    return this.mBase.getUserBadgeForDensity(paramUserHandle, paramInt);
  }
  
  public Drawable getUserBadgeForDensityNoBackground(UserHandle paramUserHandle, int paramInt)
  {
    return this.mBase.getUserBadgeForDensityNoBackground(paramUserHandle, paramInt);
  }
  
  public Drawable getUserBadgedDrawableForDensity(Drawable paramDrawable, UserHandle paramUserHandle, Rect paramRect, int paramInt)
  {
    return this.mBase.getUserBadgedDrawableForDensity(paramDrawable, paramUserHandle, paramRect, paramInt);
  }
  
  public Drawable getUserBadgedIcon(Drawable paramDrawable, UserHandle paramUserHandle)
  {
    return this.mBase.getUserBadgedIcon(paramDrawable, paramUserHandle);
  }
  
  public CharSequence getUserBadgedLabel(CharSequence paramCharSequence, UserHandle paramUserHandle)
  {
    return this.mBase.getUserBadgedLabel(paramCharSequence, paramUserHandle);
  }
  
  public XmlResourceParser getXml(String paramString, int paramInt, ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getXml(paramString, paramInt, paramApplicationInfo);
  }
  
  public boolean hasSigningCertificate(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return this.mBase.hasSigningCertificate(paramString, paramArrayOfByte, paramInt);
  }
  
  public boolean hasSystemFeature(String paramString)
  {
    return this.mBase.hasSystemFeature(paramString);
  }
  
  public boolean hasSystemFeature(String paramString, int paramInt)
  {
    return this.mBase.hasSystemFeature(paramString, paramInt);
  }
  
  public boolean isInstantApp()
  {
    return this.mBase.isInstantApp();
  }
  
  public boolean isInstantApp(String paramString)
  {
    return this.mBase.isInstantApp(paramString);
  }
  
  public boolean isPackageAvailable(String paramString)
  {
    return this.mBase.isPackageAvailable(paramString);
  }
  
  public boolean isPackageStateProtected(String paramString, int paramInt)
  {
    return this.mBase.isPackageStateProtected(paramString, paramInt);
  }
  
  public boolean isPackageSuspended()
  {
    return this.mBase.isPackageSuspended();
  }
  
  public boolean isPackageSuspendedForUser(String paramString, int paramInt)
  {
    return this.mBase.isPackageSuspendedForUser(paramString, paramInt);
  }
  
  public boolean isPermissionRevokedByPolicy(String paramString1, String paramString2)
  {
    return this.mBase.isPermissionRevokedByPolicy(paramString1, paramString2);
  }
  
  public boolean isSafeMode()
  {
    return this.mBase.isSafeMode();
  }
  
  public boolean isSignedBy(String paramString, KeySet paramKeySet)
  {
    return this.mBase.isSignedBy(paramString, paramKeySet);
  }
  
  public boolean isSignedByExactly(String paramString, KeySet paramKeySet)
  {
    return this.mBase.isSignedByExactly(paramString, paramKeySet);
  }
  
  public boolean isUpgrade()
  {
    return this.mBase.isUpgrade();
  }
  
  public Drawable loadItemIcon(PackageItemInfo paramPackageItemInfo, ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.loadItemIcon(paramPackageItemInfo, paramApplicationInfo);
  }
  
  public Drawable loadUnbadgedItemIcon(PackageItemInfo paramPackageItemInfo, ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.loadUnbadgedItemIcon(paramPackageItemInfo, paramApplicationInfo);
  }
  
  public List<ResolveInfo> queryBroadcastReceivers(Intent paramIntent, int paramInt)
  {
    return this.mBase.queryBroadcastReceivers(paramIntent, paramInt);
  }
  
  @Deprecated
  public List<ResolveInfo> queryBroadcastReceivers(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.mBase.queryBroadcastReceivers(paramIntent, paramInt1, paramInt2);
  }
  
  public List<ResolveInfo> queryBroadcastReceiversAsUser(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.mBase.queryBroadcastReceiversAsUser(paramIntent, paramInt1, paramInt2);
  }
  
  public List<ResolveInfo> queryBroadcastReceiversAsUser(Intent paramIntent, int paramInt, UserHandle paramUserHandle)
  {
    return this.mBase.queryBroadcastReceiversAsUser(paramIntent, paramInt, paramUserHandle);
  }
  
  public List<ProviderInfo> queryContentProviders(String paramString, int paramInt1, int paramInt2)
  {
    return this.mBase.queryContentProviders(paramString, paramInt1, paramInt2);
  }
  
  public List<InstrumentationInfo> queryInstrumentation(String paramString, int paramInt)
  {
    return this.mBase.queryInstrumentation(paramString, paramInt);
  }
  
  public List<ResolveInfo> queryIntentActivities(Intent paramIntent, int paramInt)
  {
    return this.mBase.queryIntentActivities(paramIntent, paramInt);
  }
  
  public List<ResolveInfo> queryIntentActivitiesAsUser(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.mBase.queryIntentActivitiesAsUser(paramIntent, paramInt1, paramInt2);
  }
  
  public List<ResolveInfo> queryIntentActivityOptions(ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt)
  {
    return this.mBase.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
  }
  
  public List<ResolveInfo> queryIntentContentProviders(Intent paramIntent, int paramInt)
  {
    return this.mBase.queryIntentContentProviders(paramIntent, paramInt);
  }
  
  public List<ResolveInfo> queryIntentContentProvidersAsUser(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.mBase.queryIntentContentProvidersAsUser(paramIntent, paramInt1, paramInt2);
  }
  
  public List<ResolveInfo> queryIntentServices(Intent paramIntent, int paramInt)
  {
    return this.mBase.queryIntentServices(paramIntent, paramInt);
  }
  
  public List<ResolveInfo> queryIntentServicesAsUser(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.mBase.queryIntentServicesAsUser(paramIntent, paramInt1, paramInt2);
  }
  
  public List<PermissionInfo> queryPermissionsByGroup(String paramString, int paramInt)
  {
    return this.mBase.queryPermissionsByGroup(paramString, paramInt);
  }
  
  public void removePackageFromPreferred(String paramString)
  {
    this.mBase.removePackageFromPreferred(paramString);
  }
  
  public void removePermission(String paramString)
  {
    this.mBase.removePermission(paramString);
  }
  
  public ResolveInfo resolveActivity(Intent paramIntent, int paramInt)
  {
    return this.mBase.resolveActivity(paramIntent, paramInt);
  }
  
  public ResolveInfo resolveActivityAsUser(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.mBase.resolveActivityAsUser(paramIntent, paramInt1, paramInt2);
  }
  
  public ProviderInfo resolveContentProvider(String paramString, int paramInt)
  {
    return this.mBase.resolveContentProvider(paramString, paramInt);
  }
  
  public ProviderInfo resolveContentProviderAsUser(String paramString, int paramInt1, int paramInt2)
  {
    return this.mBase.resolveContentProviderAsUser(paramString, paramInt1, paramInt2);
  }
  
  public ResolveInfo resolveService(Intent paramIntent, int paramInt)
  {
    return this.mBase.resolveService(paramIntent, paramInt);
  }
  
  public ResolveInfo resolveServiceAsUser(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.mBase.resolveServiceAsUser(paramIntent, paramInt1, paramInt2);
  }
  
  public void setApplicationCategoryHint(String paramString, int paramInt)
  {
    this.mBase.setApplicationCategoryHint(paramString, paramInt);
  }
  
  public void setApplicationEnabledSetting(String paramString, int paramInt1, int paramInt2)
  {
    this.mBase.setApplicationEnabledSetting(paramString, paramInt1, paramInt2);
  }
  
  public void setComponentEnabledSetting(ComponentName paramComponentName, int paramInt1, int paramInt2)
  {
    this.mBase.setComponentEnabledSetting(paramComponentName, paramInt1, paramInt2);
  }
  
  public void setInstallerPackageName(String paramString1, String paramString2)
  {
    this.mBase.setInstallerPackageName(paramString1, paramString2);
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    return this.mBase.shouldShowRequestPermissionRationale(paramString);
  }
  
  public void updateInstantAppCookie(byte[] paramArrayOfByte)
  {
    this.mBase.updateInstantAppCookie(paramArrayOfByte);
  }
  
  public void verifyPendingInstall(int paramInt1, int paramInt2)
  {
    this.mBase.verifyPendingInstall(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.PackageManagerWrapper
 * JD-Core Version:    0.7.0.1
 */