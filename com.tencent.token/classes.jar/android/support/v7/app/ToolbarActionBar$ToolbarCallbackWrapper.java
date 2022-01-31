package android.support.v7.app;

import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.widget.DecorToolbar;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class ToolbarActionBar$ToolbarCallbackWrapper
  extends WindowCallbackWrapper
{
  public ToolbarActionBar$ToolbarCallbackWrapper(ToolbarActionBar paramToolbarActionBar, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (paramInt == 0) {
      return new View(this.this$0.mDecorToolbar.getContext());
    }
    return super.onCreatePanelView(paramInt);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
    if ((bool) && (!this.this$0.mToolbarMenuPrepared))
    {
      this.this$0.mDecorToolbar.setMenuPrepared();
      this.this$0.mToolbarMenuPrepared = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.ToolbarCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */