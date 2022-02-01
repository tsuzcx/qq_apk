package com.tencent.token;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import java.util.ArrayList;

public final class hn
  implements dn
{
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  private PorterDuff.Mode A = null;
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  private int E = 16;
  private int F = 0;
  private View G;
  private MenuItem.OnActionExpandListener H;
  private boolean I = false;
  final int a;
  public hl b;
  public ei c;
  ContextMenu.ContextMenuInfo d;
  private final int i;
  private final int j;
  private final int k;
  private CharSequence l;
  private CharSequence m;
  private Intent n;
  private char o;
  private int p = 4096;
  private char q;
  private int r = 4096;
  private Drawable s;
  private int t = 0;
  private hy u;
  private Runnable v;
  private MenuItem.OnMenuItemClickListener w;
  private CharSequence x;
  private CharSequence y;
  private ColorStateList z = null;
  
  hn(hl paramhl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.b = paramhl;
    this.i = paramInt2;
    this.j = paramInt1;
    this.k = paramInt3;
    this.a = paramInt4;
    this.l = paramCharSequence;
    this.F = paramInt5;
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.D) {
        if (!this.B)
        {
          localDrawable = paramDrawable;
          if (!this.C) {}
        }
        else
        {
          localDrawable = dg.d(paramDrawable).mutate();
          if (this.B) {
            dg.a(localDrawable, this.z);
          }
          if (this.C) {
            dg.a(localDrawable, this.A);
          }
          this.D = false;
        }
      }
    }
    return localDrawable;
  }
  
  private dn a(View paramView)
  {
    this.G = paramView;
    this.c = null;
    if ((paramView != null) && (paramView.getId() == -1))
    {
      int i1 = this.i;
      if (i1 > 0) {
        paramView.setId(i1);
      }
    }
    this.b.g();
    return this;
  }
  
  private void e(boolean paramBoolean)
  {
    int i2 = this.E;
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    this.E = (i1 | i2 & 0xFFFFFFFD);
    if (i2 != this.E) {
      this.b.b(false);
    }
  }
  
  public final dn a(ei paramei)
  {
    ei localei = this.c;
    if (localei != null)
    {
      localei.b = null;
      localei.a = null;
    }
    this.G = null;
    this.c = paramei;
    this.b.b(true);
    paramei = this.c;
    if (paramei != null) {
      paramei.a(new ei.b()
      {
        public final void a()
        {
          hn.this.b.f();
        }
      });
    }
    return this;
  }
  
  public final dn a(CharSequence paramCharSequence)
  {
    this.x = paramCharSequence;
    this.b.b(false);
    return this;
  }
  
  public final ei a()
  {
    return this.c;
  }
  
  public final CharSequence a(ht.a parama)
  {
    if (parama.a()) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final void a(hy paramhy)
  {
    this.u = paramhy;
    paramhy.setHeaderTitle(getTitle());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i2 = this.E;
    int i1;
    if (paramBoolean) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    this.E = (i1 | i2 & 0xFFFFFFFB);
  }
  
  public final dn b(CharSequence paramCharSequence)
  {
    this.y = paramCharSequence;
    this.b.b(false);
    return this;
  }
  
  public final boolean b()
  {
    Object localObject = this.w;
    if ((localObject != null) && (((MenuItem.OnMenuItemClickListener)localObject).onMenuItemClick(this))) {
      return true;
    }
    localObject = this.b;
    if (((hl)localObject).a((hl)localObject, this)) {
      return true;
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((Runnable)localObject).run();
      return true;
    }
    if (this.n != null) {}
    try
    {
      this.b.a.startActivity(this.n);
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      label77:
      break label77;
    }
    localObject = this.c;
    return (localObject != null) && (((ei)localObject).d());
  }
  
  final boolean b(boolean paramBoolean)
  {
    int i2 = this.E;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    this.E = (i1 | i2 & 0xFFFFFFF7);
    return i2 != this.E;
  }
  
  public final char c()
  {
    if (this.b.b()) {
      return this.q;
    }
    return this.o;
  }
  
  public final void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.E |= 0x20;
      return;
    }
    this.E &= 0xFFFFFFDF;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.F & 0x8) == 0) {
      return false;
    }
    if (this.G == null) {
      return true;
    }
    MenuItem.OnActionExpandListener localOnActionExpandListener = this.H;
    if ((localOnActionExpandListener != null) && (!localOnActionExpandListener.onMenuItemActionCollapse(this))) {
      return false;
    }
    return this.b.b(this);
  }
  
  public final void d(boolean paramBoolean)
  {
    this.I = paramBoolean;
    this.b.b(false);
  }
  
  public final boolean d()
  {
    return (this.b.c()) && (c() != 0);
  }
  
  public final boolean e()
  {
    return (this.E & 0x4) != 0;
  }
  
  public final boolean expandActionView()
  {
    if (!j()) {
      return false;
    }
    MenuItem.OnActionExpandListener localOnActionExpandListener = this.H;
    if ((localOnActionExpandListener != null) && (!localOnActionExpandListener.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.b.a(this);
  }
  
  public final boolean f()
  {
    return (this.E & 0x20) == 32;
  }
  
  public final boolean g()
  {
    return (this.F & 0x1) == 1;
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    Object localObject = this.G;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.c;
    if (localObject != null)
    {
      this.G = ((ei)localObject).a(this);
      return this.G;
    }
    return null;
  }
  
  public final int getAlphabeticModifiers()
  {
    return this.r;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.q;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.x;
  }
  
  public final int getGroupId()
  {
    return this.j;
  }
  
  public final Drawable getIcon()
  {
    Drawable localDrawable = this.s;
    if (localDrawable != null) {
      return a(localDrawable);
    }
    if (this.t != 0)
    {
      localDrawable = gq.b(this.b.a, this.t);
      this.t = 0;
      this.s = localDrawable;
      return a(localDrawable);
    }
    return null;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.z;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.A;
  }
  
  public final Intent getIntent()
  {
    return this.n;
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.i;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.d;
  }
  
  public final int getNumericModifiers()
  {
    return this.p;
  }
  
  public final char getNumericShortcut()
  {
    return this.o;
  }
  
  public final int getOrder()
  {
    return this.k;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.u;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.l;
  }
  
  public final CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence = this.m;
    if (localCharSequence == null) {
      localCharSequence = this.l;
    }
    if ((Build.VERSION.SDK_INT < 18) && (localCharSequence != null) && (!(localCharSequence instanceof String))) {
      return localCharSequence.toString();
    }
    return localCharSequence;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.y;
  }
  
  public final boolean h()
  {
    return (this.F & 0x2) == 2;
  }
  
  public final boolean hasSubMenu()
  {
    return this.u != null;
  }
  
  public final boolean i()
  {
    return (this.F & 0x4) == 4;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.I;
  }
  
  public final boolean isCheckable()
  {
    return (this.E & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.E & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.E & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    ei localei = this.c;
    if ((localei != null) && (localei.b())) {
      return ((this.E & 0x8) == 0) && (this.c.c());
    }
    return (this.E & 0x8) == 0;
  }
  
  public final boolean j()
  {
    if ((this.F & 0x8) != 0)
    {
      if (this.G == null)
      {
        ei localei = this.c;
        if (localei != null) {
          this.G = localei.a(this);
        }
      }
      return this.G != null;
    }
    return false;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.q == paramChar) {
      return this;
    }
    this.q = Character.toLowerCase(paramChar);
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.q == paramChar) && (this.r == paramInt)) {
      return this;
    }
    this.q = Character.toLowerCase(paramChar);
    this.r = KeyEvent.normalizeMetaState(paramInt);
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int i1 = this.E;
    this.E = (paramBoolean | i1 & 0xFFFFFFFE);
    if (i1 != this.E) {
      this.b.b(false);
    }
    return this;
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.E & 0x4) != 0)
    {
      hl localhl = this.b;
      int i2 = getGroupId();
      int i3 = localhl.c.size();
      localhl.d();
      int i1 = 0;
      while (i1 < i3)
      {
        hn localhn = (hn)localhl.c.get(i1);
        if ((localhn.getGroupId() == i2) && (localhn.e()) && (localhn.isCheckable()))
        {
          if (localhn == this) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          localhn.e(paramBoolean);
        }
        i1 += 1;
      }
      localhl.e();
      return this;
    }
    e(paramBoolean);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.E |= 0x10;
    } else {
      this.E &= 0xFFFFFFEF;
    }
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.s = null;
    this.t = paramInt;
    this.D = true;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.t = 0;
    this.s = paramDrawable;
    this.D = true;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.z = paramColorStateList;
    this.B = true;
    this.D = true;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.A = paramMode;
    this.C = true;
    this.D = true;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.n = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.o == paramChar) {
      return this;
    }
    this.o = paramChar;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.o == paramChar) && (this.p == paramInt)) {
      return this;
    }
    this.o = paramChar;
    this.p = KeyEvent.normalizeMetaState(paramInt);
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.H = paramOnActionExpandListener;
    return this;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.w = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.o = paramChar1;
    this.q = Character.toLowerCase(paramChar2);
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.o = paramChar1;
    this.p = KeyEvent.normalizeMetaState(paramInt1);
    this.q = Character.toLowerCase(paramChar2);
    this.r = KeyEvent.normalizeMetaState(paramInt2);
    this.b.b(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.F = paramInt;
    this.b.g();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.b.a.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.l = paramCharSequence;
    this.b.b(false);
    hy localhy = this.u;
    if (localhy != null) {
      localhy.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (b(paramBoolean)) {
      this.b.f();
    }
    return this;
  }
  
  public final String toString()
  {
    CharSequence localCharSequence = this.l;
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hn
 * JD-Core Version:    0.7.0.1
 */