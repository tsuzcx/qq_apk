import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.qphone.base.util.QLog;

public class xwm
  implements Runnable
{
  public xwm(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (VideoFilterTools.a(this.a.getApplicationContext()))
    {
      VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
      localVideoFilterTools.a(this.a.getApplicationContext(), new xwn(this, localVideoFilterTools));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "your device don't support video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwm
 * JD-Core Version:    0.7.0.1
 */