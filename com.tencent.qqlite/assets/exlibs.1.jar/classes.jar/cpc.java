import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.mobileqq.widget.ImageProgressCircle;

public class cpc
  extends Handler
{
  public cpc(FriendProfileImageAdapter paramFriendProfileImageAdapter) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpc
 * JD-Core Version:    0.7.0.1
 */