package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window.Callback;

class ToolbarWidgetWrapper$1
  implements View.OnClickListener
{
  final ActionMenuItem mNavItem = new ActionMenuItem(this.this$0.mToolbar.getContext(), 0, 16908332, 0, 0, this.this$0.mTitle);
  
  ToolbarWidgetWrapper$1(ToolbarWidgetWrapper paramToolbarWidgetWrapper) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mWindowCallback != null) && (this.this$0.mMenuPrepared)) {
      this.this$0.mWindowCallback.onMenuItemSelected(0, this.mNavItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ToolbarWidgetWrapper.1
 * JD-Core Version:    0.7.0.1
 */