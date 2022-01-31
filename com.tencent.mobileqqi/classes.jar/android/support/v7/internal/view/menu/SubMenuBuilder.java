package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder
  extends MenuBuilder
  implements SubMenu
{
  private MenuItemImpl mItem;
  private MenuBuilder mParentMenu;
  
  public SubMenuBuilder(Context paramContext, MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    super(paramContext);
    this.mParentMenu = paramMenuBuilder;
    this.mItem = paramMenuItemImpl;
  }
  
  public void clearHeader() {}
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    return this.mParentMenu.collapseItemActionView(paramMenuItemImpl);
  }
  
  public boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (super.dispatchMenuItemSelected(paramMenuBuilder, paramMenuItem)) || (this.mParentMenu.dispatchMenuItemSelected(paramMenuBuilder, paramMenuItem));
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    return this.mParentMenu.expandItemActionView(paramMenuItemImpl);
  }
  
  public String getActionViewStatesKey()
  {
    if (this.mItem != null) {}
    for (int i = this.mItem.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.getActionViewStatesKey() + ":" + i;
  }
  
  public MenuItem getItem()
  {
    return this.mItem;
  }
  
  public Menu getParentMenu()
  {
    return this.mParentMenu;
  }
  
  public MenuBuilder getRootMenu()
  {
    return this.mParentMenu;
  }
  
  public boolean isQwertyMode()
  {
    return this.mParentMenu.isQwertyMode();
  }
  
  public boolean isShortcutsVisible()
  {
    return this.mParentMenu.isShortcutsVisible();
  }
  
  public void setCallback(MenuBuilder.Callback paramCallback)
  {
    this.mParentMenu.setCallback(paramCallback);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    super.setHeaderIconInt(getContext().getResources().getDrawable(paramInt));
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.setHeaderIconInt(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    super.setHeaderTitleInt(getContext().getResources().getString(paramInt));
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.setHeaderTitleInt(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    super.setHeaderViewInt(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.mItem.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.mItem.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.mParentMenu.setQwertyMode(paramBoolean);
  }
  
  public void setShortcutsVisible(boolean paramBoolean)
  {
    this.mParentMenu.setShortcutsVisible(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.SubMenuBuilder
 * JD-Core Version:    0.7.0.1
 */