package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher
{
  private static final String TAG = "ResourcesFlusher";
  private static Field sDrawableCacheField;
  private static boolean sDrawableCacheFieldFetched;
  private static Field sResourcesImplField;
  private static boolean sResourcesImplFieldFetched;
  private static Class<?> sThemedResourceCacheClazz;
  private static boolean sThemedResourceCacheClazzFetched;
  private static Field sThemedResourceCache_mUnthemedEntriesField;
  private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
  
  static void flush(@NonNull Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 24)
      {
        flushNougats(paramResources);
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        flushMarshmallows(paramResources);
        return;
      }
    } while (Build.VERSION.SDK_INT < 21);
    flushLollipops(paramResources);
  }
  
  @RequiresApi(21)
  private static void flushLollipops(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched) {}
    try
    {
      sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
      sDrawableCacheField.setAccessible(true);
      sDrawableCacheFieldFetched = true;
      if (sDrawableCacheField == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        paramResources = (Map)sDrawableCacheField.get(paramResources);
        if (paramResources != null) {
          paramResources.clear();
        }
        return;
        localNoSuchFieldException = localNoSuchFieldException;
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;)
        {
          Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
          paramResources = null;
        }
      }
    }
  }
  
  @RequiresApi(23)
  private static void flushMarshmallows(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched) {}
    try
    {
      sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
      sDrawableCacheField.setAccessible(true);
      sDrawableCacheFieldFetched = true;
      if (sDrawableCacheField == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          paramResources = sDrawableCacheField.get(paramResources);
          if (paramResources != null) {
            break;
          }
          return;
        }
        catch (IllegalAccessException paramResources)
        {
          Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        }
        localNoSuchFieldException = localNoSuchFieldException;
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
        continue;
        paramResources = null;
      }
      flushThemedResourcesCache(paramResources);
    }
  }
  
  @RequiresApi(24)
  private static void flushNougats(@NonNull Resources paramResources)
  {
    if (!sResourcesImplFieldFetched) {}
    for (;;)
    {
      try
      {
        sResourcesImplField = Resources.class.getDeclaredField("mResourcesImpl");
        sResourcesImplField.setAccessible(true);
        sResourcesImplFieldFetched = true;
        if (sResourcesImplField == null) {
          return;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException1);
        continue;
      }
      try
      {
        paramResources = sResourcesImplField.get(paramResources);
        if (paramResources == null) {
          continue;
        }
        if (sDrawableCacheFieldFetched) {}
      }
      catch (IllegalAccessException paramResources)
      {
        try
        {
          sDrawableCacheField = paramResources.getClass().getDeclaredField("mDrawableCache");
          sDrawableCacheField.setAccessible(true);
          sDrawableCacheFieldFetched = true;
          if (sDrawableCacheField != null)
          {
            try
            {
              paramResources = sDrawableCacheField.get(paramResources);
              if (paramResources == null) {
                continue;
              }
              flushThemedResourcesCache(paramResources);
              return;
            }
            catch (IllegalAccessException paramResources)
            {
              Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", paramResources);
            }
            paramResources = paramResources;
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", paramResources);
            paramResources = null;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          for (;;)
          {
            Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException2);
            continue;
            paramResources = null;
          }
        }
      }
    }
  }
  
  @RequiresApi(16)
  private static void flushThemedResourcesCache(@NonNull Object paramObject)
  {
    if (!sThemedResourceCacheClazzFetched) {}
    for (;;)
    {
      try
      {
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
        sThemedResourceCacheClazzFetched = true;
        if (sThemedResourceCacheClazz == null) {
          return;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
        continue;
      }
      if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {}
      try
      {
        sThemedResourceCache_mUnthemedEntriesField = sThemedResourceCacheClazz.getDeclaredField("mUnthemedEntries");
        sThemedResourceCache_mUnthemedEntriesField.setAccessible(true);
        sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        if (sThemedResourceCache_mUnthemedEntriesField == null) {
          continue;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        try
        {
          paramObject = (LongSparseArray)sThemedResourceCache_mUnthemedEntriesField.get(paramObject);
          if (paramObject == null) {
            continue;
          }
          paramObject.clear();
          return;
          localNoSuchFieldException = localNoSuchFieldException;
          Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
        }
        catch (IllegalAccessException paramObject)
        {
          for (;;)
          {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", paramObject);
            paramObject = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.ResourcesFlusher
 * JD-Core Version:    0.7.0.1
 */