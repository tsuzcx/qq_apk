package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  private static final int DEFAULT_FADE_COLOR = -858993460;
  private static final int DEFAULT_OVERHANG_SIZE = 32;
  static final SlidingPanelLayoutImpl IMPL = new SlidingPanelLayoutImplBase();
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
  private PanelSlideListener mPanelSlideListener;
  private int mParallaxBy;
  private float mParallaxOffset;
  final ArrayList<DisableLayerRunnable> mPostedRunnables = new ArrayList();
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
      IMPL = new SlidingPanelLayoutImplJBMR1();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new SlidingPanelLayoutImplJB();
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
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
    ViewCompat.setImportantForAccessibility(this, 1);
    this.mDragHelper = ViewDragHelper.create(this, 0.5F, new DragHelperCallback());
    this.mDragHelper.setMinVelocity(f * 400.0F);
  }
  
  private boolean closePane(View paramView, int paramInt)
  {
    if ((!this.mFirstLayout) && (!smoothSlideTo(0.0F, paramInt))) {
      return false;
    }
    this.mPreservedOpenState = false;
    return true;
  }
  
  private void dimChildView(View paramView, float paramFloat, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.dimPaint == null) {
        localLayoutParams.dimPaint = new Paint();
      }
      localLayoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i << 24 | paramInt & 0xFFFFFF, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.dimPaint);
      }
      invalidateChildRegion(paramView);
      return;
    }
    if (paramView.getLayerType() != 0)
    {
      if (localLayoutParams.dimPaint != null) {
        localLayoutParams.dimPaint.setColorFilter(null);
      }
      paramView = new DisableLayerRunnable(paramView);
      this.mPostedRunnables.add(paramView);
      ViewCompat.postOnAnimation(this, paramView);
    }
  }
  
  private boolean openPane(View paramView, int paramInt)
  {
    if ((!this.mFirstLayout) && (!smoothSlideTo(1.0F, paramInt))) {
      return false;
    }
    this.mPreservedOpenState = true;
    return true;
  }
  
  private void parallaxOtherViews(float paramFloat)
  {
    boolean bool1 = isLayoutRtlSupport();
    Object localObject = (LayoutParams)this.mSlideableView.getLayoutParams();
    boolean bool2 = ((LayoutParams)localObject).dimWhenOffset;
    int j = 0;
    if (bool2)
    {
      if (bool1) {
        i = ((LayoutParams)localObject).rightMargin;
      } else {
        i = ((LayoutParams)localObject).leftMargin;
      }
      if (i <= 0)
      {
        i = 1;
        break label64;
      }
    }
    int i = 0;
    label64:
    int n = getChildCount();
    while (j < n)
    {
      localObject = getChildAt(j);
      if (localObject != this.mSlideableView)
      {
        float f = this.mParallaxOffset;
        int k = this.mParallaxBy;
        int m = (int)((1.0F - f) * k);
        this.mParallaxOffset = paramFloat;
        m -= (int)((1.0F - paramFloat) * k);
        k = m;
        if (bool1) {
          k = -m;
        }
        ((View)localObject).offsetLeftAndRight(k);
        if (i != 0)
        {
          if (bool1) {
            f = this.mParallaxOffset - 1.0F;
          } else {
            f = 1.0F - this.mParallaxOffset;
          }
          dimChildView((View)localObject, f, this.mCoveredFadeColor);
        }
      }
      j += 1;
    }
  }
  
  private static boolean viewIsOpaque(View paramView)
  {
    if (paramView.isOpaque()) {
      return true;
    }
    if (Build.VERSION.SDK_INT >= 18) {
      return false;
    }
    paramView = paramView.getBackground();
    if (paramView != null) {
      return paramView.getOpacity() == -1;
    }
    return false;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        int m = paramInt2 + j;
        if ((m >= localView.getLeft()) && (m < localView.getRight()))
        {
          int n = paramInt3 + k;
          if ((n >= localView.getTop()) && (n < localView.getBottom()) && (canScroll(localView, true, paramInt1, m - localView.getLeft(), n - localView.getTop()))) {
            return true;
          }
        }
        i -= 1;
      }
    }
    if (paramBoolean)
    {
      if (!isLayoutRtlSupport()) {
        paramInt1 = -paramInt1;
      }
      if (paramView.canScrollHorizontally(paramInt1)) {
        return true;
      }
    }
    return false;
  }
  
  @Deprecated
  public boolean canSlide()
  {
    return this.mCanSlide;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public boolean closePane()
  {
    return closePane(this.mSlideableView, 0);
  }
  
  public void computeScroll()
  {
    if (this.mDragHelper.continueSettling(true))
    {
      if (!this.mCanSlide)
      {
        this.mDragHelper.abort();
        return;
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void dispatchOnPanelClosed(View paramView)
  {
    PanelSlideListener localPanelSlideListener = this.mPanelSlideListener;
    if (localPanelSlideListener != null) {
      localPanelSlideListener.onPanelClosed(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelOpened(View paramView)
  {
    PanelSlideListener localPanelSlideListener = this.mPanelSlideListener;
    if (localPanelSlideListener != null) {
      localPanelSlideListener.onPanelOpened(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelSlide(View paramView)
  {
    PanelSlideListener localPanelSlideListener = this.mPanelSlideListener;
    if (localPanelSlideListener != null) {
      localPanelSlideListener.onPanelSlide(paramView, this.mSlideOffset);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (isLayoutRtlSupport()) {
      localDrawable = this.mShadowDrawableRight;
    } else {
      localDrawable = this.mShadowDrawableLeft;
    }
    View localView;
    if (getChildCount() > 1) {
      localView = getChildAt(1);
    } else {
      localView = null;
    }
    if (localView != null)
    {
      if (localDrawable == null) {
        return;
      }
      int m = localView.getTop();
      int n = localView.getBottom();
      int k = localDrawable.getIntrinsicWidth();
      int i;
      int j;
      if (isLayoutRtlSupport())
      {
        i = localView.getRight();
        j = k + i;
      }
      else
      {
        j = localView.getLeft();
        i = j;
        k = j - k;
        j = i;
        i = k;
      }
      localDrawable.setBounds(i, m, j, n);
      localDrawable.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save();
    if ((this.mCanSlide) && (!((LayoutParams)localObject).slideable) && (this.mSlideableView != null))
    {
      paramCanvas.getClipBounds(this.mTmpRect);
      if (isLayoutRtlSupport())
      {
        localObject = this.mTmpRect;
        ((Rect)localObject).left = Math.max(((Rect)localObject).left, this.mSlideableView.getRight());
      }
      else
      {
        localObject = this.mTmpRect;
        ((Rect)localObject).right = Math.min(((Rect)localObject).right, this.mSlideableView.getLeft());
      }
      paramCanvas.clipRect(this.mTmpRect);
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
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
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = bool2;
    if (this.mCanSlide)
    {
      bool1 = bool2;
      if (paramView.dimWhenOffset)
      {
        bool1 = bool2;
        if (this.mSlideOffset > 0.0F) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
      ((DisableLayerRunnable)this.mPostedRunnables.get(i)).run();
      i += 1;
    }
    this.mPostedRunnables.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool2 = this.mCanSlide;
    boolean bool1 = true;
    if ((!bool2) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        this.mPreservedOpenState = (this.mDragHelper.isViewUnder(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) ^ true);
      }
    }
    if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (i == 0)))
    {
      if ((i != 3) && (i != 1))
      {
        float f2;
        float f1;
        if (i != 0)
        {
          if (i == 2)
          {
            f2 = paramMotionEvent.getX();
            f1 = paramMotionEvent.getY();
            f2 = Math.abs(f2 - this.mInitialMotionX);
            f1 = Math.abs(f1 - this.mInitialMotionY);
            if ((f2 > this.mDragHelper.getTouchSlop()) && (f1 > f2))
            {
              this.mDragHelper.cancel();
              this.mIsUnableToDrag = true;
              return false;
            }
          }
        }
        else
        {
          this.mIsUnableToDrag = false;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          this.mInitialMotionX = f1;
          this.mInitialMotionY = f2;
          if ((this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2)) && (isDimmed(this.mSlideableView)))
          {
            i = 1;
            break label247;
          }
        }
        i = 0;
        label247:
        if (!this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent))
        {
          if (i != 0) {
            return true;
          }
          bool1 = false;
        }
        return bool1;
      }
      this.mDragHelper.cancel();
      return false;
    }
    this.mDragHelper.cancel();
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = isLayoutRtlSupport();
    if (bool) {
      this.mDragHelper.setEdgeTrackingEnabled(2);
    } else {
      this.mDragHelper.setEdgeTrackingEnabled(1);
    }
    int k = paramInt3 - paramInt1;
    if (bool) {
      paramInt1 = getPaddingRight();
    } else {
      paramInt1 = getPaddingLeft();
    }
    if (bool) {
      paramInt4 = getPaddingLeft();
    } else {
      paramInt4 = getPaddingRight();
    }
    int n = getPaddingTop();
    int m = getChildCount();
    if (this.mFirstLayout)
    {
      float f;
      if ((this.mCanSlide) && (this.mPreservedOpenState)) {
        f = 1.0F;
      } else {
        f = 0.0F;
      }
      this.mSlideOffset = f;
    }
    paramInt2 = paramInt1;
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i1 = localView.getMeasuredWidth();
        int j;
        if (localLayoutParams.slideable)
        {
          paramInt3 = localLayoutParams.leftMargin;
          int i2 = localLayoutParams.rightMargin;
          j = k - paramInt4;
          i2 = Math.min(paramInt1, j - this.mOverhangSize) - paramInt2 - (paramInt3 + i2);
          this.mSlideRange = i2;
          if (bool) {
            paramInt3 = localLayoutParams.rightMargin;
          } else {
            paramInt3 = localLayoutParams.leftMargin;
          }
          if (paramInt2 + paramInt3 + i2 + i1 / 2 > j) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          localLayoutParams.dimWhenOffset = paramBoolean;
          j = (int)(i2 * this.mSlideOffset);
          paramInt2 = paramInt3 + j + paramInt2;
          this.mSlideOffset = (j / this.mSlideRange);
          paramInt3 = 0;
        }
        else
        {
          if (this.mCanSlide)
          {
            paramInt2 = this.mParallaxBy;
            if (paramInt2 != 0)
            {
              paramInt3 = (int)((1.0F - this.mSlideOffset) * paramInt2);
              paramInt2 = paramInt1;
              break label356;
            }
          }
          paramInt2 = paramInt1;
          paramInt3 = 0;
        }
        label356:
        if (bool)
        {
          j = k - paramInt2 + paramInt3;
          paramInt3 = j - i1;
        }
        else
        {
          paramInt3 = paramInt2 - paramInt3;
          j = paramInt3 + i1;
        }
        localView.layout(paramInt3, n, j, localView.getMeasuredHeight() + n);
        paramInt1 += localView.getWidth();
      }
      i += 1;
    }
    if (this.mFirstLayout)
    {
      if (this.mCanSlide)
      {
        if (this.mParallaxBy != 0) {
          parallaxOtherViews(this.mSlideOffset);
        }
        if (((LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset) {
          dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < m)
        {
          dimChildView(getChildAt(paramInt1), 0.0F, this.mSliderFadeColor);
          paramInt1 += 1;
        }
      }
      updateObscuredViewsVisibility(this.mSlideableView);
    }
    this.mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int k;
    int n;
    if (m != 1073741824)
    {
      if (isInEditMode())
      {
        if (m == -2147483648)
        {
          k = i;
          n = j;
          paramInt1 = paramInt2;
        }
        else
        {
          k = i;
          n = j;
          paramInt1 = paramInt2;
          if (m == 0)
          {
            k = 300;
            n = j;
            paramInt1 = paramInt2;
          }
        }
      }
      else {
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
      }
    }
    else
    {
      k = i;
      n = j;
      paramInt1 = paramInt2;
      if (j == 0) {
        if (isInEditMode())
        {
          k = i;
          n = j;
          paramInt1 = paramInt2;
          if (j == 0)
          {
            n = -2147483648;
            paramInt1 = 300;
            k = i;
          }
        }
        else
        {
          throw new IllegalStateException("Height must not be UNSPECIFIED");
        }
      }
    }
    if (n != -2147483648)
    {
      if (n != 1073741824)
      {
        paramInt1 = 0;
        paramInt2 = 0;
      }
      else
      {
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        paramInt2 = paramInt1;
      }
    }
    else
    {
      paramInt2 = paramInt1 - getPaddingTop() - getPaddingBottom();
      paramInt1 = 0;
    }
    int i2 = k - getPaddingLeft() - getPaddingRight();
    int i3 = getChildCount();
    if (i3 > 2) {
      Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
    }
    this.mSlideableView = null;
    m = i2;
    int i1 = 0;
    boolean bool1 = false;
    float f2 = 0.0F;
    View localView;
    LayoutParams localLayoutParams;
    int i4;
    for (i = paramInt1; i1 < i3; i = paramInt1)
    {
      localView = getChildAt(i1);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      float f1;
      if (localView.getVisibility() == 8)
      {
        localLayoutParams.dimWhenOffset = false;
        f1 = f2;
        paramInt1 = i;
      }
      else
      {
        f1 = f2;
        if (localLayoutParams.weight > 0.0F)
        {
          f2 += localLayoutParams.weight;
          f1 = f2;
          if (localLayoutParams.width == 0)
          {
            f1 = f2;
            paramInt1 = i;
            break label592;
          }
        }
        paramInt1 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        if (localLayoutParams.width == -2) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(i2 - paramInt1, -2147483648);
        } else if (localLayoutParams.width == -1) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(i2 - paramInt1, 1073741824);
        } else {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
        }
        if (localLayoutParams.height == -2) {
          j = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
        } else if (localLayoutParams.height == -1) {
          j = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        } else {
          j = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
        }
        localView.measure(paramInt1, j);
        j = localView.getMeasuredWidth();
        i4 = localView.getMeasuredHeight();
        paramInt1 = i;
        if (n == -2147483648)
        {
          paramInt1 = i;
          if (i4 > i) {
            paramInt1 = Math.min(i4, paramInt2);
          }
        }
        m -= j;
        boolean bool2;
        if (m < 0) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        localLayoutParams.slideable = bool2;
        if (localLayoutParams.slideable) {
          this.mSlideableView = localView;
        }
        bool1 = bool2 | bool1;
      }
      label592:
      i1 += 1;
      f2 = f1;
    }
    if ((bool1) || (f2 > 0.0F))
    {
      j = i2 - this.mOverhangSize;
      n = 0;
      while (n < i3)
      {
        localView = getChildAt(n);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (localView.getVisibility() != 8)
          {
            if ((localLayoutParams.width == 0) && (localLayoutParams.weight > 0.0F)) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            if (paramInt1 != 0) {
              i1 = 0;
            } else {
              i1 = localView.getMeasuredWidth();
            }
            if ((bool1) && (localView != this.mSlideableView))
            {
              if ((localLayoutParams.width < 0) && ((i1 > j) || (localLayoutParams.weight > 0.0F)))
              {
                if (paramInt1 != 0)
                {
                  if (localLayoutParams.height == -2) {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
                  } else if (localLayoutParams.height == -1) {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                  } else {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                  }
                }
                else {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                }
                localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), paramInt1);
              }
            }
            else if (localLayoutParams.weight > 0.0F)
            {
              if (localLayoutParams.width == 0)
              {
                if (localLayoutParams.height == -2) {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
                } else if (localLayoutParams.height == -1) {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                } else {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                }
              }
              else {
                paramInt1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
              }
              if (bool1)
              {
                i4 = i2 - (localLayoutParams.leftMargin + localLayoutParams.rightMargin);
                int i5 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                if (i1 != i4) {
                  localView.measure(i5, paramInt1);
                }
              }
              else
              {
                i4 = Math.max(0, m);
                localView.measure(View.MeasureSpec.makeMeasureSpec(i1 + (int)(localLayoutParams.weight * i4 / f2), 1073741824), paramInt1);
              }
            }
          }
        }
        n += 1;
      }
    }
    setMeasuredDimension(k, i + getPaddingTop() + getPaddingBottom());
    this.mCanSlide = bool1;
    if ((this.mDragHelper.getViewDragState() != 0) && (!bool1)) {
      this.mDragHelper.abort();
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
    LayoutParams localLayoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
    int j = this.mSlideableView.getWidth();
    int i = paramInt;
    if (bool) {
      i = getWidth() - paramInt - j;
    }
    if (bool) {
      paramInt = getPaddingRight();
    } else {
      paramInt = getPaddingLeft();
    }
    if (bool) {
      j = localLayoutParams.rightMargin;
    } else {
      j = localLayoutParams.leftMargin;
    }
    this.mSlideOffset = ((i - (paramInt + j)) / this.mSlideRange);
    if (this.mParallaxBy != 0) {
      parallaxOtherViews(this.mSlideOffset);
    }
    if (localLayoutParams.dimWhenOffset) {
      dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
    }
    dispatchOnPanelSlide(this.mSlideableView);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.isOpen) {
      openPane();
    } else {
      closePane();
    }
    this.mPreservedOpenState = paramParcelable.isOpen;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (isSlideable()) {
      bool = isOpen();
    } else {
      bool = this.mPreservedOpenState;
    }
    localSavedState.isOpen = bool;
    return localSavedState;
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
    if (!this.mCanSlide) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.mDragHelper.processTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      return true;
    case 1: 
      if (isDimmed(this.mSlideableView))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.mInitialMotionX;
        float f4 = f2 - this.mInitialMotionY;
        int i = this.mDragHelper.getTouchSlop();
        if ((f3 * f3 + f4 * f4 < i * i) && (this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2)))
        {
          closePane(this.mSlideableView, 0);
          return true;
        }
      }
      break;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
    }
    return true;
  }
  
  public boolean openPane()
  {
    return openPane(this.mSlideableView, 0);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide))
    {
      boolean bool;
      if (paramView1 == this.mSlideableView) {
        bool = true;
      } else {
        bool = false;
      }
      this.mPreservedOpenState = bool;
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
  
  public void setPanelSlideListener(@Nullable PanelSlideListener paramPanelSlideListener)
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
    Object localObject = (LayoutParams)this.mSlideableView.getLayoutParams();
    if (bool)
    {
      paramInt = getPaddingRight();
      int i = ((LayoutParams)localObject).rightMargin;
      int j = this.mSlideableView.getWidth();
      paramInt = (int)(getWidth() - (paramInt + i + paramFloat * this.mSlideRange + j));
    }
    else
    {
      paramInt = (int)(getPaddingLeft() + ((LayoutParams)localObject).leftMargin + paramFloat * this.mSlideRange);
    }
    localObject = this.mDragHelper;
    View localView = this.mSlideableView;
    if (((ViewDragHelper)localObject).smoothSlideViewTo(localView, paramInt, localView.getTop()))
    {
      setAllChildrenVisible();
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
    }
    return false;
  }
  
  void updateObscuredViewsVisibility(View paramView)
  {
    boolean bool = isLayoutRtlSupport();
    int i;
    if (bool) {
      i = getWidth() - getPaddingRight();
    } else {
      i = getPaddingLeft();
    }
    int j;
    if (bool) {
      j = getPaddingLeft();
    } else {
      j = getWidth() - getPaddingRight();
    }
    int i4 = getPaddingTop();
    int i5 = getHeight();
    int i6 = getPaddingBottom();
    int k;
    int m;
    int n;
    int i1;
    if ((paramView != null) && (viewIsOpaque(paramView)))
    {
      k = paramView.getLeft();
      m = paramView.getRight();
      n = paramView.getTop();
      i1 = paramView.getBottom();
    }
    else
    {
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
    }
    int i7 = getChildCount();
    int i2 = 0;
    while (i2 < i7)
    {
      View localView = getChildAt(i2);
      if (localView == paramView) {
        return;
      }
      if (localView.getVisibility() != 8)
      {
        if (bool) {
          i3 = j;
        } else {
          i3 = i;
        }
        int i8 = Math.max(i3, localView.getLeft());
        int i9 = Math.max(i4, localView.getTop());
        if (bool) {
          i3 = i;
        } else {
          i3 = j;
        }
        int i3 = Math.min(i3, localView.getRight());
        int i10 = Math.min(i5 - i6, localView.getBottom());
        if ((i8 >= k) && (i9 >= n) && (i3 <= m) && (i10 <= i1)) {
          i3 = 4;
        } else {
          i3 = 0;
        }
        localView.setVisibility(i3);
      }
      i2 += 1;
    }
  }
  
  class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private final Rect mTmpRect = new Rect();
    
    AccessibilityDelegate() {}
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = this.mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
      paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
      paramAccessibilityNodeInfoCompat1.setMovementGranularities(paramAccessibilityNodeInfoCompat2.getMovementGranularities());
    }
    
    public boolean filter(View paramView)
    {
      return SlidingPaneLayout.this.isDimmed(paramView);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
      copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
      localAccessibilityNodeInfoCompat.recycle();
      paramAccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
      paramAccessibilityNodeInfoCompat.setSource(paramView);
      paramView = ViewCompat.getParentForAccessibility(paramView);
      if ((paramView instanceof View)) {
        paramAccessibilityNodeInfoCompat.setParent((View)paramView);
      }
      int j = SlidingPaneLayout.this.getChildCount();
      int i = 0;
      while (i < j)
      {
        paramView = SlidingPaneLayout.this.getChildAt(i);
        if ((!filter(paramView)) && (paramView.getVisibility() == 0))
        {
          ViewCompat.setImportantForAccessibility(paramView, 1);
          paramAccessibilityNodeInfoCompat.addChild(paramView);
        }
        i += 1;
      }
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!filter(paramView)) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  private class DisableLayerRunnable
    implements Runnable
  {
    final View mChildView;
    
    DisableLayerRunnable(View paramView)
    {
      this.mChildView = paramView;
    }
    
    public void run()
    {
      if (this.mChildView.getParent() == SlidingPaneLayout.this)
      {
        this.mChildView.setLayerType(0, null);
        SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
      }
      SlidingPaneLayout.this.mPostedRunnables.remove(this);
    }
  }
  
  private class DragHelperCallback
    extends ViewDragHelper.Callback
  {
    DragHelperCallback() {}
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.mSlideableView.getLayoutParams();
      if (SlidingPaneLayout.this.isLayoutRtlSupport())
      {
        paramInt2 = SlidingPaneLayout.this.getWidth() - (SlidingPaneLayout.this.getPaddingRight() + paramView.rightMargin + SlidingPaneLayout.this.mSlideableView.getWidth());
        i = SlidingPaneLayout.this.mSlideRange;
        return Math.max(Math.min(paramInt1, paramInt2), paramInt2 - i);
      }
      paramInt2 = SlidingPaneLayout.this.getPaddingLeft() + paramView.leftMargin;
      int i = SlidingPaneLayout.this.mSlideRange;
      return Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return SlidingPaneLayout.this.mSlideRange;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, paramInt2);
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.setAllChildrenVisible();
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0)
      {
        if (SlidingPaneLayout.this.mSlideOffset == 0.0F)
        {
          localSlidingPaneLayout = SlidingPaneLayout.this;
          localSlidingPaneLayout.updateObscuredViewsVisibility(localSlidingPaneLayout.mSlideableView);
          localSlidingPaneLayout = SlidingPaneLayout.this;
          localSlidingPaneLayout.dispatchOnPanelClosed(localSlidingPaneLayout.mSlideableView);
          SlidingPaneLayout.this.mPreservedOpenState = false;
          return;
        }
        SlidingPaneLayout localSlidingPaneLayout = SlidingPaneLayout.this;
        localSlidingPaneLayout.dispatchOnPanelOpened(localSlidingPaneLayout.mSlideableView);
        SlidingPaneLayout.this.mPreservedOpenState = true;
      }
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      SlidingPaneLayout.this.onPanelDragged(paramInt1);
      SlidingPaneLayout.this.invalidate();
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int j;
      int i;
      if (SlidingPaneLayout.this.isLayoutRtlSupport())
      {
        j = SlidingPaneLayout.this.getPaddingRight() + localLayoutParams.rightMargin;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.mSlideOffset <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.mSlideRange;
        }
        j = SlidingPaneLayout.this.mSlideableView.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      else
      {
        i = SlidingPaneLayout.this.getPaddingLeft();
        j = localLayoutParams.leftMargin + i;
        if (paramFloat1 <= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.mSlideOffset <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.mSlideRange;
        }
      }
      SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(i, paramView.getTop());
      SlidingPaneLayout.this.invalidate();
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.this.mIsUnableToDrag) {
        return false;
      }
      return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).slideable;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] ATTRS = { 16843137 };
    Paint dimPaint;
    boolean dimWhenOffset;
    boolean slideable;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
      this.weight = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
    
    public LayoutParams(@NonNull LayoutParams paramLayoutParams)
    {
      super();
      this.weight = paramLayoutParams.weight;
    }
    
    public LayoutParams(@NonNull ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(@NonNull ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface PanelSlideListener
  {
    public abstract void onPanelClosed(@NonNull View paramView);
    
    public abstract void onPanelOpened(@NonNull View paramView);
    
    public abstract void onPanelSlide(@NonNull View paramView, float paramFloat);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public SlidingPaneLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new SlidingPaneLayout.SavedState(paramAnonymousParcel, null);
      }
      
      public SlidingPaneLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new SlidingPaneLayout.SavedState(paramAnonymousParcel, null);
      }
      
      public SlidingPaneLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new SlidingPaneLayout.SavedState[paramAnonymousInt];
      }
    };
    boolean isOpen;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.isOpen = bool;
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  public static class SimplePanelSlideListener
    implements SlidingPaneLayout.PanelSlideListener
  {
    public void onPanelClosed(View paramView) {}
    
    public void onPanelOpened(View paramView) {}
    
    public void onPanelSlide(View paramView, float paramFloat) {}
  }
  
  static abstract interface SlidingPanelLayoutImpl
  {
    public abstract void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
  }
  
  static class SlidingPanelLayoutImplBase
    implements SlidingPaneLayout.SlidingPanelLayoutImpl
  {
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      ViewCompat.postInvalidateOnAnimation(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    }
  }
  
  @RequiresApi(16)
  static class SlidingPanelLayoutImplJB
    extends SlidingPaneLayout.SlidingPanelLayoutImplBase
  {
    private Method mGetDisplayList;
    private Field mRecreateDisplayList;
    
    SlidingPanelLayoutImplJB()
    {
      try
      {
        this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
      }
      try
      {
        this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
        this.mRecreateDisplayList.setAccessible(true);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
      }
    }
    
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      if (this.mGetDisplayList != null)
      {
        Field localField = this.mRecreateDisplayList;
        if (localField != null)
        {
          try
          {
            localField.setBoolean(paramView, true);
            this.mGetDisplayList.invoke(paramView, (Object[])null);
          }
          catch (Exception localException)
          {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
          }
          super.invalidateChildRegion(paramSlidingPaneLayout, paramView);
          return;
        }
      }
      paramView.invalidate();
    }
  }
  
  @RequiresApi(17)
  static class SlidingPanelLayoutImplJBMR1
    extends SlidingPaneLayout.SlidingPanelLayoutImplBase
  {
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      ViewCompat.setLayerPaint(paramView, ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).dimPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */