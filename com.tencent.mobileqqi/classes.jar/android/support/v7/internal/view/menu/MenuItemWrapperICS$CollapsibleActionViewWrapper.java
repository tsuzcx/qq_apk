package android.support.v7.internal.view.menu;

import android.view.View;
import android.widget.FrameLayout;

class MenuItemWrapperICS$CollapsibleActionViewWrapper
  extends FrameLayout
  implements android.view.CollapsibleActionView
{
  final android.support.v7.view.CollapsibleActionView mWrappedView;
  
  MenuItemWrapperICS$CollapsibleActionViewWrapper(View paramView)
  {
    super(paramView.getContext());
    this.mWrappedView = ((android.support.v7.view.CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  View getWrappedView()
  {
    return (View)this.mWrappedView;
  }
  
  public void onActionViewCollapsed()
  {
    this.mWrappedView.onActionViewCollapsed();
  }
  
  public void onActionViewExpanded()
  {
    this.mWrappedView.onActionViewExpanded();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.CollapsibleActionViewWrapper
 * JD-Core Version:    0.7.0.1
 */