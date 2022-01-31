package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class GetKeyPlugin
  extends WebViewPlugin
{
  protected final int a;
  protected AuthorizeConfig a;
  protected String a;
  protected Thread a;
  protected final int b;
  protected String b;
  protected final int c;
  protected String c;
  protected final int d;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  public GetKeyPlugin()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 3;
  }
  
  private boolean a(String paramString)
  {
    localAppInterface = this.mRuntime.a();
    Object localObject3 = this.mRuntime.a().getIntent();
    localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    Object localObject2 = "0";
    Object localObject1 = localObject2;
    if (localAppInterface != null)
    {
      localObject1 = localObject2;
      if (localAppInterface.isLogin())
      {
        localObject1 = localAppInterface.getAccount();
        if (((String)localObject1).length() >= 10) {
          break label216;
        }
        localObject2 = new StringBuilder("o");
        i = ((String)localObject1).length();
        while (i < 10)
        {
          ((StringBuilder)localObject2).append("0");
          i += 1;
        }
      }
    }
    label216:
    for (localObject1 = (String)localObject1;; localObject1 = "o" + (String)localObject1)
    {
      localCookieManager.setCookie("http://ptlogin2.qq.com/", String.format("superuin=%s; PATH=/; DOMAIN=ptlogin2.qq.com;", new Object[] { localObject1 }));
      localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        str1 = localObject2[i];
        localCookieManager.setCookie(String.format("http://www.%s/", new Object[] { str1 }), String.format("uin=%1$s; domain=%2$s; path=/", new Object[] { localObject1, str1 }));
        i += 1;
      }
    }
    localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b();
    int j = localObject2.length;
    i = 0;
    while (i < j)
    {
      str1 = localObject2[i];
      localCookieManager.setCookie(String.format("http://%s/", new Object[] { str1 }), String.format("p_uin=%1$s; PATH=/; DOMAIN=%2$s;", new Object[] { localObject1, str1 }));
      i += 1;
    }
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if ((localAppInterface != null) && (localAppInterface.isLogin()))
    {
      if (!paramString.startsWith("file:")) {
        break label475;
      }
      bool1 = true;
      bool2 = false;
      str1 = "";
      localObject2 = "qq.com";
      bool3 = true;
      j = 0;
      str2 = "";
      if (!((Intent)localObject3).getBooleanExtra("avoidLoginWeb", false)) {
        break label548;
      }
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString)) {
        localCookieManager.setCookie(paramString, String.format("skey=; domain=%s; path=/", new Object[] { localObject2 }));
      }
      localCookieManager.setCookie("http://ptlogin2.qq.com/", "superkey=; PATH=/; DOMAIN=ptlogin2.qq.com; HttpOnly;");
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(str1)) {
        localCookieManager.setCookie(paramString, String.format("p_skey=; PATH=/; DOMAIN=%s;", new Object[] { Util.d(paramString) }));
      }
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString)) {
        localCookieManager.setCookie(paramString, String.format("vkey=; domain=%s; path=/", new Object[] { localObject2 }));
      }
    }
    label475:
    while ((j == 0) && (!bool3) && (!bool1) && (!bool2))
    {
      return false;
      str2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString);
      if (!TextUtils.isEmpty(str2)) {}
      for (i = 1;; i = 0)
      {
        bool3 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString);
        localObject2 = Util.c(paramString);
        str1 = Util.d(paramString);
        bool2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(str1);
        bool1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString);
        j = i;
        break;
      }
    }
    label548:
    i = 0;
    try
    {
      localObject3 = Uri.parse(paramString).getQueryParameter("_bid");
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(paramString);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i = Integer.parseInt((String)localObject1);
      }
      k = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1;
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "GetKeyPluin: invalid bid");
        }
        int k = 0;
        continue;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          i = 1;
        }
        else if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          i = 2;
          continue;
          paramString = localException;
          if (localCookieManager.getCookie(localException).contains("p_skey=")) {
            continue;
          }
          paramString = localException;
          if (TextUtils.isEmpty(this.f)) {
            continue;
          }
          str1 = localAppInterface.getAccount();
          str2 = this.f;
          if (localException.startsWith("http://s.p.qq.com")) {}
          for (paramString = "1";; paramString = "0")
          {
            paramString = String.format("http://ptlogin2.qq.com/jump?clientuin=%1$s&clientkey=%2$s&keyindex=19&pt_mq=%3$s&u1=%4$s", new Object[] { str1, str2, paramString, URLEncoder.encode(localException) });
            break;
          }
        }
      }
    }
    l1 = System.currentTimeMillis();
    localObject1 = (TicketManager)localAppInterface.getManager(2);
    localObject3 = localAppInterface.getAccount();
    this.jdField_a_of_type_JavaLangString = ((TicketManager)localObject1).getSid((String)localObject3);
    this.jdField_b_of_type_JavaLangString = ((TicketManager)localObject1).getVkey((String)localObject3);
    this.jdField_c_of_type_JavaLangString = ((TicketManager)localObject1).getSkey((String)localObject3);
    this.e = ((TicketManager)localObject1).getSuperkey((String)localObject3);
    this.f = ((TicketManager)localObject1).getStweb((String)localObject3);
    if (bool2) {
      this.jdField_d_of_type_JavaLangString = ((TicketManager)localObject1).getPskey((String)localObject3, str1);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      i = 3;
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", "get_key_finish", OfflineDownloader.a(localAppInterface.getApplication()), 1, (int)(System.currentTimeMillis() - l1), "", "" + k, "" + i, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.TAG, 4, "getkey time:" + (System.currentTimeMillis() - l1));
      }
      if (TextUtils.isEmpty(this.e)) {}
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject1).update(this.e.getBytes());
      localObject1 = ((MessageDigest)localObject1).digest();
      i = localObject1.length;
      l1 = localObject1[(i - 4)] & 0xFF;
      long l2 = (localObject1[(i - 3)] & 0xFF) << 16;
      long l3 = (localObject1[(i - 2)] & 0xFF) << 8;
      this.g = Long.toString(localObject1[(i - 1)] & 0xFF | l1 << 24 | l2 | l3);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      label977:
      break label977;
      i = 0;
    }
    localObject1 = paramString;
    if (j != 0) {
      localObject1 = Uri.parse(paramString.replaceAll("(?<=\\?|#|&)(sid|3g_sid)=[^&#]*&", "").replaceAll("[\\?#&](sid|3g_sid)=[^&#]*(?=#|$)", "")).buildUpon().appendQueryParameter(str2, this.jdField_a_of_type_JavaLangString).toString();
    }
    localCookieManager.setAcceptCookie(true);
    if (((bool3) || (bool2)) && (!TextUtils.isEmpty(this.e)))
    {
      localCookieManager.setCookie("http://ptlogin2.qq.com/", String.format("superkey=%s; PATH=/; DOMAIN=ptlogin2.qq.com; HttpOnly;", new Object[] { this.e }));
      localCookieManager.setCookie("http://ptlogin2.qq.com/", String.format("supertoken=%s; PATH=/; DOMAIN=ptlogin2.qq.com;", new Object[] { this.g }));
    }
    paramString = (String)localObject1;
    if (bool2)
    {
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        localCookieManager.setCookie((String)localObject1, String.format("p_skey=%1$s; PATH=/; DOMAIN=%2$s;", new Object[] { this.jdField_d_of_type_JavaLangString, str1 }));
        paramString = (String)localObject1;
      }
    }
    else
    {
      if ((bool3) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        localCookieManager.setCookie(String.format("http://www.%s/", new Object[] { localObject2 }), String.format("skey=%1$s; domain=%2$s; path=/", new Object[] { this.jdField_c_of_type_JavaLangString, localObject2 }));
      }
      if ((bool1) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        localCookieManager.setCookie(String.format("http://www.%s/", new Object[] { localObject2 }), String.format("vkey=%1$s; domain=%2$s; path=/", new Object[] { this.jdField_b_of_type_JavaLangString, localObject2 }));
      }
      CookieSyncManager.getInstance().sync();
      ((QQBrowserActivity)this.mRuntime.a()).I = paramString;
      return false;
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == WebViewPlugin.EVENT_BEFORE_LOAD) {
      return a(paramString);
    }
    return false;
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.isAlive())) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.GetKeyPlugin
 * JD-Core Version:    0.7.0.1
 */