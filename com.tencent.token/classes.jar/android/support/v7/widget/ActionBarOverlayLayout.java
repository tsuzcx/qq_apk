package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ActionBarOverlayLayout
  extends ViewGroup
  implements NestedScrollingParent, DecorContentParent
{
  static final int[] ATTRS = { R.attr.actionBarSize, 16842841 };
  private static final String TAG = "ActionBarOverlayLayout";
  private final int ACTION_BAR_ANIMATE_DELAY = 600;
  private int mActionBarHeight;
  ActionBarContainer mActionBarTop;
  private ActionBarVisibilityCallback mActionBarVisibilityCallback;
  private final Runnable mAddActionBarHideOffset = new Runnable()
  {
    public void run()
    {
      ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
      ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
      localActionBarOverlayLayout.mCurrentActionBarTopAnimator = localActionBarOverlayLayout.mActionBarTop.animate().translationY(-ActionBarOverlayLayout.this.mActionBarTop.getHeight()).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
    }
  };
  boolean mAnimatingForFling;
  private final Rect mBaseContentInsets = new Rect();
  private final Rect mBaseInnerInsets = new Rect();
  private ContentFrameLayout mContent;
  private final Rect mContentInsets = new Rect();
  ViewPropertyAnimator mCurrentActionBarTopAnimator;
  private DecorToolbar mDecorToolbar;
  private OverScroller mFlingEstimator;
  private boolean mHasNonEmbeddedTabs;
  private boolean mHideOnContentScroll;
  private int mHideOnContentScrollReference;
  private boolean mIgnoreWindowContentOverlay;
  private final Rect mInnerInsets = new Rect();
  private final Rect mLastBaseContentInsets = new Rect();
  private final Rect mLastBaseInnerInsets = new Rect();
  private final Rect mLastInnerInsets = new Rect();
  private int mLastSystemUiVisibility;
  private boolean mOverlayMode;
  private final NestedScrollingParentHelper mParentHelper;
  private final Runnable mRemoveActionBarHideOffset = new Runnable()
  {
    public void run()
    {
      ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
      ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
      localActionBarOverlayLayout.mCurrentActionBarTopAnimator = localActionBarOverlayLayout.mActionBarTop.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
    }
  };
  final AnimatorListenerAdapter mTopAnimatorListener = new AnimatorListenerAdapter()
  {
    public void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      paramAnonymousAnimator = ActionBarOverlayLayout.this;
      paramAnonymousAnimator.mCurrentActionBarTopAnimator = null;
      paramAnonymousAnimator.mAnimatingForFling = false;
    }
    
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      paramAnonymousAnimator = ActionBarOverlayLayout.this;
      paramAnonymousAnimator.mCurrentActionBarTopAnimator = null;
      paramAnonymousAnimator.mAnimatingForFling = false;
    }
  };
  private Drawable mWindowContentOverlay;
  private int mWindowVisibility = 0;
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.mParentHelper = new NestedScrollingParentHelper(this);
  }
  
  private void addActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    this.mAddActionBarHideOffset.run();
  }
  
  private boolean applyInsets(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    boolean bool;
    if ((paramBoolean1) && (paramView.leftMargin != paramRect.left))
    {
      paramView.leftMargin = paramRect.left;
      bool = true;
    }
    else
    {
      bool = false;
    }
    paramBoolean1 = bool;
    if (paramBoolean2)
    {
      paramBoolean1 = bool;
      if (paramView.topMargin != paramRect.top)
      {
        paramView.topMargin = paramRect.top;
        paramBoolean1 = true;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      paramBoolean2 = paramBoolean1;
      if (paramView.rightMargin != paramRect.right)
      {
        paramView.rightMargin = paramRect.right;
        paramBoolean2 = true;
      }
    }
    paramBoolean1 = paramBoolean2;
    if (paramBoolean3)
    {
      paramBoolean1 = paramBoolean2;
      if (paramView.bottomMargin != paramRect.bottom)
      {
        paramView.bottomMargin = paramRect.bottom;
        paramBoolean1 = true;
      }
    }
    return paramBoolean1;
  }
  
  private DecorToolbar getDecorToolbar(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {
      return (DecorToolbar)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't make a decor toolbar out of ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void init(Context paramContext)
  {
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(ATTRS);
    boolean bool2 = false;
    this.mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    this.mWindowContentOverlay = localTypedArray.getDrawable(1);
    if (this.mWindowContentOverlay == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    localTypedArray.recycle();
    boolean bool1 = bool2;
    if (paramContext.getApplicationInfo().targetSdkVersion < 19) {
      bool1 = true;
    }
    this.mIgnoreWindowContentOverlay = bool1;
    this.mFlingEstimator = new OverScroller(paramContext);
  }
  
  private void postAddActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    postDelayed(this.mAddActionBarHideOffset, 600L);
  }
  
  private void postRemoveActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    postDelayed(this.mRemoveActionBarHideOffset, 600L);
  }
  
  private void removeActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    this.mRemoveActionBarHideOffset.run();
  }
  
  private boolean shouldHideActionBarOnFling(float paramFloat1, float paramFloat2)
  {
    this.mFlingEstimator.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    return this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight();
  }
  
  public boolean canShowOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.canShowOverflowMenu();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dismissPopups()
  {
    pullChildren();
    this.mDecorToolbar.dismissPopupMenus();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.mWindowContentOverlay != null) && (!this.mIgnoreWindowContentOverlay))
    {
      int i;
      if (this.mActionBarTop.getVisibility() == 0) {
        i = (int)(this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY() + 0.5F);
      } else {
        i = 0;
      }
      this.mWindowContentOverlay.setBounds(0, i, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + i);
      this.mWindowContentOverlay.draw(paramCanvas);
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    pullChildren();
    ViewCompat.getWindowSystemUiVisibility(this);
    boolean bool = applyInsets(this.mActionBarTop, paramRect, true, true, false, true);
    this.mBaseInnerInsets.set(paramRect);
    ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsets, this.mBaseContentInsets);
    if (!this.mLastBaseInnerInsets.equals(this.mBaseInnerInsets))
    {
      this.mLastBaseInnerInsets.set(this.mBaseInnerInsets);
      bool = true;
    }
    if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets))
    {
      this.mLastBaseContentInsets.set(this.mBaseContentInsets);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    ActionBarContainer localActionBarContainer = this.mActionBarTop;
    if (localActionBarContainer != null) {
      return -(int)localActionBarContainer.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.mParentHelper.getNestedScrollAxes();
  }
  
  public CharSequence getTitle()
  {
    pullChildren();
    return this.mDecorToolbar.getTitle();
  }
  
  void haltActionBarHideOffsetAnimations()
  {
    removeCallbacks(this.mRemoveActionBarHideOffset);
    removeCallbacks(this.mAddActionBarHideOffset);
    ViewPropertyAnimator localViewPropertyAnimator = this.mCurrentActionBarTopAnimator;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
  }
  
  public boolean hasIcon()
  {
    pullChildren();
    return this.mDecorToolbar.hasIcon();
  }
  
  public boolean hasLogo()
  {
    pullChildren();
    return this.mDecorToolbar.hasLogo();
  }
  
  public boolean hideOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.hideOverflowMenu();
  }
  
  public void initFeature(int paramInt)
  {
    pullChildren();
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt != 109) {
          return;
        }
        setOverlayMode(true);
        return;
      }
      this.mDecorToolbar.initIndeterminateProgress();
      return;
    }
    this.mDecorToolbar.initProgress();
  }
  
  public boolean isHideOnContentScrollEnabled()
  {
    return this.mHideOnContentScroll;
  }
  
  public boolean isInOverlayMode()
  {
    return this.mOverlayMode;
  }
  
  public boolean isOverflowMenuShowPending()
  {
    pullChildren();
    return this.mDecorToolbar.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    pullChildren();
    return this.mDecorToolbar.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    haltActionBarHideOffsetAnimations();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i = localView.getMeasuredWidth();
        int j = localView.getMeasuredHeight();
        int k = localLayoutParams.leftMargin + paramInt3;
        int m = localLayoutParams.topMargin + paramInt4;
        localView.layout(k, m, i + k, j + m);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    pullChildren();
    measureChildWithMargins(this.mActionBarTop, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.mActionBarTop.getLayoutParams();
    int i1 = Math.max(0, this.mActionBarTop.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int n = Math.max(0, this.mActionBarTop.getMeasuredHeight() + ((LayoutParams)localObject).topMargin + ((LayoutParams)localObject).bottomMargin);
    int m = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
    if ((ViewCompat.getWindowSystemUiVisibility(this) & 0x100) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      k = this.mActionBarHeight;
      i = k;
      if (this.mHasNonEmbeddedTabs)
      {
        i = k;
        if (this.mActionBarTop.getTabContainer() != null) {
          i = k + this.mActionBarHeight;
        }
      }
    }
    else if (this.mActionBarTop.getVisibility() != 8)
    {
      i = this.mActionBarTop.getMeasuredHeight();
    }
    else
    {
      i = 0;
    }
    this.mContentInsets.set(this.mBaseContentInsets);
    this.mInnerInsets.set(this.mBaseInnerInsets);
    if ((!this.mOverlayMode) && (j == 0))
    {
      localObject = this.mContentInsets;
      ((Rect)localObject).top += i;
      localObject = this.mContentInsets;
      ((Rect)localObject).bottom += 0;
    }
    else
    {
      localObject = this.mInnerInsets;
      ((Rect)localObject).top += i;
      localObject = this.mInnerInsets;
      ((Rect)localObject).bottom += 0;
    }
    applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
    if (!this.mLastInnerInsets.equals(this.mInnerInsets))
    {
      this.mLastInnerInsets.set(this.mInnerInsets);
      this.mContent.dispatchFitSystemWindows(this.mInnerInsets);
    }
    measureChildWithMargins(this.mContent, paramInt1, 0, paramInt2, 0);
    localObject = (LayoutParams)this.mContent.getLayoutParams();
    int i = Math.max(i1, this.mContent.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int j = Math.max(n, this.mContent.getMeasuredHeight() + ((LayoutParams)localObject).topMargin + ((LayoutParams)localObject).bottomMargin);
    int k = View.combineMeasuredStates(m, this.mContent.getMeasuredState());
    m = getPaddingLeft();
    n = getPaddingRight();
    j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((this.mHideOnContentScroll) && (paramBoolean))
    {
      if (shouldHideActionBarOnFling(paramFloat1, paramFloat2)) {
        addActionBarHideOffset();
      } else {
        removeActionBarHideOffset();
      }
      this.mAnimatingForFling = true;
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mHideOnContentScrollReference += paramInt2;
    setActionBarHideOffset(this.mHideOnContentScrollReference);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.mParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.mHideOnContentScrollReference = getActionBarHideOffset();
    haltActionBarHideOffsetAnimations();
    paramView1 = this.mActionBarVisibilityCallback;
    if (paramView1 != null) {
      paramView1.onContentScrollStarted();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) != 0) && (this.mActionBarTop.getVisibility() == 0)) {
      return this.mHideOnContentScroll;
    }
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.mHideOnContentScroll) && (!this.mAnimatingForFling)) {
      if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
        postRemoveActionBarHideOffset();
      } else {
        postAddActionBarHideOffset();
      }
    }
    paramView = this.mActionBarVisibilityCallback;
    if (paramView != null) {
      paramView.onContentScrollStopped();
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    pullChildren();
    int k = this.mLastSystemUiVisibility;
    this.mLastSystemUiVisibility = paramInt;
    int j = 0;
    int i;
    if ((paramInt & 0x4) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt & 0x100) != 0) {
      j = 1;
    }
    ActionBarVisibilityCallback localActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
    if (localActionBarVisibilityCallback != null)
    {
      localActionBarVisibilityCallback.enableContentAnimations(j ^ 0x1);
      if ((i == 0) && (j != 0)) {
        this.mActionBarVisibilityCallback.hideForSystem();
      } else {
        this.mActionBarVisibilityCallback.showForSystem();
      }
    }
    if ((((k ^ paramInt) & 0x100) != 0) && (this.mActionBarVisibilityCallback != null)) {
      ViewCompat.requestApplyInsets(this);
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.mWindowVisibility = paramInt;
    ActionBarVisibilityCallback localActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
    if (localActionBarVisibilityCallback != null) {
      localActionBarVisibilityCallback.onWindowVisibilityChanged(paramInt);
    }
  }
  
  void pullChildren()
  {
    if (this.mContent == null)
    {
      this.mContent = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      this.mActionBarTop = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
    }
  }
  
  public void restoreToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    pullChildren();
    this.mDecorToolbar.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    pullChildren();
    this.mDecorToolbar.saveHierarchyState(paramSparseArray);
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    haltActionBarHideOffsetAnimations();
    paramInt = Math.max(0, Math.min(paramInt, this.mActionBarTop.getHeight()));
    this.mActionBarTop.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(ActionBarVisibilityCallback paramActionBarVisibilityCallback)
  {
    this.mActionBarVisibilityCallback = paramActionBarVisibilityCallback;
    if (getWindowToken() != null)
    {
      this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
      int i = this.mLastSystemUiVisibility;
      if (i != 0)
      {
        onWindowSystemUiVisibilityChanged(i);
        ViewCompat.requestApplyInsets(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.mHasNonEmbeddedTabs = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.mHideOnContentScroll)
    {
      this.mHideOnContentScroll = paramBoolean;
      if (!paramBoolean)
      {
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    pullChildren();
    this.mDecorToolbar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    pullChildren();
    this.mDecorToolbar.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    pullChildren();
    this.mDecorToolbar.setLogo(paramInt);
  }
  
  public void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    pullChildren();
    this.mDecorToolbar.setMenu(paramMenu, paramCallback);
  }
  
  public void setMenuPrepared()
  {
    pullChildren();
    this.mDecorToolbar.setMenuPrepared();
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.mOverlayMode = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.mIgnoreWindowContentOverlay = paramBoolean;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    pullChildren();
    this.mDecorToolbar.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    pullChildren();
    this.mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.showOverflowMenu();
  }
  
  public static abstract interface ActionBarVisibilityCallback
  {
    public abstract void enableContentAnimations(boolean paramBoolean);
    
    public abstract void hideForSystem();
    
    public abstract void onContentScrollStarted();
    
    public abstract void onContentScrollStopped();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
    
    public abstract void showForSystem();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */