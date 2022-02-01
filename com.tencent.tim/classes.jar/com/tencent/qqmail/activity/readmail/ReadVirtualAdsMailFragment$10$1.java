package com.tencent.qqmail.activity.readmail;

import android.webkit.WebView;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.popularize.JSApiUitil.JSAPIDelegate;
import com.tencent.qqmail.utilities.log.QMLog;

class ReadVirtualAdsMailFragment$10$1
  implements JSApiUitil.JSAPIDelegate
{
  ReadVirtualAdsMailFragment$10$1(ReadVirtualAdsMailFragment.10 param10, WebView paramWebView) {}
  
  public void doTask(String paramString1, String paramString2, String paramString3)
  {
    QMLog.log(4, ReadVirtualAdsMailFragment.TAG, "doTask func = " + paramString1);
    if ((paramString1 != null) && (paramString3 != null))
    {
      if (!paramString1.equals("getEmail")) {
        break label55;
      }
      JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetEmail(paramString3));
    }
    label55:
    do
    {
      return;
      if (paramString1.equals("getNick"))
      {
        JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetNick(paramString3));
        return;
      }
      if (paramString1.equals("getSystemVersion"))
      {
        JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetSystemVersion(paramString3));
        return;
      }
      if (paramString1.equals("getUin"))
      {
        JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetUin(paramString3));
        return;
      }
      if (paramString1.equals("getSid"))
      {
        JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetSid(paramString3));
        return;
      }
    } while (!paramString1.equals("getAppVersion"));
    JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetAppVersion(paramString3));
  }
  
  public void executeJavaScript(String paramString)
  {
    JSApiUitil.excuteJavaScript(ReadVirtualAdsMailFragment.access$1200(this.this$1.this$0), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.10.1
 * JD-Core Version:    0.7.0.1
 */