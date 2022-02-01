package com.tencent.token;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class hz
  extends hm
  implements SubMenu
{
  public hm l;
  private ho m;
  
  public hz(Context paramContext, hm paramhm, ho paramho)
  {
    super(paramContext);
    this.l = paramhm;
    this.m = paramho;
  }
  
  public final String a()
  {
    Object localObject = this.m;
    int i;
    if (localObject != null) {
      i = ((ho)localObject).getItemId();
    } else {
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(super.a());
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(i);
    return ((StringBuilder)localObject).toString();
  }
  
  public final void a(hm.a parama)
  {
    this.l.a(parama);
  }
  
  final boolean a(hm paramhm, MenuItem paramMenuItem)
  {
    return (super.a(paramhm, paramMenuItem)) || (this.l.a(paramhm, paramMenuItem));
  }
  
  public final boolean a(ho paramho)
  {
    return this.l.a(paramho);
  }
  
  public final boolean b()
  {
    return this.l.b();
  }
  
  public final boolean b(ho paramho)
  {
    return this.l.b(paramho);
  }
  
  public final boolean c()
  {
    return this.l.c();
  }
  
  public final MenuItem getItem()
  {
    return this.m;
  }
  
  public final hm k()
  {
    return this.l.k();
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    super.a(0, null, paramInt, null, null);
    return (SubMenu)this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.a(0, null, 0, paramDrawable, null);
    return (SubMenu)this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    super.a(paramInt, null, 0, null, null);
    return (SubMenu)this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.a(0, paramCharSequence, 0, null, null);
    return (SubMenu)this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    super.a(0, null, 0, null, paramView);
    return (SubMenu)this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    this.m.setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    this.m.setIcon(paramDrawable);
    return this;
  }
  
  public final void setQwertyMode(boolean paramBoolean)
  {
    this.l.setQwertyMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hz
 * JD-Core Version:    0.7.0.1
 */