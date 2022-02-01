package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qqmail.view.QMWebView;

class WebViewExplorer$13
  implements View.OnLayoutChangeListener
{
  WebViewExplorer$13(WebViewExplorer paramWebViewExplorer) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 > paramInt4) && (paramInt7 == paramInt3) && (!this.this$0.isWebViewHasPassword) && (this.this$0.fromReadMail))
    {
      WebViewExplorer.access$500(this.this$0, this.this$0.mWebView.getUrl());
      this.this$0.isInnerEditTextFocus = true;
      this.this$0.isWebViewSafeBarCloseClick = false;
      WebViewExplorer.access$600(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.13
 * JD-Core Version:    0.7.0.1
 */