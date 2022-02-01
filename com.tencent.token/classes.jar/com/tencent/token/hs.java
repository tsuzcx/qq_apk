package com.tencent.token;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public final class hs
  extends ActionMode
{
  final Context a;
  final ho b;
  
  public hs(Context paramContext, ho paramho)
  {
    this.a = paramContext;
    this.b = paramho;
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
    return im.a(this.a, (ee)this.b.b());
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
    implements ho.a
  {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<hs> c;
    final ex<Menu, Menu> d;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.b = paramContext;
      this.a = paramCallback;
      this.c = new ArrayList();
      this.d = new ex();
    }
    
    private Menu a(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.d.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = im.a(this.b, (ee)paramMenu);
        this.d.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(ho paramho)
    {
      this.a.onDestroyActionMode(b(paramho));
    }
    
    public final boolean a(ho paramho, Menu paramMenu)
    {
      return this.a.onCreateActionMode(b(paramho), a(paramMenu));
    }
    
    public final boolean a(ho paramho, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(b(paramho), im.a(this.b, (ef)paramMenuItem));
    }
    
    public final ActionMode b(ho paramho)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        hs localhs = (hs)this.c.get(i);
        if ((localhs != null) && (localhs.b == paramho)) {
          return localhs;
        }
        i += 1;
      }
      paramho = new hs(this.b, paramho);
      this.c.add(paramho);
      return paramho;
    }
    
    public final boolean b(ho paramho, Menu paramMenu)
    {
      return this.a.onPrepareActionMode(b(paramho), a(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hs
 * JD-Core Version:    0.7.0.1
 */