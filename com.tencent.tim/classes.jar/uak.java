import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.CardContainer.a;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;

class uak
  implements BusinessObserver
{
  uak(uaj paramuaj, String paramString, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.aKo.equals(localObject)) {
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      localObject = new SdkAuthorize.GetAuthApiListResponse();
      try
      {
        paramBundle = (SdkAuthorize.GetAuthApiListResponse)((SdkAuthorize.GetAuthApiListResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
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
          QLog.d(uaj.TAG, 2, "parse auth info error: \n" + paramBundle.getMessage());
        }
        ubu.a(this.b.d, -1, "parse auth info error");
        return;
      }
      localObject = (SdkAuthorize.AuthorizeResponse)paramBundle.auth_response.get();
      if ((!ubp.aQQ) && (uaj.a(this.b, paramBundle)) && (localObject != null) && (((SdkAuthorize.AuthorizeResponse)localObject).has()))
      {
        paramBundle = new uag.a();
        paramBundle.openid = ((SdkAuthorize.AuthorizeResponse)localObject).openid.get().toUpperCase();
        paramBundle.openKey = ((SdkAuthorize.AuthorizeResponse)localObject).access_token.get().toUpperCase();
        paramBundle.expireIn = ((SdkAuthorize.AuthorizeResponse)localObject).expires_in.get();
        paramBundle.expireTime = (paramBundle.expireIn + System.currentTimeMillis());
        this.b.b.a(paramBundle);
        ubu.a(this.b.d, paramBundle.S());
        return;
      }
      if (this.aQO)
      {
        uaj.a(this.b);
        return;
      }
      paramBundle = "";
      paramInt = 0;
      while (paramInt < this.b.qf.size())
      {
        localObject = (CardContainer.a)this.b.qf.get(paramInt);
        paramBundle = paramBundle + ((CardContainer.a)localObject).title + "\n";
        paramInt += 1;
      }
      uaj.a(this.b, paramBundle);
      return;
    }
    ubu.a(this.b.d, paramInt, "get auth info failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uak
 * JD-Core Version:    0.7.0.1
 */