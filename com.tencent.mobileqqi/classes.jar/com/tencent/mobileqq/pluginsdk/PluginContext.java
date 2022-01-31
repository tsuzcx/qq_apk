package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.ContextThemeWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class PluginContext
  extends ContextThemeWrapper
{
  private static final String TAG = PluginContext.class.getSimpleName();
  private AssetManager mAsset = null;
  private ClassLoader mClassLoader;
  private Context mOutContext;
  private Resources mResources = null;
  private Resources.Theme mTheme = null;
  private int mThemeResId;
  
  public PluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader)
  {
    this(paramContext, paramInt, paramString, paramClassLoader, null);
  }
  
  public PluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader, Resources paramResources)
  {
    super(paramContext, paramInt);
    this.mClassLoader = paramClassLoader;
    if (paramResources != null) {
      this.mAsset = paramResources.getAssets();
    }
    for (this.mResources = paramResources;; this.mResources = getSelfRes(paramContext, this.mAsset))
    {
      this.mTheme = getSelfTheme(this.mResources);
      this.mOutContext = paramContext;
      return;
      this.mAsset = getSelfAssets(paramString);
    }
  }
  
  private int getInnerRIdValue(String paramString)
  {
    int j = -1;
    int i = j;
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      i = j;
      int k = paramString.lastIndexOf(".");
      i = j;
      String str1 = paramString.substring(k + 1, paramString.length());
      i = j;
      paramString = paramString.substring(0, k);
      i = j;
      String str3 = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      i = j;
      str2 = str2 + "$" + str3;
      i = j;
      j = Class.forName(str2).getDeclaredField(str1).getInt(null);
      i = j;
      if (DebugHelper.sDebug)
      {
        i = j;
        DebugHelper.log("PluginDebug", "getInnderR rStrnig:" + paramString);
        i = j;
        DebugHelper.log("PluginDebug", "getInnderR className:" + str2);
        i = j;
        DebugHelper.log("PluginDebug", "getInnderR fieldName:" + str1);
      }
      return j;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return i;
  }
  
  private AssetManager getSelfAssets(String paramString)
  {
    Object localObject = null;
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localObject = localAssetManager;
      AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
      return localAssetManager;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return localObject;
  }
  
  private Resources getSelfRes(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  private Resources.Theme getSelfTheme(Resources paramResources)
  {
    paramResources = paramResources.newTheme();
    this.mThemeResId = getInnerRIdValue("com.android.internal.R.style.Theme");
    paramResources.applyStyle(this.mThemeResId, true);
    return paramResources;
  }
  
  public AssetManager getAssets()
  {
    return this.mAsset;
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.mClassLoader != null) {
      return this.mClassLoader;
    }
    return super.getClassLoader();
  }
  
  public Resources getRes()
  {
    return this.mResources;
  }
  
  public Resources getResources()
  {
    return this.mResources;
  }
  
  public Resources.Theme getTheme()
  {
    return this.mTheme;
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginContext
 * JD-Core Version:    0.7.0.1
 */