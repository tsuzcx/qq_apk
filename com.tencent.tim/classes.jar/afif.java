import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.emosm.view.DragSortListView;

public class afif
  extends afik
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  int Kd;
  DragSortListView c;
  int cRb;
  private boolean mCanDrag;
  private int mClickRemoveHitPos = -1;
  private int mClickRemoveId;
  int mCurrX;
  int mCurrY;
  GestureDetector mDetector;
  private int mDragHandleId;
  private int mDragInitMode = 0;
  boolean mDragging = false;
  private int mFlingHandleId;
  private int mFlingHitPos = -1;
  GestureDetector mFlingRemoveDetector;
  private GestureDetector.OnGestureListener mFlingRemoveListener = new afig(this);
  private float mFlingSpeed = 500.0F;
  private int mHitPos = -1;
  boolean mIsRemoving = false;
  private int mItemX;
  private int mItemY;
  private int mPositionX;
  boolean mRemoveEnabled = false;
  private int mRemoveMode;
  private boolean mSortEnabled = true;
  private int[] mTempLoc = new int[2];
  private int mTouchSlop;
  float vY = ViewConfiguration.getTouchSlop() + 2;
  
  public afif(DragSortListView paramDragSortListView)
  {
    this(paramDragSortListView, 0, 0, 1);
  }
  
  public afif(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public afif(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public afif(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.c = paramDragSortListView;
    this.mDetector = new GestureDetector(paramDragSortListView.getContext(), this);
    this.mFlingRemoveDetector = new GestureDetector(paramDragSortListView.getContext(), this.mFlingRemoveListener);
    this.mFlingRemoveDetector.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.mDragHandleId = paramInt1;
    this.mClickRemoveId = paramInt4;
    this.mFlingHandleId = paramInt5;
    setRemoveMode(paramInt3);
    setDragInitMode(paramInt2);
    this.cRb = 3;
  }
  
  public void Mw(int paramInt)
  {
    this.cRb = paramInt;
  }
  
  public int dragHandleHitPosition(MotionEvent paramMotionEvent)
  {
    return viewIdHitPosition(paramMotionEvent, this.mDragHandleId);
  }
  
  public int flingHandleHitPosition(MotionEvent paramMotionEvent)
  {
    return viewIdHitPosition(paramMotionEvent, this.mFlingHandleId);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.mRemoveEnabled) && (this.mRemoveMode == 0)) {
      this.mClickRemoveHitPos = viewIdHitPosition(paramMotionEvent, this.mClickRemoveId);
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    this.Kd = this.c.pointToPosition(i, j);
    this.mHitPos = startDragPosition(paramMotionEvent);
    if ((this.mHitPos != -1) && (this.mDragInitMode == 0)) {
      startDrag(this.mHitPos, (int)paramMotionEvent.getX() - this.mItemX, (int)paramMotionEvent.getY() - this.mItemY);
    }
    this.mIsRemoving = false;
    this.mCanDrag = true;
    this.mPositionX = 0;
    this.mFlingHitPos = startFlingPosition(paramMotionEvent);
    return true;
  }
  
  public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.mRemoveEnabled) && (this.mIsRemoving)) {
      this.mPositionX = paramPoint1.x;
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.mHitPos != -1) && (this.mDragInitMode == 2))
    {
      this.c.performHapticFeedback(0);
      startDrag(this.mHitPos, this.mCurrX - this.mItemX, this.mCurrY - this.mItemY);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int j;
    int m;
    do
    {
      int i;
      int k;
      int n;
      int i1;
      do
      {
        do
        {
          do
          {
            return false;
            i = (int)paramMotionEvent1.getX();
            j = (int)paramMotionEvent1.getY();
            k = (int)paramMotionEvent2.getX();
            m = (int)paramMotionEvent2.getY();
            n = k - this.mItemX;
            i1 = m - this.mItemY;
          } while ((!this.mCanDrag) || (this.mDragging) || ((this.mHitPos == -1) && (this.mFlingHitPos == -1)));
          if (this.mHitPos == -1) {
            break;
          }
          if ((this.mDragInitMode == 1) && (Math.abs(m - j) > this.mTouchSlop) && (this.mSortEnabled))
          {
            startDrag(this.mHitPos, n, i1);
            return false;
          }
        } while ((this.mDragInitMode == 0) || (Math.abs(k - i) <= this.mTouchSlop) || (!this.mRemoveEnabled));
        this.mIsRemoving = true;
        startDrag(this.mFlingHitPos, n, i1);
        return false;
      } while (this.mFlingHitPos == -1);
      if ((Math.abs(k - i) > this.mTouchSlop) && (this.mRemoveEnabled))
      {
        this.mIsRemoving = true;
        startDrag(this.mFlingHitPos, n, i1);
        return false;
      }
    } while (Math.abs(m - j) <= this.mTouchSlop);
    this.mCanDrag = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.mRemoveEnabled) && (this.mRemoveMode == 0) && (this.mClickRemoveHitPos != -1)) {
      this.c.removeItem(this.mClickRemoveHitPos - this.c.getHeaderViewsCount());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.c.isDragEnabled()) || (this.c.listViewIntercepted()))
    {
      if (!this.c.isDragEnabled())
      {
        if (paramMotionEvent.getAction() == 0)
        {
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          this.Kd = this.c.pointToPosition(i, j);
        }
        return this.mFlingRemoveDetector.onTouchEvent(paramMotionEvent);
      }
      return false;
    }
    this.mDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        return false;
        this.mCurrX = ((int)paramMotionEvent.getX());
        this.mCurrY = ((int)paramMotionEvent.getY());
      }
    case 1: 
      if ((this.mRemoveEnabled) && (this.mIsRemoving)) {
        if (this.mPositionX < 0) {
          break label209;
        }
      }
      break;
    }
    label209:
    for (int i = this.mPositionX;; i = -this.mPositionX)
    {
      if (i > this.c.getWidth() / 2) {
        this.c.stopDragWithVelocity(false, 0.0F);
      }
      this.mIsRemoving = false;
      this.mDragging = false;
      break;
    }
  }
  
  public void setClickRemoveId(int paramInt)
  {
    this.mClickRemoveId = paramInt;
  }
  
  public void setDragHandleId(int paramInt)
  {
    this.mDragHandleId = paramInt;
  }
  
  public void setDragInitMode(int paramInt)
  {
    this.mDragInitMode = paramInt;
  }
  
  public void setRemoveEnabled(boolean paramBoolean)
  {
    this.mRemoveEnabled = paramBoolean;
  }
  
  public void setRemoveMode(int paramInt)
  {
    this.mRemoveMode = paramInt;
  }
  
  public void setSortEnabled(boolean paramBoolean)
  {
    this.mSortEnabled = paramBoolean;
  }
  
  public boolean startDrag(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = j;
    if (this.mSortEnabled)
    {
      i = j;
      if (!this.mIsRemoving) {
        i = 12;
      }
    }
    j = i;
    if (this.mRemoveEnabled)
    {
      j = i;
      if (this.mIsRemoving) {
        j = i | 0x1 | 0x2;
      }
    }
    this.mDragging = this.c.startDrag(paramInt1 - this.c.getHeaderViewsCount(), j, paramInt2, paramInt3);
    return this.mDragging;
  }
  
  public int startDragPosition(MotionEvent paramMotionEvent)
  {
    return dragHandleHitPosition(paramMotionEvent);
  }
  
  public int startFlingPosition(MotionEvent paramMotionEvent)
  {
    if (this.mRemoveMode == 1) {
      return flingHandleHitPosition(paramMotionEvent);
    }
    return -1;
  }
  
  public int viewIdHitPosition(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.c.pointToPosition(i, j);
    j = this.c.getHeaderViewsCount();
    int k = this.c.getFooterViewsCount();
    int m = this.c.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      View localView = this.c.getChildAt(i - this.c.getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = localView; paramMotionEvent != null; paramMotionEvent = localView.findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.mTempLoc);
        if ((k <= this.mTempLoc[0]) || (j <= this.mTempLoc[1]) || (k >= this.mTempLoc[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.mTempLoc[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.mItemX = localView.getLeft();
        this.mItemY = localView.getTop();
        return i;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afif
 * JD-Core Version:    0.7.0.1
 */