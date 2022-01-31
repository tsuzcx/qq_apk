package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class VasWebviewUtil
{
  public static void a(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    if (paramIntent != null)
    {
      paramIntent.setClass(paramContext, QQBrowserActivity.class);
      if (!TextUtils.isEmpty(paramString)) {
        paramIntent.putExtra("url", paramString);
      }
      paramIntent.putExtra("business", paramLong);
      paramIntent.putExtra("isShowAd", false);
      if (paramContext == null) {
        break label98;
      }
      if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
        break label91;
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
    }
    label91:
    label98:
    while (!QLog.isDevelopLevel())
    {
      return;
      paramIntent = new Intent(paramContext, QQBrowserActivity.class);
      break;
      paramContext.startActivity(paramIntent);
      return;
    }
    QLog.d("VasWebviewUtil", 4, "open qqbrowser erro context");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil
 * JD-Core Version:    0.7.0.1
 */