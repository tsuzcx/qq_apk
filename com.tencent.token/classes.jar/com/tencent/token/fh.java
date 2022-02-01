package com.tencent.token;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class fh
{
  private final Object a;
  
  private fh(Object paramObject)
  {
    this.a = paramObject;
  }
  
  static fh a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new fh(paramObject);
  }
  
  static Object a(fh paramfh)
  {
    if (paramfh == null) {
      return null;
    }
    return paramfh.a;
  }
  
  public final int a()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.a).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final fh a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new fh(((WindowInsets)this.a).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final int b()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.a).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int c()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.a).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int d()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.a).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final boolean e()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.a).isConsumed();
    }
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (fh)paramObject;
      Object localObject = this.a;
      if (localObject == null) {
        return paramObject.a == null;
      }
      return localObject.equals(paramObject.a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fh
 * JD-Core Version:    0.7.0.1
 */