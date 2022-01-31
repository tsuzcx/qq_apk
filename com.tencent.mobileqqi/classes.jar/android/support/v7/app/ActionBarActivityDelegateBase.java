package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ProgressBarICS;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mobileqqi.R.styleable;

class ActionBarActivityDelegateBase
  extends ActionBarActivityDelegate
  implements MenuBuilder.Callback, MenuPresenter.Callback
{
  private static final int[] ACTION_BAR_DRAWABLE_TOGGLE_ATTRS = { 2130771987 };
  private static final String TAG = "ActionBarActivityDelegateBase";
  private ActionBarView mActionBarView;
  private ActionMode mActionMode;
  private boolean mClosingActionMenu;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private ListMenuPresenter mListMenuPresenter;
  private MenuBuilder mMenu;
  private Bundle mPanelFrozenActionViewState;
  private boolean mPanelIsPrepared;
  private boolean mPanelRefreshContent;
  private boolean mSubDecorInstalled;
  private CharSequence mTitleToSet;
  
  ActionBarActivityDelegateBase(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  private void applyFixedSizeWindow()
  {
    Object localObject2 = null;
    DisplayMetrics localDisplayMetrics = null;
    TypedArray localTypedArray = this.mActivity.obtainStyledAttributes(R.styleable.e);
    TypedValue localTypedValue1;
    if (localTypedArray.hasValue(3)) {
      if (0 == 0)
      {
        localTypedValue1 = new TypedValue();
        localTypedArray.getValue(3, localTypedValue1);
      }
    }
    for (;;)
    {
      TypedValue localTypedValue2;
      if (localTypedArray.hasValue(5)) {
        if (0 == 0)
        {
          localTypedValue2 = new TypedValue();
          localTypedArray.getValue(5, localTypedValue2);
        }
      }
      for (;;)
      {
        Object localObject1;
        if (localTypedArray.hasValue(6)) {
          if (0 == 0)
          {
            localObject1 = new TypedValue();
            localTypedArray.getValue(6, (TypedValue)localObject1);
          }
        }
        for (;;)
        {
          if (localTypedArray.hasValue(4))
          {
            localObject2 = localDisplayMetrics;
            if (0 == 0) {
              localObject2 = new TypedValue();
            }
            localTypedArray.getValue(4, (TypedValue)localObject2);
          }
          localDisplayMetrics = this.mActivity.getResources().getDisplayMetrics();
          int j;
          label177:
          int i;
          if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
          {
            j = 1;
            if (j == 0) {
              break label276;
            }
            if ((localTypedValue2 == null) || (localTypedValue2.type == 0)) {
              break label358;
            }
            if (localTypedValue2.type != 5) {
              break label282;
            }
            i = (int)localTypedValue2.getDimension(localDisplayMetrics);
          }
          for (;;)
          {
            label208:
            if (j != 0)
            {
              label212:
              if ((localObject1 == null) || (((TypedValue)localObject1).type == 0)) {
                break label353;
              }
              if (((TypedValue)localObject1).type != 5) {
                break label321;
              }
              j = (int)((TypedValue)localObject1).getDimension(localDisplayMetrics);
            }
            for (;;)
            {
              if ((i != -1) || (j != -1)) {
                this.mActivity.getWindow().setLayout(i, j);
              }
              localTypedArray.recycle();
              return;
              j = 0;
              break;
              label276:
              localTypedValue2 = localTypedValue1;
              break label177;
              label282:
              if (localTypedValue2.type != 6) {
                break label358;
              }
              i = (int)localTypedValue2.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label208;
              localObject1 = localObject2;
              break label212;
              label321:
              if (((TypedValue)localObject1).type == 6) {
                j = (int)((TypedValue)localObject1).getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              } else {
                label353:
                j = -1;
              }
            }
            label358:
            i = -1;
          }
          localObject1 = null;
          break;
          localObject1 = null;
        }
        localTypedValue2 = null;
        break;
        localTypedValue2 = null;
      }
      localTypedValue1 = null;
      break;
      localTypedValue1 = null;
    }
  }
  
  private ProgressBarICS getCircularProgressBar()
  {
    ProgressBarICS localProgressBarICS = (ProgressBarICS)this.mActionBarView.findViewById(2131230744);
    if (localProgressBarICS != null) {
      localProgressBarICS.setVisibility(4);
    }
    return localProgressBarICS;
  }
  
  private ProgressBarICS getHorizontalProgressBar()
  {
    ProgressBarICS localProgressBarICS = (ProgressBarICS)this.mActionBarView.findViewById(2131230745);
    if (localProgressBarICS != null) {
      localProgressBarICS.setVisibility(4);
    }
    return localProgressBarICS;
  }
  
  private MenuView getListMenuView(Context paramContext, MenuPresenter.Callback paramCallback)
  {
    if (this.mMenu == null) {
      return null;
    }
    if (this.mListMenuPresenter == null)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(R.styleable.ae);
      int i = localTypedArray.getResourceId(4, 2131624062);
      localTypedArray.recycle();
      this.mListMenuPresenter = new ListMenuPresenter(2130903057, i);
      this.mListMenuPresenter.setCallback(paramCallback);
      this.mMenu.addMenuPresenter(this.mListMenuPresenter);
    }
    for (;;)
    {
      return this.mListMenuPresenter.getMenuView(new FrameLayout(paramContext));
      this.mListMenuPresenter.updateMenuView(false);
    }
  }
  
  private void hideProgressBars(ProgressBarICS paramProgressBarICS1, ProgressBarICS paramProgressBarICS2)
  {
    if ((this.mFeatureIndeterminateProgress) && (paramProgressBarICS2.getVisibility() == 0)) {
      paramProgressBarICS2.setVisibility(4);
    }
    if ((this.mFeatureProgress) && (paramProgressBarICS1.getVisibility() == 0)) {
      paramProgressBarICS1.setVisibility(4);
    }
  }
  
  private boolean initializePanelMenu()
  {
    this.mMenu = new MenuBuilder(getActionBarThemedContext());
    this.mMenu.setCallback(this);
    return true;
  }
  
  private boolean preparePanel()
  {
    if (this.mPanelIsPrepared) {
      return true;
    }
    if ((this.mMenu == null) || (this.mPanelRefreshContent))
    {
      if ((this.mMenu == null) && ((!initializePanelMenu()) || (this.mMenu == null))) {
        return false;
      }
      if (this.mActionBarView != null) {
        this.mActionBarView.setMenu(this.mMenu, this);
      }
      this.mMenu.stopDispatchingItemsChanged();
      if (!this.mActivity.superOnCreatePanelMenu(0, this.mMenu))
      {
        this.mMenu = null;
        if (this.mActionBarView != null) {
          this.mActionBarView.setMenu(null, this);
        }
        return false;
      }
      this.mPanelRefreshContent = false;
    }
    this.mMenu.stopDispatchingItemsChanged();
    if (this.mPanelFrozenActionViewState != null)
    {
      this.mMenu.restoreActionViewStates(this.mPanelFrozenActionViewState);
      this.mPanelFrozenActionViewState = null;
    }
    if (!this.mActivity.superOnPreparePanel(0, null, this.mMenu))
    {
      if (this.mActionBarView != null) {
        this.mActionBarView.setMenu(null, this);
      }
      this.mMenu.startDispatchingItemsChanged();
      return false;
    }
    this.mMenu.startDispatchingItemsChanged();
    this.mPanelIsPrepared = true;
    return true;
  }
  
  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((this.mActionBarView != null) && (this.mActionBarView.isOverflowReserved()))
    {
      if ((!this.mActionBarView.isOverflowMenuShowing()) || (!paramBoolean))
      {
        if (this.mActionBarView.getVisibility() == 0) {
          this.mActionBarView.showOverflowMenu();
        }
        return;
      }
      this.mActionBarView.hideOverflowMenu();
      return;
    }
    paramMenuBuilder.close();
  }
  
  private void showProgressBars(ProgressBarICS paramProgressBarICS1, ProgressBarICS paramProgressBarICS2)
  {
    if ((this.mFeatureIndeterminateProgress) && (paramProgressBarICS2.getVisibility() == 4)) {
      paramProgressBarICS2.setVisibility(0);
    }
    if ((this.mFeatureProgress) && (paramProgressBarICS1.getProgress() < 10000)) {
      paramProgressBarICS1.setVisibility(0);
    }
  }
  
  private void updateProgressBars(int paramInt)
  {
    ProgressBarICS localProgressBarICS1 = getCircularProgressBar();
    ProgressBarICS localProgressBarICS2 = getHorizontalProgressBar();
    if (paramInt == -1) {
      if (this.mFeatureProgress)
      {
        paramInt = localProgressBarICS2.getProgress();
        if ((localProgressBarICS2.isIndeterminate()) || (paramInt < 10000))
        {
          paramInt = 0;
          localProgressBarICS2.setVisibility(paramInt);
        }
      }
      else if (this.mFeatureIndeterminateProgress)
      {
        localProgressBarICS1.setVisibility(0);
      }
    }
    label99:
    do
    {
      do
      {
        return;
        paramInt = 4;
        break;
        if (paramInt != -2) {
          break label99;
        }
        if (this.mFeatureProgress) {
          localProgressBarICS2.setVisibility(8);
        }
      } while (!this.mFeatureIndeterminateProgress);
      localProgressBarICS1.setVisibility(8);
      return;
      if (paramInt == -3)
      {
        localProgressBarICS2.setIndeterminate(true);
        return;
      }
      if (paramInt == -4)
      {
        localProgressBarICS2.setIndeterminate(false);
        return;
      }
    } while ((paramInt < 0) || (paramInt > 10000));
    localProgressBarICS2.setProgress(paramInt + 0);
    if (paramInt < 10000)
    {
      showProgressBars(localProgressBarICS2, localProgressBarICS1);
      return;
    }
    hideProgressBars(localProgressBarICS2, localProgressBarICS1);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)this.mActivity.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.mActivity.onSupportContentChanged();
  }
  
  public ActionBar createSupportActionBar()
  {
    ensureSubDecor();
    return new ActionBarImplBase(this.mActivity, this.mActivity);
  }
  
  final void ensureSubDecor()
  {
    boolean bool1;
    label116:
    Object localObject;
    if (!this.mSubDecorInstalled)
    {
      if (!this.mHasActionBar) {
        break label314;
      }
      if (!this.mOverlayActionBar) {
        break label276;
      }
      this.mActivity.superSetContentView(2130903042);
      this.mActionBarView = ((ActionBarView)this.mActivity.findViewById(2131230927));
      this.mActionBarView.setWindowCallback(this.mActivity);
      if (this.mFeatureProgress) {
        this.mActionBarView.initProgress();
      }
      if (this.mFeatureIndeterminateProgress) {
        this.mActionBarView.initIndeterminateProgress();
      }
      boolean bool2 = "splitActionBarWhenNarrow".equals(getUiOptionsFromMetadata());
      if (!bool2) {
        break label289;
      }
      bool1 = this.mActivity.getResources().getBoolean(2131296258);
      localObject = (ActionBarContainer)this.mActivity.findViewById(2131230929);
      if (localObject != null)
      {
        this.mActionBarView.setSplitView((ActionBarContainer)localObject);
        this.mActionBarView.setSplitActionBar(bool1);
        this.mActionBarView.setSplitWhenNarrow(bool2);
        ActionBarContextView localActionBarContextView = (ActionBarContextView)this.mActivity.findViewById(2131230928);
        localActionBarContextView.setSplitView((ActionBarContainer)localObject);
        localActionBarContextView.setSplitActionBar(bool1);
        localActionBarContextView.setSplitWhenNarrow(bool2);
      }
    }
    for (;;)
    {
      this.mActivity.findViewById(16908290).setId(-1);
      this.mActivity.findViewById(2131230741).setId(16908290);
      if (this.mTitleToSet != null)
      {
        this.mActionBarView.setWindowTitle(this.mTitleToSet);
        this.mTitleToSet = null;
      }
      applyFixedSizeWindow();
      this.mSubDecorInstalled = true;
      this.mActivity.getWindow().getDecorView().post(new ActionBarActivityDelegateBase.1(this));
      return;
      label276:
      this.mActivity.superSetContentView(2130903040);
      break;
      label289:
      localObject = this.mActivity.obtainStyledAttributes(R.styleable.e);
      bool1 = ((TypedArray)localObject).getBoolean(2, false);
      ((TypedArray)localObject).recycle();
      break label116;
      label314:
      this.mActivity.superSetContentView(2130903062);
    }
  }
  
  ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarActivityDelegateBase.ActionBarDrawableToggleImpl(this, null);
  }
  
  public boolean onBackPressed()
  {
    if (this.mActionMode != null)
    {
      this.mActionMode.finish();
      return true;
    }
    if ((this.mActionBarView != null) && (this.mActionBarView.hasExpandedActionView()))
    {
      this.mActionBarView.collapseActionView();
      return true;
    }
    return false;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.mClosingActionMenu) {
      return;
    }
    this.mClosingActionMenu = true;
    this.mActivity.closeOptionsMenu();
    this.mActionBarView.dismissPopupMenus();
    this.mClosingActionMenu = false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mHasActionBar) && (this.mSubDecorInstalled)) {
      ((ActionBarImplBase)getSupportActionBar()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onContentChanged() {}
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt != 0) {
      return this.mActivity.superOnCreatePanelMenu(paramInt, paramMenu);
    }
    return false;
  }
  
  public View onCreatePanelView(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == 0)
    {
      localObject1 = localObject2;
      if (preparePanel()) {
        localObject1 = (View)getListMenuView(this.mActivity, this);
      }
    }
    return localObject1;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    MenuItem localMenuItem = paramMenuItem;
    if (paramInt == 0) {
      localMenuItem = MenuWrapperFactory.createMenuItemWrapper(paramMenuItem);
    }
    return this.mActivity.superOnMenuItemSelected(paramInt, localMenuItem);
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return this.mActivity.onMenuItemSelected(0, paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(paramMenuBuilder, true);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    return false;
  }
  
  public void onPostResume()
  {
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      localActionBarImplBase.setShowHideAnimationEnabled(true);
    }
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt != 0) {
      return this.mActivity.superOnPreparePanel(paramInt, paramView, paramMenu);
    }
    return false;
  }
  
  public void onStop()
  {
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      localActionBarImplBase.setShowHideAnimationEnabled(false);
    }
  }
  
  public void onTitleChanged(CharSequence paramCharSequence)
  {
    if (this.mActionBarView != null)
    {
      this.mActionBarView.setWindowTitle(paramCharSequence);
      return;
    }
    this.mTitleToSet = paramCharSequence;
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    this.mActivity.getLayoutInflater().inflate(paramInt, localViewGroup);
    this.mActivity.onSupportContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.mActivity.onSupportContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.mActivity.onSupportContentChanged();
  }
  
  void setSupportProgress(int paramInt)
  {
    updateProgressBars(paramInt + 0);
  }
  
  void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -3;; i = -4)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = -2)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = -2)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    paramCallback = new ActionBarActivityDelegateBase.ActionModeCallbackWrapper(this, paramCallback);
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      this.mActionMode = localActionBarImplBase.startActionMode(paramCallback);
    }
    if (this.mActionMode != null) {
      this.mActivity.onSupportActionModeStarted(this.mActionMode);
    }
    return this.mActionMode;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (this.mMenu != null)
    {
      Bundle localBundle = new Bundle();
      this.mMenu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        this.mPanelFrozenActionViewState = localBundle;
      }
      this.mMenu.stopDispatchingItemsChanged();
      this.mMenu.clear();
    }
    this.mPanelRefreshContent = true;
    if (this.mActionBarView != null)
    {
      this.mPanelIsPrepared = false;
      preparePanel();
    }
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    default: 
      return this.mActivity.requestWindowFeature(paramInt);
    case 8: 
      this.mHasActionBar = true;
      return true;
    case 9: 
      this.mOverlayActionBar = true;
      return true;
    case 2: 
      this.mFeatureProgress = true;
      return true;
    }
    this.mFeatureIndeterminateProgress = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase
 * JD-Core Version:    0.7.0.1
 */