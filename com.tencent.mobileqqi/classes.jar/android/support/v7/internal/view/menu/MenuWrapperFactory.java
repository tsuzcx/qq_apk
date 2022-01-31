package android.support.v7.internal.view.menu;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class MenuWrapperFactory
{
  public static MenuItem createMenuItemWrapper(MenuItem paramMenuItem)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 16) {
      localObject = new MenuItemWrapperJB(paramMenuItem);
    }
    do
    {
      return localObject;
      localObject = paramMenuItem;
    } while (Build.VERSION.SDK_INT < 14);
    return new MenuItemWrapperICS(paramMenuItem);
  }
  
  public static Menu createMenuWrapper(Menu paramMenu)
  {
    Object localObject = paramMenu;
    if (Build.VERSION.SDK_INT >= 14) {
      localObject = new MenuWrapperICS(paramMenu);
    }
    return localObject;
  }
  
  public static SupportMenuItem createSupportMenuItemWrapper(MenuItem paramMenuItem)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new MenuItemWrapperJB(paramMenuItem);
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return new MenuItemWrapperICS(paramMenuItem);
    }
    throw new UnsupportedOperationException();
  }
  
  public static SupportMenu createSupportMenuWrapper(Menu paramMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new MenuWrapperICS(paramMenu);
    }
    throw new UnsupportedOperationException();
  }
  
  public static SupportSubMenu createSupportSubMenuWrapper(SubMenu paramSubMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new SubMenuWrapperICS(paramSubMenu);
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuWrapperFactory
 * JD-Core Version:    0.7.0.1
 */