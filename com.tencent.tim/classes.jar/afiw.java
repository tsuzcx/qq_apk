import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;

public class afiw
  extends aqvd
{
  public afiw(MessengerService paramMessengerService) {}
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    if (this.a.mClient != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 5);
      if ((paramBundle.get("chatbgInfo") instanceof ChatBackgroundInfo))
      {
        ChatBackgroundInfo localChatBackgroundInfo = (ChatBackgroundInfo)paramBundle.get("chatbgInfo");
        paramBundle.putString("name", localChatBackgroundInfo.name);
        paramBundle.putString("url", localChatBackgroundInfo.url);
      }
      paramBundle.putInt("type", 2);
      paramBundle.putInt("id", (int)paramLong);
      paramBundle.putInt("result", paramInt);
      localMessage.setData(paramBundle);
      this.a.mClient.send(localMessage);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Message localMessage;
    if (this.a.mClient != null)
    {
      localMessage = Message.obtain(null, 5);
      localMessage.setData(paramBundle);
    }
    try
    {
      this.a.mClient.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afiw
 * JD-Core Version:    0.7.0.1
 */