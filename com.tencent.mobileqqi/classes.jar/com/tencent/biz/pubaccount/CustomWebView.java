package com.tencent.biz.pubaccount;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomWebView
  extends WebView
{
  public static final String a = "webviewLoad";
  private static String b = null;
  CustomWebView.ScrollInterface a;
  protected WebViewPluginEngine a;
  protected boolean a;
  
  public CustomWebView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  protected static void b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(b))) {
      return;
    }
    long l = System.currentTimeMillis();
    b = paramString;
    String str = paramString;
    if (paramString.length() > 512) {
      str = paramString.substring(0, 512);
    }
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    paramString = str;
    if (arrayOfStackTraceElement.length > 2) {
      paramString = str + " at " + arrayOfStackTraceElement[2].toString();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("webviewLoad", 4, "cost:" + (System.currentTimeMillis() - l) + " " + paramString);
    }
    StatisticCollector.a(null).a("webviewLoad", paramString);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("code", Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(getUrl(), 10, localHashMap);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.loadUrl(paramString);
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Boolean = true;
    super.destroy();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    b(paramString1);
    super.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    b("[" + Share.a(paramString1, new String[0]) + "]" + paramString2);
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    Object localObject1;
    label298:
    do
    {
      return;
      localObject1 = paramString;
      String str1;
      if (paramString != null) {
        if (!paramString.startsWith("http://"))
        {
          localObject1 = paramString;
          if (!paramString.startsWith("https://")) {}
        }
        else
        {
          str1 = "en";
          switch (LocaleUtil.a(BaseApplicationImpl.getContext()))
          {
          default: 
            if (!paramString.matches("^[^#]*\\?.*(#.*)?")) {
              break;
            }
          }
        }
      }
      for (String str2 = "&";; str2 = "?")
      {
        Object localObject2 = Pattern.compile("(#.*)?$").matcher(paramString);
        localObject1 = paramString;
        if (((Matcher)localObject2).find())
        {
          localObject2 = ((Matcher)localObject2).group(1);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject1 = paramString.replaceAll("(#.*)?$", str2 + "lan=" + str1 + (String)localObject1);
        }
        if ((localObject1 != null) && ((((String)localObject1).startsWith("http")) || (((String)localObject1).startsWith("data:"))) && (!((String)localObject1).contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
          b(Share.a((String)localObject1, new String[0]));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
          break label298;
        }
        super.loadUrl((String)localObject1);
        return;
        str1 = "en";
        break;
        str1 = "ja";
        break;
        str1 = "ko";
        break;
        str1 = "de";
        break;
        str1 = "fr";
        break;
        str1 = "es";
        break;
        str1 = "tw";
        break;
        str1 = "cn";
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.b((String)localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a((String)localObject1)));
    super.loadUrl((String)localObject1);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnCustomScroolChangeListener(CustomWebView.ScrollInterface paramScrollInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface = paramScrollInterface;
  }
  
  public void setPluginEngine(WebViewPluginEngine paramWebViewPluginEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = paramWebViewPluginEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView
 * JD-Core Version:    0.7.0.1
 */