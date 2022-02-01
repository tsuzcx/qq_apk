package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class hf
  implements do
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private CharSequence e;
  private CharSequence f;
  private Intent g;
  private char h;
  private int i = 4096;
  private char j;
  private int k = 4096;
  private Drawable l;
  private int m = 0;
  private Context n;
  private MenuItem.OnMenuItemClickListener o;
  private CharSequence p;
  private CharSequence q;
  private ColorStateList r = null;
  private PorterDuff.Mode s = null;
  private boolean t = false;
  private boolean u = false;
  private int v = 16;
  
  public hf(Context paramContext, CharSequence paramCharSequence)
  {
    this.n = paramContext;
    this.a = 16908332;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = paramCharSequence;
  }
  
  private void b()
  {
    if ((this.l != null) && ((this.t) || (this.u)))
    {
      this.l = dh.d(this.l);
      this.l = this.l.mutate();
      if (this.t) {
        dh.a(this.l, this.r);
      }
      if (this.u) {
        dh.a(this.l, this.s);
      }
    }
  }
  
  public final do a(ej paramej)
  {
    throw new UnsupportedOperationException();
  }
  
  public final do a(CharSequence paramCharSequence)
  {
    this.p = paramCharSequence;
    return this;
  }
  
  public final ej a()
  {
    return null;
  }
  
  public final do b(CharSequence paramCharSequence)
  {
    this.q = paramCharSequence;
    return this;
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final boolean expandActionView()
  {
    return false;
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public final View getActionView()
  {
    return null;
  }
  
  public final int getAlphabeticModifiers()
  {
    return this.k;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.j;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.p;
  }
  
  public final int getGroupId()
  {
    return this.b;
  }
  
  public final Drawable getIcon()
  {
    return this.l;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.r;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.s;
  }
  
  public final Intent getIntent()
  {
    return this.g;
  }
  
  public final int getItemId()
  {
    return this.a;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public final int getNumericModifiers()
  {
    return this.i;
  }
  
  public final char getNumericShortcut()
  {
    return this.h;
  }
  
  public final int getOrder()
  {
    return this.d;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.e;
  }
  
  public final CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence = this.f;
    if (localCharSequence != null) {
      return localCharSequence;
    }
    return this.e;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.q;
  }
  
  public final boolean hasSubMenu()
  {
    return false;
  }
  
  public final boolean isActionViewExpanded()
  {
    return false;
  }
  
  public final boolean isCheckable()
  {
    return (this.v & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.v & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.v & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.v & 0x8) == 0;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.j = Character.toLowerCase(paramChar);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.j = Character.toLowerCase(paramChar);
    this.k = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    this.v = (paramBoolean | this.v & 0xFFFFFFFE);
    return this;
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int i2 = this.v;
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    this.v = (i1 | i2 & 0xFFFFFFFD);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int i2 = this.v;
    int i1;
    if (paramBoolean) {
      i1 = 16;
    } else {
      i1 = 0;
    }
    this.v = (i1 | i2 & 0xFFFFFFEF);
    return this;
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.m = paramInt;
    this.l = cs.a(this.n, paramInt);
    b();
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.l = paramDrawable;
    this.m = 0;
    b();
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.r = paramColorStateList;
    this.t = true;
    b();
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.s = paramMode;
    this.u = true;
    b();
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.g = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.h = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.h = paramChar;
    this.i = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.o = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.h = paramChar1;
    this.j = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.h = paramChar1;
    this.i = KeyEvent.normalizeMetaState(paramInt1);
    this.j = Character.toLowerCase(paramChar2);
    this.k = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.e = this.n.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int i2 = this.v;
    int i1 = 8;
    if (paramBoolean) {
      i1 = 0;
    }
    this.v = (i2 & 0x8 | i1);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hf
 * JD-Core Version:    0.7.0.1
 */