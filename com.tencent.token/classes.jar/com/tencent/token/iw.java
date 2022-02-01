package com.tencent.token;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class iw
  extends ListPopupWindow
  implements iv
{
  private static Method b;
  public iv a;
  
  static
  {
    try
    {
      b = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public iw(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, null, paramInt1, paramInt2);
  }
  
  public final is a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new a(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    return paramContext;
  }
  
  public final void a()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.q.setEnterTransition(null);
    }
  }
  
  public final void a(hm paramhm, MenuItem paramMenuItem)
  {
    iv localiv = this.a;
    if (localiv != null) {
      localiv.a(paramhm, paramMenuItem);
    }
  }
  
  public final void b(hm paramhm, MenuItem paramMenuItem)
  {
    iv localiv = this.a;
    if (localiv != null) {
      localiv.b(paramhm, paramMenuItem);
    }
  }
  
  public final void l()
  {
    Method localMethod = b;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(this.q, new Object[] { Boolean.FALSE });
      return;
    }
    catch (Exception localException) {}
    return;
  }
  
  public static final class a
    extends is
  {
    final int a;
    final int b;
    private iv c;
    private MenuItem d;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
      paramContext = paramContext.getResources().getConfiguration();
      if ((Build.VERSION.SDK_INT >= 17) && (1 == paramContext.getLayoutDirection()))
      {
        this.a = 21;
        this.b = 22;
        return;
      }
      this.a = 22;
      this.b = 21;
    }
    
    public final boolean onHoverEvent(MotionEvent paramMotionEvent)
    {
      if (this.c != null)
      {
        Object localObject1 = getAdapter();
        int i;
        if ((localObject1 instanceof HeaderViewListAdapter))
        {
          localObject1 = (HeaderViewListAdapter)localObject1;
          i = ((HeaderViewListAdapter)localObject1).getHeadersCount();
          localObject1 = (hl)((HeaderViewListAdapter)localObject1).getWrappedAdapter();
        }
        else
        {
          i = 0;
          localObject1 = (hl)localObject1;
        }
        MenuItem localMenuItem = null;
        Object localObject2 = localMenuItem;
        if (paramMotionEvent.getAction() != 10)
        {
          int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          localObject2 = localMenuItem;
          if (j != -1)
          {
            i = j - i;
            localObject2 = localMenuItem;
            if (i >= 0)
            {
              localObject2 = localMenuItem;
              if (i < ((hl)localObject1).getCount()) {
                localObject2 = ((hl)localObject1).a(i);
              }
            }
          }
        }
        localMenuItem = this.d;
        if (localMenuItem != localObject2)
        {
          localObject1 = ((hl)localObject1).b;
          if (localMenuItem != null) {
            this.c.a((hm)localObject1, localMenuItem);
          }
          this.d = ((MenuItem)localObject2);
          if (localObject2 != null) {
            this.c.b((hm)localObject1, (MenuItem)localObject2);
          }
        }
      }
      return super.onHoverEvent(paramMotionEvent);
    }
    
    public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
      ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
      if ((localListMenuItemView != null) && (paramInt == this.a))
      {
        if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
          performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
        }
        return true;
      }
      if ((localListMenuItemView != null) && (paramInt == this.b))
      {
        setSelection(-1);
        ((hl)getAdapter()).b.a(false);
        return true;
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    
    public final void setHoverListener(iv paramiv)
    {
      this.c = paramiv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.iw
 * JD-Core Version:    0.7.0.1
 */