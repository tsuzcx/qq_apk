import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xb6f.Identity;
import tencent.im.oidb.oidb_0xb6f.ReportFreqRspBody;
import tencent.im.oidb.oidb_0xb6f.RspBody;

class ubf
  extends jnm.d
{
  ubf(ube paramube, String paramString1, String paramString2, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.report", 2, "onResult key=" + this.val$cacheKey + ", api=" + this.val$apiName + ", count=" + this.val$count + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.report", 2, "req error");
      }
    }
    do
    {
      for (;;)
      {
        return;
        paramBundle = new oidb_0xb6f.RspBody();
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          if (paramBundle.report_freq_rsp.has()) {
            break label146;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("DoraemonOpenAPI.report", 2, "rsp invalid");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.report", 2, "parse rsp error", paramArrayOfByte);
    return;
    label146:
    ube.a(this.this$0, this.val$cacheKey, paramBundle.report_freq_rsp.identity.apptype.get(), String.valueOf(paramBundle.report_freq_rsp.identity.appid.get()), paramBundle.report_freq_rsp.identity.apiName.get(), paramBundle.report_freq_rsp.remain_times.get(), paramBundle.report_freq_rsp.expire_time.get() * 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubf
 * JD-Core Version:    0.7.0.1
 */