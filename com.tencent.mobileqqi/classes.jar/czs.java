import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.PortraitImageview.OnImageTouchedListener;
import com.tencent.mobileqq.activity.PortraitImageview.SimpleOnGestureListener;

public class czs
  extends PortraitImageview.SimpleOnGestureListener
{
  private czs(PortraitImageview paramPortraitImageview) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.a() > this.a.f()) {
      this.a.a(this.a.f());
    }
    for (;;)
    {
      return true;
      this.a.a(this.a.f() * 3.0F, paramMotionEvent.getX(), paramMotionEvent.getY(), 350.0F);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (((paramMotionEvent1 != null) && (paramMotionEvent1.getPointerCount() > 1)) || ((paramMotionEvent2 != null) && (paramMotionEvent2.getPointerCount() > 1)) || ((this.a.jdField_a_of_type_AndroidViewScaleGestureDetector != null) && (this.a.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()))) {
      return false;
    }
    this.a.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.a(-paramFloat1, -paramFloat2);
    this.a.setImageMatrix(this.a.a());
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$OnImageTouchedListener != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$OnImageTouchedListener.a();
      return false;
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czs
 * JD-Core Version:    0.7.0.1
 */