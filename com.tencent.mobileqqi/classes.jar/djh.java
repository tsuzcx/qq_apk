import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.SpaceGateActivity;

public class djh
  extends Handler
{
  public djh(SpaceGateActivity paramSpaceGateActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    ((View)paramMessage.obj).setVisibility(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     djh
 * JD-Core Version:    0.7.0.1
 */