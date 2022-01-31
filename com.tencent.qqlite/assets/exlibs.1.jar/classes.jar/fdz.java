import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
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

public class fdz
  extends SSOAccountObserver
{
  public fdz(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.k();
    if (paramInt2 == -1000)
    {
      this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a, this.a.getResources().getString(2131363836));
      return;
    }
    paramBundle = (ErrMsg)paramBundle.getParcelable("lastError");
    QuickLoginAuthorityActivity localQuickLoginAuthorityActivity = this.a;
    if (paramBundle == null) {}
    for (paramBundle = this.a.getString(2131363842);; paramBundle = paramBundle.getMessage())
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
        Object localObject = this.a.jdField_a_of_type_AndroidOsBundle.getString("retPath");
        String str = this.a.jdField_a_of_type_AndroidOsBundle.getString("schemacallback");
        paramBundle = (Bundle)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).endsWith("&")) {
            paramBundle = (String)localObject + "&";
          }
        }
        paramString = "keyindex=19&clientuin=$CLIENTUIN$&clientkey=$CLIENTKEY$".replace("$CLIENTUIN$", paramString).replace("$CLIENTKEY$", paramArrayOfByte);
        paramBundle = paramBundle + paramString;
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramBundle));
        if (!TextUtils.isEmpty(str))
        {
          if (!str.startsWith("ucweb://")) {
            continue;
          }
          paramString = "com.UCMobile";
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            continue;
          }
        }
        try
        {
          paramArrayOfByte = this.a.getPackageManager().getPackageInfo(paramString, 0);
          if (paramArrayOfByte != null)
          {
            ((Intent)localObject).setPackage(paramString);
            ((Intent)localObject).setData(Uri.parse(paramBundle));
          }
          this.a.startActivity((Intent)localObject);
          this.a.j();
          return;
        }
        catch (PackageManager.NameNotFoundException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
        if (str.startsWith("mttbrowser://"))
        {
          paramString = "com.tencent.mtt";
          continue;
        }
        if (str.startsWith("bdbrowser://"))
        {
          paramString = "com.baidu.browser.apps";
          continue;
        }
        if (str.startsWith("googlechrome://"))
        {
          paramString = "com.android.chrome";
          continue;
          paramArrayOfByte = null;
          continue;
        }
        paramString = "";
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      continue;
      paramArrayOfByte = null;
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fdz
 * JD-Core Version:    0.7.0.1
 */