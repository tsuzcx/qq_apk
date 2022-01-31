import android.os.Process;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xwx
  implements Runnable
{
  public xwx(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwx
 * JD-Core Version:    0.7.0.1
 */