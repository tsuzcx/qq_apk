package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.token.global.h;

class ed
  extends WebChromeClient
{
  ed(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    try
    {
      h.a("onJsPrompt message=" + paramString2);
      if ((this.a.shareurl != null) && (this.a.shareurl.contains("mobile_reset_psw_uv_verify")))
      {
        paramWebView = new Intent();
        paramWebView.putExtra("sppkey", paramString2);
        this.a.setResult(-1, paramWebView);
        this.a.finish();
      }
      paramJsPromptResult.cancel();
      return true;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        paramWebView.printStackTrace();
      }
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if ((paramWebView.getUrl() != null) && (paramWebView.getUrl().contains("sec_headline_content")))
    {
      this.a.sharetitle = paramString;
      this.a.shareurl = paramWebView.getUrl();
      this.a.mRightOptionLayout.setVisibility(0);
    }
    do
    {
      return;
      this.a.shareurl = paramWebView.getUrl();
    } while (this.a.alsoShowMenu);
    this.a.mRightOptionLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ed
 * JD-Core Version:    0.7.0.1
 */