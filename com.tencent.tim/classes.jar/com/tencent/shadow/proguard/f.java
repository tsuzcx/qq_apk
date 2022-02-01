package com.tencent.shadow.proguard;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;

final class f
  extends ContextWrapper
{
  private Resources a;
  private LayoutInflater b;
  private final ClassLoader c;
  
  f(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    super(paramContext);
    this.c = paramClassLoader;
    this.a = a(paramString, paramContext);
  }
  
  private static Resources a(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    PackageInfo localPackageInfo = paramContext.getPackageArchiveInfo(paramString, 128);
    localPackageInfo.applicationInfo.publicSourceDir = paramString;
    localPackageInfo.applicationInfo.sourceDir = paramString;
    try
    {
      paramString = paramContext.getResourcesForApplication(localPackageInfo.applicationInfo);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public final AssetManager getAssets()
  {
    return this.a.getAssets();
  }
  
  public final ClassLoader getClassLoader()
  {
    return this.c;
  }
  
  public final Resources getResources()
  {
    return this.a;
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.b == null) {
        this.b = ((LayoutInflater)super.getSystemService(paramString)).cloneInContext(this);
      }
      return this.b;
    }
    return super.getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    return this.a.newTheme();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.proguard.f
 * JD-Core Version:    0.7.0.1
 */