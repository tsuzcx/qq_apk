package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  private static final int DEFAULT_FADE_COLOR = -858993460;
  private static final int DEFAULT_OVERHANG_SIZE = 32;
  static final SlidingPaneLayout.SlidingPanelLayoutImpl IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplBase();
  private static final int MIN_FLING_VELOCITY = 400;
  private static final String TAG = "SlidingPaneLayout";
  private boolean mCanSlide;
  private int mCoveredFadeColor;
  final ViewDragHelper mDragHelper;
  private boolean mFirstLayout = true;
  private float mInitialMotionX;
  private float mInitialMotionY;
  boolean mIsUnableToDrag;
  private final int mOverhangSize;
  private SlidingPaneLayout.PanelSlideListener mPanelSlideListener;
  private int mParallaxBy;
  private float mParallaxOffset;
  final ArrayList mPostedRunnables = new ArrayList();
  boolean mPreservedOpenState;
  private Drawable mShadowDrawableLeft;
  private Drawable mShadowDrawableRight;
  float mSlideOffset;
  int mSlideRange;
  View mSlideableView;
  private int mSliderFadeColor = -858993460;
  private final Rect mTmpRect = new Rect();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplJBMR1();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplJB();
      return;
    }
  }
  
  public SlidingPaneLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlidingPaneLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mOverhangSize = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate(this, new SlidingPaneLayout.AccessibilityDelegate(this));
    ViewCompat.setImportantForAccessibility(this, 1);
    this.mDragHelper = ViewDragHelper.create(this, 0.5F, new SlidingPaneLayout.DragHelperCallback(this));
    this.mDragHelper.setMinVelocity(f * 400.0F);
  }
  
  private boolean closePane(View paramView, int paramInt)
  {
    boolean bool = false;
    if ((this.mFirstLayout) || (smoothSlideTo(0.0F, paramInt)))
    {
      this.mPreservedOpenState = false;
      bool = true;
    }
    return bool;
  }
  
  private void dimChildView(View paramView, float paramFloat, int paramInt)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.dimPaint == null) {
        localLayoutParams.dimPaint = new Paint();
      }
      localLayoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.dimPaint);
      }
      invalidateChildRegion(paramView);
    }
    while (paramView.getLayerType() == 0)
    {
      int i;
      return;
    }
    if (localLayoutParams.dimPaint != null) {
      localLayoutParams.dimPaint.setColorFilter(null);
    }
    paramView = new SlidingPaneLayout.DisableLayerRunnable(this, paramView);
    this.mPostedRunnables.add(paramView);
    ViewCompat.postOnAnimation(this, paramView);
  }
  
  private boolean openPane(View paramView, int paramInt)
  {
    if ((this.mFirstLayout) || (smoothSlideTo(1.0F, paramInt)))
    {
      this.mPreservedOpenState = true;
      return true;
    }
    return false;
  }
  
  private void parallaxOtherViews(float paramFloat)
  {
    boolean bool = isLayoutRtlSupport();
    Object localObject = (SlidingPaneLayout.LayoutParams)this.mSlideableView.getLayoutParams();
    int i;
    label43:
    int j;
    if (((SlidingPaneLayout.LayoutParams)localObject).dimWhenOffset) {
      if (bool)
      {
        i = ((SlidingPaneLayout.LayoutParams)localObject).rightMargin;
        if (i > 0) {
          break label94;
        }
        i = 1;
        int n = getChildCount();
        j = 0;
        label52:
        if (j >= n) {
          return;
        }
        localObject = getChildAt(j);
        if (localObject != this.mSlideableView) {
          break label99;
        }
      }
    }
    label94:
    label99:
    do
    {
      j += 1;
      break label52;
      i = ((SlidingPaneLayout.LayoutParams)localObject).leftMargin;
      break;
      i = 0;
      break label43;
      int k = (int)((1.0F - this.mParallaxOffset) * this.mParallaxBy);
      this.mParallaxOffset = paramFloat;
      int m = k - (int)((1.0F - paramFloat) * this.mParallaxBy);
      k = m;
      if (bool) {
        k = -m;
      }
      ((View)localObject).offsetLeftAndRight(k);
    } while (i == 0);
    if (bool) {}
    for (float f = this.mParallaxOffset - 1.0F;; f = 1.0F - this.mParallaxOffset)
    {
      dimChildView((View)localObject, f, this.mCoveredFadeColor);
      break;
    }
  }
  
  private static boolean viewIsOpaque(View paramView)
  {
    if (paramView.isOpaque()) {}
    do
    {
      return true;
      if (Build.VERSION.SDK_INT >= 18) {
        return false;
      }
      paramView = paramView.getBackground();
      if (paramView == null) {
        break;
      }
    } while (paramView.getOpacity() == -1);
    return false;
    return false;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {}
      }
    }
    for (;;)
    {
      return true;
      i -= 1;
      break;
      if (paramBoolean) {
        if (!isLayoutRtlSupport()) {
          break label165;
        }
      }
      while (!paramView.canScrollHorizontally(paramInt1))
      {
        return false;
        label165:
        paramInt1 = -paramInt1;
      }
    }
  }
  
  @Deprecated
  public boolean canSlide()
  {
    return this.mCanSlide;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof SlidingPaneLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public boolean closePane()
  {
    return closePane(this.mSlideableView, 0);
  }
  
  public void computeScroll()
  {
    if (this.mDragHelper.continueSettling(true))
    {
      if (!this.mCanSlide) {
        this.mDragHelper.abort();
      }
    }
    else {
      return;
    }
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  void dispatchOnPanelClosed(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelClosed(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelOpened(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelOpened(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelSlide(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelSlide(paramView, this.mSlideOffset);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (isLayoutRtlSupport())
    {
      localDrawable = this.mShadowDrawableRight;
      if (getChildCount() <= 1) {
        break label53;
      }
    }
    label53:
    for (View localView = getChildAt(1);; localView = null)
    {
      if ((localView != null) && (localDrawable != null)) {
        break label59;
      }
      return;
      localDrawable = this.mShadowDrawableLeft;
      break;
    }
    label59:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (isLayoutRtlSupport())
    {
      j = localView.getRight();
      i = j + n;
    }
    for (;;)
    {
      localDrawable.setBounds(j, k, i, m);
      localDrawable.draw(paramCanvas);
      return;
      i = localView.getLeft();
      j = i - n;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save();
    if ((this.mCanSlide) && (!localLayoutParams.slideable) && (this.mSlideableView != null))
    {
      paramCanvas.getClipBounds(this.mTmpRect);
      if (!isLayoutRtlSupport()) {
        break label104;
      }
      this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
    }
    for (;;)
    {
      paramCanvas.clipRect(this.mTmpRect);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool;
      label104:
      this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new SlidingPaneLayout.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new SlidingPaneLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new SlidingPaneLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new SlidingPaneLayout.LayoutParams(paramLayoutParams);
  }
  
  @ColorInt
  public int getCoveredFadeColor()
  {
    return this.mCoveredFadeColor;
  }
  
  public int getParallaxDistance()
  {
    return this.mParallaxBy;
  }
  
  @ColorInt
  public int getSliderFadeColor()
  {
    return this.mSliderFadeColor;
  }
  
  void invalidateChildRegion(View paramView)
  {
    IMPL.invalidateChildRegion(this, paramView);
  }
  
  boolean isDimmed(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    if ((this.mCanSlide) && (paramView.dimWhenOffset) && (this.mSlideOffset > 0.0F)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isLayoutRtlSupport()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }
  
  public boolean isOpen()
  {
    return (!this.mCanSlide) || (this.mSlideOffset == 1.0F);
  }
  
  public boolean isSlideable()
  {
    return this.mCanSlide;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int j = this.mPostedRunnables.size();
    int i = 0;
    while (i < j)
    {
      ((SlidingPaneLayout.DisableLayerRunnable)this.mPostedRunnables.get(i)).run();
      i += 1;
    }
    this.mPostedRunnables.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getActionMasked();
    if ((!this.mCanSlide) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (this.mDragHelper.isViewUnder(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label108;
        }
      }
    }
    label108:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mPreservedOpenState = bool1;
      if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (i == 0))) {
        break;
      }
      this.mDragHelper.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.mDragHelper.cancel();
      return false;
    }
    switch (i)
    {
    }
    label164:
    float f1;
    float f2;
    do
    {
      for (i = 0;; i = 1)
      {
        if (!this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent))
        {
          bool1 = bool2;
          if (i == 0) {
            break;
          }
        }
        return true;
        this.mIsUnableToDrag = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        if ((!this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2)) || (!isDimmed(this.mSlideableView))) {
          break label164;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.mInitialMotionX);
      f1 = Math.abs(f1 - this.mInitialMotionY);
    } while ((f2 <= this.mDragHelper.getTouchSlop()) || (f1 <= f2));
    this.mDragHelper.cancel();
    this.mIsUnableToDrag = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = isLayoutRtlSupport();
    int k;
    label35:
    label46:
    int n;
    int m;
    if (bool)
    {
      this.mDragHelper.setEdgeTrackingEnabled(2);
      k = paramInt3 - paramInt1;
      if (!bool) {
        break label154;
      }
      paramInt1 = getPaddingRight();
      if (!bool) {
        break label162;
      }
      paramInt4 = getPaddingLeft();
      n = getPaddingTop();
      m = getChildCount();
      if (this.mFirstLayout) {
        if ((!this.mCanSlide) || (!this.mPreservedOpenState)) {
          break label171;
        }
      }
    }
    View localView;
    label154:
    label162:
    label171:
    for (float f = 1.0F;; f = 0.0F)
    {
      this.mSlideOffset = f;
      int i = 0;
      for (paramInt2 = paramInt1;; paramInt2 = paramInt3)
      {
        if (i >= m) {
          break label451;
        }
        localView = getChildAt(i);
        if (localView.getVisibility() != 8) {
          break;
        }
        paramInt3 = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = paramInt3;
        i += 1;
        paramInt3 = paramInt1;
        paramInt1 = paramInt2;
      }
      this.mDragHelper.setEdgeTrackingEnabled(1);
      break;
      paramInt1 = getPaddingLeft();
      break label35;
      paramInt4 = getPaddingRight();
      break label46;
    }
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)localView.getLayoutParams();
    int i1 = localView.getMeasuredWidth();
    int j;
    if (localLayoutParams.slideable)
    {
      paramInt3 = localLayoutParams.leftMargin;
      j = localLayoutParams.rightMargin;
      j = Math.min(paramInt1, k - paramInt4 - this.mOverhangSize) - paramInt2 - (paramInt3 + j);
      this.mSlideRange = j;
      if (bool)
      {
        paramInt3 = localLayoutParams.rightMargin;
        label258:
        if (paramInt2 + paramInt3 + j + i1 / 2 <= k - paramInt4) {
          break label388;
        }
        paramBoolean = true;
        label280:
        localLayoutParams.dimWhenOffset = paramBoolean;
        j = (int)(j * this.mSlideOffset);
        paramInt2 += paramInt3 + j;
        this.mSlideOffset = (j / this.mSlideRange);
        paramInt3 = 0;
        label321:
        if (!bool) {
          break label435;
        }
        j = k - paramInt2 + paramInt3;
        paramInt3 = j - i1;
      }
    }
    for (;;)
    {
      localView.layout(paramInt3, n, j, localView.getMeasuredHeight() + n);
      paramInt3 = localView.getWidth() + paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt3;
      break;
      paramInt3 = localLayoutParams.leftMargin;
      break label258;
      label388:
      paramBoolean = false;
      break label280;
      if ((this.mCanSlide) && (this.mParallaxBy != 0))
      {
        paramInt3 = (int)((1.0F - this.mSlideOffset) * this.mParallaxBy);
        paramInt2 = paramInt1;
        break label321;
      }
      paramInt3 = 0;
      paramInt2 = paramInt1;
      break label321;
      label435:
      paramInt3 = paramInt2 - paramInt3;
      j = paramInt3 + i1;
    }
    label451:
    if (this.mFirstLayout)
    {
      if (!this.mCanSlide) {
        break label526;
      }
      if (this.mParallaxBy != 0) {
        parallaxOtherViews(this.mSlideOffset);
      }
      if (((SlidingPaneLayout.LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset) {
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
      }
    }
    for (;;)
    {
      updateObscuredViewsVisibility(this.mSlideableView);
      this.mFirstLayout = false;
      return;
      label526:
      paramInt1 = 0;
      while (paramInt1 < m)
      {
        dimChildView(getChildAt(paramInt1), 0.0F, this.mSliderFadeColor);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824) {
      if (isInEditMode()) {
        if (k == -2147483648)
        {
          paramInt2 = i;
          i = j;
        }
      }
    }
    for (;;)
    {
      label85:
      boolean bool1;
      int i2;
      int i3;
      int i1;
      float f1;
      label136:
      View localView;
      SlidingPaneLayout.LayoutParams localLayoutParams;
      switch (i)
      {
      default: 
        paramInt1 = 0;
        k = 0;
        bool1 = false;
        i2 = paramInt2 - getPaddingLeft() - getPaddingRight();
        i3 = getChildCount();
        if (i3 > 2) {
          Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        i1 = 0;
        j = i2;
        f1 = 0.0F;
        if (i1 >= i3) {
          break label617;
        }
        localView = getChildAt(i1);
        localLayoutParams = (SlidingPaneLayout.LayoutParams)localView.getLayoutParams();
        if (localView.getVisibility() == 8)
        {
          localLayoutParams.dimWhenOffset = false;
          m = j;
          j = paramInt1;
          paramInt1 = m;
        }
        break;
      }
      float f2;
      for (;;)
      {
        i1 += 1;
        m = j;
        j = paramInt1;
        paramInt1 = m;
        break label136;
        if (k != 0) {
          break label1105;
        }
        i = j;
        paramInt2 = 300;
        break;
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (j != 0) {
          break label1105;
        }
        if (isInEditMode())
        {
          if (j != 0) {
            break label1105;
          }
          j = -2147483648;
          paramInt2 = i;
          paramInt1 = 300;
          i = j;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        k = paramInt1;
        break label85;
        k = getPaddingTop();
        m = getPaddingBottom();
        j = 0;
        k = paramInt1 - k - m;
        paramInt1 = j;
        break label85;
        f2 = f1;
        if (localLayoutParams.weight <= 0.0F) {
          break label373;
        }
        f1 += localLayoutParams.weight;
        f2 = f1;
        if (localLayoutParams.width != 0) {
          break label373;
        }
        m = paramInt1;
        paramInt1 = j;
        j = m;
      }
      label373:
      int m = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
      label409:
      int n;
      label429:
      int i4;
      if (localLayoutParams.width == -2)
      {
        m = View.MeasureSpec.makeMeasureSpec(i2 - m, -2147483648);
        if (localLayoutParams.height != -2) {
          break label573;
        }
        n = View.MeasureSpec.makeMeasureSpec(k, -2147483648);
        localView.measure(m, n);
        n = localView.getMeasuredWidth();
        i4 = localView.getMeasuredHeight();
        m = paramInt1;
        if (i == -2147483648)
        {
          m = paramInt1;
          if (i4 > paramInt1) {
            m = Math.min(i4, k);
          }
        }
        paramInt1 = j - n;
        if (paramInt1 >= 0) {
          break label611;
        }
      }
      label573:
      label611:
      for (boolean bool2 = true;; bool2 = false)
      {
        localLayoutParams.slideable = bool2;
        if (localLayoutParams.slideable) {
          this.mSlideableView = localView;
        }
        j = m;
        bool1 = bool2 | bool1;
        f1 = f2;
        break;
        if (localLayoutParams.width == -1)
        {
          m = View.MeasureSpec.makeMeasureSpec(i2 - m, 1073741824);
          break label409;
        }
        m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
        break label409;
        if (localLayoutParams.height == -1)
        {
          n = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
          break label429;
        }
        n = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
        break label429;
      }
      label617:
      if ((bool1) || (f1 > 0.0F))
      {
        i1 = i2 - this.mOverhangSize;
        m = 0;
        if (m < i3)
        {
          localView = getChildAt(m);
          if (localView.getVisibility() == 8) {}
          for (;;)
          {
            m += 1;
            break;
            localLayoutParams = (SlidingPaneLayout.LayoutParams)localView.getLayoutParams();
            if (localView.getVisibility() != 8)
            {
              if ((localLayoutParams.width == 0) && (localLayoutParams.weight > 0.0F))
              {
                i = 1;
                if (i == 0) {
                  break label811;
                }
                n = 0;
                if ((!bool1) || (localView == this.mSlideableView)) {
                  break label875;
                }
                if ((localLayoutParams.width >= 0) || ((n <= i1) && (localLayoutParams.weight <= 0.0F))) {
                  continue;
                }
                if (i == 0) {
                  break label859;
                }
                if (localLayoutParams.height != -2) {
                  break label821;
                }
                i = View.MeasureSpec.makeMeasureSpec(k, -2147483648);
              }
              for (;;)
              {
                localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i);
                break;
                i = 0;
                break label715;
                n = localView.getMeasuredWidth();
                break label723;
                if (localLayoutParams.height == -1)
                {
                  i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                }
                else
                {
                  i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                  continue;
                  i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                }
              }
              label875:
              if (localLayoutParams.weight > 0.0F)
              {
                if (localLayoutParams.width == 0) {
                  if (localLayoutParams.height == -2) {
                    i = View.MeasureSpec.makeMeasureSpec(k, -2147483648);
                  }
                }
                for (;;)
                {
                  if (!bool1) {
                    break label1021;
                  }
                  i4 = localLayoutParams.leftMargin;
                  i4 = i2 - (localLayoutParams.rightMargin + i4);
                  int i5 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                  if (n == i4) {
                    break;
                  }
                  localView.measure(i5, i);
                  break;
                  if (localLayoutParams.height == -1)
                  {
                    i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                  }
                  else
                  {
                    i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                    continue;
                    i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                  }
                }
                label1021:
                i4 = Math.max(0, j);
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.weight * i4 / f1) + n, 1073741824), i);
              }
            }
          }
        }
      }
      label715:
      label723:
      label859:
      setMeasuredDimension(paramInt2, getPaddingTop() + paramInt1 + getPaddingBottom());
      label811:
      label821:
      this.mCanSlide = bool1;
      if ((this.mDragHelper.getViewDragState() != 0) && (!bool1)) {
        this.mDragHelper.abort();
      }
      return;
      label1105:
      paramInt2 = i;
      i = j;
    }
  }
  
  void onPanelDragged(int paramInt)
  {
    if (this.mSlideableView == null)
    {
      this.mSlideOffset = 0.0F;
      return;
    }
    boolean bool = isLayoutRtlSupport();
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)this.mSlideableView.getLayoutParams();
    int j = this.mSlideableView.getWidth();
    int i = paramInt;
    if (bool) {
      i = getWidth() - paramInt - j;
    }
    if (bool)
    {
      paramInt = getPaddingRight();
      if (!bool) {
        break label148;
      }
    }
    label148:
    for (j = localLayoutParams.rightMargin;; j = localLayoutParams.leftMargin)
    {
      this.mSlideOffset = ((i - (j + paramInt)) / this.mSlideRange);
      if (this.mParallaxBy != 0) {
        parallaxOtherViews(this.mSlideOffset);
      }
      if (localLayoutParams.dimWhenOffset) {
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
      }
      dispatchOnPanelSlide(this.mSlideableView);
      return;
      paramInt = getPaddingLeft();
      break;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SlidingPaneLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SlidingPaneLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.isOpen) {
      openPane();
    }
    for (;;)
    {
      this.mPreservedOpenState = paramParcelable.isOpen;
      return;
      closePane();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SlidingPaneLayout.SavedState localSavedState = new SlidingPaneLayout.SavedState(super.onSaveInstanceState());
    if (isSlideable()) {}
    for (boolean bool = isOpen();; bool = this.mPreservedOpenState)
    {
      localSavedState.isOpen = bool;
      return localSavedState;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.mFirstLayout = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (!this.mCanSlide) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    do
    {
      boolean bool2;
      float f3;
      float f4;
      int i;
      do
      {
        do
        {
          return bool1;
          this.mDragHelper.processTouchEvent(paramMotionEvent);
          bool2 = true;
          switch (paramMotionEvent.getActionMasked())
          {
          default: 
            return true;
          case 0: 
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            this.mInitialMotionX = f1;
            this.mInitialMotionY = f2;
            return true;
          }
          bool1 = bool2;
        } while (!isDimmed(this.mSlideableView));
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        f3 = f1 - this.mInitialMotionX;
        f4 = f2 - this.mInitialMotionY;
        i = this.mDragHelper.getTouchSlop();
        bool1 = bool2;
      } while (f3 * f3 + f4 * f4 >= i * i);
      bool1 = bool2;
    } while (!this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2));
    closePane(this.mSlideableView, 0);
    return true;
  }
  
  public boolean openPane()
  {
    return openPane(this.mSlideableView, 0);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide)) {
      if (paramView1 != this.mSlideableView) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.mPreservedOpenState = bool;
      return;
    }
  }
  
  void setAllChildrenVisible()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  public void setCoveredFadeColor(@ColorInt int paramInt)
  {
    this.mCoveredFadeColor = paramInt;
  }
  
  public void setPanelSlideListener(@Nullable SlidingPaneLayout.PanelSlideListener paramPanelSlideListener)
  {
    this.mPanelSlideListener = paramPanelSlideListener;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.mParallaxBy = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(@Nullable Drawable paramDrawable)
  {
    this.mShadowDrawableLeft = paramDrawable;
  }
  
  public void setShadowDrawableRight(@Nullable Drawable paramDrawable)
  {
    this.mShadowDrawableRight = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(@DrawableRes int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    setShadowDrawableRight(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(@ColorInt int paramInt)
  {
    this.mSliderFadeColor = paramInt;
  }
  
  @Deprecated
  public void smoothSlideClosed()
  {
    closePane();
  }
  
  @Deprecated
  public void smoothSlideOpen()
  {
    openPane();
  }
  
  boolean smoothSlideTo(float paramFloat, int paramInt)
  {
    if (!this.mCanSlide) {
      return false;
    }
    boolean bool = isLayoutRtlSupport();
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)this.mSlideableView.getLayoutParams();
    int i;
    int j;
    if (bool)
    {
      paramInt = getPaddingRight();
      i = localLayoutParams.rightMargin;
      j = this.mSlideableView.getWidth();
    }
    for (paramInt = (int)(getWidth() - (i + paramInt + this.mSlideRange * paramFloat + j)); this.mDragHelper.smoothSlideViewTo(this.mSlideableView, paramInt, this.mSlideableView.getTop()); paramInt = (int)(localLayoutParams.leftMargin + paramInt + this.mSlideRange * paramFloat))
    {
      setAllChildrenVisible();
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
      paramInt = getPaddingLeft();
    }
    return false;
  }
  
  void updateObscuredViewsVisibility(View paramView)
  {
    boolean bool = isLayoutRtlSupport();
    int i;
    int j;
    label31:
    int i4;
    int i5;
    int i6;
    int i1;
    int n;
    int m;
    int k;
    label84:
    int i7;
    int i2;
    if (bool)
    {
      i = getWidth() - getPaddingRight();
      if (!bool) {
        break label123;
      }
      j = getPaddingLeft();
      i4 = getPaddingTop();
      i5 = getHeight();
      i6 = getPaddingBottom();
      if ((paramView == null) || (!viewIsOpaque(paramView))) {
        break label136;
      }
      i1 = paramView.getLeft();
      n = paramView.getRight();
      m = paramView.getTop();
      k = paramView.getBottom();
      i7 = getChildCount();
      i2 = 0;
    }
    View localView;
    for (;;)
    {
      if (i2 < i7)
      {
        localView = getChildAt(i2);
        if (localView != paramView) {}
      }
      else
      {
        return;
        i = getPaddingLeft();
        break;
        label123:
        j = getWidth() - getPaddingRight();
        break label31;
        label136:
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        break label84;
      }
      if (localView.getVisibility() != 8) {
        break label170;
      }
      i2 += 1;
    }
    label170:
    if (bool)
    {
      i3 = j;
      label178:
      int i8 = Math.max(i3, localView.getLeft());
      int i9 = Math.max(i4, localView.getTop());
      if (!bool) {
        break label284;
      }
      i3 = i;
      label210:
      i3 = Math.min(i3, localView.getRight());
      int i10 = Math.min(i5 - i6, localView.getBottom());
      if ((i8 < i1) || (i9 < m) || (i3 > n) || (i10 > k)) {
        break label290;
      }
    }
    label284:
    label290:
    for (int i3 = 4;; i3 = 0)
    {
      localView.setVisibility(i3);
      break;
      i3 = i;
      break label178;
      i3 = j;
      break label210;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */