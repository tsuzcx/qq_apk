import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;

public class eib
  extends Handler
{
  public eib(CircleMemberListActivity paramCircleMemberListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    int j;
    if (paramMessage.what == 1000)
    {
      i = CircleMemberListActivity.a(this.a).q();
      j = CircleMemberListActivity.a(this.a).r();
      if (i <= 0) {
        break label63;
      }
      i -= 1;
    }
    for (;;)
    {
      this.a.b.a(new eic(this, i, j - 1));
      return;
      label63:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eib
 * JD-Core Version:    0.7.0.1
 */