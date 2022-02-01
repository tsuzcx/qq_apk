import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class uax
  extends amwl
{
  uax(uaw paramuaw) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "onSendResult->puin:" + paramString + ", isSuccess:" + paramBoolean);
    }
    uaw.a(this.a, paramString);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "onUpdateSendMsgError->uin:" + paramString1 + ", type:" + paramInt1 + ", uniseq:" + paramLong2 + ", errorCode:" + paramInt2);
    }
    uaw.a(this.a, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uax
 * JD-Core Version:    0.7.0.1
 */