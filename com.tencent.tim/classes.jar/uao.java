import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class uao
  implements BusinessObserver
{
  uao(uaj paramuaj, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d(uaj.TAG, 2, "-->doAuthorize-onReceive, ssoAccount: " + (String)localObject + " | uin: " + this.aKo + " isSuccess: " + paramBoolean);
    }
    if (!this.aKo.equals(localObject)) {
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      localObject = new SdkAuthorize.AuthorizeResponse();
      try
      {
        paramBundle = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
        paramInt = paramBundle.ret.get();
        localObject = paramBundle.msg.get();
        if (paramInt != 0)
        {
          ubu.a(this.b.d, paramInt, (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(uaj.TAG, 2, "parse do auth result error: \n" + paramBundle.getMessage());
        }
        ubu.a(this.b.d, -2, "parse do auth result error");
        return;
      }
      localObject = new uag.a();
      ((uag.a)localObject).openid = paramBundle.openid.get().toUpperCase();
      ((uag.a)localObject).openKey = paramBundle.access_token.get().toUpperCase();
      paramBundle = paramBundle.callbackURL.get();
      if (QLog.isColorLevel()) {}
      uaj.b(this.b, paramBundle);
      this.b.b.a((uag.a)localObject);
      ubu.a(this.b.d, ((uag.a)localObject).S());
      return;
    }
    ubu.a(this.b.d, paramInt, "do auth error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uao
 * JD-Core Version:    0.7.0.1
 */