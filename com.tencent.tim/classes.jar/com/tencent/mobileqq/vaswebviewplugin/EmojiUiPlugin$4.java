package com.tencent.mobileqq.vaswebviewplugin;

import arhz;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

class EmojiUiPlugin$4
  implements Runnable
{
  EmojiUiPlugin$4(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void run()
  {
    this.this$0.progressDialog = new arhz(this.this$0.mRuntime.getActivity(), ((QQBrowserActivity)this.this$0.mRuntime.getActivity()).getTitleBarHeight());
    this.this$0.progressDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.4
 * JD-Core Version:    0.7.0.1
 */