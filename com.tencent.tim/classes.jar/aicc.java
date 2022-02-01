import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aicc
  implements BusinessObserver
{
  aicc(aica paramaica, aica.b paramb, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    new Bundle();
    paramBundle = paramBundle.getByteArray("data");
    if (paramBundle == null)
    {
      this.jdField_a_of_type_Aica$b.l(this.bMO, false, -10002);
      return;
    }
    FastAuthorize.AuthorizeResponse localAuthorizeResponse = new FastAuthorize.AuthorizeResponse();
    try
    {
      localAuthorizeResponse.mergeFrom(paramBundle);
      if ((localAuthorizeResponse.ret.get().equals("0")) && (localAuthorizeResponse.apk_name.has()))
      {
        if (localAuthorizeResponse.access_token.has()) {
          this.jdField_a_of_type_Aica.a.mAccessToken = localAuthorizeResponse.access_token.get();
        }
        if (localAuthorizeResponse.openid.has()) {
          this.jdField_a_of_type_Aica.a.mOpenID = localAuthorizeResponse.openid.get();
        }
        if (localAuthorizeResponse.pay_token.has()) {
          this.jdField_a_of_type_Aica.a.bMP = localAuthorizeResponse.pay_token.get();
        }
        this.jdField_a_of_type_Aica.a.abj = System.currentTimeMillis();
        this.jdField_a_of_type_Aica$b.l(this.bMO, true, 0);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      this.jdField_a_of_type_Aica$b.l(this.bMO, false, -10003);
      paramBundle.printStackTrace();
      return;
    }
    QLog.e("XProxy", 2, "获取票据失败");
    try
    {
      this.jdField_a_of_type_Aica$b.l(this.bMO, false, Integer.parseInt(localAuthorizeResponse.ret.get()));
      return;
    }
    catch (NumberFormatException paramBundle)
    {
      this.jdField_a_of_type_Aica$b.l(this.bMO, false, 0);
      QLog.e("XProxy", 2, "获取票据错误码不为int");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicc
 * JD-Core Version:    0.7.0.1
 */