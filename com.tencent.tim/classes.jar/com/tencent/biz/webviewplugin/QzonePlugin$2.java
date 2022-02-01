package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import ardm.o;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.smtt.sdk.WebView;
import suw;

public class QzonePlugin$2
  implements Runnable
{
  public QzonePlugin$2(suw paramsuw) {}
  
  public void run()
  {
    if (suw.a(this.this$0) != null)
    {
      Object localObject = suw.a(this.this$0);
      if (this.this$0.mRuntime.getActivity().getIntent().getExtras().getString("url") != null) {
        localObject = this.this$0.mRuntime.getActivity().getIntent().getExtras().getString("url");
      }
      suw.a(this.this$0).loadData(new String((String)localObject).replaceAll("#", "%23").replaceAll("%", "%25").replaceAll("'", "%27"), "text/html", "utf-8");
      localObject = this.this$0.mRuntime.a(this.this$0.mRuntime.getActivity());
      if ((localObject != null) && ((localObject instanceof ardm.o))) {
        ((ardm.o)localObject).ff(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin.2
 * JD-Core Version:    0.7.0.1
 */