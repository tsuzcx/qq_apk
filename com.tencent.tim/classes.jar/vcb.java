import android.view.MotionEvent;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

public class vcb
  implements TopGestureLayout.InterceptTouchEventListener
{
  public vcb(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.this$0.a != null) {
      return this.this$0.a.OnInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcb
 * JD-Core Version:    0.7.0.1
 */