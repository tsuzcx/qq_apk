package android.support.v7.view.menu;

import android.support.annotation.NonNull;
import android.support.v7.widget.MenuPopupWindow;
import android.widget.ListView;

class CascadingMenuPopup$CascadingMenuInfo
{
  public final MenuBuilder menu;
  public final int position;
  public final MenuPopupWindow window;
  
  public CascadingMenuPopup$CascadingMenuInfo(@NonNull MenuPopupWindow paramMenuPopupWindow, @NonNull MenuBuilder paramMenuBuilder, int paramInt)
  {
    this.window = paramMenuPopupWindow;
    this.menu = paramMenuBuilder;
    this.position = paramInt;
  }
  
  public ListView getListView()
  {
    return this.window.getListView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.CascadingMenuPopup.CascadingMenuInfo
 * JD-Core Version:    0.7.0.1
 */