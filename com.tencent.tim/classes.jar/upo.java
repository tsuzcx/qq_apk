import android.os.MessageQueue.IdleHandler;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.widget.XListView;

class upo
  implements MessageQueue.IdleHandler
{
  upo(upn paramupn) {}
  
  public boolean queueIdle()
  {
    View localView = this.a.this$0.p[40];
    int i = localView.getTop();
    int j = (this.a.this$0.n.getHeight() - localView.getHeight()) / 2;
    this.a.this$0.n.smoothScrollBy(i - j, 1000);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upo
 * JD-Core Version:    0.7.0.1
 */