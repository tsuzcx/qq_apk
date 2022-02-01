package com.tencent.token;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public final class hb
  extends ActionMode
{
  final Context a;
  final gx b;
  
  public hb(Context paramContext, gx paramgx)
  {
    this.a = paramContext;
    this.b = paramgx;
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
    return hv.a(this.a, (dn)this.b.b());
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
    implements gx.a
  {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<hb> c;
    final eg<Menu, Menu> d;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.b = paramContext;
      this.a = paramCallback;
      this.c = new ArrayList();
      this.d = new eg();
    }
    
    private Menu a(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.d.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = hv.a(this.b, (dn)paramMenu);
        this.d.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(gx paramgx)
    {
      this.a.onDestroyActionMode(b(paramgx));
    }
    
    public final boolean a(gx paramgx, Menu paramMenu)
    {
      return this.a.onCreateActionMode(b(paramgx), a(paramMenu));
    }
    
    public final boolean a(gx paramgx, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(b(paramgx), hv.a(this.b, (do)paramMenuItem));
    }
    
    public final ActionMode b(gx paramgx)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        hb localhb = (hb)this.c.get(i);
        if ((localhb != null) && (localhb.b == paramgx)) {
          return localhb;
        }
        i += 1;
      }
      paramgx = new hb(this.b, paramgx);
      this.c.add(paramgx);
      return paramgx;
    }
    
    public final boolean b(gx paramgx, Menu paramMenu)
    {
      return this.a.onPrepareActionMode(b(paramgx), a(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hb
 * JD-Core Version:    0.7.0.1
 */