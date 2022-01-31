package com.tencent.biz.qrcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.net.URLEncoder;

public class QRResultHandler
{
  static final String a = "http://qm.qq.com/cgi-bin/result";
  private static final String b = "mqqapi://card/show_pslcard";
  
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, QRActionEntity paramQRActionEntity, String paramString, Bundle paramBundle)
  {
    if ((paramQRActionEntity == null) || (paramQRActionEntity.a() == 0))
    {
      a(paramQQAppInterface, paramActivity, paramString);
      return 0;
    }
    for (;;)
    {
      try
      {
        switch (paramQRActionEntity.r)
        {
        case 5: 
          a(paramQQAppInterface, paramActivity, paramString);
          return 0;
        }
      }
      catch (Exception paramQRActionEntity)
      {
        a(paramQQAppInterface, paramActivity, paramString);
        return 0;
      }
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", paramBundle.getBoolean("issupportwpa", false));
      return 1;
      String str = "";
      paramBundle = str;
      if (!TextUtils.isEmpty(paramString))
      {
        Uri localUri = Uri.parse(paramString);
        paramBundle = str;
        if (localUri != null)
        {
          paramBundle = str;
          if (localUri.isHierarchical()) {
            paramBundle = localUri.getQueryParameter("jump_from");
          }
        }
      }
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", paramBundle);
      return 2;
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", paramBundle);
      return 3;
      QQToast.a(paramActivity, 2131364497, 0).a();
      return 4;
      a(paramActivity, paramQRActionEntity);
      int i = paramQRActionEntity.r;
      return i;
    }
  }
  
  private static void a(Context paramContext, QRActionEntity paramQRActionEntity)
  {
    long l = paramQRActionEntity.a().a();
    paramQRActionEntity = new Intent(paramContext, EnterpriseDetailActivity.class);
    paramQRActionEntity.putExtra("uin", String.valueOf(l));
    paramQRActionEntity.putExtra("need_finish", false);
    paramContext.startActivity(paramQRActionEntity);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramString = 1024 + "http://qm.qq.com/cgi-bin/result" + "?p=a&v=" + DeviceInfoUtil.c() + "&r=" + URLEncoder.encode(paramString).replaceAll("\\+", "%20") + "&_wv=1027";
    paramQQAppInterface.putExtra("title", paramActivity.getString(2131362379));
    paramQQAppInterface.putExtra("url", paramString);
    paramQQAppInterface.putExtra("key_isReadModeEnabled", true);
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
    Toast.makeText(paramActivity, "public account openPublicAccountCard", 1).show();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString1);
    localBundle.putString("card_type", "group");
    localBundle.putString("from", "qrcode");
    paramString1 = paramString2;
    if (StringUtil.b(paramString2))
    {
      if (!(paramActivity instanceof ScannerActivity)) {
        break label143;
      }
      paramString1 = "ScannerActivity";
    }
    for (;;)
    {
      localBundle.putString("jump_from", paramString1);
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.a(localBundle)).toString());
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b();
      }
      return;
      label143:
      paramString1 = paramString2;
      if ((paramActivity instanceof QRJumpActivity)) {
        paramString1 = "QRJumpActivity";
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
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.a(localBundle)).toString());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a();
        paramQQAppInterface.b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.QRResultHandler
 * JD-Core Version:    0.7.0.1
 */