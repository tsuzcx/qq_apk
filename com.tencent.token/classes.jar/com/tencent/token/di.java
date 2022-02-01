package com.tencent.token;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public final class di
  implements Iterable<Intent>
{
  private static final c c = new c();
  public final ArrayList<Intent> a = new ArrayList();
  public final Context b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      c = new b();
      return;
    }
  }
  
  private di(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static di a(Context paramContext)
  {
    return new di(paramContext);
  }
  
  public final di a(ComponentName paramComponentName)
  {
    int i = this.a.size();
    try
    {
      for (paramComponentName = da.a(this.b, paramComponentName); paramComponentName != null; paramComponentName = da.a(this.b, paramComponentName.getComponent())) {
        this.a.add(i, paramComponentName);
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      throw new IllegalArgumentException(paramComponentName);
    }
  }
  
  @Deprecated
  public final Iterator<Intent> iterator()
  {
    return this.a.iterator();
  }
  
  public static abstract interface a
  {
    public abstract Intent getSupportParentActivityIntent();
  }
  
  static final class b
    extends di.c
  {}
  
  static class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.di
 * JD-Core Version:    0.7.0.1
 */