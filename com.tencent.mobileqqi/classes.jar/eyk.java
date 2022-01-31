import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.mobileqq.widget.ImageProgressCircle;

public class eyk
  extends Handler
{
  public eyk(FriendProfileImageAdapter paramFriendProfileImageAdapter) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof ImageProgressCircle)))
    {
      paramMessage = (ImageProgressCircle)paramMessage.obj;
      if (paramMessage.getVisibility() != 0) {
        paramMessage.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eyk
 * JD-Core Version:    0.7.0.1
 */