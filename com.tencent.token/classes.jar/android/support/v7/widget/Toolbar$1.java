package android.support.v7.widget;

import android.view.MenuItem;

class Toolbar$1
  implements ActionMenuView.OnMenuItemClickListener
{
  Toolbar$1(Toolbar paramToolbar) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (this.this$0.mOnMenuItemClickListener != null) {
      return this.this$0.mOnMenuItemClickListener.onMenuItemClick(paramMenuItem);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.Toolbar.1
 * JD-Core Version:    0.7.0.1
 */