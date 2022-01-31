package com.tencent.mobileqq.troop.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateActivity;

public class TroopQQBrowserHelper
{
  public static final String a = "http://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s";
  public static final String b = "&initgrouptype=%s";
  public static final String c = "1";
  
  public static void a(Context paramContext)
  {
    String str = String.format("http://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s", new Object[] { "1", "3.5.0", Integer.valueOf(0) });
    Intent localIntent = new Intent(paramContext, TroopCreateActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
    ((Activity)paramContext).overridePendingTransition(2130968590, 2130968591);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {}
    for (String str = String.format("http://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s", new Object[] { "1", "3.5.0", Integer.valueOf(1) });; str = String.format("http://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s", new Object[] { "1", "3.5.0", Integer.valueOf(0) }))
    {
      Intent localIntent = new Intent(paramContext, TroopCreateActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("isShowAd", false);
      localIntent.putExtra("troop_create_from", paramInt);
      ((BaseActivity)paramContext).startActivityForResult(localIntent, 51);
      ((Activity)paramContext).overridePendingTransition(2130968590, 2130968591);
      return;
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject1 = paramIntent.getExtras().getString("from");
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "0";
    }
    localObject1 = paramIntent.getExtras().getString("open_url");
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = localObject2;
    if ("".equals(localObject2))
    {
      localObject2 = paramIntent.getExtras().getString("troopuin");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "0";
      }
      localObject2 = paramIntent.getExtras().getString("request_params");
      paramIntent = "http://xiaoqu.qq.com/mobile/index.html?groupuin=" + (String)localObject1;
      localObject1 = paramIntent;
      if (localObject2 != null)
      {
        localObject1 = paramIntent;
        if (!"".equals(((String)localObject2).trim())) {
          localObject1 = paramIntent + "&" + (String)localObject2;
        }
      }
    }
    paramIntent = (String)localObject1 + "&from=" + (String)localObject3 + "#time=" + String.valueOf(System.currentTimeMillis());
    localObject1 = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramIntent);
    ((Intent)localObject1).putExtra("uin", paramString);
    ((Intent)localObject1).putExtra("portraitOnly", true);
    ((Intent)localObject1).putExtra("hide_more_button", true);
    ((Intent)localObject1).putExtra("hide_operation_bar", false);
    ((Intent)localObject1).putExtra("isShowAd", false);
    paramContext.startActivity((Intent)localObject1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, String paramString)
  {
    if ((paramContext == null) || (paramBundle == null)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://qun.qq.com/search/mobileqq/index.html?_bid=118");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", false);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Object localObject = String.format("http://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s", new Object[] { "1", "3.5.0", Integer.valueOf(0) });
    paramString = (String)localObject + String.format("&initgrouptype=%s", new Object[] { paramString });
    localObject = new Intent(paramContext, TroopCreateActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("isShowAd", false);
    paramContext.startActivity((Intent)localObject);
    ((Activity)paramContext).overridePendingTransition(2130968590, 2130968591);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    String str = "";
    if (TextUtils.isEmpty(paramString1)) {
      str = "http://xiaoqu.qq.com/mobile/index.html";
    }
    paramString1 = new Intent(paramContext, QQBrowserActivity.class);
    paramString1.putExtra("url", str);
    paramString1.putExtra("uin", paramString2);
    paramString1.putExtra("portraitOnly", true);
    paramString1.putExtra("hide_more_button", true);
    paramString1.putExtra("hide_operation_bar", false);
    paramString1.putExtra("isShowAd", false);
    paramContext.startActivity(paramString1);
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://qqweb.qq.com/m/qunactivity/form.html?_wv=7&_bid=244&type=relgroup");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper
 * JD-Core Version:    0.7.0.1
 */