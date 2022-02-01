import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class apws
  implements ITransactionCallback
{
  apws(apwr paramapwr) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b.TAG, 2, "upload onFailed errn:" + paramInt);
    }
    this.b.onFailed();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b.TAG, 2, "upload onSuccess");
    }
    paramHashMap = new Bdh_extinfo.CommFileExtRsp();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      this.b.picUrl = paramHashMap.bytes_download_url.get().toStringUtf8();
      this.b.cST = true;
      this.b.ecy();
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
 * Qualified Name:     apws
 * JD-Core Version:    0.7.0.1
 */