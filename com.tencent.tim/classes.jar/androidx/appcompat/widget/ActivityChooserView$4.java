package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

class ActivityChooserView$4
  extends ForwardingListener
{
  ActivityChooserView$4(ActivityChooserView paramActivityChooserView, View paramView)
  {
    super(paramView);
  }
  
  public ShowableListMenu getPopup()
  {
    return this.this$0.getListPopupWindow();
  }
  
  protected boolean onForwardingStarted()
  {
    this.this$0.showPopup();
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    this.this$0.dismissPopup();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView.4
 * JD-Core Version:    0.7.0.1
 */