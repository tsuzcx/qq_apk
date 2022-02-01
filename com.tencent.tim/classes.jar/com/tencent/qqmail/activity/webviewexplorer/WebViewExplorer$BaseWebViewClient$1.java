package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.popularize.JSApiUitil.JSAPIDelegate;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

class WebViewExplorer$BaseWebViewClient$1
  implements JSApiUitil.JSAPIDelegate
{
  WebViewExplorer$BaseWebViewClient$1(WebViewExplorer.BaseWebViewClient paramBaseWebViewClient) {}
  
  public void doTask(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null)
    {
      if (paramString1.equals("getSid")) {
        JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleGetSid(paramString3));
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (paramString1.equals("getAppVersion"))
                  {
                    JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleGetAppVersion(paramString3));
                    return;
                  }
                  if (paramString1.equals("getSystemVersion"))
                  {
                    JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleGetSystemVersion(paramString3));
                    return;
                  }
                  if ((paramString1.equals("appInstallJudge")) && (paramString2 != null))
                  {
                    JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleApppInstallJudge(paramString2, paramString3));
                    return;
                  }
                  if ((paramString1.equals("goToUrl")) && (paramString2 != null))
                  {
                    JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleGoToUrl(this.this$1.this$0, paramString2, paramString3));
                    return;
                  }
                  if ((!paramString1.equals("moreOperation")) || (paramString2 == null)) {
                    break;
                  }
                  this.this$1.this$0.popularizeMoreOperations = JSApiUitil.handleMoreOperation(paramString2);
                } while ((this.this$1.this$0.popularizeMoreOperations == null) || (this.this$1.this$0.popularizeMoreOperations.size() <= 0) || (this.this$1.this$0.topBar == null) || (this.this$1.this$0.topBar.getButtonRight() == null));
                this.this$1.this$0.topBar.getButtonRight().setEnabled(true);
                return;
                if (!paramString1.equals("refreshToken")) {
                  break;
                }
              } while (this.this$1.this$0.refreshTokenTimes >= this.this$1.this$0.MAX_REFRESH_TOKEN_TIME);
              paramString1 = this.this$1.this$0;
              paramString1.refreshTokenTimes += 1;
              this.this$1.this$0.refreshTokenCallbackId = paramString3;
              this.this$1.this$0.isRefreshReLoad = true;
              JSApiUitil.handleRefreshToken(paramString3, new WebViewExplorer.BaseWebViewClient.1.1(this));
              return;
              if ((!paramString1.equals("refreshTokenWithUin")) || (paramString2 == null)) {
                break;
              }
            } while (this.this$1.this$0.refreshTokenTimes >= this.this$1.this$0.MAX_REFRESH_TOKEN_TIME);
            paramString1 = this.this$1.this$0;
            paramString1.refreshTokenTimes += 1;
            this.this$1.this$0.refreshTokenCallbackId = paramString3;
            this.this$1.this$0.isRefreshReLoad = true;
            JSApiUitil.handleRefreshTokenWithUin(paramString2, paramString3, new WebViewExplorer.BaseWebViewClient.1.2(this));
            return;
            if ((!paramString1.equals("refreshSkey")) || (paramString2 == null)) {
              break;
            }
          } while (this.this$1.this$0.refreshSKeyTime >= this.this$1.this$0.MAX_REFRESH_SKEY_TIME);
          paramString1 = this.this$1.this$0;
          paramString1.refreshSKeyTime += 1;
          this.this$1.this$0.refreshSKeyCallbackId = paramString3;
          this.this$1.this$0.isRefreshReLoad = JSApiUitil.handleRefreshSkey(paramString2, paramString3, new WebViewExplorer.BaseWebViewClient.1.3(this));
          return;
          if ((paramString1.equals("shareToWechatTimeLine")) && (paramString2 != null))
          {
            JSApiUitil.handleShareToWx(this.this$1.this$0, 1, paramString2, paramString3, 5, new WebViewExplorer.BaseWebViewClient.1.4(this));
            return;
          }
          if ((paramString1.equals("shareToWechatFriend")) && (paramString2 != null))
          {
            JSApiUitil.handleShareToWx(this.this$1.this$0, 0, paramString2, paramString3, 5, new WebViewExplorer.BaseWebViewClient.1.5(this));
            return;
          }
          if ((paramString1.equals("copyLink")) && (paramString2 != null))
          {
            JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleCopyLink(this.this$1.this$0, paramString2, paramString3));
            return;
          }
          if ((paramString1.equals("openWithSafari")) && (paramString2 != null))
          {
            JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleOpenWithSafari(this.this$1.this$0, paramString2, paramString3));
            return;
          }
          if ((paramString1.equals("sendmail")) && (paramString2 != null))
          {
            JSApiUitil.handleSendMail(this.this$1.this$0, paramString2, paramString3, this.this$1.this$0.url, new WebViewExplorer.BaseWebViewClient.1.6(this));
            return;
          }
          if ((paramString1.equals("localLog")) && (paramString2 != null))
          {
            QMLog.log(4, "WebViewExplorer", paramString2);
            JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleLocalLog(paramString3));
            return;
          }
          if (paramString1.equals("closeWebView"))
          {
            JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleCloseWebView(paramString3));
            this.this$1.this$0.finish();
            return;
          }
          if ((paramString1.equals("openInWechatWebView")) && (paramString2 != null))
          {
            JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.openInWechatWebView(this.this$1.this$0.getActivity(), paramString2, paramString3));
            return;
          }
          if (paramString1.equals("getNetState"))
          {
            JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.getNetState(paramString3));
            return;
          }
          if (paramString1.equals("getAddressBookContacts"))
          {
            paramString1 = ContactsFragmentActivity.createIntentToSelectContact();
            this.this$1.this$0.startActivityForResult(paramString1, 109);
            this.this$1.this$0.selectContactsCallbackId = paramString3;
            return;
          }
          if (paramString1.equals("getDeviceId"))
          {
            JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.getDeviceId(paramString3));
            return;
          }
          if ((!paramString1.equals("showOptionMenu")) || (paramString2 == null)) {
            break;
          }
          paramString1 = this.this$1.this$0.topBar.getButtonRight();
        } while (paramString1 == null);
        JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleShowOptionMenu(paramString2, paramString1, paramString3));
        return;
        if (paramString1.equals("getUin"))
        {
          JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleGetUin(paramString3));
          return;
        }
        if (paramString1.equals("getEmail"))
        {
          JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleGetEmail(paramString3));
          return;
        }
      } while (!paramString1.equals("getNick"));
      JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleGetNick(paramString3));
      return;
    }
    QMLog.log(6, "WebViewExplorer", "handleJSRequest error doTask callbackId:" + paramString3 + ", params:" + paramString2);
  }
  
  public void executeJavaScript(String paramString)
  {
    JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.BaseWebViewClient.1
 * JD-Core Version:    0.7.0.1
 */