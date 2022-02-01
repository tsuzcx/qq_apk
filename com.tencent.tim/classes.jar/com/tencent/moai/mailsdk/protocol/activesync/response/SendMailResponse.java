package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import org.w3c.dom.Node;

public class SendMailResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  
  public SendMailResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public int getErrorCode()
  {
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public boolean isOk()
  {
    if (this.commonStatus != null) {
      return this.commonStatus.isStatusOk();
    }
    return super.isOk();
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return false;
          } while (!this.httpResponse.isOk());
          if (this.httpResponse.getContent() == null) {
            return true;
          }
          if (this.httpResponse.getContent().length == 0) {
            return true;
          }
          localObject = XmlDocumentHelper.bytes2XmlDoc(this.httpResponse.getContent());
        } while (localObject == null);
        localObject = XmlDocumentHelper.getChildNode((Node)localObject, "SendMail");
      } while (localObject == null);
      this.commonStatus = new CommonStatus(XmlDocumentHelper.getChildIntContent((Node)localObject, "Status"));
    } while (!this.commonStatus.isStatusOk());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.SendMailResponse
 * JD-Core Version:    0.7.0.1
 */