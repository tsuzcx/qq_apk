package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.ActionBarPolicy;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

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
  private TabClickListener mTabClickListener;
  LinearLayoutCompat mTabLayout;
  Runnable mTabSelector;
  private Spinner mTabSpinner;
  protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
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
    Spinner localSpinner = this.mTabSpinner;
    return (localSpinner != null) && (localSpinner.getParent() == this);
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
      this.mTabSpinner.setAdapter(new TabAdapter());
    }
    Runnable localRunnable = this.mTabSelector;
    if (localRunnable != null)
    {
      removeCallbacks(localRunnable);
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
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
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
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
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
    final View localView = this.mTabLayout.getChildAt(paramInt);
    Runnable localRunnable = this.mTabSelector;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
    this.mTabSelector = new Runnable()
    {
      public void run()
      {
        int i = localView.getLeft();
        int j = (ScrollingTabContainerView.this.getWidth() - localView.getWidth()) / 2;
        ScrollingTabContainerView.this.smoothScrollTo(i - j, 0);
        ScrollingTabContainerView.this.mTabSelector = null;
      }
    };
    post(this.mTabSelector);
  }
  
  public void animateToVisibility(int paramInt)
  {
    ViewPropertyAnimator localViewPropertyAnimator = this.mVisibilityAnim;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
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
    localViewPropertyAnimator = animate().alpha(0.0F);
    localViewPropertyAnimator.setDuration(200L);
    localViewPropertyAnimator.setInterpolator(sAlphaInterpolator);
    localViewPropertyAnimator.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimator, paramInt));
    localViewPropertyAnimator.start();
  }
  
  TabView createTabView(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    paramTab = new TabView(getContext(), paramTab, paramBoolean);
    if (paramBoolean)
    {
      paramTab.setBackgroundDrawable(null);
      paramTab.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
      return paramTab;
    }
    paramTab.setFocusable(true);
    if (this.mTabClickListener == null) {
      this.mTabClickListener = new TabClickListener();
    }
    paramTab.setOnClickListener(this.mTabClickListener);
    return paramTab;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Runnable localRunnable = this.mTabSelector;
    if (localRunnable != null) {
      post(localRunnable);
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
    Runnable localRunnable = this.mTabSelector;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((TabView)paramView).getTab().select();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = 1;
    boolean bool;
    if (i == 1073741824) {
      bool = true;
    } else {
      bool = false;
    }
    setFillViewport(bool);
    int j = this.mTabLayout.getChildCount();
    if ((j > 1) && ((i == 1073741824) || (i == -2147483648)))
    {
      if (j > 2) {
        this.mMaxTabWidth = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      } else {
        this.mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
      }
      this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
    }
    else
    {
      this.mMaxTabWidth = -1;
    }
    i = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
    if ((bool) || (!this.mAllowCollapse)) {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      this.mTabLayout.measure(0, i);
      if (this.mTabLayout.getMeasuredWidth() > View.MeasureSpec.getSize(paramInt1)) {
        performCollapse();
      } else {
        performExpand();
      }
    }
    else
    {
      performExpand();
    }
    paramInt2 = getMeasuredWidth();
    super.onMeasure(paramInt1, i);
    paramInt1 = getMeasuredWidth();
    if ((bool) && (paramInt2 != paramInt1)) {
      setTabSelected(this.mSelectedTabIndex);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void removeAllTabs()
  {
    this.mTabLayout.removeAllViews();
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void removeTabAt(int paramInt)
  {
    this.mTabLayout.removeViewAt(paramInt);
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
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
    while (i < j)
    {
      localObject = this.mTabLayout.getChildAt(i);
      boolean bool;
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((View)localObject).setSelected(bool);
      if (bool) {
        animateToTab(paramInt);
      }
      i += 1;
    }
    Object localObject = this.mTabSpinner;
    if ((localObject != null) && (paramInt >= 0)) {
      ((Spinner)localObject).setSelection(paramInt);
    }
  }
  
  public void updateTab(int paramInt)
  {
    ((TabView)this.mTabLayout.getChildAt(paramInt)).update();
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  private class TabAdapter
    extends BaseAdapter
  {
    TabAdapter() {}
    
    public int getCount()
    {
      return ScrollingTabContainerView.this.mTabLayout.getChildCount();
    }
    
    public Object getItem(int paramInt)
    {
      return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.this.mTabLayout.getChildAt(paramInt)).getTab();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        return ScrollingTabContainerView.this.createTabView((ActionBar.Tab)getItem(paramInt), true);
      }
      ((ScrollingTabContainerView.TabView)paramView).bindTab((ActionBar.Tab)getItem(paramInt));
      return paramView;
    }
  }
  
  private class TabClickListener
    implements View.OnClickListener
  {
    TabClickListener() {}
    
    public void onClick(View paramView)
    {
      ((ScrollingTabContainerView.TabView)paramView).getTab().select();
      int j = ScrollingTabContainerView.this.mTabLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = ScrollingTabContainerView.this.mTabLayout.getChildAt(i);
        boolean bool;
        if (localView == paramView) {
          bool = true;
        } else {
          bool = false;
        }
        localView.setSelected(bool);
        i += 1;
      }
    }
  }
  
  private class TabView
    extends LinearLayout
  {
    private final int[] BG_ATTRS = { 16842964 };
    private View mCustomView;
    private ImageView mIconView;
    private ActionBar.Tab mTab;
    private TextView mTextView;
    
    public TabView(Context paramContext, ActionBar.Tab paramTab, boolean paramBoolean)
    {
      super(null, R.attr.actionBarTabStyle);
      this.mTab = paramTab;
      this$1 = TintTypedArray.obtainStyledAttributes(paramContext, null, this.BG_ATTRS, R.attr.actionBarTabStyle, 0);
      if (ScrollingTabContainerView.this.hasValue(0)) {
        setBackgroundDrawable(ScrollingTabContainerView.this.getDrawable(0));
      }
      ScrollingTabContainerView.this.recycle();
      if (paramBoolean) {
        setGravity(8388627);
      }
      update();
    }
    
    public void bindTab(ActionBar.Tab paramTab)
    {
      this.mTab = paramTab;
      update();
    }
    
    public ActionBar.Tab getTab()
    {
      return this.mTab;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((ScrollingTabContainerView.this.mMaxTabWidth > 0) && (getMeasuredWidth() > ScrollingTabContainerView.this.mMaxTabWidth)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.mMaxTabWidth, 1073741824), paramInt2);
      }
    }
    
    public void setSelected(boolean paramBoolean)
    {
      int i;
      if (isSelected() != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean)) {
        sendAccessibilityEvent(4);
      }
    }
    
    public void update()
    {
      ActionBar.Tab localTab = this.mTab;
      Object localObject2 = localTab.getCustomView();
      Object localObject1 = null;
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        this.mCustomView = ((View)localObject2);
        localObject1 = this.mTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = this.mIconView;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setVisibility(8);
          this.mIconView.setImageDrawable(null);
        }
      }
      else
      {
        localObject2 = this.mCustomView;
        if (localObject2 != null)
        {
          removeView((View)localObject2);
          this.mCustomView = null;
        }
        Object localObject3 = localTab.getIcon();
        localObject2 = localTab.getText();
        Object localObject4;
        if (localObject3 != null)
        {
          if (this.mIconView == null)
          {
            localObject4 = new AppCompatImageView(getContext());
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.gravity = 16;
            ((ImageView)localObject4).setLayoutParams(localLayoutParams);
            addView((View)localObject4, 0);
            this.mIconView = ((ImageView)localObject4);
          }
          this.mIconView.setImageDrawable((Drawable)localObject3);
          this.mIconView.setVisibility(0);
        }
        else
        {
          localObject3 = this.mIconView;
          if (localObject3 != null)
          {
            ((ImageView)localObject3).setVisibility(8);
            this.mIconView.setImageDrawable(null);
          }
        }
        boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
        if (bool)
        {
          if (this.mTextView == null)
          {
            localObject3 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
            ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
            localObject4 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject4).gravity = 16;
            ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            addView((View)localObject3);
            this.mTextView = ((TextView)localObject3);
          }
          this.mTextView.setText((CharSequence)localObject2);
          this.mTextView.setVisibility(0);
        }
        else
        {
          localObject2 = this.mTextView;
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(8);
            this.mTextView.setText(null);
          }
        }
        localObject2 = this.mIconView;
        if (localObject2 != null) {
          ((ImageView)localObject2).setContentDescription(localTab.getContentDescription());
        }
        if (!bool) {
          localObject1 = localTab.getContentDescription();
        }
        TooltipCompat.setTooltipText(this, (CharSequence)localObject1);
      }
    }
  }
  
  protected class VisibilityAnimListener
    extends AnimatorListenerAdapter
  {
    private boolean mCanceled = false;
    private int mFinalVisibility;
    
    protected VisibilityAnimListener() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.mCanceled) {
        return;
      }
      paramAnimator = ScrollingTabContainerView.this;
      paramAnimator.mVisibilityAnim = null;
      paramAnimator.setVisibility(this.mFinalVisibility);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      ScrollingTabContainerView.this.setVisibility(0);
      this.mCanceled = false;
    }
    
    public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator paramViewPropertyAnimator, int paramInt)
    {
      this.mFinalVisibility = paramInt;
      ScrollingTabContainerView.this.mVisibilityAnim = paramViewPropertyAnimator;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ScrollingTabContainerView
 * JD-Core Version:    0.7.0.1
 */