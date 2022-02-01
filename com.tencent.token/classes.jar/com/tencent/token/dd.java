package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

final class dd
  extends df
{
  private static final Class a;
  private static final Constructor b;
  private static final Method c;
  private static final Method d;
  
  static
  {
    Object localObject1 = null;
    try
    {
      localClass2 = Class.forName("android.graphics.FontFamily");
      Constructor localConstructor = localClass2.getConstructor(new Class[0]);
      localObject2 = localClass2.getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE });
      Method localMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass2, 1).getClass() });
      localObject1 = localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    localClassNotFoundException.getClass().getName();
    Class localClass2 = null;
    Class localClass1 = localClass2;
    Object localObject2 = localClass1;
    b = localObject1;
    a = localClass2;
    c = (Method)localObject2;
    d = localClass1;
  }
  
  private static Typeface a(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(a, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)d.invoke(null, new Object[] { localObject });
      return paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  public static boolean a()
  {
    return c != null;
  }
  
  private static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramBoolean = ((Boolean)c.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  private static Object b()
  {
    try
    {
      Object localObject = b.newInstance(new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    throw new RuntimeException(localIllegalAccessException);
  }
  
  public final Typeface a(Context paramContext, cw.b paramb, Resources paramResources, int paramInt)
  {
    Object localObject1 = b();
    paramb = paramb.a;
    int i = paramb.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = paramb[paramInt];
      ByteBuffer localByteBuffer = dg.a(paramContext, paramResources, localObject2.d);
      if (localByteBuffer == null) {
        return null;
      }
      if (!a(localObject1, localByteBuffer, 0, localObject2.b, localObject2.c)) {
        return null;
      }
      paramInt += 1;
    }
    return a(localObject1);
  }
  
  public final Typeface a(Context paramContext, dt.b[] paramArrayOfb, int paramInt)
  {
    Object localObject = b();
    eg localeg = new eg();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      dt.b localb = paramArrayOfb[i];
      Uri localUri = localb.a;
      ByteBuffer localByteBuffer2 = (ByteBuffer)localeg.get(localUri);
      ByteBuffer localByteBuffer1 = localByteBuffer2;
      if (localByteBuffer2 == null)
      {
        localByteBuffer1 = dg.a(paramContext, localUri);
        localeg.put(localUri, localByteBuffer1);
      }
      if (!a(localObject, localByteBuffer1, localb.b, localb.c, localb.d)) {
        return null;
      }
      i += 1;
    }
    return Typeface.create(a(localObject), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dd
 * JD-Core Version:    0.7.0.1
 */