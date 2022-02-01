import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class afig
  extends GestureDetector.SimpleOnGestureListener
{
  afig(afif paramafif) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((!this.a.c.isDragEnabled()) && (this.a.Kd != -1)) {
      this.a.c.setTapPos(this.a.Kd);
    }
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.c.isDragEnabled()) || (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) || (this.a.c.isScrolling()) || (this.a.mDragging) || (Math.abs(paramFloat1) <= this.a.vY) || ((paramFloat1 < 0.0F) && (this.a.cRb == 2))) {}
    while ((paramFloat1 > 0.0F) && (this.a.cRb == 1)) {
      return false;
    }
    int i = this.a.Kd;
    this.a.c.setSrcPos(i);
    this.a.c.cZJ();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afig
 * JD-Core Version:    0.7.0.1
 */