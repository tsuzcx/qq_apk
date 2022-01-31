package android.support.v7.widget;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.4
 * JD-Core Version:    0.7.0.1
 */