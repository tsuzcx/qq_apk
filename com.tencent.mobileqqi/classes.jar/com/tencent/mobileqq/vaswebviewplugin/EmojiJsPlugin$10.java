package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiJsPlugin$10
  implements Runnable
{
  EmojiJsPlugin$10(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    EmojiJsPlugin.access$002(this.this$0, new QQProgressDialog(this.this$0.mRuntime.a(), ((QQBrowserActivity)this.this$0.mRuntime.a()).d()));
    EmojiJsPlugin.access$000(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */