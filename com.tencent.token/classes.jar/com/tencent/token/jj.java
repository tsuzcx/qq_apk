package com.tencent.token;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.support.v7.widget.Toolbar.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.TextView;

public final class jj
  implements it
{
  Toolbar a;
  CharSequence b;
  Window.Callback c;
  boolean d;
  private int e;
  private View f;
  private View g;
  private Drawable h;
  private Drawable i;
  private Drawable j;
  private boolean k;
  private CharSequence l;
  private CharSequence m;
  private ActionMenuPresenter n;
  private int o = 0;
  private int p = 0;
  private Drawable q;
  
  public jj(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, gs.h.abc_action_bar_up_description);
  }
  
  private jj(Toolbar paramToolbar, boolean paramBoolean, int paramInt)
  {
    this.a = paramToolbar;
    this.b = paramToolbar.getTitle();
    this.l = paramToolbar.getSubtitle();
    boolean bool;
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.k = bool;
    this.j = paramToolbar.getNavigationIcon();
    paramToolbar = ji.a(paramToolbar.getContext(), null, gs.j.ActionBar, gs.a.actionBarStyle, 0);
    this.q = paramToolbar.a(gs.j.ActionBar_homeAsUpIndicator);
    int i1;
    if (paramBoolean)
    {
      Object localObject1 = paramToolbar.c(gs.j.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.k = true;
        b((CharSequence)localObject1);
      }
      localObject1 = paramToolbar.c(gs.j.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.l = ((CharSequence)localObject1);
        if ((this.e & 0x8) != 0) {
          this.a.setSubtitle((CharSequence)localObject1);
        }
      }
      localObject1 = paramToolbar.a(gs.j.ActionBar_logo);
      if (localObject1 != null) {
        b((Drawable)localObject1);
      }
      localObject1 = paramToolbar.a(gs.j.ActionBar_icon);
      if (localObject1 != null) {
        a((Drawable)localObject1);
      }
      if (this.j == null)
      {
        localObject1 = this.q;
        if (localObject1 != null)
        {
          this.j = ((Drawable)localObject1);
          q();
        }
      }
      c(paramToolbar.a(gs.j.ActionBar_displayOptions, 0));
      i1 = paramToolbar.g(gs.j.ActionBar_customNavigationLayout, 0);
      Object localObject2;
      if (i1 != 0)
      {
        localObject1 = LayoutInflater.from(this.a.getContext()).inflate(i1, this.a, false);
        localObject2 = this.g;
        if ((localObject2 != null) && ((this.e & 0x10) != 0)) {
          this.a.removeView((View)localObject2);
        }
        this.g = ((View)localObject1);
        if ((localObject1 != null) && ((this.e & 0x10) != 0)) {
          this.a.addView(this.g);
        }
        c(this.e | 0x10);
      }
      i1 = paramToolbar.f(gs.j.ActionBar_height, 0);
      if (i1 > 0)
      {
        localObject1 = this.a.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = i1;
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      int i2 = paramToolbar.d(gs.j.ActionBar_contentInsetStart, -1);
      i1 = paramToolbar.d(gs.j.ActionBar_contentInsetEnd, -1);
      if ((i2 >= 0) || (i1 >= 0))
      {
        localObject1 = this.a;
        i2 = Math.max(i2, 0);
        i1 = Math.max(i1, 0);
        ((Toolbar)localObject1).g();
        ((Toolbar)localObject1).m.a(i2, i1);
      }
      i1 = paramToolbar.g(gs.j.ActionBar_titleTextStyle, 0);
      if (i1 != 0)
      {
        localObject1 = this.a;
        localObject2 = ((Toolbar)localObject1).getContext();
        ((Toolbar)localObject1).j = i1;
        if (((Toolbar)localObject1).b != null) {
          ((Toolbar)localObject1).b.setTextAppearance((Context)localObject2, i1);
        }
      }
      i1 = paramToolbar.g(gs.j.ActionBar_subtitleTextStyle, 0);
      if (i1 != 0)
      {
        localObject1 = this.a;
        localObject2 = ((Toolbar)localObject1).getContext();
        ((Toolbar)localObject1).k = i1;
        if (((Toolbar)localObject1).c != null) {
          ((Toolbar)localObject1).c.setTextAppearance((Context)localObject2, i1);
        }
      }
      i1 = paramToolbar.g(gs.j.ActionBar_popupTheme, 0);
      if (i1 != 0) {
        this.a.setPopupTheme(i1);
      }
    }
    else
    {
      i1 = 11;
      if (this.a.getNavigationIcon() != null)
      {
        i1 = 15;
        this.q = this.a.getNavigationIcon();
      }
      this.e = i1;
    }
    paramToolbar.a.recycle();
    if (paramInt != this.p)
    {
      this.p = paramInt;
      if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
        d(this.p);
      }
    }
    this.m = this.a.getNavigationContentDescription();
    this.a.setNavigationOnClickListener(new View.OnClickListener()
    {
      final hi a = new hi(jj.this.a.getContext(), jj.this.b);
      
      public final void onClick(View paramAnonymousView)
      {
        if ((jj.this.c != null) && (jj.this.d)) {
          jj.this.c.onMenuItemSelected(0, this.a);
        }
      }
    });
  }
  
  private void b(Drawable paramDrawable)
  {
    this.i = paramDrawable;
    p();
  }
  
  private void b(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    if ((this.e & 0x8) != 0) {
      this.a.setTitle(paramCharSequence);
    }
  }
  
  private void c(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    r();
  }
  
  private void p()
  {
    int i1 = this.e;
    Drawable localDrawable;
    if ((i1 & 0x2) != 0)
    {
      if ((i1 & 0x1) != 0)
      {
        localDrawable = this.i;
        if (localDrawable == null) {
          localDrawable = this.h;
        }
      }
      else
      {
        localDrawable = this.h;
      }
    }
    else {
      localDrawable = null;
    }
    this.a.setLogo(localDrawable);
  }
  
  private void q()
  {
    if ((this.e & 0x4) != 0)
    {
      Toolbar localToolbar = this.a;
      Drawable localDrawable = this.j;
      if (localDrawable == null) {
        localDrawable = this.q;
      }
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
    this.a.setNavigationIcon(null);
  }
  
  private void r()
  {
    if ((this.e & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.m))
      {
        this.a.setNavigationContentDescription(this.p);
        return;
      }
      this.a.setNavigationContentDescription(this.m);
    }
  }
  
  public final ViewGroup a()
  {
    return this.a;
  }
  
  public final fd a(final int paramInt, long paramLong)
  {
    fd localfd = fa.f(this.a);
    float f1;
    if (paramInt == 0) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    localfd.a(f1).a(paramLong).a(new ff()
    {
      private boolean c = false;
      
      public final void a(View paramAnonymousView)
      {
        jj.this.a.setVisibility(0);
      }
      
      public final void b(View paramAnonymousView)
      {
        if (!this.c) {
          jj.this.a.setVisibility(paramInt);
        }
      }
      
      public final void c(View paramAnonymousView)
      {
        this.c = true;
      }
    });
  }
  
  public final void a(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = gu.b(this.a.getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    a(localDrawable);
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.h = paramDrawable;
    p();
  }
  
  public final void a(Menu paramMenu, hw.a parama)
  {
    if (this.n == null)
    {
      this.n = new ActionMenuPresenter(this.a.getContext());
      this.n.h = gs.f.action_menu_presenter;
    }
    ActionMenuPresenter localActionMenuPresenter = this.n;
    localActionMenuPresenter.f = parama;
    parama = this.a;
    paramMenu = (hp)paramMenu;
    if ((paramMenu != null) || (parama.a != null))
    {
      parama.d();
      hp localhp = parama.a.a;
      if (localhp != paramMenu)
      {
        if (localhp != null)
        {
          localhp.b(parama.p);
          localhp.b(parama.q);
        }
        if (parama.q == null) {
          parama.q = new Toolbar.a(parama);
        }
        localActionMenuPresenter.l = true;
        if (paramMenu != null)
        {
          paramMenu.a(localActionMenuPresenter, parama.h);
          paramMenu.a(parama.q, parama.h);
        }
        else
        {
          localActionMenuPresenter.a(parama.h, null);
          parama.q.a(parama.h, null);
          localActionMenuPresenter.b(true);
          parama.q.b(true);
        }
        parama.a.setPopupTheme(parama.i);
        parama.a.setPresenter(localActionMenuPresenter);
        parama.p = localActionMenuPresenter;
      }
    }
  }
  
  public final void a(Window.Callback paramCallback)
  {
    this.c = paramCallback;
  }
  
  public final void a(hw.a parama, hp.a parama1)
  {
    Toolbar localToolbar = this.a;
    localToolbar.r = parama;
    localToolbar.s = parama1;
    if (localToolbar.a != null) {
      localToolbar.a.a(parama, parama1);
    }
  }
  
  public final void a(jc paramjc)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      Toolbar localToolbar = this.a;
      if (localObject == localToolbar) {
        localToolbar.removeView(this.f);
      }
    }
    this.f = paramjc;
    if ((paramjc != null) && (this.o == 2))
    {
      this.a.addView(this.f, 0);
      localObject = (Toolbar.LayoutParams)this.f.getLayoutParams();
      ((Toolbar.LayoutParams)localObject).width = -2;
      ((Toolbar.LayoutParams)localObject).height = -2;
      ((Toolbar.LayoutParams)localObject).a = 8388691;
      paramjc.setAllowCollapse(true);
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    if (!this.k) {
      b(paramCharSequence);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.setCollapsible(paramBoolean);
  }
  
  public final Context b()
  {
    return this.a.getContext();
  }
  
  public final void b(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = gu.b(this.a.getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    b(localDrawable);
  }
  
  public final void c(int paramInt)
  {
    int i1 = this.e ^ paramInt;
    this.e = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          r();
        }
        q();
      }
      if ((i1 & 0x3) != 0) {
        p();
      }
      if ((i1 & 0x8) != 0) {
        if ((paramInt & 0x8) != 0)
        {
          this.a.setTitle(this.b);
          this.a.setSubtitle(this.l);
        }
        else
        {
          this.a.setTitle(null);
          this.a.setSubtitle(null);
        }
      }
      if ((i1 & 0x10) != 0)
      {
        View localView = this.g;
        if (localView != null)
        {
          if ((paramInt & 0x10) != 0)
          {
            this.a.addView(localView);
            return;
          }
          this.a.removeView(localView);
        }
      }
    }
  }
  
  public final boolean c()
  {
    Toolbar localToolbar = this.a;
    return (localToolbar.q != null) && (localToolbar.q.b != null);
  }
  
  public final void d()
  {
    this.a.c();
  }
  
  public final void d(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = this.a.getContext().getString(paramInt);
    }
    c(str);
  }
  
  public final CharSequence e()
  {
    return this.a.getTitle();
  }
  
  public final void e(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public final boolean f()
  {
    Toolbar localToolbar = this.a;
    return (localToolbar.getVisibility() == 0) && (localToolbar.a != null) && (localToolbar.a.b);
  }
  
  public final boolean g()
  {
    return this.a.a();
  }
  
  public final boolean h()
  {
    Object localObject = this.a;
    if (((Toolbar)localObject).a != null)
    {
      localObject = ((Toolbar)localObject).a;
      if (((ActionMenuView)localObject).c != null)
      {
        localObject = ((ActionMenuView)localObject).c;
        if ((((ActionMenuPresenter)localObject).o == null) && (!((ActionMenuPresenter)localObject).h())) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        if (i1 != 0)
        {
          i1 = 1;
          break label64;
        }
      }
      int i1 = 0;
      label64:
      if (i1 != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean i()
  {
    return this.a.b();
  }
  
  public final boolean j()
  {
    Object localObject = this.a;
    if (((Toolbar)localObject).a != null)
    {
      localObject = ((Toolbar)localObject).a;
      int i1;
      if ((((ActionMenuView)localObject).c != null) && (((ActionMenuView)localObject).c.e())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void k()
  {
    this.d = true;
  }
  
  public final void l()
  {
    Toolbar localToolbar = this.a;
    if (localToolbar.a != null) {
      localToolbar.a.b();
    }
  }
  
  public final int m()
  {
    return this.e;
  }
  
  public final int n()
  {
    return this.o;
  }
  
  public final Menu o()
  {
    return this.a.getMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jj
 * JD-Core Version:    0.7.0.1
 */