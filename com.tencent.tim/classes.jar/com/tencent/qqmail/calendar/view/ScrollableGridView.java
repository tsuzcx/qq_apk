package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.qqmail.scroller.MScroller;
import com.tencent.qqmail.scroller.ScrollerListener;
import com.tencent.qqmail.scroller.effector.GridScreenContainer;
import com.tencent.qqmail.scroller.effector.SubScreenContainer;
import java.util.LinkedList;

public abstract class ScrollableGridView<T extends MScroller>
  extends ViewGroup
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, ScrollerListener, GridScreenContainer, SubScreenContainer
{
  private static final int LAYOUT_MODE_ABOVE = 1;
  private static final int LAYOUT_MODE_BELOW = 0;
  private static final int TOUCH_STATE_REST = 0;
  private static final int TOUCH_STATE_SCROLLING = 1;
  protected BaseAdapter mAdapter;
  protected final LinkedList<View> mCachedItemViews = new LinkedList();
  protected int mCurrentScreen = 0;
  protected int mFirstItemPosition;
  protected int mGridCellHeight;
  protected int mGridCellWidth;
  protected Rect mGridPadding = new Rect();
  protected int mLastItemPosition;
  private float mLastMotionX;
  private float mLastMotionY;
  protected int mMinHeight;
  protected int mNumColumns;
  protected int mNumRows;
  private Paint mPaint;
  protected Rect mRect = new Rect();
  protected T mScroller;
  private int mTouchSlop;
  private int mTouchState = 0;
  
  public ScrollableGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollableGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews(paramContext);
    initScroller(paramContext);
    this.mScroller.setOrientation(1);
  }
  
  private void addAndMeasureChild(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    }
    for (;;)
    {
      if (paramInt == 1) {}
      for (paramInt = 0;; paramInt = -1)
      {
        int i = getWidth();
        paramView.setPadding(this.mGridPadding.left, this.mGridPadding.top, this.mGridPadding.right, this.mGridPadding.bottom);
        paramView.measure(i | 0x40000000, View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
        addViewInLayout(paramView, paramInt, localLayoutParams, true);
        return;
      }
    }
  }
  
  private void fillList()
  {
    fillListDown(getChildAt(getChildCount() - 1).getBottom());
    fillListUp(getChildAt(0).getTop());
  }
  
  private void fillListDown(int paramInt)
  {
    while (paramInt < this.mRect.bottom + this.mScroller.getScroll())
    {
      View localView = this.mAdapter.getView(this.mLastItemPosition, getCachedView(), this);
      this.mLastItemPosition += 1;
      addAndMeasureChild(localView, 0);
      localView.layout(0, paramInt, getWidth(), localView.getMeasuredHeight() + paramInt);
      onChildAdd(localView);
      paramInt += localView.getMeasuredHeight();
    }
  }
  
  private void fillListUp(int paramInt)
  {
    while (paramInt > this.mRect.top + this.mScroller.getScroll())
    {
      this.mFirstItemPosition -= 1;
      View localView = this.mAdapter.getView(this.mFirstItemPosition, getCachedView(), this);
      addAndMeasureChild(localView, 1);
      int i = localView.getMeasuredHeight();
      localView.layout(0, paramInt - i, getWidth(), paramInt);
      onChildAdd(localView);
      paramInt -= i;
    }
  }
  
  private View getCachedView()
  {
    if (this.mCachedItemViews.size() != 0) {
      return (View)this.mCachedItemViews.removeFirst();
    }
    return null;
  }
  
  private void removeOutRectViews()
  {
    int i = getChildCount();
    View localView = getChildAt(0);
    while ((localView != null) && (localView.getBottom() < this.mRect.top + this.mScroller.getScroll()))
    {
      detachViewFromParent(0);
      i -= 1;
      this.mCachedItemViews.addLast(localView);
      this.mFirstItemPosition += 1;
      if (i > 1) {
        localView = getChildAt(0);
      } else {
        localView = null;
      }
    }
    localView = getChildAt(i - 1);
    while ((localView != null) && (localView.getTop() > this.mRect.bottom + this.mScroller.getScroll()))
    {
      detachViewFromParent(i - 1);
      i -= 1;
      this.mCachedItemViews.addLast(localView);
      this.mLastItemPosition -= 1;
      if (i > 1) {
        localView = getChildAt(i - 1);
      } else {
        localView = null;
      }
    }
  }
  
  public void computeScroll()
  {
    if (this.mScroller != null) {
      this.mScroller.computeScrollOffset();
    }
  }
  
  public void drawGridCell(Canvas paramCanvas, int paramInt)
  {
    int i = paramInt % getCountPerPage();
    GridView localGridView = (GridView)getChildAt(paramInt / getCountPerPage());
    paramInt = this.mNumColumns;
    int j = i / this.mNumColumns;
    View localView;
    if (localGridView != null)
    {
      localView = localGridView.getChildAt(i);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(-(i % paramInt) * this.mGridCellWidth, -j * this.mGridCellHeight);
    if (!this.mScroller.isFinished()) {
      localGridView.buildDrawingCache();
    }
    drawChild(paramCanvas, localView, getDrawingTime());
    paramCanvas.restore();
  }
  
  public void drawGridCell(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i = paramInt1 % getCountPerPage();
    Object localObject = (GridView)getChildAt(paramInt1 / getCountPerPage());
    paramInt1 = this.mNumColumns;
    int j = i / this.mNumColumns;
    if (localObject != null)
    {
      localObject = ((GridView)localObject).getChildAt(i);
      if (localObject != null) {
        break label57;
      }
    }
    label57:
    do
    {
      Bitmap localBitmap;
      do
      {
        return;
        localBitmap = ((View)localObject).getDrawingCache();
      } while (localBitmap == null);
      paramCanvas.save();
      paramCanvas.translate(-(i % paramInt1) * this.mGridCellWidth, -j * this.mGridCellHeight);
      paramInt1 = this.mPaint.getAlpha();
      if (paramInt1 != paramInt2) {
        this.mPaint.setAlpha(paramInt2);
      }
      paramCanvas.drawBitmap(localBitmap, ((View)localObject).getLeft(), ((View)localObject).getTop(), this.mPaint);
      paramCanvas.restore();
    } while (paramInt1 == paramInt2);
    this.mPaint.setAlpha(paramInt1);
  }
  
  public void drawScreen(Canvas paramCanvas, int paramInt)
  {
    GridView localGridView = (GridView)getChildAt(paramInt - this.mFirstItemPosition);
    if (localGridView != null) {
      localGridView.draw(paramCanvas);
    }
  }
  
  public void drawScreen(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    GridView localGridView = (GridView)getChildAt(paramInt1 - this.mFirstItemPosition);
    if (localGridView != null) {
      localGridView.draw(paramCanvas);
    }
  }
  
  public int getCellCol()
  {
    return this.mNumColumns;
  }
  
  public int getCellCount()
  {
    return this.mNumRows * this.mNumColumns;
  }
  
  public int getCellHeight()
  {
    return this.mGridCellHeight;
  }
  
  public int getCellRow()
  {
    return this.mNumRows;
  }
  
  public int getCellWidth()
  {
    return this.mGridCellWidth;
  }
  
  public int getCountPerPage()
  {
    return this.mNumColumns * this.mNumRows;
  }
  
  public GridView getCurrentView()
  {
    return (GridView)getChildAt(this.mCurrentScreen);
  }
  
  public int getFirstItemPosition()
  {
    return this.mFirstItemPosition;
  }
  
  protected abstract void initScroller(Context paramContext);
  
  protected void initViews(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mCurrentScreen = 0;
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public boolean isTouchScrolling()
  {
    return this.mTouchState == 1;
  }
  
  public boolean isVerticalScroll()
  {
    return this.mScroller.getOrientation() == 1;
  }
  
  protected abstract void onChildAdd(View paramView);
  
  public void onFlingIntercepted() {}
  
  public void onFlingStart() {}
  
  protected abstract void onInitLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 2) && (this.mTouchState != 0)) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (i)
      {
      }
      while (this.mTouchState == 0)
      {
        return false;
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        if (this.mScroller.isFinished()) {}
        for (i = 0;; i = 1)
        {
          this.mTouchState = i;
          break;
        }
        i = (int)(f1 - this.mLastMotionX);
        int j = (int)(f2 - this.mLastMotionY);
        if ((this.mTouchState != 1) && ((Math.abs(i) > this.mTouchSlop) || (Math.abs(j) > this.mTouchSlop)))
        {
          this.mTouchState = 1;
          this.mScroller.onTouchEvent(paramMotionEvent, 0);
          continue;
          this.mTouchState = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramBoolean) || (getChildCount() == 0))
    {
      this.mGridCellWidth = (getWidth() / this.mNumColumns);
      this.mGridCellHeight = (getHeight() / this.mNumRows);
      if (getChildCount() == 0)
      {
        fillListDown(this.mScroller.getScroll());
        fillListUp(this.mScroller.getScroll());
      }
      onInitLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      setupScroller();
    }
    for (;;)
    {
      return;
      paramInt2 = getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        View localView = this.mAdapter.getView(this.mFirstItemPosition + paramInt1, getChildAt(paramInt1), this);
        if (localView.getVisibility() != 8) {
          localView.layout(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        }
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    this.mGridCellWidth = (View.MeasureSpec.getSize(paramInt1) / this.mNumColumns);
    this.mGridCellHeight = (i / this.mNumRows);
    int j = getChildCount();
    paramInt2 = 0;
    if (paramInt2 < j)
    {
      View localView = getChildAt(paramInt2);
      if ((localView == null) || (localView.getLayoutParams() == null)) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        if (localView.getVisibility() != 8) {
          localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, -2147483648));
        }
      }
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2)
  {
    fillList();
    removeOutRectViews();
  }
  
  public void onScrollFinish(int paramInt)
  {
    this.mCurrentScreen = paramInt;
  }
  
  public void onScrollStart()
  {
    postInvalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mScroller == null) {
      return false;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      this.mScroller.onTouchEvent(paramMotionEvent, i);
      continue;
      this.mScroller.onTouchEvent(paramMotionEvent, i);
      continue;
      this.mScroller.onTouchEvent(paramMotionEvent, i);
      this.mTouchState = 0;
    }
  }
  
  public void recyle()
  {
    removeAllViews();
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    this.mAdapter = paramBaseAdapter;
  }
  
  public void setCellCol(int paramInt)
  {
    this.mNumColumns = paramInt;
  }
  
  public void setCellRow(int paramInt)
  {
    this.mNumRows = paramInt;
  }
  
  public void setGridPadding(Rect paramRect)
  {
    this.mGridPadding.set(paramRect);
  }
  
  public void setGridPaddingBottom(int paramInt)
  {
    this.mGridPadding.bottom = paramInt;
  }
  
  public void setGridPaddingLeft(int paramInt)
  {
    this.mGridPadding.left = paramInt;
  }
  
  public void setGridPaddingRight(int paramInt)
  {
    this.mGridPadding.right = paramInt;
  }
  
  public void setGridPaddingTop(int paramInt)
  {
    this.mGridPadding.top = paramInt;
  }
  
  protected void setupScroller() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.ScrollableGridView
 * JD-Core Version:    0.7.0.1
 */