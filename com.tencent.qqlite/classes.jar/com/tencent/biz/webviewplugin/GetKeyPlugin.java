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
    Object localObject5 = this.mRuntime.a().getIntent();
    if (((Intent)localObject5).getBooleanExtra("ignoreLoginWeb", false)) {
      return false;
    }
    localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    localObject3 = "0";
    Object localObject1 = localObject3;
    if (localAppInterface != null)
    {
      localObject1 = localObject3;
      if (localAppInterface.isLogin())
      {
        localObject1 = localAppInterface.getAccount();
        if (((String)localObject1).length() >= 10) {
          break label229;
        }
        localObject3 = new StringBuilder("o");
        i = ((String)localObject1).length();
        while (i < 10)
        {
          ((StringBuilder)localObject3).append("0");
          i += 1;
        }
      }
    }
    label229:
    for (localObject1 = (String)localObject1;; localObject1 = "o" + (String)localObject1)
    {
      localCookieManager.setCookie("http://ptlogin2.qq.com/", String.format("superuin=%s; PATH=/; DOMAIN=ptlogin2.qq.com;", new Object[] { localObject1 }));
      localObject3 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      j = localObject3.length;
      i = 0;
      while (i < j)
      {
        str = localObject3[i];
        localCookieManager.setCookie(String.format("http://www.%s/", new Object[] { str }), String.format("uin=%1$s; domain=%2$s; path=/", new Object[] { localObject1, str }));
        i += 1;
      }
    }
    localObject3 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b();
    int j = localObject3.length;
    i = 0;
    while (i < j)
    {
      str = localObject3[i];
      localCookieManager.setCookie(String.format("http://%s/", new Object[] { str }), String.format("p_uin=%1$s; PATH=/; DOMAIN=%2$s;", new Object[] { localObject1, str }));
      i += 1;
    }
    boolean bool2;
    if ((localAppInterface != null) && (localAppInterface.isLogin()))
    {
      if (paramString.startsWith("file:"))
      {
        bool1 = true;
        bool2 = false;
        str = "";
        localObject3 = "qq.com";
        j = 0;
        localObject4 = "";
      }
      for (;;)
      {
        if (!((Intent)localObject5).getBooleanExtra("avoidLoginWeb", false)) {
          break label675;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c();
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject4 = localObject1[i];
            localCookieManager.setCookie(String.format("http://www.%s/", new Object[] { localObject4 }), String.format("skey=; domain=%s; path=/", new Object[] { localObject4 }));
            i += 1;
            continue;
            localObject1 = Uri.parse(paramString);
            localObject3 = null;
            if (localObject1 != null) {}
            try
            {
              for (localObject1 = ((Uri)localObject1).getQueryParameter("refer");; localObject1 = null)
              {
                if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!"Qzone".equals(localObject1))) {
                  break label581;
                }
                localObject1 = "";
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label594;
                }
                i = 1;
                localObject3 = Util.c(paramString);
                str = Util.d(paramString);
                bool2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(str);
                bool1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString);
                j = i;
                localObject4 = localObject1;
                break;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                localException1.printStackTrace();
                localObject2 = localObject3;
                if (QLog.isColorLevel())
                {
                  QLog.d(this.TAG, 2, "GetKeyPluin: invalid refer");
                  localObject2 = localObject3;
                  continue;
                  label581:
                  localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString);
                  continue;
                  label594:
                  i = 0;
                }
              }
            }
          }
        }
      }
      localCookieManager.setCookie("http://ptlogin2.qq.com/", "superkey=; PATH=/; DOMAIN=ptlogin2.qq.com; HttpOnly;");
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(str)) {
        localCookieManager.setCookie(paramString, String.format("p_skey=; PATH=/; DOMAIN=%s;", new Object[] { Util.d(paramString) }));
      }
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString)) {
        localCookieManager.setCookie(paramString, String.format("vkey=; domain=%s; path=/", new Object[] { localObject3 }));
      }
    }
    return false;
    label675:
    i = 0;
    try
    {
      localObject5 = Uri.parse(paramString).getQueryParameter("_bid");
      localObject2 = localObject5;
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(paramString);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        i = Integer.parseInt((String)localObject2);
      }
      k = i;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        long l1;
        localException2.printStackTrace();
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
          paramString = localException2;
          if (localCookieManager.getCookie(localException2).contains("p_skey=")) {
            continue;
          }
          paramString = localException2;
          if (TextUtils.isEmpty(this.f)) {
            continue;
          }
          str = localAppInterface.getAccount();
          localObject4 = this.f;
          if (localException2.startsWith("http://s.p.qq.com")) {}
          for (paramString = "1";; paramString = "0")
          {
            paramString = String.format("http://ptlogin2.qq.com/jump?clientuin=%1$s&clientkey=%2$s&keyindex=19&pt_mq=%3$s&u1=%4$s", new Object[] { str, localObject4, paramString, URLEncoder.encode(localException2) });
            break;
          }
          if ((bool1) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
            localCookieManager.setCookie(String.format("http://www.%s/", new Object[] { localObject3 }), String.format("vkey=%1$s; domain=%2$s; path=/", new Object[] { this.jdField_b_of_type_JavaLangString, localObject3 }));
          }
          CookieSyncManager.getInstance().sync();
          if ((this.mRuntime.a() instanceof QQBrowserActivity)) {
            ((QQBrowserActivity)this.mRuntime.a()).K = paramString;
          }
          return false;
        }
      }
    }
    l1 = System.currentTimeMillis();
    Object localObject2 = (TicketManager)localAppInterface.getManager(2);
    localObject5 = localAppInterface.getAccount();
    this.jdField_a_of_type_JavaLangString = ((TicketManager)localObject2).getSid((String)localObject5);
    this.jdField_b_of_type_JavaLangString = ((TicketManager)localObject2).getVkey((String)localObject5);
    this.jdField_c_of_type_JavaLangString = ((TicketManager)localObject2).getSkey((String)localObject5);
    this.e = ((TicketManager)localObject2).getSuperkey((String)localObject5);
    this.f = ((TicketManager)localObject2).getStweb((String)localObject5);
    if (bool2) {
      this.jdField_d_of_type_JavaLangString = ((TicketManager)localObject2).getPskey((String)localObject5, str);
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
      localObject2 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject2).update(this.e.getBytes());
      localObject2 = ((MessageDigest)localObject2).digest();
      i = localObject2.length;
      l1 = localObject2[(i - 4)] & 0xFF;
      long l2 = (localObject2[(i - 3)] & 0xFF) << 16;
      long l3 = (localObject2[(i - 2)] & 0xFF) << 8;
      this.g = Long.toString(localObject2[(i - 1)] & 0xFF | l1 << 24 | l2 | l3);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      label1089:
      break label1089;
      i = 0;
    }
    localObject2 = paramString;
    if (j != 0) {
      localObject2 = Uri.parse(paramString.replaceAll("(?<=\\?|#|&)(sid|3g_sid)=[^&#]*&", "").replaceAll("[\\?#&](sid|3g_sid)=[^&#]*(?=#|$)", "")).buildUpon().appendQueryParameter((String)localObject4, this.jdField_a_of_type_JavaLangString).toString();
    }
    if (!TextUtils.isEmpty(this.e))
    {
      localCookieManager.setCookie("http://ptlogin2.qq.com/", String.format("superkey=%s; PATH=/; DOMAIN=ptlogin2.qq.com; HttpOnly;", new Object[] { this.e }));
      localCookieManager.setCookie("http://ptlogin2.qq.com/", String.format("supertoken=%s; PATH=/; DOMAIN=ptlogin2.qq.com;", new Object[] { this.g }));
    }
    paramString = (String)localObject2;
    if (bool2)
    {
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        localCookieManager.setCookie((String)localObject2, String.format("p_skey=%1$s; PATH=/; DOMAIN=%2$s;", new Object[] { this.jdField_d_of_type_JavaLangString, str }));
        paramString = (String)localObject2;
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label1487;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        str = localObject2[i];
        localCookieManager.setCookie(String.format("http://www.%s/", new Object[] { str }), String.format("skey=%1$s; domain=%2$s; path=/", new Object[] { this.jdField_c_of_type_JavaLangString, str }));
        i += 1;
      }
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 21) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.GetKeyPlugin
 * JD-Core Version:    0.7.0.1
 */