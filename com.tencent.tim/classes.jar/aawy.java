import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame;

public class aawy
  extends Handler
{
  public aawy(FriendListInnerFrame paramFriendListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.gW.setPadding(0, 0, 40, 0);
      return;
    }
    this.a.gW.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawy
 * JD-Core Version:    0.7.0.1
 */