package android.support.v7.internal.view.menu;

import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

abstract class BaseMenuWrapper
  extends BaseWrapper
{
  private HashMap mMenuItems;
  private HashMap mSubMenus;
  
  BaseMenuWrapper(Object paramObject)
  {
    super(paramObject);
  }
  
  final SupportMenuItem getMenuItemWrapper(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null)
    {
      if (this.mMenuItems == null) {
        this.mMenuItems = new HashMap();
      }
      SupportMenuItem localSupportMenuItem2 = (SupportMenuItem)this.mMenuItems.get(paramMenuItem);
      SupportMenuItem localSupportMenuItem1 = localSupportMenuItem2;
      if (localSupportMenuItem2 == null)
      {
        localSupportMenuItem1 = MenuWrapperFactory.createSupportMenuItemWrapper(paramMenuItem);
        this.mMenuItems.put(paramMenuItem, localSupportMenuItem1);
      }
      return localSupportMenuItem1;
    }
    return null;
  }
  
  final SubMenu getSubMenuWrapper(SubMenu paramSubMenu)
  {
    if (paramSubMenu != null)
    {
      if (this.mSubMenus == null) {
        this.mSubMenus = new HashMap();
      }
      SubMenu localSubMenu = (SubMenu)this.mSubMenus.get(paramSubMenu);
      Object localObject = localSubMenu;
      if (localSubMenu == null)
      {
        localObject = MenuWrapperFactory.createSupportSubMenuWrapper(paramSubMenu);
        this.mSubMenus.put(paramSubMenu, localObject);
      }
      return localObject;
    }
    return null;
  }
  
  final void internalClear()
  {
    if (this.mMenuItems != null) {
      this.mMenuItems.clear();
    }
    if (this.mSubMenus != null) {
      this.mSubMenus.clear();
    }
  }
  
  final void internalRemoveGroup(int paramInt)
  {
    if (this.mMenuItems == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mMenuItems.keySet().iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((MenuItem)localIterator.next()).getGroupId()) {
          localIterator.remove();
        }
      }
    }
  }
  
  final void internalRemoveItem(int paramInt)
  {
    if (this.mMenuItems == null) {}
    Iterator localIterator;
    do
    {
      return;
      while (!localIterator.hasNext()) {
        localIterator = this.mMenuItems.keySet().iterator();
      }
    } while (paramInt != ((MenuItem)localIterator.next()).getItemId());
    localIterator.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.BaseMenuWrapper
 * JD-Core Version:    0.7.0.1
 */