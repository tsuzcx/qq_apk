package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.net.http.HttpCallBack;
import com.tencent.moai.mailsdk.net.http.HttpRequest;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.GetAttachmentResponse;
import com.tencent.moai.mailsdk.util.log.Logger;

class ExchangeProtocolManager$2
  implements HttpCallBack
{
  ExchangeProtocolManager$2(ExchangeProtocolManager paramExchangeProtocolManager, Attachment paramAttachment, AttachmentCallBack paramAttachmentCallBack) {}
  
  public void onBefore(HttpRequest paramHttpRequest) {}
  
  public void onComplete(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse) {}
  
  public void onError(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    paramHttpRequest = new GetAttachmentResponse("GetAttachment", paramHttpResponse);
    paramHttpRequest.setFid(this.val$attachment.getFid());
    paramHttpRequest.setPath(this.val$attachment.getPath());
    paramHttpRequest.setAttachmentCallBack(this.val$attachmentCallBack);
    paramHttpRequest.parseResponse();
    Logger.log(4, "ExchangeProtocolManager", "download attachment error:7:" + this.val$attachment.getPath());
    if (this.val$attachmentCallBack != null) {
      this.val$attachmentCallBack.onError(7, 200001, "download attachment error:" + this.val$attachment.getPath());
    }
  }
  
  public void onPost(long paramLong1, long paramLong2) {}
  
  public void onReceive(long paramLong1, long paramLong2) {}
  
  public void onSuccess(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    paramHttpRequest = new GetAttachmentResponse("GetAttachment", paramHttpResponse);
    paramHttpRequest.setFid(this.val$attachment.getFid());
    paramHttpRequest.setPath(this.val$attachment.getPath());
    paramHttpRequest.setAttachmentCallBack(this.val$attachmentCallBack);
    paramHttpRequest.parseResponse();
    if ("NoError".equalsIgnoreCase(paramHttpRequest.getResponseCode()))
    {
      Logger.log(4, "ExchangeProtocolManager", "download attachment success path:" + this.val$attachment.getPath());
      if (this.val$attachmentCallBack != null) {
        this.val$attachmentCallBack.onSuccess(this.val$attachment.getPath());
      }
    }
    do
    {
      return;
      Logger.log(4, "ExchangeProtocolManager", "download attachment error:7:" + this.val$attachment.getPath());
    } while (this.val$attachmentCallBack == null);
    this.val$attachmentCallBack.onError(7, 200001, "download attachment error:" + this.val$attachment.getPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager.2
 * JD-Core Version:    0.7.0.1
 */