import android.app.Dialog;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView;

public class thh
  extends GestureDetector.SimpleOnGestureListener
{
  public thh(MyVideoVisibleTroopPageView paramMyVideoVisibleTroopPageView) {}
  
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
      if ((paramFloat2 > 0.0F) && (d < 0.5235987755982988D) && (this.a.jdField_a_of_type_Int == 0)) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thh
 * JD-Core Version:    0.7.0.1
 */