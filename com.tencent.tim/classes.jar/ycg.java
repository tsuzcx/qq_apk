import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class ycg
  extends achq
{
  ycg(ycd paramycd) {}
  
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
      QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    this.this$0.refresh(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.this$0.sessionInfo.aTl)) {
      return;
    }
    this.this$0.aSt = true;
    this.this$0.a(262144, null, paramLong);
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (paramArrayOfString != null))
    {
      paramArrayOfString = paramArrayOfString[0];
      if (this.this$0.a.HF.contains(paramArrayOfString))
      {
        this.this$0.a.nz.put(paramArrayOfString, Integer.valueOf(this.this$0.app.a().A(paramArrayOfString, 1)));
        this.this$0.a.dYB();
        this.this$0.a.dYC();
        this.this$0.a.dYA();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycg
 * JD-Core Version:    0.7.0.1
 */