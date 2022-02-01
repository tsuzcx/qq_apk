package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.ActiveSyncMailParser;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.ItemOperationStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import org.w3c.dom.Node;

public class ItemOperationsFetchMailResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  private boolean isSearchMail;
  private ItemOperationStatus itemOperationStatus;
  private Mail mail;
  
  public ItemOperationsFetchMailResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public int getErrorCode()
  {
    if (this.itemOperationStatus != null) {
      return this.itemOperationStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.itemOperationStatus != null) {
      return this.itemOperationStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public Mail getMail()
  {
    return this.mail;
  }
  
  public boolean isOk()
  {
    if (this.itemOperationStatus != null) {
      return this.itemOperationStatus.isStatusOk();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.isStatusOk();
    }
    return super.isOk();
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {
      return false;
    }
    if (!this.httpResponse.isOk()) {
      return false;
    }
    if (this.httpResponse.getContent() == null) {
      return true;
    }
    if (this.httpResponse.getContent().length == 0) {
      return true;
    }
    Object localObject = XmlDocumentHelper.bytes2XmlDoc(this.httpResponse.getContent());
    if (localObject == null) {
      return false;
    }
    localObject = XmlDocumentHelper.getChildNode((Node)localObject, "ItemOperations");
    if (localObject == null) {
      return false;
    }
    this.commonStatus = new CommonStatus(XmlDocumentHelper.getChildIntContent((Node)localObject, "Status"));
    if (!this.commonStatus.isStatusOk()) {
      return false;
    }
    localObject = XmlDocumentHelper.getChildNode((Node)localObject, "Response");
    if (localObject == null) {
      return false;
    }
    Node localNode = XmlDocumentHelper.getChildNode((Node)localObject, "Fetch");
    if (localNode == null) {
      return false;
    }
    if (this.isSearchMail) {}
    for (localObject = "search:LongId";; localObject = "airsync:ServerId")
    {
      localObject = XmlDocumentHelper.getChildText(localNode, (String)localObject);
      localNode = XmlDocumentHelper.getChildNode(localNode, "Properties");
      if ((localObject != null) && (localNode != null)) {
        break;
      }
      return false;
    }
    this.mail = ActiveSyncMailParser.getMail(localNode);
    this.mail.setRemoteId((String)localObject);
    return true;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setSearchMail(boolean paramBoolean)
  {
    this.isSearchMail = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.ItemOperationsFetchMailResponse
 * JD-Core Version:    0.7.0.1
 */