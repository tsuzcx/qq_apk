package android.support.v7.widget;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

class AppCompatSpinner$1
  extends ForwardingListener
{
  AppCompatSpinner$1(AppCompatSpinner paramAppCompatSpinner, View paramView, AppCompatSpinner.DropdownPopup paramDropdownPopup)
  {
    super(paramView);
  }
  
  public ShowableListMenu getPopup()
  {
    return this.val$popup;
  }
  
  public boolean onForwardingStarted()
  {
    if (!AppCompatSpinner.access$000(this.this$0).isShowing()) {
      AppCompatSpinner.access$000(this.this$0).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner.1
 * JD-Core Version:    0.7.0.1
 */