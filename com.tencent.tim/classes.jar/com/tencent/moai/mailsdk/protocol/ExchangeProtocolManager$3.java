package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpCallBack;
import com.tencent.moai.mailsdk.net.http.HttpRequest;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.ItemCreateResponse;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;

class ExchangeProtocolManager$3
  implements HttpCallBack
{
  ExchangeProtocolManager$3(ExchangeProtocolManager paramExchangeProtocolManager, SendMailCallBack paramSendMailCallBack, Mail paramMail, String paramString) {}
  
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
    paramHttpRequest = new ItemCreateResponse("CreateItem", paramHttpResponse);
    paramHttpRequest.parseResponse();
    Logger.log(4, "ExchangeProtocolManager", "send mail error:7:");
    int i = paramHttpRequest.getHttpCode();
    if (this.val$sendMailCallBack != null)
    {
      if (i == 401) {
        this.val$sendMailCallBack.onError(4, 200001, "send mail auth error:" + this.val$mail.getSubject());
      }
    }
    else {
      return;
    }
    this.val$sendMailCallBack.onError(7, 200001, "send mail " + this.val$mail.getSubject() + " error: " + paramHttpRequest.getResponseCode());
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
    paramHttpRequest = new ItemCreateResponse("CreateItem", paramHttpResponse);
    paramHttpRequest.parseResponse();
    if ("NoError".equalsIgnoreCase(paramHttpRequest.getResponseCode()))
    {
      Logger.log(4, "ExchangeProtocolManager", "send mail success:" + this.val$mail.getSubject());
      if (this.val$sendMailCallBack != null) {
        this.val$sendMailCallBack.onSendSuccess(this.val$mail);
      }
    }
    do
    {
      return;
      Logger.log(4, "ExchangeProtocolManager", "send mail error:7:");
    } while (this.val$sendMailCallBack == null);
    this.val$sendMailCallBack.onError(7, 200001, "send mail error:" + this.val$mail.getSubject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager.3
 * JD-Core Version:    0.7.0.1
 */