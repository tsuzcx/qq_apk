package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuBuilder;
import android.view.MenuItem;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface MenuItemHoverListener
{
  public abstract void onItemHoverEnter(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem);
  
  public abstract void onItemHoverExit(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.MenuItemHoverListener
 * JD-Core Version:    0.7.0.1
 */