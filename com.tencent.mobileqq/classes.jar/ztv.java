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

public class ztv
  extends mmn
{
  public ztv(VerifyUrlJobSegment paramVerifyUrlJobSegment, armr paramarmr, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "onResult type=" + this.jdField_a_of_type_Armr.jdField_a_of_type_Int + ", appid=" + this.jdField_a_of_type_Armr.jdField_a_of_type_JavaLangString + ", url=" + this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewVerifyUrlJobSegment.jdField_a_of_type_JavaLangString + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      VerifyUrlJobSegment.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewVerifyUrlJobSegment, new AppInfoError(7, "jobVerifyUrl req error " + paramInt));
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
        VerifyUrlJobSegment.b(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewVerifyUrlJobSegment, new AppInfoError(7, "jobVerifyUrl rsp invalid"));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "rsp invalid");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        VerifyUrlJobSegment.d(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewVerifyUrlJobSegment, new AppInfoError(7, "jobVerifyUrl parse rsp error"));
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
          VerifyUrlJobSegment.jdField_a_of_type_AndroidUtilLruCache.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(NetConnInfoCenter.getServerTimeMillis() + paramBundle.check_url_rsp.next_req_duration.get() * 1000L));
          VerifyUrlJobSegment.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewVerifyUrlJobSegment, this.jdField_a_of_type_Armr);
          return;
        }
        VerifyUrlJobSegment.c(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewVerifyUrlJobSegment, new VerifyUrlJobSegment.UrlNotauthorizedError());
        return;
        label444:
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ztv
 * JD-Core Version:    0.7.0.1
 */