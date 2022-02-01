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

public class PluginContext
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
  
  /* Error */
  private static Resources createResources(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 106
    //   4: invokevirtual 110	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   7: checkcast 106	android/content/res/AssetManager
    //   10: astore 4
    //   12: ldc 106
    //   14: ldc 112
    //   16: iconst_1
    //   17: anewarray 25	java/lang/Class
    //   20: dup
    //   21: iconst_0
    //   22: ldc 47
    //   24: aastore
    //   25: invokevirtual 116	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: astore 5
    //   30: aload_1
    //   31: arraylength
    //   32: istore_3
    //   33: iload_2
    //   34: iload_3
    //   35: if_icmpge +28 -> 63
    //   38: aload 5
    //   40: aload 4
    //   42: iconst_1
    //   43: anewarray 118	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: iload_2
    //   50: aaload
    //   51: aastore
    //   52: invokevirtual 124	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: iload_2
    //   57: iconst_1
    //   58: iadd
    //   59: istore_2
    //   60: goto -27 -> 33
    //   63: aload_0
    //   64: aload 4
    //   66: invokestatic 126	com/tencent/mobileqq/pluginsdk/PluginContext:createResources	(Landroid/content/Context;Landroid/content/res/AssetManager;)Landroid/content/res/Resources;
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 88	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   74: aload_0
    //   75: invokevirtual 84	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   78: invokevirtual 88	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   81: invokevirtual 132	android/util/DisplayMetrics:setTo	(Landroid/util/DisplayMetrics;)V
    //   84: aload_1
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_0
    //   90: invokevirtual 135	java/lang/InstantiationException:printStackTrace	()V
    //   93: aload_1
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_0
    //   99: invokevirtual 136	java/lang/IllegalAccessException:printStackTrace	()V
    //   102: aload_1
    //   103: areturn
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_0
    //   108: invokevirtual 137	java/lang/NoSuchMethodException:printStackTrace	()V
    //   111: aload_1
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_0
    //   117: invokevirtual 138	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   120: aload_1
    //   121: areturn
    //   122: astore_0
    //   123: goto -7 -> 116
    //   126: astore_0
    //   127: goto -20 -> 107
    //   130: astore_0
    //   131: goto -33 -> 98
    //   134: astore_0
    //   135: goto -46 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramContext	Context
    //   0	138	1	paramArrayOfString	String[]
    //   1	59	2	i	int
    //   32	4	3	j	int
    //   10	55	4	localAssetManager	AssetManager
    //   28	11	5	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   2	33	86	java/lang/InstantiationException
    //   38	56	86	java/lang/InstantiationException
    //   63	70	86	java/lang/InstantiationException
    //   2	33	95	java/lang/IllegalAccessException
    //   38	56	95	java/lang/IllegalAccessException
    //   63	70	95	java/lang/IllegalAccessException
    //   2	33	104	java/lang/NoSuchMethodException
    //   38	56	104	java/lang/NoSuchMethodException
    //   63	70	104	java/lang/NoSuchMethodException
    //   2	33	113	java/lang/reflect/InvocationTargetException
    //   38	56	113	java/lang/reflect/InvocationTargetException
    //   63	70	113	java/lang/reflect/InvocationTargetException
    //   70	84	122	java/lang/reflect/InvocationTargetException
    //   70	84	126	java/lang/NoSuchMethodException
    //   70	84	130	java/lang/IllegalAccessException
    //   70	84	134	java/lang/InstantiationException
  }
  
  private static void createTheme(ContextRIT paramContextRIT)
  {
    Resources.Theme localTheme = paramContextRIT.mR.newTheme();
    localTheme.applyStyle(getInnerRIdValue("com.android.internal.R.style.Theme"), true);
    paramContextRIT.mT = localTheme;
  }
  
  private static int getInnerRIdValue(String paramString)
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
        break label179;
      }
      paramString = paramString;
      i = -1;
    }
    label179:
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
  
  public void setTheme(Resources.Theme paramTheme)
  {
    if (this.mRIT != null) {
      this.mRIT.mT = paramTheme;
    }
  }
  
  static class ContextRIT
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginContext
 * JD-Core Version:    0.7.0.1
 */