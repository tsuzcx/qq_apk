import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class zet
  implements Handler.Callback
{
  public zet(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleMessage ", Integer.valueOf(paramMessage.what) });
    }
    switch (paramMessage.what)
    {
    case 6: 
    case 7: 
    case 11: 
    case 14: 
    case 15: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    case 9: 
    case 22: 
    case 23: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 65537: 
    case 65538: 
    case 65539: 
    case 65540: 
    case 24: 
    case 25: 
    case 27: 
    case 28: 
    case 33: 
    case 26: 
    case 34: 
    case 13: 
      do
      {
        return true;
        this.this$0.aG(paramMessage);
        return true;
        this.this$0.aB(paramMessage);
        return true;
        this.this$0.aF(paramMessage);
        return true;
        this.this$0.aE(paramMessage);
        return true;
        this.this$0.aC(paramMessage);
        return true;
        this.this$0.aD(paramMessage);
        return true;
        ChatHistoryC2CAllFragment.a(this.this$0);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.C2CAllFragment", 2, "handle_get_roam_msg_auth_mode notify UI");
        }
        if (this.this$0.b.aaV())
        {
          this.this$0.BC(false);
          return true;
        }
        this.this$0.cpc();
        return true;
      } while (paramMessage.obj == null);
      ChatHistoryC2CAllFragment localChatHistoryC2CAllFragment = this.this$0;
      BaseApplication localBaseApplication = this.this$0.mApp.getApp();
      if (((Boolean)paramMessage.obj).booleanValue() == true) {}
      for (int i = 2131693300;; i = 2131693299)
      {
        localChatHistoryC2CAllFragment.vk(localBaseApplication.getString(i));
        return true;
      }
    case 39: 
      ChatHistoryC2CAllFragment.a(this.this$0, paramMessage);
      return true;
    case 40: 
      ChatHistoryC2CAllFragment.b(this.this$0, paramMessage);
      return true;
    case 41: 
      ChatHistoryC2CAllFragment.c(this.this$0, paramMessage);
      return true;
    }
    ChatHistoryC2CAllFragment.d(this.this$0, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zet
 * JD-Core Version:    0.7.0.1
 */