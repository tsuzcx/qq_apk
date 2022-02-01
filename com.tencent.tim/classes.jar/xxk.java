import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler.d;
import com.tencent.qphone.base.util.QLog;

class xxk
  extends achq
{
  xxk(xxh paramxxh) {}
  
  protected void U(boolean paramBoolean, String paramString)
  {
    this.this$0.refresh(65536);
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
 * Qualified Name:     xxk
 * JD-Core Version:    0.7.0.1
 */