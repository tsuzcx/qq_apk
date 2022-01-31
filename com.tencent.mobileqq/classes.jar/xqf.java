import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.qphone.base.util.QLog;

public class xqf
  implements Runnable
{
  public xqf(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (VideoFilterTools.a(this.a.getApplicationContext()))
    {
      VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
      localVideoFilterTools.a(this.a.getApplicationContext(), new xqg(this, localVideoFilterTools));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "your device don't support video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqf
 * JD-Core Version:    0.7.0.1
 */