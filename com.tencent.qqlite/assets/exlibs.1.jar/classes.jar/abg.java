import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class abg
  extends GestureDetector.SimpleOnGestureListener
{
  public abg(BaseChatPie paramBaseChatPie) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onScroll");
    }
    if (BaseChatPie.c(this.a)) {
      BaseChatPie.d(this.a, false);
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onShowPress");
    }
    this.a.f(false);
    BaseChatPie.d(this.a, true);
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onSingleTapConfirmed");
    }
    this.a.f(false);
    BaseChatPie.d(this.a, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     abg
 * JD-Core Version:    0.7.0.1
 */