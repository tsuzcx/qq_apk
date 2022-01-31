package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.RestrictTo;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.ActionBarPolicy;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final int FADE_DURATION = 200;
  private static final String TAG = "ScrollingTabContainerView";
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  private boolean mAllowCollapse;
  private int mContentHeight;
  int mMaxTabWidth;
  private int mSelectedTabIndex;
  int mStackedTabMaxWidth;
  private ScrollingTabContainerView.TabClickListener mTabClickListener;
  LinearLayoutCompat mTabLayout;
  Runnable mTabSelector;
  private Spinner mTabSpinner;
  protected final ScrollingTabContainerView.VisibilityAnimListener mVisAnimListener = new ScrollingTabContainerView.VisibilityAnimListener(this);
  protected ViewPropertyAnimator mVisibilityAnim;
  
  public ScrollingTabContainerView(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    paramContext = ActionBarPolicy.get(paramContext);
    setContentHeight(paramContext.getTabContainerHeight());
    this.mStackedTabMaxWidth = paramContext.getStackedTabMaxWidth();
    this.mTabLayout = createTabLayout();
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private Spinner createSpinner()
  {
    AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
    localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    localAppCompatSpinner.setOnItemSelectedListener(this);
    return localAppCompatSpinner;
  }
  
  private LinearLayoutCompat createTabLayout()
  {
    LinearLayoutCompat localLinearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
    localLinearLayoutCompat.setMeasureWithLargestChildEnabled(true);
    localLinearLayoutCompat.setGravity(17);
    localLinearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    return localLinearLayoutCompat;
  }
  
  private boolean isCollapsed()
  {
    return (this.mTabSpinner != null) && (this.mTabSpinner.getParent() == this);
  }
  
  private void performCollapse()
  {
    if (isCollapsed()) {
      return;
    }
    if (this.mTabSpinner == null) {
      this.mTabSpinner = createSpinner();
    }
    removeView(this.mTabLayout);
    addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
    if (this.mTabSpinner.getAdapter() == null) {
      this.mTabSpinner.setAdapter(new ScrollingTabContainerView.TabAdapter(this));
    }
    if (this.mTabSelector != null)
    {
      removeCallbacks(this.mTabSelector);
      this.mTabSelector = null;
    }
    this.mTabSpinner.setSelection(this.mSelectedTabIndex);
  }
  
  private boolean performExpand()
  {
    if (!isCollapsed()) {
      return false;
    }
    removeView(this.mTabSpinner);
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.mTabSpinner.getSelectedItemPosition());
    return false;
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    paramTab = createTabView(paramTab, false);
    this.mTabLayout.addView(paramTab, paramInt, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      paramTab.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    paramTab = createTabView(paramTab, false);
    this.mTabLayout.addView(paramTab, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      paramTab.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void animateToTab(int paramInt)
  {
    View localView = this.mTabLayout.getChildAt(paramInt);
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
    this.mTabSelector = new ScrollingTabContainerView.1(this, localView);
    post(this.mTabSelector);
  }
  
  public void animateToVisibility(int paramInt)
  {
    if (this.mVisibilityAnim != null) {
      this.mVisibilityAnim.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localViewPropertyAnimator = animate().alpha(1.0F);
      localViewPropertyAnimator.setDuration(200L);
      localViewPropertyAnimator.setInterpolator(sAlphaInterpolator);
      localViewPropertyAnimator.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimator, paramInt));
      localViewPropertyAnimator.start();
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = animate().alpha(0.0F);
    localViewPropertyAnimator.setDuration(200L);
    localViewPropertyAnimator.setInterpolator(sAlphaInterpolator);
    localViewPropertyAnimator.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimator, paramInt));
    localViewPropertyAnimator.start();
  }
  
  ScrollingTabContainerView.TabView createTabView(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    paramTab = new ScrollingTabContainerView.TabView(this, getContext(), paramTab, paramBoolean);
    if (paramBoolean)
    {
      paramTab.setBackgroundDrawable(null);
      paramTab.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
      return paramTab;
    }
    paramTab.setFocusable(true);
    if (this.mTabClickListener == null) {
      this.mTabClickListener = new ScrollingTabContainerView.TabClickListener(this);
    }
    paramTab.setOnClickListener(this.mTabClickListener);
    return paramTab;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mTabSelector != null) {
      post(this.mTabSelector);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = ActionBarPolicy.get(getContext());
    setContentHeight(paramConfiguration.getTabContainerHeight());
    this.mStackedTabMaxWidth = paramConfiguration.getStackedTabMaxWidth();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
  }
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((ScrollingTabContainerView.TabView)paramView).getTab().select();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int i = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (i == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int j = this.mTabLayout.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != -2147483648))) {
        break label195;
      }
      if (j <= 2) {
        break label182;
      }
      this.mMaxTabWidth = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label72:
      this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
      label87:
      i = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
      if ((bool) || (!this.mAllowCollapse)) {
        break label203;
      }
      label110:
      if (paramInt2 == 0) {
        break label216;
      }
      this.mTabLayout.measure(0, i);
      if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label208;
      }
      performCollapse();
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.mSelectedTabIndex);
      }
      return;
      bool = false;
      break;
      label182:
      this.mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label72;
      label195:
      this.mMaxTabWidth = -1;
      break label87;
      label203:
      paramInt2 = 0;
      break label110;
      label208:
      performExpand();
      continue;
      label216:
      performExpand();
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
  
  public void removeAllTabs()
  {
    this.mTabLayout.removeAllViews();
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void removeTabAt(int paramInt)
  {
    this.mTabLayout.removeViewAt(paramInt);
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.mAllowCollapse = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.mSelectedTabIndex = paramInt;
    int j = this.mTabLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.mTabLayout.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          animateToTab(paramInt);
        }
        i += 1;
        break;
      }
    }
    if ((this.mTabSpinner != null) && (paramInt >= 0)) {
      this.mTabSpinner.setSelection(paramInt);
    }
  }
  
  public void updateTab(int paramInt)
  {
    ((ScrollingTabContainerView.TabView)this.mTabLayout.getChildAt(paramInt)).update();
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ScrollingTabContainerView
 * JD-Core Version:    0.7.0.1
 */