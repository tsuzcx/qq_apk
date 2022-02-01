package oicq.wlogin_sdk.quicklogin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import oicq.wlogin_sdk.tools.util;

final class c
  extends WebViewClient
{
  c(Activity paramActivity, WebView paramWebView, String paramString) {}
  
  private boolean a(SslCertificate paramSslCertificate)
  {
    paramSslCertificate = SslCertificate.saveState(paramSslCertificate).getByteArray("x509-certificate");
    if (paramSslCertificate != null) {}
    try
    {
      paramSslCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramSslCertificate));
      boolean bool = Arrays.equals(MessageDigest.getInstance("SHA-256").digest(((X509Certificate)paramSslCertificate).getEncoded()), new byte[] { 51, -65, -44, 0, 73, 7, 89, -98, 112, -76, -112, -125, 58, 25, -96, -8, -40, -51, 57, -89, -92, -47, 9, -16, -108, 34, -93, -30, -1, -123, -89, -98 });
      return bool;
    }
    catch (Exception paramSslCertificate)
    {
      label242:
      break label242;
    }
    return false;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (17 <= Build.VERSION.SDK_INT) {
      this.b.loadUrl(this.c);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    try
    {
      paramWebView = new StringBuilder();
      paramWebView.append("ssl error ");
      paramWebView.append(paramSslError.getUrl());
      paramWebView.append(":");
      paramWebView.append(paramSslError.getPrimaryError());
      util.LOGI(paramWebView.toString());
      if (true == QuickLoginWebViewLoader.sslErrorProcessed)
      {
        paramSslErrorHandler.proceed();
        return;
      }
      if (((paramSslError.getPrimaryError() == 4) || (paramSslError.getPrimaryError() == 1) || (paramSslError.getPrimaryError() == 5) || (paramSslError.getPrimaryError() == 3)) && (paramSslError.getUrl().startsWith("https://xui.ptlogin2.qq.com")) && (a(paramSslError.getCertificate())))
      {
        paramSslErrorHandler.proceed();
        QuickLoginWebViewLoader.sslErrorProcessed = true;
        return;
      }
      paramWebView = new AlertDialog.Builder(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("页面证书错误(");
      localStringBuilder.append(paramSslError.getPrimaryError());
      localStringBuilder.append(")，是否继续？");
      paramWebView.setMessage(localStringBuilder.toString());
      paramWebView.setPositiveButton("继续", new d(this, paramSslErrorHandler));
      paramWebView.setNegativeButton("取消", new e(this, paramSslErrorHandler));
      paramWebView.setOnCancelListener(new f(this, paramSslErrorHandler));
      paramWebView = paramWebView.create();
    }
    catch (Error paramWebView)
    {
      for (;;)
      {
        try
        {
          paramWebView.show();
          return;
        }
        catch (Exception paramWebView) {}
        paramWebView = paramWebView;
      }
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString != null) {
      try
      {
        paramWebView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
        return true;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load url ");
        paramWebView = paramString;
        if (paramString == null) {
          paramWebView = "";
        }
        localStringBuilder.append(paramWebView);
        localStringBuilder.append(" failed ");
        localStringBuilder.append(localException.getMessage());
        util.LOGI(localStringBuilder.toString(), "");
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.c
 * JD-Core Version:    0.7.0.1
 */