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

public class zvr
{
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, zvn paramzvn, String paramString, Bundle paramBundle)
  {
    if ((paramzvn == null) || (paramzvn.a() == 0))
    {
      a(paramQQAppInterface, paramActivity, paramString);
      return 0;
    }
    for (;;)
    {
      try
      {
        switch (paramzvn.c)
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
      catch (Exception paramzvn)
      {
        String str3;
        String str4;
        String str5;
        String str2;
        String str1;
        Uri localUri;
        a(paramQQAppInterface, paramActivity, paramString);
        return 0;
      }
      a(paramQQAppInterface, paramActivity, paramzvn.a().a() + "", paramBundle.getBoolean("issupportwpa", false));
      return 1;
      str3 = "";
      str4 = "";
      str5 = paramBundle.getString("authSig");
      str2 = str3;
      str1 = str4;
      if (!TextUtils.isEmpty(paramString))
      {
        localUri = Uri.parse(paramString);
        str2 = str3;
        str1 = str4;
        if (localUri != null)
        {
          str2 = str3;
          str1 = str4;
          if (localUri.isHierarchical())
          {
            str3 = localUri.getQueryParameter("jump_from");
            str4 = localUri.getQueryParameter("source_id");
            str2 = str3;
            str1 = str4;
            if (TextUtils.isEmpty(str4))
            {
              str1 = paramBundle.getString("sourceId", "");
              str2 = str3;
            }
          }
        }
      }
      a(paramQQAppInterface, paramActivity, paramzvn.a().a() + "", str2, str1, paramBundle.getString("authKey"), str5);
      return 2;
      a(paramQQAppInterface, paramActivity, paramzvn.a().a() + "", paramBundle);
      return 3;
      a(paramActivity, paramzvn);
      return paramzvn.c;
      a(paramQQAppInterface, paramActivity, twh.a(paramzvn.a().a()), paramBundle);
      return 10;
    }
  }
  
  private static String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(bhkv.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static void a(Context paramContext, zvn paramzvn)
  {
    nok.a(paramContext, null, String.valueOf(paramzvn.a().a()), false, 1, true, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramString = 1024 + "https://qm.qq.com/cgi-bin/result" + "?p=a&v=" + bhlo.c() + "&r=" + URLEncoder.encode(paramString).replaceAll("\\+", "%20") + "&_wv=1027";
    paramQQAppInterface.putExtra("title", paramActivity.getString(2131717582));
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
    tzq.a(localIntent, paramQQAppInterface, paramActivity, paramString, -1);
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_1", "scan");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString1);
    localBundle.putString("card_type", "group");
    localBundle.putString("authKey", paramString4);
    localBundle.putString("authSig", paramString5);
    localBundle.putString("from", "qrcode");
    if (!TextUtils.isEmpty(bhmr.l)) {
      localBundle.putString("appid", bhmr.l);
    }
    if (!TextUtils.isEmpty(bhmr.m)) {
      localBundle.putString("openid", a(bhmr.m));
    }
    bhmr.l = null;
    bhmr.m = null;
    paramString1 = paramString2;
    if (bhsr.a(paramString2))
    {
      if (!(paramActivity instanceof ScannerActivity)) {
        break label239;
      }
      paramString1 = "ScannerActivity";
    }
    for (;;)
    {
      if (!bhsr.a(paramString3)) {
        localBundle.putString("source_id", paramString3);
      }
      localBundle.putString("jump_from", paramString1);
      paramQQAppInterface = bhni.a(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + nnr.a(localBundle)).toString());
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a();
      }
      return;
      label239:
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
      paramQQAppInterface = bhni.a(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + nnr.a(localBundle)).toString());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.b();
        paramQQAppInterface.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvr
 * JD-Core Version:    0.7.0.1
 */