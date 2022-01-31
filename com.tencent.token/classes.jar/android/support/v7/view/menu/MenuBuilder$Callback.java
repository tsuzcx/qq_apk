package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;
import android.view.MenuItem;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface MenuBuilder$Callback
{
  public abstract boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem);
  
  public abstract void onMenuModeChange(MenuBuilder paramMenuBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.MenuBuilder.Callback
 * JD-Core Version:    0.7.0.1
 */