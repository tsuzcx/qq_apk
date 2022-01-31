package android.support.v7.widget;

import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

class PopupMenu$3
  extends ForwardingListener
{
  PopupMenu$3(PopupMenu paramPopupMenu, View paramView)
  {
    super(paramView);
  }
  
  public ShowableListMenu getPopup()
  {
    return this.this$0.mPopup.getPopup();
  }
  
  protected boolean onForwardingStarted()
  {
    this.this$0.show();
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    this.this$0.dismiss();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.PopupMenu.3
 * JD-Core Version:    0.7.0.1
 */