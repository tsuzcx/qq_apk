package com.tencent.mobileqq.jsp;

import acfp;
import aild;
import android.app.ProgressDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;

public class UiApiPlugin$28$2
  implements Runnable
{
  public UiApiPlugin$28$2(aild paramaild) {}
  
  public void run()
  {
    this.a.this$0.d.dismiss();
    QQToast.a(this.a.this$0.mRuntime.a().getApplication(), 1, acfp.m(2131716193), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.28.2
 * JD-Core Version:    0.7.0.1
 */