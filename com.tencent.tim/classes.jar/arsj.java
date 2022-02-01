import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

public class arsj
  extends SSOAccountObserver
{
  public arsj(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onFailed--action = " + paramInt1 + ", ret = " + paramInt2 + ", ssoAccount = *" + artw.qx(paramString));
    this.this$0.jf();
    if (paramInt2 == -1000)
    {
      this.this$0.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.aV(this.this$0, this.this$0.getResources().getString(2131696664));
      return;
    }
    paramBundle = (ErrMsg)paramBundle.getParcelable("lastError");
    if (paramBundle == null) {}
    for (paramBundle = this.this$0.getString(2131696660);; paramBundle = paramBundle.getMessage())
    {
      QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "ssoAccount failed, error: ", paramBundle });
      QQToast.a(BaseApplicationImpl.getContext(), paramBundle + "(" + paramInt2 + ")", 0).show();
      this.this$0.WO(paramString);
      return;
    }
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onGetA1WithA1--ret = " + paramInt1 + ", ssoAccount = *" + artw.qx(paramString));
    paramString = "" + this.this$0.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.this$0.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.this$0.aIE = paramString;
    this.this$0.cBU = null;
    paramString = new WloginSimpleInfo();
    this.this$0.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.this$0.aIE, paramString);
    paramArrayOfByte = new RSACrypt(this.this$0).EncryptData(this.this$0.hl, paramArrayOfByte);
    paramString = (ErrMsg)paramBundle.getParcelable("errMsg");
    paramBundle = this.this$0;
    String str = this.this$0.aIE;
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.getMessage())
    {
      paramBundle.a(paramInt1, paramArrayOfByte, str, paramString);
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onGetTicketNoPasswd--ssoAccount = *" + artw.qx(paramString));
    this.this$0.cBU = null;
    if ((this.this$0.mParams.containsKey("qrcode")) && (this.this$0.mParams.containsKey("schemacallback"))) {
      QuickLoginAuthorityActivity.a(this.this$0);
    }
    while (!this.this$0.mParams.containsKey("p")) {
      return;
    }
    aenj localaenj = (aenj)aeif.a().o(546);
    paramBundle = "";
    if (paramInt == 32) {
      paramBundle = util.buf_to_string(paramArrayOfByte);
    }
    String str1 = this.this$0.mParams.getString("p");
    paramArrayOfByte = str1;
    if (!TextUtils.isEmpty(str1))
    {
      paramArrayOfByte = str1;
      if (!str1.endsWith("&")) {
        paramArrayOfByte = str1 + "&";
      }
    }
    paramString = "keyindex=19&clientuin=$CLIENTUIN$&clientkey=$CLIENTKEY$".replace("$CLIENTUIN$", paramString).replace("$CLIENTKEY$", paramBundle);
    String str3 = paramArrayOfByte + paramString;
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
    paramBundle = null;
    str1 = null;
    String str2 = this.this$0.mParams.getString("schemacallback");
    paramString = str1;
    if (!TextUtils.isEmpty(str2))
    {
      if (str2.startsWith("mttbrowser://")) {
        paramString = "com.tencent.mtt";
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label815;
      }
      paramArrayOfByte = Uri.parse(paramArrayOfByte).getQueryParameter("pt_browser");
      QLog.i("SSOAccountObserver", 1, "-->onGetTicketNoPasswd--schemacallback=" + str2 + ",pt_browser=" + paramArrayOfByte);
      if ((TextUtils.isEmpty(paramArrayOfByte)) || (!"LieBaoFast".equals(paramArrayOfByte))) {
        break label815;
      }
      paramString = "com.ijinshan.browser_fast";
    }
    label808:
    label815:
    for (;;)
    {
      for (;;)
      {
        paramInt = 0;
        if (!TextUtils.isEmpty(paramString)) {}
        try
        {
          paramArrayOfByte = this.this$0.getPackageManager().getPackageInfo(paramString, 0);
          if (localaenj.cNY == 1)
          {
            paramBundle = (String)localaenj.fa.get(paramString);
            if ((this.this$0.cb(paramString, paramBundle)) && (paramArrayOfByte != null))
            {
              paramInt = 1;
              if (paramInt != 0)
              {
                localIntent.setPackage(paramString);
                localIntent.setData(Uri.parse(str3));
              }
              if ((localaenj.cNZ != 1) || (paramInt != 0)) {
                break label756;
              }
              this.this$0.jf();
              QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131712635), 1).show();
              paramArrayOfByte = new HashMap();
              paramArrayOfByte.put("callback", str2);
              if (paramInt == 0) {
                break label808;
              }
              paramString = "1";
              paramArrayOfByte.put("checkRes", paramString);
              anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "kQuickLoginForBrowser", true, 0L, 0L, paramArrayOfByte, "");
              return;
              if (str2.startsWith("ucweb://"))
              {
                paramString = "com.UCMobile";
                break;
              }
              if (str2.startsWith("bdbrowser://"))
              {
                paramString = "com.baidu.browser.apps";
                break;
              }
              if (str2.startsWith("bdapp://"))
              {
                paramString = "com.baidu.searchbox";
                break;
              }
              if (str2.startsWith("googlechrome://"))
              {
                paramString = "com.android.chrome";
                break;
              }
              if (str2.startsWith("mzbrowser://"))
              {
                paramString = "com.android.browser";
                break;
              }
              if (str2.startsWith("lb://"))
              {
                paramString = "com.ijinshan.browser_fast";
                break;
              }
              if (str2.startsWith("qihoobrowser://"))
              {
                paramString = "com.qihoo.browser";
                break;
              }
              if (str2.startsWith("browser2345://"))
              {
                paramString = "com.browser2345";
                break;
              }
              paramString = str1;
              if (!str2.startsWith("SogouMSE://")) {
                break;
              }
              paramString = "sogou.mobile.explorer";
            }
          }
        }
        catch (PackageManager.NameNotFoundException paramArrayOfByte)
        {
          for (;;)
          {
            QLog.e("SSOAccountObserver", 1, "-->onGetTicketNoPasswd exception:" + paramArrayOfByte.getStackTrace().toString());
            paramArrayOfByte = paramBundle;
            continue;
            paramInt = 0;
            continue;
            if (paramArrayOfByte != null)
            {
              paramInt = 1;
            }
            else
            {
              paramInt = 0;
              continue;
              try
              {
                label756:
                this.this$0.startActivity(localIntent);
                this.this$0.elx();
              }
              catch (Exception paramString)
              {
                for (;;)
                {
                  QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "startActivity :" + paramString.getMessage());
                }
              }
              paramString = "0";
            }
          }
        }
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onUserCancel--action = " + paramInt + ", ssoAccount = *" + artw.qx(paramString));
    this.this$0.jf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsj
 * JD-Core Version:    0.7.0.1
 */