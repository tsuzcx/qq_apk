package com.tencent.token;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public final class ha
  extends ActionMode
{
  final Context a;
  final gw b;
  
  public ha(Context paramContext, gw paramgw)
  {
    this.a = paramContext;
    this.b = paramgw;
  }
  
  public final void finish()
  {
    this.b.c();
  }
  
  public final View getCustomView()
  {
    return this.b.i();
  }
  
  public final Menu getMenu()
  {
    return hu.a(this.a, (dm)this.b.b());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.b.a();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.b.g();
  }
  
  public final Object getTag()
  {
    return this.b.c;
  }
  
  public final CharSequence getTitle()
  {
    return this.b.f();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.b.d;
  }
  
  public final void invalidate()
  {
    this.b.d();
  }
  
  public final boolean isTitleOptional()
  {
    return this.b.h();
  }
  
  public final void setCustomView(View paramView)
  {
    this.b.a(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.b.a(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.b.c = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.b.b(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public static final class a
    implements gw.a
  {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<ha> c;
    final ef<Menu, Menu> d;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.b = paramContext;
      this.a = paramCallback;
      this.c = new ArrayList();
      this.d = new ef();
    }
    
    private Menu a(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.d.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = hu.a(this.b, (dm)paramMenu);
        this.d.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(gw paramgw)
    {
      this.a.onDestroyActionMode(b(paramgw));
    }
    
    public final boolean a(gw paramgw, Menu paramMenu)
    {
      return this.a.onCreateActionMode(b(paramgw), a(paramMenu));
    }
    
    public final boolean a(gw paramgw, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(b(paramgw), hu.a(this.b, (dn)paramMenuItem));
    }
    
    public final ActionMode b(gw paramgw)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        ha localha = (ha)this.c.get(i);
        if ((localha != null) && (localha.b == paramgw)) {
          return localha;
        }
        i += 1;
      }
      paramgw = new ha(this.b, paramgw);
      this.c.add(paramgw);
      return paramgw;
    }
    
    public final boolean b(gw paramgw, Menu paramMenu)
    {
      return this.a.onPrepareActionMode(b(paramgw), a(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ha
 * JD-Core Version:    0.7.0.1
 */