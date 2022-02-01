package com.tencent.qqmail.activity.readmail;

import android.webkit.WebView;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.popularize.JSApiUitil.JSAPIDelegate;
import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$118$1
  implements JSApiUitil.JSAPIDelegate
{
  ReadMailFragment$118$1(ReadMailFragment.118 param118, WebView paramWebView) {}
  
  public void doTask(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString3 != null) && (paramString1.equals("getSid"))) {
      JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetSid(paramString3));
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
                if ((paramString1 != null) && (paramString3 != null) && (paramString1.equals("getAppVersion")))
                {
                  JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetAppVersion(paramString3));
                  return;
                }
                if ((paramString1 != null) && (paramString3 != null) && (paramString1.equals("getSystemVersion")))
                {
                  JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGetSystemVersion(paramString3));
                  return;
                }
                if ((paramString1 != null) && (paramString3 != null) && (paramString1.equals("appInstallJudge")) && (paramString2 != null))
                {
                  JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleApppInstallJudge(paramString2, paramString3));
                  return;
                }
                if ((paramString1 != null) && (paramString3 != null) && (paramString1.equals("goToUrl")) && (paramString2 != null))
                {
                  JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleGoToUrl(this.this$1.this$0.getActivity(), paramString2, paramString3));
                  return;
                }
              } while ((paramString1 != null) && (paramString3 != null) && (paramString1.equals("moreOperation")) && (paramString2 != null));
              if ((paramString1 == null) || (!paramString1.equals("refreshToken"))) {
                break;
              }
            } while (this.this$1.this$0.refreshTokenTimes >= this.this$1.this$0.MAX_REFRESH_TOKEN_TIME);
            paramString1 = this.this$1.this$0;
            paramString1.refreshTokenTimes += 1;
            this.this$1.this$0.refreshTokenCallbackId = paramString3;
            JSApiUitil.handleRefreshToken(paramString3, new ReadMailFragment.118.1.1(this));
            return;
            if ((paramString1 == null) || (!paramString1.equals("refreshTokenWithUin")) || (paramString2 == null)) {
              break;
            }
          } while (this.this$1.this$0.refreshTokenTimes >= this.this$1.this$0.MAX_REFRESH_TOKEN_TIME);
          paramString1 = this.this$1.this$0;
          paramString1.refreshTokenTimes += 1;
          this.this$1.this$0.refreshTokenCallbackId = paramString3;
          JSApiUitil.handleRefreshTokenWithUin(paramString2, paramString3, new ReadMailFragment.118.1.2(this));
          return;
          if ((paramString1 == null) || (!paramString1.equals("refreshSkey")) || (paramString2 == null)) {
            break;
          }
        } while (this.this$1.this$0.refreshSkeyTime >= this.this$1.this$0.MAX_REFRESH_SKEY_TIME);
        paramString1 = this.this$1.this$0;
        paramString1.refreshSkeyTime += 1;
        this.this$1.this$0.refreshSkeyCallbackId = paramString3;
        JSApiUitil.handleRefreshSkey(paramString2, paramString3, new ReadMailFragment.118.1.3(this));
        return;
        if ((paramString1 != null) && (paramString1.equals("shareToWechatTimeLine")) && (paramString2 != null))
        {
          JSApiUitil.handleShareToWx(this.this$1.this$0.getActivity(), 1, paramString2, paramString3, 5, new ReadMailFragment.118.1.4(this));
          return;
        }
        if ((paramString1 != null) && (paramString1.equals("shareToWechatFriend")) && (paramString2 != null))
        {
          JSApiUitil.handleShareToWx(this.this$1.this$0.getActivity(), 0, paramString2, paramString3, 5, new ReadMailFragment.118.1.5(this));
          return;
        }
        if ((paramString1 != null) && (paramString1.equals("copyLink")) && (paramString2 != null))
        {
          JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleCopyLink(this.this$1.this$0.getActivity(), paramString2, paramString3));
          return;
        }
        if ((paramString1 != null) && (paramString1.equals("openWithSafari")) && (paramString2 != null))
        {
          JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleOpenWithSafari(this.this$1.this$0.getActivity(), paramString2, paramString3));
          return;
        }
        if ((paramString1 != null) && (paramString1.equals("sendmail")) && (paramString2 != null))
        {
          JSApiUitil.handleSendMail(this.this$1.this$0.getActivity(), paramString2, paramString3, "", new ReadMailFragment.118.1.6(this));
          return;
        }
        if ((paramString1 != null) && (paramString1.equals("localLog")) && (paramString2 != null))
        {
          QMLog.log(4, "ReadMailFragment", paramString2);
          JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleLocalLog(paramString3));
          return;
        }
        if ((paramString1 != null) && (paramString1.equals("closeWebView")))
        {
          this.this$1.this$0.onButtonBackClick();
          JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.handleCloseWebView(paramString3));
          return;
        }
        if ((paramString1 != null) && (paramString1.equals("openInWechatWebView")) && (paramString2 != null))
        {
          JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.openInWechatWebView(this.this$1.this$0.getActivity(), paramString2, paramString3));
          return;
        }
        if ((paramString1 != null) && (paramString1.equals("getNetState")))
        {
          JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.getNetState(paramString3));
          return;
        }
        if ((paramString1 == null) || (!paramString1.equals("getAddressBookContacts"))) {
          break;
        }
      } while (!this.this$1.this$0.isAttachedToActivity());
      paramString1 = ContactsFragmentActivity.createIntentToSelectContact();
      this.this$1.this$0.startActivityForResult(paramString1, 106);
      this.this$1.this$0.selectContactsCallbackId = paramString3;
      return;
    } while ((paramString1 == null) || (!paramString1.equals("getDeviceId")));
    JSApiUitil.excuteJavaScript(this.val$view, JSApiUitil.getDeviceId(paramString3));
  }
  
  public void executeJavaScript(String paramString)
  {
    JSApiUitil.excuteJavaScript(this.val$view, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.118.1
 * JD-Core Version:    0.7.0.1
 */