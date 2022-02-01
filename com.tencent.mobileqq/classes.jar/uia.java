import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;

class uia
  extends ntf
{
  uia(uhz paramuhz) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        paramBundle = new oidb_0x6cf.RspBody();
        if (paramArrayOfByte != null) {
          paramBundle.mergeFrom(paramArrayOfByte);
        }
        paramBundle = (oidb_0x885.RspBody)paramBundle.msg_ad_rsp.get();
        if ((paramInt == 0) && (paramArrayOfByte != null)) {
          paramBundle.mergeFrom(paramArrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialHandler", 2, "errorCode = " + paramInt + ", rspBody.bytes_ad_user_info.has = " + paramBundle.bytes_ad_user_info.has());
        }
        if ((paramBundle != null) && (paramBundle.bytes_ad_user_info.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AdMaterialHandler", 2, "errorCode = " + paramInt + ", rspBody.bytes_ad_user_info = " + paramBundle.bytes_ad_user_info.get().toStringUtf8());
          }
          paramArrayOfByte = this.a;
          if (paramInt == 0)
          {
            bool = true;
            paramArrayOfByte.notifyUI(1, bool, paramBundle.bytes_ad_user_info.get().toStringUtf8());
            ujg.a.a(null, true, "no error", paramBundle.bytes_ad_user_info.get().toStringUtf8(), "resource_fetch_key");
            ujg.a.a("", "requestSuccess", 1);
          }
        }
        else
        {
          ujg.a.a(null, true, "error with errorcode: " + paramInt, null, "resource_fetch_key");
          ujg.a.a("", "requestFail", 1);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialHandler", 2, "Exception error" + QLog.getStackTraceString(paramArrayOfByte));
        }
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uia
 * JD-Core Version:    0.7.0.1
 */