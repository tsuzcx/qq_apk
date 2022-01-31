import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xqw
  implements Runnable
{
  public xqw(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.removeCallbacks(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqw
 * JD-Core Version:    0.7.0.1
 */