package android.support.v7.view.menu;

import android.support.v7.widget.ForwardingListener;

class ActionMenuItemView$ActionMenuItemForwardingListener
  extends ForwardingListener
{
  public ActionMenuItemView$ActionMenuItemForwardingListener(ActionMenuItemView paramActionMenuItemView)
  {
    super(paramActionMenuItemView);
  }
  
  public ShowableListMenu getPopup()
  {
    if (this.this$0.mPopupCallback != null) {
      return this.this$0.mPopupCallback.getPopup();
    }
    return null;
  }
  
  protected boolean onForwardingStarted()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.this$0.mItemInvoker != null)
    {
      bool1 = bool2;
      if (this.this$0.mItemInvoker.invokeItem(this.this$0.mItemData))
      {
        ShowableListMenu localShowableListMenu = getPopup();
        bool1 = bool2;
        if (localShowableListMenu != null)
        {
          bool1 = bool2;
          if (localShowableListMenu.isShowing()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView.ActionMenuItemForwardingListener
 * JD-Core Version:    0.7.0.1
 */