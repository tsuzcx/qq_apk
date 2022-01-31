package com.tencent.biz.pubaccount;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import nx;

public class CustomWebView
  extends WebView
{
  public static final String a = "webviewLoad";
  public static final String b = CustomWebView.class.getSimpleName();
  static final String c = "((0))";
  static final String d = "((1))";
  static final String e = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);";
  static String f = null;
  private static String g = null;
  CustomWebView.ScrollInterface a;
  protected WebViewPluginEngine a;
  public boolean a;
  
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
    if ((paramString == null) || (paramString.equals(g))) {
      return;
    }
    long l = System.currentTimeMillis();
    g = paramString;
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
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.loadUrl(paramString);
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w(b, 2, QLog.getStackTraceString(new Throwable("func is empty")));
      }
      return;
    }
    Object localObject;
    if (f == null)
    {
      localObject = AuthorizeConfig.a().a("jscallback", null);
      if ((localObject == null) || (!((String)localObject).contains("((0))")) || (!((String)localObject).contains("((1))"))) {
        break label151;
      }
    }
    label151:
    for (f = (String)localObject;; f = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);")
    {
      localObject = new StringBuilder();
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || ("".equals(paramVarArgs[0]))) {
        break;
      }
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      int i = 1;
      int j = paramVarArgs.length;
      while (i < j)
      {
        ((StringBuilder)localObject).append(',').append(paramVarArgs[i]);
        i += 1;
      }
    }
    ((StringBuilder)localObject).append("void(0)");
    c(f.replace("((0))", Util.b(paramString)).replace("((1))", (CharSequence)localObject));
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      try
      {
        super.loadUrl("javascript:" + paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    post(new nx(this, paramString));
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
    b("[" + Util.b(paramString1, new String[0]) + "]" + paramString2);
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((paramString != null) && ((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
        b(Util.b(paramString, new String[0]));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null)
      {
        super.loadUrl(paramString);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.b(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(paramString)));
    super.loadUrl(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView
 * JD-Core Version:    0.7.0.1
 */