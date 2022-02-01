package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.moai.nativepages.model.AdLandingPageComponentH5Info;

public class AdLandingPageH5
  extends AdLandingPageBaseComp
{
  private WebView mWebView;
  private FrameLayout webViewContainer;
  
  public AdLandingPageH5(Context paramContext, AdLandingPageComponentH5Info paramAdLandingPageComponentH5Info, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentH5Info, paramViewGroup);
  }
  
  public View createView()
  {
    this.mWebView = new WebView(this.context);
    this.webViewContainer = ((FrameLayout)this.contentView);
    this.webViewContainer.addView(this.mWebView);
    return this.webViewContainer;
  }
  
  protected View customLayout()
  {
    return new FrameLayout(this.context);
  }
  
  protected void fillItem()
  {
    WindowManager localWindowManager = (WindowManager)this.context.getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    this.mWebView.setVerticalScrollBarEnabled(false);
    this.mWebView.setHorizontalScrollBarEnabled(false);
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 11) {
      this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.mWebView.loadUrl(getInfo().h5Url);
    this.mWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.mWebView.setVisibility(0);
    this.webViewContainer.setPadding(this.webViewContainer.getPaddingLeft(), (int)getInfo().paddingTop, this.webViewContainer.getPaddingRight(), (int)getInfo().paddingBottom);
    this.webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(i, j));
  }
  
  public AdLandingPageComponentH5Info getInfo()
  {
    return (AdLandingPageComponentH5Info)this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageH5
 * JD-Core Version:    0.7.0.1
 */