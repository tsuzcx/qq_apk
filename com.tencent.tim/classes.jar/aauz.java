import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class aauz
  implements GestureDetector.OnGestureListener
{
  aauz(aauy paramaauy) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    aauy.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      aauy.a(this.a).fling((int)aauy.a(this.a), 0, (int)-paramFloat1, 0, (int)aauy.b(this.a), (int)aauy.c(this.a), 0, 0);
      aauy.b(this.a);
      return true;
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    do
    {
      synchronized (this.a)
      {
        aauy.a(this.a, aauy.a(this.a) + paramFloat1);
        if (aauy.a(this.a) < aauy.b(this.a)) {
          aauy.a(this.a, aauy.b(this.a));
        }
        if (aauy.a(this.a) > aauy.c(this.a)) {
          aauy.a(this.a, aauy.c(this.a));
        }
        paramFloat1 = aauy.a(this.a);
        paramFloat2 = aauy.d(this.a);
        aauy.b(this.a, aauy.a(this.a));
        if (aauy.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      aauy.a(this.a);
      if (aauy.a(this.a) != null) {
        aauy.a(this.a).gw(aauy.a(this.a), aauy.b(this.a));
      }
      if (aauy.a(this.a) != null) {
        aauy.a(this.a).invalidate();
      }
    } while (aauy.a(this.a) == null);
    aauy.a(this.a).e(aauy.a(this.a), -aauy.a(this.a), aauy.e(this.a) - aauy.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aauz
 * JD-Core Version:    0.7.0.1
 */