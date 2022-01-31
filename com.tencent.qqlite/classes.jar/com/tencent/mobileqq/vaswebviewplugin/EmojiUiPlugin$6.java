package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiUiPlugin$6
  implements Runnable
{
  EmojiUiPlugin$6(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void run()
  {
    this.this$0.progressDialog = new QQProgressDialog(this.this$0.mRuntime.a(), ((QQBrowserActivity)this.this$0.mRuntime.a()).getTitleBarHeight());
    this.this$0.progressDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.6
 * JD-Core Version:    0.7.0.1
 */