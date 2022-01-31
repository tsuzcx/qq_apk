package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class MenuItemCompatHoneycomb
{
  public static View getActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.getActionView();
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    return paramMenuItem.setActionView(paramInt);
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    return paramMenuItem.setActionView(paramView);
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompatHoneycomb
 * JD-Core Version:    0.7.0.1
 */