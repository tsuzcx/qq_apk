import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xnq
  implements Runnable
{
  public xnq(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.removeCallbacks(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnq
 * JD-Core Version:    0.7.0.1
 */