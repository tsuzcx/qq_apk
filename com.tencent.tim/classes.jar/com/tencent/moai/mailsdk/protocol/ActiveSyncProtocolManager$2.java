package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpCallBack;
import com.tencent.moai.mailsdk.net.http.HttpRequest;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SendMailResponse;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;

class ActiveSyncProtocolManager$2
  implements HttpCallBack
{
  ActiveSyncProtocolManager$2(ActiveSyncProtocolManager paramActiveSyncProtocolManager, SendMailCallBack paramSendMailCallBack, Mail paramMail, String paramString) {}
  
  public void onBefore(HttpRequest paramHttpRequest)
  {
    if (this.val$sendMailCallBack != null) {
      this.val$sendMailCallBack.onSendBefore(this.val$mail);
    }
  }
  
  public void onComplete(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    try
    {
      FileUtility.deleteFile(this.val$tmpFilePath);
      return;
    }
    catch (IOException paramHttpRequest)
    {
      paramHttpRequest.printStackTrace();
    }
  }
  
  public void onError(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    int i = 4;
    paramHttpRequest = new SendMailResponse("SendMail", "", paramHttpResponse);
    paramHttpRequest.parseResponse();
    Logger.log(4, "ActiveSyncProtocolManager", "send mail error:7:" + paramHttpRequest.getHttpCode() + ":" + paramHttpRequest.getErrorCode() + ":" + paramHttpRequest.getErrorMsg());
    if (this.val$sendMailCallBack != null) {
      if (paramHttpRequest.getHttpCode() != 401) {
        break label108;
      }
    }
    for (;;)
    {
      this.val$sendMailCallBack.onError(i, paramHttpRequest.getErrorCode(), paramHttpRequest.getErrorMsg());
      return;
      label108:
      i = 7;
    }
  }
  
  public void onPost(long paramLong1, long paramLong2)
  {
    if (this.val$sendMailCallBack != null) {
      this.val$sendMailCallBack.onProgress(paramLong1, paramLong2);
    }
  }
  
  public void onReceive(long paramLong1, long paramLong2) {}
  
  public void onSuccess(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    paramHttpRequest = new SendMailResponse("SendMail", "", paramHttpResponse);
    paramHttpRequest.parseResponse();
    if (paramHttpRequest.isOk())
    {
      Logger.log(4, "ActiveSyncProtocolManager", "send mail success:" + this.val$mail.getSubject());
      if (this.val$sendMailCallBack != null) {
        this.val$sendMailCallBack.onSendSuccess(this.val$mail);
      }
    }
    do
    {
      return;
      Logger.log(4, "ActiveSyncProtocolManager", "send mail error:7:" + paramHttpRequest.getErrorCode() + ":" + paramHttpRequest.getErrorMsg());
    } while (this.val$sendMailCallBack == null);
    this.val$sendMailCallBack.onError(7, paramHttpRequest.getErrorCode(), paramHttpRequest.getErrorMsg());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager.2
 * JD-Core Version:    0.7.0.1
 */