package com.tencent.mobileqq.multiaio.widget;

import ajin;
import ajis;
import ajit;
import ajiu;
import ajiv;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultiAIOBaseViewPager
  extends ViewGroup
{
  private static final Comparator<c> COMPARATOR = new ajis();
  static final int[] LAYOUT_ATTRS = { 16842931 };
  private static final Interpolator sInterpolator = new ajit();
  private b jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$b;
  private final c jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$c = new c();
  private g jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$g;
  private h jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$h;
  private i jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$i;
  private final k jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$k = new d(this);
  private g b;
  private boolean coR = true;
  private int djm;
  protected int djn;
  private Scroller k;
  private int mActivePointerId = -1;
  PagerAdapter mAdapter;
  private List<f> mAdapterChangeListeners;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable = new MultiAIOBaseViewPager.3(this);
  private int mExpectedAdapterCount;
  private long mFakeDragBeginTime;
  private boolean mFakeDragging;
  private boolean mFirstLayout = true;
  private float mFirstOffset = -3.402824E+038F;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private boolean mIsScrollStarted;
  private boolean mIsUnableToDrag;
  private final ArrayList<c> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset = 3.4028235E+38F;
  private EdgeEffect mLeftEdge;
  private Drawable mMarginDrawable;
  protected int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets;
  private int mOffscreenPageLimit = 1;
  private List<g> mOnPageChangeListeners;
  private int mPageMargin;
  private int mPageTransformerLayerType;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState;
  private ClassLoader mRestoredClassLoader;
  private int mRestoredCurItem = -1;
  private EdgeEffect mRightEdge;
  private int mScrollState = 0;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private final Rect mTempRect = new Rect();
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public MultiAIOBaseViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public MultiAIOBaseViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private c a()
  {
    int i = getClientWidth();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int m;
    int j;
    Object localObject1;
    label53:
    Object localObject2;
    c localc;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label214;
      }
      f2 = this.mPageMargin / i;
      f4 = 0.0F;
      f3 = 0.0F;
      m = -1;
      i = 0;
      j = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i < this.mItems.size())
      {
        localc = (c)this.mItems.get(i);
        if ((j != 0) || (localc.position == m + 1)) {
          break label249;
        }
        localc = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$c;
        localc.offset = (f4 + f3 + f2);
        localc.position = (m + 1);
        localc.widthFactor = this.mAdapter.getPageWidth(localc.position);
        i -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localc.offset;
      f4 = localc.widthFactor;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i != this.mItems.size() - 1)) {
          break label219;
        }
        localObject2 = localc;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      m = localc.position;
      f4 = localc.widthFactor;
      j = 0;
      i += 1;
      localObject1 = localc;
      break label53;
    }
  }
  
  static void a(PagerAdapter paramPagerAdapter, DataSetObserver paramDataSetObserver)
  {
    try
    {
      Method localMethod = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[] { DataSetObserver.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramPagerAdapter, new Object[] { paramDataSetObserver });
      return;
    }
    catch (Exception paramPagerAdapter)
    {
      paramPagerAdapter.printStackTrace();
    }
  }
  
  private void a(c paramc1, int paramInt, c paramc2)
  {
    int n = this.mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramc2 == null) {
        break label409;
      }
      i = paramc2.position;
      if (i < paramc1.position)
      {
        f1 = paramc2.offset + paramc2.widthFactor + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramc1.position) || (j >= this.mItems.size())) {
          break label409;
        }
        for (paramc2 = (c)this.mItems.get(j);; paramc2 = (c)this.mItems.get(j))
        {
          m = i;
          f3 = f1;
          if (i <= paramc2.position) {
            break;
          }
          m = i;
          f3 = f1;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (m < paramc2.position)
        {
          f3 += this.mAdapter.getPageWidth(m) + f2;
          m += 1;
        }
        paramc2.offset = f3;
        f1 = f3 + (paramc2.widthFactor + f2);
        i = m + 1;
      }
    }
    if (i > paramc1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramc2.offset;
      i -= 1;
      while ((i >= paramc1.position) && (j >= 0))
      {
        for (paramc2 = (c)this.mItems.get(j);; paramc2 = (c)this.mItems.get(j))
        {
          m = i;
          f3 = f1;
          if (i >= paramc2.position) {
            break;
          }
          m = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (m > paramc2.position)
        {
          f3 -= this.mAdapter.getPageWidth(m) + f2;
          m -= 1;
        }
        f1 = f3 - (paramc2.widthFactor + f2);
        paramc2.offset = f1;
        i = m - 1;
      }
    }
    label409:
    int m = this.mItems.size();
    float f3 = paramc1.offset;
    i = paramc1.position - 1;
    if (paramc1.position == 0)
    {
      f1 = paramc1.offset;
      this.mFirstOffset = f1;
      if (paramc1.position != n - 1) {
        break label550;
      }
      f1 = paramc1.offset + paramc1.widthFactor - 1.0F;
      label475:
      this.mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label603;
      }
      paramc2 = (c)this.mItems.get(j);
      for (;;)
      {
        if (i > paramc2.position)
        {
          f1 -= this.mAdapter.getPageWidth(i) + f2;
          i -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label550:
          f1 = 3.4028235E+38F;
          break label475;
        }
      }
      f1 -= paramc2.widthFactor + f2;
      paramc2.offset = f1;
      if (paramc2.position == 0) {
        this.mFirstOffset = f1;
      }
      i -= 1;
      j -= 1;
    }
    label603:
    float f1 = paramc1.offset + paramc1.widthFactor + f2;
    int j = paramc1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < m)
    {
      paramc1 = (c)this.mItems.get(i);
      while (paramInt < paramc1.position)
      {
        f1 = this.mAdapter.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramc1.position == n - 1) {
        this.mLastOffset = (paramc1.widthFactor + f1 - 1.0F);
      }
      paramc1.offset = f1;
      f1 += paramc1.widthFactor + f2;
      paramInt += 1;
      i += 1;
    }
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    int i;
    if (this.mScrollState == 2)
    {
      i = 1;
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        if (this.mScroller.isFinished()) {
          break label170;
        }
      }
    }
    label170:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.mScroller.abortAnimation();
        j = getScrollX();
        m = getScrollY();
        int n = this.mScroller.getCurrX();
        int i1 = this.mScroller.getCurrY();
        if ((j != n) || (m != i1))
        {
          scrollTo(n, i1);
          if (n != j) {
            pageScrolled(n);
          }
        }
      }
      this.mPopulatePending = false;
      int m = 0;
      j = i;
      i = m;
      while (i < this.mItems.size())
      {
        c localc = (c)this.mItems.get(i);
        if (localc.scrolling)
        {
          localc.scrolling = false;
          j = 1;
        }
        i += 1;
      }
      i = 0;
      break;
    }
    if (j != 0)
    {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
      }
    }
    else {
      return;
    }
    this.mEndScrollRunnable.run();
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$g != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$g.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mOnPageChangeListeners != null)
    {
      int j = this.mOnPageChangeListeners.size();
      int i = 0;
      while (i < j)
      {
        g localg = (g)this.mOnPageChangeListeners.get(i);
        if (localg != null) {
          localg.onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i += 1;
      }
    }
    if (this.b != null) {
      this.b.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void dispatchOnPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$g != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$g.onPageSelected(paramInt);
    }
    if (this.mOnPageChangeListeners != null)
    {
      int j = this.mOnPageChangeListeners.size();
      int i = 0;
      while (i < j)
      {
        g localg = (g)this.mOnPageChangeListeners.get(i);
        if (localg != null) {
          localg.onPageSelected(paramInt);
        }
        i += 1;
      }
    }
    if (this.b != null) {
      this.b.onPageSelected(paramInt);
    }
  }
  
  private void dispatchOnScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$g != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$g.onPageScrollStateChanged(paramInt);
    }
    if (this.mOnPageChangeListeners != null)
    {
      int j = this.mOnPageChangeListeners.size();
      int i = 0;
      while (i < j)
      {
        g localg = (g)this.mOnPageChangeListeners.get(i);
        if (localg != null) {
          localg.onPageScrollStateChanged(paramInt);
        }
        i += 1;
      }
    }
    if (this.b != null) {
      this.b.onPageScrollStateChanged(paramInt);
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int m = getChildCount();
    int i = 0;
    if (i < m)
    {
      if (paramBoolean) {}
      for (int j = this.mPageTransformerLayerType;; j = 0)
      {
        getChildAt(i).setLayerType(j, null);
        i += 1;
        break;
      }
    }
  }
  
  private void endDrag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "endDrag() called");
    }
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private static boolean isDecorView(View paramView)
  {
    return paramView.getClass().getAnnotation(a.class) != null;
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.mGutterSize) && (paramFloat2 < 0.0F));
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      return;
    }
  }
  
  private boolean performDrag(float paramFloat)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int m = getClientWidth();
    paramFloat = m * this.mFirstOffset;
    f1 = m;
    float f3 = this.mLastOffset;
    c localc1 = (c)this.mItems.get(0);
    c localc2 = (c)this.mItems.get(this.mItems.size() - 1);
    if (localc1.position != 0) {
      paramFloat = localc1.offset * m;
    }
    for (int i = 0;; i = 1)
    {
      if (localc2.position != this.mAdapter.getCount() - 1) {
        f1 = localc2.offset * m;
      }
      for (int j = 0;; j = 1)
      {
        if (f2 < paramFloat)
        {
          if (i == 0) {
            break label249;
          }
          this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / m);
        }
        for (;;)
        {
          this.mLastMotionX += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          pageScrolled((int)paramFloat);
          return bool1;
          if (f2 > f1)
          {
            if (j != 0) {
              this.mRightEdge.onPull(Math.abs(f2 - f1) / m);
            }
            for (bool1 = bool2;; bool1 = false)
            {
              paramFloat = f1;
              break;
            }
          }
          paramFloat = f2;
          bool1 = false;
          continue;
          label249:
          bool1 = false;
        }
        f1 *= f3;
      }
    }
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      if (!this.mScroller.isFinished())
      {
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
      }
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int m = getPaddingLeft();
      int n = getPaddingRight();
      f = getScrollX() / (paramInt2 - m - n + paramInt4);
      scrollTo((int)((paramInt1 - i - j + paramInt3) * f), getScrollY());
      return;
    }
    c localc = a(this.mCurItem);
    if (localc != null) {}
    for (float f = Math.min(localc.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      completeScroll(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void removeNonDecorViews()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean resetTouch()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "resetTouch() called");
    }
    this.mActivePointerId = -1;
    endDrag();
    this.mLeftEdge.onRelease();
    this.mRightEdge.onRelease();
    return (this.mLeftEdge.isFinished()) || (this.mRightEdge.isFinished());
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    c localc = a(paramInt1);
    float f;
    if (localc != null) {
      f = getClientWidth();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(localc.offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        smoothScrollTo(i, 0, paramInt2);
        if (paramBoolean2) {
          dispatchOnPageSelected(paramInt1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiAIOBaseViewPager", 2, "scrollToItem() called with: item = [" + paramInt1 + "], smoothScroll = [" + paramBoolean1 + "], velocity = [" + paramInt2 + "], dispatchSelected = [" + paramBoolean2 + "]");
        }
        return;
      }
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
      completeScroll(false);
      scrollTo(i, 0);
      pageScrolled(i);
      return;
    }
  }
  
  public void QW(int paramInt)
  {
    this.mPopulatePending = true;
    int i = getClientWidth();
    int j = getScrollX();
    c localc = a();
    if (localc == null) {
      return;
    }
    setCurrentItemInternal(determineTargetPage(localc.position, (j / i - localc.offset) / localc.widthFactor, paramInt, this.mFlingDistance - 1), true, true, paramInt);
  }
  
  c a(int paramInt)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      c localc = (c)this.mItems.get(i);
      if (localc.position == paramInt) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  c a(int paramInt1, int paramInt2)
  {
    c localc = new c();
    localc.position = paramInt1;
    localc.object = this.mAdapter.instantiateItem(this, paramInt1);
    localc.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size()))
    {
      this.mItems.add(localc);
      return localc;
    }
    this.mItems.add(paramInt2, localc);
    return localc;
  }
  
  c a(View paramView)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      c localc = (c)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localc.object)) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public void a(g paramg)
  {
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramg);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int m = getDescendantFocusability();
    if (m != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          c localc = a(localView);
          if ((localc != null) && (localc.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((m == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        c localc = a(localView);
        if ((localc != null) && (localc.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      localLayoutParams.isDecor |= isDecorView(paramView);
      if (this.mInLayout)
      {
        if (localLayoutParams.isDecor) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.needsMeasure = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  protected boolean aqP()
  {
    return this.mFirstLayout;
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label329;
      }
      if (paramInt != 17) {
        break label266;
      }
      i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
      j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = pageLeft();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label375;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label382;
      }
      if (localObject != this) {}
    }
    label266:
    label329:
    label375:
    label382:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("MultiAIOBaseViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 66)
        {
          i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
          j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
          if ((localObject != null) && (i <= j))
          {
            bool = pageRight();
            break label89;
          }
          bool = localView.requestFocus();
          break label89;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = pageLeft();
            break label89;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = pageRight();
            break label89;
          }
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  c b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }
  
  public void b(g paramg)
  {
    if (this.mOnPageChangeListeners != null) {
      this.mOnPageChangeListeners.remove(paramg);
    }
  }
  
  public boolean beginFakeDrag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "beginFakeDrag() called");
    }
    if (this.mIsBeingDragged) {
      return false;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.mVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.mFakeDragBeginTime = l;
      return true;
      this.mVelocityTracker.clear();
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int m = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + m < localView.getTop()) || (paramInt3 + m >= localView.getBottom()) || (!canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + m - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (paramView.canScrollHorizontally(-paramInt1)))
    {
      View localView;
      return true;
      i -= 1;
      break;
    }
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.mAdapter == null) {}
    int i;
    int j;
    do
    {
      return false;
      i = getClientWidth();
      j = getScrollX();
      if (paramInt < 0)
      {
        if (j > (int)(i * this.mFirstOffset)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (j < (int)(i * this.mLastOffset)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.mIsScrollStarted = true;
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int m = this.mScroller.getCurrX();
      int n = this.mScroller.getCurrY();
      if ((i != m) || (j != n))
      {
        scrollTo(m, n);
        if (!pageScrolled(m))
        {
          this.mScroller.abortAnimation();
          scrollTo(0, n);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    completeScroll(true);
  }
  
  void dataSetChanged()
  {
    int i3 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i3;
    int i;
    int j;
    int m;
    int i1;
    int n;
    label67:
    Object localObject;
    int i2;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i3))
    {
      i = 1;
      j = this.mCurItem;
      m = 0;
      i1 = 0;
      n = i;
      i = j;
      j = m;
      m = i1;
      if (m >= this.mItems.size()) {
        break label299;
      }
      localObject = (c)this.mItems.get(m);
      i1 = this.mAdapter.getItemPosition(((c)localObject).object);
      if (i1 != -1) {
        break label157;
      }
      i1 = m;
      i2 = j;
      m = n;
      j = i;
      i = i2;
      n = i1;
    }
    for (;;)
    {
      i1 = m;
      i2 = j;
      m = n + 1;
      j = i;
      i = i2;
      n = i1;
      break label67;
      i = 0;
      break;
      label157:
      if (i1 == -2)
      {
        this.mItems.remove(m);
        n = m - 1;
        m = j;
        if (j == 0)
        {
          this.mAdapter.startUpdate(this);
          m = 1;
        }
        this.mAdapter.destroyItem(this, ((c)localObject).position, ((c)localObject).object);
        if (this.mCurItem == ((c)localObject).position)
        {
          j = Math.max(0, Math.min(this.mCurItem, i3 - 1));
          i = m;
          m = 1;
        }
      }
      else
      {
        if (((c)localObject).position != i1)
        {
          if (((c)localObject).position == this.mCurItem) {
            i = i1;
          }
          ((c)localObject).position = i1;
          i1 = i;
          i2 = 1;
          n = m;
          i = j;
          j = i1;
          m = i2;
          continue;
          label299:
          if (j != 0) {
            this.mAdapter.finishUpdate(this);
          }
          Collections.sort(this.mItems, COMPARATOR);
          if (n != 0)
          {
            m = getChildCount();
            j = 0;
            while (j < m)
            {
              localObject = (LayoutParams)getChildAt(j).getLayoutParams();
              if (!((LayoutParams)localObject).isDecor) {
                ((LayoutParams)localObject).widthFactor = 0.0F;
              }
              j += 1;
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
          }
          return;
        }
        i1 = i;
        i2 = n;
        n = m;
        i = j;
        j = i1;
        m = i2;
        continue;
      }
      j = i;
      i1 = 1;
      i = m;
      m = i1;
    }
  }
  
  protected int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0)
        {
          c localc1 = (c)this.mItems.get(0);
          c localc2 = (c)this.mItems.get(this.mItems.size() - 1);
          paramInt2 = Math.max(localc1.position, Math.min(paramInt1, localc2.position));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.mCurItem) {}
    for (float f = 0.4F;; f = 0.6F)
    {
      paramInt1 += (int)(f + paramFloat);
      break;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        c localc = a(localView);
        if ((localc != null) && (localc.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int m = 0;
    int i = 0;
    int n = getOverScrollMode();
    boolean bool;
    if ((n == 0) || ((n == 1) && (this.mAdapter != null) && (this.mAdapter.getCount() > 1)))
    {
      int j;
      if (!this.mLeftEdge.isFinished())
      {
        m = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        n = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.mFirstOffset * n);
        this.mLeftEdge.setSize(i, n);
        j = false | this.mLeftEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
      m = j;
      if (!this.mRightEdge.isFinished())
      {
        n = paramCanvas.save();
        m = getWidth();
        int i1 = getHeight();
        int i2 = getPaddingTop();
        int i3 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * m);
        this.mRightEdge.setSize(i1 - i2 - i3, m);
        bool = j | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(n);
      }
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      this.mLeftEdge.finish();
      this.mRightEdge.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void dxM()
  {
    if (this.mScroller != null) {
      this.mScroller.abortAnimation();
    }
  }
  
  public void endFakeDrag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "endFakeDrag() called");
    }
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    if (this.mAdapter != null)
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      Object localObject = this.mVelocityTracker;
      ((VelocityTracker)localObject).clear();
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
      int i = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
      this.mPopulatePending = true;
      int j = getClientWidth();
      int m = getScrollX();
      localObject = a();
      if (localObject == null) {
        return;
      }
      determineTargetPage(((c)localObject).position, (m / j - ((c)localObject).offset) / ((c)localObject).widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX));
    }
    endDrag();
    this.mFakeDragging = false;
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      return false;
      if (paramKeyEvent.hasModifiers(2)) {
        return pageLeft();
      }
      return arrowScroll(17);
      if (paramKeyEvent.hasModifiers(2)) {
        return pageRight();
      }
      return arrowScroll(66);
      if (paramKeyEvent.hasNoModifiers()) {
        return arrowScroll(2);
      }
    } while (!paramKeyEvent.hasModifiers(1));
    return arrowScroll(1);
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "fakeDragBy() called with: xOffset = [" + paramFloat + "]");
    }
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    if (this.mAdapter == null) {
      return;
    }
    this.mLastMotionX += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i = getClientWidth();
    paramFloat = i;
    float f4 = this.mFirstOffset;
    float f1 = i;
    float f3 = this.mLastOffset;
    Object localObject = (c)this.mItems.get(0);
    c localc = (c)this.mItems.get(this.mItems.size() - 1);
    if (((c)localObject).position != 0) {}
    for (paramFloat = ((c)localObject).offset * i;; paramFloat *= f4)
    {
      if (localc.position != this.mAdapter.getCount() - 1) {}
      for (f1 = localc.offset * i;; f1 *= f3)
      {
        if (f2 < paramFloat) {}
        for (;;)
        {
          this.mLastMotionX += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          pageScrolled((int)paramFloat);
          long l = SystemClock.uptimeMillis();
          localObject = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
          if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
          }
          this.mVelocityTracker.addMovement((MotionEvent)localObject);
          ((MotionEvent)localObject).recycle();
          return;
          if (f2 > f1) {
            paramFloat = f1;
          } else {
            paramFloat = f2;
          }
        }
      }
    }
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
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem()
  {
    return this.mCurItem;
  }
  
  public int getPageMargin()
  {
    return this.mPageMargin;
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  void initViewPager()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.mScroller = new Scroller(localContext, sInterpolator);
    this.k = new Scroller(getContext());
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.djn = ajin.s(getContext(), this.mMaximumVelocity);
    this.mMaximumVelocity = this.djn;
    this.mLeftEdge = new EdgeEffect(localContext);
    this.mRightEdge = new EdgeEffect(localContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(16.0F * f));
    ViewCompat.setAccessibilityDelegate(this, new e());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setOnApplyWindowInsetsListener(this, new ajiu(this));
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  public boolean isScrollFinished()
  {
    if (this.mScroller != null) {
      return this.mScroller.isFinished();
    }
    return true;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mEndScrollRunnable);
    if ((this.mScroller != null) && (!this.mScroller.isFinished())) {
      this.mScroller.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m;
    int n;
    float f3;
    Object localObject;
    float f1;
    int i1;
    int i;
    int i2;
    int j;
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      m = getScrollX();
      n = getWidth();
      f3 = this.mPageMargin / n;
      localObject = (c)this.mItems.get(0);
      f1 = ((c)localObject).offset;
      i1 = this.mItems.size();
      i = ((c)localObject).position;
      i2 = ((c)this.mItems.get(i1 - 1)).position;
      j = 0;
    }
    for (;;)
    {
      float f2;
      if (i < i2)
      {
        while ((i > ((c)localObject).position) && (j < i1))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (c)((ArrayList)localObject).get(j);
        }
        if (i != ((c)localObject).position) {
          break label271;
        }
        f2 = (((c)localObject).offset + ((c)localObject).widthFactor) * n;
      }
      label271:
      float f4;
      for (f1 = ((c)localObject).offset + ((c)localObject).widthFactor + f3;; f1 += f4 + f3)
      {
        if (this.mPageMargin + f2 > m)
        {
          this.mMarginDrawable.setBounds(Math.round(f2), this.mTopPageBounds, Math.round(this.mPageMargin + f2), this.mBottomPageBounds);
          this.mMarginDrawable.draw(paramCanvas);
        }
        if (f2 <= m + n) {
          break;
        }
        return;
        f4 = this.mAdapter.getPageWidth(i);
        f2 = (f1 + f4) * n;
      }
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1)) {
      resetTouch();
    }
    do
    {
      return false;
      if (i == 0) {
        break;
      }
      if (this.mIsBeingDragged) {
        return true;
      }
    } while (this.mIsUnableToDrag);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      return this.mIsBeingDragged;
      i = this.mActivePointerId;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        if ((i >= 0) && (i <= paramMotionEvent.getPointerCount() - 1))
        {
          float f1 = this.mLastMotionX;
          try
          {
            f2 = paramMotionEvent.getX(i);
            f1 = f2;
            f4 = f1 - this.mLastMotionX;
            f5 = Math.abs(f4);
            f2 = this.mLastMotionY;
          }
          catch (Exception localException1)
          {
            try
            {
              f3 = paramMotionEvent.getY(i);
              f2 = f3;
              f3 = Math.abs(f2 - this.mInitialMotionY);
              if ((f4 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f4)) && (canScroll(this, false, (int)f4, (int)f1, (int)f2)))
              {
                this.mLastMotionX = f1;
                this.mLastMotionY = f2;
                this.mIsUnableToDrag = true;
                return false;
                localException1 = localException1;
                QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", localException1);
              }
            }
            catch (Exception localException2)
            {
              float f2;
              float f4;
              float f5;
              float f3;
              for (;;)
              {
                QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", localException2);
              }
              if ((f5 > this.mTouchSlop) && (0.5F * f5 > f3))
              {
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
                if (f4 > 0.0F)
                {
                  f3 = this.mInitialMotionX + this.mTouchSlop;
                  label351:
                  this.mLastMotionX = f3;
                  this.mLastMotionY = f2;
                  setScrollingCacheEnabled(true);
                }
              }
              while ((this.mIsBeingDragged) && (performDrag(f1)))
              {
                ViewCompat.postInvalidateOnAnimation(this);
                break;
                f3 = this.mInitialMotionX - this.mTouchSlop;
                break label351;
                if (f3 > this.mTouchSlop) {
                  this.mIsUnableToDrag = true;
                }
              }
            }
          }
          f1 = paramMotionEvent.getX();
          this.mInitialMotionX = f1;
          this.mLastMotionX = f1;
          f1 = paramMotionEvent.getY();
          this.mInitialMotionY = f1;
          this.mLastMotionY = f1;
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mIsUnableToDrag = false;
          this.mIsScrollStarted = true;
          this.mScroller.computeScrollOffset();
          if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
          {
            i = 1;
            label516:
            if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$b != null) {
              if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$b.aqL()) {
                break label599;
              }
            }
          }
          label599:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label605;
            }
            this.mScroller.abortAnimation();
            if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$b != null) {
              this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$b.abortAnimation();
            }
            this.mPopulatePending = false;
            populate();
            this.mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
            break;
            i = 0;
            break label516;
          }
          label605:
          completeScroll(false);
          this.mIsBeingDragged = false;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = getChildCount();
    int i4 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i5 = getScrollX();
    int j = 0;
    int n = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i6;
    int m;
    label154:
    int i1;
    if (n < i2)
    {
      localView = getChildAt(n);
      if (localView.getVisibility() == 8) {
        break label671;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.isDecor) {
        break label671;
      }
      paramInt4 = localLayoutParams.gravity;
      i6 = localLayoutParams.gravity;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        m = paramInt2;
        switch (i6 & 0x70)
        {
        default: 
          i1 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i1;
          label204:
          paramInt4 += i5;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          j += 1;
          paramInt4 = i;
          paramInt3 = m;
          i = paramInt1;
          paramInt1 = j;
        }
        break;
      }
    }
    for (;;)
    {
      n += 1;
      m = paramInt3;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i;
      i = paramInt4;
      paramInt2 = m;
      break;
      m = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      m += paramInt2;
      break label154;
      paramInt4 = Math.max((i4 - localView.getMeasuredWidth()) / 2, paramInt2);
      m = paramInt2;
      break label154;
      m = localView.getMeasuredWidth();
      paramInt4 = i + localView.getMeasuredWidth();
      i1 = i4 - i - m;
      i = paramInt4;
      m = paramInt2;
      paramInt4 = i1;
      break label154;
      i1 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i1 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i1;
      break label204;
      i1 = Math.max((i3 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i1;
      break label204;
      i1 = i3 - paramInt3 - localView.getMeasuredHeight();
      i6 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i6;
      paramInt3 = i1;
      break label204;
      i = i4 - paramInt2 - i;
      paramInt4 = 0;
      while (paramInt4 < i2)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.isDecor)
          {
            c localc = a(localView);
            if (localc != null)
            {
              float f = i;
              m = (int)(localc.offset * f) + paramInt2;
              if (localLayoutParams.needsMeasure)
              {
                localLayoutParams.needsMeasure = false;
                f = i;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(m, paramInt1, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt4 += 1;
      }
      this.mTopPageBounds = paramInt1;
      this.mBottomPageBounds = (i3 - paramInt3);
      this.mDecorChildCount = j;
      if (this.mFirstLayout) {
        scrollToItem(this.mCurItem, false, 0, false);
      }
      this.mFirstLayout = false;
      return;
      label671:
      paramInt4 = j;
      j = paramInt1;
      m = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i;
      i = paramInt3;
      paramInt2 = j;
      paramInt3 = m;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i5 = getChildCount();
    int m = 0;
    View localView;
    int i;
    int j;
    LayoutParams localLayoutParams;
    int n;
    int i2;
    label183:
    int i1;
    if (m < i5)
    {
      localView = getChildAt(m);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.isDecor)
          {
            i = localLayoutParams.gravity & 0x7;
            n = localLayoutParams.gravity & 0x70;
            i2 = -2147483648;
            j = -2147483648;
            if ((n != 48) && (n != 80)) {
              break label333;
            }
            n = 1;
            if ((i != 3) && (i != 5)) {
              break label339;
            }
            i1 = 1;
            label198:
            if (n == 0) {
              break label345;
            }
            i = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label538;
            }
            i2 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label532;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i4;
      if (localLayoutParams.height != -2)
      {
        i3 = 1073741824;
        j = i3;
        if (localLayoutParams.height != -1)
        {
          i4 = localLayoutParams.height;
          j = i3;
        }
      }
      for (int i3 = i4;; i3 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i2), View.MeasureSpec.makeMeasureSpec(i3, j));
        if (n != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          m += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label333:
          n = 0;
          break label183;
          label339:
          i1 = 0;
          break label198;
          label345:
          i = i2;
          if (i1 == 0) {
            break label208;
          }
          j = 1073741824;
          i = i2;
          break label208;
          i = paramInt1;
          j = paramInt2;
          if (i1 != 0)
          {
            i = paramInt1 - localView.getMeasuredWidth();
            j = paramInt2;
          }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i = getChildCount();
        paramInt2 = 0;
        if (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.isDecor)) {
              if (localLayoutParams == null) {
                break label521;
              }
            }
          }
        }
        label521:
        for (float f = localLayoutParams.widthFactor;; f = 0.0F)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f * paramInt1), 1073741824), this.mChildHeightMeasureSpec);
          paramInt2 += 1;
          break;
          return;
        }
      }
      label532:
      i = paramInt1;
      continue;
      label538:
      i2 = i;
      i = paramInt1;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    View localView;
    if (this.mDecorChildCount > 0)
    {
      int i2 = getScrollX();
      i = getPaddingLeft();
      int j = getPaddingRight();
      int i3 = getWidth();
      int i4 = getChildCount();
      int i1 = 0;
      while (i1 < i4)
      {
        localView = getChildAt(i1);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int n;
        int m;
        if (!localLayoutParams.isDecor)
        {
          n = i;
          m = j;
          i1 += 1;
          i = n;
          j = m;
        }
        else
        {
          switch (localLayoutParams.gravity & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            m = i;
            n = j;
            j = i;
            i = n;
          }
          for (;;)
          {
            int i5 = m + i2 - localView.getLeft();
            m = i;
            n = j;
            if (i5 == 0) {
              break;
            }
            localView.offsetLeftAndRight(i5);
            m = i;
            n = j;
            break;
            m = localView.getWidth();
            n = m + i;
            m = i;
            i = j;
            j = n;
            continue;
            m = Math.max((i3 - localView.getMeasuredWidth()) / 2, i);
            n = i;
            i = j;
            j = n;
            continue;
            m = i3 - j - localView.getMeasuredWidth();
            i5 = localView.getMeasuredWidth();
            n = i;
            i = j + i5;
            j = n;
          }
        }
      }
    }
    dispatchOnPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$h != null)
    {
      paramInt2 = getScrollX();
      i = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i)
      {
        localView = getChildAt(paramInt1);
        if (((LayoutParams)localView.getLayoutParams()).isDecor) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
          this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$h.transformPage(localView, paramFloat);
        }
      }
    }
    this.mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int m = -1;
    int j = getChildCount();
    int i;
    if ((paramInt & 0x2) != 0)
    {
      m = 1;
      i = 0;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        c localc = a(localView);
        if ((localc != null) && (localc.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          j = -1;
          continue;
        }
      }
      i += m;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mAdapter != null)
    {
      this.mAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
      setCurrentItemInternal(paramParcelable.position, false, true);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.adapterState;
    this.mRestoredClassLoader = paramParcelable.loader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    if (this.mAdapter != null) {
      localSavedState.adapterState = this.mAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    int i = 0;
    boolean bool2 = false;
    if (this.mFakeDragging) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramMotionEvent.getAction() != 0) {
            break;
          }
          bool1 = bool2;
        } while (paramMotionEvent.getEdgeFlags() != 0);
        bool1 = bool2;
      } while (this.mAdapter == null);
      bool1 = bool2;
    } while (this.mAdapter.getCount() == 0);
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    boolean bool1 = bool3;
    label144:
    float f1;
    float f2;
    label336:
    Object localObject;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool3;
    case 4: 
    case 0: 
    case 2: 
      label375:
      do
      {
        for (;;)
        {
          if (bool1) {
            ViewCompat.postInvalidateOnAnimation(this);
          }
          return true;
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          f1 = paramMotionEvent.getX();
          this.mInitialMotionX = f1;
          this.mLastMotionX = f1;
          f1 = paramMotionEvent.getY();
          this.mInitialMotionY = f1;
          this.mLastMotionY = f1;
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          bool1 = bool3;
          continue;
          if (this.mIsBeingDragged) {
            break label375;
          }
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i != -1) {
            break;
          }
          bool1 = resetTouch();
        }
        f1 = paramMotionEvent.getX(i);
        float f3 = Math.abs(f1 - this.mLastMotionX);
        f2 = paramMotionEvent.getY(i);
        float f4 = Math.abs(f2 - this.mLastMotionY);
        if ((f3 > this.mTouchSlop) && (f3 > f4))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          if (f1 - this.mInitialMotionX <= 0.0F) {
            break;
          }
          f1 = this.mInitialMotionX + this.mTouchSlop;
          this.mLastMotionX = f1;
          this.mLastMotionY = f2;
          setScrollState(1);
          setScrollingCacheEnabled(true);
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
        }
        bool1 = bool3;
      } while (!this.mIsBeingDragged);
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i == -1) {
        break;
      }
    }
    for (bool1 = performDrag(paramMotionEvent.getX(i)) | false;; bool1 = false)
    {
      for (;;)
      {
        for (;;)
        {
          break label144;
          f1 = this.mInitialMotionX - this.mTouchSlop;
          break label336;
          bool1 = bool3;
          if (!this.mIsBeingDragged) {
            break label144;
          }
          localObject = this.mVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
          int j = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
          this.mPopulatePending = true;
          int n = getClientWidth();
          int i1 = getScrollX();
          localObject = a();
          bool1 = bool2;
          if (localObject == null) {
            break;
          }
          f1 = this.mPageMargin / n;
          int m = ((c)localObject).position;
          f2 = (i1 / n - ((c)localObject).offset) / (((c)localObject).widthFactor + f1);
          n = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          f1 = this.mLastMotionX;
          if (n != -1) {
            f1 = paramMotionEvent.getX(n);
          }
          n = (int)(f1 - this.mInitialMotionX);
          if ((Math.abs(n) > this.mFlingDistance * 4) && (Math.abs(j) > this.mMinimumVelocity)) {
            i = 1;
          }
          for (;;)
          {
            bool1 = resetTouch();
            if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$b != null)) {
              this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$b.QQ(j);
            }
            break;
            setCurrentItemInternal(determineTargetPage(m, f2, j, n), true, true, j);
          }
          bool1 = bool3;
          if (!this.mIsBeingDragged) {
            break label144;
          }
          scrollToItem(this.mCurItem, true, 0, false);
          bool1 = resetTouch();
          break label144;
          i = paramMotionEvent.getActionIndex();
          try
          {
            this.mLastMotionX = paramMotionEvent.getX(i);
            this.mActivePointerId = paramMotionEvent.getPointerId(i);
            bool1 = bool3;
          }
          catch (Exception paramMotionEvent)
          {
            QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", paramMotionEvent);
            bool1 = bool3;
          }
        }
        break label144;
        onSecondaryPointerUp(paramMotionEvent);
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        try
        {
          this.mLastMotionX = paramMotionEvent.getX(i);
          bool1 = bool3;
        }
        catch (Exception paramMotionEvent)
        {
          QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", paramMotionEvent);
          bool1 = bool3;
        }
      }
      break label144;
    }
  }
  
  boolean pageLeft()
  {
    if (this.mCurItem > 0)
    {
      setCurrentItem(this.mCurItem - 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageRight()
  {
    if ((this.mAdapter != null) && (this.mCurItem < this.mAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageScrolled(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "pageScrolled() called with: xpos = [" + paramInt + "]");
    }
    if (this.mItems.size() == 0) {
      if (!this.mFirstLayout) {}
    }
    c localc;
    do
    {
      do
      {
        return false;
        this.mCalledSuper = false;
        onPageScrolled(0, 0.0F, 0);
      } while (this.mCalledSuper);
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      localc = a();
    } while (localc == null);
    int j = getClientWidth();
    int m = this.mPageMargin;
    float f = this.mPageMargin / j;
    int i = localc.position;
    f = (paramInt / j - localc.offset) / (localc.widthFactor + f);
    paramInt = (int)((m + j) * f);
    this.mCalledSuper = false;
    onPageScrolled(i, f, paramInt);
    if (!this.mCalledSuper) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    return true;
  }
  
  void populate()
  {
    populate(this.mCurItem);
  }
  
  public void populate(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "populate() called with: newCurrentItem = [" + paramInt + "]");
    }
    Object localObject2;
    if (this.mCurItem != paramInt)
    {
      localObject2 = a(this.mCurItem);
      this.mCurItem = paramInt;
    }
    for (;;)
    {
      if (this.mAdapter == null) {
        sortChildDrawingOrder();
      }
      do
      {
        return;
        if (this.mPopulatePending)
        {
          sortChildDrawingOrder();
          return;
        }
      } while (getWindowToken() == null);
      this.mAdapter.startUpdate(this);
      paramInt = this.mOffscreenPageLimit;
      int i3 = Math.max(0, this.mCurItem - paramInt);
      int i1 = this.mAdapter.getCount();
      int i2 = Math.min(i1 - 1, paramInt + this.mCurItem);
      Object localObject1;
      if (i1 != this.mExpectedAdapterCount) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + i1 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.mItems.size())
      {
        localObject1 = (c)this.mItems.get(paramInt);
        if (((c)localObject1).position >= this.mCurItem) {
          if (((c)localObject1).position != this.mCurItem) {
            break label1267;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i1 > 0)) {}
        for (Object localObject3 = a(this.mCurItem, paramInt);; localObject3 = localObject1)
        {
          int n;
          label360:
          int i4;
          label373:
          int i;
          float f3;
          int m;
          int j;
          Object localObject4;
          float f1;
          if (localObject3 != null)
          {
            n = paramInt - 1;
            if (n < 0) {
              break label641;
            }
            localObject1 = (c)this.mItems.get(n);
            i4 = getClientWidth();
            if (i4 > 0) {
              break label647;
            }
            f2 = 0.0F;
            i = this.mCurItem;
            f3 = 0.0F;
            m = i - 1;
            j = paramInt;
            localObject4 = localObject1;
            if (m >= 0)
            {
              if ((f3 < f2) || (m >= i3)) {
                break label802;
              }
              if (localObject4 != null) {
                break label668;
              }
            }
            f1 = ((c)localObject3).widthFactor;
            paramInt = j + 1;
            if (f1 < 2.0F)
            {
              if (paramInt >= this.mItems.size()) {
                break label922;
              }
              localObject1 = (c)this.mItems.get(paramInt);
              label460:
              if (i4 > 0) {
                break label928;
              }
            }
          }
          label641:
          label647:
          label668:
          label928:
          for (float f2 = 0.0F;; f2 = getPaddingRight() / i4 + 2.0F)
          {
            i = this.mCurItem;
            i += 1;
            label479:
            if (i < i1)
            {
              if ((f1 < f2) || (i <= i2)) {
                break label1024;
              }
              if (localObject1 != null) {
                break label943;
              }
            }
            a((c)localObject3, j, (c)localObject2);
            this.mAdapter.setPrimaryItem(this, this.mCurItem, ((c)localObject3).object);
            this.mAdapter.finishUpdate(this);
            i = getChildCount();
            paramInt = 0;
            while (paramInt < i)
            {
              localObject2 = getChildAt(paramInt);
              localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
              ((LayoutParams)localObject1).childIndex = paramInt;
              if ((!((LayoutParams)localObject1).isDecor) && (((LayoutParams)localObject1).widthFactor == 0.0F))
              {
                localObject2 = a((View)localObject2);
                if (localObject2 != null)
                {
                  ((LayoutParams)localObject1).widthFactor = ((c)localObject2).widthFactor;
                  ((LayoutParams)localObject1).position = ((c)localObject2).position;
                }
              }
              paramInt += 1;
            }
            paramInt += 1;
            break;
            localObject1 = null;
            break label360;
            f2 = 2.0F - ((c)localObject3).widthFactor + getPaddingLeft() / i4;
            break label373;
            localObject1 = localObject4;
            paramInt = n;
            f1 = f3;
            i = j;
            if (m == localObject4.position)
            {
              localObject1 = localObject4;
              paramInt = n;
              f1 = f3;
              i = j;
              if (!localObject4.scrolling)
              {
                this.mItems.remove(n);
                this.mAdapter.destroyItem(this, m, localObject4.object);
                paramInt = n - 1;
                i = j - 1;
                if (paramInt < 0) {
                  break label793;
                }
                localObject1 = (c)this.mItems.get(paramInt);
                f1 = f3;
              }
            }
            for (;;)
            {
              m -= 1;
              localObject4 = localObject1;
              n = paramInt;
              f3 = f1;
              j = i;
              break;
              localObject1 = null;
              f1 = f3;
              continue;
              label802:
              if ((localObject4 != null) && (m == localObject4.position))
              {
                f1 = f3 + localObject4.widthFactor;
                paramInt = n - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (c)this.mItems.get(paramInt);
                  i = j;
                }
                else
                {
                  localObject1 = null;
                  i = j;
                }
              }
              else
              {
                f1 = f3 + a(m, n + 1).widthFactor;
                i = j + 1;
                if (n >= 0)
                {
                  localObject1 = (c)this.mItems.get(n);
                  paramInt = n;
                }
                else
                {
                  localObject1 = null;
                  paramInt = n;
                }
              }
            }
            localObject1 = null;
            break label460;
          }
          label793:
          label922:
          label943:
          if ((i == ((c)localObject1).position) && (!((c)localObject1).scrolling))
          {
            this.mItems.remove(paramInt);
            this.mAdapter.destroyItem(this, i, ((c)localObject1).object);
            if (paramInt < this.mItems.size()) {
              localObject1 = (c)this.mItems.get(paramInt);
            }
          }
          for (;;)
          {
            i += 1;
            break label479;
            localObject1 = null;
            continue;
            label1024:
            if ((localObject1 != null) && (i == ((c)localObject1).position))
            {
              f3 = ((c)localObject1).widthFactor;
              paramInt += 1;
              if (paramInt < this.mItems.size()) {}
              for (localObject1 = (c)this.mItems.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = a(i, paramInt);
            paramInt += 1;
            f3 = ((c)localObject1).widthFactor;
            if (paramInt < this.mItems.size()) {}
            for (localObject1 = (c)this.mItems.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            sortChildDrawingOrder();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = b((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((c)localObject1).position == this.mCurItem)) {
                break label1255;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1249;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = a((View)localObject1);
                if ((localObject2 != null) && (((c)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(2))) {
                  break;
                }
                paramInt += 1;
              }
              label1249:
              break;
            }
            label1255:
            break;
          }
        }
        label1267:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    int j = 0;
    int i;
    if (this.mAdapter != null)
    {
      a(this.mAdapter, null);
      this.mAdapter.startUpdate(this);
      i = 0;
      while (i < this.mItems.size())
      {
        localObject = (c)this.mItems.get(i);
        this.mAdapter.destroyItem(this, ((c)localObject).position, ((c)localObject).object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      this.djm = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    boolean bool;
    if (this.mAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$i == null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$i = new i();
      }
      a(this.mAdapter, this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$i);
      this.mPopulatePending = false;
      bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem < 0) {
        break label305;
      }
      this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
      setCurrentItemInternal(this.mRestoredCurItem, false, true);
      this.mRestoredCurItem = -1;
      this.mRestoredAdapterState = null;
      this.mRestoredClassLoader = null;
    }
    while ((this.mAdapterChangeListeners != null) && (!this.mAdapterChangeListeners.isEmpty()))
    {
      int m = this.mAdapterChangeListeners.size();
      i = j;
      while (i < m)
      {
        ((f)this.mAdapterChangeListeners.get(i)).a(this, (PagerAdapter)localObject, paramPagerAdapter);
        i += 1;
      }
      label305:
      if (!bool) {
        populate();
      } else {
        requestLayout();
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.mPopulatePending = false;
    if (!this.mFirstLayout) {}
    for (boolean bool = true;; bool = false)
    {
      setCurrentItemInternal(paramInt, bool, false);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    setCurrentItem(paramInt, paramBoolean, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.djm == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.mOffscreenPageLimit;
      if ((i <= this.mCurItem + paramInt1) && (i >= this.mCurItem - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.mItems.size())
      {
        ((c)this.mItems.get(paramInt1)).scrolling = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount()) {
        i = this.mAdapter.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.djm != i) {
      paramBoolean2 = true;
    }
    if (this.mFirstLayout)
    {
      this.mCurItem = i;
      this.djm = this.mCurItem;
      if (paramBoolean2) {
        dispatchOnPageSelected(i);
      }
      requestLayout();
      return;
    }
    populate(i);
    this.djm = this.mCurItem;
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public void setFlingListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$b = paramb;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      Log.w("MultiAIOBaseViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(g paramg)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$g = paramg;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  public void setPageTransformer(boolean paramBoolean, h paramh)
  {
    setPageTransformer(paramBoolean, paramh, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, h paramh, int paramInt)
  {
    int j = 1;
    boolean bool1;
    boolean bool2;
    label20:
    int i;
    if (paramh != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$h == null) {
        break label80;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label86;
      }
      i = 1;
      label30:
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$h = paramh;
      setChildrenDrawingOrderEnabled(bool1);
      if (!bool1) {
        break label92;
      }
      if (paramBoolean) {
        j = 2;
      }
      this.mDrawingOrder = j;
      this.mPageTransformerLayerType = paramInt;
    }
    for (;;)
    {
      if (i != 0) {
        populate();
      }
      return;
      bool1 = false;
      break;
      label80:
      bool2 = false;
      break label20;
      label86:
      i = 0;
      break label30;
      label92:
      this.mDrawingOrder = 0;
    }
  }
  
  void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$h != null) {
      if (paramInt == 0) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      enableLayers(bool);
      dispatchOnScrollStateChanged(paramInt);
      return;
    }
  }
  
  void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if ((this.mScroller != null) && (!this.mScroller.isFinished()))
    {
      i = 1;
      if (i == 0) {
        break label125;
      }
      if (!this.mIsScrollStarted) {
        break label113;
      }
      i = this.mScroller.getCurrX();
      label54:
      this.mScroller.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    int j;
    int m;
    for (;;)
    {
      j = getScrollY();
      m = paramInt1 - i;
      paramInt2 -= j;
      if ((m != 0) || (paramInt2 != 0)) {
        break label134;
      }
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
      i = 0;
      break;
      label113:
      i = this.mScroller.getStartX();
      break label54;
      label125:
      i = getScrollX();
    }
    label134:
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int n = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(m) * 1.0F / paramInt1);
    float f1 = n;
    float f2 = n;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(m) / (f1 * f2 + this.mPageMargin) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.mIsScrollStarted = false;
      this.mScroller.startScroll(i, j, m, paramInt2, paramInt1);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
    }
  }
  
  protected void sortChildDrawingOrder()
  {
    if (this.mDrawingOrder != 0)
    {
      if (this.mDrawingOrderedChildren == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.mDrawingOrderedChildren.add(localView);
          i += 1;
        }
        this.mDrawingOrderedChildren.clear();
      }
      Collections.sort(this.mDrawingOrderedChildren, this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$k);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, MultiAIOBaseViewPager.LAYOUT_ATTRS);
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new ajiv();
    Parcelable adapterState;
    ClassLoader loader;
    int position;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.adapterState = paramParcel.readParcelable(localClassLoader);
      this.loader = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.adapterState, paramInt);
    }
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface a {}
  
  public static abstract interface b
  {
    public abstract void QQ(int paramInt);
    
    public abstract void abortAnimation();
    
    public abstract boolean aqL();
  }
  
  public static class c
  {
    Object object;
    float offset;
    public int position;
    boolean scrolling;
    float widthFactor;
  }
  
  static class d
    extends MultiAIOBaseViewPager.k
  {
    private final MultiAIOBaseViewPager a;
    
    public d(MultiAIOBaseViewPager paramMultiAIOBaseViewPager)
    {
      this.a = paramMultiAIOBaseViewPager;
    }
    
    public int compare(View paramView1, View paramView2)
    {
      paramView1 = (MultiAIOBaseViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (MultiAIOBaseViewPager.LayoutParams)paramView2.getLayoutParams();
      if (paramView1.isDecor != paramView2.isDecor)
      {
        if (paramView1.isDecor) {
          return 1;
        }
        return -1;
      }
      int i = this.a.getCurrentItem();
      if (i == paramView1.position) {
        return 1;
      }
      if (i == paramView2.position) {
        return -1;
      }
      return paramView1.position - paramView2.position;
    }
  }
  
  class e
    extends AccessibilityDelegateCompat
  {
    e() {}
    
    private boolean canScroll()
    {
      return (MultiAIOBaseViewPager.this.mAdapter != null) && (MultiAIOBaseViewPager.this.mAdapter.getCount() > 1);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(MultiAIOBaseViewPager.class.getName());
      paramAccessibilityEvent.setScrollable(canScroll());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (MultiAIOBaseViewPager.this.mAdapter != null))
      {
        paramAccessibilityEvent.setItemCount(MultiAIOBaseViewPager.this.mAdapter.getCount());
        paramAccessibilityEvent.setFromIndex(MultiAIOBaseViewPager.this.mCurItem);
        paramAccessibilityEvent.setToIndex(MultiAIOBaseViewPager.this.mCurItem);
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(MultiAIOBaseViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (MultiAIOBaseViewPager.this.canScrollHorizontally(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (MultiAIOBaseViewPager.this.canScrollHorizontally(-1)) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        if (MultiAIOBaseViewPager.this.canScrollHorizontally(1))
        {
          MultiAIOBaseViewPager.this.setCurrentItem(MultiAIOBaseViewPager.this.mCurItem + 1);
          return true;
        }
        return false;
      }
      if (MultiAIOBaseViewPager.this.canScrollHorizontally(-1))
      {
        MultiAIOBaseViewPager.this.setCurrentItem(MultiAIOBaseViewPager.this.mCurItem - 1);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface f
  {
    public abstract void a(MultiAIOBaseViewPager paramMultiAIOBaseViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  public static abstract interface g
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  public static abstract interface h
  {
    public abstract void transformPage(View paramView, float paramFloat);
  }
  
  class i
    extends DataSetObserver
  {
    i() {}
    
    public void onChanged()
    {
      MultiAIOBaseViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated()
    {
      MultiAIOBaseViewPager.this.dataSetChanged();
    }
  }
  
  public static class j
    implements MultiAIOBaseViewPager.g
  {
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt) {}
  }
  
  static class k
    implements Comparator<View>
  {
    public int compare(View paramView1, View paramView2)
    {
      paramView1 = (MultiAIOBaseViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (MultiAIOBaseViewPager.LayoutParams)paramView2.getLayoutParams();
      if (paramView1.isDecor != paramView2.isDecor)
      {
        if (paramView1.isDecor) {
          return 1;
        }
        return -1;
      }
      return paramView1.position - paramView2.position;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager
 * JD-Core Version:    0.7.0.1
 */