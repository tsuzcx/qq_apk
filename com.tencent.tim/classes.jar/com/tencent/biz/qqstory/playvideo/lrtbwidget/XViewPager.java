package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import qku;
import qkv;
import qkw;
import qkx;
import qky;
import ram;

public class XViewPager
  extends ViewGroup
{
  private static final Comparator<b> COMPARATOR;
  private static final int[] LAYOUT_ATTRS = { 16842931 };
  private static final k jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$k = new k();
  private static final Interpolator sInterpolator;
  public String TAG = "XViewPager" + System.identityHashCode(this);
  private EdgeEffectCompat jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat;
  private final b jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$b = new b();
  private d jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$d;
  private e jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$e;
  private g jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$g;
  private h jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h;
  private i jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$i;
  private boolean aDQ;
  private boolean aDR;
  private boolean aDS = true;
  private boolean aDT = true;
  private boolean aDU;
  private boolean aDV;
  private boolean aDW;
  private EdgeEffectCompat jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat;
  private f jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f;
  private h jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h;
  private int bmT = -1;
  private int bmU = 1;
  private int bmV;
  private int bmW;
  private int bmX;
  private int bmY;
  private f c;
  private int mActivePointerId = -1;
  private PagerAdapter mAdapter;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  private int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable = new XViewPager.3(this);
  private int mExpectedAdapterCount;
  private boolean mFakeDragging;
  private boolean mFirstLayout = true;
  private float mFirstOffset = -3.402824E+038F;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private boolean mIsUnableToDrag;
  private final ArrayList<b> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset = 3.4028235E+38F;
  private EdgeEffectCompat mLeftEdge;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets;
  private int mOffscreenPageLimit = 1;
  private List<f> mOnPageChangeListeners;
  private int mPageMargin;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState;
  private ClassLoader mRestoredClassLoader;
  private int mRestoredCurItem = -1;
  private EdgeEffectCompat mRightEdge;
  private int mScrollState = 0;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private Method mSetChildrenDrawingOrderEnabled;
  private final Rect mTempRect = new Rect();
  private int mTopPageBounds;
  protected int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private float mj = 0.6F;
  
  static
  {
    COMPARATOR = new qku();
    sInterpolator = new qkv();
  }
  
  public XViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public XViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private boolean JP()
  {
    return (this.aDS) && (this.aDT);
  }
  
  private boolean JQ()
  {
    return (Gravity.isHorizontal(this.bmX)) || (((!this.aDS) && (!this.aDT)) || ((this.bmX == 0) || (!JR())));
  }
  
  private boolean JR()
  {
    return (Gravity.isVertical(this.bmX)) || (((!this.aDQ) && (!this.aDR)) || ((this.bmX == 0) || (!JQ())));
  }
  
  private b a()
  {
    Object localObject2;
    if (JR()) {
      localObject2 = b();
    }
    int i;
    float f1;
    label37:
    float f2;
    label52:
    float f4;
    float f3;
    int k;
    int j;
    Object localObject1;
    label69:
    do
    {
      return localObject2;
      i = getClientWidth();
      if (i <= 0) {
        break;
      }
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label226;
      }
      f2 = this.mPageMargin / i;
      f4 = 0.0F;
      f3 = 0.0F;
      k = -1;
      i = 0;
      j = 1;
      localObject1 = null;
      localObject2 = localObject1;
    } while (i >= this.mItems.size());
    b localb = (b)this.mItems.get(i);
    if ((j == 0) && (localb.position != k + 1))
    {
      localb = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$b;
      localb.offset = (f4 + f3 + f2);
      localb.position = (k + 1);
      localb.widthFactor = this.mAdapter.getPageWidth(localb.position);
      i -= 1;
    }
    for (;;)
    {
      f3 = localb.offset;
      f4 = localb.widthFactor;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {
          break;
        }
      }
      if ((f1 < f4 + f3 + f2) || (i == this.mItems.size() - 1))
      {
        return localb;
        f1 = 0.0F;
        break label37;
        label226:
        f2 = 0.0F;
        break label52;
      }
      k = localb.position;
      f4 = localb.widthFactor;
      j = 0;
      localObject1 = localb;
      i += 1;
      break label69;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject = a(paramInt1);
    float f;
    if (localObject != null) {
      f = sH();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(((b)localObject).offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        smoothScrollTo(0, i, paramInt2);
        if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f != null)) {
          this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageSelected(paramInt1);
        }
        if ((paramBoolean2) && (this.mOnPageChangeListeners != null))
        {
          i = this.mOnPageChangeListeners.size();
          paramInt2 = j;
          while (paramInt2 < i)
          {
            localObject = (f)this.mOnPageChangeListeners.get(paramInt2);
            if (localObject != null) {
              ((f)localObject).onPageSelected(paramInt1);
            }
            paramInt2 += 1;
          }
        }
        if ((paramBoolean2) && (this.c != null)) {
          this.c.onPageSelected(paramInt1);
        }
        return;
      }
      if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f != null)) {
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageSelected(paramInt1);
      }
      if ((paramBoolean2) && (this.mOnPageChangeListeners != null))
      {
        j = this.mOnPageChangeListeners.size();
        paramInt2 = 0;
        while (paramInt2 < j)
        {
          localObject = (f)this.mOnPageChangeListeners.get(paramInt2);
          if (localObject != null) {
            ((f)localObject).onPageSelected(paramInt1);
          }
          paramInt2 += 1;
        }
      }
      if ((paramBoolean2) && (this.c != null)) {
        this.c.onPageSelected(paramInt1);
      }
      completeScroll(false);
      scrollTo(0, i);
      eG(i);
      return;
    }
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    int m = this.mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramb2 == null) {
        break label409;
      }
      i = paramb2.position;
      if (i < paramb1.position)
      {
        f1 = paramb2.offset + paramb2.widthFactor + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramb1.position) || (j >= this.mItems.size())) {
          break label409;
        }
        for (paramb2 = (b)this.mItems.get(j);; paramb2 = (b)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramb2.position)
        {
          f3 += this.mAdapter.getPageWidth(k) + f2;
          k += 1;
        }
        paramb2.offset = f3;
        f1 = f3 + (paramb2.widthFactor + f2);
        i = k + 1;
      }
    }
    if (i > paramb1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramb2.offset;
      i -= 1;
      while ((i >= paramb1.position) && (j >= 0))
      {
        for (paramb2 = (b)this.mItems.get(j);; paramb2 = (b)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramb2.position)
        {
          f3 -= this.mAdapter.getPageWidth(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramb2.widthFactor + f2);
        paramb2.offset = f1;
        i = k - 1;
      }
    }
    label409:
    int k = this.mItems.size();
    float f3 = paramb1.offset;
    i = paramb1.position - 1;
    if (paramb1.position == 0)
    {
      f1 = paramb1.offset;
      this.mFirstOffset = f1;
      if (paramb1.position != m - 1) {
        break label550;
      }
      f1 = paramb1.offset + paramb1.widthFactor - 1.0F;
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
      paramb2 = (b)this.mItems.get(j);
      for (;;)
      {
        if (i > paramb2.position)
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
      f1 -= paramb2.widthFactor + f2;
      paramb2.offset = f1;
      if (paramb2.position == 0) {
        this.mFirstOffset = f1;
      }
      i -= 1;
      j -= 1;
    }
    label603:
    float f1 = paramb1.offset + paramb1.widthFactor + f2;
    int j = paramb1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramb1 = (b)this.mItems.get(i);
      while (paramInt < paramb1.position)
      {
        f1 = this.mAdapter.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramb1.position == m - 1) {
        this.mLastOffset = (paramb1.widthFactor + f1 - 1.0F);
      }
      paramb1.offset = f1;
      f1 += paramb1.widthFactor + f2;
      paramInt += 1;
      i += 1;
    }
    this.mNeedCalculatePageOffsets = false;
  }
  
  private b b()
  {
    int i = sH();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int k;
    int j;
    Object localObject1;
    label53:
    Object localObject2;
    b localb;
    if (i > 0)
    {
      f1 = getScrollY() / i;
      if (i <= 0) {
        break label214;
      }
      f2 = this.mPageMargin / i;
      f4 = 0.0F;
      f3 = 0.0F;
      k = -1;
      i = 0;
      j = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i < this.mItems.size())
      {
        localb = (b)this.mItems.get(i);
        if ((j != 0) || (localb.position == k + 1)) {
          break label249;
        }
        localb = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$b;
        localb.offset = (f4 + f3 + f2);
        localb.position = (k + 1);
        localb.widthFactor = this.mAdapter.getPageWidth(localb.position);
        i -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localb.offset;
      f4 = localb.widthFactor;
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
        localObject2 = localb;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      k = localb.position;
      f4 = localb.widthFactor;
      j = 0;
      i += 1;
      localObject1 = localb;
      break label53;
    }
  }
  
  private void b(b paramb1, int paramInt, b paramb2)
  {
    int m = this.mAdapter.getCount();
    int i = sH();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramb2 == null) {
        break label409;
      }
      i = paramb2.position;
      if (i < paramb1.position)
      {
        f1 = paramb2.offset + paramb2.widthFactor + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramb1.position) || (j >= this.mItems.size())) {
          break label409;
        }
        for (paramb2 = (b)this.mItems.get(j);; paramb2 = (b)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramb2.position)
        {
          f3 += this.mAdapter.getPageWidth(k) + f2;
          k += 1;
        }
        paramb2.offset = f3;
        f1 = f3 + (paramb2.widthFactor + f2);
        i = k + 1;
      }
    }
    if (i > paramb1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramb2.offset;
      i -= 1;
      while ((i >= paramb1.position) && (j >= 0))
      {
        for (paramb2 = (b)this.mItems.get(j);; paramb2 = (b)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramb2.position)
        {
          f3 -= this.mAdapter.getPageWidth(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramb2.widthFactor + f2);
        paramb2.offset = f1;
        i = k - 1;
      }
    }
    label409:
    int k = this.mItems.size();
    float f3 = paramb1.offset;
    i = paramb1.position - 1;
    if (paramb1.position == 0)
    {
      f1 = paramb1.offset;
      this.mFirstOffset = f1;
      if (paramb1.position != m - 1) {
        break label550;
      }
      f1 = paramb1.offset + paramb1.widthFactor - 1.0F;
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
      paramb2 = (b)this.mItems.get(j);
      for (;;)
      {
        if (i > paramb2.position)
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
      f1 -= paramb2.widthFactor + f2;
      paramb2.offset = f1;
      if (paramb2.position == 0) {
        this.mFirstOffset = f1;
      }
      i -= 1;
      j -= 1;
    }
    label603:
    float f1 = paramb1.offset + paramb1.widthFactor + f2;
    int j = paramb1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramb1 = (b)this.mItems.get(i);
      while (paramInt < paramb1.position)
      {
        f1 = this.mAdapter.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramb1.position == m - 1) {
        this.mLastOffset = (paramb1.widthFactor + f1 - 1.0F);
      }
      paramb1.offset = f1;
      f1 += paramb1.widthFactor + f2;
      paramInt += 1;
      i += 1;
    }
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void boN()
  {
    int m = getChildCount();
    int n = getClientWidth();
    int i1 = sH();
    int k = 0;
    int i = 0;
    View localView;
    b localb;
    float f;
    int i2;
    int i3;
    if (k < m)
    {
      localView = getChildAt(k);
      if ((localView.getVisibility() == 8) || (((LayoutParams)localView.getLayoutParams()).isDecor)) {
        break label336;
      }
      localb = a(localView);
      if (localb == null) {
        break label336;
      }
      if (Gravity.isHorizontal(this.bmX))
      {
        f = n;
        i2 = (int)(localb.offset * f);
        i3 = getPaddingLeft();
        j = getPaddingTop();
        i3 = i2 + i3 - localView.getLeft();
        i2 = j - localView.getTop();
        if (i3 == 0) {
          break label339;
        }
        localView.offsetLeftAndRight(i3);
      }
    }
    label309:
    label336:
    label339:
    for (int j = 1;; j = i)
    {
      if (i2 != 0)
      {
        localView.offsetTopAndBottom(i2);
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        this.aDV = false;
        i = j;
      }
      for (;;)
      {
        k += 1;
        break;
        if (Gravity.isVertical(this.bmX))
        {
          f = i1;
          i2 = (int)(localb.offset * f);
          i3 = getPaddingTop();
          j = getPaddingLeft();
          i3 = i2 + i3 - localView.getTop();
          i2 = j - localView.getLeft();
          if (i3 != 0) {
            localView.offsetTopAndBottom(i3);
          }
          for (j = 1;; j = i)
          {
            if (i2 != 0)
            {
              localView.offsetLeftAndRight(i2);
              j = 1;
            }
            i = j;
            if (j == 0) {
              break;
            }
            this.aDV = true;
            i = j;
            break;
            if (i != 0)
            {
              if (!Gravity.isHorizontal(this.bmX)) {
                break label309;
              }
              scrollToItem(this.mCurItem, false, 0, false);
            }
            while (!Gravity.isVertical(this.bmX)) {
              return;
            }
            a(this.mCurItem, false, 0, false);
            return;
          }
        }
      }
    }
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    if (this.mScrollState == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        this.mScroller.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.mScroller.getCurrX();
        int n = this.mScroller.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.mPopulatePending = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.mItems.size())
      {
        b localb = (b)this.mItems.get(i);
        if (localb.scrolling)
        {
          localb.scrolling = false;
          j = 1;
        }
        i += 1;
      }
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
  
  private boolean d(float paramFloat)
  {
    int j = 1;
    boN();
    float f1 = this.mLastMotionY;
    this.mLastMotionY = paramFloat;
    f1 = getScrollY() + (f1 - paramFloat);
    int k = sH();
    paramFloat = k * this.mFirstOffset;
    float f2 = k;
    float f3 = this.mLastOffset;
    b localb1 = (b)this.mItems.get(0);
    b localb2 = (b)this.mItems.get(this.mItems.size() - 1);
    if (localb1.position != 0) {
      paramFloat = localb1.offset * k;
    }
    for (int i = 0;; i = 1)
    {
      if (localb2.position != this.mAdapter.getCount() - 1)
      {
        f2 = localb2.offset * k;
        j = 0;
      }
      for (;;)
      {
        if (f1 < paramFloat) {
          if (i == 0) {
            break label276;
          }
        }
        label276:
        for (boolean bool1 = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(paramFloat - f1) / k);; bool1 = false)
        {
          boolean bool2 = bool1;
          if (this.aDU)
          {
            paramFloat = f1;
            bool2 = bool1;
          }
          for (;;)
          {
            this.mLastMotionY += paramFloat - (int)paramFloat;
            scrollTo(0, (int)paramFloat);
            eG((int)paramFloat);
            return bool2;
            if (f1 > f2)
            {
              if (j != 0) {}
              for (bool2 = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(f1 - f2) / k);; bool2 = false)
              {
                if (this.aDU)
                {
                  paramFloat = f1;
                  break;
                }
                paramFloat = f2;
                break;
              }
            }
            paramFloat = f1;
            bool2 = false;
          }
        }
        f2 *= f3;
      }
    }
  }
  
  private void dV(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getScrollX(), paramInt2 });
    localValueAnimator.setDuration(this.bmY);
    localValueAnimator.addUpdateListener(new qkw(this));
    localValueAnimator.addListener(new qkx(this));
    localValueAnimator.start();
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0)
        {
          if (this.mOffscreenPageLimit != 0) {
            break;
          }
          paramInt2 = Math.max(0, Math.min(paramInt1, this.mAdapter.getCount()));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.mCurItem) {}
    for (float f = 1.0F - this.mj;; f = this.mj)
    {
      paramInt1 = (int)(f + (paramInt1 + paramFloat));
      break;
    }
    b localb1 = (b)this.mItems.get(0);
    b localb2 = (b)this.mItems.get(this.mItems.size() - 1);
    return Math.max(localb1.position, Math.min(paramInt1, localb2.position));
  }
  
  private boolean eG(int paramInt)
  {
    boolean bool = false;
    if (this.mItems.size() == 0)
    {
      this.mCalledSuper = false;
      b(0, 0.0F, 0);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      b localb = a();
      int j = sH();
      int k = this.mPageMargin;
      float f = this.mPageMargin / j;
      int i = localb.position;
      f = (paramInt / j - localb.offset) / (localb.widthFactor + f);
      paramInt = (int)((k + j) * f);
      this.mCalledSuper = false;
      b(i, f, paramInt);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      if (paramBoolean) {}
      for (int j = 2;; j = 0)
      {
        ViewCompat.setLayerType(getChildAt(i), j, null);
        i += 1;
        break;
      }
    }
  }
  
  private void endDrag()
  {
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
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.mGutterSize) && (paramFloat2 < 0.0F));
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId) {
      if (i != 0) {
        break label65;
      }
    }
    label65:
    for (i = 1;; i = 0)
    {
      this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
      this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, i);
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      return;
    }
  }
  
  private boolean pageScrolled(int paramInt)
  {
    boolean bool = false;
    if (this.mItems.size() == 0)
    {
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      b localb = a();
      int j = getClientWidth();
      int k = this.mPageMargin;
      float f = this.mPageMargin / j;
      int i = localb.position;
      f = (paramInt / j - localb.offset) / (localb.widthFactor + f);
      paramInt = (int)((k + j) * f);
      this.mCalledSuper = false;
      onPageScrolled(i, f, paramInt);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private boolean performDrag(float paramFloat)
  {
    int j = 1;
    boN();
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    f1 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * this.mFirstOffset;
    float f2 = k;
    float f3 = this.mLastOffset;
    b localb1 = (b)this.mItems.get(0);
    b localb2 = (b)this.mItems.get(this.mItems.size() - 1);
    if (localb1.position != 0) {
      paramFloat = localb1.offset * k;
    }
    for (int i = 0;; i = 1)
    {
      if (localb2.position != this.mAdapter.getCount() - 1)
      {
        f2 = localb2.offset * k;
        j = 0;
      }
      for (;;)
      {
        if (f1 < paramFloat) {
          if (i == 0) {
            break label359;
          }
        }
        label318:
        label359:
        for (boolean bool1 = this.mLeftEdge.onPull(Math.abs(paramFloat - f1) / k);; bool1 = false)
        {
          boolean bool2 = bool1;
          if (this.aDU)
          {
            paramFloat = f1;
            bool2 = bool1;
          }
          for (;;)
          {
            f1 = paramFloat;
            if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$e != null)
            {
              f1 = paramFloat;
              if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$e.JS())
              {
                i = getWidth() * (getCurrentItem() - 1);
                if ((this.bmX != 3) || (paramFloat >= i)) {
                  break label318;
                }
                f1 = i;
              }
            }
            label240:
            this.mLastMotionX += f1 - (int)f1;
            scrollTo((int)f1, 0);
            pageScrolled((int)f1);
            return bool2;
            if (f1 > f2)
            {
              if (j != 0) {}
              for (bool2 = this.mRightEdge.onPull(Math.abs(f1 - f2) / k);; bool2 = false)
              {
                if (this.aDU)
                {
                  paramFloat = f1;
                  break;
                }
                paramFloat = f2;
                break;
                f1 = paramFloat;
                if (this.bmX != 5) {
                  break label240;
                }
                f1 = paramFloat;
                if (paramFloat <= i) {
                  break label240;
                }
                f1 = i;
                break label240;
              }
            }
            paramFloat = f1;
            bool2 = false;
          }
        }
        f2 *= f3;
      }
    }
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(paramInt2, getScrollY());
      if (!this.mScroller.isFinished())
      {
        paramInt3 = this.mScroller.getDuration();
        paramInt4 = this.mScroller.timePassed();
        localb = a(this.mCurItem);
        if (localb != null) {
          this.mScroller.startScroll(paramInt2, 0, (int)(localb.offset * paramInt1), 0, paramInt3 - paramInt4);
        }
      }
      return;
    }
    b localb = a(this.mCurItem);
    if (localb != null) {}
    for (float f = Math.min(localb.offset, this.mLastOffset);; f = 0.0F)
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
  
  private boolean rz()
  {
    return (this.aDQ) && (this.aDR);
  }
  
  private void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingTop();
      int j = getPaddingBottom();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      f = getScrollY() / (paramInt2 - k - m + paramInt4);
      paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(getScrollX(), paramInt2);
      if (!this.mScroller.isFinished())
      {
        paramInt3 = this.mScroller.getDuration();
        paramInt4 = this.mScroller.timePassed();
        localb = a(this.mCurItem);
        if (localb != null) {
          this.mScroller.startScroll(0, paramInt2, 0, (int)(localb.offset * paramInt1), paramInt3 - paramInt4);
        }
      }
      return;
    }
    b localb = a(this.mCurItem);
    if (localb != null) {}
    for (float f = Math.min(localb.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingTop() - getPaddingBottom()));
      if (paramInt1 == getScrollY()) {
        break;
      }
      completeScroll(false);
      scrollTo(getScrollX(), paramInt1);
      return;
    }
  }
  
  private int sH()
  {
    return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject = a(paramInt1);
    float f;
    if (localObject != null) {
      f = getClientWidth();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(((b)localObject).offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        smoothScrollTo(i, 0, paramInt2);
        if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f != null)) {
          this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageSelected(paramInt1);
        }
        if ((paramBoolean2) && (this.mOnPageChangeListeners != null))
        {
          i = this.mOnPageChangeListeners.size();
          paramInt2 = j;
          while (paramInt2 < i)
          {
            localObject = (f)this.mOnPageChangeListeners.get(paramInt2);
            if (localObject != null) {
              ((f)localObject).onPageSelected(paramInt1);
            }
            paramInt2 += 1;
          }
        }
        if ((paramBoolean2) && (this.c != null)) {
          this.c.onPageSelected(paramInt1);
        }
        return;
      }
      if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f != null)) {
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageSelected(paramInt1);
      }
      if ((paramBoolean2) && (this.mOnPageChangeListeners != null))
      {
        j = this.mOnPageChangeListeners.size();
        paramInt2 = 0;
        while (paramInt2 < j)
        {
          localObject = (f)this.mOnPageChangeListeners.get(paramInt2);
          if (localObject != null) {
            ((f)localObject).onPageSelected(paramInt1);
          }
          paramInt2 += 1;
        }
      }
      if ((paramBoolean2) && (this.c != null)) {
        this.c.onPageSelected(paramInt1);
      }
      completeScroll(false);
      if (this.aDW)
      {
        dV(paramInt1, i);
        return;
      }
      scrollTo(i, 0);
      pageScrolled(i);
      return;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    int i = 0;
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h != null) {
      if (paramInt == 0) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      enableLayers(bool);
      if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageScrollStateChanged(paramInt);
      }
      if (this.mOnPageChangeListeners == null) {
        break;
      }
      int j = this.mOnPageChangeListeners.size();
      while (i < j)
      {
        f localf = (f)this.mOnPageChangeListeners.get(i);
        if (localf != null) {
          localf.onPageScrollStateChanged(paramInt);
        }
        i += 1;
      }
      break;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
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
      Collections.sort(this.mDrawingOrderedChildren, jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$k);
    }
  }
  
  private boolean x(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getHeight() - this.mGutterSize) && (paramFloat2 < 0.0F));
  }
  
  public b a(int paramInt)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      b localb = (b)this.mItems.get(i);
      if (localb.position == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  b a(int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.position = paramInt1;
    localb.object = this.mAdapter.instantiateItem(this, paramInt1);
    localb.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size()))
    {
      this.mItems.add(localb);
      return localb;
    }
    this.mItems.add(paramInt2, localb);
    return localb;
  }
  
  b a(View paramView)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      b localb = (b)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localb.object)) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  public void a(f paramf)
  {
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramf);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i4 = getScrollY();
    int j = 0;
    int m = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i;
    int i5;
    int k;
    label154:
    int n;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label693;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.isDecor) {
        break label693;
      }
      i = localLayoutParams.gravity;
      i5 = localLayoutParams.gravity;
      switch (i & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        i = paramInt2;
        k = paramInt2;
        switch (i5 & 0x70)
        {
        default: 
          n = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = n;
          label204:
          paramInt3 += i4;
          localView.layout(i, paramInt3, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt3);
          j += 1;
          paramInt3 = k;
          i = paramInt1;
          paramInt1 = j;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      k = paramInt3;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i;
      paramInt2 = k;
      break;
      k = localView.getMeasuredWidth();
      i = paramInt2;
      k += paramInt2;
      break label154;
      i = Math.max((i2 - localView.getMeasuredWidth()) / 2, paramInt2);
      k = paramInt2;
      break label154;
      k = localView.getMeasuredWidth();
      i = paramInt4 + localView.getMeasuredWidth();
      n = i2 - paramInt4 - k;
      paramInt4 = i;
      k = paramInt2;
      i = n;
      break label154;
      n = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      n += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
      break label204;
      n = Math.max((i3 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = n;
      break label204;
      n = i3 - paramInt3 - localView.getMeasuredHeight();
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i5;
      paramInt3 = n;
      break label204;
      k = i3 - paramInt1 - paramInt3;
      i = 0;
      while (i < i1)
      {
        localView = getChildAt(i);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.isDecor)
          {
            b localb = a(localView);
            if (localb != null)
            {
              float f = k;
              m = (int)(localb.offset * f) + paramInt1;
              if (localLayoutParams.needsMeasure)
              {
                localLayoutParams.needsMeasure = false;
                n = View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 - paramInt4, 1073741824);
                f = k;
                localView.measure(n, View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824));
              }
              localView.layout(paramInt2, m, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + m);
            }
          }
        }
        i += 1;
      }
      this.mTopPageBounds = paramInt1;
      this.bmV = paramInt2;
      this.mBottomPageBounds = (i3 - paramInt3);
      this.bmW = (i2 - paramInt4);
      this.mDecorChildCount = j;
      if ((this.mFirstLayout) || (!this.aDV)) {
        a(this.mCurItem, false, 0, false);
      }
      this.mFirstLayout = false;
      this.aDV = true;
      return;
      label693:
      i = j;
      j = paramInt1;
      k = paramInt2;
      paramInt1 = i;
      i = paramInt3;
      paramInt2 = j;
      paramInt3 = k;
    }
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
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
        localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollVertically(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i -= 1;
      break;
    }
    return false;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList == null) {}
    int j;
    int k;
    do
    {
      return;
      j = paramArrayList.size();
      k = getDescendantFocusability();
      if (k != 393216)
      {
        int i = 0;
        while (i < getChildCount())
        {
          View localView = getChildAt(i);
          if (localView.getVisibility() == 0)
          {
            b localb = a(localView);
            if ((localb != null) && (localb.position == this.mCurItem)) {
              localView.addFocusables(paramArrayList, paramInt1, paramInt2);
            }
          }
          i += 1;
        }
      }
    } while (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable()) || (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())));
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
        b localb = a(localView);
        if ((localb != null) && (localb.position == this.mCurItem)) {
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
      localLayoutParams.isDecor |= paramView instanceof a;
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
  
  protected void ak(Canvas paramCanvas)
  {
    int k;
    int m;
    float f3;
    Object localObject;
    float f1;
    int n;
    int i;
    int i1;
    int j;
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      k = getScrollY();
      m = getHeight();
      f3 = this.mPageMargin / m;
      localObject = (b)this.mItems.get(0);
      f1 = ((b)localObject).offset;
      n = this.mItems.size();
      i = ((b)localObject).position;
      i1 = ((b)this.mItems.get(n - 1)).position;
      j = 0;
    }
    for (;;)
    {
      float f2;
      if (i < i1)
      {
        while ((i > ((b)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (b)((ArrayList)localObject).get(j);
        }
        if (i != ((b)localObject).position) {
          break label266;
        }
        f2 = (((b)localObject).offset + ((b)localObject).widthFactor) * m;
      }
      label266:
      float f4;
      for (f1 = ((b)localObject).offset + ((b)localObject).widthFactor + f3;; f1 += f4 + f3)
      {
        if (this.mPageMargin + f2 > k)
        {
          this.mMarginDrawable.setBounds(this.bmV, (int)f2, this.bmW, (int)(this.mPageMargin + f2 + 0.5F));
          this.mMarginDrawable.draw(paramCanvas);
        }
        if (f2 <= k + m) {
          break;
        }
        return;
        f4 = this.mAdapter.getPageWidth(i);
        f2 = (f1 + f4) * m;
      }
      i += 1;
    }
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
        ram.e(this.TAG, "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
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
  
  b b(View paramView)
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
  
  protected void b(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    int j;
    Object localObject;
    if (this.mDecorChildCount > 0)
    {
      int i1 = getScrollY();
      i = getPaddingTop();
      j = getPaddingBottom();
      int i2 = getHeight();
      int i3 = getChildCount();
      int n = 0;
      while (n < i3)
      {
        localObject = getChildAt(n);
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        int m;
        int k;
        if (!localLayoutParams.isDecor)
        {
          m = i;
          k = j;
          n += 1;
          i = m;
          j = k;
        }
        else
        {
          switch (localLayoutParams.gravity & 0x70)
          {
          default: 
            k = i;
            m = j;
            j = i;
            i = m;
          }
          for (;;)
          {
            int i4 = k + i1 - ((View)localObject).getTop();
            k = i;
            m = j;
            if (i4 == 0) {
              break;
            }
            ((View)localObject).offsetTopAndBottom(i4);
            k = i;
            m = j;
            break;
            k = ((View)localObject).getHeight();
            m = k + i;
            k = i;
            i = j;
            j = m;
            continue;
            k = Math.max((i2 - ((View)localObject).getMeasuredHeight()) / 2, i);
            m = i;
            i = j;
            j = m;
            continue;
            k = i2 - j - ((View)localObject).getMeasuredHeight();
            i4 = ((View)localObject).getMeasuredHeight();
            m = i;
            i = j + i4;
            j = m;
          }
        }
      }
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mOnPageChangeListeners != null)
    {
      j = this.mOnPageChangeListeners.size();
      i = 0;
      while (i < j)
      {
        localObject = (f)this.mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((f)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i += 1;
      }
    }
    if (this.c != null) {
      this.c.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h != null)
    {
      paramInt2 = getScrollY();
      i = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i)
      {
        localObject = getChildAt(paramInt1);
        if (((LayoutParams)((View)localObject).getLayoutParams()).isDecor) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (((View)localObject).getTop() - paramInt2) / sH();
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h.transformPage((View)localObject, paramFloat);
        }
      }
    }
    this.mCalledSuper = true;
  }
  
  public List<f> bP()
  {
    if (this.mOnPageChangeListeners == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(this.mOnPageChangeListeners);
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
        localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1)))
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
      do
      {
        return false;
      } while (!JP());
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
    boN();
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!Gravity.isHorizontal(this.bmX)) {
          break label106;
        }
        if (!pageScrolled(k))
        {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      for (;;)
      {
        ViewCompat.postInvalidateOnAnimation(this);
        return;
        label106:
        if (!eG(m))
        {
          this.mScroller.abortAnimation();
          scrollTo(k, 0);
        }
      }
    }
    if (this.mScrollState == 0) {
      this.bmX = 0;
    }
    completeScroll(true);
  }
  
  void dataSetChanged()
  {
    int i2 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i2;
    int i;
    int j;
    int k;
    int n;
    int m;
    label67:
    Object localObject;
    int i1;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i2))
    {
      i = 1;
      j = this.mCurItem;
      k = 0;
      n = 0;
      m = i;
      i = j;
      j = k;
      k = n;
      if (k >= this.mItems.size()) {
        break label299;
      }
      localObject = (b)this.mItems.get(k);
      n = this.mAdapter.getItemPosition(((b)localObject).object);
      if (n != -1) {
        break label157;
      }
      n = k;
      i1 = j;
      k = m;
      j = i;
      i = i1;
      m = n;
    }
    for (;;)
    {
      n = k;
      i1 = j;
      k = m + 1;
      j = i;
      i = i1;
      m = n;
      break label67;
      i = 0;
      break;
      label157:
      if (n == -2)
      {
        this.mItems.remove(k);
        m = k - 1;
        k = j;
        if (j == 0)
        {
          this.mAdapter.startUpdate(this);
          k = 1;
        }
        this.mAdapter.destroyItem(this, ((b)localObject).position, ((b)localObject).object);
        if (this.mCurItem == ((b)localObject).position)
        {
          j = Math.max(0, Math.min(this.mCurItem, i2 - 1));
          i = k;
          k = 1;
        }
      }
      else
      {
        if (((b)localObject).position != n)
        {
          if (((b)localObject).position == this.mCurItem) {
            i = n;
          }
          ((b)localObject).position = n;
          n = i;
          i1 = 1;
          m = k;
          i = j;
          j = n;
          k = i1;
          continue;
          label299:
          if (j != 0) {
            this.mAdapter.finishUpdate(this);
          }
          Collections.sort(this.mItems, COMPARATOR);
          if (m != 0)
          {
            k = getChildCount();
            j = 0;
            while (j < k)
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
        n = i;
        i1 = m;
        m = k;
        i = j;
        j = n;
        k = i1;
        continue;
      }
      j = i;
      n = 1;
      i = k;
      k = n;
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
        b localb = a(localView);
        if ((localb != null) && (localb.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.mAdapter != null) && (this.mAdapter.getCount() > 1)))
    {
      int j;
      if (!this.mLeftEdge.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.mFirstOffset * m);
        this.mLeftEdge.setSize(i, m);
        j = false | this.mLeftEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.mRightEdge.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * k);
        this.mRightEdge.setSize(n - i1 - i2, k);
        bool = j | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
      if (!this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.isFinished()) {
        throw new RuntimeException("do not support (OVER_SCROLL_ALWAYS, OVER_SCROLL_IF_CONTENT_SCROLLS)");
      }
      if (!this.mRightEdge.isFinished()) {
        throw new RuntimeException("do not support (OVER_SCROLL_ALWAYS, OVER_SCROLL_IF_CONTENT_SCROLLS)");
      }
    }
    else
    {
      this.mLeftEdge.finish();
      this.mRightEdge.finish();
      this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
      this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
    }
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
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
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      do
      {
        return false;
        return arrowScroll(33);
        return arrowScroll(130);
        return arrowScroll(17);
        return arrowScroll(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
        return arrowScroll(2);
      }
    } while (!KeyEventCompat.hasModifiers(paramKeyEvent, 1));
    return arrowScroll(1);
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
    if ((Build.VERSION.SDK_INT >= 24) && ((this.mDrawingOrderedChildren == null) || (this.mDrawingOrderedChildren.size() != getChildCount()))) {
      sortChildDrawingOrder();
    }
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
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffectCompat(localContext);
    this.mRightEdge = new EdgeEffectCompat(localContext);
    this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat = new EdgeEffectCompat(localContext);
    this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat = new EdgeEffectCompat(localContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(16.0F * f));
    ViewCompat.setAccessibilityDelegate(this, new c());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mEndScrollRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (JR()) {
      ak(paramCanvas);
    }
    label17:
    while ((this.mPageMargin <= 0) || (this.mMarginDrawable == null) || (this.mItems.size() <= 0) || (this.mAdapter == null)) {
      return;
    }
    int k = getScrollX();
    int m = getWidth();
    float f3 = this.mPageMargin / m;
    Object localObject = (b)this.mItems.get(0);
    float f1 = ((b)localObject).offset;
    int n = this.mItems.size();
    int i = ((b)localObject).position;
    int i1 = ((b)this.mItems.get(n - 1)).position;
    int j = 0;
    label129:
    float f2;
    if (i < i1)
    {
      while ((i > ((b)localObject).position) && (j < n))
      {
        localObject = this.mItems;
        j += 1;
        localObject = (b)((ArrayList)localObject).get(j);
      }
      if (i != ((b)localObject).position) {
        break label292;
      }
      f2 = (((b)localObject).offset + ((b)localObject).widthFactor) * m;
    }
    label292:
    float f4;
    for (f1 = ((b)localObject).offset + ((b)localObject).widthFactor + f3;; f1 += f4 + f3)
    {
      if (this.mPageMargin + f2 > k)
      {
        this.mMarginDrawable.setBounds((int)f2, this.mTopPageBounds, (int)(this.mPageMargin + f2 + 0.5F), this.mBottomPageBounds);
        this.mMarginDrawable.draw(paramCanvas);
      }
      if (f2 > k + m) {
        break;
      }
      i += 1;
      break label129;
      break label17;
      f4 = this.mAdapter.getPageWidth(i);
      f2 = (f1 + f4) * m;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      this.mActivePointerId = -1;
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      return false;
    }
    if (i != 0)
    {
      if (this.mIsBeingDragged) {
        return true;
      }
      if (this.mIsUnableToDrag) {
        return false;
      }
    }
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
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        float f2 = MotionEventCompat.getX(paramMotionEvent, i);
        float f1 = f2 - this.mLastMotionX;
        float f4 = Math.abs(f1);
        float f3 = MotionEventCompat.getY(paramMotionEvent, i);
        float f5 = f3 - this.mLastMotionY;
        float f6 = Math.abs(f5);
        if (((rz()) || ((this.aDQ) && (f5 < 0.0F)) || ((this.aDR) && (f5 > 0.0F))) && (f5 != 0.0F) && (!x(this.mLastMotionY, f5)) && (a(this, false, (int)f5, (int)f2, (int)f3)))
        {
          this.mLastMotionX = f2;
          this.mLastMotionY = f3;
          this.mIsUnableToDrag = true;
          this.bmX = 0;
          return false;
        }
        if (((JP()) || ((this.aDS) && (f1 < 0.0F)) || ((this.aDT) && (f1 > 0.0F))) && (f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.mLastMotionX = f2;
          this.mLastMotionY = f3;
          this.mIsUnableToDrag = true;
          this.bmX = 0;
          return false;
        }
        if (((rz()) || ((this.aDQ) && (f5 < 0.0F)) || ((this.aDR) && (f5 > 0.0F))) && (!Gravity.isHorizontal(this.bmX)) && (f6 > this.mTouchSlop) && (0.6F * f6 > f4))
        {
          this.mIsBeingDragged = true;
          if (f5 > 0.0F)
          {
            i = 80;
            label475:
            this.bmX = i;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
            this.mLastMotionX = f2;
            if (f5 <= 0.0F) {
              break label563;
            }
            f1 = this.mInitialMotionY + this.mTouchSlop;
            label514:
            this.mLastMotionY = f1;
            setScrollingCacheEnabled(true);
          }
        }
        while (this.mIsBeingDragged)
        {
          if (!Gravity.isHorizontal(this.bmX)) {
            break label834;
          }
          if (!performDrag(f2)) {
            break;
          }
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          i = 48;
          break label475;
          label563:
          f1 = this.mInitialMotionY - this.mTouchSlop;
          break label514;
          if (((JP()) || ((this.aDS) && (f1 < 0.0F)) || ((this.aDT) && (f1 > 0.0F))) && (!Gravity.isVertical(this.bmX)) && (f4 > this.mTouchSlop) && (0.6F * f4 > f6))
          {
            this.mIsBeingDragged = true;
            if (f1 > 0.0F)
            {
              i = 5;
              label656:
              this.bmX = i;
              requestParentDisallowInterceptTouchEvent(true);
              setScrollState(1);
              if (f1 <= 0.0F) {
                break label714;
              }
            }
            label714:
            for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
            {
              this.mLastMotionX = f1;
              this.mLastMotionY = f3;
              setScrollingCacheEnabled(true);
              break;
              i = 3;
              break label656;
            }
          }
          if (((!rz()) || ((this.aDQ) && (f5 > 0.0F)) || ((this.aDR) && (f5 < 0.0F))) && (f6 > this.mTouchSlop)) {
            this.mIsUnableToDrag = true;
          } else if (((!JP()) || ((this.aDS) && (f1 > 0.0F)) || ((this.aDT) && (f1 < 0.0F))) && (f4 > this.mTouchSlop)) {
            this.mIsUnableToDrag = true;
          }
        }
        label834:
        if (d(f3))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          continue;
          f1 = paramMotionEvent.getX();
          this.mInitialMotionX = f1;
          this.mLastMotionX = f1;
          f1 = paramMotionEvent.getY();
          this.mInitialMotionY = f1;
          this.mLastMotionY = f1;
          this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          this.mIsUnableToDrag = false;
          this.mScroller.computeScrollOffset();
          if ((Gravity.isHorizontal(this.bmX)) && (this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
          {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            this.mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
          }
          else if ((Gravity.isVertical(this.bmX)) && (this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalY() - this.mScroller.getCurrY()) > this.mCloseEnough))
          {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            this.mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
          }
          else
          {
            completeScroll(false);
            this.mIsBeingDragged = false;
            continue;
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (JR())
    {
      a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i4 = getScrollX();
    int j = 0;
    int m = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i;
    int i5;
    int k;
    label174:
    int n;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label709;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.isDecor) {
        break label709;
      }
      i = localLayoutParams.gravity;
      i5 = localLayoutParams.gravity;
      switch (i & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        i = paramInt2;
        k = paramInt2;
        switch (i5 & 0x70)
        {
        default: 
          n = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = n;
          label224:
          i += i4;
          localView.layout(i, paramInt3, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt3);
          j += 1;
          paramInt3 = k;
          i = paramInt1;
          paramInt1 = j;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      k = paramInt3;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i;
      paramInt2 = k;
      break;
      k = localView.getMeasuredWidth();
      i = paramInt2;
      k += paramInt2;
      break label174;
      i = Math.max((i2 - localView.getMeasuredWidth()) / 2, paramInt2);
      k = paramInt2;
      break label174;
      k = localView.getMeasuredWidth();
      i = paramInt4 + localView.getMeasuredWidth();
      n = i2 - paramInt4 - k;
      paramInt4 = i;
      k = paramInt2;
      i = n;
      break label174;
      n = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      n += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
      break label224;
      n = Math.max((i3 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = n;
      break label224;
      n = i3 - paramInt3 - localView.getMeasuredHeight();
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i5;
      paramInt3 = n;
      break label224;
      k = i2 - paramInt2 - paramInt4;
      i = 0;
      while (i < i1)
      {
        localView = getChildAt(i);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.isDecor)
          {
            b localb = a(localView);
            if (localb != null)
            {
              float f = k;
              m = (int)(localb.offset * f) + paramInt2;
              if (localLayoutParams.needsMeasure)
              {
                localLayoutParams.needsMeasure = false;
                f = k;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(m, paramInt1, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        i += 1;
      }
      this.mTopPageBounds = paramInt1;
      this.bmV = paramInt2;
      this.mBottomPageBounds = (i3 - paramInt3);
      this.bmW = (i2 - paramInt4);
      this.mDecorChildCount = j;
      if ((this.mFirstLayout) || (this.aDV)) {
        scrollToItem(this.mCurItem, false, 0, false);
      }
      this.mFirstLayout = false;
      this.aDV = false;
      return;
      label709:
      i = j;
      j = paramInt1;
      k = paramInt2;
      paramInt1 = i;
      i = paramInt3;
      paramInt2 = j;
      paramInt3 = k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    LayoutParams localLayoutParams;
    int m;
    int i1;
    label183:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
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
            m = localLayoutParams.gravity & 0x70;
            i1 = -2147483648;
            j = -2147483648;
            if ((m != 48) && (m != 80)) {
              break label333;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label339;
            }
            n = 1;
            label198:
            if (m == 0) {
              break label345;
            }
            i = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label528;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label522;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localLayoutParams.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localLayoutParams.height != -1)
        {
          i3 = localLayoutParams.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          k += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label333:
          m = 0;
          break label183;
          label339:
          n = 0;
          break label198;
          label345:
          i = i1;
          if (n == 0) {
            break label208;
          }
          j = 1073741824;
          i = i1;
          break label208;
          i = paramInt1;
          j = paramInt2;
          if (n != 0)
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
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.isDecor))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), this.mChildHeightMeasureSpec);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i = paramInt1;
      continue;
      label528:
      i1 = i;
      i = paramInt1;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    int j;
    Object localObject;
    if (this.mDecorChildCount > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      j = getPaddingRight();
      int i2 = getWidth();
      int i3 = getChildCount();
      int n = 0;
      while (n < i3)
      {
        localObject = getChildAt(n);
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        int m;
        int k;
        if (!localLayoutParams.isDecor)
        {
          m = i;
          k = j;
          n += 1;
          i = m;
          j = k;
        }
        else
        {
          switch (localLayoutParams.gravity & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            k = i;
            m = j;
            j = i;
            i = m;
          }
          for (;;)
          {
            int i4 = k + i1 - ((View)localObject).getLeft();
            k = i;
            m = j;
            if (i4 == 0) {
              break;
            }
            ((View)localObject).offsetLeftAndRight(i4);
            k = i;
            m = j;
            break;
            k = ((View)localObject).getWidth();
            m = k + i;
            k = i;
            i = j;
            j = m;
            continue;
            k = Math.max((i2 - ((View)localObject).getMeasuredWidth()) / 2, i);
            m = i;
            i = j;
            j = m;
            continue;
            k = i2 - j - ((View)localObject).getMeasuredWidth();
            i4 = ((View)localObject).getMeasuredWidth();
            m = i;
            i = j + i4;
            j = m;
          }
        }
      }
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mOnPageChangeListeners != null)
    {
      j = this.mOnPageChangeListeners.size();
      i = 0;
      while (i < j)
      {
        localObject = (f)this.mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((f)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i += 1;
      }
    }
    if (this.c != null) {
      this.c.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h != null)
    {
      paramInt2 = getScrollX();
      i = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i)
      {
        localObject = getChildAt(paramInt1);
        if (((LayoutParams)((View)localObject).getLayoutParams()).isDecor) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (((View)localObject).getLeft() - paramInt2) / getClientWidth();
          this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h.transformPage((View)localObject, paramFloat);
        }
      }
    }
    this.mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int k = -1;
    int j = getChildCount();
    int i;
    if ((paramInt & 0x2) != 0)
    {
      k = 1;
      i = 0;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = a(localView);
        if ((localb != null) && (localb.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          j = -1;
          continue;
        }
      }
      i += k;
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
    if (paramInt2 != paramInt4) {
      s(paramInt2, paramInt4, this.mPageMargin, this.mPageMargin);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = 3;
    int i2 = 0;
    if (this.mFakeDragging) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.mAdapter == null) || (this.mAdapter.getCount() == 0)) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = i2;
    float f1;
    float f2;
    Object localObject;
    label467:
    label474:
    label488:
    int k;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = i2;
    case 4: 
    case 0: 
    case 2: 
    case 1: 
      label581:
      do
      {
        for (;;)
        {
          if (i != 0) {
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
          this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          i = i2;
          continue;
          float f3;
          float f4;
          if (!this.mIsBeingDragged)
          {
            i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
            f1 = MotionEventCompat.getX(paramMotionEvent, i);
            f3 = Math.abs(f1 - this.mLastMotionX);
            f2 = MotionEventCompat.getY(paramMotionEvent, i);
            f4 = Math.abs(f2 - this.mLastMotionY);
            if (((!rz()) && ((!this.aDQ) || (f2 >= this.mLastMotionY)) && ((!this.aDR) || (f2 <= this.mLastMotionY))) || ((this.mIsBeingDragged) && (Gravity.isHorizontal(this.bmX))) || (f4 <= this.mTouchSlop) || (f4 <= f3)) {
              break label488;
            }
            this.mIsBeingDragged = true;
            if (f2 >= this.mLastMotionY) {
              break label467;
            }
            i = 48;
            this.bmX = i;
            requestParentDisallowInterceptTouchEvent(true);
            this.mLastMotionX = f1;
            if (f2 - this.mInitialMotionY <= 0.0F) {
              break label474;
            }
            f1 = this.mInitialMotionY + this.mTouchSlop;
            this.mLastMotionY = f1;
            setScrollState(1);
            setScrollingCacheEnabled(true);
            localObject = getParent();
            if (localObject != null) {
              ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
            }
          }
          int j;
          while (((!JP()) && ((!this.aDS) || (f1 >= this.mLastMotionX)) && ((!this.aDT) || (f1 <= this.mLastMotionX))) || ((this.mIsBeingDragged) && (Gravity.isVertical(this.bmX))) || (f3 <= this.mTouchSlop) || (f3 <= f4)) {
            for (;;)
            {
              i = i2;
              if (!this.mIsBeingDragged) {
                break;
              }
              if (!Gravity.isHorizontal(this.bmX)) {
                break label676;
              }
              boolean bool1 = false | performDrag(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)));
              break;
              j = 80;
              continue;
              f1 = this.mInitialMotionY - this.mTouchSlop;
            }
          }
          this.mIsBeingDragged = true;
          if (f1 < this.mLastMotionX)
          {
            j = i3;
            this.bmX = j;
            requestParentDisallowInterceptTouchEvent(true);
            if (f1 - this.mInitialMotionX <= 0.0F) {
              break label662;
            }
          }
          for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
          {
            this.mLastMotionX = f1;
            this.mLastMotionY = f2;
            setScrollState(1);
            setScrollingCacheEnabled(true);
            localObject = getParent();
            if (localObject == null) {
              break;
            }
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
            break;
            j = 5;
            break label581;
          }
          bool2 = false | d(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)));
        }
        boolean bool2 = i2;
      } while (!this.mIsBeingDragged);
      label662:
      label676:
      if (Gravity.isHorizontal(this.bmX))
      {
        localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        i2 = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.mActivePointerId);
        this.mPopulatePending = true;
        k = getClientWidth();
        i3 = getScrollX();
        localObject = a();
        k = determineTargetPage(((b)localObject).position, (i3 / k - ((b)localObject).offset) / ((b)localObject).widthFactor, i2, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)) - this.mInitialMotionX));
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$e == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$e.JS())) {
          break label1296;
        }
        if ((this.bmX == 3) && (k < getCurrentItem())) {
          k = getCurrentItem();
        }
      }
      break;
    }
    label1296:
    for (;;)
    {
      setCurrentItemInternal(k, true, true, i2);
      this.mActivePointerId = -1;
      endDrag();
      boolean bool4 = this.mLeftEdge.onRelease();
      int m = this.mRightEdge.onRelease() | bool4;
      break;
      if ((this.bmX == 5) && (m > getCurrentItem()))
      {
        int n = getCurrentItem();
        continue;
        n = i2;
        if (!Gravity.isVertical(this.bmX)) {
          break;
        }
        localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        n = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.mActivePointerId);
        this.mPopulatePending = true;
        i2 = sH();
        i3 = getScrollY();
        localObject = a();
        setCurrentItemInternal(determineTargetPage(((b)localObject).position, (i3 / i2 - ((b)localObject).offset) / ((b)localObject).widthFactor, n, (int)(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)) - this.mInitialMotionY)), true, true, n);
        this.mActivePointerId = -1;
        endDrag();
        bool4 = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
        boolean bool3 = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease() | bool4;
        break;
        bool3 = i2;
        if (!this.mIsBeingDragged) {
          break;
        }
        if (Gravity.isHorizontal(this.bmX)) {
          scrollToItem(this.mCurItem, true, 0, false);
        }
        for (;;)
        {
          this.mActivePointerId = -1;
          endDrag();
          if (!Gravity.isHorizontal(this.bmX)) {
            break label1181;
          }
          bool4 = this.mLeftEdge.onRelease();
          bool3 = this.mRightEdge.onRelease() | bool4;
          break;
          a(this.mCurItem, true, 0, false);
        }
        label1181:
        bool4 = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
        bool3 = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease() | bool4;
        break;
        int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
        f1 = MotionEventCompat.getX(paramMotionEvent, i1);
        f2 = MotionEventCompat.getY(paramMotionEvent, i1);
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i1);
        i1 = i2;
        break;
        onSecondaryPointerUp(paramMotionEvent);
        this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
        this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
        i1 = i2;
        break;
      }
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$g != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$g.onVisibilityChanged(paramView, paramInt);
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
  
  void populate()
  {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt)
  {
    int i;
    Object localObject2;
    if (this.mCurItem != paramInt) {
      if (this.mCurItem < paramInt)
      {
        i = 66;
        localObject2 = a(this.mCurItem);
        this.mCurItem = paramInt;
      }
    }
    for (int j = i;; j = 2)
    {
      if (this.mAdapter == null) {
        sortChildDrawingOrder();
      }
      do
      {
        return;
        i = 17;
        break;
        if (this.mPopulatePending)
        {
          sortChildDrawingOrder();
          return;
        }
      } while (getWindowToken() == null);
      this.mAdapter.startUpdate(this);
      int i3 = this.mOffscreenPageLimit;
      int i4 = Math.max(0, this.mCurItem - i3);
      int i1 = this.mAdapter.getCount();
      int i2 = Math.min(i1 - 1, this.mCurItem + i3);
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
      label249:
      if (paramInt < this.mItems.size())
      {
        localObject1 = (b)this.mItems.get(paramInt);
        if (((b)localObject1).position >= this.mCurItem) {
          if (((b)localObject1).position != this.mCurItem) {
            break label1322;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i1 > 0)) {}
        label529:
        label1299:
        for (Object localObject3 = a(this.mCurItem, paramInt);; localObject3 = localObject1)
        {
          int n;
          label347:
          int i5;
          float f1;
          label360:
          float f3;
          int m;
          int k;
          Object localObject4;
          if (localObject3 != null)
          {
            n = paramInt - 1;
            if (n < 0) {
              break label671;
            }
            localObject1 = (b)this.mItems.get(n);
            i5 = getClientWidth();
            if (i5 > 0) {
              break label677;
            }
            f1 = 0.0F;
            f2 = f1;
            if (i3 == 0) {
              f2 = 0.0F;
            }
            i = this.mCurItem;
            f3 = 0.0F;
            m = i - 1;
            k = paramInt;
            localObject4 = localObject1;
            if (m >= 0)
            {
              if ((f3 < f2) || (m >= i4)) {
                break label832;
              }
              if (localObject4 != null) {
                break label698;
              }
            }
            f3 = ((b)localObject3).widthFactor;
            paramInt = k + 1;
            if (f3 < 2.0F)
            {
              if (paramInt >= this.mItems.size()) {
                break label952;
              }
              localObject1 = (b)this.mItems.get(paramInt);
              label458:
              if (i5 > 0) {
                break label958;
              }
              f1 = 0.0F;
              label465:
              if (i3 != 0) {
                break label1310;
              }
            }
          }
          label1176:
          label1305:
          label1310:
          for (float f2 = 0.0F;; f2 = f1)
          {
            i = this.mCurItem;
            i += 1;
            f1 = f3;
            label487:
            if (i < i1)
            {
              if ((f1 < f2) || (i <= i2)) {
                break label1054;
              }
              if (localObject1 != null) {}
            }
            else
            {
              if (!JR()) {
                break label1176;
              }
              b((b)localObject3, k, (b)localObject2);
              localObject2 = this.mAdapter;
              paramInt = this.mCurItem;
              if (localObject3 == null) {
                break label1189;
              }
              localObject1 = ((b)localObject3).object;
              ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
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
                    ((LayoutParams)localObject1).widthFactor = ((b)localObject2).widthFactor;
                    ((LayoutParams)localObject1).position = ((b)localObject2).position;
                  }
                }
                paramInt += 1;
              }
              paramInt += 1;
              break label249;
              localObject1 = null;
              break label347;
              f1 = 2.0F - ((b)localObject3).widthFactor + getPaddingLeft() / i5;
              break label360;
              localObject1 = localObject4;
              paramInt = n;
              f1 = f3;
              i = k;
              if (m == localObject4.position)
              {
                localObject1 = localObject4;
                paramInt = n;
                f1 = f3;
                i = k;
                if (!localObject4.scrolling)
                {
                  this.mItems.remove(n);
                  this.mAdapter.destroyItem(this, m, localObject4.object);
                  paramInt = n - 1;
                  i = k - 1;
                  if (paramInt < 0) {
                    break label823;
                  }
                  localObject1 = (b)this.mItems.get(paramInt);
                  f1 = f3;
                }
              }
              for (;;)
              {
                m -= 1;
                localObject4 = localObject1;
                n = paramInt;
                f3 = f1;
                k = i;
                break;
                localObject1 = null;
                f1 = f3;
                continue;
                if ((localObject4 != null) && (m == localObject4.position))
                {
                  f1 = f3 + localObject4.widthFactor;
                  paramInt = n - 1;
                  if (paramInt >= 0)
                  {
                    localObject1 = (b)this.mItems.get(paramInt);
                    i = k;
                  }
                  else
                  {
                    localObject1 = null;
                    i = k;
                  }
                }
                else
                {
                  f1 = f3 + a(m, n + 1).widthFactor;
                  i = k + 1;
                  if (n >= 0)
                  {
                    localObject1 = (b)this.mItems.get(n);
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
              break label458;
              f1 = getPaddingRight() / i5 + 2.0F;
              break label465;
            }
            label552:
            label698:
            label832:
            if ((i == ((b)localObject1).position) && (!((b)localObject1).scrolling))
            {
              this.mItems.remove(paramInt);
              this.mAdapter.destroyItem(this, i, ((b)localObject1).object);
              if (paramInt < this.mItems.size()) {
                localObject1 = (b)this.mItems.get(paramInt);
              }
            }
            for (;;)
            {
              label671:
              label677:
              label823:
              label952:
              label958:
              i += 1;
              break label487;
              localObject1 = null;
              continue;
              label1054:
              if ((localObject1 != null) && (i == ((b)localObject1).position))
              {
                f3 = ((b)localObject1).widthFactor;
                paramInt += 1;
                if (paramInt < this.mItems.size()) {}
                for (localObject1 = (b)this.mItems.get(paramInt);; localObject1 = null)
                {
                  f1 += f3;
                  break;
                }
              }
              localObject1 = a(i, paramInt);
              paramInt += 1;
              f3 = ((b)localObject1).widthFactor;
              if (paramInt < this.mItems.size()) {}
              for (localObject1 = (b)this.mItems.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
              a((b)localObject3, k, (b)localObject2);
              break label529;
              label1189:
              localObject1 = null;
              break label552;
              sortChildDrawingOrder();
              if (!hasFocus()) {
                break;
              }
              localObject1 = findFocus();
              if (localObject1 != null) {}
              for (localObject1 = b((View)localObject1);; localObject1 = null)
              {
                if ((localObject1 != null) && (((b)localObject1).position == this.mCurItem)) {
                  break label1305;
                }
                paramInt = 0;
                for (;;)
                {
                  if (paramInt >= getChildCount()) {
                    break label1299;
                  }
                  localObject1 = getChildAt(paramInt);
                  localObject2 = a((View)localObject1);
                  if ((localObject2 != null) && (((b)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(j))) {
                    break;
                  }
                  paramInt += 1;
                }
                break;
              }
              break;
            }
          }
        }
        label1322:
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
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public int sG()
  {
    return this.bmX;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$i);
      this.mAdapter.startUpdate(this);
      int i = 0;
      while (i < this.mItems.size())
      {
        localObject = (b)this.mItems.get(i);
        this.mAdapter.destroyItem(this, ((b)localObject).position, ((b)localObject).object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    boolean bool;
    if (this.mAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$i == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$i = new i(null);
      }
      this.mAdapter.registerDataSetObserver(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$i);
      this.mPopulatePending = false;
      bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem < 0) {
        break label260;
      }
      this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
      setCurrentItemInternal(this.mRestoredCurItem, false, true);
      this.mRestoredCurItem = -1;
      this.mRestoredAdapterState = null;
      this.mRestoredClassLoader = null;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$d != null) && (localObject != paramPagerAdapter)) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$d.onAdapterChanged((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      label260:
      if (!bool) {
        populate();
      } else {
        requestLayout();
      }
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.mSetChildrenDrawingOrderEnabled == null)) {}
    try
    {
      this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          ram.e(this.TAG, "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        ram.e(this.TAG, "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
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
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    int j = 0;
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i = this.mCurItem;
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
        ((b)this.mItems.get(paramInt1)).scrolling = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount()) {
        i = this.mAdapter.getCount() - 1;
      }
    }
    if (this.mCurItem != i) {
      paramBoolean2 = true;
    }
    while (this.mFirstLayout)
    {
      this.mCurItem = i;
      if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f != null)) {
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageSelected(i);
      }
      if ((paramBoolean2) && (this.mOnPageChangeListeners != null))
      {
        paramInt2 = this.mOnPageChangeListeners.size();
        paramInt1 = j;
        for (;;)
        {
          if (paramInt1 < paramInt2)
          {
            f localf = (f)this.mOnPageChangeListeners.get(paramInt1);
            if (localf != null) {
              localf.onPageSelected(i);
            }
            paramInt1 += 1;
            continue;
            paramBoolean2 = false;
            break;
          }
        }
      }
      if ((paramBoolean2) && (this.c != null)) {
        this.c.onPageSelected(i);
      }
      requestLayout();
      return;
    }
    populate(i);
    if (JR())
    {
      a(i, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public void setCurrentItemWithTransform(int paramInt1, int paramInt2)
  {
    this.aDW = true;
    this.bmY = paramInt2;
    setCurrentItem(paramInt1, false);
    this.aDW = false;
  }
  
  public void setDistanceAndVelocityThreshold(int paramInt1, int paramInt2)
  {
    this.mFlingDistance = paramInt1;
    this.mMinimumVelocity = paramInt2;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.aDU = paramBoolean;
  }
  
  public void setEnableScrollDirection(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.aDQ = paramBoolean1;
    this.aDR = paramBoolean2;
    this.aDS = paramBoolean3;
    this.aDT = paramBoolean4;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      ram.w(this.TAG, "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
  }
  
  public void setOnDragStatusChangedListener(e parame)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$e = parame;
  }
  
  public void setOnPageChangeListener(f paramf)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f = paramf;
  }
  
  public void setOnVisibilityChangeListener(@Nullable g paramg)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$g = paramg;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j;
    if (rz())
    {
      j = getHeight();
      s(j, j, paramInt, i);
    }
    for (;;)
    {
      requestLayout();
      return;
      j = getWidth();
      recomputeScrollPosition(j, j, paramInt, i);
    }
  }
  
  public void setPageMarginDrawable(@DrawableRes int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
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
  
  public void setPageScrollDuration(int paramInt)
  {
    this.bmT = paramInt;
  }
  
  public void setPageScrollDurationDivisor(int paramInt)
  {
    this.bmU = paramInt;
  }
  
  public void setPageTransformer(boolean paramBoolean, h paramh)
  {
    int j = 1;
    boolean bool1;
    boolean bool2;
    label28:
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramh == null) {
        break label75;
      }
      bool1 = true;
      if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h == null) {
        break label81;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label87;
      }
      i = 1;
      label37:
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$h = paramh;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (!bool1) {
        break label92;
      }
      if (paramBoolean) {
        j = 2;
      }
    }
    label75:
    label81:
    label87:
    label92:
    for (this.mDrawingOrder = j;; this.mDrawingOrder = 0)
    {
      if (i != 0) {
        populate();
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label28;
      i = 0;
      break label37;
    }
  }
  
  public void setPageTurningThreshold(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
      this.mj = paramFloat;
    }
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.mScroller = paramScroller;
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i = getScrollX();
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if ((k == 0) && (paramInt2 == 0))
    {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = sH();
    int n = paramInt1 / 2;
    int i1 = m / 2;
    float f4 = Math.min(1.0F, 1.0F * Math.abs(k) / paramInt1);
    float f3 = Math.min(1.0F, 1.0F * Math.abs(paramInt2) / m);
    float f1 = n;
    float f2 = n;
    f4 = distanceInfluenceForSnapDuration(f4);
    float f5 = i1;
    float f6 = i1;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {
      if (JR())
      {
        paramInt1 = Math.round(1000.0F * Math.abs((f6 * f3 + f5) / paramInt3)) * 4;
        paramInt1 = Math.min(paramInt1, 600);
        if ((this.bmU != 2) && (this.bmU != 3)) {
          break label377;
        }
        this.mScroller.startScroll(i, j, k, paramInt2, paramInt1 / this.bmU);
      }
    }
    for (;;)
    {
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      paramInt1 = Math.round(1000.0F * Math.abs((f2 * f4 + f1) / paramInt3)) * 4;
      break;
      if (JR())
      {
        f1 = m;
        f2 = this.mAdapter.getPageWidth(this.mCurItem);
        paramInt1 = (int)((Math.abs(paramInt2) / (f1 * f2 + this.mPageMargin) + 1.0F) * 100.0F);
        break;
      }
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
      paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.mPageMargin) + 1.0F) * 100.0F);
      break;
      label377:
      if (this.bmT > 0) {
        this.mScroller.startScroll(i, j, k, paramInt2, this.bmT);
      } else {
        this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
      }
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
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, XViewPager.LAYOUT_ATTRS);
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new qky());
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
  
  static abstract interface a {}
  
  public static class b
  {
    public Object object;
    float offset;
    public int position;
    boolean scrolling;
    float widthFactor;
  }
  
  class c
    extends AccessibilityDelegateCompat
  {
    c() {}
    
    private boolean canScroll()
    {
      return (XViewPager.a(XViewPager.this) != null) && (XViewPager.a(XViewPager.this).getCount() > 1);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(XViewPager.class.getName());
      paramView = AccessibilityRecordCompat.obtain();
      paramView.setScrollable(canScroll());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (XViewPager.a(XViewPager.this) != null))
      {
        paramView.setItemCount(XViewPager.a(XViewPager.this).getCount());
        paramView.setFromIndex(XViewPager.a(XViewPager.this));
        paramView.setToIndex(XViewPager.a(XViewPager.this));
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(XViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (XViewPager.this.canScrollHorizontally(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (XViewPager.this.canScrollHorizontally(-1)) {
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
        if (XViewPager.this.canScrollHorizontally(1))
        {
          XViewPager.this.setCurrentItem(XViewPager.a(XViewPager.this) + 1);
          return true;
        }
        return false;
      }
      if (XViewPager.this.canScrollHorizontally(-1))
      {
        XViewPager.this.setCurrentItem(XViewPager.a(XViewPager.this) - 1);
        return true;
      }
      return false;
    }
  }
  
  static abstract interface d
  {
    public abstract void onAdapterChanged(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  public static abstract interface e
  {
    public abstract boolean JS();
  }
  
  public static abstract interface f
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  public static abstract interface g
  {
    public abstract void onVisibilityChanged(@NonNull View paramView, int paramInt);
  }
  
  public static abstract interface h
  {
    public abstract void transformPage(View paramView, float paramFloat);
  }
  
  class i
    extends DataSetObserver
  {
    private i() {}
    
    public void onChanged()
    {
      XViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated()
    {
      XViewPager.this.dataSetChanged();
    }
  }
  
  public static class j
    implements XViewPager.f
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
      paramView1 = (XViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (XViewPager.LayoutParams)paramView2.getLayoutParams();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager
 * JD-Core Version:    0.7.0.1
 */