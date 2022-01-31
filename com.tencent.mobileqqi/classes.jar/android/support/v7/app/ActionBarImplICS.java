package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplICS
  extends ActionBar
{
  final android.app.ActionBar mActionBar;
  FragmentTransaction mActiveTransaction;
  final Activity mActivity;
  private ArrayList mAddedMenuVisWrappers = new ArrayList();
  final ActionBar.Callback mCallback;
  
  public ActionBarImplICS(Activity paramActivity, ActionBar.Callback paramCallback)
  {
    this(paramActivity, paramCallback, true);
  }
  
  ActionBarImplICS(Activity paramActivity, ActionBar.Callback paramCallback, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    this.mCallback = paramCallback;
    this.mActionBar = paramActivity.getActionBar();
    if ((paramBoolean) && ((getDisplayOptions() & 0x4) != 0)) {
      setHomeButtonEnabled(true);
    }
  }
  
  private ActionBarImplICS.OnMenuVisibilityListenerWrapper findAndRemoveMenuVisWrapper(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    int i = 0;
    if (i < this.mAddedMenuVisWrappers.size())
    {
      ActionBarImplICS.OnMenuVisibilityListenerWrapper localOnMenuVisibilityListenerWrapper = (ActionBarImplICS.OnMenuVisibilityListenerWrapper)((WeakReference)this.mAddedMenuVisWrappers.get(i)).get();
      int j;
      if (localOnMenuVisibilityListenerWrapper == null)
      {
        this.mAddedMenuVisWrappers.remove(i);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (localOnMenuVisibilityListenerWrapper.mWrappedListener != paramOnMenuVisibilityListener);
      this.mAddedMenuVisWrappers.remove(i);
      return localOnMenuVisibilityListenerWrapper;
    }
    return null;
  }
  
  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    if (paramOnMenuVisibilityListener != null)
    {
      paramOnMenuVisibilityListener = new ActionBarImplICS.OnMenuVisibilityListenerWrapper(paramOnMenuVisibilityListener);
      this.mAddedMenuVisWrappers.add(new WeakReference(paramOnMenuVisibilityListener));
      this.mActionBar.addOnMenuVisibilityListener(paramOnMenuVisibilityListener);
    }
  }
  
  public void addTab(ActionBar.Tab paramTab)
  {
    this.mActionBar.addTab(((ActionBarImplICS.TabWrapper)paramTab).mWrappedTab);
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt)
  {
    this.mActionBar.addTab(((ActionBarImplICS.TabWrapper)paramTab).mWrappedTab, paramInt);
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    this.mActionBar.addTab(((ActionBarImplICS.TabWrapper)paramTab).mWrappedTab, paramInt, paramBoolean);
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    this.mActionBar.addTab(((ActionBarImplICS.TabWrapper)paramTab).mWrappedTab, paramBoolean);
  }
  
  void commitActiveTransaction()
  {
    if ((this.mActiveTransaction != null) && (!this.mActiveTransaction.isEmpty())) {
      this.mActiveTransaction.commit();
    }
    this.mActiveTransaction = null;
  }
  
  FragmentTransaction getActiveTransaction()
  {
    if (this.mActiveTransaction == null) {
      this.mActiveTransaction = this.mCallback.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
    }
    return this.mActiveTransaction;
  }
  
  public View getCustomView()
  {
    return this.mActionBar.getCustomView();
  }
  
  public int getDisplayOptions()
  {
    return this.mActionBar.getDisplayOptions();
  }
  
  public int getHeight()
  {
    return this.mActionBar.getHeight();
  }
  
  public int getNavigationItemCount()
  {
    return this.mActionBar.getNavigationItemCount();
  }
  
  public int getNavigationMode()
  {
    return this.mActionBar.getNavigationMode();
  }
  
  public int getSelectedNavigationIndex()
  {
    return this.mActionBar.getSelectedNavigationIndex();
  }
  
  public ActionBar.Tab getSelectedTab()
  {
    return (ActionBar.Tab)this.mActionBar.getSelectedTab().getTag();
  }
  
  public CharSequence getSubtitle()
  {
    return this.mActionBar.getSubtitle();
  }
  
  public ActionBar.Tab getTabAt(int paramInt)
  {
    return (ActionBar.Tab)this.mActionBar.getTabAt(paramInt).getTag();
  }
  
  public int getTabCount()
  {
    return this.mActionBar.getTabCount();
  }
  
  public Context getThemedContext()
  {
    return this.mActionBar.getThemedContext();
  }
  
  public CharSequence getTitle()
  {
    return this.mActionBar.getTitle();
  }
  
  public void hide()
  {
    this.mActionBar.hide();
  }
  
  public boolean isShowing()
  {
    return this.mActionBar.isShowing();
  }
  
  public ActionBar.Tab newTab()
  {
    android.app.ActionBar.Tab localTab = this.mActionBar.newTab();
    ActionBarImplICS.TabWrapper localTabWrapper = new ActionBarImplICS.TabWrapper(this, localTab);
    localTab.setTag(localTabWrapper);
    return localTabWrapper;
  }
  
  public void removeAllTabs()
  {
    this.mActionBar.removeAllTabs();
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    paramOnMenuVisibilityListener = findAndRemoveMenuVisWrapper(paramOnMenuVisibilityListener);
    this.mActionBar.removeOnMenuVisibilityListener(paramOnMenuVisibilityListener);
  }
  
  public void removeTab(ActionBar.Tab paramTab)
  {
    this.mActionBar.removeTab(((ActionBarImplICS.TabWrapper)paramTab).mWrappedTab);
  }
  
  public void removeTabAt(int paramInt)
  {
    this.mActionBar.removeTabAt(paramInt);
  }
  
  public void selectTab(ActionBar.Tab paramTab)
  {
    this.mActionBar.selectTab(((ActionBarImplICS.TabWrapper)paramTab).mWrappedTab);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mActionBar.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCustomView(int paramInt)
  {
    this.mActionBar.setCustomView(paramInt);
  }
  
  public void setCustomView(View paramView)
  {
    this.mActionBar.setCustomView(paramView);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    android.app.ActionBar.LayoutParams localLayoutParams = new android.app.ActionBar.LayoutParams(paramLayoutParams);
    localLayoutParams.gravity = paramLayoutParams.gravity;
    this.mActionBar.setCustomView(paramView, localLayoutParams);
  }
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayHomeAsUpEnabled(paramBoolean);
  }
  
  public void setDisplayOptions(int paramInt)
  {
    this.mActionBar.setDisplayOptions(paramInt);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    this.mActionBar.setDisplayOptions(paramInt1, paramInt2);
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayShowCustomEnabled(paramBoolean);
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayShowHomeEnabled(paramBoolean);
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayShowTitleEnabled(paramBoolean);
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayUseLogoEnabled(paramBoolean);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    this.mActionBar.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setIcon(int paramInt)
  {
    this.mActionBar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mActionBar.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    android.app.ActionBar localActionBar = this.mActionBar;
    if (paramOnNavigationListener != null) {}
    for (paramOnNavigationListener = new ActionBarImplICS.OnNavigationListenerWrapper(paramOnNavigationListener);; paramOnNavigationListener = null)
    {
      localActionBar.setListNavigationCallbacks(paramSpinnerAdapter, paramOnNavigationListener);
      return;
    }
  }
  
  public void setLogo(int paramInt)
  {
    this.mActionBar.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.mActionBar.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt)
  {
    this.mActionBar.setNavigationMode(paramInt);
  }
  
  public void setSelectedNavigationItem(int paramInt)
  {
    this.mActionBar.setSelectedNavigationItem(paramInt);
  }
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable)
  {
    this.mActionBar.setSplitBackgroundDrawable(paramDrawable);
  }
  
  public void setSubtitle(int paramInt)
  {
    this.mActionBar.setSubtitle(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mActionBar.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    this.mActionBar.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mActionBar.setTitle(paramCharSequence);
  }
  
  public void show()
  {
    this.mActionBar.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarImplICS
 * JD-Core Version:    0.7.0.1
 */