import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class wme
  extends GestureDetector.SimpleOnGestureListener
{
  private wme(wlx paramwlx) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - wlx.a(this.a);
    if (wlx.b(this.a) < wlx.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (wlx.d(this.a) < wlx.e(this.a)))
    {
      f2 = wlx.d(this.a);
      f1 = Math.abs(f1) + f2;
      localwlx = this.a;
      if (f1 > wlx.e(this.a))
      {
        i = wlx.e(this.a);
        wlx.b(localwlx, i);
      }
    }
    while ((f1 >= 0.0F) || (wlx.d(this.a) <= wlx.f(this.a))) {
      for (;;)
      {
        float f2;
        if (wlx.a(this.a) != null)
        {
          wlx.a(this.a).getLayoutParams().height = wlx.d(this.a);
          wlx.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = wlx.d(this.a) - Math.abs(f1);
    wlx localwlx = this.a;
    if (f1 < wlx.f(this.a)) {}
    for (int i = wlx.f(this.a);; i = (int)f1)
    {
      wlx.b(localwlx, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wme
 * JD-Core Version:    0.7.0.1
 */