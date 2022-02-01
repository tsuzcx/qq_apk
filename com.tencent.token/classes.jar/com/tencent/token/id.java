package com.tencent.token;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class id
  extends hz
  implements SubMenu
{
  id(Context paramContext, ds paramds)
  {
    super(paramContext, paramds);
  }
  
  public final void clearHeader()
  {
    ((ds)this.d).clearHeader();
  }
  
  public final MenuItem getItem()
  {
    return a(((ds)this.d).getItem());
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    ((ds)this.d).setHeaderIcon(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((ds)this.d).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    ((ds)this.d).setHeaderTitle(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((ds)this.d).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    ((ds)this.d).setHeaderView(paramView);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    ((ds)this.d).setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    ((ds)this.d).setIcon(paramDrawable);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.id
 * JD-Core Version:    0.7.0.1
 */