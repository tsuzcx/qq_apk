package com.tencent.qqmail.view;

import android.app.Activity;
import android.webkit.WebView;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.popularize.JSApiUitil.JSAPIDelegate;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAdvertiseView$1$1
  implements JSApiUitil.JSAPIDelegate
{
  QMAdvertiseView$1$1(QMAdvertiseView.1 param1, WebView paramWebView) {}
  
  public void doTask(String paramString1, String paramString2, String paramString3)
  {
    QMLog.log(4, "QMAdvertiseView", "doTask func = " + paramString1);
    if ((paramString1 != null) && (paramString3 != null))
    {
      if (!paramString1.equals("shareToFriend")) {
        break label54;
      }
      this.this$1.this$0.handleShareToFriend(paramString2);
    }
    label54:
    do
    {
      do
      {
        return;
        if (!paramString1.equals("closeWebView")) {
          break;
        }
      } while (QMAdvertiseView.access$000(this.this$1.this$0));
      JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleCloseWebView(paramString3));
      QMAdvertiseView.access$100(this.this$1.this$0).onBackPressed();
      return;
      if (paramString1.equals("getEmail"))
      {
        JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetEmail(paramString3));
        return;
      }
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
        JSApiUitil.excuteJavaScript(QMAdvertiseView.access$200(this.this$1.this$0), JSApiUitil.handleGetSid(paramString3));
        return;
      }
    } while (!paramString1.equals("getAppVersion"));
    JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetAppVersion(paramString3));
  }
  
  public void executeJavaScript(String paramString)
  {
    JSApiUitil.excuteJavaScript(QMAdvertiseView.access$200(this.this$1.this$0), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMAdvertiseView.1.1
 * JD-Core Version:    0.7.0.1
 */