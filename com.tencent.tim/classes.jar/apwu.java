import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class apwu
  implements ITransactionCallback
{
  apwu(apwt paramapwt) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "upload onFailed errn:" + paramInt);
    }
    this.a.onFailed();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "upload onSuccess");
    }
    paramHashMap = new PttShortVideo.PttShortVideoUploadResp();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)paramHashMap.mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has()) {
        this.a.ajA = paramArrayOfByte.str_fileid.get();
      }
      this.a.cSU = true;
      this.a.ecy();
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwu
 * JD-Core Version:    0.7.0.1
 */