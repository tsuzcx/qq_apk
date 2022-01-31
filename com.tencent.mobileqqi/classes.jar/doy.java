import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.SpaceGateActivity;

public class doy
  extends Handler
{
  public doy(SpaceGateActivity paramSpaceGateActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    ((View)paramMessage.obj).setVisibility(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     doy
 * JD-Core Version:    0.7.0.1
 */