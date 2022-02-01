package com.tencent.mobileqq.vaswebviewplugin;

import aqha;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import mqq.app.QQPermissionCallback;

class QWalletCommonJsPlugin$6
  implements QQPermissionCallback
{
  QWalletCommonJsPlugin$6(QWalletCommonJsPlugin paramQWalletCommonJsPlugin) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.this$0.mRuntime.getActivity(), paramArrayOfString, paramArrayOfInt);
    this.this$0.callJs(QWalletCommonJsPlugin.access$200(this.this$0), new String[] { "{'result':-1, 'msg': 'no permission to read contact number'}" });
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new QWalletCommonJsPlugin.SelectContactTask(this.this$0).execute(new String[] { this.this$0.mContactId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */