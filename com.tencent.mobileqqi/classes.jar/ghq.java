import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;

public class ghq
  extends GestureDetector.SimpleOnGestureListener
{
  public ghq(StatusHistoryActivity paramStatusHistoryActivity, int paramInt) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    if ((paramFloat1 <= -this.jdField_a_of_type_Int) && (paramFloat2 < 0.5F)) {
      return StatusHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghq
 * JD-Core Version:    0.7.0.1
 */