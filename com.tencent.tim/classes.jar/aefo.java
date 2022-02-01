import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aefo
  extends Handler
{
  public aefo(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.this$0.bHl == 1) || (this.this$0.bHl == 2)))
    {
      this.this$0.aqz();
      QQToast.a(this.this$0, 2131691963, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefo
 * JD-Core Version:    0.7.0.1
 */