import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

public class hjk
  extends SSOAccountObserver
{
  public hjk(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.m();
    if (paramInt2 == -1000)
    {
      this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a, this.a.getResources().getString(2131562443));
      return;
    }
    paramBundle = (ErrMsg)paramBundle.getParcelable("lastError");
    QuickLoginAuthorityActivity localQuickLoginAuthorityActivity = this.a;
    if (paramBundle == null) {}
    for (paramBundle = this.a.getString(2131562323);; paramBundle = paramBundle.getMessage())
    {
      Toast.makeText(localQuickLoginAuthorityActivity, paramBundle, 0).show();
      this.a.a(paramString);
      return;
    }
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    paramString = "" + this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.a.d = paramString;
    paramString = new WloginSimpleInfo();
    this.a.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.a.d, paramString);
    paramArrayOfByte = new RSACrypt(this.a).EncryptData(this.a.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
    paramString = (ErrMsg)paramBundle.getParcelable("errMsg");
    paramBundle = this.a;
    String str = this.a.d;
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.getMessage())
    {
      paramBundle.a(paramInt1, paramArrayOfByte, str, paramString);
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 32) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = util.buf_to_string(paramArrayOfByte);
        String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("retPath");
        String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("schemacallback");
        paramBundle = str1;
        if (!TextUtils.isEmpty(str1))
        {
          paramBundle = str1;
          if (!str1.endsWith("&")) {
            paramBundle = str1 + "&";
          }
        }
        paramString = "keyindex=19&clientuin=$CLIENTUIN$&clientkey=$CLIENTKEY$".replace("$CLIENTUIN$", paramString).replace("$CLIENTKEY$", paramArrayOfByte);
        paramArrayOfByte = paramBundle + paramString;
        paramString = paramArrayOfByte;
        if (!TextUtils.isEmpty(str2)) {
          paramString = str2 + paramArrayOfByte;
        }
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        this.a.startActivity(paramString);
        this.a.l();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramArrayOfByte = null;
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hjk
 * JD-Core Version:    0.7.0.1
 */