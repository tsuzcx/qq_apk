package moai.patch.resource;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import moai.patch.log.PatchLog;
import moai.patch.util.VersionUtil;

public class MoaiResourceLoader
{
  private static final String BAIDU_ASSET_MANAGER_CLASS_FULL_NAME = "android.content.res.BaiduAssetManager";
  private static final String MOAI_PATCH_FINGERPRINT = "moai_patch_fingerPrint";
  private static AssetManager originAssetManager = null;
  
  public static boolean attachPatchResources(ContextWrapper paramContextWrapper, File paramFile)
    throws Exception
  {
    String str = paramFile.getAbsolutePath() + File.separator + "patch.apk";
    if (new File(str).exists()) {
      return hackAssetManager(paramContextWrapper, str, paramFile);
    }
    PatchLog.w(4003, "apk path:" + str);
    return false;
  }
  
  private static Collection<WeakReference<Resources>> findAllResourcesRef()
    throws Exception
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      localObject1 = Class.forName("android.app.ResourcesManager");
      localObject2 = ((Class)localObject1).getDeclaredMethod("getInstance", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      try
      {
        Object localObject3 = ((Class)localObject1).getDeclaredField("mActiveResources");
        ((Field)localObject3).setAccessible(true);
        localObject3 = ((ArrayMap)((Field)localObject3).get(localObject2)).values();
        return localObject3;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mResourceReferences");
        ((Field)localObject1).setAccessible(true);
        return (Collection)((Field)localObject1).get(localObject2);
      }
    }
    Object localObject1 = Class.forName("android.app.ActivityThread");
    Object localObject2 = ((Class)localObject1).getDeclaredField("mActiveResources");
    ((Field)localObject2).setAccessible(true);
    return ((HashMap)((Field)localObject2).get(((Class)localObject1).getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]))).values();
  }
  
  private static int getMoaiPatchFingerPrintResId(Context paramContext)
  {
    return paramContext.getResources().getIdentifier("moai_patch_fingerPrint", "string", paramContext.getPackageName());
  }
  
  private static boolean hackAssetManager(Context paramContext, String paramString, File paramFile)
  {
    String str = safeGetString(paramContext, getMoaiPatchFingerPrintResId(paramContext));
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 24) {
          Hack.clazz(ApplicationInfo.class).field("publicSourceDir").set(paramContext.getApplicationInfo(), paramString);
        }
        localObject1 = Hack.clazz("android.app.LoadedApk").field("mResDir");
        localObject2 = Hack.clazz("android.app.ActivityThread");
        localObject3 = ((Hack.HackedClass)localObject2).method("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        localObject4 = new String[2];
        localObject4[0] = "mPackages";
        localObject4[1] = "mResourcePackages";
        int j = localObject4.length;
        int i = 0;
        if (i >= j) {
          break;
        }
        Iterator localIterator = ((Map)((Hack.HackedClass)localObject2).field(localObject4[i]).get(localObject3)).values().iterator();
        if (localIterator.hasNext())
        {
          Object localObject5 = ((WeakReference)localIterator.next()).get();
          if (localObject5 != null) {
            ((Hack.HackedField)localObject1).set(localObject5, paramString);
          }
        }
        else
        {
          i += 1;
        }
      }
      catch (Throwable paramContext)
      {
        throw new IllegalStateException(paramContext);
      }
    }
    if (paramContext.getAssets().getClass().getName().equals("android.content.res.BaiduAssetManager")) {}
    for (Object localObject1 = (AssetManager)Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);; localObject1 = (AssetManager)AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]))
    {
      localObject2 = Hack.clazz(AssetManager.class);
      if (((Integer)((Hack.HackedClass)localObject2).method("addAssetPath", new Class[] { String.class }).invoke(localObject1, new Object[] { paramString })).intValue() != 0) {
        break;
      }
      throw new IllegalStateException("Could not create new AssetManager");
    }
    ((Hack.HackedClass)localObject2).method("ensureStringBlocks", new Class[0]).invoke(localObject1, new Object[0]);
    Object localObject2 = findAllResourcesRef().iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Resources)((WeakReference)((Iterator)localObject2).next()).get();
        if (localObject3 == null) {
          continue;
        }
        for (;;)
        {
          try
          {
            paramString = Resources.class.getDeclaredField("mResourcesImpl");
            paramString.setAccessible(true);
            localObject4 = paramString.get(localObject3);
          }
          catch (Throwable paramString)
          {
            paramString = Resources.class.getDeclaredField("mAssets");
            paramString.setAccessible(true);
            if (originAssetManager != null) {
              continue;
            }
            originAssetManager = (AssetManager)paramString.get(localObject3);
            paramString.set(localObject3, localObject1);
            continue;
          }
          try
          {
            paramString = localObject4.getClass().getDeclaredField("mAssets");
            paramString.setAccessible(true);
            if (originAssetManager == null) {
              originAssetManager = (AssetManager)paramString.get(localObject4);
            }
            paramString.set(localObject4, localObject1);
            ((Resources)localObject3).updateConfiguration(((Resources)localObject3).getConfiguration(), ((Resources)localObject3).getDisplayMetrics());
          }
          catch (NoSuchFieldException paramString)
          {
            paramString = localObject4.getClass().getSuperclass().getDeclaredField("mAssets");
          }
        }
      }
    }
    paramString = safeGetString(paramContext, getMoaiPatchFingerPrintResId(paramContext));
    if ((!str.equals("")) && (str.equals(paramString)))
    {
      PatchLog.w(1022, "res check fail. current:" + str + ",version:" + VersionUtil.getVersionCode(paramContext));
      return false;
    }
    PatchLog.i(4002, "attachPatchResources:" + paramFile.getAbsolutePath());
    return true;
  }
  
  public static void revertResource()
    throws Exception
  {
    if (originAssetManager == null)
    {
      PatchLog.w(1035, "revert resources origin is null");
      return;
    }
    Iterator localIterator = findAllResourcesRef().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Resources localResources = (Resources)((WeakReference)localIterator.next()).get();
        if (localResources == null) {
          continue;
        }
        try
        {
          Field localField1 = Resources.class.getDeclaredField("mAssets");
          localField1.setAccessible(true);
          localField1.set(localResources, originAssetManager);
          localResources.updateConfiguration(localResources.getConfiguration(), localResources.getDisplayMetrics());
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject = Resources.class.getDeclaredField("mResourcesImpl");
            ((Field)localObject).setAccessible(true);
            localObject = ((Field)localObject).get(localResources);
            Field localField2 = localObject.getClass().getDeclaredField("mAssets");
            localField2.setAccessible(true);
            localField2.set(localObject, originAssetManager);
          }
        }
      }
    }
    PatchLog.w(1024, "revert resources");
  }
  
  private static String safeGetString(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getString(paramInt);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if ((paramContext instanceof Resources.NotFoundException)) {
        throw new RuntimeException("no moai_patch_fingerPrint found, please check if moai_patch_fingerPrint been proguard or if moai_patch_fingerPrint exists");
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.resource.MoaiResourceLoader
 * JD-Core Version:    0.7.0.1
 */