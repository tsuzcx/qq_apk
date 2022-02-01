import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URLEncoder;

public class rtw
{
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, rtt paramrtt, String paramString, Bundle paramBundle)
  {
    if ((paramrtt == null) || (paramrtt.tY() == 0))
    {
      a(paramQQAppInterface, paramActivity, paramString);
      return 0;
    }
    for (;;)
    {
      try
      {
        switch (paramrtt.bizType)
        {
        case 4: 
        case 5: 
        case 7: 
        case 8: 
        case 9: 
          a(paramQQAppInterface, paramActivity, paramString);
          return 0;
        }
      }
      catch (Exception paramrtt)
      {
        String str2;
        String str3;
        String str1;
        Uri localUri;
        a(paramQQAppInterface, paramActivity, paramString);
        return 0;
      }
      a(paramQQAppInterface, paramActivity, paramrtt.a().getLongValue() + "", paramBundle.getBoolean("issupportwpa", false));
      return 1;
      str2 = "";
      str3 = paramBundle.getString("authSig");
      str1 = str2;
      if (!TextUtils.isEmpty(paramString))
      {
        localUri = Uri.parse(paramString);
        str1 = str2;
        if (localUri != null)
        {
          str1 = str2;
          if (localUri.isHierarchical()) {
            str1 = localUri.getQueryParameter("jump_from");
          }
        }
      }
      a(paramQQAppInterface, paramActivity, paramrtt.a().getLongValue() + "", str1, paramBundle.getString("authKey"), str3);
      return 2;
      a(paramQQAppInterface, paramActivity, paramrtt.a().getLongValue() + "", paramBundle);
      return 3;
      a(paramActivity, paramrtt);
      return paramrtt.bizType;
      a(paramQQAppInterface, paramActivity, oak.cu(paramrtt.a().getStringValue()), paramBundle);
      return 10;
    }
  }
  
  private static void a(Context paramContext, rtt paramrtt)
    throws Exception
  {
    jqs.a(paramContext, null, String.valueOf(paramrtt.a().getLongValue()), false, 1, true, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramString = 1024 + "https://qm.qq.com/cgi-bin/result" + "?p=a&v=" + aqgz.getQQVersion() + "&r=" + URLEncoder.encode(paramString).replaceAll("\\+", "%20") + "&_wv=1027";
    paramQQAppInterface.putExtra("title", paramActivity.getString(2131719039));
    paramQQAppInterface.putExtra("url", paramString);
    paramQQAppInterface.putExtra("key_isReadModeEnabled", true);
    if (paramActivity.getIntent().getBooleanExtra("QRDecode", false) == true)
    {
      paramActivity.startActivityForResult(paramQQAppInterface, 2);
      return;
    }
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt)
  {
    paramQQAppInterface = new Intent(paramActivity, QRCardActivity.class);
    paramQQAppInterface.putExtra("CARDMODE", paramInt);
    paramQQAppInterface.putExtra("QRCARDSTR", paramString);
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  private static final void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null)
    {
      String str = paramBundle.getString("extvalue");
      paramBundle = paramBundle.getString("exttype");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBundle)))
      {
        localIntent.putExtra("extvalue", str);
        localIntent.putExtra("exttype", paramBundle);
      }
    }
    localIntent.putExtra("source", 1);
    ocp.a(localIntent, paramQQAppInterface, paramActivity, paramString, -1);
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_1", "scan");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString1);
    localBundle.putString("card_type", "group");
    localBundle.putString("authKey", paramString3);
    localBundle.putString("authSig", paramString4);
    localBundle.putString("from", "qrcode");
    if (!TextUtils.isEmpty(aqhv.mAppId)) {
      localBundle.putString("appid", aqhv.mAppId);
    }
    if (!TextUtils.isEmpty(aqhv.mOpenId)) {
      localBundle.putString("openid", toBase64Decode(aqhv.mOpenId));
    }
    aqhv.mAppId = null;
    aqhv.mOpenId = null;
    paramString1 = paramString2;
    if (aqmr.isEmpty(paramString2))
    {
      if (!(paramActivity instanceof ScannerActivity)) {
        break label214;
      }
      paramString1 = "ScannerActivity";
    }
    for (;;)
    {
      localBundle.putString("jump_from", paramString1);
      paramQQAppInterface = aqik.c(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + jqc.b(localBundle)).toString());
      if (paramQQAppInterface != null) {
        paramQQAppInterface.ace();
      }
      return;
      label214:
      paramString1 = paramString2;
      if ((paramActivity instanceof QRJumpActivity)) {
        if (paramActivity.getIntent().getBooleanExtra("fromQrcode", false)) {
          paramString1 = "ScannerActivity";
        } else {
          paramString1 = "QRJumpActivity";
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString);
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      localBundle.putString("wpa", paramString);
      paramQQAppInterface = aqik.c(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + jqc.b(localBundle)).toString());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.edK();
        paramQQAppInterface.ace();
      }
      return;
    }
  }
  
  private static String toBase64Decode(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(aqgo.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rtw
 * JD-Core Version:    0.7.0.1
 */