import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;

class axoq
  implements View.OnTouchListener
{
  axoq(axoo paramaxoo) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((axoo.a(this.b) instanceof QIMCameraStoryCaptureButtonLayout)) && (((QIMCameraStoryCaptureButtonLayout)axoo.a(this.b)).aRx())) {
      return true;
    }
    return axoo.a(this.b).au(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axoq
 * JD-Core Version:    0.7.0.1
 */