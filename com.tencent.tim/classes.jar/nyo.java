import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class nyo
  extends achq
{
  nyo(nyn paramnyn) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "onUpdateSendMsgError->uin:" + paramString1 + ", type:" + paramInt1 + ", uniseq:" + paramLong2 + ", errorCode:" + paramInt2);
    }
    nyn.a(this.this$0, paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "onSendResult->puin:" + paramString + ", isSuccess:" + paramBoolean);
    }
    nyn.a(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyo
 * JD-Core Version:    0.7.0.1
 */