package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

class ActionBarView$ExpandedActionViewMenuPresenter
  implements MenuPresenter
{
  MenuItemImpl mCurrentExpandedItem;
  MenuBuilder mMenu;
  
  private ActionBarView$ExpandedActionViewMenuPresenter(ActionBarView paramActionBarView) {}
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    if ((this.this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
    }
    this.this$0.removeView(this.this$0.mExpandedActionView);
    this.this$0.removeView(ActionBarView.access$600(this.this$0));
    this.this$0.mExpandedActionView = null;
    if ((ActionBarView.access$1200(this.this$0) & 0x2) != 0) {
      ActionBarView.access$700(this.this$0).setVisibility(0);
    }
    if ((ActionBarView.access$1200(this.this$0) & 0x8) != 0)
    {
      if (ActionBarView.access$800(this.this$0) != null) {
        break label245;
      }
      ActionBarView.access$1300(this.this$0);
    }
    for (;;)
    {
      if ((ActionBarView.access$900(this.this$0) != null) && (ActionBarView.access$1400(this.this$0) == 2)) {
        ActionBarView.access$900(this.this$0).setVisibility(0);
      }
      if ((ActionBarView.access$1000(this.this$0) != null) && (ActionBarView.access$1400(this.this$0) == 1)) {
        ActionBarView.access$1000(this.this$0).setVisibility(0);
      }
      if ((ActionBarView.access$1100(this.this$0) != null) && ((ActionBarView.access$1200(this.this$0) & 0x10) != 0)) {
        ActionBarView.access$1100(this.this$0).setVisibility(0);
      }
      ActionBarView.access$600(this.this$0).setIcon(null);
      this.mCurrentExpandedItem = null;
      this.this$0.requestLayout();
      paramMenuItemImpl.setActionViewExpanded(false);
      return true;
      label245:
      ActionBarView.access$800(this.this$0).setVisibility(0);
    }
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    this.this$0.mExpandedActionView = paramMenuItemImpl.getActionView();
    ActionBarView.access$600(this.this$0).setIcon(ActionBarView.access$500(this.this$0).getConstantState().newDrawable(this.this$0.getResources()));
    this.mCurrentExpandedItem = paramMenuItemImpl;
    if (this.this$0.mExpandedActionView.getParent() != this.this$0) {
      this.this$0.addView(this.this$0.mExpandedActionView);
    }
    if (ActionBarView.access$600(this.this$0).getParent() != this.this$0) {
      this.this$0.addView(ActionBarView.access$600(this.this$0));
    }
    ActionBarView.access$700(this.this$0).setVisibility(8);
    if (ActionBarView.access$800(this.this$0) != null) {
      ActionBarView.access$800(this.this$0).setVisibility(8);
    }
    if (ActionBarView.access$900(this.this$0) != null) {
      ActionBarView.access$900(this.this$0).setVisibility(8);
    }
    if (ActionBarView.access$1000(this.this$0) != null) {
      ActionBarView.access$1000(this.this$0).setVisibility(8);
    }
    if (ActionBarView.access$1100(this.this$0) != null) {
      ActionBarView.access$1100(this.this$0).setVisibility(8);
    }
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
    if (this.mCurrentExpandedItem != null)
    {
      if (this.mMenu == null) {
        break label74;
      }
      int j = this.mMenu.size();
      i = 0;
      if (i >= j) {
        break label74;
      }
      if ((SupportMenuItem)this.mMenu.getItem(i) != this.mCurrentExpandedItem) {
        break label67;
      }
    }
    label67:
    label74:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
      }
      return;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarView.ExpandedActionViewMenuPresenter
 * JD-Core Version:    0.7.0.1
 */