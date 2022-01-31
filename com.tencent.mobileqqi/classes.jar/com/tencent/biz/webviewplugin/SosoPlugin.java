package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import bvi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider.SosoSrvAddrType;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SosoPlugin
  extends WebViewPlugin
{
  public static final int a = 0;
  public static final String a = "http://htdata.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080";
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { "http://htdata.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080", "http://htdata2.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080" };
  public static final int b = 1;
  public static final String b = "http://htdata2.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080";
  public static final String c = "/cgi-bin/httpconn?htcmd=0x6ff0080";
  public static final String d = "#__SOSO_RAW_URL___";
  public static final String e = "key_isReadModeEnabled";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  SosoSrvAddrProvider jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  protected boolean a;
  boolean b = true;
  private int c = 1;
  private int d = this.c;
  private int e = -1;
  
  public SosoPlugin()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bvi(this);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "registerReceiver soso receiver");
      }
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.receiver.soso"));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, "registerReceiver soso receiver error", localException);
    }
  }
  
  private String b(String paramString)
  {
    String str;
    if (this.c == 1)
    {
      str = paramString;
      if (this.b) {
        str = a(this.mRuntime.a().getIntent(), paramString, SosoSrvAddrProvider.a());
      }
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"));
      str = paramString;
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "VIEW_MODE_SYSTEM_BROWSER_MODE! url is not original!");
    return paramString;
  }
  
  private void b()
  {
    if (this.c == 1)
    {
      this.d = this.c;
      this.c = 0;
      return;
    }
    this.d = this.c;
    this.c = 1;
  }
  
  String a(Intent paramIntent, String paramString, SosoSrvAddrProvider paramSosoSrvAddrProvider)
  {
    if ((paramString.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) || (paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      return paramString;
    }
    Object localObject1 = paramString;
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        str = jdField_a_of_type_ArrayOfJavaLangString[new java.util.Random().nextInt(2)];
        localObject1 = paramString;
        Object localObject2 = paramSosoSrvAddrProvider.a(SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV);
        paramSosoSrvAddrProvider = str;
        if (localObject2 != null)
        {
          paramSosoSrvAddrProvider = str;
          localObject1 = paramString;
          if (((String)localObject2).length() > 0)
          {
            localObject1 = paramString;
            str = str.replaceFirst("http://[^/\\s]*/", (String)localObject2);
            paramSosoSrvAddrProvider = str;
            localObject1 = paramString;
            if (QLog.isColorLevel())
            {
              localObject1 = paramString;
              QLog.d(this.TAG, 2, "replaceDomainWithIp: " + str);
              paramSosoSrvAddrProvider = str;
            }
          }
        }
        localObject1 = paramString;
        localStringBuilder = new StringBuilder();
        localObject1 = paramString;
        localStringBuilder.append(paramSosoSrvAddrProvider);
        localObject1 = paramString;
        localStringBuilder.append("&u=");
        localObject1 = paramString;
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
        localObject1 = paramString;
        localStringBuilder.append("&wap=3");
        localObject1 = paramString;
        switch (paramIntent.getExtras().getInt("curtype"))
        {
        case 0: 
          localObject1 = paramString;
          localStringBuilder.append("&qq-pf-to=mqq.temporaryc2c");
          localObject1 = paramString;
          paramSosoSrvAddrProvider = paramIntent.getStringExtra("uin");
          localObject1 = paramString;
          if (!TextUtils.isEmpty(paramSosoSrvAddrProvider))
          {
            localObject1 = paramString;
            localStringBuilder.append("&uin=").append(paramSosoSrvAddrProvider);
          }
          localObject1 = paramString;
          paramIntent = paramIntent.getStringExtra("friendUin");
          localObject1 = paramString;
          if (!TextUtils.isEmpty(paramIntent))
          {
            localObject1 = paramString;
            localStringBuilder.append("&originuin=").append(paramIntent);
          }
          paramSosoSrvAddrProvider = paramString;
          if (paramString != null)
          {
            localObject1 = paramString;
            if (!paramString.startsWith("http://"))
            {
              paramSosoSrvAddrProvider = paramString;
              localObject1 = paramString;
              if (!paramString.startsWith("https://")) {}
            }
            else
            {
              localObject1 = paramString;
            }
          }
          switch (LocaleUtil.a(BaseApplicationImpl.getContext()))
          {
          default: 
            localObject1 = paramString;
            if (!paramString.matches("^[^#]*\\?.*(#.*)?")) {
              break label578;
            }
            str = "&";
            localObject1 = paramString;
            localObject2 = Pattern.compile("(#.*)?$").matcher(paramString);
            paramSosoSrvAddrProvider = paramString;
            localObject1 = paramString;
            if (((Matcher)localObject2).find())
            {
              localObject1 = paramString;
              localObject2 = ((Matcher)localObject2).group(1);
              paramSosoSrvAddrProvider = (SosoSrvAddrProvider)localObject2;
              if (localObject2 == null) {
                paramSosoSrvAddrProvider = "";
              }
              localObject1 = paramString;
              paramSosoSrvAddrProvider = paramString.replaceAll("(#.*)?$", str + "lan=" + paramIntent + paramSosoSrvAddrProvider);
            }
            localObject1 = paramSosoSrvAddrProvider;
            return localStringBuilder.toString();
          }
          break;
        }
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        paramIntent.printStackTrace();
        return localObject1;
      }
      localObject1 = paramString;
      localStringBuilder.append("&qq-pf-to=mqq.c2c");
      continue;
      localObject1 = paramString;
      localStringBuilder.append("&qq-pf-to=mqq.group");
      continue;
      localObject1 = paramString;
      localStringBuilder.append("&qq-pf-to=mqq.discussion");
      continue;
      label578:
      String str = "?";
      continue;
      continue;
      paramIntent = "en";
      continue;
      paramIntent = "en";
      continue;
      paramIntent = "ja";
      continue;
      paramIntent = "ko";
      continue;
      paramIntent = "de";
      continue;
      paramIntent = "fr";
      continue;
      paramIntent = "es";
      continue;
      paramIntent = "tw";
      continue;
      paramIntent = "cn";
    }
  }
  
  String a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return paramString;
    }
    if (this.c == 1)
    {
      String str;
      if (paramString.indexOf("#__SOSO_RAW_URL___") == -1) {
        str = b(paramString);
      }
      for (;;)
      {
        paramString = str;
        if (this.d != 0) {
          break;
        }
        this.e = -1;
        return str;
        this.d = this.c;
        this.c = 0;
        this.e = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
        str = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d(this.TAG, 2, "anchorIndex org " + this.e);
          str = paramString;
        }
      }
    }
    this.d = this.c;
    this.c = 0;
    return paramString;
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 12)
    {
      paramInt = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
      if (this.e == paramInt - 1)
      {
        b();
        this.e = paramInt;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "anchorIndex back " + this.e);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (paramInt == 1)
          {
            this.b = true;
            return false;
          }
          if (paramInt == 2)
          {
            this.b = true;
            SosoSrvAddrProvider.a().a(SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV, paramString);
            return false;
          }
          if (paramInt == 0)
          {
            this.b = false;
            return false;
          }
        } while (paramInt != 13);
        paramInt = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
      } while (this.e != paramInt + 1);
      b();
      this.e = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "anchorIndex forward " + this.e);
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (("http".equals(paramString2)) || ("https".equals(paramString2)))
    {
      paramString2 = a(paramString1);
      if (!paramString1.equalsIgnoreCase(paramString2))
      {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString2);
        return true;
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
    this.jdField_a_of_type_Boolean = this.mRuntime.a().getIntent().getBooleanExtra("key_isReadModeEnabled", false);
    a();
    SosoSrvAddrProvider.a().c();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "unregisterReceiver sosoReceiver");
      }
      this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SosoPlugin
 * JD-Core Version:    0.7.0.1
 */