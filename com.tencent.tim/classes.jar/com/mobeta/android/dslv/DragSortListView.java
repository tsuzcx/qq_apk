package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView
  extends ListView
{
  private static final int DRAGGING = 4;
  public static final int DRAG_NEG_X = 2;
  public static final int DRAG_NEG_Y = 8;
  public static final int DRAG_POS_X = 1;
  public static final int DRAG_POS_Y = 4;
  private static final int DROPPING = 2;
  private static final int IDLE = 0;
  private static final int NO_CANCEL = 0;
  private static final int ON_INTERCEPT_TOUCH_EVENT = 2;
  private static final int ON_TOUCH_EVENT = 1;
  private static final int REMOVING = 1;
  private static final int STOPPED = 3;
  private static final int sCacheSize = 3;
  private AdapterWrapper mAdapterWrapper;
  private boolean mAnimate = false;
  private boolean mBlockLayoutRequests = false;
  private MotionEvent mCancelEvent;
  private int mCancelMethod = 0;
  private HeightCache mChildHeightCache = new HeightCache(3);
  private float mCurrFloatAlpha = 1.0F;
  private int mDownScrollStartY;
  private float mDownScrollStartYF;
  private int mDragDeltaX;
  private int mDragDeltaY;
  private float mDragDownScrollHeight;
  private float mDragDownScrollStartFrac = 0.3333333F;
  private boolean mDragEnabled = true;
  private int mDragFlags = 0;
  private DragListener mDragListener;
  private DragScroller mDragScroller;
  private DragSortTracker mDragSortTracker;
  private int mDragStartY;
  private int mDragState = 0;
  private float mDragUpScrollHeight;
  private float mDragUpScrollStartFrac = 0.3333333F;
  private DropAnimator mDropAnimator;
  private DropListener mDropListener;
  private int mFirstExpPos;
  private float mFloatAlpha = 1.0F;
  private Point mFloatLoc = new Point();
  private int mFloatPos;
  private View mFloatView;
  private int mFloatViewHeight;
  private int mFloatViewHeightHalf;
  private boolean mFloatViewInvalidated = false;
  private FloatViewManager mFloatViewManager = null;
  private int mFloatViewMid;
  private boolean mFloatViewOnMeasured = false;
  private boolean mIgnoreTouchEvent = false;
  private boolean mInTouchEvent = false;
  private int mItemHeightCollapsed = 1;
  private boolean mLastCallWasIntercept = false;
  private int mLastX;
  private int mLastY;
  private LiftAnimator mLiftAnimator;
  private boolean mListViewIntercepted = false;
  private boolean mLockScroll = false;
  private float mMaxScrollSpeed = 0.5F;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  private RemoveAnimator mRemoveAnimator;
  private RemoveListener mRemoveListener;
  private float mRemoveVelocityX = 0.0F;
  private View[] mSampleViewTypes = new View[1];
  private DragScrollProfile mScrollProfile = new DragSortListView.1(this);
  private int mSecondExpPos;
  private float mSlideFrac = 0.0F;
  private float mSlideRegionFrac = 0.25F;
  private int mSrcPos;
  private Point mTouchLoc = new Point();
  private boolean mTrackDragSort = false;
  private int mUpScrollStartY;
  private float mUpScrollStartYF;
  private boolean mUseRemoveVelocity;
  private int mWidthMeasureSpec = 0;
  private int mX;
  private int mY;
  
  public DragSortListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int j = 150;
    boolean bool1;
    int i;
    if (paramAttributeSet != null)
    {
      paramContext = QMApplicationContext.sharedInstance().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, 0, 0);
      this.mItemHeightCollapsed = Math.max(1, paramContext.getDimensionPixelSize(R.styleable.DragSortListView_collapsed_height, 1));
      this.mTrackDragSort = paramContext.getBoolean(R.styleable.DragSortListView_track_drag_sort, false);
      if (this.mTrackDragSort) {
        this.mDragSortTracker = new DragSortTracker();
      }
      this.mFloatAlpha = paramContext.getFloat(R.styleable.DragSortListView_float_alpha, this.mFloatAlpha);
      this.mCurrFloatAlpha = this.mFloatAlpha;
      this.mDragEnabled = paramContext.getBoolean(R.styleable.DragSortListView_drag_enabled, this.mDragEnabled);
      this.mSlideRegionFrac = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(R.styleable.DragSortListView_slide_shuffle_speed, 0.75F)));
      if (this.mSlideRegionFrac > 0.0F)
      {
        bool1 = true;
        this.mAnimate = bool1;
        setDragScrollStart(paramContext.getFloat(R.styleable.DragSortListView_drag_scroll_start, this.mDragUpScrollStartFrac));
        this.mMaxScrollSpeed = paramContext.getFloat(R.styleable.DragSortListView_max_drag_scroll_speed, this.mMaxScrollSpeed);
        j = paramContext.getInt(R.styleable.DragSortListView_remove_animation_duration, 150);
        i = paramContext.getInt(R.styleable.DragSortListView_drop_animation_duration, 150);
        if (paramContext.getBoolean(R.styleable.DragSortListView_use_default_controller, true))
        {
          bool1 = paramContext.getBoolean(R.styleable.DragSortListView_remove_enabled, false);
          int k = paramContext.getInt(R.styleable.DragSortListView_remove_mode, 1);
          boolean bool2 = paramContext.getBoolean(R.styleable.DragSortListView_sort_enabled, true);
          int m = paramContext.getInt(R.styleable.DragSortListView_drag_start_mode, 1);
          int n = paramContext.getResourceId(R.styleable.DragSortListView_drag_handle_id, 0);
          int i1 = paramContext.getResourceId(R.styleable.DragSortListView_fling_handle_id, 0);
          int i2 = paramContext.getResourceId(R.styleable.DragSortListView_click_remove_id, 0);
          int i3 = paramContext.getColor(R.styleable.DragSortListView_float_background_color, -16777216);
          paramAttributeSet = new DragSortController(this, n, m, k, i2, i1);
          paramAttributeSet.setRemoveEnabled(bool1);
          paramAttributeSet.setSortEnabled(bool2);
          paramAttributeSet.setBackgroundColor(i3);
          this.mFloatViewManager = paramAttributeSet;
          setOnTouchListener(paramAttributeSet);
        }
        paramContext.recycle();
      }
    }
    for (;;)
    {
      this.mDragScroller = new DragScroller();
      if (j > 0) {
        this.mRemoveAnimator = new RemoveAnimator(0.5F, j);
      }
      if (i > 0) {
        this.mDropAnimator = new DropAnimator(0.5F, i);
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
  
  private void adjustItem(int paramInt)
  {
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      adjustItem(paramInt, localView, false);
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
    int j = getFirstVisiblePosition();
    if (this.mSrcPos < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
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
        break label114;
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
    label114:
    do
    {
      return i;
      i = 0;
      break;
      return this.mFloatViewHeight;
      if (this.mSrcPos == this.mSecondExpPos) {
        return this.mFloatViewHeight - k;
      }
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
  
  private void destroyFloatView()
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
  
  private void doDragFloatView(int paramInt, View paramView, boolean paramBoolean)
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
  
  private void doDragFloatView(boolean paramBoolean)
  {
    int i = getFirstVisiblePosition();
    int j = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null) {
      return;
    }
    doDragFloatView(i + j, localView, paramBoolean);
  }
  
  private void doRemoveItem()
  {
    doRemoveItem(this.mSrcPos - getHeaderViewsCount());
  }
  
  private void doRemoveItem(int paramInt)
  {
    this.mDragState = 1;
    if (this.mRemoveListener != null) {
      this.mRemoveListener.remove(paramInt);
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
    Drawable localDrawable = getDivider();
    int m = getDividerHeight();
    ViewGroup localViewGroup;
    int j;
    int k;
    int i;
    if ((localDrawable != null) && (m != 0))
    {
      localViewGroup = (ViewGroup)getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        j = getPaddingLeft();
        k = getWidth() - getPaddingRight();
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
      this.mDropListener.drop(this.mSrcPos - i, this.mFloatPos - i);
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
  
  private int getChildHeight(int paramInt)
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
  
  private int getItemHeight(int paramInt)
  {
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      return localView.getHeight();
    }
    return calcItemHeight(paramInt, getChildHeight(paramInt));
  }
  
  private int getShuffleEdge(int paramInt1, int paramInt2)
  {
    int i = getHeaderViewsCount();
    int j = getFooterViewsCount();
    if ((paramInt1 <= i) || (paramInt1 >= getCount() - j)) {
      return paramInt2;
    }
    j = getDividerHeight();
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
  
  private void printPosData()
  {
    Log.d("mobeta", "mSrcPos=" + this.mSrcPos + " mFirstExpPos=" + this.mFirstExpPos + " mSecondExpPos=" + this.mSecondExpPos);
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
    int i = getFirstVisiblePosition();
    int j = this.mFirstExpPos;
    View localView2 = getChildAt(j - i);
    View localView1 = localView2;
    if (localView2 == null)
    {
      j = i + getChildCount() / 2;
      localView1 = getChildAt(j - i);
    }
    int i1 = localView1.getTop();
    int i2 = localView1.getHeight();
    i = getShuffleEdge(j, i1);
    int i4 = getDividerHeight();
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
        n = getHeaderViewsCount();
        i3 = getFooterViewsCount();
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
          this.mDragListener.drag(this.mFloatPos - n, j - n);
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
        j = getCount() - i3 - 1;
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
  
  public void initStyle()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    localLayoutParams.gravity = 48;
    setLayoutParams(localLayoutParams);
    setDividerHeight(0);
    setFadingEdgeLength(0);
    setBackgroundColor(getResources().getColor(2131167684));
    setVisibility(8);
  }
  
  public boolean isDragEnabled()
  {
    return this.mDragEnabled;
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
    ListAdapter localListAdapter;
    if (this.mDropListener != null)
    {
      localListAdapter = getInputAdapter();
      if (localListAdapter != null) {
        break label50;
      }
    }
    label50:
    for (int i = 0;; i = localListAdapter.getCount())
    {
      if ((paramInt1 >= 0) && (paramInt1 < i) && (paramInt2 >= 0) && (paramInt2 < i)) {
        this.mDropListener.drop(paramInt1, paramInt2);
      }
      return;
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
    if (!this.mDragEnabled) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    saveTouchCoords(paramMotionEvent);
    this.mLastCallWasIntercept = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.mDragState != 0)
      {
        this.mIgnoreTouchEvent = true;
        return true;
      }
      this.mInTouchEvent = true;
    }
    if (this.mFloatView != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.mInTouchEvent = false;
      }
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.mListViewIntercepted = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
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
    boolean bool2 = false;
    if ((this.mLockScroll) && (paramMotionEvent.getAction() == 2)) {
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      if (this.mIgnoreTouchEvent)
      {
        this.mIgnoreTouchEvent = false;
        return false;
      }
      if (!this.mDragEnabled) {
        return super.onTouchEvent(paramMotionEvent);
      }
      bool1 = this.mLastCallWasIntercept;
      this.mLastCallWasIntercept = false;
      if (!bool1) {
        saveTouchCoords(paramMotionEvent);
      }
      if (this.mDragState == 4)
      {
        onDragTouchEvent(paramMotionEvent);
        return true;
      }
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
        View localView = getChildAt(this.mSrcPos - getFirstVisiblePosition());
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
      this.mAdapterWrapper = new AdapterWrapper(paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.mObserver);
      if ((paramListAdapter instanceof DropListener)) {
        setDropListener((DropListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragListener)) {
        setDragListener((DragListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof RemoveListener)) {
        setRemoveListener((RemoveListener)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.mAdapterWrapper);
      return;
      this.mAdapterWrapper = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.mDragEnabled = paramBoolean;
  }
  
  public void setDragListener(DragListener paramDragListener)
  {
    this.mDragListener = paramDragListener;
  }
  
  public void setDragScrollProfile(DragScrollProfile paramDragScrollProfile)
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
  
  public void setDragSortListener(DragSortListener paramDragSortListener)
  {
    setDropListener(paramDragSortListener);
    setDragListener(paramDragSortListener);
    setRemoveListener(paramDragSortListener);
  }
  
  public void setDropListener(DropListener paramDropListener)
  {
    this.mDropListener = paramDropListener;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.mCurrFloatAlpha = paramFloat;
  }
  
  public void setFloatViewManager(FloatViewManager paramFloatViewManager)
  {
    this.mFloatViewManager = paramFloatViewManager;
  }
  
  public void setLockScroll(boolean paramBoolean)
  {
    this.mLockScroll = paramBoolean;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.mMaxScrollSpeed = paramFloat;
  }
  
  public void setRemoveListener(RemoveListener paramRemoveListener)
  {
    this.mRemoveListener = paramRemoveListener;
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
  
  class AdapterWrapper
    extends BaseAdapter
  {
    private ListAdapter mAdapter;
    
    public AdapterWrapper(ListAdapter paramListAdapter)
    {
      this.mAdapter = paramListAdapter;
      this.mAdapter.registerDataSetObserver(new DragSortListView.AdapterWrapper.1(this, DragSortListView.this));
    }
    
    public boolean areAllItemsEnabled()
    {
      return this.mAdapter.areAllItemsEnabled();
    }
    
    public ListAdapter getAdapter()
    {
      return this.mAdapter;
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
        DragSortListView.this.adjustItem(DragSortListView.this.getHeaderViewsCount() + paramInt, (View)localObject, true);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
      View localView1 = this.mAdapter.getView(paramInt, null, DragSortListView.this);
      if ((localView1 instanceof Checkable)) {}
      for (Object localObject = new DragSortItemViewCheckable(QMApplicationContext.sharedInstance());; localObject = new DragSortItemView(QMApplicationContext.sharedInstance()))
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
  
  public static abstract interface DragListener
  {
    public abstract void drag(int paramInt1, int paramInt2);
  }
  
  public static abstract interface DragScrollProfile
  {
    public abstract float getSpeed(float paramFloat, long paramLong);
  }
  
  class DragScroller
    implements Runnable
  {
    public static final int DOWN = 1;
    public static final int STOP = -1;
    public static final int UP = 0;
    private float dt;
    private int dy;
    private boolean mAbort;
    private long mCurrTime;
    private int mFirstFooter;
    private int mLastHeader;
    private long mPrevTime;
    private float mScrollSpeed;
    private boolean mScrolling = false;
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
        this.mScrollSpeed = DragSortListView.this.mScrollProfile.getSpeed((DragSortListView.this.mUpScrollStartYF - i2) / DragSortListView.this.mDragUpScrollHeight, this.mPrevTime);
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
        DragSortListView.access$2602(DragSortListView.this, true);
        DragSortListView.this.setSelectionFromTop(i, j - k);
        DragSortListView.this.layoutChildren();
        DragSortListView.this.invalidate();
        DragSortListView.access$2602(DragSortListView.this, false);
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
        this.mScrollSpeed = (-DragSortListView.this.mScrollProfile.getSpeed((i1 - DragSortListView.this.mDownScrollStartYF) / DragSortListView.this.mDragDownScrollHeight, this.mPrevTime));
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
  
  public static abstract interface DragSortListener
    extends DragSortListView.DragListener, DragSortListView.DropListener, DragSortListView.RemoveListener
  {}
  
  class DragSortTracker
  {
    StringBuilder mBuilder = new StringBuilder();
    File mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    private int mNumFlushes = 0;
    private int mNumInBuffer = 0;
    private boolean mTracking = false;
    
    public DragSortTracker()
    {
      if (!this.mFile.exists()) {}
      try
      {
        this.mFile.createNewFile();
        Log.d("mobeta", "file created");
        return;
      }
      catch (IOException this$1)
      {
        Log.w("mobeta", "Could not create dslv_state.txt");
        Log.d("mobeta", DragSortListView.this.getMessage());
      }
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
      //   0: aload_0
      //   1: getfield 38	com/mobeta/android/dslv/DragSortListView$DragSortTracker:mTracking	Z
      //   4: ifne +4 -> 8
      //   7: return
      //   8: aconst_null
      //   9: astore_3
      //   10: iconst_1
      //   11: istore_1
      //   12: aload_0
      //   13: getfield 36	com/mobeta/android/dslv/DragSortListView$DragSortTracker:mNumFlushes	I
      //   16: ifne +5 -> 21
      //   19: iconst_0
      //   20: istore_1
      //   21: new 208	java/io/FileWriter
      //   24: dup
      //   25: aload_0
      //   26: getfield 53	com/mobeta/android/dslv/DragSortListView$DragSortTracker:mFile	Ljava/io/File;
      //   29: iload_1
      //   30: invokespecial 211	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
      //   33: astore_2
      //   34: aload_2
      //   35: aload_0
      //   36: getfield 32	com/mobeta/android/dslv/DragSortListView$DragSortTracker:mBuilder	Ljava/lang/StringBuilder;
      //   39: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   42: invokevirtual 218	java/io/FileWriter:write	(Ljava/lang/String;)V
      //   45: aload_0
      //   46: getfield 32	com/mobeta/android/dslv/DragSortListView$DragSortTracker:mBuilder	Ljava/lang/StringBuilder;
      //   49: iconst_0
      //   50: aload_0
      //   51: getfield 32	com/mobeta/android/dslv/DragSortListView$DragSortTracker:mBuilder	Ljava/lang/StringBuilder;
      //   54: invokevirtual 221	java/lang/StringBuilder:length	()I
      //   57: invokevirtual 225	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   60: pop
      //   61: aload_0
      //   62: aload_0
      //   63: getfield 36	com/mobeta/android/dslv/DragSortListView$DragSortTracker:mNumFlushes	I
      //   66: iconst_1
      //   67: iadd
      //   68: putfield 36	com/mobeta/android/dslv/DragSortListView$DragSortTracker:mNumFlushes	I
      //   71: aload_2
      //   72: invokevirtual 228	java/io/FileWriter:close	()V
      //   75: return
      //   76: astore_2
      //   77: return
      //   78: astore_2
      //   79: aconst_null
      //   80: astore_2
      //   81: aload_2
      //   82: invokevirtual 228	java/io/FileWriter:close	()V
      //   85: return
      //   86: astore_2
      //   87: return
      //   88: astore_2
      //   89: aload_3
      //   90: invokevirtual 228	java/io/FileWriter:close	()V
      //   93: aload_2
      //   94: athrow
      //   95: astore_3
      //   96: goto -3 -> 93
      //   99: astore 4
      //   101: aload_2
      //   102: astore_3
      //   103: aload 4
      //   105: astore_2
      //   106: goto -17 -> 89
      //   109: astore_3
      //   110: goto -29 -> 81
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	113	0	this	DragSortTracker
      //   11	19	1	bool	boolean
      //   33	39	2	localFileWriter	java.io.FileWriter
      //   76	1	2	localException1	java.lang.Exception
      //   78	1	2	localIOException1	IOException
      //   80	2	2	localObject1	Object
      //   86	1	2	localException2	java.lang.Exception
      //   88	14	2	localObject2	Object
      //   105	1	2	localObject3	Object
      //   9	81	3	localObject4	Object
      //   95	1	3	localException3	java.lang.Exception
      //   102	1	3	localObject5	Object
      //   109	1	3	localIOException2	IOException
      //   99	5	4	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   71	75	76	java/lang/Exception
      //   12	19	78	java/io/IOException
      //   21	34	78	java/io/IOException
      //   81	85	86	java/lang/Exception
      //   12	19	88	finally
      //   21	34	88	finally
      //   89	93	95	java/lang/Exception
      //   34	71	99	finally
      //   34	71	109	java/io/IOException
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
      DragSortListView.access$102(DragSortListView.this, 2);
      this.mInitDeltaY = (DragSortListView.this.mFloatLoc.y - getTargetY());
      this.mInitDeltaX = (DragSortListView.this.mFloatLoc.x - DragSortListView.this.getPaddingLeft());
    }
    
    public void onStop()
    {
      DragSortListView.this.dropFloatView();
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
  
  public static abstract interface DropListener
  {
    public abstract void drop(int paramInt1, int paramInt2);
  }
  
  public static abstract interface FloatViewManager
  {
    public abstract View onCreateFloatView(int paramInt);
    
    public abstract void onDestroyFloatView(View paramView);
    
    public abstract void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2);
  }
  
  class HeightCache
  {
    private SparseIntArray mMap;
    private int mMaxSize;
    private ArrayList<Integer> mOrder;
    
    public HeightCache(int paramInt)
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
  
  class LiftAnimator
    extends DragSortListView.SmoothAnimator
  {
    private float mFinalDragDeltaY;
    private float mInitDragDeltaY;
    
    public LiftAnimator(float paramFloat, int paramInt)
    {
      super(paramFloat, paramInt);
    }
    
    public void onStart()
    {
      this.mInitDragDeltaY = DragSortListView.this.mDragDeltaY;
      this.mFinalDragDeltaY = DragSortListView.this.mFloatViewHeightHalf;
    }
    
    public void onUpdate(float paramFloat1, float paramFloat2)
    {
      if (DragSortListView.this.mDragState != 4)
      {
        cancel();
        return;
      }
      DragSortListView.access$302(DragSortListView.this, (int)(this.mFinalDragDeltaY * paramFloat2 + (1.0F - paramFloat2) * this.mInitDragDeltaY));
      DragSortListView.this.mFloatLoc.y = (DragSortListView.this.mY - DragSortListView.this.mDragDeltaY);
      DragSortListView.this.doDragFloatView(true);
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
      DragSortListView.access$102(DragSortListView.this, 1);
      this.mFloatLocX = DragSortListView.this.mFloatLoc.x;
      if (DragSortListView.this.mUseRemoveVelocity)
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.this.mRemoveVelocityX == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.mFloatLocX < 0.0F) {
            DragSortListView.access$1602(localDragSortListView, i * f);
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
            DragSortListView.access$1602(DragSortListView.this, -f);
            return;
          }
        } while ((DragSortListView.this.mRemoveVelocityX <= 0.0F) || (DragSortListView.this.mRemoveVelocityX >= f));
        DragSortListView.access$1602(DragSortListView.this, f);
        return;
      }
      DragSortListView.this.destroyFloatView();
    }
    
    public void onStop()
    {
      DragSortListView.this.doRemoveItem();
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
          float f2 = DragSortListView.this.mRemoveVelocityX;
          if (DragSortListView.this.mRemoveVelocityX > 0.0F) {}
          for (i = 1;; i = -1)
          {
            DragSortListView.access$1602((DragSortListView)localObject, i * paramFloat2 * k + f2);
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
              this.mFirstChildHeight = DragSortListView.this.getChildHeight(this.mFirstPos, localView, false);
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
        this.mSecondChildHeight = DragSortListView.this.getChildHeight(this.mSecondPos, localView, false);
        this.mSecondStartBlank = (localView.getHeight() - this.mSecondChildHeight);
      }
      int i = Math.max((int)(this.mSecondStartBlank * paramFloat1), 1);
      Object localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + this.mSecondChildHeight);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public static abstract interface RemoveListener
  {
    public abstract void remove(int paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.mobeta.android.dslv.DragSortListView
 * JD-Core Version:    0.7.0.1
 */