import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.List;

class auwe
  implements RecyclerView.OnItemTouchListener
{
  auwe(auwd paramauwd) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.this$0.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.this$0.mInitialTouchX = paramMotionEvent.getX();
      this.this$0.mInitialTouchY = paramMotionEvent.getY();
      this.this$0.obtainVelocityTracker();
      if (this.this$0.mSelected == null)
      {
        paramRecyclerView = this.this$0.findAnimation(paramMotionEvent);
        if (paramRecyclerView != null)
        {
          auwd localauwd = this.this$0;
          localauwd.mInitialTouchX -= paramRecyclerView.mX;
          localauwd = this.this$0;
          localauwd.mInitialTouchY -= paramRecyclerView.mY;
          this.this$0.endRecoverAnimation(paramRecyclerView.mViewHolder, true);
          if (this.this$0.mPendingCleanup.remove(paramRecyclerView.mViewHolder.itemView)) {
            this.this$0.mCallback.clearView(this.this$0.mRecyclerView, paramRecyclerView.mViewHolder);
          }
          this.this$0.select(paramRecyclerView.mViewHolder, paramRecyclerView.mActionState);
          this.this$0.updateDxDy(paramMotionEvent, this.this$0.mSelectedFlags, 0);
        }
      }
    }
    for (;;)
    {
      if (this.this$0.mVelocityTracker != null) {
        this.this$0.mVelocityTracker.addMovement(paramMotionEvent);
      }
      if (this.this$0.mSelected == null) {
        break;
      }
      return true;
      if ((i == 3) || (i == 1))
      {
        this.this$0.mActivePointerId = -1;
        this.this$0.select(null, 0);
      }
      else if (this.this$0.mActivePointerId != -1)
      {
        int j = paramMotionEvent.findPointerIndex(this.this$0.mActivePointerId);
        if (j >= 0) {
          this.this$0.checkSelectForSwipe(i, paramMotionEvent, j);
        }
      }
    }
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.this$0.select(null, 0);
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = 0;
    this.this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.this$0.mVelocityTracker != null) {
      this.this$0.mVelocityTracker.addMovement(paramMotionEvent);
    }
    if (this.this$0.mActivePointerId == -1) {}
    int j;
    do
    {
      int k;
      do
      {
        return;
        j = paramMotionEvent.getActionMasked();
        k = paramMotionEvent.findPointerIndex(this.this$0.mActivePointerId);
        if (k >= 0) {
          this.this$0.checkSelectForSwipe(j, paramMotionEvent, k);
        }
        paramRecyclerView = this.this$0.mSelected;
      } while (paramRecyclerView == null);
      switch (j)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.this$0.select(null, 0);
          this.this$0.mActivePointerId = -1;
          return;
          if (k < 0) {
            break;
          }
          this.this$0.updateDxDy(paramMotionEvent, this.this$0.mSelectedFlags, k);
          this.this$0.moveIfNecessary(paramRecyclerView);
          this.this$0.mRecyclerView.removeCallbacks(this.this$0.mScrollRunnable);
          this.this$0.mScrollRunnable.run();
          this.this$0.mRecyclerView.invalidate();
          return;
          if (this.this$0.mVelocityTracker != null) {
            this.this$0.mVelocityTracker.clear();
          }
        }
      }
      j = paramMotionEvent.getActionIndex();
    } while (paramMotionEvent.getPointerId(j) != this.this$0.mActivePointerId);
    if (j == 0) {
      i = 1;
    }
    this.this$0.mActivePointerId = paramMotionEvent.getPointerId(i);
    this.this$0.updateDxDy(paramMotionEvent, this.this$0.mSelectedFlags, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwe
 * JD-Core Version:    0.7.0.1
 */