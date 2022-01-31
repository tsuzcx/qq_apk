import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout.ArkSearchReportCallback;

public class urt
  extends GestureDetector.SimpleOnGestureListener
{
  public urt(ArkAppRootLayout paramArkAppRootLayout) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (ArkAppRootLayout.a(this.a) != null) {
      ArkAppRootLayout.a(this.a).a();
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urt
 * JD-Core Version:    0.7.0.1
 */