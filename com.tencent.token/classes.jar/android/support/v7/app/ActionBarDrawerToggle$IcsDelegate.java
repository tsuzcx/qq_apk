package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

class ActionBarDrawerToggle$IcsDelegate
  implements ActionBarDrawerToggle.Delegate
{
  final Activity mActivity;
  ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;
  
  ActionBarDrawerToggle$IcsDelegate(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public Context getActionBarThemedContext()
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null) {
      return localActionBar.getThemedContext();
    }
    return this.mActivity;
  }
  
  public Drawable getThemeUpIndicator()
  {
    return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
  }
  
  public boolean isNavigationVisible()
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
  }
  
  public void setActionBarDescription(int paramInt)
  {
    this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null)
    {
      localActionBar.setDisplayShowHomeEnabled(true);
      this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, paramDrawable, paramInt);
      localActionBar.setDisplayShowHomeEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.IcsDelegate
 * JD-Core Version:    0.7.0.1
 */