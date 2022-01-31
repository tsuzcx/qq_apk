package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webviewplugin.WebViewPluginConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class VasWebviewUtil
{
  public static Intent a(long paramLong, Intent paramIntent)
  {
    Intent localIntent;
    if (paramIntent == null) {
      localIntent = null;
    }
    String str;
    do
    {
      do
      {
        return localIntent;
        localIntent = paramIntent;
      } while (paramLong <= 0L);
      str = String.valueOf(paramLong);
      localIntent = paramIntent;
    } while (!WebViewPluginConfig.a.containsKey(str));
    paramIntent.putExtra("insertPluginsArray", new String[] { str });
    return paramIntent;
  }
  
  public static void a(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    if (paramIntent != null)
    {
      paramIntent.setClass(paramContext, QQBrowserActivity.class);
      if (!TextUtils.isEmpty(paramString)) {
        paramIntent.putExtra("url", paramString);
      }
      paramIntent.putExtra("business", paramLong);
      a(paramLong, paramIntent);
      paramIntent.putExtra("isShowAd", false);
      if (paramContext == null) {
        break label105;
      }
      if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
        break label98;
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
    }
    label98:
    label105:
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
  
  public static boolean a(Context paramContext)
  {
    if (!Utils.e())
    {
      Toast.makeText(paramContext, paramContext.getString(2131363510), 0).show();
      return false;
    }
    if (Utils.b() < 5242880L)
    {
      Toast.makeText(paramContext, paramContext.getString(2131363511), 0).show();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil
 * JD-Core Version:    0.7.0.1
 */