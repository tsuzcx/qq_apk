import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.widget.QQToast;

public class yte
  extends Handler
{
  public yte(SystemMsgListView paramSystemMsgListView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1012: 
      do
      {
        return;
      } while (SystemMsgListView.a(this.this$0) == null);
      this.this$0.clB();
      SystemMsgListView.a(this.this$0).notifyDataSetChanged();
      return;
    }
    paramMessage = SystemMsgListView.a(this.this$0).getResources().getString(2131720690);
    QQToast.a(SystemMsgListView.a(this.this$0), 1, paramMessage, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yte
 * JD-Core Version:    0.7.0.1
 */