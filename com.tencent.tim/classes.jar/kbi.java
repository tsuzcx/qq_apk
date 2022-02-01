import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPublicAccountMessageReceiptResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class kbi
  implements BusinessObserver
{
  kbi(kaw paramkaw, NewIntent paramNewIntent) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      mobileqq_mp.SendPublicAccountMessageReceiptResponse localSendPublicAccountMessageReceiptResponse = new mobileqq_mp.SendPublicAccountMessageReceiptResponse();
      localSendPublicAccountMessageReceiptResponse.mergeFrom(paramBundle);
      boolean bool = paramBoolean;
      if (localSendPublicAccountMessageReceiptResponse.ret_info.has())
      {
        bool = paramBoolean;
        if (localSendPublicAccountMessageReceiptResponse.ret_info.ret_code.has())
        {
          paramInt = localSendPublicAccountMessageReceiptResponse.ret_info.ret_code.get();
          bool = paramBoolean;
          if (paramInt != 0L) {
            bool = false;
          }
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("PublicAccountManager", 2, "sendMsgArriveReceipt response :" + String.valueOf(false));
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountManager", 2, "sendMsgArriveReceipt response :" + String.valueOf(paramBoolean));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbi
 * JD-Core Version:    0.7.0.1
 */