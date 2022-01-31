import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class ccm
  extends Handler
{
  public ccm(SystemMsgListView paramSystemMsgListView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (SystemMsgListView.a(this.a) == null);
        this.a.j();
        SystemMsgListView.a(this.a).notifyDataSetChanged();
        return;
      } while (SystemMsgListView.a(this.a).k() <= 0);
      SystemMsgListView.a(this.a).a(this.a.d);
      return;
    } while (SystemMsgListView.a(this.a) == null);
    SystemMsgListView.a(this.a).a(this.a.d);
    this.a.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ccm
 * JD-Core Version:    0.7.0.1
 */