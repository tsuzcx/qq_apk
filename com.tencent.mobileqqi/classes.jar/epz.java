import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame;

public class epz
  extends Handler
{
  public epz(FriendListInnerFrame paramFriendListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a.setPadding(0, 0, 40, 0);
      return;
    }
    this.a.a.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epz
 * JD-Core Version:    0.7.0.1
 */