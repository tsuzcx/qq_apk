package com.tencent.token;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;

public final class ajz
{
  static PackageManager a;
  
  public static List<PackageInfo> a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("getInstalledPackages, flags:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    if (!ll.a()) {
      return null;
    }
    akg.a("[API]PackageManagerInvoke_");
    return a.getInstalledPackages(paramInt);
  }
  
  public static List<ResolveInfo> a(ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("queryIntentActivityOptions, flags:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    if (!ll.a()) {
      return null;
    }
    akg.a("[API]PackageManagerInvoke_");
    return a.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
  }
  
  public static List<ResolveInfo> a(Intent paramIntent, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("queryBroadcastReceivers, flags:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    if (!ll.a()) {
      return null;
    }
    akg.a("[API]PackageManagerInvoke_");
    return a.queryBroadcastReceivers(paramIntent, paramInt);
  }
  
  public static List<ApplicationInfo> b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("getInstalledApplications, flags:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    if (!ll.a()) {
      return null;
    }
    akg.a("[API]PackageManagerInvoke_");
    return a.getInstalledApplications(paramInt);
  }
  
  public static List<ResolveInfo> b(Intent paramIntent, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("queryIntentServices, flags:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    if (!ll.a()) {
      return null;
    }
    akg.a("[API]PackageManagerInvoke_");
    return a.queryIntentServices(paramIntent, paramInt);
  }
  
  public static List<ResolveInfo> c(Intent paramIntent, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("queryIntentActivities, flags:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    if (!ll.a()) {
      return null;
    }
    akg.a("[API]PackageManagerInvoke_");
    return a.queryIntentActivities(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajz
 * JD-Core Version:    0.7.0.1
 */