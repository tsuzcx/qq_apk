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

public final class gl
  extends ActionBar
{
  iq a;
  boolean b;
  public Window.Callback c;
  private boolean d;
  private boolean e;
  private ArrayList<Object> f = new ArrayList();
  private final Runnable g = new Runnable()
  {
    public final void run()
    {
      gl localgl = gl.this;
      Menu localMenu = localgl.i();
      hm localhm;
      if ((localMenu instanceof hm)) {
        localhm = (hm)localMenu;
      } else {
        localhm = null;
      }
      if (localhm != null) {
        localhm.d();
      }
      try
      {
        localMenu.clear();
        if ((!localgl.c.onCreatePanelMenu(0, localMenu)) || (!localgl.c.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
        return;
      }
      finally
      {
        if (localhm != null) {
          localhm.e();
        }
      }
    }
  };
  private final Toolbar.b h = new Toolbar.b()
  {
    public final boolean a(MenuItem paramAnonymousMenuItem)
    {
      return gl.this.c.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  public gl(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.a = new jg(paramToolbar, false);
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
    ex.a(this.a.a(), paramFloat);
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
    ex.a(this.a.a(), this.g);
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
    implements ht.a
  {
    private boolean b;
    
    a() {}
    
    public final void a(hm paramhm, boolean paramBoolean)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      gl.this.a.l();
      if (gl.this.c != null) {
        gl.this.c.onPanelClosed(108, paramhm);
      }
      this.b = false;
    }
    
    public final boolean a(hm paramhm)
    {
      if (gl.this.c != null)
      {
        gl.this.c.onMenuOpened(108, paramhm);
        return true;
      }
      return false;
    }
  }
  
  final class b
    implements hm.a
  {
    b() {}
    
    public final void a(hm paramhm)
    {
      if (gl.this.c != null)
      {
        if (gl.this.a.g())
        {
          gl.this.c.onPanelClosed(108, paramhm);
          return;
        }
        if (gl.this.c.onPreparePanel(0, null, paramhm)) {
          gl.this.c.onMenuOpened(108, paramhm);
        }
      }
    }
    
    public final boolean a(hm paramhm, MenuItem paramMenuItem)
    {
      return false;
    }
  }
  
  final class c
    extends he
  {
    public c(Window.Callback paramCallback)
    {
      super();
    }
    
    public final View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0) {
        return new View(gl.this.a.b());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!gl.this.b))
      {
        gl.this.a.k();
        gl.this.b = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gl
 * JD-Core Version:    0.7.0.1
 */