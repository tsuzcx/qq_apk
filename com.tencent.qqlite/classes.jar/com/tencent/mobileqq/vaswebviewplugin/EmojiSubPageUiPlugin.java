package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;

public class EmojiSubPageUiPlugin
  extends EmojiUiPlugin
{
  public void OnActivityCreate()
  {
    this.mActivityType = 2;
    super.OnActivityCreate();
  }
  
  public void OnActivityPause()
  {
    super.OnActivityPause();
    this.mRuntime.a().loadUrl("javascript:var webviewEvent = document.createEvent('Events');webviewEvent.initEvent('webviewobserve');webviewEvent.name = 'stopAudio';document.dispatchEvent(webviewEvent);");
  }
  
  protected long getPluginBusiness()
  {
    return 8L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiSubPageUiPlugin
 * JD-Core Version:    0.7.0.1
 */