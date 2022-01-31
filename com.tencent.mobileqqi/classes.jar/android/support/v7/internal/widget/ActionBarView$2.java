package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.MenuItemImpl;
import android.view.View;
import android.view.View.OnClickListener;

class ActionBarView$2
  implements View.OnClickListener
{
  ActionBarView$2(ActionBarView paramActionBarView) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionBarView.access$100(this.this$0).mCurrentExpandedItem;
    if (paramView != null) {
      paramView.collapseActionView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarView.2
 * JD-Core Version:    0.7.0.1
 */