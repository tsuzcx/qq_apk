package com.tencent.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

public class TypedArrayWarpper
{
  private TypedArray a;
  
  public TypedArrayWarpper(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray;
  }
  
  public float a(int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (paramInt >= 0) {
      f = this.a.getFloat(paramInt, paramFloat);
    }
    return f;
  }
  
  public float a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    float f = paramFloat;
    if (paramInt1 >= 0) {
      f = this.a.getFraction(paramInt1, paramInt2, paramInt3, paramFloat);
    }
    return f;
  }
  
  public int a()
  {
    return this.a.length();
  }
  
  public int a(int paramInt)
  {
    return this.a.getIndex(paramInt);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getInt(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int a(int paramInt, String paramString)
  {
    return this.a.getLayoutDimension(paramInt, paramString);
  }
  
  public ColorStateList a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getColorStateList(paramInt);
    }
    return null;
  }
  
  public Resources a()
  {
    return this.a.getResources();
  }
  
  public Drawable a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getDrawable(paramInt);
    }
    return null;
  }
  
  public TypedValue a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.peekValue(paramInt);
    }
    return null;
  }
  
  public CharSequence a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getText(paramInt);
    }
    return null;
  }
  
  public String a()
  {
    return this.a.getPositionDescription();
  }
  
  public String a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getString(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.a.recycle();
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.hasValue(paramInt);
    }
    return false;
  }
  
  public boolean a(int paramInt, TypedValue paramTypedValue)
  {
    if (paramInt >= 0) {
      return this.a.getValue(paramInt, paramTypedValue);
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramInt >= 0) {
      bool = this.a.getBoolean(paramInt, paramBoolean);
    }
    return bool;
  }
  
  public CharSequence[] a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getTextArray(paramInt);
    }
    return null;
  }
  
  public float b(int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (paramInt >= 0) {
      f = this.a.getDimension(paramInt, paramFloat);
    }
    return f;
  }
  
  public int b()
  {
    return this.a.getIndexCount();
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getColor(paramInt1, paramInt2);
    }
    return i;
  }
  
  public String b(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getNonResourceString(paramInt);
    }
    return null;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getInteger(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int d(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getDimensionPixelOffset(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int e(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getDimensionPixelSize(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int f(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getLayoutDimension(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int g(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getResourceId(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.TypedArrayWarpper
 * JD-Core Version:    0.7.0.1
 */