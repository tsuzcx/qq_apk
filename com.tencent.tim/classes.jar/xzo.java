import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.4.1;
import com.tencent.mobileqq.app.MessageHandler.d;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class xzo
  extends achq
{
  xzo(xzk paramxzk) {}
  
  protected void U(boolean paramBoolean, String paramString)
  {
    this.a.refresh(65536);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(xzk.TAG, 2, "[onUpdateSendMsgError], errMsg:" + paramString2 + ",replyCode:" + paramInt2);
    }
    ThreadManager.getUIHandler().post(new GameMsgChatPie.4.1(this, paramString2));
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, MessageHandler.d paramd)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.sessionInfo.aTl)) {
      return;
    }
    this.a.aSt = true;
    this.a.a(262144, paramd, paramLong);
  }
  
  public void yh(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.refresh(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzo
 * JD-Core Version:    0.7.0.1
 */