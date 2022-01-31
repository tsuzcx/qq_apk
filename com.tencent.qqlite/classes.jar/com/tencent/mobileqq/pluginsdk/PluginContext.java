package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.ContextThemeWrapper;
import com.tencent.commonsdk.soload.SoLoadCore;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

class PluginContext
  extends ContextThemeWrapper
{
  private static final String TAG = PluginContext.class.getSimpleName();
  private static final boolean USE_RESOURCES_CACHE = false;
  private static final HashMap<String, ContextRIT> sResourcesCache = new HashMap();
  private ClassLoader mClassLoader;
  private Context mOutContext;
  private ContextRIT mRIT;
  
  public PluginContext(Context paramContext, int paramInt1, String paramString, ClassLoader paramClassLoader, Resources paramResources, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.mClassLoader = paramClassLoader;
    if (paramInt2 == 2) {
      paramString = getOrCreateRIT(paramContext, new String[] { SoLoadCore.getApkPath(MobileQQ.getContext()), paramString });
    }
    for (;;)
    {
      this.mRIT = paramString;
      this.mOutContext = paramContext;
      return;
      if (paramInt2 == 1)
      {
        paramString = new ContextRIT(null, paramResources);
        createTheme(paramString);
      }
      else
      {
        paramString = getOrCreateRIT(paramContext, new String[] { paramString });
      }
    }
  }
  
  private static Resources createResources(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  private static Resources createResources(Context paramContext, String[] paramArrayOfString)
  {
    AssetManager localAssetManager = new AssetManager();
    localAssetManager.addAssetPaths(paramArrayOfString);
    return createResources(paramContext, localAssetManager);
  }
  
  private static void createTheme(ContextRIT paramContextRIT)
  {
    Resources.Theme localTheme = paramContextRIT.mR.newTheme();
    localTheme.applyStyle(getInnerRIdValue("com.android.internal.R.style.Theme"), true);
    paramContextRIT.mT = localTheme;
  }
  
  private static int getInnerRIdValue(String paramString)
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
        DebugHelper.log("plugin_tag", "getInnderR rStrnig:" + paramString);
        i = j;
        DebugHelper.log("plugin_tag", "getInnderR className:" + str2);
        i = j;
        DebugHelper.log("plugin_tag", "getInnderR fieldName:" + str1);
      }
      return j;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return i;
  }
  
  private static ContextRIT getOrCreateRIT(Context paramContext, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    Collections.sort(localArrayList);
    paramContext = new ContextRIT(null, createResources(paramContext, paramVarArgs));
    createTheme(paramContext);
    return paramContext;
  }
  
  public AssetManager getAssets()
  {
    return this.mRIT.mR.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.mClassLoader != null) {
      return this.mClassLoader;
    }
    return super.getClassLoader();
  }
  
  public Context getOutContext()
  {
    return this.mOutContext;
  }
  
  public Resources getResources()
  {
    return this.mRIT.mR;
  }
  
  public Resources.Theme getTheme()
  {
    return this.mRIT.mT;
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
  }
  
  private static class ContextRIT
  {
    public Resources mR;
    public Resources.Theme mT;
    
    public ContextRIT(Resources.Theme paramTheme, Resources paramResources)
    {
      this.mT = paramTheme;
      this.mR = paramResources;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginContext
 * JD-Core Version:    0.7.0.1
 */