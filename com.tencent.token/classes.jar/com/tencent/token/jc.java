package com.tencent.token;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class jc
  extends ContextWrapper
{
  private static final Object a = new Object();
  private static ArrayList<WeakReference<jc>> b;
  private final Resources c;
  private final Resources.Theme d;
  
  private jc(Context paramContext)
  {
    super(paramContext);
    if (jk.a())
    {
      this.c = new jk(this, paramContext.getResources());
      this.d = this.c.newTheme();
      this.d.setTo(paramContext.getTheme());
      return;
    }
    this.c = new je(this, paramContext.getResources());
    this.d = null;
  }
  
  public static Context a(Context paramContext)
  {
    boolean bool = paramContext instanceof jc;
    int j = 0;
    int i = j;
    if (!bool)
    {
      i = j;
      if (!(paramContext.getResources() instanceof je)) {
        if ((paramContext.getResources() instanceof jk))
        {
          i = j;
        }
        else if (Build.VERSION.SDK_INT >= 21)
        {
          i = j;
          if (!jk.a()) {}
        }
        else
        {
          i = 1;
        }
      }
    }
    if (i != 0) {}
    for (;;)
    {
      synchronized (a)
      {
        if (b == null)
        {
          b = new ArrayList();
        }
        else
        {
          i = b.size() - 1;
          if (i >= 0)
          {
            localObject1 = (WeakReference)b.get(i);
            if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
              break label238;
            }
            b.remove(i);
            break label238;
          }
          i = b.size() - 1;
          if (i >= 0)
          {
            localObject1 = (WeakReference)b.get(i);
            if (localObject1 == null) {
              break label245;
            }
            localObject1 = (jc)((WeakReference)localObject1).get();
            if ((localObject1 == null) || (((jc)localObject1).getBaseContext() != paramContext)) {
              break label251;
            }
            return localObject1;
          }
        }
        paramContext = new jc(paramContext);
        b.add(new WeakReference(paramContext));
        return paramContext;
      }
      return paramContext;
      label238:
      i -= 1;
      continue;
      label245:
      Object localObject1 = null;
      continue;
      label251:
      i -= 1;
    }
  }
  
  public final AssetManager getAssets()
  {
    return this.c.getAssets();
  }
  
  public final Resources getResources()
  {
    return this.c;
  }
  
  public final Resources.Theme getTheme()
  {
    Resources.Theme localTheme2 = this.d;
    Resources.Theme localTheme1 = localTheme2;
    if (localTheme2 == null) {
      localTheme1 = super.getTheme();
    }
    return localTheme1;
  }
  
  public final void setTheme(int paramInt)
  {
    Resources.Theme localTheme = this.d;
    if (localTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    localTheme.applyStyle(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jc
 * JD-Core Version:    0.7.0.1
 */