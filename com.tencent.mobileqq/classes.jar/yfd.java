import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class yfd
  extends GestureDetector.SimpleOnGestureListener
{
  private yfd(yew paramyew) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - yew.a(this.a);
    if (yew.b(this.a) < yew.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (yew.d(this.a) < yew.e(this.a)))
    {
      f2 = yew.d(this.a);
      f1 = Math.abs(f1) + f2;
      localyew = this.a;
      if (f1 > yew.e(this.a))
      {
        i = yew.e(this.a);
        yew.b(localyew, i);
      }
    }
    while ((f1 >= 0.0F) || (yew.d(this.a) <= yew.f(this.a))) {
      for (;;)
      {
        float f2;
        if (yew.a(this.a) != null)
        {
          yew.a(this.a).getLayoutParams().height = yew.d(this.a);
          yew.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = yew.d(this.a) - Math.abs(f1);
    yew localyew = this.a;
    if (f1 < yew.f(this.a)) {}
    for (int i = yew.f(this.a);; i = (int)f1)
    {
      yew.b(localyew, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfd
 * JD-Core Version:    0.7.0.1
 */