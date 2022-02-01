import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;

public class alxp
  extends OrientationEventListener
{
  public alxp(CameraCaptureView paramCameraCaptureView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.this$0.dzm = paramInt;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "OrientationEventListener unknown");
      }
      this.this$0.dzn = 90;
    }
    if ((paramInt > 315) || (paramInt < 45)) {
      this.this$0.dzn = 90;
    }
    for (;;)
    {
      if (this.this$0.cAF) {
        this.this$0.orientation = this.this$0.dzn;
      }
      alxg.orientation = this.this$0.orientation;
      return;
      if ((paramInt > 45) && (paramInt < 135)) {
        this.this$0.dzn = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        this.this$0.dzn = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        this.this$0.dzn = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxp
 * JD-Core Version:    0.7.0.1
 */