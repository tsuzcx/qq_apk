import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class wmb
  extends GestureDetector.SimpleOnGestureListener
{
  private wmb(wlu paramwlu) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - wlu.a(this.a);
    if (wlu.b(this.a) < wlu.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (wlu.d(this.a) < wlu.e(this.a)))
    {
      f2 = wlu.d(this.a);
      f1 = Math.abs(f1) + f2;
      localwlu = this.a;
      if (f1 > wlu.e(this.a))
      {
        i = wlu.e(this.a);
        wlu.b(localwlu, i);
      }
    }
    while ((f1 >= 0.0F) || (wlu.d(this.a) <= wlu.f(this.a))) {
      for (;;)
      {
        float f2;
        if (wlu.a(this.a) != null)
        {
          wlu.a(this.a).getLayoutParams().height = wlu.d(this.a);
          wlu.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = wlu.d(this.a) - Math.abs(f1);
    wlu localwlu = this.a;
    if (f1 < wlu.f(this.a)) {}
    for (int i = wlu.f(this.a);; i = (int)f1)
    {
      wlu.b(localwlu, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wmb
 * JD-Core Version:    0.7.0.1
 */