import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class zfa
  extends AccountObserver
{
  public zfa(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 == null)
      {
        i = 0;
        QLog.e("Q.history.C2CAllFragment", 2, i);
      }
    }
    else
    {
      paramString1 = this.this$0.mUIHandler.obtainMessage(39);
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (int i = 1;; i = 0)
    {
      paramString1.arg1 = i;
      paramString1.arg2 = 0;
      this.this$0.mUIHandler.sendMessage(paramString1);
      return;
      i = paramString2.length();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfa
 * JD-Core Version:    0.7.0.1
 */