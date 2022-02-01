package com.tencent.token;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class jw
{
  public final TypedArray a;
  private final Context b;
  private TypedValue c;
  
  private jw(Context paramContext, TypedArray paramTypedArray)
  {
    this.b = paramContext;
    this.a = paramTypedArray;
  }
  
  public static jw a(Context paramContext, int paramInt, int[] paramArrayOfInt)
  {
    return new jw(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt));
  }
  
  public static jw a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return new jw(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
  }
  
  public static jw a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new jw(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    return this.a.getInt(paramInt1, paramInt2);
  }
  
  public final Typeface a(int paramInt1, int paramInt2, do.a parama)
  {
    paramInt1 = this.a.getResourceId(paramInt1, 0);
    if (paramInt1 == 0) {
      return null;
    }
    if (this.c == null) {
      this.c = new TypedValue();
    }
    return do.a(this.b, paramInt1, this.c, paramInt2, parama);
  }
  
  public final Drawable a(int paramInt)
  {
    if (this.a.hasValue(paramInt))
    {
      int i = this.a.getResourceId(paramInt, 0);
      if (i != 0) {
        return hi.b(this.b, i);
      }
    }
    return this.a.getDrawable(paramInt);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean)
  {
    return this.a.getBoolean(paramInt, paramBoolean);
  }
  
  public final int b(int paramInt1, int paramInt2)
  {
    return this.a.getColor(paramInt1, paramInt2);
  }
  
  public final Drawable b(int paramInt)
  {
    if (this.a.hasValue(paramInt))
    {
      paramInt = this.a.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return iy.a().a(this.b, paramInt, true);
      }
    }
    return null;
  }
  
  public final int c(int paramInt1, int paramInt2)
  {
    return this.a.getInteger(paramInt1, paramInt2);
  }
  
  public final CharSequence c(int paramInt)
  {
    return this.a.getText(paramInt);
  }
  
  public final int d(int paramInt1, int paramInt2)
  {
    return this.a.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public final String d(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public final int e(int paramInt1, int paramInt2)
  {
    return this.a.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public final ColorStateList e(int paramInt)
  {
    if (this.a.hasValue(paramInt))
    {
      int i = this.a.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList = hi.a(this.b, i);
        if (localColorStateList != null) {
          return localColorStateList;
        }
      }
    }
    return this.a.getColorStateList(paramInt);
  }
  
  public final int f(int paramInt1, int paramInt2)
  {
    return this.a.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public final boolean f(int paramInt)
  {
    return this.a.hasValue(paramInt);
  }
  
  public final int g(int paramInt1, int paramInt2)
  {
    return this.a.getResourceId(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jw
 * JD-Core Version:    0.7.0.1
 */