package android.support.v7.app;

import android.view.View;
import android.view.View.OnClickListener;

class ActionBarDrawerToggle$1
  implements View.OnClickListener
{
  ActionBarDrawerToggle$1(ActionBarDrawerToggle paramActionBarDrawerToggle) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mDrawerIndicatorEnabled) {
      this.this$0.toggle();
    }
    while (this.this$0.mToolbarNavigationClickListener == null) {
      return;
    }
    this.this$0.mToolbarNavigationClickListener.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.1
 * JD-Core Version:    0.7.0.1
 */