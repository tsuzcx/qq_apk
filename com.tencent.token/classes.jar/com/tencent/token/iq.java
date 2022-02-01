package com.tencent.token;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class iq
  extends id
  implements SubMenu
{
  public id l;
  private if m;
  
  public iq(Context paramContext, id paramid, if paramif)
  {
    super(paramContext);
    this.l = paramid;
    this.m = paramif;
  }
  
  public final String a()
  {
    Object localObject = this.m;
    int i;
    if (localObject != null) {
      i = ((if)localObject).getItemId();
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
  
  public final void a(id.a parama)
  {
    this.l.a(parama);
  }
  
  final boolean a(id paramid, MenuItem paramMenuItem)
  {
    return (super.a(paramid, paramMenuItem)) || (this.l.a(paramid, paramMenuItem));
  }
  
  public final boolean a(if paramif)
  {
    return this.l.a(paramif);
  }
  
  public final boolean b()
  {
    return this.l.b();
  }
  
  public final boolean b(if paramif)
  {
    return this.l.b(paramif);
  }
  
  public final boolean c()
  {
    return this.l.c();
  }
  
  public final MenuItem getItem()
  {
    return this.m;
  }
  
  public final id k()
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
 * Qualified Name:     com.tencent.token.iq
 * JD-Core Version:    0.7.0.1
 */