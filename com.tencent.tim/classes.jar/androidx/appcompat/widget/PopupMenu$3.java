package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.PopupMenu.3
 * JD-Core Version:    0.7.0.1
 */