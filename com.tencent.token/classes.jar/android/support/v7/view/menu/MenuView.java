package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface MenuView
{
  public abstract int getWindowAnimations();
  
  public abstract void initialize(MenuBuilder paramMenuBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.MenuView
 * JD-Core Version:    0.7.0.1
 */