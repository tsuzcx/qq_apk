package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private final Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private boolean mDrawerSlideAnimationEnabled = true;
  private boolean mHasCustomUpIndicator;
  private Drawable mHomeAsUpIndicator;
  private final int mOpenDrawerContentDescRes;
  private DrawerArrowDrawable mSlider;
  View.OnClickListener mToolbarNavigationClickListener;
  private boolean mWarnedForDisplayHomeAsUp = false;
  
  ActionBarDrawerToggle(Activity paramActivity, Toolbar paramToolbar, DrawerLayout paramDrawerLayout, DrawerArrowDrawable paramDrawerArrowDrawable, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    if (paramToolbar != null)
    {
      this.mActivityImpl = new ToolbarCompatDelegate(paramToolbar);
      paramToolbar.setNavigationOnClickListener(new ActionBarDrawerToggle.1(this));
      this.mDrawerLayout = paramDrawerLayout;
      this.mOpenDrawerContentDescRes = paramInt1;
      this.mCloseDrawerContentDescRes = paramInt2;
      if (paramDrawerArrowDrawable != null) {
        break label136;
      }
    }
    label136:
    for (this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());; this.mSlider = paramDrawerArrowDrawable)
    {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      return;
      if ((paramActivity instanceof DelegateProvider))
      {
        this.mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
        break;
      }
      this.mActivityImpl = new FrameworkActionBarDelegate(paramActivity);
      break;
    }
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    this(paramActivity, null, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, Toolbar paramToolbar, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    this(paramActivity, paramToolbar, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  private void setPosition(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.mSlider.setVerticalMirror(true);
    }
    for (;;)
    {
      this.mSlider.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        this.mSlider.setVerticalMirror(false);
      }
    }
  }
  
  @NonNull
  public DrawerArrowDrawable getDrawerArrowDrawable()
  {
    return this.mSlider;
  }
  
  Drawable getThemeUpIndicator()
  {
    return this.mActivityImpl.getThemeUpIndicator();
  }
  
  public View.OnClickListener getToolbarNavigationClickListener()
  {
    return this.mToolbarNavigationClickListener;
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return this.mDrawerIndicatorEnabled;
  }
  
  public boolean isDrawerSlideAnimationEnabled()
  {
    return this.mDrawerSlideAnimationEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mHasCustomUpIndicator) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    }
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    if (this.mDrawerSlideAnimationEnabled)
    {
      setPosition(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    setPosition(0.0F);
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.mDrawerIndicatorEnabled))
    {
      toggle();
      return true;
    }
    return false;
  }
  
  void setActionBarDescription(int paramInt)
  {
    this.mActivityImpl.setActionBarDescription(paramInt);
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if ((!this.mWarnedForDisplayHomeAsUp) && (!this.mActivityImpl.isNavigationVisible()))
    {
      Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
      this.mWarnedForDisplayHomeAsUp = true;
    }
    this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
  }
  
  public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable paramDrawerArrowDrawable)
  {
    this.mSlider = paramDrawerArrowDrawable;
    syncState();
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (!paramBoolean) {
        break label54;
      }
      DrawerArrowDrawable localDrawerArrowDrawable = this.mSlider;
      if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
        break label46;
      }
      i = this.mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localDrawerArrowDrawable, i);
    }
    for (;;)
    {
      this.mDrawerIndicatorEnabled = paramBoolean;
      return;
      label46:
      i = this.mOpenDrawerContentDescRes;
      break;
      label54:
      setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }
  }
  
  public void setDrawerSlideAnimationEnabled(boolean paramBoolean)
  {
    this.mDrawerSlideAnimationEnabled = paramBoolean;
    if (!paramBoolean) {
      setPosition(0.0F);
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = this.mDrawerLayout.getResources().getDrawable(paramInt);
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
  
  public void setToolbarNavigationClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mToolbarNavigationClickListener = paramOnClickListener;
  }
  
  public void syncState()
  {
    DrawerArrowDrawable localDrawerArrowDrawable;
    if (this.mDrawerLayout.isDrawerOpen(8388611))
    {
      setPosition(1.0F);
      if (this.mDrawerIndicatorEnabled)
      {
        localDrawerArrowDrawable = this.mSlider;
        if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
          break label61;
        }
      }
    }
    label61:
    for (int i = this.mCloseDrawerContentDescRes;; i = this.mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localDrawerArrowDrawable, i);
      return;
      setPosition(0.0F);
      break;
    }
  }
  
  void toggle()
  {
    int i = this.mDrawerLayout.getDrawerLockMode(8388611);
    if ((this.mDrawerLayout.isDrawerVisible(8388611)) && (i != 2)) {
      this.mDrawerLayout.closeDrawer(8388611);
    }
    while (i == 1) {
      return;
    }
    this.mDrawerLayout.openDrawer(8388611);
  }
  
  public static abstract interface Delegate
  {
    public abstract Context getActionBarThemedContext();
    
    public abstract Drawable getThemeUpIndicator();
    
    public abstract boolean isNavigationVisible();
    
    public abstract void setActionBarDescription(@StringRes int paramInt);
    
    public abstract void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt);
  }
  
  public static abstract interface DelegateProvider
  {
    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  static class FrameworkActionBarDelegate
    implements ActionBarDrawerToggle.Delegate
  {
    private final Activity mActivity;
    private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;
    
    FrameworkActionBarDelegate(Activity paramActivity)
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
      if (Build.VERSION.SDK_INT >= 18)
      {
        TypedArray localTypedArray = getActionBarThemedContext().obtainStyledAttributes(null, new int[] { 16843531 }, 16843470, 0);
        Drawable localDrawable = localTypedArray.getDrawable(0);
        localTypedArray.recycle();
        return localDrawable;
      }
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = this.mActivity.getActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int paramInt)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        ActionBar localActionBar = this.mActivity.getActionBar();
        if (localActionBar != null) {
          localActionBar.setHomeActionContentDescription(paramInt);
        }
        return;
      }
      this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = this.mActivity.getActionBar();
      if (localActionBar != null)
      {
        if (Build.VERSION.SDK_INT >= 18)
        {
          localActionBar.setHomeAsUpIndicator(paramDrawable);
          localActionBar.setHomeActionContentDescription(paramInt);
        }
      }
      else {
        return;
      }
      localActionBar.setDisplayShowHomeEnabled(true);
      this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mActivity, paramDrawable, paramInt);
      localActionBar.setDisplayShowHomeEnabled(false);
    }
  }
  
  static class ToolbarCompatDelegate
    implements ActionBarDrawerToggle.Delegate
  {
    final CharSequence mDefaultContentDescription;
    final Drawable mDefaultUpIndicator;
    final Toolbar mToolbar;
    
    ToolbarCompatDelegate(Toolbar paramToolbar)
    {
      this.mToolbar = paramToolbar;
      this.mDefaultUpIndicator = paramToolbar.getNavigationIcon();
      this.mDefaultContentDescription = paramToolbar.getNavigationContentDescription();
    }
    
    public Context getActionBarThemedContext()
    {
      return this.mToolbar.getContext();
    }
    
    public Drawable getThemeUpIndicator()
    {
      return this.mDefaultUpIndicator;
    }
    
    public boolean isNavigationVisible()
    {
      return true;
    }
    
    public void setActionBarDescription(@StringRes int paramInt)
    {
      if (paramInt == 0)
      {
        this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
        return;
      }
      this.mToolbar.setNavigationContentDescription(paramInt);
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt)
    {
      this.mToolbar.setNavigationIcon(paramDrawable);
      setActionBarDescription(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.ActionBarDrawerToggle
 * JD-Core Version:    0.7.0.1
 */