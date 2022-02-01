package com.tencent.token;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public final class he
  extends ActionMode
{
  final Context a;
  final ha b;
  
  public he(Context paramContext, ha paramha)
  {
    this.a = paramContext;
    this.b = paramha;
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
    return hy.a(this.a, (dq)this.b.b());
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
    implements ha.a
  {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<he> c;
    final ej<Menu, Menu> d;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.b = paramContext;
      this.a = paramCallback;
      this.c = new ArrayList();
      this.d = new ej();
    }
    
    private Menu a(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.d.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = hy.a(this.b, (dq)paramMenu);
        this.d.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(ha paramha)
    {
      this.a.onDestroyActionMode(b(paramha));
    }
    
    public final boolean a(ha paramha, Menu paramMenu)
    {
      return this.a.onCreateActionMode(b(paramha), a(paramMenu));
    }
    
    public final boolean a(ha paramha, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(b(paramha), hy.a(this.b, (dr)paramMenuItem));
    }
    
    public final ActionMode b(ha paramha)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        he localhe = (he)this.c.get(i);
        if ((localhe != null) && (localhe.b == paramha)) {
          return localhe;
        }
        i += 1;
      }
      paramha = new he(this.b, paramha);
      this.c.add(paramha);
      return paramha;
    }
    
    public final boolean b(ha paramha, Menu paramMenu)
    {
      return this.a.onPrepareActionMode(b(paramha), a(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.he
 * JD-Core Version:    0.7.0.1
 */