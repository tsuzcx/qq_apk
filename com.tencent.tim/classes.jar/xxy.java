import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class xxy
  extends achq
{
  xxy(xxt paramxxt) {}
  
  protected void U(boolean paramBoolean, String paramString)
  {
    this.this$0.refresh(65536);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2, int paramInt3)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.this$0.sessionInfo.aTl)) || (paramInt1 != this.this$0.sessionInfo.cZ) || (paramInt3 != this.this$0.sessionInfo.topicId))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError_confess err uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " topicId " + paramInt3);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError_confess uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2 + " topicId " + paramInt3);
    }
    this.this$0.refresh(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.this$0.sessionInfo.aTl)) || (paramInt1 != this.this$0.sessionInfo.cZ) || (paramInt2 != this.this$0.sessionInfo.topicId))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onSendResult_confess err uin " + paramString + " type " + paramInt1 + " uniseq " + paramLong + " topicId " + paramInt2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onSendResult_confess uin " + paramString + " type " + paramInt1 + " uniseq " + paramLong + " topicId " + paramInt2);
    }
    this.this$0.aSt = true;
    this.this$0.a(262144, null, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxy
 * JD-Core Version:    0.7.0.1
 */