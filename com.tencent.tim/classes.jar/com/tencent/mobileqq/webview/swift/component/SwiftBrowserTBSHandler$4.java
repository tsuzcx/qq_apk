package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import arcb;
import aryr;
import aryv;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class SwiftBrowserTBSHandler$4
  implements Runnable
{
  public SwiftBrowserTBSHandler$4(arcb paramarcb, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.this$0.aT(MsfSdkUtils.insertMtype("Web", this.this$0.czu), 0);
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_SNG_APPID, this.val$appid);
    localBundle.putString(aryv.PARAM_URL, this.this$0.czu);
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 2);
    localBundle.putString(aryv.PARAM_APPNAME, this.czy);
    localBundle.putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, false);
    localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
    localBundle.putString(aryv.PARAM_NOTIFYKEY, "_" + this.val$appid);
    aryr.d(this.this$0.a, localBundle, "biz_src_yyb", null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.4
 * JD-Core Version:    0.7.0.1
 */