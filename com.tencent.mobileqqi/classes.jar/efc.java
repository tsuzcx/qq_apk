import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;

public class efc
  extends Handler
{
  public efc(SystemMsgListView paramSystemMsgListView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (SystemMsgListView.a(this.a) == null);
    this.a.j();
    SystemMsgListView.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     efc
 * JD-Core Version:    0.7.0.1
 */