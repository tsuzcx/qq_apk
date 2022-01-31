package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import java.lang.reflect.Method;

@Deprecated
public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private static final int ID_HOME = 16908332;
  private static final String TAG = "ActionBarDrawerToggle";
  private static final int[] THEME_ATTRS = { 16843531 };
  private static final float TOGGLE_DRAWABLE_OFFSET = 0.3333333F;
  final Activity mActivity;
  private final ActionBarDrawerToggle.Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private Drawable mDrawerImage;
  private final int mDrawerImageResource;
  private boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private boolean mHasCustomUpIndicator;
  private Drawable mHomeAsUpIndicator;
  private final int mOpenDrawerContentDescRes;
  private ActionBarDrawerToggle.SetIndicatorInfo mSetIndicatorInfo;
  private ActionBarDrawerToggle.SlideDrawable mSlider;
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, @DrawableRes int paramInt1, @StringRes int paramInt2, @StringRes int paramInt3) {}
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, boolean paramBoolean, @DrawableRes int paramInt1, @StringRes int paramInt2, @StringRes int paramInt3)
  {
    this.mActivity = paramActivity;
    if ((paramActivity instanceof ActionBarDrawerToggle.DelegateProvider))
    {
      this.mActivityImpl = ((ActionBarDrawerToggle.DelegateProvider)paramActivity).getDrawerToggleDelegate();
      this.mDrawerLayout = paramDrawerLayout;
      this.mDrawerImageResource = paramInt1;
      this.mOpenDrawerContentDescRes = paramInt2;
      this.mCloseDrawerContentDescRes = paramInt3;
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      this.mDrawerImage = ContextCompat.getDrawable(paramActivity, paramInt1);
      this.mSlider = new ActionBarDrawerToggle.SlideDrawable(this, this.mDrawerImage);
      paramActivity = this.mSlider;
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (float f = 0.3333333F;; f = 0.0F)
    {
      paramActivity.setOffset(f);
      return;
      this.mActivityImpl = null;
      break;
    }
  }
  
  private static boolean assumeMaterial(Context paramContext)
  {
    return (paramContext.getApplicationInfo().targetSdkVersion >= 21) && (Build.VERSION.SDK_INT >= 21);
  }
  
  private Drawable getThemeUpIndicator()
  {
    if (this.mActivityImpl != null) {
      return this.mActivityImpl.getThemeUpIndicator();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject = this.mActivity.getActionBar();
      if (localObject != null) {}
      for (localObject = ((ActionBar)localObject).getThemedContext();; localObject = this.mActivity)
      {
        localObject = ((Context)localObject).obtainStyledAttributes(null, THEME_ATTRS, 16843470, 0);
        localDrawable = ((TypedArray)localObject).getDrawable(0);
        ((TypedArray)localObject).recycle();
        return localDrawable;
      }
    }
    Object localObject = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
    Drawable localDrawable = ((TypedArray)localObject).getDrawable(0);
    ((TypedArray)localObject).recycle();
    return localDrawable;
  }
  
  private void setActionBarDescription(int paramInt)
  {
    if (this.mActivityImpl != null) {
      this.mActivityImpl.setActionBarDescription(paramInt);
    }
    ActionBar localActionBar;
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT < 18) {
          break;
        }
        localActionBar = this.mActivity.getActionBar();
      } while (localActionBar == null);
      localActionBar.setHomeActionContentDescription(paramInt);
      return;
      if (this.mSetIndicatorInfo == null) {
        this.mSetIndicatorInfo = new ActionBarDrawerToggle.SetIndicatorInfo(this.mActivity);
      }
    } while (this.mSetIndicatorInfo.mSetHomeAsUpIndicator == null);
    try
    {
      localActionBar = this.mActivity.getActionBar();
      this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(localActionBar, new Object[] { Integer.valueOf(paramInt) });
      localActionBar.setSubtitle(localActionBar.getSubtitle());
      return;
    }
    catch (Exception localException)
    {
      Log.w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", localException);
    }
  }
  
  private void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if (this.mActivityImpl != null) {
      this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
    }
    ActionBar localActionBar;
    do
    {
      return;
      if (Build.VERSION.SDK_INT < 18) {
        break;
      }
      localActionBar = this.mActivity.getActionBar();
    } while (localActionBar == null);
    localActionBar.setHomeAsUpIndicator(paramDrawable);
    localActionBar.setHomeActionContentDescription(paramInt);
    return;
    if (this.mSetIndicatorInfo == null) {
      this.mSetIndicatorInfo = new ActionBarDrawerToggle.SetIndicatorInfo(this.mActivity);
    }
    if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator != null) {
      try
      {
        localActionBar = this.mActivity.getActionBar();
        this.mSetIndicatorInfo.mSetHomeAsUpIndicator.invoke(localActionBar, new Object[] { paramDrawable });
        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(localActionBar, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramDrawable)
      {
        Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator via JB-MR2 API", paramDrawable);
        return;
      }
    }
    if (this.mSetIndicatorInfo.mUpIndicatorView != null)
    {
      this.mSetIndicatorInfo.mUpIndicatorView.setImageDrawable(paramDrawable);
      return;
    }
    Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator");
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return this.mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mHasCustomUpIndicator) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    }
    this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    this.mSlider.setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    this.mSlider.setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    float f = this.mSlider.getPosition();
    if (paramFloat > 0.5F) {}
    for (paramFloat = Math.max(f, Math.max(0.0F, paramFloat - 0.5F) * 2.0F);; paramFloat = Math.min(f, paramFloat * 2.0F))
    {
      this.mSlider.setPosition(paramFloat);
      return;
    }
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.mDrawerIndicatorEnabled))
    {
      if (this.mDrawerLayout.isDrawerVisible(8388611)) {
        this.mDrawerLayout.closeDrawer(8388611);
      }
      for (;;)
      {
        return true;
        this.mDrawerLayout.openDrawer(8388611);
      }
    }
    return false;
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (!paramBoolean) {
        break label55;
      }
      ActionBarDrawerToggle.SlideDrawable localSlideDrawable = this.mSlider;
      if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
        break label47;
      }
      i = this.mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localSlideDrawable, i);
    }
    for (;;)
    {
      this.mDrawerIndicatorEnabled = paramBoolean;
      return;
      label47:
      i = this.mOpenDrawerContentDescRes;
      break;
      label55:
      setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(this.mActivity, paramInt);
    }
    setHomeAsUpIndicator(localDrawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    }
    for (this.mHasCustomUpIndicator = false;; this.mHasCustomUpIndicator = true)
    {
      if (!this.mDrawerIndicatorEnabled) {
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
      }
      return;
      this.mHomeAsUpIndicator = paramDrawable;
    }
  }
  
  public void syncState()
  {
    ActionBarDrawerToggle.SlideDrawable localSlideDrawable;
    if (this.mDrawerLayout.isDrawerOpen(8388611))
    {
      this.mSlider.setPosition(1.0F);
      if (this.mDrawerIndicatorEnabled)
      {
        localSlideDrawable = this.mSlider;
        if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
          break label69;
        }
      }
    }
    label69:
    for (int i = this.mCloseDrawerContentDescRes;; i = this.mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localSlideDrawable, i);
      return;
      this.mSlider.setPosition(0.0F);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle
 * JD-Core Version:    0.7.0.1
 */