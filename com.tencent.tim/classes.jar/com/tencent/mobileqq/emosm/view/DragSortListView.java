package com.tencent.mobileqq.emosm.view;

import afif;
import afih;
import afii;
import afij;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import atau.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView
  extends XListView
{
  private DragScroller jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller;
  private DropAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator;
  private LiftAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LiftAnimator;
  private RemoveAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator;
  private a jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$a;
  private b jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$b;
  c jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$c = new afih(this);
  private e jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$e;
  private g jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g;
  private h jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$h = new h(3);
  private i jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$i;
  private Rect aV;
  private f jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$f;
  private j jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j;
  private boolean bYj;
  private boolean bYk;
  private boolean bYl;
  private boolean bYm;
  private boolean bYn = true;
  private boolean bYo;
  private boolean bYp;
  int cRc = -1;
  int cRd;
  private boolean mAnimate;
  private boolean mBlockLayoutRequests;
  private MotionEvent mCancelEvent;
  private int mCancelMethod = 0;
  private float mCurrFloatAlpha = 1.0F;
  private int mDownScrollStartY;
  float mDownScrollStartYF;
  private int mDragDeltaX;
  int mDragDeltaY;
  float mDragDownScrollHeight;
  private float mDragDownScrollStartFrac = 0.3333333F;
  private boolean mDragEnabled = true;
  private int mDragFlags;
  private int mDragStartY;
  public int mDragState = 0;
  float mDragUpScrollHeight;
  private float mDragUpScrollStartFrac = 0.3333333F;
  int mFirstExpPos;
  private float mFloatAlpha = 1.0F;
  Point mFloatLoc = new Point();
  int mFloatPos;
  private View mFloatView;
  int mFloatViewHeight;
  int mFloatViewHeightHalf;
  int mFloatViewMid;
  private boolean mFloatViewOnMeasured;
  private boolean mIgnoreTouchEvent;
  private boolean mInTouchEvent;
  int mItemHeightCollapsed = 1;
  private boolean mLastCallWasIntercept;
  private long mLastShowTime;
  private int mLastX;
  int mLastY;
  private boolean mListViewIntercepted;
  public float mMaxScrollSpeed = 0.5F;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  float mRemoveVelocityX = 0.0F;
  private View[] mSampleViewTypes = new View[1];
  int mSecondExpPos;
  private float mSlideFrac = 0.0F;
  private float mSlideRegionFrac = 0.25F;
  int mSrcPos;
  private Point mTouchLoc = new Point();
  private boolean mTrackDragSort;
  private int mUpScrollStartY;
  float mUpScrollStartYF;
  boolean mUseRemoveVelocity;
  private int mWidthMeasureSpec;
  private int mX;
  int mY;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int j = 150;
    boolean bool1;
    int i;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.DragSortListView, 0, 0);
      this.mItemHeightCollapsed = Math.max(1, paramContext.getDimensionPixelSize(1, 1));
      this.mTrackDragSort = paramContext.getBoolean(17, false);
      if (this.mTrackDragSort) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$e = new e();
      }
      this.mFloatAlpha = paramContext.getFloat(8, this.mFloatAlpha);
      this.mCurrFloatAlpha = this.mFloatAlpha;
      this.mDragEnabled = paramContext.getBoolean(2, this.mDragEnabled);
      this.bYj = paramContext.getBoolean(10, this.bYj);
      this.mSlideRegionFrac = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(15, 0.75F)));
      if (this.mSlideRegionFrac > 0.0F)
      {
        bool1 = true;
        this.mAnimate = bool1;
        setDragScrollStart(paramContext.getFloat(4, this.mDragUpScrollStartFrac));
        this.mMaxScrollSpeed = paramContext.getFloat(11, this.mMaxScrollSpeed);
        j = paramContext.getInt(12, 150);
        i = paramContext.getInt(6, 150);
        if (paramContext.getBoolean(18, true))
        {
          bool1 = paramContext.getBoolean(13, false);
          int k = paramContext.getInt(14, 1);
          boolean bool2 = paramContext.getBoolean(16, true);
          int m = paramContext.getInt(5, 0);
          int n = paramContext.getResourceId(3, 0);
          int i1 = paramContext.getResourceId(7, 0);
          int i2 = paramContext.getResourceId(0, 0);
          int i3 = paramContext.getColor(9, -16777216);
          paramAttributeSet = new afif(this, n, m, k, i2, i1);
          paramAttributeSet.setRemoveEnabled(bool1);
          paramAttributeSet.setSortEnabled(bool2);
          paramAttributeSet.setBackgroundColor(i3);
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g = paramAttributeSet;
          super.setOnTouchListener(paramAttributeSet);
        }
        paramContext.recycle();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller = new DragScroller();
      this.bYk = true;
      if (j > 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator = new RemoveAnimator(0.5F, j);
      }
      if (i > 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator = new DropAnimator(0.5F, i);
      }
      this.mCancelEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new afii(this);
      return;
      bool1 = false;
      break;
      i = 150;
    }
  }
  
  private void adjustAllItems()
  {
    int j = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int i = Math.max(0, getHeaderViewsCount() - j);
    k = Math.min(k - j, getCount() - 1 - getFooterViewsCount() - j);
    while (i <= k)
    {
      View localView = getChildAt(i);
      if (localView != null) {
        adjustItem(j + i, localView, false);
      }
      i += 1;
    }
  }
  
  private void adjustItem(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i;
    if ((paramInt != this.mSrcPos) && (paramInt != this.mFirstExpPos) && (paramInt != this.mSecondExpPos))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.mFirstExpPos) || (paramInt == this.mSecondExpPos))
      {
        if (paramInt >= this.mSrcPos) {
          break label151;
        }
        ((DragSortItemView)paramView).setGravity(80);
      }
    }
    for (;;)
    {
      int k = paramView.getVisibility();
      int j = 0;
      i = j;
      if (paramInt == this.mSrcPos)
      {
        i = j;
        if (this.mFloatView != null) {
          i = 4;
        }
      }
      if (i != k) {
        paramView.setVisibility(i);
      }
      return;
      i = calcItemHeight(paramInt, paramView, paramBoolean);
      break;
      label151:
      if (paramInt > this.mSrcPos) {
        ((DragSortItemView)paramView).setGravity(48);
      }
    }
  }
  
  private void adjustOnReorder()
  {
    int i = 0;
    int j = super.getFirstVisiblePosition();
    if (this.mSrcPos < j)
    {
      View localView = super.getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      super.setSelectionFromTop(j - 1, i - getPaddingTop());
    }
  }
  
  private int adjustScroll(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i = getChildHeight(paramInt1);
    int m = paramView.getHeight();
    int n = calcItemHeight(paramInt1, i);
    int j;
    if (paramInt1 != this.mSrcPos)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.mFloatViewHeight;
      int k = i1;
      if (this.mSrcPos != this.mFirstExpPos)
      {
        k = i1;
        if (this.mSrcPos != this.mSecondExpPos) {
          k = i1 - this.mItemHeightCollapsed;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 > this.mFirstExpPos) {
          return k - i + 0;
        }
      }
      else
      {
        if (paramInt1 == paramInt3)
        {
          if (paramInt1 <= this.mFirstExpPos) {
            return j - k + 0;
          }
          if (paramInt1 == this.mSecondExpPos) {
            return m - n + 0;
          }
          return 0 + j;
        }
        if (paramInt1 <= this.mFirstExpPos) {
          return 0 - k;
        }
        if (paramInt1 == this.mSecondExpPos) {
          return 0 - i;
        }
      }
      return 0;
      i = n;
      j = m;
    }
  }
  
  private boolean ai(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = this.mLastCallWasIntercept;
    this.mLastCallWasIntercept = false;
    if (!bool1) {
      saveTouchCoords(paramMotionEvent);
    }
    if (this.mDragState == 4)
    {
      onDragTouchEvent(paramMotionEvent);
      bool2 = true;
    }
    do
    {
      return bool2;
      bool1 = bool2;
      if (this.mDragState == 0)
      {
        bool1 = bool2;
        if (super.onTouchEvent(paramMotionEvent)) {
          bool1 = true;
        }
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
      }
    } while (!bool1);
    this.mCancelMethod = 1;
    return bool1;
    doActionUpOrCancel();
    return bool1;
  }
  
  private ImageView b(int paramInt)
  {
    paramInt -= getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ImageView)localView.findViewById(2131366361);
      }
    }
    return null;
  }
  
  private int calcItemHeight(int paramInt1, int paramInt2)
  {
    getDividerHeight();
    int i;
    int j;
    int k;
    if ((this.mAnimate) && (this.mFirstExpPos != this.mSecondExpPos))
    {
      i = 1;
      j = this.mFloatViewHeight - this.mItemHeightCollapsed;
      k = (int)(this.mSlideFrac * j);
      if (paramInt1 != this.mSrcPos) {
        break label123;
      }
      if (this.mSrcPos != this.mFirstExpPos) {
        break label90;
      }
      if (i == 0) {
        break label85;
      }
      i = k + this.mItemHeightCollapsed;
    }
    label85:
    label90:
    label123:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        return this.mFloatViewHeight;
        if (this.mSrcPos == this.mSecondExpPos) {
          return this.mFloatViewHeight - k;
        }
        i = paramInt2;
      } while (this.mDragState == 0);
      return this.mItemHeightCollapsed;
      if (paramInt1 == this.mFirstExpPos)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.mSecondExpPos);
    return paramInt2 + j - k;
  }
  
  private int calcItemHeight(int paramInt, View paramView, boolean paramBoolean)
  {
    return calcItemHeight(paramInt, getChildHeight(paramInt, paramView, paramBoolean));
  }
  
  private void clearPositions()
  {
    this.mSrcPos = -1;
    this.mFirstExpPos = -1;
    this.mSecondExpPos = -1;
    this.mFloatPos = -1;
  }
  
  private void continueDrag(int paramInt1, int paramInt2)
  {
    this.mFloatLoc.x = (paramInt1 - this.mDragDeltaX);
    this.mFloatLoc.y = (paramInt2 - this.mDragDeltaY);
    doDragFloatView(true);
    paramInt1 = Math.min(paramInt2, this.mFloatViewMid + this.mFloatViewHeightHalf);
    paramInt2 = Math.max(paramInt2, this.mFloatViewMid - this.mFloatViewHeightHalf);
    int i = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.getScrollDir();
    if ((paramInt1 > this.mLastY) && (paramInt1 > this.mDownScrollStartY) && (i != 1))
    {
      if (i != -1) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.stopScrolling(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.startScrolling(1);
    }
    do
    {
      return;
      if ((paramInt2 < this.mLastY) && (paramInt2 < this.mUpScrollStartY) && (i != 0))
      {
        if (i != -1) {
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.stopScrolling(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.startScrolling(0);
        return;
      }
    } while ((paramInt2 < this.mUpScrollStartY) || (paramInt1 > this.mDownScrollStartY) || (!this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.isScrolling()));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.stopScrolling(true);
  }
  
  private boolean d(View paramView, int paramInt1, int paramInt2)
  {
    if (this.aV == null) {
      this.aV = new Rect();
    }
    paramView.getDrawingRect(this.aV);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.aV.left = arrayOfInt[0];
    this.aV.top = arrayOfInt[1];
    this.aV.right += arrayOfInt[0];
    paramView = this.aV;
    int i = this.aV.bottom;
    paramView.bottom = (arrayOfInt[1] + i);
    return this.aV.contains(paramInt1, paramInt2);
  }
  
  private void doActionUpOrCancel()
  {
    this.mCancelMethod = 0;
    this.mInTouchEvent = false;
    if (this.mDragState == 3) {
      this.mDragState = 0;
    }
    this.mCurrFloatAlpha = this.mFloatAlpha;
    this.mListViewIntercepted = false;
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$h.clear();
  }
  
  private void doRemoveItem()
  {
    doRemoveItem(this.mSrcPos - getHeaderViewsCount());
  }
  
  private void doRemoveItem(int paramInt)
  {
    this.mDragState = 1;
    if (this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j != null) {
      this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j.remove(paramInt);
    }
    destroyFloatView();
    adjustOnReorder();
    clearPositions();
    if (this.mInTouchEvent)
    {
      this.mDragState = 3;
      return;
    }
    this.mDragState = 0;
  }
  
  private void drawDivider(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = super.getDivider();
    int m = super.getDividerHeight();
    ViewGroup localViewGroup;
    int j;
    int k;
    int i;
    if ((localDrawable != null) && (m != 0))
    {
      localViewGroup = (ViewGroup)super.getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        j = super.getPaddingLeft();
        k = super.getWidth() - super.getPaddingRight();
        i = localViewGroup.getChildAt(0).getHeight();
        if (paramInt <= this.mSrcPos) {
          break label128;
        }
        i += localViewGroup.getTop();
        paramInt = i + m;
      }
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(j, i, k, paramInt);
      localDrawable.setBounds(j, i, k, paramInt);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      label128:
      paramInt = localViewGroup.getBottom() - i;
      i = paramInt - m;
    }
  }
  
  private void dropFloatView()
  {
    this.mDragState = 2;
    if ((this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$f != null) && (this.mFloatPos >= 0) && (this.mFloatPos < getCount()))
    {
      int i = getHeaderViewsCount();
      this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$f.drop(this.mSrcPos - i, this.mFloatPos - i);
    }
    destroyFloatView();
    adjustOnReorder();
    clearPositions();
    adjustAllItems();
    if (this.mInTouchEvent)
    {
      this.mDragState = 3;
      return;
    }
    this.mDragState = 0;
  }
  
  private int getChildHeight(int paramInt, View paramView, boolean paramBoolean)
  {
    int i = 0;
    if (paramInt == this.mSrcPos) {
      paramInt = i;
    }
    View localView;
    label65:
    do
    {
      return paramInt;
      localView = paramView;
      if (paramInt >= getHeaderViewsCount()) {
        if (paramInt < getCount() - getFooterViewsCount()) {
          break label65;
        }
      }
      for (localView = paramView;; localView = ((ViewGroup)paramView).getChildAt(0))
      {
        paramView = localView.getLayoutParams();
        if ((paramView == null) || (paramView.height <= 0)) {
          break;
        }
        return paramView.height;
      }
      paramInt = localView.getHeight();
    } while ((paramInt != 0) && (!paramBoolean));
    measureItem(localView);
    return localView.getMeasuredHeight();
  }
  
  private void measureFloatView()
  {
    if (this.mFloatView != null)
    {
      measureItem(this.mFloatView);
      this.mFloatViewHeight = this.mFloatView.getMeasuredHeight();
      this.mFloatViewHeightHalf = (this.mFloatViewHeight / 2);
    }
  }
  
  private void measureItem(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      return;
    }
  }
  
  private void saveTouchCoords(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.mLastX = this.mX;
      this.mLastY = this.mY;
    }
    this.mX = ((int)paramMotionEvent.getX());
    this.mY = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.mLastX = this.mX;
      this.mLastY = this.mY;
    }
    this.mOffsetX = ((int)paramMotionEvent.getRawX() - this.mX);
    this.mOffsetY = ((int)paramMotionEvent.getRawY() - this.mY);
  }
  
  private void updateFloatView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g != null)
    {
      this.mTouchLoc.set(this.mX, this.mY);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g.onDragFloatView(this.mFloatView, this.mFloatLoc, this.mTouchLoc);
    }
    int i = this.mFloatLoc.x;
    int m = this.mFloatLoc.y;
    int j = getPaddingLeft();
    int k;
    if (((this.mDragFlags & 0x1) == 0) && (i > j))
    {
      this.mFloatLoc.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.mDragFlags & 0x8) == 0)
      {
        j = i;
        if (n <= this.mSrcPos) {
          j = Math.max(getChildAt(this.mSrcPos - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.mDragFlags & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.mSrcPos) {
          k = Math.min(getChildAt(this.mSrcPos - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label315;
      }
      this.mFloatLoc.y = j;
    }
    for (;;)
    {
      this.mFloatViewMid = (this.mFloatLoc.y + this.mFloatViewHeightHalf);
      return;
      if (((this.mDragFlags & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.mFloatLoc.x = j;
      break;
      label315:
      if (this.mFloatViewHeight + m > k) {
        this.mFloatLoc.y = (k - this.mFloatViewHeight);
      }
    }
  }
  
  private boolean updatePositions()
  {
    int i = super.getFirstVisiblePosition();
    int j = this.mFirstExpPos;
    View localView2 = super.getChildAt(j - i);
    View localView1 = localView2;
    if (localView2 == null)
    {
      j = i + getChildCount() / 2;
      localView1 = super.getChildAt(j - i);
    }
    int i1 = localView1.getTop();
    int i2 = localView1.getHeight();
    i = getShuffleEdge(j, i1);
    int i4 = super.getDividerHeight();
    int k;
    int m;
    int n;
    label147:
    int i3;
    label200:
    float f2;
    if (this.mFloatViewMid < i)
    {
      k = i;
      m = i;
      i = k;
      n = j;
      j = n;
      k = m;
      if (n >= 0)
      {
        n -= 1;
        i = getItemHeight(n);
        if (n == 0)
        {
          i = i1 - i4 - i;
          k = m;
          j = n;
        }
      }
      else
      {
        n = super.getHeaderViewsCount();
        i3 = super.getFooterViewsCount();
        i1 = this.mFirstExpPos;
        i2 = this.mSecondExpPos;
        float f1 = this.mSlideFrac;
        if (!this.mAnimate) {
          break label629;
        }
        i4 = Math.abs(i - k);
        if (this.mFloatViewMid >= i) {
          break label555;
        }
        f2 = this.mSlideRegionFrac;
        m = (int)(i4 * (f2 * 0.5F));
        f2 = m;
        k += m;
        if (this.mFloatViewMid >= k) {
          break label568;
        }
        this.mFirstExpPos = (j - 1);
        this.mSecondExpPos = j;
        this.mSlideFrac = ((k - this.mFloatViewMid) * 0.5F / f2);
        label267:
        if (this.mFirstExpPos >= n) {
          break label644;
        }
        this.mFirstExpPos = n;
        this.mSecondExpPos = n;
        j = n;
        label292:
        if ((this.mFirstExpPos == i1) && (this.mSecondExpPos == i2) && (this.mSlideFrac == f1)) {
          break label687;
        }
      }
    }
    label555:
    label687:
    for (boolean bool = true;; bool = false)
    {
      if (j != this.mFloatPos)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$b != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$b.drag(this.mFloatPos - n, j - n);
        }
        this.mFloatPos = j;
        return true;
        i2 = i1 - (i + i4);
        i1 = getShuffleEdge(n, i2);
        j = n;
        k = m;
        i = i1;
        if (this.mFloatViewMid >= i1) {
          break label147;
        }
        m = i1;
        i = i1;
        i1 = i2;
        break;
        int i5 = getCount();
        k = i;
        n = i;
        i = k;
        m = j;
        for (;;)
        {
          j = m;
          k = n;
          if (m >= i5) {
            break;
          }
          if (m == i5 - 1)
          {
            i = i1 + i4 + i2;
            j = m;
            k = n;
            break;
          }
          i3 = i1 + (i4 + i2);
          i2 = getItemHeight(m + 1);
          i1 = getShuffleEdge(m + 1, i3);
          j = m;
          k = n;
          i = i1;
          if (this.mFloatViewMid < i1) {
            break;
          }
          m += 1;
          n = i1;
          i = i1;
          i1 = i3;
        }
        m = k;
        k = i;
        i = m;
        break label200;
        label568:
        if (this.mFloatViewMid < i - m)
        {
          this.mFirstExpPos = j;
          this.mSecondExpPos = j;
          break label267;
        }
        this.mFirstExpPos = j;
        this.mSecondExpPos = (j + 1);
        this.mSlideFrac = ((1.0F + (i - this.mFloatViewMid) / f2) * 0.5F);
        break label267;
        label629:
        this.mFirstExpPos = j;
        this.mSecondExpPos = j;
        break label267;
        if (this.mSecondExpPos < getCount() - i3) {
          break label292;
        }
        j = super.getCount() - i3 - 1;
        this.mFirstExpPos = j;
        this.mSecondExpPos = j;
        break label292;
      }
      return bool;
    }
  }
  
  private void updateScrollStarts()
  {
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.mUpScrollStartYF = (i + this.mDragUpScrollStartFrac * f1);
    float f2 = i;
    this.mDownScrollStartYF = (f1 * (1.0F - this.mDragDownScrollStartFrac) + f2);
    this.mUpScrollStartY = ((int)this.mUpScrollStartYF);
    this.mDownScrollStartY = ((int)this.mDownScrollStartYF);
    this.mDragUpScrollHeight = (this.mUpScrollStartYF - i);
    this.mDragDownScrollHeight = (i + j - this.mDownScrollStartYF);
  }
  
  public View a(int paramInt1, int paramInt2)
  {
    paramInt1 -= super.getFirstVisiblePosition();
    if ((paramInt1 >= 0) && (paramInt1 <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt1);
      if (localView != null) {
        return localView.findViewById(paramInt2);
      }
    }
    return null;
  }
  
  public ShaderAnimLayout a(int paramInt)
  {
    paramInt -= super.getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= super.getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ShaderAnimLayout)localView.findViewById(2131378161);
      }
    }
    return null;
  }
  
  public void cZJ()
  {
    if (this.bYp) {}
    Object localObject;
    ProgressCircle localProgressCircle;
    do
    {
      do
      {
        return;
        localObject = a(this.mSrcPos);
      } while (localObject == null);
      ((ShaderAnimLayout)localObject).show();
      this.bYp = true;
      localObject = (RelativeLayout)a(this.mSrcPos, 2131381295);
      localProgressCircle = (ProgressCircle)((RelativeLayout)localObject).findViewById(2131381296);
    } while ((((RelativeLayout)localObject).getVisibility() != 0) || (localProgressCircle.getVisibility() != 0));
    ((RelativeLayout)localObject).setVisibility(8);
    this.cRc = this.mSrcPos;
  }
  
  public void cZK()
  {
    Object localObject = a(this.mSrcPos);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).hide();
      this.bYp = false;
      if (this.cRc >= 0)
      {
        localObject = (RelativeLayout)a(this.cRc, 2131381295);
        if ((localObject != null) && (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131381296)).getVisibility() == 0)) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public void cZL()
  {
    Object localObject = a(this.mSrcPos);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).eiY();
      this.bYp = false;
      if (this.cRc >= 0)
      {
        localObject = (RelativeLayout)a(this.cRc, 2131381295);
        if (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131381296)).getVisibility() == 0) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public void cZM()
  {
    if ((this.bYp) && (VersionUtils.isOreo()) && (AppSetting.enableTalkBack))
    {
      if (!this.bYk) {
        break label49;
      }
      cZL();
      removeItem(this.mSrcPos);
    }
    for (this.bYl = false;; this.bYl = false)
    {
      this.bYp = false;
      return;
      label49:
      if (this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j != null) {
        this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j.remove(this.mSrcPos);
      }
    }
  }
  
  public void cancelDrag()
  {
    if (this.mDragState == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.stopScrolling(true);
      destroyFloatView();
      clearPositions();
      adjustAllItems();
      if (this.mInTouchEvent) {
        this.mDragState = 3;
      }
    }
    else
    {
      return;
    }
    this.mDragState = 0;
  }
  
  void destroyFloatView()
  {
    if (this.mFloatView != null)
    {
      this.mFloatView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g.onDestroyFloatView(this.mFloatView);
      }
      this.mFloatView = null;
      invalidate();
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.mDragState != 0)
    {
      if (this.mFirstExpPos != this.mSrcPos) {
        drawDivider(this.mFirstExpPos, paramCanvas);
      }
      if ((this.mSecondExpPos != this.mFirstExpPos) && (this.mSecondExpPos != this.mSrcPos)) {
        drawDivider(this.mSecondExpPos, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.mFloatView != null)
    {
      k = this.mFloatView.getWidth();
      m = this.mFloatView.getHeight();
      int j = this.mFloatLoc.x;
      int n = getWidth();
      i = j;
      if (j < 0) {
        i = -j;
      }
      if (i >= n) {
        break label216;
      }
      f = (n - i) / n;
    }
    label216:
    for (f *= f;; f = 0.0F)
    {
      i = (int)(f * (255.0F * this.mCurrFloatAlpha));
      paramCanvas.save();
      paramCanvas.translate(this.mFloatLoc.x, this.mFloatLoc.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.mFloatView.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
    }
  }
  
  void doDragFloatView(int paramInt, View paramView, boolean paramBoolean)
  {
    this.mBlockLayoutRequests = true;
    updateFloatView();
    int i = this.mFirstExpPos;
    int j = this.mSecondExpPos;
    boolean bool = updatePositions();
    if (bool)
    {
      adjustAllItems();
      setSelectionFromTop(paramInt, adjustScroll(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.mBlockLayoutRequests = false;
  }
  
  void doDragFloatView(boolean paramBoolean)
  {
    int i = getFirstVisiblePosition();
    int j = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null) {
      return;
    }
    doDragFloatView(i + j, localView, paramBoolean);
  }
  
  int getChildHeight(int paramInt)
  {
    int i = 0;
    if (paramInt == this.mSrcPos) {}
    do
    {
      return i;
      localObject = getChildAt(paramInt - getFirstVisiblePosition());
      if (localObject != null) {
        return getChildHeight(paramInt, (View)localObject, false);
      }
      j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$h.get(paramInt);
      i = j;
    } while (j != -1);
    Object localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.mSampleViewTypes.length) {
      this.mSampleViewTypes = new View[j];
    }
    if (i >= 0) {
      if (this.mSampleViewTypes[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.mSampleViewTypes[i] = localObject;
      }
    }
    for (;;)
    {
      i = getChildHeight(paramInt, (View)localObject, true);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$h.add(paramInt, i);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.mSampleViewTypes[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  int getItemHeight(int paramInt)
  {
    View localView = super.getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      return localView.getHeight();
    }
    return calcItemHeight(paramInt, getChildHeight(paramInt));
  }
  
  int getShuffleEdge(int paramInt1, int paramInt2)
  {
    int i = super.getHeaderViewsCount();
    int j = super.getFooterViewsCount();
    if ((paramInt1 <= i) || (paramInt1 >= getCount() - j)) {
      return paramInt2;
    }
    j = super.getDividerHeight();
    int m = this.mFloatViewHeight - this.mItemHeightCollapsed;
    int k = getChildHeight(paramInt1);
    int n = getItemHeight(paramInt1);
    if (this.mSecondExpPos <= this.mSrcPos) {
      if ((paramInt1 == this.mSecondExpPos) && (this.mFirstExpPos != this.mSecondExpPos)) {
        if (paramInt1 == this.mSrcPos) {
          i = paramInt2 + n - this.mFloatViewHeight;
        }
      }
    }
    while (paramInt1 <= this.mSrcPos)
    {
      return (this.mFloatViewHeight - j - getChildHeight(paramInt1 - 1)) / 2 + i;
      i = n - k + paramInt2 - m;
      continue;
      i = paramInt2;
      if (paramInt1 > this.mSecondExpPos)
      {
        i = paramInt2;
        if (paramInt1 <= this.mSrcPos)
        {
          i = paramInt2 - m;
          continue;
          if ((paramInt1 > this.mSrcPos) && (paramInt1 <= this.mFirstExpPos))
          {
            i = paramInt2 + m;
          }
          else
          {
            i = paramInt2;
            if (paramInt1 == this.mSecondExpPos)
            {
              i = paramInt2;
              if (this.mFirstExpPos != this.mSecondExpPos) {
                i = paramInt2 + (n - k);
              }
            }
          }
        }
      }
    }
    return (k - j - this.mFloatViewHeight) / 2 + i;
  }
  
  public boolean isDragEnabled()
  {
    return this.mDragEnabled;
  }
  
  public boolean isScrolling()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.isScrolling();
  }
  
  public void layoutChildren()
  {
    super.layoutChildren();
    if (this.mFloatView != null)
    {
      if ((this.mFloatView.isLayoutRequested()) && (!this.mFloatViewOnMeasured)) {
        measureFloatView();
      }
      this.mFloatView.layout(0, 0, this.mFloatView.getMeasuredWidth(), this.mFloatView.getMeasuredHeight());
      this.mFloatViewOnMeasured = false;
    }
  }
  
  public boolean listViewIntercepted()
  {
    return this.mListViewIntercepted;
  }
  
  protected boolean onDragTouchEvent(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      if (this.mDragState == 4) {
        cancelDrag();
      }
      doActionUpOrCancel();
      continue;
      if (this.mDragState == 4) {
        stopDrag(false);
      }
      doActionUpOrCancel();
      continue;
      continueDrag((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mTrackDragSort) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$e.appendState();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    int j;
    boolean bool2;
    if (!this.mDragEnabled)
    {
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (this.bYp)
      {
        paramMotionEvent = a(this.mSrcPos);
        if (paramMotionEvent == null) {
          bool2 = false;
        }
      }
    }
    do
    {
      return bool2;
      if (d(paramMotionEvent, i, j)) {
        this.bYl = true;
      }
      do
      {
        for (;;)
        {
          return true;
          cZK();
          this.bYn = false;
        }
        paramMotionEvent = (Button)a(this.cRd, 2131381294);
        if (paramMotionEvent == null) {
          return false;
        }
      } while (!d(paramMotionEvent, i, j));
      this.bYm = true;
      return false;
      i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      ImageView localImageView = b(i);
      if ((localImageView != null) && (d(localImageView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
      {
        if ((this.bYp) && (this.mSrcPos != i))
        {
          this.bYo = false;
          return true;
        }
        this.mSrcPos = i;
        this.bYo = true;
        return true;
      }
      if (this.bYp)
      {
        i = (int)paramMotionEvent.getRawX();
        j = (int)paramMotionEvent.getRawY();
        paramMotionEvent = a(this.mSrcPos);
        if (paramMotionEvent == null) {
          return false;
        }
        if (d(paramMotionEvent, i, j)) {
          this.bYl = true;
        }
        return true;
      }
      saveTouchCoords(paramMotionEvent);
      this.mLastCallWasIntercept = true;
      i = paramMotionEvent.getAction() & 0xFF;
      if (i == 0)
      {
        if (this.mDragState != 0)
        {
          this.mIgnoreTouchEvent = true;
          return true;
        }
        this.mInTouchEvent = true;
      }
      if (this.mFloatView == null) {
        break label317;
      }
      bool1 = true;
      if (i == 1) {
        break;
      }
      bool2 = bool1;
    } while (i != 3);
    this.mInTouchEvent = false;
    return bool1;
    label317:
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.mListViewIntercepted = true;
    }
    for (boolean bool1 = true;; bool1 = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool1) {
          this.mCancelMethod = 1;
        }
        break;
      case 1: 
      case 3: 
        doActionUpOrCancel();
        break;
        this.mCancelMethod = 2;
        break;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mFloatView != null)
    {
      if (this.mFloatView.isLayoutRequested()) {
        measureFloatView();
      }
      this.mFloatViewOnMeasured = true;
    }
    this.mWidthMeasureSpec = paramInt1;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    updateScrollStarts();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    if (this.mIgnoreTouchEvent)
    {
      this.mIgnoreTouchEvent = false;
      return false;
    }
    if (!this.mDragEnabled)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.bYp)
        {
          if (this.bYl) {
            if (this.bYk)
            {
              cZL();
              removeItem(this.mSrcPos);
              this.bYl = false;
            }
          }
          for (;;)
          {
            this.bYp = false;
            return false;
            if (this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j != null) {
              this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j.remove(this.mSrcPos);
            }
            this.bYl = false;
            return false;
            cZK();
          }
        }
        Button localButton = (Button)a(this.cRd, 2131381294);
        if ((this.bYm) && (localButton != null))
        {
          this.bYm = false;
          this.bYn = true;
          return false;
        }
        if (!this.bYn)
        {
          this.bYn = true;
          return true;
        }
      }
      try
      {
        bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
          boolean bool = false;
        }
      }
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.bYo)
      {
        if (this.bYp)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$i != null) {
            this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$i.Bb(this.mSrcPos);
          }
          int i = j;
          if (AppSetting.enableTalkBack)
          {
            i = j;
            if (System.currentTimeMillis() - this.mLastShowTime < 300L) {
              i = 0;
            }
          }
          if (i != 0)
          {
            paramMotionEvent = a(this.mSrcPos);
            if (paramMotionEvent != null)
            {
              this.bYp = false;
              paramMotionEvent.hide();
            }
          }
        }
        for (;;)
        {
          this.bYo = false;
          return false;
          if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$i != null) {
            this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$i.Bc(this.mSrcPos);
          }
          paramMotionEvent = a(this.mSrcPos);
          if (paramMotionEvent != null)
          {
            this.bYp = true;
            paramMotionEvent.show();
            this.mLastShowTime = System.currentTimeMillis();
          }
        }
      }
      if (this.bYp)
      {
        if (this.bYl) {
          if (!this.bYj)
          {
            cZL();
            removeItem(this.mSrcPos);
            this.bYl = false;
          }
        }
        for (;;)
        {
          this.bYp = false;
          return false;
          if (this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j != null) {
            this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j.remove(this.mSrcPos);
          }
          this.bYl = false;
          return false;
          cZK();
        }
      }
    }
    return ai(paramMotionEvent);
  }
  
  public void removeItem(int paramInt)
  {
    this.mUseRemoveVelocity = false;
    removeItem(paramInt, 0.0F);
  }
  
  public void removeItem(int paramInt, float paramFloat)
  {
    if ((this.mDragState == 0) || (this.mDragState == 4))
    {
      if (this.mDragState == 0)
      {
        this.mSrcPos = (getHeaderViewsCount() + paramInt);
        this.mFirstExpPos = this.mSrcPos;
        this.mSecondExpPos = this.mSrcPos;
        this.mFloatPos = this.mSrcPos;
        View localView = super.getChildAt(this.mSrcPos - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.mDragState = 1;
      this.mRemoveVelocityX = paramFloat;
      if (this.mInTouchEvent) {
        switch (this.mCancelMethod)
        {
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator.start();
      return;
      super.onTouchEvent(this.mCancelEvent);
      continue;
      super.onInterceptTouchEvent(this.mCancelEvent);
    }
    doRemoveItem(paramInt);
  }
  
  public void requestLayout()
  {
    if (!this.mBlockLayoutRequests) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$a = new a(paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.mObserver);
      if ((paramListAdapter instanceof f)) {
        setDropListener((f)paramListAdapter);
      }
      if ((paramListAdapter instanceof b)) {
        setDragListener((b)paramListAdapter);
      }
      if ((paramListAdapter instanceof j)) {
        setRemoveListener((j)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$a);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$a = null;
    }
  }
  
  public void setDelImmediately(boolean paramBoolean)
  {
    this.bYk = paramBoolean;
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.mDragEnabled = paramBoolean;
    this.bYp = false;
    this.bYl = false;
    this.bYo = false;
  }
  
  public void setDragListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$b = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$c = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    setDragScrollStarts(paramFloat, paramFloat);
  }
  
  public void setDragScrollStarts(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F)
    {
      this.mDragDownScrollStartFrac = 0.5F;
      if (paramFloat1 <= 0.5F) {
        break label46;
      }
    }
    label46:
    for (this.mDragUpScrollStartFrac = 0.5F;; this.mDragUpScrollStartFrac = paramFloat1)
    {
      if (getHeight() != 0) {
        updateScrollStarts();
      }
      return;
      this.mDragDownScrollStartFrac = paramFloat2;
      break;
    }
  }
  
  public void setDragSortListener(d paramd)
  {
    setDropListener(paramd);
    setDragListener(paramd);
    setRemoveListener(paramd);
  }
  
  public void setDropListener(f paramf)
  {
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$f = paramf;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.mCurrFloatAlpha = paramFloat;
  }
  
  public void setFloatViewManager(g paramg)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g = paramg;
  }
  
  public void setLeftEventListener(i parami)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$i = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.mMaxScrollSpeed = paramFloat;
  }
  
  public void setRemoveListener(j paramj)
  {
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView$j = paramj;
  }
  
  public void setSrcPos(int paramInt)
  {
    this.mSrcPos = paramInt;
  }
  
  public void setTapPos(int paramInt)
  {
    this.cRd = paramInt;
  }
  
  public boolean startDrag(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!this.mInTouchEvent) || (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g == null)) {}
    View localView;
    do
    {
      return false;
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$g.onCreateFloatView(paramInt1);
    } while (localView == null);
    return startDrag(paramInt1, localView, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean startDrag(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    if ((this.mDragState != 0) || (!this.mInTouchEvent) || (this.mFloatView != null) || (paramView == null) || (!this.mDragEnabled))
    {
      bool = false;
      return bool;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.mFirstExpPos = paramInt1;
    this.mSecondExpPos = paramInt1;
    this.mSrcPos = paramInt1;
    this.mFloatPos = paramInt1;
    this.mDragState = 4;
    this.mDragFlags = 0;
    this.mDragFlags |= paramInt2;
    this.mFloatView = paramView;
    measureFloatView();
    this.mDragDeltaX = paramInt3;
    this.mDragDeltaY = paramInt4;
    this.mDragStartY = this.mY;
    this.mFloatLoc.x = (this.mX - this.mDragDeltaX);
    this.mFloatLoc.y = (this.mY - this.mDragDeltaY);
    paramView = getChildAt(this.mSrcPos - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.mTrackDragSort) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$e.startTracking();
    }
    switch (this.mCancelMethod)
    {
    }
    for (;;)
    {
      requestLayout();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LiftAnimator == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LiftAnimator.start();
      return true;
      super.onTouchEvent(this.mCancelEvent);
      continue;
      super.onInterceptTouchEvent(this.mCancelEvent);
    }
  }
  
  public boolean stopDrag(boolean paramBoolean)
  {
    this.mUseRemoveVelocity = false;
    return stopDrag(paramBoolean, 0.0F);
  }
  
  public boolean stopDrag(boolean paramBoolean, float paramFloat)
  {
    if (this.mFloatView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.stopScrolling(true);
      if (paramBoolean) {
        removeItem(this.mSrcPos - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.mTrackDragSort) {
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$e.stopTracking();
        }
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator.start();
        } else {
          dropFloatView();
        }
      }
    }
    return false;
  }
  
  public boolean stopDragWithVelocity(boolean paramBoolean, float paramFloat)
  {
    this.mUseRemoveVelocity = true;
    return stopDrag(paramBoolean, paramFloat);
  }
  
  class DragScroller
    implements Runnable
  {
    private float dt;
    private int dy;
    private boolean mAbort;
    private long mCurrTime;
    private long mPrevTime;
    private float mScrollSpeed;
    private boolean mScrolling;
    private int scrollDir;
    private long tStart;
    
    public DragScroller() {}
    
    public int getScrollDir()
    {
      if (this.mScrolling) {
        return this.scrollDir;
      }
      return -1;
    }
    
    public boolean isScrolling()
    {
      return this.mScrolling;
    }
    
    public void run()
    {
      if (this.mAbort)
      {
        this.mScrolling = false;
        return;
      }
      int j = DragSortListView.this.getFirstVisiblePosition();
      int i = DragSortListView.this.getLastVisiblePosition();
      int m = DragSortListView.this.getCount();
      int k = DragSortListView.this.getPaddingTop();
      int n = DragSortListView.this.getHeight() - k - DragSortListView.this.getPaddingBottom();
      int i1 = Math.min(DragSortListView.this.mY, DragSortListView.this.mFloatViewMid + DragSortListView.this.mFloatViewHeightHalf);
      int i2 = Math.max(DragSortListView.this.mY, DragSortListView.this.mFloatViewMid - DragSortListView.this.mFloatViewHeightHalf);
      View localView;
      if (this.scrollDir == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.mScrolling = false;
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.mScrolling = false;
          return;
        }
        this.mScrollSpeed = DragSortListView.this.a.getSpeed((DragSortListView.this.mUpScrollStartYF - i2) / DragSortListView.this.mDragUpScrollHeight, this.mPrevTime);
        this.mCurrTime = SystemClock.uptimeMillis();
        this.dt = ((float)(this.mCurrTime - this.mPrevTime));
        this.dy = Math.round(this.mScrollSpeed * this.dt);
        if (this.dy < 0) {
          break label470;
        }
        this.dy = Math.min(n, this.dy);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.dy;
        j = m;
        if (i == 0)
        {
          j = m;
          if (m > k) {
            j = k;
          }
        }
        DragSortListView.a(DragSortListView.this, true);
        DragSortListView.this.setSelectionFromTop(i, j - k);
        DragSortListView.this.layoutChildren();
        DragSortListView.this.invalidate();
        DragSortListView.a(DragSortListView.this, false);
        DragSortListView.this.doDragFloatView(i, localView, false);
        this.mPrevTime = this.mCurrTime;
        DragSortListView.this.post(this);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.mScrolling = false;
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.mScrolling = false;
          return;
        }
        this.mScrollSpeed = (-DragSortListView.this.a.getSpeed((i1 - DragSortListView.this.mDownScrollStartYF) / DragSortListView.this.mDragDownScrollHeight, this.mPrevTime));
        break;
        label470:
        this.dy = Math.max(-n, this.dy);
      }
    }
    
    public void startScrolling(int paramInt)
    {
      if (!this.mScrolling)
      {
        this.mAbort = false;
        this.mScrolling = true;
        this.tStart = SystemClock.uptimeMillis();
        this.mPrevTime = this.tStart;
        this.scrollDir = paramInt;
        DragSortListView.this.post(this);
      }
    }
    
    public void stopScrolling(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        DragSortListView.this.removeCallbacks(this);
        this.mScrolling = false;
        return;
      }
      this.mAbort = true;
    }
  }
  
  class DropAnimator
    extends DragSortListView.SmoothAnimator
  {
    private int mDropPos;
    private float mInitDeltaX;
    private float mInitDeltaY;
    private int srcPos;
    
    public DropAnimator(float paramFloat, int paramInt)
    {
      super(paramFloat, paramInt);
    }
    
    private int getTargetY()
    {
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.this.mItemHeightCollapsed + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.mDropPos - i);
      if (localView != null)
      {
        if (this.mDropPos == this.srcPos) {
          return localView.getTop();
        }
        if (this.mDropPos < this.srcPos) {
          return localView.getTop() - j;
        }
        return localView.getBottom() + j - DragSortListView.this.mFloatViewHeight;
      }
      cancel();
      return -1;
    }
    
    public void onStart()
    {
      this.mDropPos = DragSortListView.this.mFloatPos;
      this.srcPos = DragSortListView.this.mSrcPos;
      DragSortListView.this.mDragState = 2;
      this.mInitDeltaY = (DragSortListView.this.mFloatLoc.y - getTargetY());
      this.mInitDeltaX = (DragSortListView.this.mFloatLoc.x - DragSortListView.this.getPaddingLeft());
    }
    
    public void onStop()
    {
      DragSortListView.a(DragSortListView.this);
    }
    
    public void onUpdate(float paramFloat1, float paramFloat2)
    {
      int i = getTargetY();
      int j = DragSortListView.this.getPaddingLeft();
      paramFloat1 = DragSortListView.this.mFloatLoc.y - i;
      float f = DragSortListView.this.mFloatLoc.x - j;
      paramFloat2 = 1.0F - paramFloat2;
      if ((paramFloat2 < Math.abs(paramFloat1 / this.mInitDeltaY)) || (paramFloat2 < Math.abs(f / this.mInitDeltaX)))
      {
        DragSortListView.this.mFloatLoc.y = (i + (int)(this.mInitDeltaY * paramFloat2));
        DragSortListView.this.mFloatLoc.x = (DragSortListView.this.getPaddingLeft() + (int)(this.mInitDeltaX * paramFloat2));
        DragSortListView.this.doDragFloatView(true);
      }
    }
  }
  
  class LiftAnimator
    extends DragSortListView.SmoothAnimator
  {
    private float mFinalDragDeltaY;
    private float mInitDragDeltaY;
    
    public void onStart()
    {
      this.mInitDragDeltaY = this.this$0.mDragDeltaY;
      this.mFinalDragDeltaY = this.this$0.mFloatViewHeightHalf;
    }
    
    public void onUpdate(float paramFloat1, float paramFloat2)
    {
      if (this.this$0.mDragState != 4)
      {
        cancel();
        return;
      }
      this.this$0.mDragDeltaY = ((int)(this.mFinalDragDeltaY * paramFloat2 + (1.0F - paramFloat2) * this.mInitDragDeltaY));
      this.this$0.mFloatLoc.y = (this.this$0.mY - this.this$0.mDragDeltaY);
      this.this$0.doDragFloatView(true);
    }
  }
  
  class RemoveAnimator
    extends DragSortListView.SmoothAnimator
  {
    private int mFirstChildHeight = -1;
    private int mFirstPos;
    private float mFirstStartBlank;
    private float mFloatLocX;
    private int mSecondChildHeight = -1;
    private int mSecondPos;
    private float mSecondStartBlank;
    private int srcPos;
    
    public RemoveAnimator(float paramFloat, int paramInt)
    {
      super(paramFloat, paramInt);
    }
    
    public void onStart()
    {
      int i = -1;
      this.mFirstChildHeight = -1;
      this.mSecondChildHeight = -1;
      this.mFirstPos = DragSortListView.this.mFirstExpPos;
      this.mSecondPos = DragSortListView.this.mSecondExpPos;
      this.srcPos = DragSortListView.this.mSrcPos;
      DragSortListView.this.mDragState = 1;
      this.mFloatLocX = DragSortListView.this.mFloatLoc.x;
      if (DragSortListView.this.mUseRemoveVelocity)
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.this.mRemoveVelocityX == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.mFloatLocX < 0.0F) {
            localDragSortListView.mRemoveVelocityX = (i * f);
          }
        }
        do
        {
          return;
          i = 1;
          break;
          f *= 2.0F;
          if ((DragSortListView.this.mRemoveVelocityX < 0.0F) && (DragSortListView.this.mRemoveVelocityX > -f))
          {
            DragSortListView.this.mRemoveVelocityX = (-f);
            return;
          }
        } while ((DragSortListView.this.mRemoveVelocityX <= 0.0F) || (DragSortListView.this.mRemoveVelocityX >= f));
        DragSortListView.this.mRemoveVelocityX = f;
        return;
      }
      DragSortListView.this.destroyFloatView();
    }
    
    public void onStop()
    {
      DragSortListView.b(DragSortListView.this);
    }
    
    public void onUpdate(float paramFloat1, float paramFloat2)
    {
      paramFloat1 = 1.0F - paramFloat2;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.mFirstPos - j);
      if (DragSortListView.this.mUseRemoveVelocity)
      {
        paramFloat2 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / 1000.0F;
        if (paramFloat2 != 0.0F) {}
      }
      do
      {
        do
        {
          return;
          float f1 = DragSortListView.this.mRemoveVelocityX;
          int k = DragSortListView.this.getWidth();
          localObject = DragSortListView.this;
          float f2 = ((DragSortListView)localObject).mRemoveVelocityX;
          if (DragSortListView.this.mRemoveVelocityX > 0.0F) {}
          for (i = 1;; i = -1)
          {
            ((DragSortListView)localObject).mRemoveVelocityX = (i * paramFloat2 * k + f2);
            this.mFloatLocX += f1 * paramFloat2;
            DragSortListView.this.mFloatLoc.x = ((int)this.mFloatLocX);
            if ((this.mFloatLocX >= k) || (this.mFloatLocX <= -k)) {
              break;
            }
            this.mStartTime = SystemClock.uptimeMillis();
            DragSortListView.this.doDragFloatView(true);
            return;
          }
          if (localView != null)
          {
            if (this.mFirstChildHeight == -1)
            {
              this.mFirstChildHeight = DragSortListView.a(DragSortListView.this, this.mFirstPos, localView, false);
              this.mFirstStartBlank = (localView.getHeight() - this.mFirstChildHeight);
            }
            i = Math.max((int)(this.mFirstStartBlank * paramFloat1), 1);
            localObject = localView.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject).height = (i + this.mFirstChildHeight);
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        } while (this.mSecondPos == this.mFirstPos);
        localView = DragSortListView.this.getChildAt(this.mSecondPos - j);
      } while (localView == null);
      if (this.mSecondChildHeight == -1)
      {
        this.mSecondChildHeight = DragSortListView.a(DragSortListView.this, this.mSecondPos, localView, false);
        this.mSecondStartBlank = (localView.getHeight() - this.mSecondChildHeight);
      }
      int i = Math.max((int)(this.mSecondStartBlank * paramFloat1), 1);
      Object localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + this.mSecondChildHeight);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  class SmoothAnimator
    implements Runnable
  {
    private float mA;
    private float mAlpha;
    private float mB;
    private float mC;
    private boolean mCanceled;
    private float mD;
    private float mDurationF;
    protected long mStartTime;
    
    public SmoothAnimator(float paramFloat, int paramInt)
    {
      this.mAlpha = paramFloat;
      this.mDurationF = paramInt;
      paramFloat = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.mD = paramFloat;
      this.mA = paramFloat;
      this.mB = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.mC = (1.0F / (1.0F - this.mAlpha));
    }
    
    public void cancel()
    {
      this.mCanceled = true;
    }
    
    public void onStart() {}
    
    public void onStop() {}
    
    public void onUpdate(float paramFloat1, float paramFloat2) {}
    
    public void run()
    {
      if (this.mCanceled) {
        return;
      }
      float f = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.mDurationF;
      if (f >= 1.0F)
      {
        onUpdate(1.0F, 1.0F);
        onStop();
        return;
      }
      onUpdate(f, transform(f));
      DragSortListView.this.post(this);
    }
    
    public void start()
    {
      this.mStartTime = SystemClock.uptimeMillis();
      this.mCanceled = false;
      onStart();
      DragSortListView.this.post(this);
    }
    
    public float transform(float paramFloat)
    {
      if (paramFloat < this.mAlpha) {
        return this.mA * paramFloat * paramFloat;
      }
      if (paramFloat < 1.0F - this.mAlpha) {
        return this.mB + this.mC * paramFloat;
      }
      return 1.0F - this.mD * (paramFloat - 1.0F) * (paramFloat - 1.0F);
    }
  }
  
  public class a
    extends BaseAdapter
  {
    private ListAdapter mAdapter;
    
    public a(ListAdapter paramListAdapter)
    {
      this.mAdapter = paramListAdapter;
      this.mAdapter.registerDataSetObserver(new afij(this, DragSortListView.this));
    }
    
    public boolean areAllItemsEnabled()
    {
      return this.mAdapter.areAllItemsEnabled();
    }
    
    public int getCount()
    {
      return this.mAdapter.getCount();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mAdapter.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return this.mAdapter.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return this.mAdapter.getItemViewType(paramInt);
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null)
      {
        localObject = (DragSortItemView)paramView;
        localView1 = ((DragSortItemView)localObject).getChildAt(0);
        View localView2 = this.mAdapter.getView(paramInt, localView1, DragSortListView.this);
        if (localView2 != localView1)
        {
          if (localView1 != null) {
            ((DragSortItemView)localObject).removeViewAt(0);
          }
          ((DragSortItemView)localObject).addView(localView2);
        }
        DragSortListView.a(DragSortListView.this, DragSortListView.this.getHeaderViewsCount() + paramInt, (View)localObject, true);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
      View localView1 = this.mAdapter.getView(paramInt, null, DragSortListView.this);
      if ((localView1 instanceof Checkable)) {}
      for (Object localObject = new DragSortItemViewCheckable(DragSortListView.this.getContext());; localObject = new DragSortItemView(DragSortListView.this.getContext()))
      {
        ((DragSortItemView)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        ((DragSortItemView)localObject).addView(localView1);
        break;
      }
    }
    
    public int getViewTypeCount()
    {
      return this.mAdapter.getViewTypeCount();
    }
    
    public boolean hasStableIds()
    {
      return this.mAdapter.hasStableIds();
    }
    
    public boolean isEmpty()
    {
      return this.mAdapter.isEmpty();
    }
    
    public boolean isEnabled(int paramInt)
    {
      return this.mAdapter.isEnabled(paramInt);
    }
  }
  
  public static abstract interface b
  {
    public abstract void drag(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract float getSpeed(float paramFloat, long paramLong);
  }
  
  public static abstract interface d
    extends DragSortListView.b, DragSortListView.f, DragSortListView.j
  {}
  
  class e
  {
    StringBuilder mBuilder = new StringBuilder();
    File mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    private int mNumFlushes;
    private int mNumInBuffer;
    private boolean mTracking;
    
    public e()
    {
      if (!this.mFile.exists()) {}
      try
      {
        this.mFile.createNewFile();
        return;
      }
      catch (IOException this$1) {}
    }
    
    public void appendState()
    {
      if (!this.mTracking) {}
      do
      {
        return;
        this.mBuilder.append("<DSLVState>\n");
        int j = DragSortListView.this.getChildCount();
        int k = DragSortListView.this.getFirstVisiblePosition();
        this.mBuilder.append("    <Positions>");
        int i = 0;
        while (i < j)
        {
          this.mBuilder.append(k + i).append(",");
          i += 1;
        }
        this.mBuilder.append("</Positions>\n");
        this.mBuilder.append("    <Tops>");
        i = 0;
        while (i < j)
        {
          this.mBuilder.append(DragSortListView.this.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        this.mBuilder.append("</Tops>\n");
        this.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          this.mBuilder.append(DragSortListView.this.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        this.mBuilder.append("</Bottoms>\n");
        this.mBuilder.append("    <FirstExpPos>").append(DragSortListView.this.mFirstExpPos).append("</FirstExpPos>\n");
        this.mBuilder.append("    <FirstExpBlankHeight>").append(DragSortListView.this.getItemHeight(DragSortListView.this.mFirstExpPos) - DragSortListView.this.getChildHeight(DragSortListView.this.mFirstExpPos)).append("</FirstExpBlankHeight>\n");
        this.mBuilder.append("    <SecondExpPos>").append(DragSortListView.this.mSecondExpPos).append("</SecondExpPos>\n");
        this.mBuilder.append("    <SecondExpBlankHeight>").append(DragSortListView.this.getItemHeight(DragSortListView.this.mSecondExpPos) - DragSortListView.this.getChildHeight(DragSortListView.this.mSecondExpPos)).append("</SecondExpBlankHeight>\n");
        this.mBuilder.append("    <SrcPos>").append(DragSortListView.this.mSrcPos).append("</SrcPos>\n");
        this.mBuilder.append("    <SrcHeight>").append(DragSortListView.this.mFloatViewHeight + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
        this.mBuilder.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
        this.mBuilder.append("    <LastY>").append(DragSortListView.this.mLastY).append("</LastY>\n");
        this.mBuilder.append("    <FloatY>").append(DragSortListView.this.mFloatViewMid).append("</FloatY>\n");
        this.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          this.mBuilder.append(DragSortListView.this.getShuffleEdge(k + i, DragSortListView.this.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        this.mBuilder.append("</ShuffleEdges>\n");
        this.mBuilder.append("</DSLVState>\n");
        this.mNumInBuffer += 1;
      } while (this.mNumInBuffer <= 1000);
      flush();
      this.mNumInBuffer = 0;
    }
    
    /* Error */
    public void flush()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 58	com/tencent/mobileqq/emosm/view/DragSortListView$e:mTracking	Z
      //   6: ifne +4 -> 10
      //   9: return
      //   10: aload_0
      //   11: getfield 184	com/tencent/mobileqq/emosm/view/DragSortListView$e:mNumFlushes	I
      //   14: ifne +119 -> 133
      //   17: new 186	java/io/FileWriter
      //   20: dup
      //   21: aload_0
      //   22: getfield 47	com/tencent/mobileqq/emosm/view/DragSortListView$e:mFile	Ljava/io/File;
      //   25: iload_1
      //   26: invokespecial 189	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
      //   29: astore_2
      //   30: aload_2
      //   31: aload_0
      //   32: getfield 32	com/tencent/mobileqq/emosm/view/DragSortListView$e:mBuilder	Ljava/lang/StringBuilder;
      //   35: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   38: invokevirtual 197	java/io/FileWriter:write	(Ljava/lang/String;)V
      //   41: aload_0
      //   42: getfield 32	com/tencent/mobileqq/emosm/view/DragSortListView$e:mBuilder	Ljava/lang/StringBuilder;
      //   45: iconst_0
      //   46: aload_0
      //   47: getfield 32	com/tencent/mobileqq/emosm/view/DragSortListView$e:mBuilder	Ljava/lang/StringBuilder;
      //   50: invokevirtual 200	java/lang/StringBuilder:length	()I
      //   53: invokevirtual 204	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   56: pop
      //   57: aload_2
      //   58: invokevirtual 205	java/io/FileWriter:flush	()V
      //   61: aload_0
      //   62: aload_0
      //   63: getfield 184	com/tencent/mobileqq/emosm/view/DragSortListView$e:mNumFlushes	I
      //   66: iconst_1
      //   67: iadd
      //   68: putfield 184	com/tencent/mobileqq/emosm/view/DragSortListView$e:mNumFlushes	I
      //   71: aload_2
      //   72: ifnull -63 -> 9
      //   75: aload_2
      //   76: invokevirtual 208	java/io/FileWriter:close	()V
      //   79: return
      //   80: astore_2
      //   81: aload_2
      //   82: invokevirtual 211	java/io/IOException:printStackTrace	()V
      //   85: return
      //   86: astore_2
      //   87: aconst_null
      //   88: astore_2
      //   89: aload_2
      //   90: ifnull -81 -> 9
      //   93: aload_2
      //   94: invokevirtual 208	java/io/FileWriter:close	()V
      //   97: return
      //   98: astore_2
      //   99: aload_2
      //   100: invokevirtual 211	java/io/IOException:printStackTrace	()V
      //   103: return
      //   104: astore_3
      //   105: aconst_null
      //   106: astore_2
      //   107: aload_2
      //   108: ifnull +7 -> 115
      //   111: aload_2
      //   112: invokevirtual 208	java/io/FileWriter:close	()V
      //   115: aload_3
      //   116: athrow
      //   117: astore_2
      //   118: aload_2
      //   119: invokevirtual 211	java/io/IOException:printStackTrace	()V
      //   122: goto -7 -> 115
      //   125: astore_3
      //   126: goto -19 -> 107
      //   129: astore_3
      //   130: goto -41 -> 89
      //   133: iconst_1
      //   134: istore_1
      //   135: goto -118 -> 17
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	138	0	this	e
      //   1	134	1	bool	boolean
      //   29	47	2	localFileWriter	java.io.FileWriter
      //   80	2	2	localIOException1	IOException
      //   86	1	2	localIOException2	IOException
      //   88	6	2	localObject1	Object
      //   98	2	2	localIOException3	IOException
      //   106	6	2	localObject2	Object
      //   117	2	2	localIOException4	IOException
      //   104	12	3	localObject3	Object
      //   125	1	3	localObject4	Object
      //   129	1	3	localIOException5	IOException
      // Exception table:
      //   from	to	target	type
      //   75	79	80	java/io/IOException
      //   17	30	86	java/io/IOException
      //   93	97	98	java/io/IOException
      //   17	30	104	finally
      //   111	115	117	java/io/IOException
      //   30	71	125	finally
      //   30	71	129	java/io/IOException
    }
    
    public void startTracking()
    {
      this.mBuilder.append("<DSLVStates>\n");
      this.mNumFlushes = 0;
      this.mTracking = true;
    }
    
    public void stopTracking()
    {
      if (this.mTracking)
      {
        this.mBuilder.append("</DSLVStates>\n");
        flush();
        this.mTracking = false;
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void drop(int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract View onCreateFloatView(int paramInt);
    
    public abstract void onDestroyFloatView(View paramView);
    
    public abstract void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2);
  }
  
  class h
  {
    private SparseIntArray mMap;
    private int mMaxSize;
    private ArrayList<Integer> mOrder;
    
    public h(int paramInt)
    {
      this.mMap = new SparseIntArray(paramInt);
      this.mOrder = new ArrayList(paramInt);
      this.mMaxSize = paramInt;
    }
    
    public void add(int paramInt1, int paramInt2)
    {
      int i = this.mMap.get(paramInt1, -1);
      if (i != paramInt2)
      {
        if (i != -1) {
          break label77;
        }
        if (this.mMap.size() == this.mMaxSize) {
          this.mMap.delete(((Integer)this.mOrder.remove(0)).intValue());
        }
      }
      for (;;)
      {
        this.mMap.put(paramInt1, paramInt2);
        this.mOrder.add(Integer.valueOf(paramInt1));
        return;
        label77:
        this.mOrder.remove(Integer.valueOf(paramInt1));
      }
    }
    
    public void clear()
    {
      this.mMap.clear();
      this.mOrder.clear();
    }
    
    public int get(int paramInt)
    {
      return this.mMap.get(paramInt, -1);
    }
  }
  
  public static abstract interface i
  {
    public abstract void Bb(int paramInt);
    
    public abstract void Bc(int paramInt);
  }
  
  public static abstract interface j
  {
    public abstract void remove(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView
 * JD-Core Version:    0.7.0.1
 */