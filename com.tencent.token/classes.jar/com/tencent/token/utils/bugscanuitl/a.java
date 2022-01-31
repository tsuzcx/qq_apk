package com.tencent.token.utils.bugscanuitl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.File;

public final class a
{
  private final b a;
  private final ApplicationInfo b;
  private final File c;
  private String d;
  private Drawable e;
  private String f;
  private boolean g = false;
  private boolean h;
  
  public a(b paramb, ApplicationInfo paramApplicationInfo)
  {
    this.a = paramb;
    this.b = paramApplicationInfo;
    this.c = new File(paramApplicationInfo.sourceDir);
  }
  
  public final ApplicationInfo a()
  {
    return this.b;
  }
  
  public final void a(Context paramContext)
  {
    if ((this.d == null) || (!this.h))
    {
      if (this.c.exists()) {
        break label45;
      }
      this.h = false;
    }
    for (;;)
    {
      String str = this.b.packageName;
      for (paramContext = this;; paramContext = this)
      {
        paramContext.d = str;
        return;
        label45:
        this.h = true;
        paramContext = this.b.loadLabel(paramContext.getPackageManager());
        if (paramContext == null) {
          break;
        }
        str = paramContext.toString();
      }
    }
  }
  
  public final void a(String paramString)
  {
    this.f = paramString;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final Drawable c()
  {
    if (this.e == null)
    {
      if (this.c.exists())
      {
        this.e = this.b.loadIcon(this.a.b);
        return this.e;
      }
      this.h = false;
    }
    do
    {
      return this.a.getContext().getResources().getDrawable(17301651);
      if (this.h) {
        break;
      }
    } while (!this.c.exists());
    this.h = true;
    this.e = this.b.loadIcon(this.a.b);
    return this.e;
    return this.e;
  }
  
  public final String d()
  {
    return this.f;
  }
  
  public final String toString()
  {
    return "mLabel:" + this.d + "bFilter:" + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.a
 * JD-Core Version:    0.7.0.1
 */