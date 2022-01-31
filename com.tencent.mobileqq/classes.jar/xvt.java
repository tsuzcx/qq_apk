import android.app.Activity;
import com.tencent.mobileqq.activity.richmedia.FlowSendTask;

public class xvt
  implements Runnable
{
  public xvt(FlowSendTask paramFlowSendTask) {}
  
  public void run()
  {
    this.a.a.setResult(1001);
    this.a.a.finish();
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xvt
 * JD-Core Version:    0.7.0.1
 */