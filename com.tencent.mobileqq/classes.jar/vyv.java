import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class vyv
  extends GestureDetector.SimpleOnGestureListener
{
  private vyv(vyo paramvyo) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - vyo.a(this.a);
    if (vyo.b(this.a) < vyo.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (vyo.d(this.a) < vyo.e(this.a)))
    {
      f2 = vyo.d(this.a);
      f1 = Math.abs(f1) + f2;
      localvyo = this.a;
      if (f1 > vyo.e(this.a))
      {
        i = vyo.e(this.a);
        vyo.b(localvyo, i);
      }
    }
    while ((f1 >= 0.0F) || (vyo.d(this.a) <= vyo.f(this.a))) {
      for (;;)
      {
        float f2;
        if (vyo.a(this.a) != null)
        {
          vyo.a(this.a).getLayoutParams().height = vyo.d(this.a);
          vyo.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = vyo.d(this.a) - Math.abs(f1);
    vyo localvyo = this.a;
    if (f1 < vyo.f(this.a)) {}
    for (int i = vyo.f(this.a);; i = (int)f1)
    {
      vyo.b(localvyo, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vyv
 * JD-Core Version:    0.7.0.1
 */