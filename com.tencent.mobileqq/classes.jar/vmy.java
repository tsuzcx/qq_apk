import android.app.Dialog;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;

public class vmy
  extends GestureDetector.SimpleOnGestureListener
{
  public vmy(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent2 != null) && (paramMotionEvent1 != null))
    {
      paramFloat1 = Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX());
      float f = Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY());
      double d = Math.abs(Math.asin(paramFloat1 / Math.sqrt(paramFloat1 * paramFloat1 + f * f)));
      if ((paramFloat2 > 0.0F) && (d < 0.5235987755982988D) && (this.a.b == 0)) {
        this.a.a.dismiss();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmy
 * JD-Core Version:    0.7.0.1
 */