import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;

class zti
  implements BusinessObserver
{
  zti(zth paramzth, String paramString, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_JavaLangString.equals(localObject)) {
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
          zva.a(this.jdField_a_of_type_Zth.jdField_a_of_type_Zrt, paramInt, (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(zth.jdField_a_of_type_JavaLangString, 2, "parse auth info error: \n" + paramBundle.getMessage());
        }
        zva.a(this.jdField_a_of_type_Zth.jdField_a_of_type_Zrt, -1, "parse auth info error");
        return;
      }
      localObject = (SdkAuthorize.AuthorizeResponse)paramBundle.auth_response.get();
      if ((!zuv.jdField_a_of_type_Boolean) && (zth.a(this.jdField_a_of_type_Zth, paramBundle)) && (localObject != null) && (((SdkAuthorize.AuthorizeResponse)localObject).has()))
      {
        paramBundle = new ztg();
        paramBundle.jdField_a_of_type_JavaLangString = ((SdkAuthorize.AuthorizeResponse)localObject).openid.get().toUpperCase();
        paramBundle.jdField_b_of_type_JavaLangString = ((SdkAuthorize.AuthorizeResponse)localObject).access_token.get().toUpperCase();
        paramBundle.jdField_a_of_type_Long = ((SdkAuthorize.AuthorizeResponse)localObject).expires_in.get();
        paramBundle.jdField_b_of_type_Long = (paramBundle.jdField_a_of_type_Long + System.currentTimeMillis());
        this.jdField_a_of_type_Zth.jdField_a_of_type_Ztd.a(paramBundle);
        zva.a(this.jdField_a_of_type_Zth.jdField_a_of_type_Zrt, paramBundle.a());
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        zth.a(this.jdField_a_of_type_Zth);
        return;
      }
      paramBundle = "";
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_Zth.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bbvs)this.jdField_a_of_type_Zth.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramBundle = paramBundle + ((bbvs)localObject).jdField_a_of_type_JavaLangString + "\n";
        paramInt += 1;
      }
      zth.a(this.jdField_a_of_type_Zth, paramBundle);
      return;
    }
    zva.a(this.jdField_a_of_type_Zth.jdField_a_of_type_Zrt, paramInt, "get auth info failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zti
 * JD-Core Version:    0.7.0.1
 */