package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher
{
  private static final String TAG = "ResourcesFlusher";
  private static Field sDrawableCacheField;
  private static boolean sDrawableCacheFieldFetched;
  private static Field sResourcesImplField;
  private static boolean sResourcesImplFieldFetched;
  private static Class sThemedResourceCacheClazz;
  private static boolean sThemedResourceCacheClazzFetched;
  private static Field sThemedResourceCache_mUnthemedEntriesField;
  private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
  
  static boolean flush(@NonNull Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return flushNougats(paramResources);
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return flushMarshmallows(paramResources);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return flushLollipops(paramResources);
    }
    return false;
  }
  
  @RequiresApi(21)
  private static boolean flushLollipops(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      sDrawableCacheFieldFetched = true;
    }
    Field localField = sDrawableCacheField;
    if (localField != null)
    {
      try
      {
        paramResources = (Map)localField.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        paramResources = null;
      }
      if (paramResources != null)
      {
        paramResources.clear();
        return true;
      }
    }
    return false;
  }
  
  @RequiresApi(23)
  private static boolean flushMarshmallows(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      sDrawableCacheFieldFetched = true;
    }
    Object localObject2 = null;
    Field localField = sDrawableCacheField;
    Object localObject1 = localObject2;
    if (localField != null) {
      try
      {
        localObject1 = localField.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        localObject1 = localObject2;
      }
    }
    boolean bool2 = false;
    if (localObject1 == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (flushThemedResourcesCache(localObject1)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @RequiresApi(24)
  private static boolean flushNougats(@NonNull Resources paramResources)
  {
    if (!sResourcesImplFieldFetched)
    {
      try
      {
        sResourcesImplField = Resources.class.getDeclaredField("mResourcesImpl");
        sResourcesImplField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException1);
      }
      sResourcesImplFieldFetched = true;
    }
    Field localField1 = sResourcesImplField;
    if (localField1 == null) {
      return false;
    }
    Object localObject2 = null;
    try
    {
      paramResources = localField1.get(paramResources);
    }
    catch (IllegalAccessException paramResources)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", paramResources);
      paramResources = null;
    }
    if (paramResources == null) {
      return false;
    }
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = paramResources.getClass().getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException2);
      }
      sDrawableCacheFieldFetched = true;
    }
    Field localField2 = sDrawableCacheField;
    Object localObject1 = localObject2;
    if (localField2 != null) {
      try
      {
        localObject1 = localField2.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", paramResources);
        localObject1 = localObject2;
      }
    }
    return (localObject1 != null) && (flushThemedResourcesCache(localObject1));
  }
  
  @RequiresApi(16)
  private static boolean flushThemedResourcesCache(@NonNull Object paramObject)
  {
    if (!sThemedResourceCacheClazzFetched)
    {
      try
      {
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
      }
      sThemedResourceCacheClazzFetched = true;
    }
    Class localClass = sThemedResourceCacheClazz;
    if (localClass == null) {
      return false;
    }
    if (!sThemedResourceCache_mUnthemedEntriesFieldFetched)
    {
      try
      {
        sThemedResourceCache_mUnthemedEntriesField = localClass.getDeclaredField("mUnthemedEntries");
        sThemedResourceCache_mUnthemedEntriesField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
      }
      sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    }
    Field localField = sThemedResourceCache_mUnthemedEntriesField;
    if (localField == null) {
      return false;
    }
    try
    {
      paramObject = (LongSparseArray)localField.get(paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", paramObject);
      paramObject = null;
    }
    if (paramObject != null)
    {
      paramObject.clear();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ResourcesFlusher
 * JD-Core Version:    0.7.0.1
 */