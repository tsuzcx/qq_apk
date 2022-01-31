package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MenuPopupWindow$MenuDropDownListView
  extends DropDownListView
{
  final int mAdvanceKey;
  private MenuItemHoverListener mHoverListener;
  private MenuItem mHoveredMenuItem;
  final int mRetreatKey;
  
  public MenuPopupWindow$MenuDropDownListView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    paramContext = paramContext.getResources().getConfiguration();
    if ((Build.VERSION.SDK_INT >= 17) && (1 == paramContext.getLayoutDirection()))
    {
      this.mAdvanceKey = 21;
      this.mRetreatKey = 22;
      return;
    }
    this.mAdvanceKey = 22;
    this.mRetreatKey = 21;
  }
  
  public void clearSelection()
  {
    setSelection(-1);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    int i;
    if (this.mHoverListener != null)
    {
      localObject = getAdapter();
      if (!(localObject instanceof HeaderViewListAdapter)) {
        break label166;
      }
      localObject = (HeaderViewListAdapter)localObject;
      i = ((HeaderViewListAdapter)localObject).getHeadersCount();
      localObject = (MenuAdapter)((HeaderViewListAdapter)localObject).getWrappedAdapter();
      if (paramMotionEvent.getAction() == 10) {
        break label178;
      }
      int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (j == -1) {
        break label178;
      }
      i = j - i;
      if ((i < 0) || (i >= ((MenuAdapter)localObject).getCount())) {
        break label178;
      }
    }
    label166:
    label178:
    for (MenuItemImpl localMenuItemImpl = ((MenuAdapter)localObject).getItem(i);; localMenuItemImpl = null)
    {
      MenuItem localMenuItem = this.mHoveredMenuItem;
      if (localMenuItem != localMenuItemImpl)
      {
        localObject = ((MenuAdapter)localObject).getAdapterMenu();
        if (localMenuItem != null) {
          this.mHoverListener.onItemHoverExit((MenuBuilder)localObject, localMenuItem);
        }
        this.mHoveredMenuItem = localMenuItemImpl;
        if (localMenuItemImpl != null) {
          this.mHoverListener.onItemHoverEnter((MenuBuilder)localObject, localMenuItemImpl);
        }
      }
      return super.onHoverEvent(paramMotionEvent);
      i = 0;
      localObject = (MenuAdapter)localObject;
      break;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
    if ((localListMenuItemView != null) && (paramInt == this.mAdvanceKey))
    {
      if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
        performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
      }
      return true;
    }
    if ((localListMenuItemView != null) && (paramInt == this.mRetreatKey))
    {
      setSelection(-1);
      ((MenuAdapter)getAdapter()).getAdapterMenu().close(false);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setHoverListener(MenuItemHoverListener paramMenuItemHoverListener)
  {
    this.mHoverListener = paramMenuItemHoverListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.MenuPopupWindow.MenuDropDownListView
 * JD-Core Version:    0.7.0.1
 */