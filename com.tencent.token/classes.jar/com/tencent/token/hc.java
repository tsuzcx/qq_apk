package com.tencent.token;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class hc
  extends ContextWrapper
{
  public int a;
  private Resources.Theme b;
  private LayoutInflater c;
  private Configuration d;
  private Resources e;
  
  public hc()
  {
    super(null);
  }
  
  public hc(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
  }
  
  private void a()
  {
    int i;
    if (this.b == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.b = getResources().newTheme();
      Resources.Theme localTheme = getBaseContext().getTheme();
      if (localTheme != null) {
        this.b.setTo(localTheme);
      }
    }
    this.b.applyStyle(this.a, true);
  }
  
  protected final void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public final AssetManager getAssets()
  {
    return getResources().getAssets();
  }
  
  public final Resources getResources()
  {
    if (this.e == null) {
      if (this.d == null) {
        this.e = super.getResources();
      } else if (Build.VERSION.SDK_INT >= 17) {
        this.e = createConfigurationContext(this.d).getResources();
      }
    }
    return this.e;
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.c == null) {
        this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.c;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    Resources.Theme localTheme = this.b;
    if (localTheme != null) {
      return localTheme;
    }
    if (this.a == 0) {
      this.a = gs.i.Theme_AppCompat_Light;
    }
    a();
    return this.b;
  }
  
  public final void setTheme(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hc
 * JD-Core Version:    0.7.0.1
 */