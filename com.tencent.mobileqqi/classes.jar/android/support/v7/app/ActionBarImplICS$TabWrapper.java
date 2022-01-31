package android.support.v7.app;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.view.View;

class ActionBarImplICS$TabWrapper
  extends ActionBar.Tab
  implements android.app.ActionBar.TabListener
{
  private CharSequence mContentDescription;
  private ActionBar.TabListener mTabListener;
  private Object mTag;
  final android.app.ActionBar.Tab mWrappedTab;
  
  public ActionBarImplICS$TabWrapper(ActionBarImplICS paramActionBarImplICS, android.app.ActionBar.Tab paramTab)
  {
    this.mWrappedTab = paramTab;
  }
  
  public CharSequence getContentDescription()
  {
    return this.mContentDescription;
  }
  
  public View getCustomView()
  {
    return this.mWrappedTab.getCustomView();
  }
  
  public Drawable getIcon()
  {
    return this.mWrappedTab.getIcon();
  }
  
  public int getPosition()
  {
    return this.mWrappedTab.getPosition();
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public CharSequence getText()
  {
    return this.mWrappedTab.getText();
  }
  
  public void onTabReselected(android.app.ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
    ActionBar.TabListener localTabListener = this.mTabListener;
    if (paramFragmentTransaction != null) {}
    for (paramTab = this.this$0.getActiveTransaction();; paramTab = null)
    {
      localTabListener.onTabReselected(this, paramTab);
      this.this$0.commitActiveTransaction();
      return;
    }
  }
  
  public void onTabSelected(android.app.ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
    ActionBar.TabListener localTabListener = this.mTabListener;
    if (paramFragmentTransaction != null) {}
    for (paramTab = this.this$0.getActiveTransaction();; paramTab = null)
    {
      localTabListener.onTabSelected(this, paramTab);
      this.this$0.commitActiveTransaction();
      return;
    }
  }
  
  public void onTabUnselected(android.app.ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
    ActionBar.TabListener localTabListener = this.mTabListener;
    if (paramFragmentTransaction != null) {}
    for (paramTab = this.this$0.getActiveTransaction();; paramTab = null)
    {
      localTabListener.onTabUnselected(this, paramTab);
      return;
    }
  }
  
  public void select()
  {
    this.mWrappedTab.select();
  }
  
  public ActionBar.Tab setContentDescription(int paramInt)
  {
    this.mContentDescription = this.this$0.mActivity.getText(paramInt);
    return this;
  }
  
  public ActionBar.Tab setContentDescription(CharSequence paramCharSequence)
  {
    this.mContentDescription = paramCharSequence;
    return this;
  }
  
  public ActionBar.Tab setCustomView(int paramInt)
  {
    this.mWrappedTab.setCustomView(paramInt);
    return this;
  }
  
  public ActionBar.Tab setCustomView(View paramView)
  {
    this.mWrappedTab.setCustomView(paramView);
    return this;
  }
  
  public ActionBar.Tab setIcon(int paramInt)
  {
    this.mWrappedTab.setIcon(paramInt);
    return this;
  }
  
  public ActionBar.Tab setIcon(Drawable paramDrawable)
  {
    this.mWrappedTab.setIcon(paramDrawable);
    return this;
  }
  
  public ActionBar.Tab setTabListener(ActionBar.TabListener paramTabListener)
  {
    this.mTabListener = paramTabListener;
    android.app.ActionBar.Tab localTab = this.mWrappedTab;
    if (paramTabListener != null) {}
    for (paramTabListener = this;; paramTabListener = null)
    {
      localTab.setTabListener(paramTabListener);
      return this;
    }
  }
  
  public ActionBar.Tab setTag(Object paramObject)
  {
    this.mTag = paramObject;
    return this;
  }
  
  public ActionBar.Tab setText(int paramInt)
  {
    this.mWrappedTab.setText(paramInt);
    return this;
  }
  
  public ActionBar.Tab setText(CharSequence paramCharSequence)
  {
    this.mWrappedTab.setText(paramCharSequence);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarImplICS.TabWrapper
 * JD-Core Version:    0.7.0.1
 */