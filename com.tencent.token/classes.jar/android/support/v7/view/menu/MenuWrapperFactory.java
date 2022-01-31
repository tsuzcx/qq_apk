package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class MenuWrapperFactory
{
  public static Menu wrapSupportMenu(Context paramContext, SupportMenu paramSupportMenu)
  {
    return new MenuWrapperICS(paramContext, paramSupportMenu);
  }
  
  public static MenuItem wrapSupportMenuItem(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new MenuItemWrapperJB(paramContext, paramSupportMenuItem);
    }
    return new MenuItemWrapperICS(paramContext, paramSupportMenuItem);
  }
  
  public static SubMenu wrapSupportSubMenu(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    return new SubMenuWrapperICS(paramContext, paramSupportSubMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.MenuWrapperFactory
 * JD-Core Version:    0.7.0.1
 */