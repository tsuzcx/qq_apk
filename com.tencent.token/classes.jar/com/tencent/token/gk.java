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

public final class gk
  extends ActionBar
{
  ip a;
  boolean b;
  public Window.Callback c;
  private boolean d;
  private boolean e;
  private ArrayList<Object> f = new ArrayList();
  private final Runnable g = new Runnable()
  {
    public final void run()
    {
      gk localgk = gk.this;
      Menu localMenu = localgk.i();
      hl localhl;
      if ((localMenu instanceof hl)) {
        localhl = (hl)localMenu;
      } else {
        localhl = null;
      }
      if (localhl != null) {
        localhl.d();
      }
      try
      {
        localMenu.clear();
        if ((!localgk.c.onCreatePanelMenu(0, localMenu)) || (!localgk.c.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
        return;
      }
      finally
      {
        if (localhl != null) {
          localhl.e();
        }
      }
    }
  };
  private final Toolbar.b h = new Toolbar.b()
  {
    public final boolean a(MenuItem paramAnonymousMenuItem)
    {
      return gk.this.c.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  public gk(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.a = new jf(paramToolbar, false);
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
    ew.a(this.a.a(), paramFloat);
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
    ew.a(this.a.a(), this.g);
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
    implements hs.a
  {
    private boolean b;
    
    a() {}
    
    public final void a(hl paramhl, boolean paramBoolean)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      gk.this.a.l();
      if (gk.this.c != null) {
        gk.this.c.onPanelClosed(108, paramhl);
      }
      this.b = false;
    }
    
    public final boolean a(hl paramhl)
    {
      if (gk.this.c != null)
      {
        gk.this.c.onMenuOpened(108, paramhl);
        return true;
      }
      return false;
    }
  }
  
  final class b
    implements hl.a
  {
    b() {}
    
    public final void a(hl paramhl)
    {
      if (gk.this.c != null)
      {
        if (gk.this.a.g())
        {
          gk.this.c.onPanelClosed(108, paramhl);
          return;
        }
        if (gk.this.c.onPreparePanel(0, null, paramhl)) {
          gk.this.c.onMenuOpened(108, paramhl);
        }
      }
    }
    
    public final boolean a(hl paramhl, MenuItem paramMenuItem)
    {
      return false;
    }
  }
  
  final class c
    extends hd
  {
    public c(Window.Callback paramCallback)
    {
      super();
    }
    
    public final View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0) {
        return new View(gk.this.a.b());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!gk.this.b))
      {
        gk.this.a.k();
        gk.this.b = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gk
 * JD-Core Version:    0.7.0.1
 */