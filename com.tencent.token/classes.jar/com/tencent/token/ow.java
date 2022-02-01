package com.tencent.token;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

class ow
  implements oy
{
  private static String f;
  protected Context a;
  protected String b;
  protected boolean c = false;
  protected boolean d = false;
  private int e;
  
  ow(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("<init>, appId = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", checkSignature = true");
    this.a = paramContext;
    this.b = paramString;
    this.c = true;
    pg.a = paramContext.getApplicationContext();
  }
  
  private static boolean a(Context paramContext, Bundle paramBundle)
  {
    if (f == null)
    {
      f = new oz(paramContext).getString("_wxapp_pay_entry_classname_", null);
      new StringBuilder("pay, set wxappPayEntryClassname = ").append(f);
      if (f == null) {
        try
        {
          f = paramContext.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
        }
        catch (Exception localException)
        {
          new StringBuilder("get from metaData failed : ").append(localException.getMessage());
        }
      }
      if (f == null) {
        return false;
      }
    }
    od.a locala = new od.a();
    locala.f = paramBundle;
    locala.a = "com.tencent.mm";
    locala.b = f;
    return od.a(paramContext, locala);
  }
  
  private boolean c()
  {
    if (!this.d)
    {
      if (!a()) {
        return false;
      }
      try
      {
        this.a.startActivity(this.a.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
        return true;
      }
      catch (Exception localException)
      {
        new StringBuilder("startActivity fail, exception = ").append(localException.getMessage());
        return false;
      }
    }
    throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
  }
  
  private void d()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      c();
    }
  }
  
  public final boolean a()
  {
    if (!this.d) {}
    try
    {
      PackageInfo localPackageInfo = this.a.getPackageManager().getPackageInfo("com.tencent.mm", 64);
      if (localPackageInfo == null) {
        return false;
      }
      boolean bool = pb.a(localPackageInfo.signatures, this.c);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
    return false;
  }
  
  public final boolean a(og paramog)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (!this.d)
    {
      if (!pb.a(this.a, "com.tencent.mm", this.c)) {
        return false;
      }
      if (!paramog.b()) {
        return false;
      }
      new StringBuilder("sendReq, req type = ").append(paramog.a());
      localObject3 = new Bundle();
      paramog.a((Bundle)localObject3);
      if ((paramog.a() != 5) && (paramog.a() != 27))
      {
        if (paramog.a() == 9)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_add_card_to_wx_card_list"), ((Bundle)localObject3).getString("_wxapi_basereq_transaction") }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 16)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[] { ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_app_id"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_location_id"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_sign_type"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_card_sign"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_time_stamp"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_nonce_str"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_card_id"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_card_type"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_can_multi_select"), ((Bundle)localObject3).getString("_wxapi_basereq_transaction") }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 11)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 12)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_jump_to_webview_url"), ((Bundle)localObject3).getString("_wxapi_basereq_transaction") }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        Object localObject4;
        Object localObject5;
        if (paramog.a() == 25)
        {
          localObject1 = this.a;
          d();
          localObject2 = (oo.a)paramog;
          localObject3 = ((Context)localObject1).getContentResolver();
          localObject4 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
          localObject1 = "";
          paramog = (og)localObject1;
          if (((oo.a)localObject2).c != null)
          {
            paramog = (og)localObject1;
            if (((oo.a)localObject2).c.size() > 0) {
              paramog = new JSONObject(((oo.a)localObject2).c).toString();
            }
          }
          localObject1 = this.b;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((oo.a)localObject2).d);
          paramog = ((ContentResolver)localObject3).query((Uri)localObject4, null, null, new String[] { localObject1, ((StringBuilder)localObject5).toString(), paramog }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 13)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_timeStamp"), ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_nonceStr"), ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_signType"), ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_signature"), ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_package") }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 14)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_basereq_transaction", ""), ((Bundle)localObject3).getString("_wxapi_create_chatroom_group_id", ""), ((Bundle)localObject3).getString("_wxapi_create_chatroom_chatroom_name", ""), ((Bundle)localObject3).getString("_wxapi_create_chatroom_chatroom_nickname", ""), ((Bundle)localObject3).getString("_wxapi_create_chatroom_ext_msg", ""), ((Bundle)localObject3).getString("_wxapi_basereq_openid", "") }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 15)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_basereq_transaction", ""), ((Bundle)localObject3).getString("_wxapi_join_chatroom_group_id", ""), ((Bundle)localObject3).getString("_wxapi_join_chatroom_chatroom_nickname", ""), ((Bundle)localObject3).getString("_wxapi_join_chatroom_ext_msg", ""), ((Bundle)localObject3).getString("_wxapi_basereq_openid", "") }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 17)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_scan_qrcode_result") }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 18)
        {
          localObject1 = this.a;
          d();
          paramog = (oh.a)paramog;
          paramog = ((Context)localObject1).getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.b, "1", String.valueOf(paramog.c), paramog.d, paramog.e }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        StringBuilder localStringBuilder;
        if (paramog.a() == 28)
        {
          localObject1 = this.a;
          paramog = (oq.a)paramog;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
          localObject3 = this.b;
          localObject4 = paramog.c;
          localObject5 = paramog.d;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramog.e);
          paramog = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { localObject3, localObject4, localObject5, localStringBuilder.toString(), paramog.f }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 29)
        {
          localObject1 = this.a;
          d();
          paramog = (ol.a)paramog;
          paramog = ((Context)localObject1).getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new String[] { this.b, paramog.c }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 23)
        {
          localObject1 = this.a;
          d();
          paramog = (oi.a)paramog;
          paramog = ((Context)localObject1).getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.b, "5", paramog.c }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 19)
        {
          localObject1 = this.a;
          d();
          paramog = (ok.a)paramog;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
          localObject3 = this.b;
          localObject4 = paramog.c;
          localObject5 = paramog.d;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramog.e);
          paramog = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { localObject3, localObject4, localObject5, localStringBuilder.toString(), paramog.f }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 26)
        {
          localObject1 = this.a;
          d();
          paramog = (on.a)paramog;
          paramog = ((Context)localObject1).getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[] { this.b, paramog.c, paramog.d, paramog.e, paramog.a }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 20)
        {
          localObject1 = this.a;
          d();
          paramog = (oj.a)paramog;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
          paramog = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramog.c) }));
          paramog = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { this.b, "2", paramog }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 21)
        {
          localObject1 = this.a;
          d();
          paramog = (om.a)paramog;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
          paramog = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramog.c) }));
          paramog = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { this.b, "3", paramog }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 22)
        {
          localObject1 = this.a;
          d();
          paramog = (op.a)paramog;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
          paramog = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramog.c) }));
          paramog = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { this.b, "4", paramog }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 24)
        {
          paramog = this.a;
          d();
          paramog = paramog.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[] { this.b }, null);
          if (paramog != null) {
            paramog.close();
          }
          return true;
        }
        if (paramog.a() == 2)
        {
          localObject4 = (or.a)paramog;
          int i = ((or.a)localObject4).c.a();
          if (pg.a(i))
          {
            if (b() < 620756993) {}
            for (localObject1 = new ov();; localObject1 = new ov())
            {
              ((ov)localObject1).a = ((Bundle)localObject3).getString("_wxminiprogram_webpageurl");
              ((or.a)localObject4).c.e = ((ot.b)localObject1);
              break label2233;
              if ((i != 46) || (b() >= 620953856)) {
                break;
              }
            }
            localObject5 = (ou)((or.a)localObject4).c.e;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(((ou)localObject5).b);
            ((StringBuilder)localObject1).append("@app");
            ((ou)localObject5).b = ((StringBuilder)localObject1).toString();
            localObject1 = ((ou)localObject5).c;
            if (!pg.a((String)localObject1))
            {
              localObject1 = ((String)localObject1).split("\\?");
              if (localObject1.length > 1)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(localObject1[0]);
                ((StringBuilder)localObject2).append(".html?");
                localObject1 = localObject1[1];
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(localObject1[0]);
                localObject1 = ".html";
              }
              ((StringBuilder)localObject2).append((String)localObject1);
              ((ou)localObject5).c = ((StringBuilder)localObject2).toString();
            }
            label2233:
            if (((or.a)localObject4).d != 3) {
              ((or.a)localObject4).d = 0;
            }
            paramog.a((Bundle)localObject3);
          }
        }
        localObject1 = new od.a();
        ((od.a)localObject1).f = ((Bundle)localObject3);
        localObject2 = new StringBuilder("weixin://sendreq?appid=");
        ((StringBuilder)localObject2).append(this.b);
        ((od.a)localObject1).c = ((StringBuilder)localObject2).toString();
        ((od.a)localObject1).a = "com.tencent.mm";
        ((od.a)localObject1).b = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
        if (paramog.a() != 2) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = this.a.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[] { this.b, "621086720" }, null);
        if ((localObject2 == null) || (!((Cursor)localObject2).moveToFirst())) {
          break label2460;
        }
        paramog = ((Cursor)localObject2).getString(0);
        "getTokenFromWX token is ".concat(String.valueOf(paramog));
        ((Cursor)localObject2).close();
        ((od.a)localObject1).d = paramog;
      }
      catch (Exception paramog)
      {
        new StringBuilder("getTokenFromWX fail, exception = ").append(paramog.getMessage());
      }
      return od.a(this.a, (od.a)localObject1);
      return a(this.a, (Bundle)localObject3);
      throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
      label2460:
      paramog = null;
    }
  }
  
  public final boolean a(String paramString)
  {
    if (!this.d)
    {
      if (!pb.a(this.a, "com.tencent.mm", this.c)) {
        return false;
      }
      "registerApp, appId = ".concat(String.valueOf(paramString));
      this.b = paramString;
      "registerApp, appId = ".concat(String.valueOf(paramString));
      this.b = paramString;
      new StringBuilder("register app ").append(this.a.getPackageName());
      Object localObject = new oe.a();
      ((oe.a)localObject).a = "com.tencent.mm";
      ((oe.a)localObject).b = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
      paramString = new StringBuilder("weixin://registerapp?appid=");
      paramString.append(this.b);
      ((oe.a)localObject).c = paramString.toString();
      ((oe.a)localObject).d = 0L;
      Context localContext = this.a;
      if (localContext == null) {
        return false;
      }
      if (pg.a(((oe.a)localObject).b)) {
        return false;
      }
      paramString = null;
      if (!pg.a(((oe.a)localObject).a))
      {
        paramString = new StringBuilder();
        paramString.append(((oe.a)localObject).a);
        paramString.append(".permission.MM_MESSAGE");
        paramString = paramString.toString();
      }
      Intent localIntent = new Intent(((oe.a)localObject).b);
      if (((oe.a)localObject).e != null) {
        localIntent.putExtras(((oe.a)localObject).e);
      }
      String str = localContext.getPackageName();
      localIntent.putExtra("_mmessage_sdkVersion", 621086720);
      localIntent.putExtra("_mmessage_appPackage", str);
      localIntent.putExtra("_mmessage_content", ((oe.a)localObject).c);
      localIntent.putExtra("_mmessage_support_content_type", ((oe.a)localObject).d);
      localIntent.putExtra("_mmessage_checksum", of.a(((oe.a)localObject).c, str));
      localContext.sendBroadcast(localIntent, paramString);
      localObject = new StringBuilder("send mm message, intent=");
      ((StringBuilder)localObject).append(localIntent);
      ((StringBuilder)localObject).append(", perm=");
      ((StringBuilder)localObject).append(paramString);
      return true;
    }
    throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
  }
  
  public final int b()
  {
    if (!this.d)
    {
      if (!a()) {
        return 0;
      }
      this.e = 0;
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      pg.b.submit(new ox(this, localCountDownLatch));
      try
      {
        localCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.getMessage();
      }
      new StringBuilder("wxSdkVersion = ").append(this.e);
      if (this.e == 0) {
        try
        {
          this.e = this.a.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
          new StringBuilder("OPEN_SDK_VERSION = ").append(this.e);
        }
        catch (Exception localException)
        {
          new StringBuilder("get from metaData failed : ").append(localException.getMessage());
        }
      }
      return this.e;
    }
    throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ow
 * JD-Core Version:    0.7.0.1
 */