package com.tencent.token;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class ir
  extends in
  implements SubMenu
{
  ir(Context paramContext, eg parameg)
  {
    super(paramContext, parameg);
  }
  
  public final void clearHeader()
  {
    ((eg)this.d).clearHeader();
  }
  
  public final MenuItem getItem()
  {
    return a(((eg)this.d).getItem());
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    ((eg)this.d).setHeaderIcon(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((eg)this.d).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    ((eg)this.d).setHeaderTitle(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((eg)this.d).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    ((eg)this.d).setHeaderView(paramView);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    ((eg)this.d).setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    ((eg)this.d).setIcon(paramDrawable);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ir
 * JD-Core Version:    0.7.0.1
 */