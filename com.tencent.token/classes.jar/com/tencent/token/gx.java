package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

public abstract class gx
  extends gw
{
  private static boolean o;
  private static final boolean p;
  private static final int[] q = { 16842836 };
  protected final Context b;
  public final Window c;
  protected final Window.Callback d;
  protected final Window.Callback e;
  public final gv f;
  protected ActionBar g;
  protected MenuInflater h;
  public boolean i;
  protected boolean j;
  protected boolean k;
  protected boolean l;
  protected boolean m;
  public boolean n;
  private CharSequence r;
  private boolean s;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 21) {
      bool = true;
    } else {
      bool = false;
    }
    p = bool;
    if ((bool) && (!o))
    {
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
      {
        public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
        {
          boolean bool = paramAnonymousThrowable instanceof Resources.NotFoundException;
          int j = 0;
          int i = j;
          Object localObject;
          if (bool)
          {
            localObject = paramAnonymousThrowable.getMessage();
            i = j;
            if (localObject != null) {
              if (!((String)localObject).contains("drawable"))
              {
                i = j;
                if (!((String)localObject).contains("Drawable")) {}
              }
              else
              {
                i = 1;
              }
            }
          }
          if (i != 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramAnonymousThrowable.getMessage());
            ((StringBuilder)localObject).append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            localObject = new Resources.NotFoundException(((StringBuilder)localObject).toString());
            ((Throwable)localObject).initCause(paramAnonymousThrowable.getCause());
            ((Throwable)localObject).setStackTrace(paramAnonymousThrowable.getStackTrace());
            this.a.uncaughtException(paramAnonymousThread, (Throwable)localObject);
            return;
          }
          this.a.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
        }
      });
      o = true;
    }
  }
  
  protected gx(Context paramContext, Window paramWindow, gv paramgv)
  {
    this.b = paramContext;
    this.c = paramWindow;
    this.f = paramgv;
    this.d = this.c.getCallback();
    paramWindow = this.d;
    if (!(paramWindow instanceof b))
    {
      this.e = a(paramWindow);
      this.c.setCallback(this.e);
      paramContext = jw.a(paramContext, null, q);
      paramWindow = paramContext.b(0);
      if (paramWindow != null) {
        this.c.setBackgroundDrawable(paramWindow);
      }
      paramContext.a.recycle();
      return;
    }
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  public final ActionBar a()
  {
    m();
    return this.g;
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new b(paramCallback);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.r = paramCharSequence;
    b(paramCharSequence);
  }
  
  protected abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  protected abstract boolean a(KeyEvent paramKeyEvent);
  
  public final MenuInflater b()
  {
    if (this.h == null)
    {
      m();
      Object localObject = this.g;
      if (localObject != null) {
        localObject = ((ActionBar)localObject).b();
      } else {
        localObject = this.b;
      }
      this.h = new ht((Context)localObject);
    }
    return this.h;
  }
  
  protected abstract ho b(ho.a parama);
  
  public void b(Bundle paramBundle) {}
  
  protected abstract void b(CharSequence paramCharSequence);
  
  public void d()
  {
    this.s = true;
  }
  
  protected abstract void d(int paramInt);
  
  public void e()
  {
    this.s = false;
  }
  
  protected abstract boolean e(int paramInt);
  
  public void h()
  {
    this.n = true;
  }
  
  public final gu.a i()
  {
    return new a();
  }
  
  public boolean k()
  {
    return false;
  }
  
  protected abstract void m();
  
  protected final Context n()
  {
    Object localObject1 = a();
    if (localObject1 != null) {
      localObject1 = ((ActionBar)localObject1).b();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.b;
    }
    return localObject2;
  }
  
  protected final CharSequence o()
  {
    Window.Callback localCallback = this.d;
    if ((localCallback instanceof Activity)) {
      return ((Activity)localCallback).getTitle();
    }
    return this.r;
  }
  
  final class a
    implements gu.a
  {
    a() {}
    
    public final void a(int paramInt)
    {
      ActionBar localActionBar = gx.this.a();
      if (localActionBar != null) {
        localActionBar.a(paramInt);
      }
    }
  }
  
  class b
    extends hv
  {
    b(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (gx.this.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (gx.this.a(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof id))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      gx.this.e(paramInt);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      gx.this.d(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      id localid;
      if ((paramMenu instanceof id)) {
        localid = (id)paramMenu;
      } else {
        localid = null;
      }
      if ((paramInt == 0) && (localid == null)) {
        return false;
      }
      if (localid != null) {
        localid.k = true;
      }
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if (localid != null) {
        localid.k = false;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gx
 * JD-Core Version:    0.7.0.1
 */