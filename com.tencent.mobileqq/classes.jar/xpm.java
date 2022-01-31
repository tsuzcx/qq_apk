import android.app.Activity;
import com.tencent.mobileqq.activity.richmedia.FlowSendTask;

public class xpm
  implements Runnable
{
  public xpm(FlowSendTask paramFlowSendTask) {}
  
  public void run()
  {
    this.a.a.setResult(1001);
    this.a.a.finish();
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpm
 * JD-Core Version:    0.7.0.1
 */