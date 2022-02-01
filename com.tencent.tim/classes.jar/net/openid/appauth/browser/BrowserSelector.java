package net.openid.appauth.browser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class BrowserSelector
{
  @VisibleForTesting
  static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
  @VisibleForTesting
  static final Intent BROWSER_INTENT = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
  private static final String SCHEME_HTTP = "http";
  private static final String SCHEME_HTTPS = "https";
  
  @SuppressLint({"PackageManagerGetSignatures"})
  @NonNull
  public static List<BrowserDescriptor> getAllBrowsers(Context paramContext)
  {
    int i = 64;
    paramContext = paramContext.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 23) {
      i = 131136;
    }
    Iterator localIterator = paramContext.queryIntentActivities(BROWSER_INTENT, i).iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if (isFullBrowser(localResolveInfo)) {
        try
        {
          PackageInfo localPackageInfo = paramContext.getPackageInfo(localResolveInfo.activityInfo.packageName, 64);
          if (hasWarmupService(paramContext, localResolveInfo.activityInfo.packageName)) {
            localArrayList.add(new BrowserDescriptor(localPackageInfo, true));
          }
          localArrayList.add(new BrowserDescriptor(localPackageInfo, false));
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      }
    }
    return localArrayList;
  }
  
  private static boolean hasWarmupService(PackageManager paramPackageManager, String paramString)
  {
    boolean bool = false;
    Intent localIntent = new Intent();
    localIntent.setAction("android.support.customtabs.action.CustomTabsService");
    localIntent.setPackage(paramString);
    if (paramPackageManager.resolveService(localIntent, 0) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isFullBrowser(ResolveInfo paramResolveInfo)
  {
    if ((!paramResolveInfo.filter.hasAction("android.intent.action.VIEW")) || (!paramResolveInfo.filter.hasCategory("android.intent.category.BROWSABLE")) || (paramResolveInfo.filter.schemesIterator() == null)) {}
    for (;;)
    {
      return false;
      if (paramResolveInfo.filter.authoritiesIterator() == null)
      {
        paramResolveInfo = paramResolveInfo.filter.schemesIterator();
        boolean bool1 = false;
        boolean bool2 = false;
        while (paramResolveInfo.hasNext())
        {
          String str = (String)paramResolveInfo.next();
          bool2 |= "http".equals(str);
          bool1 = "https".equals(str) | bool1;
          if ((bool2) && (bool1)) {
            return true;
          }
        }
      }
    }
  }
  
  @SuppressLint({"PackageManagerGetSignatures"})
  @Nullable
  public static BrowserDescriptor select(Context paramContext, BrowserMatcher paramBrowserMatcher)
  {
    Object localObject = getAllBrowsers(paramContext);
    paramContext = null;
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (BrowserDescriptor)localIterator.next();
      if (paramBrowserMatcher.matches((BrowserDescriptor)localObject))
      {
        if (((BrowserDescriptor)localObject).useCustomTab.booleanValue()) {
          return localObject;
        }
        if (paramContext != null) {
          break label66;
        }
        paramContext = (Context)localObject;
      }
    }
    label66:
    for (;;)
    {
      break;
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.BrowserSelector
 * JD-Core Version:    0.7.0.1
 */