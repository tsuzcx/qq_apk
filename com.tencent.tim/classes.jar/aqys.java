import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import cooperation.qzone.report.lp.LpReportInfo_dc04171;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class aqys
  extends WebViewPlugin
{
  String YP;
  jnn a;
  boolean cXb = true;
  boolean cXc = true;
  String cyF = null;
  skj mClient;
  
  public aqys()
  {
    this.mPluginNameSpace = "UrlSaveVerifyV2";
  }
  
  private void bBm()
  {
    if (this.a == null)
    {
      CustomWebView localCustomWebView = this.mRuntime.getWebView();
      if (localCustomWebView != null) {
        this.a = new jnn(localCustomWebView, new aqyu(this));
      }
    }
  }
  
  private void egy()
  {
    int m = -1;
    int k = 2;
    int n = 0;
    if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null))
    {
      QLog.e("WebSecurityPluginV2", 1, "reportSoftKeyboardToggled mRuntime empty");
      return;
    }
    Intent localIntent = this.mRuntime.getActivity().getIntent();
    String str3 = "";
    Object localObject = this.mRuntime.getWebView();
    if (localObject != null) {
      str3 = ((CustomWebView)localObject).getOriginalUrl();
    }
    String str4 = "";
    String str5 = "";
    String str6 = "";
    localObject = str4;
    int i = m;
    int j = n;
    String str1 = str5;
    String str2 = str6;
    if (localIntent != null)
    {
      if (!localIntent.getBooleanExtra("fromQrcode", false)) {
        break label245;
      }
      localObject = "mqq.qrcode";
      str2 = str6;
      str1 = str5;
      j = n;
      i = m;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSecurityPluginV2", 1, "reportSoftKeyboardToggled-- referer:" + str3 + " ,url:" + this.YP + " ,msgType:" + i + ",msgFrom:" + j + ",senderUin:" + str1 + ",chatId:" + str2 + ",urlSource:" + (String)localObject);
      }
      LpReportInfo_dc04171.report(this.YP, str3, (String)localObject, i, j, str1, str2);
      return;
      label245:
      if (localIntent.getBooleanExtra("key_isFromQZone", false))
      {
        localObject = "mqq.qzone";
        i = m;
        j = n;
        str1 = str5;
        str2 = str6;
      }
      else
      {
        j = localIntent.getIntExtra("uinType", -1);
        i = j;
        if (j == -1) {
          i = localIntent.getIntExtra("curtype", -1);
        }
        switch (i)
        {
        default: 
          QLog.d("WebSecurityPluginV2", 4, "reportSoftKeyboardToggled:unknow uinType");
          localObject = str4;
          i = m;
          j = n;
          str1 = str5;
          str2 = str6;
          break;
        case 0: 
          localObject = "mqq.c2c";
          str2 = localIntent.getStringExtra("friend_uin");
          str1 = localIntent.getStringExtra("friendUin");
          if (localIntent.getBooleanExtra("is_send", false)) {
            k = 1;
          }
          i = 0;
          j = k;
          break;
        case 1: 
          str2 = localIntent.getStringExtra("groupUin");
          str1 = localIntent.getStringExtra("friendUin");
          if (localIntent.getBooleanExtra("is_send", false)) {}
          for (i = 1;; i = 2)
          {
            j = i;
            localObject = "mqq.group";
            i = 2;
            break;
          }
        case 3000: 
          localObject = "mqq.discussion";
          i = 3;
          str2 = localIntent.getStringExtra("dicussgroup_uin");
          str1 = localIntent.getStringExtra("friendUin");
          if (localIntent.getBooleanExtra("is_send", false)) {
            k = 1;
          }
          j = k;
          break;
        case 1000: 
        case 1001: 
        case 1004: 
        case 1005: 
          str2 = localIntent.getStringExtra("friend_uin");
          str1 = localIntent.getStringExtra("friendUin");
          if (localIntent.getBooleanExtra("is_send", false)) {
            k = 1;
          }
          j = k;
          i = 1;
          localObject = str4;
        }
      }
    }
  }
  
  private boolean rL(String paramString)
  {
    return jml.a().cS(paramString);
  }
  
  private boolean rM(String paramString)
  {
    return jml.a().cT(paramString);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("UrlSaveVerifyV2".equals(paramString2)) && ("continueVisit".equals(paramString3)) && (paramVarArgs.length > 0)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("url");
        if (!TextUtils.isEmpty(paramJsBridgeListener))
        {
          paramString1 = this.mRuntime.getWebView();
          if (paramString1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("WebSecurityPluginV2", 2, "continueVisit url=" + jqo.filterKeyForLog(paramJsBridgeListener, new String[0]));
            }
            this.cyF = paramJsBridgeListener;
            paramString1.loadUrl(paramJsBridgeListener);
            return false;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("WebSecurityPluginV2", 2, "jump url is null");
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        QLog.e("WebSecurityPluginV2", 1, paramJsBridgeListener.toString());
      }
    }
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    int k = -1;
    int i = 2;
    boolean bool3 = true;
    if (("http".equals(paramString2)) || ("https".equals(paramString2)))
    {
      if ((this.mRuntime != null) && (this.mRuntime.getActivity() != null)) {
        break label53;
      }
      QLog.e("WebSecurityPluginV2", 1, "handleSchemaRequest mRuntime empty");
    }
    label53:
    do
    {
      return false;
      bBm();
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString2 != null) && (!paramString2.isLogin()))
      {
        QLog.e("WebSecurityPluginV2", 1, "appRuntime.isLogin() is false!");
        return false;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        QLog.e("WebSecurityPluginV2", 1, "no network");
        return false;
      }
      this.YP = paramString1;
      if (!paramString1.equals(this.cyF)) {
        break;
      }
      this.cyF = null;
    } while (!QLog.isColorLevel());
    QLog.i("WebSecurityPluginV2", 2, "should pass check");
    return false;
    boolean bool2;
    label165:
    label208:
    label217:
    Intent localIntent;
    String str4;
    String str1;
    String str2;
    String str3;
    int j;
    if (this.cXc)
    {
      bool2 = rL(paramString1);
      if (!rM(paramString1))
      {
        bool1 = true;
        this.cXb = bool1;
        this.cXc = false;
        paramString2 = this.mRuntime.b();
        if ((paramString2 != null) && (paramString2.a != null))
        {
          paramString2 = paramString2.a;
          if (bool2) {
            break label467;
          }
          bool1 = true;
          paramString2.cYd = bool1;
        }
        bool1 = true;
        if (!bool1) {
          break label494;
        }
        QLog.i("UrlCheckLog", 1, "now check url=" + jqo.filterKeyForLog(paramString1, new String[0]) + ", async=" + bool2);
        if (this.mClient == null)
        {
          this.mClient = skj.a();
          this.mClient.bzj();
        }
        localIntent = this.mRuntime.getActivity().getIntent();
        str4 = "";
        str1 = "";
        str2 = "";
        str3 = "";
        paramString2 = str1;
        if (localIntent == null) {
          break label624;
        }
        CustomWebView localCustomWebView = this.mRuntime.getWebView();
        paramString2 = str1;
        if (localCustomWebView != null)
        {
          str1 = localCustomWebView.getUrl();
          paramString2 = str1;
          if (TextUtils.isEmpty(str1)) {
            paramString2 = localIntent.getStringExtra("url");
          }
        }
        if (!localIntent.getBooleanExtra("fromQrcode", false)) {
          break label502;
        }
        str1 = "mqq.qrcode";
        i = 0;
        j = k;
        label388:
        this.mClient.a(paramString1, j, i, str2, str3, str1, paramString2, new aqyt(this, paramString1, bool2));
        if (QLog.isColorLevel()) {
          QLog.d("WebSecurityPluginV2", 1, "sendSecurityCheck url=" + paramString1);
        }
        if (bool2) {
          break label806;
        }
      }
    }
    label806:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break label165;
      label467:
      bool1 = false;
      break label208;
      if (!rM(paramString1)) {}
      for (bool1 = true;; bool1 = false)
      {
        this.cXb = bool1;
        bool2 = true;
        break label217;
        label494:
        break;
      }
      label502:
      if (localIntent.getBooleanExtra("key_isFromQZone", false))
      {
        str1 = "mqq.qzone";
        i = 0;
        j = k;
        break label388;
      }
      int m = localIntent.getIntExtra("uinType", -1);
      j = m;
      if (m == -1) {
        j = localIntent.getIntExtra("curtype", -1);
      }
      switch (j)
      {
      default: 
        i = 0;
        j = k;
        str1 = str4;
        break;
      case 0: 
        str1 = "mqq.c2c";
        str3 = localIntent.getStringExtra("friend_uin");
        str2 = localIntent.getStringExtra("friendUin");
        if (localIntent.getBooleanExtra("is_send", false)) {
          i = 1;
        }
        j = 0;
        break;
      case 1: 
        str1 = "mqq.group";
        str3 = localIntent.getStringExtra("groupUin");
        str2 = localIntent.getStringExtra("friendUin");
        if (localIntent.getBooleanExtra("is_send", false)) {}
        for (i = 1;; i = 2)
        {
          j = 2;
          break;
        }
      case 3000: 
        str1 = "mqq.discussion";
        j = 3;
        str3 = localIntent.getStringExtra("dicussgroup_uin");
        str2 = localIntent.getStringExtra("friendUin");
        if (localIntent.getBooleanExtra("is_send", false)) {
          i = 1;
        }
        break;
      case 1000: 
      case 1001: 
      case 1004: 
      case 1005: 
        label624:
        str3 = localIntent.getStringExtra("friend_uin");
        str2 = localIntent.getStringExtra("friendUin");
        if (localIntent.getBooleanExtra("is_send", false)) {
          i = 1;
        }
        j = 1;
        str1 = str4;
        break;
      }
    }
  }
  
  void mf(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSecurityPluginV2", 2, new Object[] { "checkOperationBit ", Long.valueOf(paramLong) });
    }
    CustomWebView localCustomWebView;
    if ((1L & paramLong) != 0L)
    {
      localCustomWebView = this.mRuntime.getWebView();
      if (localCustomWebView == null) {}
    }
    Object localObject1;
    Object localObject3;
    String str;
    Object localObject2;
    do
    {
      do
      {
        try
        {
          if (localCustomWebView.getX5WebViewExtension() != null)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("forbid-input", "*");
            localCustomWebView.getX5WebViewExtension().setFakeLoginParams((Bundle)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("WebSecurityPluginV2", 2, "checkOperationBit success");
            }
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("WebSecurityPluginV2", 2, "initWebviewExtension e:", localThrowable1);
          return;
        }
      } while ((0x4 & paramLong) == 0L);
      localObject3 = this.mRuntime.getActivity().getIntent();
      localObject1 = "";
      str = "";
      localObject2 = this.mRuntime.getWebView();
      if (localObject2 != null) {
        str = ((CustomWebView)localObject2).getUrl();
      }
      if (localObject3 != null) {
        localObject1 = ((Intent)localObject3).getStringExtra("url");
      }
    } while (this.mClient == null);
    try
    {
      localObject3 = arbz.i((String)localObject1);
      ((Bundle)localObject3).putString("uin", this.mRuntime.a().getCurrentAccountUin());
      if (localObject2 != null)
      {
        localObject2 = ((CustomWebView)localObject2).getTitle();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Bundle)localObject3).putString("title", (String)localObject2);
        }
      }
      this.mClient.a(1, str, (String)localObject1, (Bundle)localObject3);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("WebSecurityPluginV2", 1, localThrowable2, new Object[0]);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mClient != null) {
      this.mClient.bzk();
    }
    if (this.a != null) {
      this.a.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqys
 * JD-Core Version:    0.7.0.1
 */