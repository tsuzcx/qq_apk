package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@RequiresApi(18)
class ActionBarDrawerToggle$JellybeanMr2Delegate
  implements ActionBarDrawerToggle.Delegate
{
  final Activity mActivity;
  
  ActionBarDrawerToggle$JellybeanMr2Delegate(Activity paramActivity)
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
    TypedArray localTypedArray = getActionBarThemedContext().obtainStyledAttributes(null, new int[] { 16843531 }, 16843470, 0);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public boolean isNavigationVisible()
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
  }
  
  public void setActionBarDescription(int paramInt)
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null) {
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null)
    {
      localActionBar.setHomeAsUpIndicator(paramDrawable);
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.JellybeanMr2Delegate
 * JD-Core Version:    0.7.0.1
 */