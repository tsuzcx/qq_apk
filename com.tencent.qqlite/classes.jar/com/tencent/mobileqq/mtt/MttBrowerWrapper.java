package com.tencent.mobileqq.mtt;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class MttBrowerWrapper
{
  public static int a = 0;
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    try
    {
      paramContext.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      QQToast.a(paramContext, "未找其他浏览器。", 0).b(paramContext.getResources().getDimensionPixelSize(2131492887));
    }
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    a(paramContext, paramString1, paramBoolean, false, false, false, paramInt, paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, String paramString2)
  {
    if (QRUtils.b(paramString1))
    {
      a += 1;
      paramString2 = new Intent(paramContext, JoinDiscussionActivity.class);
      paramInt = paramString1.indexOf("dc/ft?k=");
      if (paramInt > 0) {
        paramString2.putExtra("innerSig", paramString1.substring("dc/ft?k=".length() + paramInt));
      }
      for (;;)
      {
        paramContext.startActivity(paramString2);
        return;
        paramString2.putExtra("innerSig", paramString1);
      }
    }
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", paramBoolean4);
    localIntent.putExtra("key_isReadModeEnabled", paramBoolean1);
    localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getAccount());
    localIntent.putExtra("vkey", ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).d());
    localIntent.putExtra("useDefBackText", paramBoolean3);
    localIntent.putExtra("curtype", paramInt);
    localIntent.putExtra("injectrecommend", paramBoolean2);
    localIntent.putExtra("friendUin", paramString2);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromAio", true);
    PublicAccountUtil.a(localIntent, paramString1);
    paramContext.startActivity(localIntent);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mtt.MttBrowerWrapper
 * JD-Core Version:    0.7.0.1
 */