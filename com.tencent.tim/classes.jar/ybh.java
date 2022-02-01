import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ybh
  extends achq
{
  ybh(ybb paramybb) {}
  
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
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2);
    }
    this.this$0.refresh(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onSendResult, isSucc:" + paramBoolean + " uin:" + paramString + " uniseq:" + paramLong);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      do
      {
        return;
      } while (!paramString.equals(this.this$0.sessionInfo.aTl));
      this.this$0.aSt = true;
      this.this$0.a(262144, null, paramLong);
    } while ((!paramBoolean) || (((acff)this.this$0.app.getManager(51)).isFriend(this.this$0.sessionInfo.aTl)));
    ybb.a(this.this$0);
    ybb.b(this.this$0);
    this.this$0.cgy();
  }
  
  public void bI(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((!paramList.isSendFromLocal()) && (!(paramList instanceof MessageForUniteGrayTip)) && (paramList.frienduin != null) && (paramList.frienduin.equals(this.this$0.sessionInfo.aTl)) && (!((acff)this.this$0.app.getManager(51)).isFriend(this.this$0.sessionInfo.aTl)))
      {
        ybb.c(this.this$0);
        ybb.b(this.this$0);
        this.this$0.cgy();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybh
 * JD-Core Version:    0.7.0.1
 */