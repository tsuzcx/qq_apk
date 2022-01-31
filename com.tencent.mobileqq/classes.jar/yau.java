import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class yau
  extends GestureDetector.SimpleOnGestureListener
{
  private yau(yan paramyan) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - yan.a(this.a);
    if (yan.b(this.a) < yan.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (yan.d(this.a) < yan.e(this.a)))
    {
      f2 = yan.d(this.a);
      f1 = Math.abs(f1) + f2;
      localyan = this.a;
      if (f1 > yan.e(this.a))
      {
        i = yan.e(this.a);
        yan.b(localyan, i);
      }
    }
    while ((f1 >= 0.0F) || (yan.d(this.a) <= yan.f(this.a))) {
      for (;;)
      {
        float f2;
        if (yan.a(this.a) != null)
        {
          yan.a(this.a).getLayoutParams().height = yan.d(this.a);
          yan.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = yan.d(this.a) - Math.abs(f1);
    yan localyan = this.a;
    if (f1 < yan.f(this.a)) {}
    for (int i = yan.f(this.a);; i = (int)f1)
    {
      yan.b(localyan, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yau
 * JD-Core Version:    0.7.0.1
 */