package android.support.v7.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

class Toolbar$ExpandedActionViewMenuPresenter
  implements MenuPresenter
{
  MenuItemImpl mCurrentExpandedItem;
  MenuBuilder mMenu;
  
  Toolbar$ExpandedActionViewMenuPresenter(Toolbar paramToolbar) {}
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    if ((this.this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
    }
    this.this$0.removeView(this.this$0.mExpandedActionView);
    this.this$0.removeView(this.this$0.mCollapseButtonView);
    this.this$0.mExpandedActionView = null;
    this.this$0.addChildrenForExpandedActionView();
    this.mCurrentExpandedItem = null;
    this.this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(false);
    return true;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    this.this$0.ensureCollapseButtonView();
    paramMenuBuilder = this.this$0.mCollapseButtonView.getParent();
    if (paramMenuBuilder != this.this$0)
    {
      if ((paramMenuBuilder instanceof ViewGroup)) {
        ((ViewGroup)paramMenuBuilder).removeView(this.this$0.mCollapseButtonView);
      }
      this.this$0.addView(this.this$0.mCollapseButtonView);
    }
    this.this$0.mExpandedActionView = paramMenuItemImpl.getActionView();
    this.mCurrentExpandedItem = paramMenuItemImpl;
    paramMenuBuilder = this.this$0.mExpandedActionView.getParent();
    if (paramMenuBuilder != this.this$0)
    {
      if ((paramMenuBuilder instanceof ViewGroup)) {
        ((ViewGroup)paramMenuBuilder).removeView(this.this$0.mExpandedActionView);
      }
      paramMenuBuilder = this.this$0.generateDefaultLayoutParams();
      paramMenuBuilder.gravity = (0x800003 | this.this$0.mButtonGravity & 0x70);
      paramMenuBuilder.mViewType = 2;
      this.this$0.mExpandedActionView.setLayoutParams(paramMenuBuilder);
      this.this$0.addView(this.this$0.mExpandedActionView);
    }
    this.this$0.removeChildrenForExpandedActionView();
    this.this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(true);
    if ((this.this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded();
    }
    return true;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    if ((this.mMenu != null) && (this.mCurrentExpandedItem != null)) {
      this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
    }
    this.mMenu = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public void updateMenuView(boolean paramBoolean)
  {
    int k = 0;
    int j;
    int m;
    int i;
    if (this.mCurrentExpandedItem != null)
    {
      j = k;
      if (this.mMenu != null)
      {
        m = this.mMenu.size();
        i = 0;
      }
    }
    for (;;)
    {
      j = k;
      if (i < m)
      {
        if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.Toolbar.ExpandedActionViewMenuPresenter
 * JD-Core Version:    0.7.0.1
 */