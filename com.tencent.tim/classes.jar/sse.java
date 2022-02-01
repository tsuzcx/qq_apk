import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.tencent.mobileqq.pluginsdk.DebugHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class sse
  extends ContextThemeWrapper
{
  private AssetManager a;
  private ClassLoader mClassLoader;
  private Resources mResources;
  private Resources.Theme mTheme;
  private int mThemeResId;
  
  public sse(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader)
  {
    this(paramContext, paramInt, paramString, paramClassLoader, null, true);
  }
  
  public sse(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader, Resources paramResources, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.mClassLoader = paramClassLoader;
    if (paramResources != null)
    {
      this.a = paramResources.getAssets();
      this.mResources = paramResources;
    }
    for (;;)
    {
      if (this.mResources != null) {
        this.mTheme = a(this.mResources);
      }
      return;
      paramResources = getApkPath(paramContext);
      if ((!TextUtils.isEmpty(paramResources)) && (paramBoolean))
      {
        paramClassLoader = new String[2];
        paramClassLoader[0] = paramResources;
        paramClassLoader[1] = paramString;
        if (QLog.isColorLevel()) {
          QLog.d("ViewPluginContext", 2, "qq path:" + paramResources + ", apk path:" + paramString);
        }
        if (Build.VERSION.SDK_INT < 27) {
          break label276;
        }
        paramContext = paramContext.getPackageManager();
        paramClassLoader = paramContext.getPackageArchiveInfo(paramString, 143);
        if (paramClassLoader.applicationInfo == null) {
          break label265;
        }
        paramClassLoader.applicationInfo.sourceDir = paramString;
        paramClassLoader.applicationInfo.publicSourceDir = paramString;
        if (TextUtils.isEmpty(paramClassLoader.applicationInfo.processName)) {
          paramClassLoader.applicationInfo.processName = "com.tencent.mobileqq";
        }
      }
      try
      {
        this.mResources = paramContext.getResourcesForApplication(paramClassLoader.applicationInfo);
        if (this.mResources == null) {
          continue;
        }
        this.a = this.mResources.getAssets();
        continue;
        paramClassLoader = new String[1];
        paramClassLoader[0] = paramString;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          QLog.e("ViewPluginContext arendgx", 1, paramContext, new Object[0]);
        }
      }
      label265:
      QLog.e("ViewPluginContext arendgx", 1, "error : mPackageInfo.applicationInfo == null");
      continue;
      label276:
      this.a = a(paramClassLoader);
      this.mResources = a(paramContext, this.a);
    }
  }
  
  public sse(Context paramContext, int paramInt, sse paramsse)
  {
    super(paramContext, paramInt);
    this.mClassLoader = paramsse.mClassLoader;
    this.a = paramsse.a;
    this.mTheme = paramsse.mTheme;
    this.mResources = paramsse.mResources;
    this.mThemeResId = paramsse.mThemeResId;
  }
  
  private AssetManager a(String[] paramArrayOfString)
  {
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        AssetManager.class.getDeclaredMethod("addAssetPaths", new Class[] { [Ljava.lang.String.class }).invoke(localAssetManager, new Object[] { paramArrayOfString });
        return localAssetManager;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramArrayOfString = localThrowable1;
          Object localObject = localThrowable2;
        }
      }
      localThrowable1 = localThrowable1;
      paramArrayOfString = null;
    }
    return paramArrayOfString;
  }
  
  private Resources.Theme a(Resources paramResources)
  {
    paramResources = paramResources.newTheme();
    this.mThemeResId = getInnerRIdValue("com.android.internal.R.style.Theme");
    paramResources.applyStyle(this.mThemeResId, true);
    return paramResources;
  }
  
  private Resources a(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  public static String getApkPath(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      localObject2 = ((PackageManager)localObject2).getApplicationInfo(paramContext, 8192);
      paramContext = localObject1;
      if (localObject2 != null) {
        paramContext = ((ApplicationInfo)localObject2).sourceDir;
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private int getInnerRIdValue(String paramString)
  {
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      i = paramString.lastIndexOf(".");
      String str1 = paramString.substring(i + 1, paramString.length());
      paramString = paramString.substring(0, i);
      String str3 = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      str2 = str2 + "$" + str3;
      i = Class.forName(str2).getDeclaredField(str1).getInt(null);
      paramString.printStackTrace();
    }
    catch (Throwable paramString)
    {
      try
      {
        if (DebugHelper.sDebug)
        {
          DebugHelper.log("plugin_tag", "getInnderR rStrnig:" + paramString);
          DebugHelper.log("plugin_tag", "getInnderR className:" + str2);
          DebugHelper.log("plugin_tag", "getInnderR fieldName:" + str1);
        }
        return i;
      }
      catch (Throwable paramString)
      {
        int i;
        break label186;
      }
      paramString = paramString;
      i = -1;
    }
    label186:
    return i;
  }
  
  public AssetManager getAssets()
  {
    return this.a;
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.mClassLoader != null) {
      return this.mClassLoader;
    }
    return super.getClassLoader();
  }
  
  public Resources getResources()
  {
    return this.mResources;
  }
  
  public Resources.Theme getTheme()
  {
    return this.mTheme;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sse
 * JD-Core Version:    0.7.0.1
 */