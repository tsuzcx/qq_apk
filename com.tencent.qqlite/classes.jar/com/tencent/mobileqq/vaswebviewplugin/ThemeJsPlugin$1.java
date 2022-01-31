package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.utils.NetworkUtil;

class ThemeJsPlugin$1
  implements Runnable
{
  ThemeJsPlugin$1(ThemeJsPlugin paramThemeJsPlugin, String paramString1, int paramInt, String paramString2, long paramLong) {}
  
  public void run()
  {
    int i = NetworkUtil.a(ThemeJsPlugin.access$000(this.this$0));
    Bundle localBundle = new Bundle();
    localBundle.putString("subAction", "theme_mall");
    localBundle.putString("actionName", this.val$actionName);
    localBundle.putInt("result", this.val$actionResult);
    localBundle.putString("r2", this.val$themeId);
    localBundle.putString("r4", "" + i);
    localBundle.putLong("downloadTime", this.val$downloadTime);
    localBundle = DataFactory.makeIPCRequestPacket("reportTheme", "", this.this$0.mOnRemoteResp.key, localBundle);
    this.this$0.sendRemoteReq(localBundle, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */