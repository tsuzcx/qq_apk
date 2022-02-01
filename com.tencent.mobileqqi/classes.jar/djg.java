import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.SpaceGateActivity;

public class djg
  extends Handler
{
  public djg(SpaceGateActivity paramSpaceGateActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    ((View)paramMessage.obj).setVisibility(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     djg
 * JD-Core Version:    0.7.0.1
 */