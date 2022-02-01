import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class aaqv
  extends OrientationEventListener
{
  public aaqv(NewFlowCameraActivity paramNewFlowCameraActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    NewFlowCameraActivity.a(this.this$0).onOrientationChanged(paramInt);
    if (this.this$0.bxJ) {}
    do
    {
      return;
      if (paramInt == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "OrientationEventListener unknown");
        }
        this.this$0.mOrientation = 90;
        return;
      }
      if ((paramInt > 315) || (paramInt < 45))
      {
        this.this$0.mOrientation = 90;
        return;
      }
      if ((paramInt > 45) && (paramInt < 135))
      {
        this.this$0.mOrientation = 180;
        return;
      }
      if ((paramInt > 135) && (paramInt < 225))
      {
        this.this$0.mOrientation = 270;
        return;
      }
    } while ((paramInt <= 225) || (paramInt >= 315));
    this.this$0.mOrientation = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqv
 * JD-Core Version:    0.7.0.1
 */