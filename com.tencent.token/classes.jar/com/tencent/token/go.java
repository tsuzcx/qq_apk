package com.tencent.token;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.b;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

public final class go
  extends ActionBar
{
  it a;
  boolean b;
  public Window.Callback c;
  private boolean d;
  private boolean e;
  private ArrayList<Object> f = new ArrayList();
  private final Runnable g = new Runnable()
  {
    public final void run()
    {
      go localgo = go.this;
      Menu localMenu = localgo.i();
      hp localhp;
      if ((localMenu instanceof hp)) {
        localhp = (hp)localMenu;
      } else {
        localhp = null;
      }
      if (localhp != null) {
        localhp.d();
      }
      try
      {
        localMenu.clear();
        if ((!localgo.c.onCreatePanelMenu(0, localMenu)) || (!localgo.c.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
        return;
      }
      finally
      {
        if (localhp != null) {
          localhp.e();
        }
      }
    }
  };
  private final Toolbar.b h = new Toolbar.b()
  {
    public final boolean a(MenuItem paramAnonymousMenuItem)
    {
      return go.this.c.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  public go(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.a = new jj(paramToolbar, false);
    this.c = new c(paramCallback);
    this.a.a(this.c);
    paramToolbar.setOnMenuItemClickListener(this.h);
    this.a.a(paramCharSequence);
  }
  
  public final int a()
  {
    return this.a.m();
  }
  
  public final void a(float paramFloat)
  {
    fa.a(this.a.a(), paramFloat);
  }
  
  public final void a(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public final void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.a.a(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = i();
    if (localMenu != null)
    {
      if (paramKeyEvent != null) {
        i = paramKeyEvent.getDeviceId();
      } else {
        i = -1;
      }
      int i = KeyCharacterMap.load(i).getKeyboardType();
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      localMenu.setQwertyMode(bool);
      return localMenu.performShortcut(paramInt, paramKeyEvent, 0);
    }
    return false;
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      d();
    }
    return true;
  }
  
  public final Context b()
  {
    return this.a.b();
  }
  
  public final void b(boolean paramBoolean) {}
  
  public final void c(boolean paramBoolean)
  {
    if (paramBoolean == this.e) {
      return;
    }
    this.e = paramBoolean;
    int j = this.f.size();
    int i = 0;
    while (i < j)
    {
      this.f.get(i);
      i += 1;
    }
  }
  
  public final boolean d()
  {
    return this.a.i();
  }
  
  public final boolean e()
  {
    return this.a.j();
  }
  
  public final boolean f()
  {
    this.a.a().removeCallbacks(this.g);
    fa.a(this.a.a(), this.g);
    return true;
  }
  
  public final boolean g()
  {
    if (this.a.c())
    {
      this.a.d();
      return true;
    }
    return false;
  }
  
  public final void h()
  {
    this.a.a().removeCallbacks(this.g);
  }
  
  final Menu i()
  {
    if (!this.d)
    {
      this.a.a(new a(), new b());
      this.d = true;
    }
    return this.a.o();
  }
  
  final class a
    implements hw.a
  {
    private boolean b;
    
    a() {}
    
    public final void a(hp paramhp, boolean paramBoolean)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      go.this.a.l();
      if (go.this.c != null) {
        go.this.c.onPanelClosed(108, paramhp);
      }
      this.b = false;
    }
    
    public final boolean a(hp paramhp)
    {
      if (go.this.c != null)
      {
        go.this.c.onMenuOpened(108, paramhp);
        return true;
      }
      return false;
    }
  }
  
  final class b
    implements hp.a
  {
    b() {}
    
    public final void a(hp paramhp)
    {
      if (go.this.c != null)
      {
        if (go.this.a.g())
        {
          go.this.c.onPanelClosed(108, paramhp);
          return;
        }
        if (go.this.c.onPreparePanel(0, null, paramhp)) {
          go.this.c.onMenuOpened(108, paramhp);
        }
      }
    }
    
    public final boolean a(hp paramhp, MenuItem paramMenuItem)
    {
      return false;
    }
  }
  
  final class c
    extends hh
  {
    public c(Window.Callback paramCallback)
    {
      super();
    }
    
    public final View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0) {
        return new View(go.this.a.b());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!go.this.b))
      {
        go.this.a.k();
        go.this.b = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.go
 * JD-Core Version:    0.7.0.1
 */