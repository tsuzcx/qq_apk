package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.Map;

public class ChatBackgroundUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ChatBackgroundUiPlugin";
  private Bundle mReqBundle;
  private String uin;
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.mReqBundle = new Bundle();
    this.uin = this.mRuntime.a().getAccount();
    WebViewFragment localWebViewFragment = this.mRuntime.b();
    if (localWebViewFragment != null) {
      localWebViewFragment.mUrl = super.decodeUrl(localWebViewFragment.mUrl);
    }
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 33554432L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin
 * JD-Core Version:    0.7.0.1
 */