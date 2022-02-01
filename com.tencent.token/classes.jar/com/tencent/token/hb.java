package com.tencent.token;

import android.content.res.Resources;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class hb
{
  private static Field a;
  private static boolean b;
  private static Class c;
  private static boolean d;
  private static Field e;
  private static boolean f;
  private static Field g;
  private static boolean h;
  
  static boolean a(Resources paramResources)
  {
    if (!b) {}
    try
    {
      Field localField = Resources.class.getDeclaredField("mDrawableCache");
      a = localField;
      localField.setAccessible(true);
      label23:
      b = true;
      localField = a;
      if (localField != null) {}
      try
      {
        paramResources = (Map)localField.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        label47:
        break label47;
      }
      paramResources = null;
      if (paramResources != null)
      {
        paramResources.clear();
        return true;
      }
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  private static boolean a(Object paramObject)
  {
    if (!d) {}
    try
    {
      c = Class.forName("android.content.res.ThemedResourceCache");
      d = true;
      localObject = c;
      if (localObject == null) {
        return false;
      }
      if (f) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        Object localObject = ((Class)localObject).getDeclaredField("mUnthemedEntries");
        e = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        label50:
        f = true;
        localObject = e;
        if (localObject == null) {
          return false;
        }
        try
        {
          paramObject = (LongSparseArray)((Field)localObject).get(paramObject);
        }
        catch (IllegalAccessException paramObject)
        {
          label76:
          break label76;
        }
        paramObject = null;
        if (paramObject != null)
        {
          paramObject.clear();
          return true;
        }
        return false;
        localClassNotFoundException = localClassNotFoundException;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label50;
      }
    }
  }
  
  static boolean b(Resources paramResources)
  {
    if (!b) {}
    try
    {
      localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      a = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      b = true;
      localObject3 = null;
      localField = a;
      localObject1 = localObject3;
      if (localField == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        Field localField;
        Object localObject1 = localField.get(paramResources);
        if (localObject1 == null) {
          return false;
        }
        return (localObject1 != null) && (a(localObject1));
        localNoSuchFieldException = localNoSuchFieldException;
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;)
        {
          Object localObject3;
          Object localObject2 = localObject3;
        }
      }
    }
  }
  
  static boolean c(Resources paramResources)
  {
    if (!h) {}
    try
    {
      localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      g = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      h = true;
      localObject1 = g;
      if (localObject1 == null) {
        return false;
      }
      localObject3 = null;
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      try
      {
        paramResources = ((Field)localObject1).get(paramResources);
        break label50;
        paramResources = null;
        label50:
        if (paramResources == null) {
          return false;
        }
        if (b) {}
      }
      catch (IllegalAccessException localNoSuchFieldException2)
      {
        try
        {
          localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
          a = (Field)localObject1;
          ((Field)localObject1).setAccessible(true);
          b = true;
          localField = a;
          localObject1 = localObject3;
          if (localField == null) {}
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          try
          {
            for (;;)
            {
              Field localField;
              Object localObject1 = localField.get(paramResources);
              return (localObject1 != null) && (a(localObject1));
              localNoSuchFieldException1 = localNoSuchFieldException1;
              continue;
              paramResources = paramResources;
            }
            localNoSuchFieldException2 = localNoSuchFieldException2;
          }
          catch (IllegalAccessException paramResources)
          {
            for (;;)
            {
              Object localObject3;
              Object localObject2 = localObject3;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hb
 * JD-Core Version:    0.7.0.1
 */