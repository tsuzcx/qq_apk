import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class zep
  extends GestureDetector.SimpleOnGestureListener
{
  private zep(zei paramzei) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - zei.a(this.a);
    if (zei.b(this.a) < zei.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (zei.d(this.a) < zei.e(this.a)))
    {
      f2 = zei.d(this.a);
      f1 = Math.abs(f1) + f2;
      localzei = this.a;
      if (f1 > zei.e(this.a))
      {
        i = zei.e(this.a);
        zei.b(localzei, i);
      }
    }
    while ((f1 >= 0.0F) || (zei.d(this.a) <= zei.f(this.a))) {
      for (;;)
      {
        float f2;
        if (zei.a(this.a) != null)
        {
          zei.a(this.a).getLayoutParams().height = zei.d(this.a);
          zei.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = zei.d(this.a) - Math.abs(f1);
    zei localzei = this.a;
    if (f1 < zei.f(this.a)) {}
    for (int i = zei.f(this.a);; i = (int)f1)
    {
      zei.b(localzei, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zep
 * JD-Core Version:    0.7.0.1
 */