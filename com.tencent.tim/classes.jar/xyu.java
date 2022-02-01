import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class xyu
  extends achq
{
  xyu(xys paramxys) {}
  
  protected void L(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.this$0.sessionInfo.aTl != null) && (this.this$0.sessionInfo.aTl.equals(paramString)))
    {
      ChatActivityUtils.bJs();
      if (paramBoolean) {
        this.this$0.bGP();
      }
    }
  }
  
  protected void M(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.this$0.sessionInfo.aTl != null) && (this.this$0.sessionInfo.aTl.equals(paramString)))
    {
      ChatActivityUtils.bJs();
      if (paramBoolean) {
        this.this$0.bGP();
      }
    }
  }
  
  protected void U(boolean paramBoolean, String paramString)
  {
    this.this$0.refresh(65536);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.this$0.sessionInfo.aTl)) || (paramInt1 != this.this$0.sessionInfo.cZ))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      paramString1 = this.this$0.app.b().a(paramString1, paramInt1, paramLong2);
      if ((paramString1 != null) && (paramString1.msgtype == -2058) && ((paramString1.extraflag == 32768) || (paramString1.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.this$0.TAG, 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
        }
        this.this$0.app.b().b(paramString1, false);
      }
      return;
    }
    xys.a(this.this$0, paramString1, paramInt1, paramLong2);
    this.this$0.refresh(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, MessageHandler.d paramd)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.this$0.sessionInfo.aTl)) {
      return;
    }
    this.this$0.aSt = true;
    this.this$0.a(262144, paramd, paramLong);
    ((aize)this.this$0.app.getManager(308)).a(this.this$0.sessionInfo, aize.dha);
  }
  
  public void yh(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.this$0.refresh(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyu
 * JD-Core Version:    0.7.0.1
 */