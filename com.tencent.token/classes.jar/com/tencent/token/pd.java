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

class pd
  implements pf
{
  private static String f;
  protected Context a;
  protected String b;
  protected boolean c = false;
  protected boolean d = false;
  private int e;
  
  pd(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("<init>, appId = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", checkSignature = true");
    this.a = paramContext;
    this.b = paramString;
    this.c = true;
    pn.a = paramContext.getApplicationContext();
  }
  
  private static boolean a(Context paramContext, Bundle paramBundle)
  {
    if (f == null)
    {
      f = new pg(paramContext).getString("_wxapp_pay_entry_classname_", null);
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
    ok.a locala = new ok.a();
    locala.f = paramBundle;
    locala.a = "com.tencent.mm";
    locala.b = f;
    return ok.a(paramContext, locala);
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
      boolean bool = pi.a(localPackageInfo.signatures, this.c);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
    return false;
  }
  
  public final boolean a(on paramon)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (!this.d)
    {
      if (!pi.a(this.a, "com.tencent.mm", this.c)) {
        return false;
      }
      if (!paramon.b()) {
        return false;
      }
      new StringBuilder("sendReq, req type = ").append(paramon.a());
      localObject3 = new Bundle();
      paramon.a((Bundle)localObject3);
      if ((paramon.a() != 5) && (paramon.a() != 27))
      {
        if (paramon.a() == 9)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_add_card_to_wx_card_list"), ((Bundle)localObject3).getString("_wxapi_basereq_transaction") }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 16)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[] { ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_app_id"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_location_id"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_sign_type"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_card_sign"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_time_stamp"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_nonce_str"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_card_id"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_card_type"), ((Bundle)localObject3).getString("_wxapi_choose_card_from_wx_card_can_multi_select"), ((Bundle)localObject3).getString("_wxapi_basereq_transaction") }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 11)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 12)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_jump_to_webview_url"), ((Bundle)localObject3).getString("_wxapi_basereq_transaction") }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        Object localObject4;
        Object localObject5;
        if (paramon.a() == 25)
        {
          localObject1 = this.a;
          d();
          localObject2 = (ov.a)paramon;
          localObject3 = ((Context)localObject1).getContentResolver();
          localObject4 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
          localObject1 = "";
          paramon = (on)localObject1;
          if (((ov.a)localObject2).c != null)
          {
            paramon = (on)localObject1;
            if (((ov.a)localObject2).c.size() > 0) {
              paramon = new JSONObject(((ov.a)localObject2).c).toString();
            }
          }
          localObject1 = this.b;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((ov.a)localObject2).d);
          paramon = ((ContentResolver)localObject3).query((Uri)localObject4, null, null, new String[] { localObject1, ((StringBuilder)localObject5).toString(), paramon }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 13)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_timeStamp"), ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_nonceStr"), ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_signType"), ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_signature"), ((Bundle)localObject3).getString("_wxapi_open_busi_lucky_money_package") }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 14)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_basereq_transaction", ""), ((Bundle)localObject3).getString("_wxapi_create_chatroom_group_id", ""), ((Bundle)localObject3).getString("_wxapi_create_chatroom_chatroom_name", ""), ((Bundle)localObject3).getString("_wxapi_create_chatroom_chatroom_nickname", ""), ((Bundle)localObject3).getString("_wxapi_create_chatroom_ext_msg", ""), ((Bundle)localObject3).getString("_wxapi_basereq_openid", "") }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 15)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_basereq_transaction", ""), ((Bundle)localObject3).getString("_wxapi_join_chatroom_group_id", ""), ((Bundle)localObject3).getString("_wxapi_join_chatroom_chatroom_nickname", ""), ((Bundle)localObject3).getString("_wxapi_join_chatroom_ext_msg", ""), ((Bundle)localObject3).getString("_wxapi_basereq_openid", "") }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 17)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[] { this.b, ((Bundle)localObject3).getString("_wxapi_scan_qrcode_result") }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 18)
        {
          localObject1 = this.a;
          d();
          paramon = (oo.a)paramon;
          paramon = ((Context)localObject1).getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.b, "1", String.valueOf(paramon.c), paramon.d, paramon.e }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        StringBuilder localStringBuilder;
        if (paramon.a() == 28)
        {
          localObject1 = this.a;
          paramon = (ox.a)paramon;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
          localObject3 = this.b;
          localObject4 = paramon.c;
          localObject5 = paramon.d;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramon.e);
          paramon = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { localObject3, localObject4, localObject5, localStringBuilder.toString(), paramon.f }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 29)
        {
          localObject1 = this.a;
          d();
          paramon = (os.a)paramon;
          paramon = ((Context)localObject1).getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new String[] { this.b, paramon.c }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 23)
        {
          localObject1 = this.a;
          d();
          paramon = (op.a)paramon;
          paramon = ((Context)localObject1).getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.b, "5", paramon.c }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 19)
        {
          localObject1 = this.a;
          d();
          paramon = (or.a)paramon;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
          localObject3 = this.b;
          localObject4 = paramon.c;
          localObject5 = paramon.d;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramon.e);
          paramon = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { localObject3, localObject4, localObject5, localStringBuilder.toString(), paramon.f }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 26)
        {
          localObject1 = this.a;
          d();
          paramon = (ou.a)paramon;
          paramon = ((Context)localObject1).getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[] { this.b, paramon.c, paramon.d, paramon.e, paramon.a }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 20)
        {
          localObject1 = this.a;
          d();
          paramon = (oq.a)paramon;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
          paramon = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramon.c) }));
          paramon = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { this.b, "2", paramon }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 21)
        {
          localObject1 = this.a;
          d();
          paramon = (ot.a)paramon;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
          paramon = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramon.c) }));
          paramon = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { this.b, "3", paramon }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 22)
        {
          localObject1 = this.a;
          d();
          paramon = (ow.a)paramon;
          localObject1 = ((Context)localObject1).getContentResolver();
          localObject2 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
          paramon = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramon.c) }));
          paramon = ((ContentResolver)localObject1).query((Uri)localObject2, null, null, new String[] { this.b, "4", paramon }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 24)
        {
          paramon = this.a;
          d();
          paramon = paramon.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[] { this.b }, null);
          if (paramon != null) {
            paramon.close();
          }
          return true;
        }
        if (paramon.a() == 2)
        {
          localObject4 = (oy.a)paramon;
          int i = ((oy.a)localObject4).c.a();
          if (pn.a(i))
          {
            if (b() < 620756993) {}
            for (localObject1 = new pc();; localObject1 = new pc())
            {
              ((pc)localObject1).a = ((Bundle)localObject3).getString("_wxminiprogram_webpageurl");
              ((oy.a)localObject4).c.e = ((pa.b)localObject1);
              break label2233;
              if ((i != 46) || (b() >= 620953856)) {
                break;
              }
            }
            localObject5 = (pb)((oy.a)localObject4).c.e;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(((pb)localObject5).b);
            ((StringBuilder)localObject1).append("@app");
            ((pb)localObject5).b = ((StringBuilder)localObject1).toString();
            localObject1 = ((pb)localObject5).c;
            if (!pn.a((String)localObject1))
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
              ((pb)localObject5).c = ((StringBuilder)localObject2).toString();
            }
            label2233:
            if (((oy.a)localObject4).d != 3) {
              ((oy.a)localObject4).d = 0;
            }
            paramon.a((Bundle)localObject3);
          }
        }
        localObject1 = new ok.a();
        ((ok.a)localObject1).f = ((Bundle)localObject3);
        localObject2 = new StringBuilder("weixin://sendreq?appid=");
        ((StringBuilder)localObject2).append(this.b);
        ((ok.a)localObject1).c = ((StringBuilder)localObject2).toString();
        ((ok.a)localObject1).a = "com.tencent.mm";
        ((ok.a)localObject1).b = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
        if (paramon.a() != 2) {}
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
        paramon = ((Cursor)localObject2).getString(0);
        "getTokenFromWX token is ".concat(String.valueOf(paramon));
        ((Cursor)localObject2).close();
        ((ok.a)localObject1).d = paramon;
      }
      catch (Exception paramon)
      {
        new StringBuilder("getTokenFromWX fail, exception = ").append(paramon.getMessage());
      }
      return ok.a(this.a, (ok.a)localObject1);
      return a(this.a, (Bundle)localObject3);
      throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
      label2460:
      paramon = null;
    }
  }
  
  public final boolean a(String paramString)
  {
    if (!this.d)
    {
      if (!pi.a(this.a, "com.tencent.mm", this.c)) {
        return false;
      }
      "registerApp, appId = ".concat(String.valueOf(paramString));
      this.b = paramString;
      "registerApp, appId = ".concat(String.valueOf(paramString));
      this.b = paramString;
      new StringBuilder("register app ").append(this.a.getPackageName());
      Object localObject = new ol.a();
      ((ol.a)localObject).a = "com.tencent.mm";
      ((ol.a)localObject).b = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
      paramString = new StringBuilder("weixin://registerapp?appid=");
      paramString.append(this.b);
      ((ol.a)localObject).c = paramString.toString();
      ((ol.a)localObject).d = 0L;
      Context localContext = this.a;
      if (localContext == null) {
        return false;
      }
      if (pn.a(((ol.a)localObject).b)) {
        return false;
      }
      paramString = null;
      if (!pn.a(((ol.a)localObject).a))
      {
        paramString = new StringBuilder();
        paramString.append(((ol.a)localObject).a);
        paramString.append(".permission.MM_MESSAGE");
        paramString = paramString.toString();
      }
      Intent localIntent = new Intent(((ol.a)localObject).b);
      if (((ol.a)localObject).e != null) {
        localIntent.putExtras(((ol.a)localObject).e);
      }
      String str = localContext.getPackageName();
      localIntent.putExtra("_mmessage_sdkVersion", 621086720);
      localIntent.putExtra("_mmessage_appPackage", str);
      localIntent.putExtra("_mmessage_content", ((ol.a)localObject).c);
      localIntent.putExtra("_mmessage_support_content_type", ((ol.a)localObject).d);
      localIntent.putExtra("_mmessage_checksum", om.a(((ol.a)localObject).c, str));
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
      pn.b.submit(new pe(this, localCountDownLatch));
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
 * Qualified Name:     com.tencent.token.pd
 * JD-Core Version:    0.7.0.1
 */