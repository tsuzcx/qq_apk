package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mtt.spcialcall.sdk.MttApi;
import com.tencent.mtt.spcialcall.sdk.MttLoader;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;

public class WebViewJumpPlugin
  extends WebViewPlugin
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private void a(Intent paramIntent)
  {
    this.mRuntime.a().startActivity(paramIntent);
  }
  
  private void a(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    do
    {
      return;
      ((Activity)localObject).finish();
      if (QRUtils.c(paramString))
      {
        localObject = new Intent((Context)localObject, JoinDiscussionActivity.class);
        ((Intent)localObject).putExtra("innerSig", paramString);
        a((Intent)localObject);
        return;
      }
      paramString = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject, paramString);
    } while (paramString == null);
    paramString.b();
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      HashMap localHashMap = new HashMap();
      localHashMap.put("KEY_PID", String.valueOf(50079));
      localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
      paramString = MttLoader.a(this.mRuntime.a(), paramString);
      int i = MttApi.a(this.mRuntime.a(), paramString, localHashMap);
      if (paramBoolean)
      {
        if (4 != i) {
          break label93;
        }
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
      }
      while (i == 0)
      {
        return true;
        label93:
        if (5 == i) {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
        } else if (i != 0) {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
        }
      }
    }
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (("".equals(paramString1)) || ("about:blank;".equals(paramString1)) || ("about:blank".equals(paramString1))) {}
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              return true;
              if (paramString1.startsWith("tel:"))
              {
                paramString1 = new Intent("android.intent.action.DIAL", Uri.parse(paramString1));
                if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
                  KapalaiAdapterUtil.a().a(paramString1);
                }
                a(paramString1);
                return true;
              }
              if (paramString1.startsWith("sms:"))
              {
                paramString2 = new Intent("android.intent.action.VIEW");
                int j = paramString1.indexOf("?");
                i = j;
                if (j == -1) {
                  i = paramString1.length();
                }
                paramString2.putExtra("address", paramString1.substring(paramString1.indexOf(":") + 1, i));
                j = paramString1.indexOf("=");
                i = j;
                if (j == -1) {
                  i = paramString1.length() - 1;
                }
                paramString2.putExtra("sms_body", paramString1.substring(i + 1, paramString1.length()));
                paramString2.setType("vnd.android-dir/mms-sms");
                a(paramString2);
                return true;
              }
              if (!paramString1.startsWith("mqqapi://tenpay/pay?")) {
                break;
              }
              i = getRequestCode((byte)3);
            } while ((i == -1) || (this.b));
            this.b = true;
            paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
          } while (paramString1 == null);
          paramString1.a("webview");
          paramString1.a("k_requestcode", String.valueOf(i));
          paramString1.b();
          this.jdField_a_of_type_Boolean = true;
          this.b = false;
          return true;
          if ((!QRUtils.a(paramString1)) && (!paramString1.startsWith("mqqopensdkapi:"))) {
            break;
          }
          paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
        } while (paramString1 == null);
        paramString1.a("webview");
        paramString1.b();
        return true;
        if (paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/"))
        {
          String str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
          if (!TextUtils.isEmpty(str))
          {
            paramString2 = Share.a(paramString1, new String[0]);
            paramString1 = paramString2;
            if (paramString2.length() > 512) {
              paramString1 = paramString2.substring(0, 512);
            }
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview_jump", "http_jumpaction", 0, 1, 0, Share.a(str, new String[0]), paramString1, "", "");
          }
          return false;
        }
        if (paramString1.startsWith("mqqapi://"))
        {
          paramString2 = new Intent(this.mRuntime.a(), JumpActivity.class);
          paramString2.setData(Uri.parse(paramString1));
          paramString2.putExtra("from", "webview");
          a(paramString2);
          return true;
        }
        if (!paramString1.startsWith("qb")) {
          break;
        }
      } while (a(paramString1, false));
      paramString1 = MttLoader.a(this.mRuntime.a(), paramString1);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString1);
      return true;
      if ((paramString1.startsWith("mqqflyticket://")) || (QRUtils.b(paramString1)))
      {
        a(paramString1);
        return true;
      }
    } while (MttApi.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, paramString1));
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 3)
    {
      if (paramInt != -1) {
        break label107;
      }
      if ((this.jdField_a_of_type_Boolean) && (paramIntent != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
      {
        str = paramIntent.getStringExtra("callback_type");
        if (!"javascript".equals(str)) {
          break label79;
        }
        callJs(paramIntent.getStringExtra("callback_name"), new String[] { paramIntent.getStringExtra("callback_data") });
      }
    }
    label79:
    label107:
    while (paramInt != 0)
    {
      String str;
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        return;
        if ("url".equals(str)) {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramIntent.getStringExtra("callback_url"));
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onCreate()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
    if ((this.mRuntime.a() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.mRuntime.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin
 * JD-Core Version:    0.7.0.1
 */