import android.os.Bundle;
import android.util.LruCache;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment;
import com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment.UrlNotauthorizedError;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xb60.CheckUrlRsp;
import tencent.im.oidb.oidb_0xb60.RspBody;

public class uav
  extends jnm.d
{
  public uav(VerifyUrlJobSegment paramVerifyUrlJobSegment, ajcn paramajcn, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "onResult type=" + this.c.appType + ", appid=" + this.c.appId + ", url=" + this.a.aKq + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      VerifyUrlJobSegment.a(this.a, new AppInfoError(7, "jobVerifyUrl req error " + paramInt));
      if ((QLog.isColorLevel()) && (paramArrayOfByte == null)) {
        break label444;
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = ((oidb_0xb60.RspBody)new oidb_0xb60.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
        StringBuilder localStringBuilder = new StringBuilder().append("req error code=").append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ", data=null";
          QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, paramArrayOfByte);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle = "";
        continue;
        paramArrayOfByte = ", msg=" + paramBundle;
        continue;
      }
      paramBundle = new oidb_0xb60.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.check_url_rsp.has()) {
          break label313;
        }
        VerifyUrlJobSegment.b(this.a, new AppInfoError(7, "jobVerifyUrl rsp invalid"));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "rsp invalid");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        VerifyUrlJobSegment.d(this.a, new AppInfoError(7, "jobVerifyUrl parse rsp error"));
      }
      if (QLog.isColorLevel())
      {
        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "parse rsp error", paramArrayOfByte);
        return;
        label313:
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.jobVerifyUrl", 2, "receive is_auth:" + paramBundle.check_url_rsp.is_authed.get() + ", duration:" + paramBundle.check_url_rsp.next_req_duration.get());
        }
        if (paramBundle.check_url_rsp.is_authed.get())
        {
          VerifyUrlJobSegment.o.put(this.val$cacheKey, Long.valueOf(NetConnInfoCenter.getServerTimeMillis() + paramBundle.check_url_rsp.next_req_duration.get() * 1000L));
          VerifyUrlJobSegment.a(this.a, this.c);
          return;
        }
        VerifyUrlJobSegment.c(this.a, new VerifyUrlJobSegment.UrlNotauthorizedError());
        return;
        label444:
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uav
 * JD-Core Version:    0.7.0.1
 */