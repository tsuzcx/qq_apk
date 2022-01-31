import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.selectmember.DiscussionMemberListInnerFrame;

public class euk
  extends Handler
{
  public euk(DiscussionMemberListInnerFrame paramDiscussionMemberListInnerFrame) {}
  
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
 * Qualified Name:     euk
 * JD-Core Version:    0.7.0.1
 */