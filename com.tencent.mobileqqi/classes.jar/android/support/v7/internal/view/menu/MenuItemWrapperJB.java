package android.support.v7.internal.view.menu;

import android.support.v4.view.ActionProvider;
import android.view.MenuItem;

class MenuItemWrapperJB
  extends MenuItemWrapperICS
{
  MenuItemWrapperJB(MenuItem paramMenuItem)
  {
    super(paramMenuItem, false);
  }
  
  MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider paramActionProvider)
  {
    return new MenuItemWrapperJB.ActionProviderWrapperJB(this, paramActionProvider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperJB
 * JD-Core Version:    0.7.0.1
 */