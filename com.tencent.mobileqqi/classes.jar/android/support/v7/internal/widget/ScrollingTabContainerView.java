package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.internal.view.ActionBarPolicy;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterViewICS.OnItemClickListener
{
  private static final String TAG = "ScrollingTabContainerView";
  private boolean mAllowCollapse;
  private int mContentHeight;
  private final LayoutInflater mInflater;
  int mMaxTabWidth;
  private int mSelectedTabIndex;
  int mStackedTabMaxWidth;
  private ScrollingTabContainerView.TabClickListener mTabClickListener;
  private LinearLayout mTabLayout;
  Runnable mTabSelector;
  private SpinnerICS mTabSpinner;
  
  public ScrollingTabContainerView(Context paramContext)
  {
    super(paramContext);
    this.mInflater = LayoutInflater.from(paramContext);
    setHorizontalScrollBarEnabled(false);
    paramContext = ActionBarPolicy.get(paramContext);
    setContentHeight(paramContext.getTabContainerHeight());
    this.mStackedTabMaxWidth = paramContext.getStackedTabMaxWidth();
    this.mTabLayout = ((LinearLayout)this.mInflater.inflate(2130903045, this, false));
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private SpinnerICS createSpinner()
  {
    SpinnerICS localSpinnerICS = new SpinnerICS(getContext(), null, 2130772039);
    localSpinnerICS.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    localSpinnerICS.setOnItemClickListenerInt(this);
    return localSpinnerICS;
  }
  
  private ScrollingTabContainerView.TabView createTabView(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    ScrollingTabContainerView.TabView localTabView = (ScrollingTabContainerView.TabView)this.mInflater.inflate(2130903044, this.mTabLayout, false);
    localTabView.attach(this, paramTab, paramBoolean);
    if (paramBoolean)
    {
      localTabView.setBackgroundDrawable(null);
      localTabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
      return localTabView;
    }
    localTabView.setFocusable(true);
    if (this.mTabClickListener == null) {
      this.mTabClickListener = new ScrollingTabContainerView.TabClickListener(this, null);
    }
    localTabView.setOnClickListener(this.mTabClickListener);
    return localTabView;
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
      this.mTabSpinner.setAdapter(new ScrollingTabContainerView.TabAdapter(this, null));
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
    this.mTabLayout.addView(paramTab, paramInt, new LinearLayout.LayoutParams(0, -1, 1.0F));
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
    this.mTabLayout.addView(paramTab, new LinearLayout.LayoutParams(0, -1, 1.0F));
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
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mTabSelector != null) {
      post(this.mTabSelector);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
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
  
  public void onItemClick(AdapterViewICS paramAdapterViewICS, View paramView, int paramInt, long paramLong)
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
        break label192;
      }
      if (j <= 2) {
        break label179;
      }
      this.mMaxTabWidth = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label70:
      this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
      label85:
      i = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
      if ((bool) || (!this.mAllowCollapse)) {
        break label200;
      }
      label107:
      if (paramInt2 == 0) {
        break label213;
      }
      this.mTabLayout.measure(0, i);
      if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label205;
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
      label179:
      this.mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label70;
      label192:
      this.mMaxTabWidth = -1;
      break label85;
      label200:
      paramInt2 = 0;
      break label107;
      label205:
      performExpand();
      continue;
      label213:
      performExpand();
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView
 * JD-Core Version:    0.7.0.1
 */