import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import mqq.os.MqqHandler;

public class zew
  extends ProxyObserver
{
  public zew(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onProxySaveToDbFinished()
  {
    this.this$0.mUIHandler.sendEmptyMessage(41);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zew
 * JD-Core Version:    0.7.0.1
 */