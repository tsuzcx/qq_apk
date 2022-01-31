package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlite.R.styleable;

public class DragSortListView
  extends ListView
{
  static final int DRAGGING = 4;
  public static final int DRAG_NEG_X = 2;
  public static final int DRAG_NEG_Y = 8;
  public static final int DRAG_POS_X = 1;
  public static final int DRAG_POS_Y = 4;
  static final int DROPPING = 2;
  private static final int IDLE = 0;
  private static final int NO_CANCEL = 0;
  private static final int ON_INTERCEPT_TOUCH_EVENT = 2;
  private static final int ON_TOUCH_EVENT = 1;
  static final int REMOVING = 1;
  private static final int STOPPED = 3;
  private static final int sCacheSize = 3;
  private boolean ignoreDeleteEnabled = false;
  private DragSortListView.AdapterWrapper mAdapterWrapper;
  private boolean mAnimate = false;
  private boolean mBlockLayoutRequests = false;
  private MotionEvent mCancelEvent;
  private int mCancelMethod = 0;
  private DragSortListView.HeightCache mChildHeightCache = new DragSortListView.HeightCache(this, 3);
  private float mCurrFloatAlpha = 1.0F;
  private boolean mDelImmediately;
  private int mDownScrollStartY;
  float mDownScrollStartYF;
  private int mDragDeltaX;
  int mDragDeltaY;
  float mDragDownScrollHeight;
  private float mDragDownScrollStartFrac = 0.3333333F;
  private boolean mDragEnabled = true;
  private int mDragFlags = 0;
  private DragSortListView.DragListener mDragListener;
  private DragSortListView.DragScroller mDragScroller;
  private DragSortListView.DragSortTracker mDragSortTracker;
  private int mDragStartY;
  int mDragState = 0;
  float mDragUpScrollHeight;
  private float mDragUpScrollStartFrac = 0.3333333F;
  private DragSortListView.DropAnimator mDropAnimator;
  private DragSortListView.DropListener mDropListener;
  int mFirstExpPos;
  private float mFloatAlpha = 1.0F;
  Point mFloatLoc = new Point();
  int mFloatPos;
  private View mFloatView;
  int mFloatViewHeight;
  int mFloatViewHeightHalf;
  private boolean mFloatViewInvalidated = false;
  private DragSortListView.FloatViewManager mFloatViewManager = null;
  int mFloatViewMid;
  private boolean mFloatViewOnMeasured = false;
  private boolean mIgnoreTouchEvent = false;
  private boolean mInTouchEvent = false;
  private boolean mIsDelEvent;
  private boolean mIsDelShow;
  private boolean mIsItemEvent = true;
  private boolean mIsLeftEvent;
  private boolean mIsUpdateEvent;
  int mItemHeightCollapsed = 1;
  private boolean mLastCallWasIntercept = false;
  private int mLastX;
  int mLastY;
  private DragSortListView.LeftEventListener mLeftEventListener;
  private DragSortListView.LiftAnimator mLiftAnimator;
  private boolean mListViewIntercepted = false;
  float mMaxScrollSpeed = 0.5F;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  int mProgressPos = -1;
  private DragSortListView.RemoveAnimator mRemoveAnimator;
  private DragSortListView.RemoveListener mRemoveListener;
  float mRemoveVelocityX = 0.0F;
  private View[] mSampleViewTypes = new View[1];
  DragSortListView.DragScrollProfile mScrollProfile = new DragSortListView.1(this);
  int mSecondExpPos;
  private Rect mShaderRect = null;
  private float mSlideFrac = 0.0F;
  private float mSlideRegionFrac = 0.25F;
  int mSrcPos;
  int mTapPos;
  private Point mTouchLoc = new Point();
  private boolean mTrackDragSort = false;
  private int mUpScrollStartY;
  float mUpScrollStartYF;
  boolean mUseRemoveVelocity;
  private int mWidthMeasureSpec = 0;
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
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.c, 0, 0);
      this.mItemHeightCollapsed = Math.max(1, paramContext.getDimensionPixelSize(0, 1));
      this.mTrackDragSort = paramContext.getBoolean(5, false);
      if (this.mTrackDragSort) {
        this.mDragSortTracker = new DragSortListView.DragSortTracker(this);
      }
      this.mFloatAlpha = paramContext.getFloat(6, this.mFloatAlpha);
      this.mCurrFloatAlpha = this.mFloatAlpha;
      this.mDragEnabled = paramContext.getBoolean(10, this.mDragEnabled);
      this.ignoreDeleteEnabled = paramContext.getBoolean(18, this.ignoreDeleteEnabled);
      this.mSlideRegionFrac = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(7, 0.75F)));
      if (this.mSlideRegionFrac > 0.0F)
      {
        bool1 = true;
        this.mAnimate = bool1;
        setDragScrollStart(paramContext.getFloat(1, this.mDragUpScrollStartFrac));
        this.mMaxScrollSpeed = paramContext.getFloat(2, this.mMaxScrollSpeed);
        j = paramContext.getInt(8, 150);
        i = paramContext.getInt(9, 150);
        if (paramContext.getBoolean(17, true))
        {
          bool1 = paramContext.getBoolean(12, false);
          int k = paramContext.getInt(4, 1);
          boolean bool2 = paramContext.getBoolean(11, true);
          int m = paramContext.getInt(13, 0);
          int n = paramContext.getResourceId(14, 0);
          int i1 = paramContext.getResourceId(15, 0);
          int i2 = paramContext.getResourceId(16, 0);
          int i3 = paramContext.getColor(3, -16777216);
          paramAttributeSet = new DragSortController(this, n, m, k, i2, i1);
          paramAttributeSet.setRemoveEnabled(bool1);
          paramAttributeSet.setSortEnabled(bool2);
          paramAttributeSet.setBackgroundColor(i3);
          this.mFloatViewManager = paramAttributeSet;
          super.setOnTouchListener(paramAttributeSet);
        }
        paramContext.recycle();
      }
    }
    for (;;)
    {
      this.mDragScroller = new DragSortListView.DragScroller(this);
      this.mDelImmediately = true;
      if (j > 0) {
        this.mRemoveAnimator = new DragSortListView.RemoveAnimator(this, 0.5F, j);
      }
      if (i > 0) {
        this.mDropAnimator = new DragSortListView.DropAnimator(this, 0.5F, i);
      }
      this.mCancelEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DragSortListView.2(this);
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
  
  private static int buildRunList(SparseBooleanArray paramSparseBooleanArray, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = findFirstSetIndex(paramSparseBooleanArray, paramInt1, paramInt2);
    if (j == -1) {
      return 0;
    }
    int m = paramSparseBooleanArray.keyAt(j);
    int i = m + 1;
    j += 1;
    int k = 0;
    if (j < paramSparseBooleanArray.size())
    {
      int n = paramSparseBooleanArray.keyAt(j);
      if (n < paramInt2)
      {
        if (!paramSparseBooleanArray.valueAt(j)) {}
        for (;;)
        {
          j += 1;
          break;
          if (n == i)
          {
            i += 1;
          }
          else
          {
            paramArrayOfInt1[k] = m;
            paramArrayOfInt2[k] = i;
            k += 1;
            i = n + 1;
            m = n;
          }
        }
      }
    }
    j = i;
    if (i == paramInt2) {
      j = paramInt1;
    }
    paramArrayOfInt1[k] = m;
    paramArrayOfInt2[k] = j;
    i = k + 1;
    paramInt2 = i;
    if (i > 1)
    {
      paramInt2 = i;
      if (paramArrayOfInt1[0] == paramInt1)
      {
        paramInt2 = i;
        if (paramArrayOfInt2[(i - 1)] == paramInt1)
        {
          paramArrayOfInt1[0] = paramArrayOfInt1[(i - 1)];
          paramInt2 = i - 1;
        }
      }
    }
    return paramInt2;
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
    int i = this.mDragScroller.getScrollDir();
    if ((paramInt1 > this.mLastY) && (paramInt1 > this.mDownScrollStartY) && (i != 1))
    {
      if (i != -1) {
        this.mDragScroller.stopScrolling(true);
      }
      this.mDragScroller.startScrolling(1);
    }
    do
    {
      return;
      if ((paramInt2 < this.mLastY) && (paramInt2 < this.mUpScrollStartY) && (i != 0))
      {
        if (i != -1) {
          this.mDragScroller.stopScrolling(true);
        }
        this.mDragScroller.startScrolling(0);
        return;
      }
    } while ((paramInt2 < this.mUpScrollStartY) || (paramInt1 > this.mDownScrollStartY) || (!this.mDragScroller.isScrolling()));
    this.mDragScroller.stopScrolling(true);
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
    this.mChildHeightCache.clear();
  }
  
  private void doRemoveItem()
  {
    doRemoveItem(this.mSrcPos - getHeaderViewsCount());
  }
  
  private void doRemoveItem(int paramInt)
  {
    this.mDragState = 1;
    if (this.mRemoveListener != null) {
      this.mRemoveListener.a(paramInt);
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
    if ((this.mDropListener != null) && (this.mFloatPos >= 0) && (this.mFloatPos < getCount()))
    {
      int i = getHeaderViewsCount();
      this.mDropListener.a_(this.mSrcPos - i, this.mFloatPos - i);
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
  
  private static int findFirstSetIndex(SparseBooleanArray paramSparseBooleanArray, int paramInt1, int paramInt2)
  {
    int i = paramSparseBooleanArray.size();
    paramInt1 = insertionIndexForKey(paramSparseBooleanArray, paramInt1);
    while ((paramInt1 < i) && (paramSparseBooleanArray.keyAt(paramInt1) < paramInt2) && (!paramSparseBooleanArray.valueAt(paramInt1))) {
      paramInt1 += 1;
    }
    if (paramInt1 != i)
    {
      i = paramInt1;
      if (paramSparseBooleanArray.keyAt(paramInt1) < paramInt2) {}
    }
    else
    {
      i = -1;
    }
    return i;
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
  
  private int getEventPosition(MotionEvent paramMotionEvent)
  {
    return super.pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  private ImageView getLeftIndicator(int paramInt)
  {
    paramInt -= getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ImageView)localView.findViewById(2131298233);
      }
    }
    return null;
  }
  
  private static int insertionIndexForKey(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    int i = 0;
    int j = paramSparseBooleanArray.size();
    if (j - i > 0)
    {
      int k = i + j >> 1;
      if (paramSparseBooleanArray.keyAt(k) < paramInt) {
        i = k + 1;
      }
      for (;;)
      {
        break;
        j = k;
      }
    }
    return i;
  }
  
  private void invalidateFloatView()
  {
    this.mFloatViewInvalidated = true;
  }
  
  private boolean isEventInView(View paramView, int paramInt1, int paramInt2)
  {
    if (this.mShaderRect == null) {
      this.mShaderRect = new Rect();
    }
    paramView.getDrawingRect(this.mShaderRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.mShaderRect.left = arrayOfInt[0];
    this.mShaderRect.top = arrayOfInt[1];
    this.mShaderRect.right += arrayOfInt[0];
    paramView = this.mShaderRect;
    int i = this.mShaderRect.bottom;
    paramView.bottom = (arrayOfInt[1] + i);
    return this.mShaderRect.contains(paramInt1, paramInt2);
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
  
  private static int rotate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4 - paramInt3;
    paramInt2 = paramInt1 + paramInt2;
    if (paramInt2 < paramInt3) {
      paramInt1 = paramInt2 + i;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (paramInt2 < paramInt4);
    return paramInt2 - i;
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
    if (this.mFloatViewManager != null)
    {
      this.mTouchLoc.set(this.mX, this.mY);
      this.mFloatViewManager.onDragFloatView(this.mFloatView, this.mFloatLoc, this.mTouchLoc);
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
        if (this.mDragListener != null) {
          this.mDragListener.a(this.mFloatPos - n, j - n);
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
  
  public void cancelDrag()
  {
    if (this.mDragState == 4)
    {
      this.mDragScroller.stopScrolling(true);
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
      if (this.mFloatViewManager != null) {
        this.mFloatViewManager.onDestroyFloatView(this.mFloatView);
      }
      this.mFloatView = null;
      invalidate();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
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
      j = this.mChildHeightCache.get(paramInt);
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
      this.mChildHeightCache.add(paramInt, i);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.mSampleViewTypes[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  public ShaderAnimLayout getDelButton(int paramInt)
  {
    paramInt -= super.getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= super.getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ShaderAnimLayout)localView.findViewById(2131296441);
      }
    }
    return null;
  }
  
  public float getFloatAlpha()
  {
    return this.mCurrFloatAlpha;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.mAdapterWrapper == null) {
      return null;
    }
    return this.mAdapterWrapper.getAdapter();
  }
  
  public View getItemChild(int paramInt1, int paramInt2)
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
  
  public void hideDelButton()
  {
    Object localObject = getDelButton(this.mSrcPos);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).d();
      this.mIsDelShow = false;
      if (this.mProgressPos >= 0)
      {
        localObject = (RelativeLayout)getItemChild(this.mProgressPos, 2131297125);
        if (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131297126)).getVisibility() == 0) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public void hideDelButtonWithoutAnimation()
  {
    Object localObject = getDelButton(this.mSrcPos);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).e();
      this.mIsDelShow = false;
      if (this.mProgressPos >= 0)
      {
        localObject = (RelativeLayout)getItemChild(this.mProgressPos, 2131297125);
        if (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131297126)).getVisibility() == 0) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public boolean isDragEnabled()
  {
    return this.mDragEnabled;
  }
  
  public boolean isScrolling()
  {
    return this.mDragScroller.isScrolling();
  }
  
  protected void layoutChildren()
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
  
  public void moveCheckState(int paramInt1, int paramInt2)
  {
    SparseBooleanArray localSparseBooleanArray = getCheckedItemPositions();
    int j;
    if (paramInt2 < paramInt1) {
      j = paramInt1;
    }
    for (int i = paramInt2;; i = paramInt1)
    {
      int k = j + 1;
      int[] arrayOfInt1 = new int[localSparseBooleanArray.size()];
      int[] arrayOfInt2 = new int[localSparseBooleanArray.size()];
      j = buildRunList(localSparseBooleanArray, i, k, arrayOfInt1, arrayOfInt2);
      if ((j == 1) && (arrayOfInt1[0] == arrayOfInt2[0])) {}
      for (;;)
      {
        return;
        if (paramInt1 < paramInt2)
        {
          paramInt1 = 0;
          while (paramInt1 != j)
          {
            setItemChecked(rotate(arrayOfInt1[paramInt1], -1, i, k), true);
            setItemChecked(rotate(arrayOfInt2[paramInt1], -1, i, k), false);
            paramInt1 += 1;
          }
        }
        else
        {
          paramInt1 = 0;
          while (paramInt1 != j)
          {
            setItemChecked(arrayOfInt1[paramInt1], false);
            setItemChecked(arrayOfInt2[paramInt1], true);
            paramInt1 += 1;
          }
        }
      }
      j = paramInt2;
    }
  }
  
  public void moveItem(int paramInt1, int paramInt2)
  {
    if (this.mDropListener != null)
    {
      int i = getInputAdapter().getCount();
      if ((paramInt1 >= 0) && (paramInt1 < i) && (paramInt2 >= 0) && (paramInt2 < i)) {
        this.mDropListener.a_(paramInt1, paramInt2);
      }
    }
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
      this.mDragSortTracker.appendState();
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
      if (this.mIsDelShow)
      {
        paramMotionEvent = getDelButton(this.mSrcPos);
        if (paramMotionEvent == null) {
          bool2 = false;
        }
      }
    }
    do
    {
      return bool2;
      if (isEventInView(paramMotionEvent, i, j)) {
        this.mIsDelEvent = true;
      }
      do
      {
        for (;;)
        {
          return true;
          hideDelButton();
          this.mIsItemEvent = false;
        }
        paramMotionEvent = (Button)getItemChild(this.mTapPos, 2131297085);
        if (paramMotionEvent == null) {
          return false;
        }
      } while (!isEventInView(paramMotionEvent, i, j));
      this.mIsUpdateEvent = true;
      return false;
      i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      ImageView localImageView = getLeftIndicator(i);
      if ((localImageView != null) && (isEventInView(localImageView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
      {
        if ((this.mIsDelShow) && (this.mSrcPos != i))
        {
          this.mIsLeftEvent = false;
          return true;
        }
        this.mSrcPos = i;
        this.mIsLeftEvent = true;
        return true;
      }
      if (this.mIsDelShow)
      {
        i = (int)paramMotionEvent.getRawX();
        j = (int)paramMotionEvent.getRawY();
        paramMotionEvent = getDelButton(this.mSrcPos);
        if (paramMotionEvent == null) {
          return false;
        }
        if (isEventInView(paramMotionEvent, i, j)) {
          this.mIsDelEvent = true;
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
  
  protected void onMeasure(int paramInt1, int paramInt2)
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
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    updateScrollStarts();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIgnoreTouchEvent)
    {
      this.mIgnoreTouchEvent = false;
      return false;
    }
    if (!this.mDragEnabled)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.mIsDelShow)
        {
          if (this.mIsDelEvent) {
            if (this.mDelImmediately)
            {
              hideDelButtonWithoutAnimation();
              removeItem(this.mSrcPos);
              this.mIsDelEvent = false;
            }
          }
          for (;;)
          {
            this.mIsDelShow = false;
            return false;
            if (this.mRemoveListener != null) {
              this.mRemoveListener.a(this.mSrcPos);
            }
            this.mIsDelEvent = false;
            return false;
            hideDelButton();
          }
        }
        Button localButton = (Button)getItemChild(this.mTapPos, 2131297085);
        if ((this.mIsUpdateEvent) && (localButton != null))
        {
          this.mIsUpdateEvent = false;
          this.mIsItemEvent = true;
          return false;
        }
        if (!this.mIsItemEvent)
        {
          this.mIsItemEvent = true;
          return true;
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.mIsLeftEvent)
      {
        if (this.mIsDelShow)
        {
          if (this.mLeftEventListener != null) {
            this.mLeftEventListener.a(this.mSrcPos);
          }
          paramMotionEvent = getDelButton(this.mSrcPos);
          if (paramMotionEvent != null)
          {
            this.mIsDelShow = false;
            paramMotionEvent.d();
          }
        }
        for (;;)
        {
          this.mIsLeftEvent = false;
          return false;
          if (this.mLeftEventListener != null) {
            this.mLeftEventListener.b(this.mSrcPos);
          }
          paramMotionEvent = getDelButton(this.mSrcPos);
          if (paramMotionEvent != null)
          {
            this.mIsDelShow = true;
            paramMotionEvent.a();
          }
        }
      }
      if (this.mIsDelShow)
      {
        if (this.mIsDelEvent) {
          if (!this.ignoreDeleteEnabled)
          {
            hideDelButtonWithoutAnimation();
            removeItem(this.mSrcPos);
            this.mIsDelEvent = false;
          }
        }
        for (;;)
        {
          this.mIsDelShow = false;
          return false;
          if (this.mRemoveListener != null) {
            this.mRemoveListener.a(this.mSrcPos);
          }
          this.mIsDelEvent = false;
          return false;
          hideDelButton();
        }
      }
    }
    boolean bool1 = this.mLastCallWasIntercept;
    this.mLastCallWasIntercept = false;
    if (!bool1) {
      saveTouchCoords(paramMotionEvent);
    }
    boolean bool2;
    if (this.mDragState == 4)
    {
      onDragTouchEvent(paramMotionEvent);
      bool2 = true;
      return bool2;
    }
    if ((this.mDragState == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.mCancelMethod = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        doActionUpOrCancel();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public void removeCheckState(int paramInt)
  {
    SparseBooleanArray localSparseBooleanArray = getCheckedItemPositions();
    if (localSparseBooleanArray.size() == 0) {}
    for (;;)
    {
      return;
      int[] arrayOfInt1 = new int[localSparseBooleanArray.size()];
      int[] arrayOfInt2 = new int[localSparseBooleanArray.size()];
      int j = localSparseBooleanArray.keyAt(localSparseBooleanArray.size() - 1) + 1;
      int k = buildRunList(localSparseBooleanArray, paramInt, j, arrayOfInt1, arrayOfInt2);
      int i = 0;
      while (i != k)
      {
        if ((arrayOfInt1[i] != paramInt) && ((arrayOfInt2[i] >= arrayOfInt1[i]) || (arrayOfInt2[i] <= paramInt))) {
          setItemChecked(rotate(arrayOfInt1[i], -1, paramInt, j), true);
        }
        setItemChecked(rotate(arrayOfInt2[i], -1, paramInt, j), false);
        i += 1;
      }
    }
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
    while (this.mRemoveAnimator != null)
    {
      this.mRemoveAnimator.start();
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
      this.mAdapterWrapper = new DragSortListView.AdapterWrapper(this, paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.mObserver);
      if ((paramListAdapter instanceof DragSortListView.DropListener)) {
        setDropListener((DragSortListView.DropListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.DragListener)) {
        setDragListener((DragSortListView.DragListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.RemoveListener)) {
        setRemoveListener((DragSortListView.RemoveListener)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.mAdapterWrapper);
      return;
      this.mAdapterWrapper = null;
    }
  }
  
  public void setDelImmediately(boolean paramBoolean)
  {
    this.mDelImmediately = paramBoolean;
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.mDragEnabled = paramBoolean;
    this.mIsDelShow = false;
    this.mIsDelEvent = false;
    this.mIsLeftEvent = false;
  }
  
  public void setDragListener(DragSortListView.DragListener paramDragListener)
  {
    this.mDragListener = paramDragListener;
  }
  
  public void setDragScrollProfile(DragSortListView.DragScrollProfile paramDragScrollProfile)
  {
    if (paramDragScrollProfile != null) {
      this.mScrollProfile = paramDragScrollProfile;
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
  
  public void setDragSortListener(DragSortListView.DragSortListener paramDragSortListener)
  {
    setDropListener(paramDragSortListener);
    setDragListener(paramDragSortListener);
    setRemoveListener(paramDragSortListener);
  }
  
  public void setDropListener(DragSortListView.DropListener paramDropListener)
  {
    this.mDropListener = paramDropListener;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.mCurrFloatAlpha = paramFloat;
  }
  
  public void setFloatViewManager(DragSortListView.FloatViewManager paramFloatViewManager)
  {
    this.mFloatViewManager = paramFloatViewManager;
  }
  
  public void setLeftEventListener(DragSortListView.LeftEventListener paramLeftEventListener)
  {
    this.mLeftEventListener = paramLeftEventListener;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.mMaxScrollSpeed = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.RemoveListener paramRemoveListener)
  {
    this.mRemoveListener = paramRemoveListener;
  }
  
  public void setSrcPos(int paramInt)
  {
    this.mSrcPos = paramInt;
  }
  
  public void setTapPos(int paramInt)
  {
    this.mTapPos = paramInt;
  }
  
  public void showDelButton()
  {
    if (this.mIsDelShow) {}
    Object localObject;
    ProgressCircle localProgressCircle;
    do
    {
      do
      {
        return;
        localObject = getDelButton(this.mSrcPos);
      } while (localObject == null);
      ((ShaderAnimLayout)localObject).a();
      this.mIsDelShow = true;
      localObject = (RelativeLayout)getItemChild(this.mSrcPos, 2131297125);
      localProgressCircle = (ProgressCircle)((RelativeLayout)localObject).findViewById(2131297126);
    } while ((((RelativeLayout)localObject).getVisibility() != 0) || (localProgressCircle.getVisibility() != 0));
    ((RelativeLayout)localObject).setVisibility(8);
    this.mProgressPos = this.mSrcPos;
  }
  
  public boolean startDrag(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!this.mInTouchEvent) || (this.mFloatViewManager == null)) {}
    View localView;
    do
    {
      return false;
      localView = this.mFloatViewManager.onCreateFloatView(paramInt1);
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
      this.mDragSortTracker.startTracking();
    }
    switch (this.mCancelMethod)
    {
    }
    for (;;)
    {
      requestLayout();
      if (this.mLiftAnimator == null) {
        break;
      }
      this.mLiftAnimator.start();
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
      this.mDragScroller.stopScrolling(true);
      if (paramBoolean) {
        removeItem(this.mSrcPos - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.mTrackDragSort) {
          this.mDragSortTracker.stopTracking();
        }
        return true;
        if (this.mDropAnimator != null) {
          this.mDropAnimator.start();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView
 * JD-Core Version:    0.7.0.1
 */