package com.tencent.token;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

final class jb
{
  static final int[] a = { -16842910 };
  static final int[] b = { 16842908 };
  static final int[] c = { 16843518 };
  static final int[] d = { 16842919 };
  static final int[] e = { 16842912 };
  static final int[] f = { 16842913 };
  static final int[] g = { -16842919, -16842908 };
  static final int[] h = new int[0];
  private static final ThreadLocal<TypedValue> i = new ThreadLocal();
  private static final int[] j = new int[1];
  
  public static int a(Context paramContext, int paramInt)
  {
    int[] arrayOfInt = j;
    arrayOfInt[0] = paramInt;
    paramContext = jf.a(paramContext, null, arrayOfInt);
    try
    {
      paramInt = paramContext.b(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.a.recycle();
    }
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    Object localObject1 = j;
    localObject1[0] = paramInt;
    paramContext = jf.a(paramContext, null, (int[])localObject1);
    try
    {
      localObject1 = paramContext.e(0);
      return localObject1;
    }
    finally
    {
      paramContext.a.recycle();
    }
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    Object localObject = b(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(a, ((ColorStateList)localObject).getDefaultColor());
    }
    TypedValue localTypedValue = (TypedValue)i.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      i.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    float f1 = ((TypedValue)localObject).getFloat();
    paramInt = a(paramContext, paramInt);
    return cz.b(paramInt, Math.round(Color.alpha(paramInt) * f1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jb
 * JD-Core Version:    0.7.0.1
 */