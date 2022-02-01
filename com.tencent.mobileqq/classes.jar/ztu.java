import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class ztu
  extends GestureDetector.SimpleOnGestureListener
{
  private ztu(ztn paramztn) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - ztn.a(this.a);
    if (ztn.b(this.a) < ztn.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (ztn.d(this.a) < ztn.e(this.a)))
    {
      f2 = ztn.d(this.a);
      f1 = Math.abs(f1) + f2;
      localztn = this.a;
      if (f1 > ztn.e(this.a))
      {
        i = ztn.e(this.a);
        ztn.b(localztn, i);
      }
    }
    while ((f1 >= 0.0F) || (ztn.d(this.a) <= ztn.f(this.a))) {
      for (;;)
      {
        float f2;
        if (ztn.a(this.a) != null)
        {
          ztn.a(this.a).getLayoutParams().height = ztn.d(this.a);
          ztn.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = ztn.d(this.a) - Math.abs(f1);
    ztn localztn = this.a;
    if (f1 < ztn.f(this.a)) {}
    for (int i = ztn.f(this.a);; i = (int)f1)
    {
      ztn.b(localztn, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztu
 * JD-Core Version:    0.7.0.1
 */